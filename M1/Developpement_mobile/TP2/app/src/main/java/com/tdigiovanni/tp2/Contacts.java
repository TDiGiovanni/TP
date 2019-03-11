package com.tdigiovanni.tp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

        ArrayList<String> contactsInfos= getIntent().getStringArrayListExtra("CONTACT_INFOS"); // Q1 only
        /*
        try {
            String fileName = getIntent().getExtra("FILE_NAME");
            FileInputStream file = openFileInput(fileName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file));
            String contactInfos = bufferedReader.readLine();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contactsInfos);

        contactsList.setAdapter(adapter);
    }
}
