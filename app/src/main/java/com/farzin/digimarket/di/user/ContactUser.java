package com.farzin.digimarket.di.user;

public class ContactUser {

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void deleteEmail(){
        email = "";
    }
}
