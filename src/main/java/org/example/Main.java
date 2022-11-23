package org.example;

import org.example.controller.OwnerController;
import org.example.database.Constants;
import org.example.database.Database;
import org.example.model.Owner;
import org.example.reposiotory.OwnerRepository;
import org.example.view.OwnerView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel"); //Windows Look and feel
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {

        }


        Database database = new Database();
        database.connectToDatabase();
        OwnerController ownerController = new OwnerController(new Owner(), new OwnerView(), new OwnerRepository(database));
        JPanel rootPanel = ownerController.getOwnerView().getRootPanel();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("FrameDemo");

                frame.addWindowListener(new WindowListener() {
                    @Override
                    public void windowOpened(WindowEvent e) {
                        String[] columnNames = {"Firstname", "Lastname", "Email", "Id"};

                        database.connectToDatabase();

                        List<Owner> owners = ownerController.getOwnerRepository().getAllOwnersSortedById();

                        //setting table model
                        DefaultTableModel tableModel = new DefaultTableModel(null, columnNames);
                        ownerController.getOwnerView().getOwnerTable().setModel(tableModel);
                        //

                        //hiding id column
                        //TableColumnModel columnModel = ownerController.getOwnerView().getOwnerTable().getColumnModel();
                        //columnModel.removeColumn(columnModel.getColumn(3));
                        //

                        //inserting data to table
                        for(Owner owner : owners){
                            tableModel.addRow(new Object[]{owner.getFirstname(), owner.getLastname(), owner.getEmail(), owner.getId()});
                        }
                        //
                    }
                    @Override
                    public void windowClosing(WindowEvent e) {
                        //here closing db
                    }

                    @Override
                    public void windowClosed(WindowEvent e) {

                    }

                    @Override
                    public void windowIconified(WindowEvent e) {

                    }

                    @Override
                    public void windowDeiconified(WindowEvent e) {

                    }

                    @Override
                    public void windowActivated(WindowEvent e) {

                    }

                    @Override
                    public void windowDeactivated(WindowEvent e) {

                    }
                });
                frame.setContentPane(rootPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setPreferredSize(new Dimension(500, 600));
                frame.setResizable(false);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}