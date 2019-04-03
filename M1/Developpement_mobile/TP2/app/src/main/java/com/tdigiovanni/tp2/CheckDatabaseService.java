package com.tdigiovanni.tp2;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CheckDatabaseService extends IntentService {
    public CheckDatabaseService() {
        super("CheckDatabaseService");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        // Get all contacts from file
        String fileName = intent.getStringExtra("FILE_NAME");
        ArrayList<String> allContacts = new ArrayList<>();
        try
        {
            FileInputStream file = openFileInput(fileName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file));
            allContacts.add(bufferedReader.readLine());
            file.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        ContactsDatabaseOpenHelper database = ContactsDatabaseOpenHelper.getInstance(this);

        for (String contact : allContacts)
        {
            String[] parts = contact.split("_"); // Each element is text between commas
            String name = parts[0];
            String lastName = parts[1];
            String number = parts[2];

            // Check if contacts are already in database
            if (!database.checkExistingContact(name, lastName, number))
                // Add them otherwise
                database.addContact(name,
                        lastName,
                        number);
        }
    }
}
