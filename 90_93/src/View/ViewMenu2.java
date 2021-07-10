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
public class ViewMenu2 extends JFrame implements ActionListener{
    private JButton bBuy, bHistory, bBack;
    private JLabel lJudul;
    
    public ViewMenu2(){
       setTitle("Layanan Apotek 2021");
       lJudul = new JLabel("Apotek 2021");
       bBuy = new JButton("Daftar Obat");
       bHistory = new JButton("Riwayat Pembelian Obat");
       bBack = new JButton("Back");
       setLayout(null);
       
       add(lJudul);
       lJudul.setHorizontalAlignment(SwingConstants.CENTER);
       add(bBuy);
       add(bHistory);
       add(bBack);
       
       bBuy.addActionListener(this);
       bHistory.addActionListener(this);
       bBack.addActionListener(this);
       bBuy.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       bHistory.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       bBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       
       lJudul.setFont(new Font("", Font.BOLD, 15));
       lJudul.setBounds(55, 25, 180, 25);
       bBuy.setBounds(55, 75, 180, 22);
       bHistory.setBounds(55, 120, 180, 22);
       bBack.setBounds(55, 165, 180, 22);
       
       setSize(300,260);setDefaultCloseOperation(EXIT_ON_CLOSE);
       setVisible(true);
       setLocationRelativeTo(null);
   }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bBuy){
            ControllerObat lihat = new ControllerObat();
            lihat.viewObat();
            dispose();
        }
        else if(e.getSource() == bHistory){
            ControllerTransaction lihat = new ControllerTransaction();
            lihat.viewHistory();
            dispose();
        }
        else if(e.getSource() == bBack){
            ControllerMenu menu = new ControllerMenu();
            menu.viewMenu();
            dispose();
        }
    }
}

