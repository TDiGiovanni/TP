package com.tdigiovanni.tp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Contacts extends AppCompatActivity {

    protected ListView contactsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout., );

        contactsList = findViewById(R.id.contactsList);
        contactsList.setAdapter(adapter);
    }
}
