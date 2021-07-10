/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author ASUS
 */
public class ViewLogin extends JFrame implements ActionListener{
    private JLabel lMenu, lUser, lPassword;
    private JButton bLogin, bBack, bRegist; 
    private JTextField fUser;
    private JPasswordField fPassword;
    private JCheckBox check;
    
    public void ViewLogin() {
        setTitle("LOGIN");
        lMenu = new JLabel("LOGIN");
        lUser = new JLabel("Username");
        fUser = new JTextField(20);
        lPassword = new JLabel("Password");
        fPassword = new JPasswordField(20);
        bLogin = new JButton("Login");
        bBack = new JButton("Back");
        bRegist = new JButton("Regist");
        check = new JCheckBox("");
        
        setLayout(null);
        add(lMenu); add(check);
        add(lUser); add(fUser);
        add(lPassword); add(fPassword);
        add(bLogin); add(bBack); add(bRegist);

        lMenu.setFont(new Font("", Font.BOLD, 16));
        lMenu.setBounds(120,20,120,20);
        lUser.setBounds(20,50,120,20);
        fUser.setBounds(20,75,250,25);
        lPassword.setBounds(20,110,120,20);
        fPassword.setBounds(20,135,230,25);
        check.setBounds(250,135,20,25);
        bBack.setBounds(20,180,115,22);
        bLogin.setBounds(155,180,115,22);
        bRegist.setBounds(20,220,250,22);
        bLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bLogin.addActionListener(this);
        bRegist.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bRegist.addActionListener(this);
        bBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bBack.addActionListener(this);
        check.addActionListener(this);
        
        setSize(300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==check){
            JCheckBox test = (JCheckBox) e.getSource();
            fPassword.setEchoChar(test.isSelected() ? '\u0000' : (Character) UIManager.get("PasswordField.echoChar"));
        }   
        else if(e.getSource()==bLogin) {
            if (fUser.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Username harus diisi");
            }
            if (String.valueOf(fPassword.getPassword()).equals("")) {
                JOptionPane.showMessageDialog(this, "Password harus diisi");
            }
            else {
                String[] data = {
                    fUser.getText(), String.valueOf(fPassword.getPassword())
                };
                ControllerAccount login = new ControllerAccount();
                login.viewLogin(data);
                dispose();
            }
        }
        else if(e.getSource()==bBack){
            dispose();
            ControllerMenu menu = new ControllerMenu();
            menu.viewMenu3();
        }
        else if(e.getSource()==bRegist){
            dispose();
            ControllerAccount regist = new ControllerAccount();
            regist.viewRegist();
        }
    }
}
