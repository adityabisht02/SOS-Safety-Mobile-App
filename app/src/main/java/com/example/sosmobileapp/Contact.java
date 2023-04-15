package com.example.sosmobileapp;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "contacts")
    public class Contact {
        @ColumnInfo(name = "name")
        public String name;

        @ColumnInfo(name = "phone")
        public String phone;
    }

