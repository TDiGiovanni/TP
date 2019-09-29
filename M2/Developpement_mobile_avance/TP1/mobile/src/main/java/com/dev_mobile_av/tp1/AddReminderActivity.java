package com.dev_mobile_av.tp1;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AddReminderActivity extends AppCompatActivity
{
    protected ArrayList<Reminder> reminders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reminder);

        final EditText timeEditText = findViewById(R.id.timeEditText);
        final EditText dateEditText = findViewById(R.id.dateEditText);
        final Spinner typeSpinner = findViewById(R.id.typeSpinner);
        final EditText titleEditText = findViewById(R.id.titleEditText);
        final EditText descriptionEditText = findViewById(R.id.descriptionEditText);
        Button addReminderButton = findViewById(R.id.addReminderButton);
        Button showRemindersButton = findViewById(R.id.showRemindersButton);
        Button clearRemindersButton = findViewById(R.id.clearRemindersButton);

        reminders = new ArrayList<>();

        typeSpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ReminderType.values()));

        addReminderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(timeEditText.getText())
                        || TextUtils.isEmpty(dateEditText.getText())
                        || TextUtils.isEmpty(titleEditText.getText())
                        || TextUtils.isEmpty(descriptionEditText.getText()))
                    Toast.makeText(AddReminderActivity.this, "You must fill out all the informations", Toast.LENGTH_SHORT).show();

                else
                {
                    Reminder reminder = new Reminder(timeEditText.getText().toString(),
                            dateEditText.getText().toString(),
                            typeSpinner.getSelectedItem().toString(),
                            titleEditText.getText().toString(),
                            descriptionEditText.getText().toString());

                    reminders.add(reminder);
                }
            }
        });

        showRemindersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddReminderActivity.this, ShowRemindersActivity.class);
                intent.putExtra("ReminderList", reminders);
                startActivity(intent);
            }
        });

        clearRemindersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reminders.clear();
            }
        });
    }
}
