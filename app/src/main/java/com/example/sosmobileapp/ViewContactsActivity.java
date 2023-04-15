package com.example.sosmobileapp;

import static com.google.android.material.internal.ContextUtils.getActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ViewContactsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Contact> contacts;
    List<ContactModel> contactModels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contacts);
        recyclerView=findViewById(R.id.contactsRV);
        //get database instance
        DatabaseHelper dbhelper=DatabaseHelper.getDB(this);

        //get all contacts stored in room database
        contacts=dbhelper.contactDao().getAllContacts();
        contactModels=new ArrayList<ContactModel>();

        //add contacts to contact model arraylist
        for(int i=0;i<contacts.size();i++){
            Contact currentContact=contacts.get(i);
            contactModels.add(new ContactModel(currentContact.getPhone(),R.drawable.baseline_delete_24));
        }

        ContactAdapter adapter=new ContactAdapter(getApplicationContext(),contactModels);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

    }

}