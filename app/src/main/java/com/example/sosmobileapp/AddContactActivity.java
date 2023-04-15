package com.example.sosmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddContactActivity extends AppCompatActivity {
    EditText editTextName,editTextPhone;
    Button addContactBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        editTextName=findViewById(R.id.editTextPersonName);
        editTextPhone=findViewById(R.id.editTextPhone);
        addContactBtn=(findViewById(R.id.submitContactBtn));

        //returns instance of DB
        DatabaseHelper dbhelper=DatabaseHelper.getDB(this);

        addContactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contact newcontact=new Contact(editTextName.getText().toString(),editTextPhone.getText().toString());
                dbhelper.contactDao().insert(newcontact);
                Toast.makeText(AddContactActivity.this, " Contact Added!!", Toast.LENGTH_SHORT).show();
            }
        });


    }
}