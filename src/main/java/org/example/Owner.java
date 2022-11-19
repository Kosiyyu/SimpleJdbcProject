package org.example;

public class Owner {
    int id;
    String firstname;
    String lastname;
    String email;

    public Owner() {
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
