package com.tdigiovanni.tp2;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Contacts extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        ListView contactsList = findViewById(R.id.contactsList);

        /* Q1 version
        ArrayList<String> contactsInfos = getIntent().getStringArrayListExtra("CONTACT_INFOS");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contactsInfos);
        */

        /* Q3 version
        String fileName = getIntent().getStringExtra("FILE_NAME");
        ArrayList<String> contactsInfos = new ArrayList<String>();
        try {
            FileInputStream file = openFileInput(fileName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file));
            contactsInfos.add(bufferedReader.readLine());
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contactsInfos);
        */

        // Q4 version
        ContactsDatabase database = new ContactsDatabase(this);
        Cursor cursor = database.getAllContacts();
        String[] fromColumns = {};
        int[] toViews = {};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, fromColumns, toViews, 0);

        contactsList.setAdapter(adapter);
    }
}
