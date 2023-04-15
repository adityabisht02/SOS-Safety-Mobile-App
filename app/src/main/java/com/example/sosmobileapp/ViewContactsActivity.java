package com.example.sosmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class ViewContactsActivity extends AppCompatActivity {

    TextView heading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contacts);
        heading=findViewById(R.id.textView17);

        //get database instance
        DatabaseHelper dbhelper=DatabaseHelper.getDB(this);

        List<Contact> contacts=dbhelper.contactDao().getAllContacts();

        //loop through contacts and send sms
        for(int i=0;i<contacts.size();i++){

        }

        heading.setText(contacts.get(0).getPhone());
    }
}