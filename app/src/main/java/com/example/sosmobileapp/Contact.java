package com.example.sosmobileapp;


import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.PrimaryKey;

@Entity(tableName = "contacts")
    public class Contact {
    @PrimaryKey(autoGenerate = true)
    public int id;

        @ColumnInfo(name = "name")
        public String name;

    @ColumnInfo(name = "phone")
        public String phone;

     Contact(String name, String phone) {

        this.name=name;
        this.phone=phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

