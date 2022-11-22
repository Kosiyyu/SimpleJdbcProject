package org.example.view;

import lombok.Data;

import javax.swing.*;


@Data
public class OwnerView {
    private JPanel rootPanel;
    private JTextField firstnameTextField;
    private JTextField lastnameTextField;
    private JTextField emailTextField;
    private JTable ownerTable;
    private JButton addButton;
    private JButton readButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JComboBox sortComboBox;
    private JLabel firstnameJLabel;
    private JLabel lastnameJLabel;
    private JLabel emailJLabel;
    private JPanel labelPanel;
    private JPanel inputPanel;
    private JPanel tablePanel;
    private JPanel buttonPanel;
}
