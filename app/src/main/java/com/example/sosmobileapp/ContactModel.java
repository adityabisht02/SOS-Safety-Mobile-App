package com.example.sosmobileapp;

public class ContactModel {
    private String phone;
    private int deleteimage;
    ContactModel(String phone,int deleteimage){
        this.phone=phone;
        this.deleteimage=deleteimage;
    }
    public String getPhone(){
        return phone;
    }
    public int getImage(){
        return deleteimage;
    }
    public void setContactimage(int deleteimage){
        this.deleteimage=deleteimage;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
}
