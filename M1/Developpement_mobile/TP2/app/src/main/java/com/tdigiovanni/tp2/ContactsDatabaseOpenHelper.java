package com.tdigiovanni.tp2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ContactsDatabaseOpenHelper extends SQLiteOpenHelper {
    public static final String TABLE_CONTACT = "table_contact";

    public static final String COLUMN_ID = "Id";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_SURNAME = "Surname";
    public static final String COLUMN_NUMBER = "Number";

    private static final String CREATION_DB_QUERY = "create table " + TABLE_CONTACT + " ("
            + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_NAME + " text not null, "
            + COLUMN_SURNAME + " text not null, "
            + COLUMN_NUMBER + " integer not null);";

    public ContactsDatabaseOpenHelper(Context context, String nom, SQLiteDatabase.CursorFactory cursorFactory, int version) {
        super(context, nom, cursorFactory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATION_DB_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL("drop table " + TABLE_CONTACT + ";");
        onCreate(database);
    }
}
