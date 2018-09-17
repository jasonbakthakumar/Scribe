package jasonbakthakumar.scribe;

import android.*;
import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.LocaleList;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.i18n.phonenumbers.NumberParseException;
import com.sinch.verification.CodeInterceptionException;
import com.sinch.verification.Config;
import com.sinch.verification.IncorrectCodeException;
import com.sinch.verification.InitiationResult;
import com.sinch.verification.InvalidInputException;
import com.sinch.verification.ServiceErrorException;
import com.sinch.verification.SinchVerification;
import com.sinch.verification.Verification;
import com.sinch.verification.VerificationListener;

import java.util.Arrays;
import java.util.Locale;

import jasonbakthakumar.scribe.DotsAnimation.DotLoader;
import jasonbakthakumar.scribe.Util.CountryCodeUtils;
import jasonbakthakumar.scribe.Util.PhoneNumberVerification;

public class PhoneNumber extends AppCompatActivity {

    private TextInputLayout phoneNumberLayout;
    private EditText phoneNumberEditText;
    private TextInputLayout verificationLayout;
    private EditText verificationEditText;
    private Spinner countrySpinner;
    private DotLoader dotLoader;
    private String countrySelected;
    private FloatingActionButton fab;
    private final String APPLICATION_KEY = "a623b400-a018-4d82-a756-68cf35785208";
    private boolean verifyNeeded = false;
    Verification verification;
    private static final int REQUEST_CONTACTS = 2;
    private static final String FRAGMENT_DIALOG = "dialog";
    public String phn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number);
        phoneNumberEditText = (EditText) findViewById(R.id.phn_edit);
        verificationEditText = (EditText) findViewById(R.id.ver_edit);
        phoneNumberLayout = (TextInputLayout) findViewById(R.id.textInputLayout3);
        verificationLayout = (TextInputLayout) findViewById(R.id.textInputLayout4);
        fab = (FloatingActionButton) findViewById(R.id.floatingActionButton2);
        dotLoader = (DotLoader) findViewById(R.id.textView3);
        countrySpinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.countries, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countrySpinner.setAdapter(adapter);
        if(getUserCountry() != null){
            countrySpinner.setSelection(getStringPosition());
        }




    }

    @Override
    protected void onResume() {
        super.onResume();
        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] countries = getResources().getStringArray(R.array.countries);
                    countrySelected = countries[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                countrySelected = "Please Select your Country";

            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!verifyNeeded) {
                    if (phoneNumberEditText.getText().toString().length() >= 7) {
                        fab.setEnabled(false);
                        phoneNumberLayout.setErrorEnabled(false);
                        dotLoader.setVisibility(View.VISIBLE);
                        try {
                            String phoneNumber = setThePhoneNumber(phoneNumberEditText.getText().toString(), countrySelected);
                            phn = phoneNumber;
                            Config config = SinchVerification.config().applicationKey(APPLICATION_KEY).context(getApplicationContext())
                                    .build();
                            VerificationListener listener = new MyVerificationListener();
                            verification = SinchVerification.createSmsVerification(config, phoneNumber, listener);
                            verification.initiate();

                        } catch (NumberParseException e) {
                            String phoneNumber = phoneNumberEditText.getText().toString();
                            phn = phoneNumber;
                            Config config = SinchVerification.config().applicationKey(APPLICATION_KEY).context(getApplicationContext())
                                    .build();
                            VerificationListener listener = new MyVerificationListener();
                            verification = SinchVerification.createSmsVerification(config, phoneNumber, listener);
                            verification.initiate();


                        }


                    } else {
                        fab.setEnabled(true);
                        phoneNumberLayout.setErrorEnabled(true);
                        phoneNumberLayout.setError("Please enter a valid mobile number");
                        dotLoader.setVisibility(View.INVISIBLE);
                        verificationLayout.setVisibility(View.GONE);
                    }
                }
                else{
                    dotLoader.setVisibility(View.VISIBLE);
                    String code = verificationEditText.getText().toString();
                    verification.verify(code);

                }

            }
        });
    }

    private int getStringPosition() {
        String[] ar = getResources().getStringArray(R.array.countries);
        Locale locale = new Locale("",getUserCountry());
        countrySelected = locale.getDisplayCountry();
        for (String country:ar){
            if(country.equals(countrySelected)){
                return Arrays.asList(ar).indexOf(country);
            }

        }
        return 0;
    }


    private void startContactVerificationFlow() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
                == PackageManager.PERMISSION_GRANTED) {
            startActivity(new Intent(this, MIActivity.class));
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_CONTACTS)) {
                ConfirmationDialogFragment
                        .newInstance(R.string.contact_verification_prompt,
                                new String[]{Manifest.permission.READ_CONTACTS},
                                REQUEST_CONTACTS,
                                R.string.contact_permission_not_granted)
                        .show(getSupportFragmentManager(), FRAGMENT_DIALOG);
            }
            else{
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS},
                        REQUEST_CONTACTS);
            }
        }

    }



    public String getUserCountry() {
        try {
            final TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
            final String simCountry = tm.getSimCountryIso();
            if (simCountry != null && simCountry.length() == 2) { // SIM country code is available
                return simCountry.toUpperCase(Locale.US);
            }
            else if (tm.getPhoneType() != TelephonyManager.PHONE_TYPE_CDMA) { // device is not 3G (would be unreliable)
                String networkCountry = tm.getNetworkCountryIso();
                if (networkCountry != null && networkCountry.length() == 2) { // network country code is available
                    return networkCountry.toUpperCase(Locale.US);
                }
            }
        }
        catch (Exception e) {
            return null;
        }
        return null;
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CONTACTS:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startActivity(new Intent(PhoneNumber.this, MIActivity.class));
                } else {
                    startActivity(new Intent(PhoneNumber.this, MIActivity.class));
                }
                break;

            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                break;

        }


    }

    //The entire code for setting a phone Number..:)
    public String setThePhoneNumber(String phd, String c) throws NumberParseException {

        PhoneNumberVerification p = new PhoneNumberVerification();
        try{
            switch (c) {
                case "Albania":
                    phd = p.setAlbaniaMobileNumber(phd);
                    break;
                case "Algeria":
                    phd = p.setAlgeriaMobileNumber(phd);
                    break;
                case "Angola":
                    phd = p.setAngolaMobileNumber(phd);
                    break;
                case "Antigua and Barbuda":
                    phd = p.setAntigua_and_BarbudaMobileNumber(phd);
                    break;
                case "Argentina":
                    phd = p.setArgentinaMobileNumber(phd);
                    break;
                case "Armenia":
                    phd = p.setArmeniaMobileNumber(phd);
                    break;
                case "Aruba":
                    phd = p.setArubaMobileNumber(phd);
                    break;
                case "Australia":
                    phd = p.setAustraliaMobileNumber(phd);
                    break;
                case "Austria":
                    phd = p.setAustriaMobileNumber(phd);
                    break;
                case "Azerbaijan":
                    phd = p.setAzerbaijanMobileNumber(phd);
                    break;
                case "Bahamas":
                    phd = p.setBahamasMobileNumber(phd);
                    break;
                case "Bahrain":
                    phd = p.setBahrainMobileNumber(phd);
                    break;
                case "Bangladesh":
                    phd = p.setBangladeshMobileNumber(phd);
                    break;
                case "Belarus":
                    phd = p.setBelarusMobileNumber(phd);
                    break;
                case "Belgium":
                    phd = p.setBelgiumMobileNumber(phd);
                    break;
                case "Belize":
                    phd = p.setBelizeMobileNumber(phd);
                    break;
                case "Benin":
                    phd = p.setBeninMobileNumber(phd);
                    break;
                case "Bolivia":
                    phd = p.setBoliviaMobileNumber(phd);
                    break;
                case "Bosnia and Herzegovina":
                    phd = p.setBosnia_and_HerzegovinaMobileNumber(phd);
                    break;
                case "Botswana":
                    phd = p.setBotswanaMobileNumber(phd);
                    break;
                case "Brazil":
                    phd = p.setBrazilMobileNumber(phd);
                    break;
                case "Bulgaria":
                    phd = p.setBulgariaMobileNumber(phd);
                    break;
                case "Burkina":
                    phd = p.setBurkinaMobileNumber(phd);
                    break;
                case "Cambodia":
                    phd = p.setCambodiaMobileNumber(phd);
                    break;
                case "Cameroon":
                    phd = p.setCameroonMobileNumber(phd);
                    break;
                case "Canada":
                    phd = p.setCanadaMobileNumber(phd);
                    break;
                case "Cape Verde":
                    phd = p.setCape_VerdeMobileNumber(phd);
                    break;
                case "Chile":
                    phd = p.setChileMobileNumber(phd);
                    break;
                case "China":
                    phd = p.setChinaMobileNumber(phd);
                    break;
                case "Colombia":
                    phd = p.setColombiaMobileNumber(phd);
                    break;
                case "Costa Rica":
                    phd = p.setCosta_RicaMobileNumber(phd);
                    break;
                case "Croatia":
                    phd = p.setCroatiaMobileNumber(phd);
                    break;
                case "Cyprus":
                    phd = p.setCyprusMobileNumber(phd);
                    break;
                case "Czech Republic":
                    phd = p.setCzech_RepublicMobileNumber(phd);
                    break;
                case "Denmark":
                    phd = p.setDenmarkMobileNumber(phd);
                    break;
                case "Dominican Republic":
                    phd = p.setDominican_RepublicMobileNumber(phd);
                    break;
                case "Ecuador":
                    phd = p.setEcuadorMobileNumber(phd);
                    break;
                case "Egypt":
                    phd = p.setEgyptMobileNumber(phd);
                    break;
                case "El Salvador":
                    phd = p.setEl_SalvadorMobileNumber(phd);
                    break;
                case "Estonia":
                    phd = p.setEstoniaMobileNumber(phd);
                    break;
                case "Fiji":
                    phd = p.setFijiMobileNumber(phd);
                    break;
                case "Finland":
                    phd = p.setFinlandMobileNumber(phd);
                    break;
                case "France":
                    phd = p.setFranceMobileNumber(phd);
                    break;
                case "Gabon":
                    phd = p.setGabonMobileNumber(phd);
                    break;
                case "Germany":
                    phd = p.setGermanyMobileNumber(phd);
                    break;
                case "Ghana":
                    phd = p.setGhanaMobileNumber(phd);
                    break;
                case "Greece":
                    phd = p.setGreeceMobileNumber(phd);
                    break;
                case "Guatemala":
                    phd = p.setGuatemalaMobileNumber(phd);
                    break;
                case "Guinea-Bissau":
                    phd = p.setGuinea_BissauMobileNumber(phd);
                    break;
                case "Haiti":
                    phd = p.setHaitiMobileNumber(phd);
                    break;
                case "Honduras":
                    phd = p.setHondurasMobileNumber(phd);
                    break;
                case "Hong Kong":
                    phd = p.setHong_KongMobileNumber(phd);
                    break;
                case "Hungary":
                    phd = p.setHungaryMobileNumber(phd);
                    break;
                case "Iceland":
                    phd = p.setIcelandMobileNumber(phd);
                    break;
                case "India":
                    phd = p.setIndianMobileNumber(phd);
                    break;
                case "Indonesia":
                    phd = p.setIndonesiaMobileNumber(phd);
                    break;
                case "Ireland":
                    phd = p.setIrelandMobileNumber(phd);
                    break;
                case "Israel":
                    phd = p.setIsraelMobileNumber(phd);
                    break;
                case "Italy":
                    phd = p.setItalyMobileNumber(phd);
                    break;
                case "Ivory Coast":
                    phd = p.setIvory_CoastMobileNumber(phd);
                    break;
                case "Jamaica":
                    phd = p.setJamaicaMobileNumber(phd);
                    break;
                case "Japan":
                    phd = p.setJapanMobileNumber(phd);
                    break;
                case "Jordan":
                    phd = p.setJordanMobileNumber(phd);
                    break;
                case "Kazakhstan":
                    phd = p.setKazakhstanMobileNumber(phd);
                    break;
                case "Kenya":
                    phd = p.setKenyaMobileNumber(phd);
                    break;
                case "Kuwait":
                    phd = p.setKuwaitMobileNumber(phd);
                    break;
                case "Kyrgyzstan":
                    phd = p.setKyrgyzstanMobileNumber(phd);
                    break;
                case "Laos":
                    phd = p.setLaosMobileNumber(phd);
                    break;
                case "Latvia":
                    phd = p.setLatviaMobileNumber(phd);
                    break;
                case "Lebanon":
                    phd = p.setLebanonMobileNumber(phd);
                    break;
                case "Liechtenstein":
                    phd = p.setLiechtensteinMobileNumber(phd);
                    break;
                case "Lithuania":
                    phd = p.setLithuaniaMobileNumber(phd);
                    break;
                case "Luxembourg":
                    phd = p.setLuxembourgMobileNumber(phd);
                    break;
                case "Macedonia":
                    phd = p.setMacedoniaMobileNumber(phd);
                    break;
                case "Malaysia":
                    phd = p.setMalaysiaMobileNumber(phd);
                    break;
                case "Mali":
                    phd = p.setMaliMobileNumber(phd);
                    break;
                case "Malta":
                    phd = p.setMaltaMobileNumber(phd);
                    break;
                case "Mauritius":
                    phd = p.setMauritiusMobileNumber(phd);
                    break;
                case "Mexico":
                    phd = p.setMexicoMobileNumber(phd);
                    break;
                case "Moldova":
                    phd = p.setMoldovaMobileNumber(phd);
                    break;
                case "Morocco":
                    phd = p.setMoroccoMobileNumber(phd);
                    break;
                case "Mozambique":
                    phd = p.setMozambiqueMobileNumber(phd);
                    break;
                case "Namibia":
                    phd = p.setNamibiaMobileNumber(phd);
                    break;
                case "Nepal":
                    phd = p.setNepalMobileNumber(phd);
                    break;
                case "Netherlands":
                    phd = p.setNetherlandsMobileNumber(phd);
                    break;
                case "Netherlands Antilles":
                    phd = p.setNetherlands_AntillesMobileNumber(phd);
                    break;
                case "New Zealand":
                    phd = p.setNew_ZealandMobileNumber(phd);
                    break;
                case "Nicaragua":
                    phd = p.setNicaraguaMobileNumber(phd);
                    break;
                case "Niger":
                    phd = p.setNigerMobileNumber(phd);
                    break;
                case "Nigeria":
                    phd = p.setNigeriaMobileNumber(phd);
                    break;
                case "Norway":
                    phd = p.setNorwayMobileNumber(phd);
                    break;
                case "Oman":
                    phd = p.setOmanMobileNumber(phd);
                    break;
                case "Pakistan":
                    phd = p.setPakistanMobileNumber(phd);
                    break;
                case "Panama":
                    phd = p.setPanamaMobileNumber(phd);
                    break;
                case "Papua New Guinea":
                    phd = p.setPapua_New_GuineaMobileNumber(phd);
                    break;
                case "Paraguay":
                    phd = p.setParaguayMobileNumber(phd);
                    break;
                case "Peru":
                    phd = p.setPeruMobileNumber(phd);
                    break;
                case "Philippines":
                    phd = p.setPhilippinesMobileNumber(phd);
                    break;
                case "Poland":
                    phd = p.setPolandMobileNumber(phd);
                    break;
                case "Portugal":
                    phd = p.setPortugalMobileNumber(phd);
                    break;
                case "Qatar":
                    phd = p.setQatarMobileNumber(phd);
                    break;
                case "Romania":
                    phd = p.setRomaniaMobileNumber(phd);
                    break;
                case "Russia":
                    phd = p.setRussiaMobileNumber(phd);
                    break;
                case "Rwanda":
                    phd = p.setRwandaMobileNumber(phd);
                    break;
                case "Saudi Arabia":
                    phd = p.setSaudi_ArabiaMobileNumber(phd);
                    break;
                case "Senegal":
                    phd = p.setSenegalMobileNumber(phd);
                    break;
                case "Serbia":
                    phd = p.setSerbiaMobileNumber(phd);
                    break;
                case "Singapore":
                    phd = p.setSingaporeMobileNumber(phd);
                    break;
                case "Slovakia":
                    phd = p.setSlovakiaMobileNumber(phd);
                    break;
                case "Slovenia":
                    phd = p.setSloveniaMobileNumber(phd);
                    break;
                case "South Africa":
                    phd = p.setSouth_AfricaMobileNumber(phd);
                    break;
                case "South Korea":
                    phd = p.setSouth_KoreaMobileNumber(phd);
                    break;
                case "Spain":
                    phd = p.setSpainMobileNumber(phd);
                    break;
                case "Sri Lanka":
                    phd = p.setSri_LankaMobileNumber(phd);
                    break;
                case "Sweden":
                    phd = p.setSwedenMobileNumber(phd);
                    break;
                case "Switzerland":
                    phd = p.setSwitzerlandMobileNumber(phd);
                    break;
                case "Taiwan":
                    phd = p.setTaiwanMobileNumber(phd);
                    break;
                case "Tajikistan":
                    phd = p.setTajikistannMobileNumber(phd);
                    break;
                case "Tanzania":
                    phd = p.setTanzaniaMobileNumber(phd);
                    break;
                case "Thailand":
                    phd = p.setThailandMobileNumber(phd);
                    break;
                case "Togo":
                    phd = p.setTogoMobileNumber(phd);
                    break;
                case "Trinidad and Tobago":
                    phd = p.setTrinidad_and_TobagoMobileNumber(phd);
                    break;
                case "Tunisia":
                    phd = p.setTunisiaMobileNumber(phd);
                    break;
                case "Turkey":
                    phd = p.setTurkeyMobileNumber(phd);
                    break;
                case "Turkmenistan":
                    phd = p.setTurkmenistanMobileNumber(phd);
                    break;
                case "Uganda":
                    phd = p.setUgandaMobileNumber(phd);
                    break;
                case "Ukraine":
                    phd = p.setUkraineMobileNumber(phd);
                    break;
                case "United Arab Emirates":
                    phd = p.setUnited_Arab_EmiratesMobileNumber(phd);
                    break;
                case "United Kingdom":
                    phd = p.setUnited_KingdomMobileNumber(phd);
                    break;
                case "United States":
                    phd = p.setUSMobileNumber(phd);
                    break;
                case "Uruguay":
                    phd = p.setUruguayMobileNumber(phd);
                    break;
                case "Uzbekistan":
                    phd = p.setUzbekistanMobileNumber(phd);
                    break;
                case "Venezuela":
                    phd = p.setVenezuelaMobileNumber(phd);
                    break;
                case "Vietnam":
                    phd = p.setVietnamMobileNumber(phd);
                    break;
                case "Yemen":
                    phd = p.setYemenMobileNumber(phd);
                    break;
                case "Zambia":
                    phd = p.setZambiaMobileNumber(phd);
                    break;
                case "Zimbabwe":
                    phd = p.setZimbabweMobileNumber(phd);
                    break;
                case "Please Select your Country":
                    phd = "1234567890";
                    break;
            }
        }

        catch(NumberParseException e){
            e.printStackTrace();
        }


        return phd;
    }



    class MyVerificationListener implements VerificationListener {

        @Override
        public void onInitiated(InitiationResult initiationResult) {

        }

        @Override
        public void onInitiationFailed(Exception exception) {
            fab.setEnabled(true);
            if (exception instanceof InvalidInputException) {
                // Incorrect number provided
                dotLoader.setVisibility(View.INVISIBLE);
                verifyNeeded = false;
                Toast.makeText(getApplicationContext(), "Phone number Provided is wrong", Toast.LENGTH_SHORT).show();
                phoneNumberLayout.setErrorEnabled(true);
                phoneNumberLayout.setError("Enter the correct Phone Number and press next to verify");


            } else if (exception instanceof ServiceErrorException) {
                // Sinch service error
                dotLoader.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_SHORT).show();
                phoneNumberLayout.setErrorEnabled(true);
                phoneNumberLayout.setError(exception.getMessage());
            } else {
                dotLoader.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(), "We seem to have run into an network Problem. Try again", Toast.LENGTH_LONG).show();
                phoneNumberLayout.setErrorEnabled(true);
                phoneNumberLayout.setError("We seem to have run into an network Problem. Try again");
                // Other system error, such as UnknownHostException in case of network error
            }
        }

        @Override
        public void onVerified() {
            //The phone Number has Been Verified
            fab.setEnabled(false);
            dotLoader.setVisibility(View.INVISIBLE);
            verificationLayout.setErrorEnabled(false);
            verificationLayout.setVisibility(View.GONE);
            CountryCodeUtils cdo = new CountryCodeUtils();
            Toast.makeText(getApplicationContext(), "Your phone Number has been verified", Toast.LENGTH_LONG).show();
            SharedPreferences sharedpreferences = getSharedPreferences("REG", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString("phoneNumber",phn);
            editor.putBoolean("done",true);
            editor.putString("defaultCountry",cdo.getTheTwoLetterCode(countrySelected));
            editor.apply();
            startContactVerificationFlow();
        }

        @Override
        public void onVerificationFailed(Exception e) {
            verifyNeeded = true;
            verificationLayout.setVisibility(View.VISIBLE);
            fab.setEnabled(true);
            if (e instanceof InvalidInputException) {
                // Incorrect number or code provided
                dotLoader.setVisibility(View.INVISIBLE);
                verifyNeeded = false;
                Toast.makeText(getApplicationContext(), "Incorrect number or code provided", Toast.LENGTH_LONG).show();
                verificationLayout.setVisibility(View.GONE);
                phoneNumberLayout.setErrorEnabled(false);
                phoneNumberLayout.setError("Please enter a valid phone Number");
            } else if (e instanceof CodeInterceptionException) {
                dotLoader.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(), "Intercepting the verification code automatically failed, input the code manually", Toast.LENGTH_LONG).show();
                verificationLayout.setErrorEnabled(true);
                verificationLayout.setError("Intercepting the verification code automatically failed, input the code manually");
            } else if (e instanceof IncorrectCodeException) {
                // The verification code provided was incorrect
                dotLoader.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(), "The verification code provided was incorrect", Toast.LENGTH_LONG).show();
                verificationLayout.setErrorEnabled(true);
                verificationLayout.setError("The verification code provided was incorrect");
            } else if (e instanceof ServiceErrorException) {
                // Sinch service error
                dotLoader.setVisibility(View.INVISIBLE);
                verifyNeeded = false;
                Toast.makeText(getApplicationContext(), "Service error Occured. Please try again", Toast.LENGTH_LONG).show();
                verificationLayout.setVisibility(View.GONE);
                phoneNumberLayout.setErrorEnabled(true);
                phoneNumberLayout.setError("Service error Occured. Please try again");
            } else {
                // Other system error, such as UnknownHostException in case of network error
                dotLoader.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(), "Network Error. Please Try again", Toast.LENGTH_LONG).show();
                verificationLayout.setErrorEnabled(true);
                verificationLayout.setError("Network Error. Please Try again");
            }
        }

    }



}
