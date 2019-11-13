package com.dev_mobile_av.wear_tp2;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dev_mobile_av.shared.Message;

public class SendMessageActivity extends AppCompatActivity
{
    protected EditText contentEditText;
    protected Button sendMessageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        contentEditText = findViewById(R.id.contentEditText);
        sendMessageButton = findViewById(R.id.sendMessageButton);

        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(contentEditText.getText()))
                    Toast.makeText(SendMessageActivity.this, getResources().getString(R.string.fillInfos), Toast.LENGTH_LONG).show();

                else
                {
                    Message message = new Message(contentEditText.getText().toString(),
                            0,
                            0);

                    //TODO: send message

                    Toast.makeText(SendMessageActivity.this, getResources().getString(R.string.sentMessage), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
