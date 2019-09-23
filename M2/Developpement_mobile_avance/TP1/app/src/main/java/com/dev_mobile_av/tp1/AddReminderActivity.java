package com.dev_mobile_av.tp1;

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
import java.io.PrintWriter;

public class AddReminderActivity extends AppCompatActivity
{
    private final static String FILE_NAME = "reminderInfos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reminder);

        final EditText timeEditText = findViewById(R.id.timeEditText);
        final EditText dateEditText = findViewById(R.id.dateEditText);
        final EditText typeEditText = findViewById(R.id.typeEditText);
        final EditText titleEditText = findViewById(R.id.titleEditText);
        final EditText descriptionEditText = findViewById(R.id.descriptionEditText);
        Button addReminderButton = findViewById(R.id.addReminderButton);
        Button showRemindersButton = findViewById(R.id.showRemindersButton);
        Button clearRemindersButton = findViewById(R.id.clearRemindersButton);

        addReminderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(timeEditText.getText())
                        || TextUtils.isEmpty(dateEditText.getText())
                        || TextUtils.isEmpty(typeEditText.getText())
                        || TextUtils.isEmpty(titleEditText.getText())
                        || TextUtils.isEmpty(descriptionEditText.getText()))
                    Toast.makeText(AddReminderActivity.this, "You must fill out all the informations", Toast.LENGTH_SHORT).show();

                else
                    {
                    Reminder reminder = new Reminder(timeEditText.getText().toString(),
                            dateEditText.getText().toString(),
                            typeEditText.getText().toString(),
                            titleEditText.getText().toString(),
                            descriptionEditText.getText().toString());

                    try
                    {
                        FileOutputStream file = openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
                        file.write(reminder.toString().getBytes());
                        file.close();
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        });

        showRemindersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddReminderActivity.this, showRemindersActivity.class);
                intent.putExtra("FILE_NAME", FILE_NAME);
                startActivity(intent);
            }
        });

        clearRemindersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try
                {
                    FileOutputStream file = new FileOutputStream(FILE_NAME, false);
                    file.write("".getBytes());
                    file.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
}
