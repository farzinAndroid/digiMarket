package com.farzin.digimarket.di.user;

import javax.inject.Inject;

public class UserProfile {

    ContactUser contactUser;

    @Inject
    public UserProfile(ContactUser contactUser) {
        this.contactUser = contactUser;
    }

    public void insertEmail(String email){
        contactUser.setEmail(email);
    }

    public String showEmail(){
        return contactUser.getEmail();
    }

    public void clearEmail(){
        contactUser.deleteEmail();
    }
}
