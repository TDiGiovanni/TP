package com.tdigiovanni.tp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main extends AppCompatActivity {
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
                    intent.putExtra("CONTACT_INFOS", surnameEdit.getText() + " "
                            + nameEdit.getText() + " : "
                            + numberEdit.getText());
                    startActivity(intent);
                }
            }
        });
    }
}
