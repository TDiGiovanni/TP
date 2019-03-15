package com.tdigiovanni.tp2;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class Contacts extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        ListView contactsList = findViewById(R.id.contactsList);

        /* Q1 version
        ArrayList<String> contactsInfos = getIntent().getStringArrayListExtra("CONTACT_INFOS");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contactsInfos);
        */

        /* Q3 version
        String fileName = getIntent().getStringExtra("FILE_NAME");
        ArrayList<String> contactsInfos = new ArrayList<String>();
        try {
            FileInputStream file = openFileInput(fileName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file));
            contactsInfos.add(bufferedReader.readLine());
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contactsInfos);
        */

        // Q4 version
        ContactsDatabaseOpenHelper database = ContactsDatabaseOpenHelper.getInstance(this);
        Cursor cursor = database.getAllContacts();
        String[] fromColumns = {
                ContactsDatabaseOpenHelper.COLUMN_NAME,
                ContactsDatabaseOpenHelper.COLUMN_LAST_NAME,
                ContactsDatabaseOpenHelper.COLUMN_NUMBER
        };
        int[] toViews = {android.R.id.text1};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, fromColumns, toViews, 0);
        adapter.setViewBinder(new SimpleCursorAdapter.ViewBinder() {
            public boolean setViewValue(View view, Cursor cursor, int columnIndex) {
                ((TextView) view).setText(
                        new StringBuilder()
                                .append(cursor.getString(cursor.getColumnIndex(ContactsDatabaseOpenHelper.COLUMN_NAME)))
                                .append(" ")
                                .append(cursor.getString(cursor.getColumnIndex(ContactsDatabaseOpenHelper.COLUMN_LAST_NAME)))
                                .append(" : ")
                                .append(cursor.getString(cursor.getColumnIndex(ContactsDatabaseOpenHelper.COLUMN_NUMBER)))
                                .toString()
                );

                return true;
            }
        });

        contactsList.setAdapter(adapter);
    }
}
