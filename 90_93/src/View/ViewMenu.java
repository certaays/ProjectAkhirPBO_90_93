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
public class ViewMenu extends JFrame implements ActionListener{
    private JLabel lJudul;
    private JButton bUser, bAdmin;
    
    public ViewMenu(){
       setTitle("Menu Utama");
       lJudul = new JLabel("Apotek 2021");
       bAdmin = new JButton("Admin");
       bUser = new JButton("Obat");
       setLayout(null);
       
       add(lJudul); lJudul.setHorizontalAlignment(SwingConstants.CENTER);
       add(bAdmin); add(bUser);
       
       bUser.addActionListener(this);
       bUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       bAdmin.addActionListener(this);
       bAdmin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       
       lJudul.setFont(new Font("", Font.BOLD, 15));
       lJudul.setBounds(82, 25, 120, 25);
       bAdmin.setBounds(55, 80, 180, 22);
       bUser.setBounds(55, 130, 180, 22);
       
       setSize(300,250);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setVisible(true);
       setLocationRelativeTo(null);
     
   }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bAdmin){
            ControllerMenu menu = new ControllerMenu();
            menu.viewMenu3();
            dispose();
        }
        else if(e.getSource() == bUser){
            ControllerMenu menu = new ControllerMenu();
            menu.viewMenu2();
            dispose();
        }
    }
}