package com.example.sosmobileapp;

public class ContactModel {
    private String phone;
    private int contactimage;
    ContactModel(String phone,int contactimage){
        this.phone=phone;
        this.contactimage=contactimage;
    }
    public String getPhone(){
        return phone;
    }
    public int getImage(){
        return contactimage;
    }
    public void setContactimage(int contactimage){
        this.contactimage=contactimage;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
}
