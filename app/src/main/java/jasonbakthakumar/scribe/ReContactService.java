package jasonbakthakumar.scribe;

import android.annotation.SuppressLint;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.os.ResultReceiver;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

import java.util.ArrayList;
import java.util.List;
import jasonbakthakumar.scribe.Util.Contact;
import jasonbakthakumar.scribe.Util.DatabaseHelper;
import jasonbakthakumar.scribe.Util.Users;

/**
 * Created by jasonbakthakumar on 27/02/17.
 */

public class ReContactService extends IntentService {

    private DatabaseHelper db = new DatabaseHelper(this);
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("users");
    public static final String RECEIVER = "receiver";


    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     */


    public ReContactService() {
        super("ReContactService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if(intent != null){
            if(intent.getExtras().getBoolean("dataPopulate",false)){

                db.clearOutTheTable();
                doTheFirstTimeRealWork(intent);
            }
            else{
                //The refresh is being called
                doTheNormalRealWork(intent);

            }
        }

    }

    private void doTheNormalRealWork(final Intent intent) {
        ArrayList<String> contactRetrieved = getPhoneNumberAndNameFromContacts();
        if(contactRetrieved != null){
            SharedPreferences prefs = getSharedPreferences("REG", Context.MODE_PRIVATE);
            prefs.edit().putBoolean("contactEmpty",false).apply();
            //contact is NOt Empty
            //remove duplicates
            List<String> newList = new ArrayList<>();
            //remove all the duplicates
            for(int i=0; i<contactRetrieved.size();i++) {
                String phoneNo = contactRetrieved.get(i);
                String name = contactRetrieved.get(++i);
                if(!newList.contains(phoneNo)){
                    newList.add(phoneNo);
                    newList.add(name);
                }
            }
            //check for new contacts..
            for(int i=0; i<newList.size();i++) {
                String phoneNo = newList.get(i);
                String name = newList.get(++i);
                if (!db.isContactPresent(phoneNo)) {
                    Contact contact = new Contact(name,phoneNo,false,null,null);
                    db.addContact(contact);
                }
            }

            //do the thing...
            List<Contact> contactList = db.getAllContacts();
            final int sizeOfTheList = contactList.size() - 1;
            for(int i=0; i<contactList.size();i++){
                final int temp = i;
                Contact contact = contactList.get(i);
                if(contact.isOnScribe()){
                    //the guy is on Scribe
                    mDatabase.child(contact.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                Users user = dataSnapshot.getValue(Users.class);
                                Contact contact2 = new Contact(user.getName(),user.getVibe(),true,user.getPhotoUrl(),user.getUid());
                                db.updateExistingContact(contact2,user.getUid());
                                if(temp == sizeOfTheList){
                                    sendTheReciever(intent,false);

                                }
                            }
                            else{
                                if(temp == sizeOfTheList){
                                    sendTheReciever(intent,false);

                                }

                            }

                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            //connection error dont do anything
                            if(temp == sizeOfTheList){
                                sendTheReciever(intent,false);

                            }
                        }
                    });
                }
                else{
                    // guy is not on Scribe.
                    final String phn = contact.getVibe();
                    Query myContactQuery = mDatabase.orderByChild("phoneNumber").equalTo(contact.getVibe()).limitToFirst(1);
                    myContactQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                for(DataSnapshot dsp: dataSnapshot.getChildren()){
                                    Users user = dsp.getValue(Users.class);
                                    Contact contact1 = new Contact(user.getName(),user.getVibe(),true,user.getPhotoUrl(),user.getUid());
                                    db.updateContact(contact1,phn);
                                }
                                if(temp == sizeOfTheList){
                                    sendTheReciever(intent,false);
                                }
                            }
                            else{
                                if(temp == sizeOfTheList){
                                    sendTheReciever(intent,false);

                                }

                            }

                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            //lets assume guy is not Scribe. Dont do anythiing
                            if(temp == sizeOfTheList){
                                sendTheReciever(intent,false);

                            }
                        }
                    });

                }

            }

        }
        else{
            //contact is empty
            SharedPreferences prefs = getSharedPreferences("REG", Context.MODE_PRIVATE);
            prefs.edit().putBoolean("contactEmpty",true).apply();
            sendTheReciever(intent,false);
        }



    }

    private void doTheFirstTimeRealWork(final Intent intent) {
        ArrayList<String> contactRetrieved = getPhoneNumberAndNameFromContacts();
        if(contactRetrieved != null){
            //cityList.stream().distinct().collect(Collectors.toList());
            //contact is not empty
            SharedPreferences prefs = getSharedPreferences("REG", Context.MODE_PRIVATE);
            prefs.edit().putBoolean("contactEmpty",false).apply();
            List<String> newList = new ArrayList<>();
            //remove all the duplicates
            for(int i=0; i<contactRetrieved.size();i++) {
                String phoneNo = contactRetrieved.get(i);
                String name = contactRetrieved.get(++i);
                if(!newList.contains(phoneNo)){
                    newList.add(phoneNo);
                    newList.add(name);
                }
            }

            for(int i=0; i<newList.size();i++){
                String phoneNo = newList.get(i);
                String name = newList.get(++i);
                Contact contact = new Contact(name,phoneNo,false,null,null);
                db.addContact(contact);
            }

            final int sizeOfTheList = newList.size() - 1;
            for(int ib=0; ib<newList.size();ib+=2) {
                final int tempted = ib;
                final String phoneNo = newList.get(ib);
                Query myContactQuery = mDatabase.orderByChild("phoneNumber").equalTo(phoneNo).limitToFirst(1);
                myContactQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){

                            //The user exists
                            for(DataSnapshot dsp: dataSnapshot.getChildren()){
                                Users user = dsp.getValue(Users.class);
                                Contact contact = new Contact(user.getName(),user.getVibe(),true,user.getPhotoUrl(),user.getUid());
                                db.updateContact(contact,phoneNo);
                            }
                            if(tempted/2 == sizeOfTheList/2){
                                sendTheReciever(intent,true);

                            }
                        }
                        else{

                            if(tempted/2 == sizeOfTheList/2){

                                sendTheReciever(intent,true);
                            }

                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        //lets assume this guy aint on Scribe

                        if(tempted/2 == sizeOfTheList/2){

                            sendTheReciever(intent,true);
                        }

                    }
                });
            }
        }
        else{
            //contact is empty
            SharedPreferences prefs = getSharedPreferences("REG", Context.MODE_PRIVATE);
            prefs.edit().putBoolean("contactEmpty",true).apply();
            sendTheReciever(intent,true);

        }



    }


    private void sendTheReciever(Intent intent,boolean isItTheFirstTime) {
        ResultReceiver receiver = intent.getParcelableExtra(RECEIVER);
        receiver.send(isItTheFirstTime ? 10 : 1, null);
    }




    private ArrayList<String> getPhoneNumberAndNameFromContacts(){
        ArrayList<String> stuff = new ArrayList<>();
        SharedPreferences prefs = getSharedPreferences("REG", Context.MODE_PRIVATE);
        String userPhone = prefs.getString("phoneNumber",null);
        String countryDefault = prefs.getString("defaultCountry",null);
        @SuppressLint("Recycle")
        Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
        assert phones != null;
        if(phones.getCount() > 0){
            if(phones.moveToFirst()){
                do{
                    if(Integer.parseInt(phones.getString(phones.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)))>0){
                        String phoneNo = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        String name=phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                        if(isValidMobileNumber(phoneNo)){
                            phoneNo = phoneNo.replaceAll("\\s+","");
                            phoneNo = phoneNo.replaceAll("[^\\w+]","");
                            if (!phoneNo.startsWith("+")) {
                                if(prefs.getString("defaultCountry",null) != null){
                                    PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
                                    try {
                                        Phonenumber.PhoneNumber phoneNumber = phoneUtil.parse(phoneNo,countryDefault);
                                        phoneNo = phoneUtil.format(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.E164);
                                    } catch (NumberParseException ignored) {
                                        //nothing happens

                                    }
                                }
                            }
                            if (!phoneNo.equals(userPhone)) {
                                stuff.add(phoneNo);
                                stuff.add(name);
                            }
                        }

                    }
                }while (phones.moveToNext());
            }

            phones.close();
            return stuff;
        }
        return null;
    }



    private boolean isValidMobileNumber(String phoneNo) {
        return android.util.Patterns.PHONE.matcher(phoneNo).matches();
    }


}
