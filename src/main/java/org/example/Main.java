package org.example;

import org.example.database.Constants;
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
        database.connectToDatabase();


        OwnerRepository ownerRepository = new OwnerRepository(database);
/*        ownerRepository.addOwner(new Owner("Jan1", "Kowalski", "jan.kowalski@gmail.com"));*/


        System.out.println(ownerRepository.getAllOwners());
        System.out.println(ownerRepository.getAllOwnersSortedById());

    }
}