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
public class ViewRegist extends JFrame implements ActionListener{
    private JLabel lMenu, lId, lUser, lPassword;
    private JButton bRegist, bBack, bLogin; 
    private JTextField fUser, fId;
    private JPasswordField fPassword;
    private JCheckBox check;
    
    public void ViewRegist() {
        setTitle("REGISTER");
        lMenu = new JLabel("REGISTER");
        lId = new JLabel("Id Karyawan");
        fId = new JTextField(30);
        lUser = new JLabel("Username");
        fUser = new JTextField(20);
        lPassword = new JLabel("Password");
        fPassword = new JPasswordField(20);
        fUser = new JTextField(20);
        bRegist = new JButton("Regist");
        bBack = new JButton("Back");
        bLogin = new JButton("Login");
        check = new JCheckBox("");
        
        setLayout(null);
        add(lMenu); add(check);
        add(lId); add(fId);
        add(lUser); add(fUser);
        add(lPassword); add(fPassword);
        add(bRegist); add(bBack); add(bLogin);

        lMenu.setFont(new Font("", Font.BOLD, 15));
        lMenu.setBounds(105,20,120,20);
        lId.setBounds(20,60,120,20);
        fId.setBounds(20,85,250,20);
        lUser.setBounds(20,120,120,20);
        fUser.setBounds(20,145,250,20);
        lPassword.setBounds(20,180,120,20);
        fPassword.setBounds(20,205,230,25);
        check.setBounds(250,205,20,25);
        bBack.setBounds(20,250,115,20);
        bRegist.setBounds(155,250,115,20);
        bLogin.setBounds(20,290,250,20);
       
        bLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bLogin.addActionListener(this);
        bRegist.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bRegist.addActionListener(this);
        bBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bBack.addActionListener(this);
        check.addActionListener(this);
        
        setSize(300,370);
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
        else if(e.getSource()==bRegist) {
            if (fId.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Id_karyawan harus diisi");
            }
            if (fUser.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Username harus diisi");
            }
            if (String.valueOf(fPassword.getPassword()).equals("")) {
                JOptionPane.showMessageDialog(this, "Password harus diisi");
            }
            else {
                String[] data = {
                    fId.getText() ,fUser.getText(), String.valueOf(fPassword.getPassword())
                };
                ControllerAccount regist = new ControllerAccount();
                regist.viewRegist(data);
                dispose();
            }
        }
        else if(e.getSource()==bLogin){
            ControllerAccount login = new ControllerAccount();
            login.viewLogin();
            dispose();
        }
        
        else if(e.getSource()==bBack){
            dispose();
            ControllerMenu menu = new ControllerMenu();
            menu.viewMenu3();
        }
    }
}
