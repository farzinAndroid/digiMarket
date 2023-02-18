package com.farzin.digimarket.di.test;

public class User {

    public Contacts contacts;
    public User(Contacts contacts) {

        this.contacts = contacts;

        //first way
        //contacts = new CustomeContact();
        //contacts = new SimpleContact();

    }
}
