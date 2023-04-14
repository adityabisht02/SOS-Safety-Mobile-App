package com.example.sosmobileapp.ui.settings;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


import com.example.sosmobileapp.AddContactActivity;
import com.example.sosmobileapp.EditSOSMessageActivity;
import com.example.sosmobileapp.R;
import com.example.sosmobileapp.ViewContactsActivity;


public class SettingsFragment extends Fragment {

    LinearLayout editSOSMessage,deleteContacts, viewContacts, addContact;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editSOSMessage=view.findViewById(R.id.editSOSMessageBtn);
        deleteContacts=view.findViewById(R.id.deleteContactBtn);
        addContact=view.findViewById(R.id.addContactBtn);
        viewContacts=view.findViewById(R.id.viewContactsBtn);

        editSOSMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), EditSOSMessageActivity.class);
                startActivity(intent);

            }
        });

        deleteContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), ViewContactsActivity.class);
                startActivity(intent);

            }
        });

        viewContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), ViewContactsActivity.class);
                startActivity(intent);

            }
        });

        addContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), AddContactActivity.class);
                startActivity(intent);

            }
        });



    }
}