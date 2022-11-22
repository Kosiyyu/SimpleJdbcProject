package org.example;

import org.example.controller.OwnerController;
import org.example.database.Constants;
import org.example.database.Database;
import org.example.model.Owner;
import org.example.reposiotory.OwnerRepository;
import org.example.view.OwnerView;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
/*        //TEST
        Database database = new Database();
        database.connectToDatabase();


        OwnerRepository ownerRepository = new OwnerRepository(database);
*//*        ownerRepository.addOwner(new Owner("Jan1", "Kowalski", "jan.kowalski@gmail.com"));*//*


        System.out.println(ownerRepository.getAllOwners());
        System.out.println(ownerRepository.getAllOwnersSortedById());
        System.out.println(ownerRepository.getOwnerById(100));
        ownerRepository.deleteOwnerById(14);
        ownerRepository.updateOwnerById(7,"AAA", "AAA", "AAA");*/

        OwnerController ownerController = new OwnerController(new Owner(), new OwnerView());

        JPanel rootPanel = ownerController.getOwnerView().getRootPanel();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {


                JFrame frame = new JFrame("FrameDemo");
                frame.setContentPane(rootPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}