package com.example.tdigiovanni.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
//import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Empty extends AppCompatActivity {

    protected Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);

        sendButton = findViewById(R.id.sendButton);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Empty.this, "Button clicked!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
