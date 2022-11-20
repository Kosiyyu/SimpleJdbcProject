package org.example;

import org.example.database.Database;
import org.example.model.Owner;
import org.example.reposiotory.OwnerRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //TEST
        Database database = new Database();
        OwnerRepository ownerRepository = new OwnerRepository();
        ownerRepository.addOwner(new Owner("Michal", "Kowalski", "michal.kowalski@gmail.com"));
    }
}