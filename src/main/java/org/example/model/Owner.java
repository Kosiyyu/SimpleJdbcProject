package org.example.model;

import lombok.Data;


@Data
public class Owner{
    int id;
    String firstname;
    String lastname;
    String email;

    public Owner() {
    }

    public Owner(String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public Owner(int id, String firstname, String lastname, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    @Override
    public String toString() {
        return
                "{"  + id +
                ", " + firstname + '\'' +
                ", " + lastname + '\'' +
                ", " + email + '\'' +
                '}';
    }
}
