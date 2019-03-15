package com.tdigiovanni.tp2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ContactsDatabaseOpenHelper extends SQLiteOpenHelper {
    private SQLiteDatabase database;
    private static ContactsDatabaseOpenHelper instance;

    private static final String BASE_NAME = "contacts.db";
    private static final int BASE_VERSION = 1;

    public static final String TABLE_CONTACT = "contact";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_LAST_NAME = "lastName";
    public static final String COLUMN_NUMBER = "number";

    private static final String CREATION_DB_QUERY = "create table " + TABLE_CONTACT + " ("
            + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_NAME + " text not null, "
            + COLUMN_LAST_NAME + " text not null, "
            + COLUMN_NUMBER + " text not null);";


    private ContactsDatabaseOpenHelper(Context context) {
        super(context, BASE_NAME, null, BASE_VERSION);
    }


    public static ContactsDatabaseOpenHelper getInstance(Context context) {
        if (instance == null) {
            instance = new ContactsDatabaseOpenHelper(context);
        }
        return instance;
    }


    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATION_DB_QUERY);
    }


    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL("drop table " + TABLE_CONTACT + ";");
        this.onCreate(database);
    }


    public void addContact(String name, String lastName, String number) {
        database = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_LAST_NAME, lastName);
        values.put(COLUMN_NUMBER, number);

        database.insert(TABLE_CONTACT, null, values);
    }


    public Cursor getAllContacts() {
        database = this.getWritableDatabase();

        return database.query(TABLE_CONTACT,
                new String[]{COLUMN_ID, COLUMN_NAME, COLUMN_LAST_NAME, COLUMN_NUMBER},
                null,
                null,
                null,
                null,
                null);
    }
}
