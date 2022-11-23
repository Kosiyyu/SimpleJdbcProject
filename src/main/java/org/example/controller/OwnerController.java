package org.example.controller;

import lombok.Data;
import org.example.model.Owner;
import org.example.reposiotory.OwnerRepository;
import org.example.view.OwnerView;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.util.List;

@Data
public class OwnerController {
    private Owner owner;
    private OwnerView ownerView;
    private OwnerRepository ownerRepository;

    public OwnerController() {

    }

    public OwnerController(Owner owner, OwnerView ownerView, OwnerRepository ownerRepository) {
        this.owner = owner;
        this.ownerView = ownerView;
        this.ownerRepository = ownerRepository;

        addButtonListener();
        deleteButtonListener();
        updateButtonListener();
        getReadButtonListener();
    }

    public void addButtonListener(){
        ownerView.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstname = ownerView.getFirstnameTextField().getText();
                String lastname = ownerView.getLastnameTextField().getText();
                String email = ownerView.getEmailTextField().getText();
                ownerRepository.addOwner(new Owner(firstname, lastname, email));
                clearInputFields();
                resetTable();
            }
        });
    }

    public void deleteButtonListener(){
        ownerView.getDeleteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowId = ownerView.getOwnerTable().getSelectedRow();
                int ownerId = Integer.parseInt(ownerView.getOwnerTable().getValueAt(rowId, 3).toString());
                ownerRepository.deleteOwnerById(ownerId);
                clearInputFields();
                resetTable();
            }
        });
    }

    public void updateButtonListener(){
        ownerView.getUpdateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstname = ownerView.getFirstnameTextField().getText();
                String lastname = ownerView.getLastnameTextField().getText();
                String email = ownerView.getEmailTextField().getText();
                int rowId = ownerView.getOwnerTable().getSelectedRow();
                int ownerId = Integer.parseInt(ownerView.getOwnerTable().getValueAt(rowId, 3).toString());
                ownerRepository.updateOwnerById(ownerId, firstname, lastname, email);
                clearInputFields();
                resetTable();
            }
        });
    }

    public void getReadButtonListener(){
        ownerView.getReadButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowId = ownerView.getOwnerTable().getSelectedRow();
                int ownerId = Integer.parseInt(ownerView.getOwnerTable().getValueAt(rowId, 3).toString());
                Owner owner = ownerRepository.getOwnerById(ownerId);
                ownerView.getFirstnameTextField().setText(owner.getFirstname());
                ownerView.getLastnameTextField().setText(owner.getLastname());
                ownerView.getEmailTextField().setText(owner.getEmail());
            }
        });
    }

    public void clearInputFields(){
        ownerView.getFirstnameTextField().setText("");
        ownerView.getLastnameTextField().setText("");
        ownerView.getEmailTextField().setText("");
    }

    public void resetTable(){
        DefaultTableModel tableModel = (DefaultTableModel) ownerView.getOwnerTable().getModel();
        tableModel.setRowCount(0);
        List<Owner> owners = ownerRepository.getAllOwnersSortedById();
        for(Owner owner : owners){
            tableModel.addRow(new Object[]{owner.getFirstname(), owner.getLastname(), owner.getEmail(), owner.getId()});
        }
    }


}
