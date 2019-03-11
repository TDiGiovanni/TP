package com.tdigiovanni.tp2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOpenHelper extends SQLiteOpenHelper {
    private static final int BASE_VERSION = 1;
    private static final String BASE_NAME = "contacts.db";
    private static final String TABLE_CONTACT = "table_contact";

    public static final String COLUMN_NAME = "Name";
    public static final int COLUMN_NAME_ID = 0;

    public static final String COLUMN_SURNAME = "Surname";
    public static final int COLUMN_SURNAME_ID = 1;

    public static final String COLUMN_NUMBER = "Number";
    public static final int COLUMN_NUMBER_ID = 2;

    /*** La requête de création de la structure de la base de données.*/
    private static final String CREATION_DB_QUERY = "create table " + TABLE_CONTACT + " (" + COLUMN_NAME+ " integer primary key autoincrement, " + COLONNE_NOM+ " text not null, " + COLONNE_RAYON + " text not null);";

    public DatabaseOpenHelper(Context context, String nom, SQLiteDatabase.CursorFactory cursorFactory, int version) {
        super(context, nom, cursorFactory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATION_DB_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL("drop table " + TABLE_PLANETES + ";");

        onCreate(database);
    }
}
