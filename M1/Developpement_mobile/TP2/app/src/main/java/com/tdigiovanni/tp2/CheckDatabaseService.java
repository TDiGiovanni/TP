package com.tdigiovanni.tp2;

import android.app.IntentService;
import android.app.Service;
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
        ArrayList<String> allContacts = new ArrayList<String>();
        try {
            FileInputStream file = openFileInput(fileName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file));
            allContacts.add(bufferedReader.readLine());
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        for (String contact : allContacts)
        {
            // Check if contacts are already in database
            //if (!checkExistingContact())
                // Add them otherwise
                ContactsDatabaseOpenHelper database = ContactsDatabaseOpenHelper.getInstance(this);
                database.addContact(
                        intent.getStringExtra("CONTACT_NAME"),
                        intent.getStringExtra("CONTACT_LAST_NAME"),
                        intent.getStringExtra("CONTACT_NUMBER"));
        }
    }
}
