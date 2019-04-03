package com.tdigiovanni.tp2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    private final static String FILE_NAME = "contactInfos";

    //private ArrayList<String> contactsInfos = new ArrayList<String>(); // Array for intent version
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText nameEdit = findViewById(R.id.nameEdit);
        final EditText lastNameEdit = findViewById(R.id.lastNameEdit);
        final EditText numberEdit = findViewById(R.id.numberEdit);
        Button addToFileButton = findViewById(R.id.addToFileButton);
        Button showContactsButton = findViewById(R.id.showContactsButton);

        addToFileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(nameEdit.getText())
                || TextUtils.isEmpty(lastNameEdit.getText())
                || TextUtils.isEmpty(numberEdit.getText()) )
                    Toast.makeText(MainActivity.this, "You must fill out all informations", Toast.LENGTH_SHORT).show();

                else
                    {
                    /* Store in intent version
                    contactsInfos.add(lastNameEdit.getText() + " "
                            + nameEdit.getText() + " : "
                            + numberEdit.getText());

                    intent.putStringArrayListExtra("CONTACT_INFOS", contactsInfos);
                    */

                    String contactsInfos = lastNameEdit.getText() + "_"
                            + nameEdit.getText() + "_"
                            + numberEdit.getText();

                    try {
                        FileOutputStream file = openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
                        file.write(contactsInfos.getBytes());
                        file.close();
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        showContactsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent serviceIntent = new Intent(MainActivity.this, CheckDatabaseService.class);
                serviceIntent.putExtra("FILE_NAME", FILE_NAME);
                startService(serviceIntent);

                Intent activityIntent = new Intent(MainActivity.this, ContactsActivity.class);
                startActivity(activityIntent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        counter++;
        Toast.makeText(this, "Counter: " + counter, Toast.LENGTH_LONG).show();
    }
}
