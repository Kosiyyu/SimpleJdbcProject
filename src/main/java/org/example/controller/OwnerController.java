package org.example.controller;

import lombok.Data;
import org.example.model.Owner;
import org.example.view.OwnerView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

@Data
public class OwnerController {
    private Owner owner;
    private OwnerView ownerView;

    public OwnerController() {

    }

    public OwnerController(Owner owner, OwnerView ownerView) {
        this.owner = owner;
        this.ownerView = ownerView;

        initButtonsListeners();
    }

    public void initButtonsListeners(){
        ownerView.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ownerView.getFirstnameTextField().setText("leleleelle");
            }
        });
    }
}
