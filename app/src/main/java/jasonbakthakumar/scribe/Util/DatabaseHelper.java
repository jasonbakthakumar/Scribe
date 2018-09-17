package jasonbakthakumar.scribe.Util;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jasonbakthakumar on 09/01/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "contactsManager";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_CONTACTS = "contactsTable";
    private static final String CONTACT_NAME = "cName";
    private static final String CONTACT_VIBE = "cVibe";
    private static final String CONTACT_SCRIBE = "cScribe";
    private static final String CONTACT_PROFILE_PIC_URL = "cPictureURL";
    private static final String CONTACT_UID = "cUID";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {


        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + CONTACT_NAME + " TEXT," + CONTACT_VIBE + " TEXT,"
                + CONTACT_SCRIBE + " INTEGER," + CONTACT_PROFILE_PIC_URL + " TEXT," + CONTACT_UID + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }


    // Adding new contact
    public void addContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CONTACT_NAME, contact.getName()); // Contact Name
        values.put(CONTACT_VIBE, contact.getVibe());// Contact Phone Number
        values.put(CONTACT_SCRIBE,contact.isOnScribe()?1:0);
        values.put(CONTACT_PROFILE_PIC_URL,contact.getProfilePictureUrl());
        values.put(CONTACT_UID,contact.getUid());
        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); // Closing database connection
    }

    //retrieve all contacts
    public List<Contact> getAllContacts() {
        List<Contact> contactList = new ArrayList<Contact>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact(cursor.getString(0),cursor.getString(1), Integer.parseInt(cursor.getString(2)) == 1,cursor.getString(3),cursor.getString(4));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
        return contactList;
    }

    public boolean isContactPresent(String phoneNumber) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_CONTACTS, new String[] { CONTACT_NAME,
                        CONTACT_VIBE, CONTACT_SCRIBE, CONTACT_PROFILE_PIC_URL, CONTACT_UID}, CONTACT_VIBE + "=?",
                new String[] { String.valueOf(phoneNumber) },null,null,null,null);
        return cursor != null;

    }


    public int getContactsCount() {
        int count = 0;
        String countQuery = "SELECT * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        if(cursor != null && !cursor.isClosed()){
            count = cursor.getCount();
            cursor.close();
        }
        return count;
    }


    // Updating single contact only for telling them in or out
    public int updateContact(Contact contact, String oldPhoneNumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CONTACT_NAME, contact.getName()); // Contact Name
        values.put(CONTACT_VIBE, contact.getVibe());// Contact Phone Number
        values.put(CONTACT_SCRIBE,contact.isOnScribe()?1:0);
        values.put(CONTACT_PROFILE_PIC_URL,contact.getProfilePictureUrl());
        values.put(CONTACT_UID,contact.getUid());
        // updating row
        return db.update(TABLE_CONTACTS, values, CONTACT_VIBE + " = ?",
                new String[] { String.valueOf(oldPhoneNumber) });
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(db);

    }

    public void clearOutTheTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        onCreate(db);

    }


    public int updateExistingContact(Contact contact, String uid) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CONTACT_NAME, contact.getName()); // Contact Name
        values.put(CONTACT_VIBE, contact.getVibe());// Contact Phone Number
        values.put(CONTACT_SCRIBE,contact.isOnScribe()?1:0);
        values.put(CONTACT_PROFILE_PIC_URL,contact.getProfilePictureUrl());
        values.put(CONTACT_UID,contact.getUid());
        // updating row
        return db.update(TABLE_CONTACTS, values, CONTACT_UID + " = ?",
                new String[] { String.valueOf(uid) });



    }
}
