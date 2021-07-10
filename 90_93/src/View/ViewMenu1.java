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
public class ViewMenu1 extends JFrame implements ActionListener{
    private JButton bTambah, bLihat, bBack;
    private JLabel lJudul;
    
    public ViewMenu1(){
       setTitle("Menu Admin");
       lJudul = new JLabel("Menu Admin");
       bTambah = new JButton("Tambah Obat");
       bLihat = new JButton("Lihat Obat");
       bBack = new JButton("Logout");
       setLayout(null);
       
       add(lJudul); lJudul.setHorizontalAlignment(SwingConstants.CENTER);
       add(bTambah); add(bLihat); add(bBack);
       
       bTambah.addActionListener(this);
       bTambah.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       bLihat.addActionListener(this);
       bLihat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       bBack.addActionListener(this);
       bBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       
       lJudul.setFont(new Font("", Font.BOLD, 15));
       lJudul.setBounds(82, 25, 120, 25);
       bTambah.setBounds(55, 75, 180, 22);
       bLihat.setBounds(55, 120, 180, 22);
       bBack.setBounds(55, 165, 180, 22);
       
       setSize(300,260);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setVisible(true);
       setLocationRelativeTo(null);
   }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bTambah){
            ControllerObat tambah = new ControllerObat();
            tambah.addObat();
            dispose();
        }
        else if(e.getSource() == bLihat){
            ControllerObat lihat = new ControllerObat();
            lihat.viewObatA();
            dispose();
        }
        else if(e.getSource() == bBack){
            ControllerMenu menu = new ControllerMenu();
            menu.viewMenu3();
            dispose();
        }
    }
}