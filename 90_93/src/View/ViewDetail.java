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
public class ViewDetail extends JFrame implements ActionListener {
    private JLabel lJudul, lNama, lKategori, lJenis, lHarga, lBanyak, isianNama, isianKategori, isianJenis, isianHarga;          
    private JButton bBack, bBuy;
    private JTextField fBanyak;
    private String id;

    public void openDetail(String[] data){
        this.id = data[0];
        setTitle(data[1]);
       
        setTitle("Data Obat");
        lJudul = new JLabel("Informasi Obat");
        lNama = new JLabel("Nama        : ");
        isianNama = new JLabel(data[1]);
        lKategori = new JLabel("Kategori   : ");
        isianKategori = new JLabel(data[2]);
        lJenis = new JLabel("Jenis        : ");
        isianJenis = new JLabel(data[3]);        
        lHarga = new JLabel("Harga       : ");
        isianHarga = new JLabel(data[4]);
      
        bBack = new JButton("Back");
        bBuy = new JButton("Buy");
        
        setLayout(null); add(lJudul);
        add(lNama); add(isianNama);
        add(lKategori); add(isianKategori);
        add(lJenis); add(isianJenis);
        add(lHarga); add(isianHarga);
        add(bBack); add(bBuy);        

        lJudul.setFont(new Font("", Font.BOLD, 15));
        lJudul.setBounds(90,20,120,20);
        lNama.setBounds(20,60,120,20);
        isianNama.setBounds(92,60,190,20);
        lKategori.setBounds(20,90,120,20);
        isianKategori.setBounds(92,90,190,20);
        lJenis.setBounds(20,120,120,20);
        isianJenis.setBounds(92,120,190,20);
        lHarga.setBounds(20,150,120,20);
        isianHarga.setBounds(92,150,190,20);
        bBuy.setBounds(150,195,118,20);
        bBack.setBounds(20,195,118,20);
        
        bBuy.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bBuy.addActionListener(this);
        bBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bBack.addActionListener(this);

        setSize(300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bBack){
            ControllerObat menu = new ControllerObat();
            menu.viewObat();
            dispose();
        }
        else if(e.getSource()==bBuy){
            String[] data = {
                id, isianNama.getText() , isianKategori.getText(), isianJenis.getText(), isianHarga.getText(), ""
            };
            ControllerTransaction transaksi = new ControllerTransaction(); 
            transaksi.viewBuy(data);
            dispose();
        }
    }
    
}   
