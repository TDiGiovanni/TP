package com.tdigiovanni.tp2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main extends AppCompatActivity {
    //private ArrayList<String> contactsInfos = new ArrayList<String>(); // Q1 version
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText nameEdit = findViewById(R.id.nameEdit);
        final EditText surnameEdit = findViewById(R.id.surnameEdit);
        final EditText numberEdit = findViewById(R.id.numberEdit);
        Button sendButton = findViewById(R.id.sendButton);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( TextUtils.isEmpty(nameEdit.getText())
                || TextUtils.isEmpty(surnameEdit.getText())
                || TextUtils.isEmpty(numberEdit.getText()) )
                    Toast.makeText(Main.this, "You must fill out all informations", Toast.LENGTH_SHORT).show();

                else {
                    Intent intent = new Intent(Main.this, Contacts.class);

                    /* Q1 version
                    contactsInfos.add(surnameEdit.getText() + " "
                            + nameEdit.getText() + " : "
                            + numberEdit.getText());

                    intent.putStringArrayListExtra("CONTACT_INFOS", contactsInfos);
                    */

                    /* Q3 version
                    String contactsInfos = surnameEdit.getText() + " "
                            + nameEdit.getText() + " : "
                            + numberEdit.getText();

                    String fileName = "contactInfos";
                    try {
                        FileOutputStream file = openFileOutput(fileName, Context.MODE_PRIVATE);
                        file.write(contactsInfos.getBytes());
                        file.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    intent.putExtra("FILE_NAME", fileName);
                    */

                    // Q4 version
                    ContactsDatabase database = new ContactsDatabase(Main.this);

                    startActivity(intent);
                }
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
