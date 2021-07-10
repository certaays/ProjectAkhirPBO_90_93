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
public class ViewMenu3 extends JFrame implements ActionListener{
    private final JLabel lJudul;
    private final JButton bLogin, bRegister, bBack;
    
    public ViewMenu3(){
       setTitle("Menu Admin");
       lJudul = new JLabel("Welcome Admin!");
       bRegister = new JButton("Register");
       bLogin = new JButton("Login");
       bBack = new JButton("Back");
       setLayout(null);
       
       add(lJudul);
       lJudul.setHorizontalAlignment(SwingConstants.CENTER);
       add(bRegister);
       add(bLogin);
       add(bBack);
       
       bLogin.addActionListener(this);
       bRegister.addActionListener(this);
       bBack.addActionListener(this);
       bRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       bLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       bBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      
       lJudul.setFont(new Font("", Font.BOLD, 15));
       lJudul.setBounds(55, 25, 180, 25);
       bRegister.setBounds(55, 75, 180, 22);
       bLogin.setBounds(55, 120, 180, 22);
       bBack.setBounds(55, 165, 180, 22);
       
       setSize(300,260);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setVisible(true);
       setLocationRelativeTo(null);
     
   }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bRegister){
            ControllerAccount regist = new ControllerAccount();
            regist.viewRegist();
            dispose();
        }
        else if(e.getSource() == bLogin){
            ControllerAccount login = new ControllerAccount();
            login.viewLogin();
            dispose();
        }
        else if(e.getSource()==bBack){
            dispose();
            ControllerMenu menu = new ControllerMenu();
            menu.viewMenu();
        }
    }
}
