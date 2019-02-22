package com.tdigiovanni.tp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Contacts extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        ListView contactsList = findViewById(R.id.contactsList);

        ArrayList<String> contact = new ArrayList<String>();
        contact.add(getIntent().getStringExtra("CONTACT_INFOS"));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contact);

        contactsList.setAdapter(adapter);
    }
}
