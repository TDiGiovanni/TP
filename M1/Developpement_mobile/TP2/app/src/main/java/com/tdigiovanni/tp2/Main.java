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

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main extends AppCompatActivity {
    private ArrayList<String> contactsInfos = new ArrayList<String>(); // Q1 only

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

                    /* Q1 only*/
                    contactsInfos.add(surnameEdit.getText() + " "
                            + nameEdit.getText() + " : "
                            + numberEdit.getText());

                    intent.putStringArrayListExtra("CONTACT_INFOS", contactsInfos);

                    /*
                    String contactInfos = surnameEdit.getText() + " "
                            + nameEdit.getText() + " : "
                            + numberEdit.getText();

                    String fileName = "contactInfos";
                    FileOutputStream file = openFileOutput(fileName, Context.MODE_PRIVATE);
                    file.write(contactsInfos);
                    file.close();


                    intent.putExtra("FILE_NAME", fileName);
                    */
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        if (!savedInstanceState.containsKey("NUMBER_CALLS"))
            savedInstanceState.putInt("NUMBER_CALLS", 1);

        else
            savedInstanceState.putInt("NUMBER_CALLS", savedInstanceState.getInt("NUMBER_CALLS") + 1);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        int numberCalls = savedInstanceState.getInt("NUMBER_CALLS");
        Toast.makeText(this, "Number of calls: " + numberCalls, Toast.LENGTH_SHORT).show();
    }
}
