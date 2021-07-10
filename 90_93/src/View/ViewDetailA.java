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
public class ViewDetailA extends JFrame implements ActionListener{
    private JLabel lNama, lKategori, lJenis, lHarga, lBanyak, lJudul, isianNama, isianKategori, isianJenis, isianHarga;          
    private JButton bUpdate, bDelete, bBack, bTotal;
    private JTextField fBanyak;
    private String id;

    public void openDetail(String[] data){
        this.id = data[0];
       
        setTitle("Data Obat Apoteker");
        lJudul = new JLabel("Informasi Obat");
        lNama = new JLabel("Nama        : ");
        isianNama = new JLabel(data[1]);
        lKategori = new JLabel("Kategori   : ");
        isianKategori = new JLabel(data[2]);
        lJenis = new JLabel("Jenis        : ");
        isianJenis = new JLabel(data[3]);        
        lHarga = new JLabel("Harga       : ");
        isianHarga = new JLabel(data[4]);
        
        bUpdate = new JButton("Edit");
        bDelete = new JButton("Delete");
        bBack = new JButton("Back");
        
        setLayout(null); add(lJudul);
        add(lNama); add(isianNama);
        add(lKategori); add(isianKategori);
        add(lJenis); add(isianJenis);
        add(lHarga); add(isianHarga);
        add(bUpdate); add(bDelete);
        add(bBack); 

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
        bUpdate.setBounds(20,195,118,20);
        bDelete.setBounds(150,195,118,20);
        bBack.setBounds(20,235,250,20);
        
        bBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bBack.addActionListener(this);
        bUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bUpdate.addActionListener(this);
        bDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bDelete.addActionListener(this);

        setSize(300,320);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {   
        if(e.getSource()==bUpdate){
            ControllerObat update = new ControllerObat();
            update.updateObat(id);
            dispose();
        }
        else if(e.getSource()==bDelete){
            OptDialog();
        }
        else if(e.getSource()==bBack){
            ControllerObat menu = new ControllerObat();
            menu.viewObatA();
            dispose();
        }
    }
    
    public void OptDialog(){
        int check = JOptionPane.showOptionDialog(this, "Yakin ingin menghapus?", "Hapus", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        if(check==0){
            ControllerObat delete = new ControllerObat();
            delete.deleteObat(id);
            dispose();
            ControllerObat back = new ControllerObat();
            back.viewObatA();
        }
    }    
    
}
