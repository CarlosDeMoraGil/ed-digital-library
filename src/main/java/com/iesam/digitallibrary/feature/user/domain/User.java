package com.iesam.digitallibrary.feature.user.domain;

import java.io.Serializable;

public class User implements Serializable {
    
    public final String id;
    public final String name;
    public final String surname;
    public final String dateBorn;
    public final String email;
    public final String address;
    public final String number;

    public User(String id, String name, String surname, String dateBorn, String email, String address, String number) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateBorn = dateBorn;
        this.email = email;
        this.address = address;
        this.number = number;
    }

    @Override
    public String toString() {
        return "User" +
                " id  = " + id + '\n' +
                " name = " + name + '\n' +
                " surname = " + surname + '\n' +
                " email = " + email + '\n' +
                " address = " + address + '\n' +
                " number = " + number + '\n';
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDateBorn() {
        return dateBorn;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getNumber() {
        return number;
    }
}
