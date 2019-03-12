package com.tdigiovanni.tp2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ContactsDatabase {
    private static final String BASE_NAME = "contacts.db";
    private static final int BASE_VERSION = 1;

    private SQLiteDatabase database;
    private ContactsDatabaseOpenHelper helper;

    public ContactsDatabase(Context context) {
        helper = new ContactsDatabaseOpenHelper(context, BASE_NAME, null, BASE_VERSION);
    }

    public SQLiteDatabase open() {
        database = helper.getWritableDatabase();
        return database;
    }

    public Cursor getAllContacts() {
        return database.query(helper.TABLE_CONTACT,
                new String[] { helper.COLUMN_ID, helper.COLUMN_NAME, helper.COLUMN_SURNAME, helper.COLUMN_NUMBER },
                null,
                null,
                null,
                null,
                null);
    }
}
