package jasonbakthakumar.scribe.Util;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

/**
 * Created by jasonbakthakumar on 17/11/16.
 */

public class PhoneNumberVerification {

    PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();

    //To Check if the number is China Region Number or Not.
    public boolean isChinaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "CN");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Zimbabwe Number in the Internaational Format
    public String setChinaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "CN");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Zimbabwe Region Number or Not.
    public boolean isZimbabweMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "ZW");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Zimbabwe Number in the Internaational Format
    public String setZimbabweMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "ZW");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number isZambia Region Number or Not.
    public boolean isZambiaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "ZM");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Zambia Number in the Internaational Format
    public String setZambiaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "ZM");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number isYemen Region Number or Not.
    public boolean isYemenMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "YE");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Yemen Number in the Internaational Format
    public String setYemenMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "YE");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number isVietnam Region Number or Not.
    public boolean isVietnamMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "VN");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Vietnam Number in the Internaational Format
    public String setVietnamMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "VN");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }






    //To Check if the number isVenezuela Region Number or Not.
    public boolean isVenezuelaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "VE");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Venezuela Number in the Internaational Format
    public String setVenezuelaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "VE");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Uzbekistan Region Number or Not.
    public boolean isUzbekistanMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "UZ");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Uzbekistan Number in the Internaational Format
    public String setUzbekistanMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "UZ");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }




    //To Check if the number is Uruguay Region Number or Not.
    public boolean isUruguayMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "UY");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  UruguayNumber in the Internaational Format
    public String setUruguayMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "UY");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is United_Kingdom Region Number or Not.
    public boolean isUnited_KingdomMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "GB");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  United_Kingdom Number in the Internaational Format
    public String setUnited_KingdomMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "GB");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }





    //To Check if the number is United_Arab_Emirates Region Number or Not.
    public boolean isUnited_Arab_EmiratesMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber,"AE");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  United_Arab_Emirates Number in the Internaational Format
    public String setUnited_Arab_EmiratesMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "AE");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }




    //To Check if the number is Ukraine Region Number or Not.
    public boolean isUkraineMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "UA");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Ukraine Number in the Internaational Format
    public String setUkraineMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "UA");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }




    //To Check if the number is Uganda Region Number or Not.
    public boolean isUgandaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "UG");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Uganda Number in the Internaational Format
    public String setUgandaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "UG");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }




    //To Check if the number is Turkmenistan Region Number or Not.
    public boolean isTurkmenistanMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "TM");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Turkmenistan Number in the Internaational Format
    public String setTurkmenistanMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "TM");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Turkey Region Number or Not.
    public boolean isTurkeyMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "TR");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  TTurkey Number in the Internaational Format
    public String setTurkeyMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "TR");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Tunisia Region Number or Not.
    public boolean isTunisiaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "TN");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Tunisia Number in the Internaational Format
    public String setTunisiaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "TN");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Trinidad and Tobago Region Number or Not.
    public boolean isTrinidad_and_TobagoMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "TT");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Trinidad_and_Tobago Number in the Internaational Format
    public String setTrinidad_and_TobagoMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "TT");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Togo Region Number or Not.
    public boolean isTogoMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "TG");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Togo Number in the Internaational Format
    public String setTogoMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "TG");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }






    //To Check if the number is Thailand Region Number or Not.
    public boolean isThailandMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "TH");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Thailand Number in the Internaational Format
    public String setThailandMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "TH");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }




    //To Check if the number is Tanzania Region Number or Not.
    public boolean isTanzaniaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "TZ");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Tanzania Number in the Internaational Format
    public String setTanzaniaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "TZ");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Tajikistan Region Number or Not.
    public boolean isTajikistanMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "TJ");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Tajikistan Number in the Internaational Format
    public String setTajikistannMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "TJ");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Taiwan Region Number or Not.
    public boolean isTaiwanMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "TW");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Taiwan Number in the Internaational Format
    public String setTaiwanMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "TW");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Switzerland Region Number or Not.
    public boolean isSwitzerlandMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "CH");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Switzerland Number in the Internaational Format
    public String setSwitzerlandMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "CH");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }




    //To Check if the number is Sweden Region Number or Not.
    public boolean isSwedenMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "SE");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Sweden Number in the Internaational Format
    public String setSwedenMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "SE");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Sri_Lanka Region Number or Not.
    public boolean isSri_LankaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "LK");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Sri_Lanka Number in the Internaational Format
    public String setSri_LankaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "LK");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }

    //To Check if the number is Spain Region Number or Not.
    public boolean isSpainMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "ES");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }


    //To set An  Spain Number in the Internaational Format
    public String setSpainMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "ES");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }
    //To Check if the number is South Korea Region Number or Not.
    public boolean isSouth_KoreaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "KR");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  South Korea Number in the Internaational Format
    public String setSouth_KoreaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "KR");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is South Africa Region Number or Not.
    public boolean isSouth_AfricaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "ZA");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  South_Africa Number in the Internaational Format
    public String setSouth_AfricaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "ZA");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Slovenia Region Number or Not.
    public boolean isSloveniaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "SI");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Slovenia Number in the Internaational Format
    public String setSloveniaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "SI");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }




    //To Check if the number is Slovakia Region Number or Not.
    public boolean isSlovakiaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "SK");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Slovakia Number in the Internaational Format
    public String setSlovakiaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "SK");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Singapore Region Number or Not.
    public boolean isSingaporeMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "SG");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Singapore Number in the Internaational Format
    public String setSingaporeMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "SG");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Serbia Region Number or Not.
    public boolean isSerbiaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "RS");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Serbia Number in the Internaational Format
    public String setSerbiaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "RS");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Senegal Region Number or Not.
    public boolean isSenegalMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "SN");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Senegal Number in the Internaational Format
    public String setSenegalMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "SN");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Saudi Arabia Region Number or Not.
    public boolean isSaudi_ArabiaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "SA");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Saudi Arabia Number in the Internaational Format
    public String setSaudi_ArabiaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "SA");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Rwanda Region Number or Not.
    public boolean isRwandaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "RW");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Rwanda Number in the Internaational Format
    public String setRwandaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "RW");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }

    //To Check if the number is Russia Region Number or Not.
    public boolean isRussiaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "RU");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Russia Number in the Internaational Format
    public String setRussiaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "RU");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Romania Region Number or Not.
    public boolean isRomaniaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "RO");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Romania Number in the Internaational Format
    public String setRomaniaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "RO");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Qatar Region Number or Not.
    public boolean isQatarMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "QA");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Qatar Number in the Internaational Format
    public String setQatarMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "QA");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Portugal Region Number or Not.
    public boolean isPortugalMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "PT");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Portugal Number in the Internaational Format
    public String setPortugalMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "PT");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Poland Region Number or Not.
    public boolean isPolandMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "PL");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Poland Number in the Internaational Format
    public String setPolandMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "PL");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Philippines Region Number or Not.
    public boolean isPhilippinesMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "PH");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Philippines Number in the Internaational Format
    public String setPhilippinesMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "PH");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Peru Region Number or Not.
    public boolean isPeruMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "PE");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Peru Number in the Internaational Format
    public String setPeruMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "PE");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Paraguay Region Number or Not.
    public boolean isParaguayMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "PY");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Paraguay Number in the Internaational Format
    public String setParaguayMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "PY");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Papua New Guinea Region Number or Not.
    public boolean isPapua_New_GuineaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "PG");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Papua_New_Guinea Number in the Internaational Format
    public String setPapua_New_GuineaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "PG");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Panama Region Number or Not.
    public boolean isPanamaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "PA");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Panama Number in the Internaational Format
    public String setPanamaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "PA");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Pakistan Region Number or Not.
    public boolean isPakistanMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "PK");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Pakistan Number in the Internaational Format
    public String setPakistanMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "PK");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Oman Region Number or Not.
    public boolean isOmanMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "OM");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Oman Number in the Internaational Format
    public String setOmanMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "OM");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Norway Region Number or Not.
    public boolean isNorwayMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "NO");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Norway Number in the Internaational Format
    public String setNorwayMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "NO");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Nigeria Region Number or Not.
    public boolean isNigeriaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "NG");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Nigeria Number in the Internaational Format
    public String setNigeriaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "NG");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Niger Region Number or Not.
    public boolean isNigerMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "NE");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Niger Number in the Internaational Format
    public String setNigerMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "NE");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Nicaragua Region Number or Not.
    public boolean isNicaraguaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "NI");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Nicaragua Number in the Internaational Format
    public String setNicaraguaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "NI");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is New Zealand Region Number or Not.
    public boolean isNew_ZealandMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "NZ");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  New_Zealand Number in the Internaational Format
    public String setNew_ZealandMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "NZ");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Netherlands Antilles Region Number or Not.
    public boolean isNetherlands_AntillesMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "AN");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Netherlands_Antilles Number in the Internaational Format
    public String setNetherlands_AntillesMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "AN");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Netherlands Region Number or Not.
    public boolean isNetherlandsMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "NL");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Netherlands Number in the Internaational Format
    public String setNetherlandsMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "NL");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is  Nepal Region Number or Not.
    public boolean isNepalMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "NP");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Nepal Number in the Internaational Format
    public String setNepalMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "NP");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is  Namibia Region Number or Not.
    public boolean isNamibiaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "NA");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Namibia Number in the Internaational Format
    public String setNamibiaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "NA");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is  Mozambique Region Number or Not.
    public boolean isMozambiqueMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "MZ");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Mozambique Number in the Internaational Format
    public String setMozambiqueMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "MZ");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is  Morocco Region Number or Not.
    public boolean isMoroccoMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "MA");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Morocco Number in the Internaational Format
    public String setMoroccoMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "MA");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is  Moldova Region Number or Not.
    public boolean isMoldovaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "MD");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Moldova Number in the Internaational Format
    public String setMoldovaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "MD");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is  Mexico Region Number or Not.
    public boolean isMexicoMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "MX");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Mexico Number in the Internaational Format
    public String setMexicoMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "MX");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is  Mauritius Region Number or Not.
    public boolean isMauritiusMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "MU");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Mauritius Number in the Internaational Format
    public String setMauritiusMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "MU");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }

    //To Check if the number is  Malta Region Number or Not.
    public boolean isMaltaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "MT");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Malta Number in the Internaational Format
    public String setMaltaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "MT");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is  Mali Region Number or Not.
    public boolean isMaliMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "ML");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Mali Number in the Internaational Format
    public String setMaliMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "ML");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is  Malaysia Region Number or Not.
    public boolean isMalaysiaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "MY");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Malaysia Number in the Internaational Format
    public String setMalaysiaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "MY");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is  Macedonia Region Number or Not.
    public boolean isMacedoniaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "MK");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An  Macedonia Number in the Internaational Format
    public String setMacedoniaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "MK");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Luxembourg Region Number or Not.
    public boolean isLuxembourgMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "LU");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Luxembourg Number in the Internaational Format
    public String setLuxembourgMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "LU");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Lithuania Region Number or Not.
    public boolean isLithuaniaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "LT");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Lithuania Number in the Internaational Format
    public String setLithuaniaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "LT");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Liechtenstein Region Number or Not.
    public boolean isLiechtensteinMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "LI");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Liechtenstein Number in the Internaational Format
    public String setLiechtensteinMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "LI");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Lebanon Region Number or Not.
    public boolean isLebanonMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "LB");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Lebanon Number in the Internaational Format
    public String setLebanonMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "LB");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Latvia Region Number or Not.
    public boolean isLatviaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "LV");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Latvia Number in the Internaational Format
    public String setLatviaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "LV");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Laos Region Number or Not.
    public boolean isLaosMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "LA");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Laos Number in the Internaational Format
    public String setLaosMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "LA");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }

    //To Check if the number is Kyrgyzstan Region Number or Not.
    public boolean isKyrgyzstanMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "KG");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Kyrgyzstan Number in the Internaational Format
    public String setKyrgyzstanMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "KG");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }




    //To Check if the number is Kuwait Region Number or Not.
    public boolean isKuwaitMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "KW");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Kuwait Number in the Internaational Format
    public String setKuwaitMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "KW");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Kenya Region Number or Not.
    public boolean isKenyaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "KE");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Kenya Number in the Internaational Format
    public String setKenyaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "KE");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }

    //To Check if the number is Kazakhstan Region Number or Not.
    public boolean isKazakhstanMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "KZ");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Kazakhstan Number in the Internaational Format
    public String setKazakhstanMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "KZ");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Jordan Region Number or Not.
    public boolean isJordanMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "JO");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Jordan Number in the Internaational Format
    public String setJordanMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "JO");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Japan Region Number or Not.
    public boolean isJapanMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "JP");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Japan Number in the Internaational Format
    public String setJapanMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "JP");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Jamaica Region Number or Not.
    public boolean isJamaicaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "JM");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An IJamaica Number in the Internaational Format
    public String setJamaicaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "JM");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Ivory Coast Region Number or Not.
    public boolean isIvory_CoastMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "CI");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Ivory_Coast Number in the Internaational Format
    public String setIvory_CoastMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "CI");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Italy Region Number or Not.
    public boolean isItalyMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "IT");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Italy Number in the Internaational Format
    public String setItalyMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "IT");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Israel Region Number or Not.
    public boolean isIsraelMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "IL");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Israel Number in the Internaational Format
    public String setIsraelMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "IL");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Ireland Region Number or Not.
    public boolean isIrelandMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "IE");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Ireland  Number in the Internaational Format
    public String setIrelandMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "IE");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Indonesia Region Number or Not.
    public boolean isIndonesiaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "ID");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Indonesia  Number in the Internaational Format
    public String setIndonesiaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "ID");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Iceland Region Number or Not.
    public boolean isIcelandMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "IS");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Iceland  Number in the Internaational Format
    public String setIcelandMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "IS");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Hungary Region Number or Not.
    public boolean isHungaryMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "HU");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Hungary  Number in the Internaational Format
    public String setHungaryMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "HU");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Hong Kong Region Number or Not.
    public boolean isHong_KongMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "HK");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Hong_Kong  Number in the Internaational Format
    public String setHong_KongMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "HK");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Honduras Region Number or Not.
    public boolean isHondurasMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "HN");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Honduras  Number in the Internaational Format
    public String setHondurasMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "HN");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Haiti Region Number or Not.
    public boolean isHaitiMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "HT");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Haiti  Number in the Internaational Format
    public String setHaitiMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "HT");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Guinea-Bissau Region Number or Not.
    public boolean isGuinea_BissauMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "GW");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Guinea-Bissau  Number in the Internaational Format
    public String setGuinea_BissauMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "GW");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Guatemala Region Number or Not.
    public boolean isGuatemalaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "GT");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Guatemala  Number in the Internaational Format
    public String setGuatemalaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "GT");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }

    //To Check if the number is Greece Region Number or Not.
    public boolean isGreeceMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "GR");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Greece  Number in the Internaational Format
    public String setGreeceMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "GR");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Ghana Region Number or Not.
    public boolean isGhanaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "GH");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Ghana  Number in the Internaational Format
    public String setGhanaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "GH");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Germany Region Number or Not.
    public boolean isGermanyMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "DE");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Germany  Number in the Internaational Format
    public String setGermanyMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "DE");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Gabon Region Number or Not.
    public boolean isGabonMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "GA");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Gabon  Number in the Internaational Format
    public String setGabonMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "GA");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is France Region Number or Not.
    public boolean isFranceMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "FR");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An France  Number in the Internaational Format
    public String setFranceMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "FR");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }




    //To Check if the number is Finland Region Number or Not.
    public boolean isFinlandMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "FI");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Finland  Number in the Internaational Format
    public String setFinlandMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "FI");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Fiji Region Number or Not.
    public boolean isFijiMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "FJ");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Fiji  Number in the Internaational Format
    public String setFijiMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "FJ");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }




    //To Check if the number is Estonia Region Number or Not.
    public boolean isEstoniaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "EE");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Estonia  Number in the Internaational Format
    public String setEstoniaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "EE");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is El_Salvador Region Number or Not.
    public boolean isEl_SalvadorMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "SV");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An El_Salvador  Number in the Internaational Format
    public String setEl_SalvadorMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "SV");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Egypt Region Number or Not.
    public boolean isEgyptMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "EG");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Egypt  Number in the Internaational Format
    public String setEgyptMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "EG");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Ecuador Region Number or Not.
    public boolean isEcuadorMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "EC");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Ecuador  Number in the Internaational Format
    public String setEcuadorMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "EC");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Dominican_Republic Region Number or Not.
    public boolean isDominican_RepublicMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "DO");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Dominican_Republic  Number in the Internaational Format
    public String setDominican_RepublicMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "DO");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }




    //To Check if the number is Denmark Region Number or Not.
    public boolean isDenmarkMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "DK");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Denmark Number in the Internaational Format
    public String setDenmarkMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "DK");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Czech Republic Region Number or Not.
    public boolean isCzech_RepublicMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "CZ");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Czech_Republic Number in the Internaational Format
    public String setCzech_RepublicMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "CZ");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Cyprus Region Number or Not.
    public boolean isCyprusMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "CY");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Cyprus Number in the Internaational Format
    public String setCyprusMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "CY");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Croatia Region Number or Not.
    public boolean isCroatiaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "HR");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Croatia Number in the Internaational Format
    public String setCroatiaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "HR");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Costa Rica Region Number or Not.
    public boolean isCosta_RicaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "CR");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Costa Rica Number in the Internaational Format
    public String setCosta_RicaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "CR");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Colombia Region Number or Not.
    public boolean isColombiaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "CO");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Colombia Number in the Internaational Format
    public String setColombiaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "CO");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }

    //To Check if the number is Chile Region Number or Not.
    public boolean isChileMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "CL");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Chile Number in the Internaational Format
    public String setChileMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "CL");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Cape Verde Region Number or Not.
    public boolean isCape_VerdeMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "CV");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Cape Verde Number in the Internaational Format
    public String setCape_VerdeMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "CV");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Canada Region Number or Not.
    public boolean isCanadaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "CA");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Canada Number in the Internaational Format
    public String setCanadaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "CA");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Cameroon Region Number or Not.
    public boolean isCameroonMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "CM");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An CCameroon Number in the Internaational Format
    public String setCameroonMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "CM");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Cambodia Region Number or Not.
    public boolean isCambodiaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "KH");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Cambodia Number in the Internaational Format
    public String setCambodiaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "KH");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }




    //To Check if the number is Burkina Region Number or Not.
    public boolean isBurkinaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "BF");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Burkina Number in the Internaational Format
    public String setBurkinaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "BF");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Bulgaria Region Number or Not.
    public boolean isBulgariaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "BG");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }


    //To set An Bulgaria Number in the Internaational Format
    public String setBulgariaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "BG");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Brazil Region Number or Not.
    public boolean isBrazilMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "BR");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Brazil Number in the Internaational Format
    public String setBrazilMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "BR");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }




    //To Check if the number is Botswana Region Number or Not.
    public boolean isBotswanaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "BW");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Botswana Number in the Internaational Format
    public String setBotswanaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "BW");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Bosnia and Herzegovina Region Number or Not.
    public boolean isBosnia_and_HerzegovinaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "BA");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Bosnia_and_Herzegovina Number in the Internaational Format
    public String setBosnia_and_HerzegovinaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "BA");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }




    //To Check if the number is Bolivia Region Number or Not.
    public boolean isBoliviaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "BO");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }


    //To set An Bolivia Number in the Internaational Format
    public String setBoliviaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "BO");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Benin Region Number or Not.
    public boolean isBeninMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "BJ");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Benin Number in the Internaational Format
    public String setBeninMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "BJ");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Belize Region Number or Not.
    public boolean isBelizeMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "BZ");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Belize Number in the Internaational Format
    public String setBelizeMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "BZ");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Belgium Region Number or Not.
    public boolean isBelgiumMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "BE");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Belgium Number in the Internaational Format
    public String setBelgiumMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "BE");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Belarus Region Number or Not.
    public boolean isBelarusMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "BY");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Belarus Number in the Internaational Format
    public String setBelarusMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "BY");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Bangladesh Region Number or Not.
    public boolean isBangladeshMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "BD");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }
    //To set An Bangladesh Number in the Internaational Format
    public String setBangladeshMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "BD");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Bahrain Region Number or Not.
    public boolean isBahrainMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "BH");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Bahrain Number in the Internaational Format
    public String setBahrainMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "BH");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Bahamas Region Number or Not.
    public boolean isBahamasMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "BS");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }



    //To set An Bahamas Number in the Internaational Format
    public String setBahamasMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "BS");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }

    //To Check if the number is Azerbaijan Region Number or Not.
    public boolean isAzerbaijanMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "AZ");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Azerbaijan Number in the Internaational Format
    public String setAzerbaijanMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "AZ");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Austria Region Number or Not.
    public boolean isAustriaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "AT");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Austria Number in the Internaational Format
    public String setAustriaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "AT");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }




    //To Check if the number is Australia Region Number or Not.
    public boolean isAustraliaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "AU");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Australia Number in the Internaational Format
    public String setAustraliaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "AU");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }




    //To Check if the number is Aruba Region Number or Not.
    public boolean isArubaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "AW");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Aruba Number in the Internaational Format
    public String setArubaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "AW");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Armenia Region Number or Not.
    public boolean isArmeniaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "AM");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Armenia Number in the Internaational Format
    public String setArmeniaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "AM");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Argentina Region Number or Not.
    public boolean isArgentinaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "AR");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Argentina Number in the Internaational Format
    public String setArgentinaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "AR");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Antigua and Barbuda Region Number or Not.
    public boolean isAntigua_and_BarbudaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "AG");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Antigua_and_Barbuda Number in the Internaational Format
    public String setAntigua_and_BarbudaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "AG");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Angola Region Number or Not.
    public boolean isAngolaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "AO");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Angola Number in the Internaational Format
    public String setAngolaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "AO");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Algeria Region Number or Not.
    public boolean isAlgeriaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "DZ");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Algeria Number in the Internaational Format
    public String setAlgeriaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "DZ");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }



    //To Check if the number is Albania Region Number or Not.
    public boolean isAlbaniaMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "AL");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Albania Number in the Internaational Format
    public String setAlbaniaMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "AL");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is US Region Number or Not.
    public boolean isUSMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber,"US");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An US Number in the Internaational Format
    public String setUSMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "US");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


    //To Check if the number is Indian Number or Not.
    public boolean isIndianMobileNumber(String phoneNumber) {
        try {
            Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "IN");
            String Mobile = "MOBILE";
            PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneUtil.getNumberType(phoneNumberObject);
            if (Mobile.equals(phoneNumberType.toString())) {
                return true;
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }

    //To set An Indian Number in the Internaational Format
    public String setIndianMobileNumber(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumberObject = phoneUtil.parse(phoneNumber, "IN");
        return phoneUtil.format(phoneNumberObject, PhoneNumberUtil.PhoneNumberFormat.E164);
    }


}