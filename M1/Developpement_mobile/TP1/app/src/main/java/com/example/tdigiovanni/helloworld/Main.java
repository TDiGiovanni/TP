package com.example.tdigiovanni.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main extends AppCompatActivity {

    //private static final int ACTIVITY_CODE = 1;
    protected EditText phoneEdit;
    protected Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneEdit = findViewById(R.id.phone);

        sendButton = findViewById(R.id.sendButton);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(Main.this, "@string/click", Toast.LENGTH_LONG).show();

                /*
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = inflater.inflate(R.layout.popup_confirmation, null);
                PopupWindow popupWindow = new PopupWindow(popupView);
                popupWindow.showAtLocation(view, CENTER, 0, 0);
                */

                Intent intent = new Intent(Main.this, Empty.class);
                intent.putExtra("Phone number", phoneEdit.getText().toString());
                startActivity(intent);
            }
        });
    }
}
