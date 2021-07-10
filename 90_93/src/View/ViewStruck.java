/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerTransaction;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author ASUS
 */
public class ViewStruck extends JFrame implements ActionListener{
    private JLabel lNama, lKategori, lJudul, lJenis, lHarga, lBanyak, lTotal, isianNama, isianKategori, isianJenis, isianHarga, isianBanyak, isianTotal;          
    private JButton bBack;
    private String kode;

    public void ViewStruck(String id, String[] data){
        kode = id;
       
        setTitle("Pembelian ke - "+id+" ");
        lJudul = new JLabel("Pembelian ke - "+id+" ");
        lNama = new JLabel("Nama : ");
        isianNama = new JLabel(data[0]);
        lKategori = new JLabel("Kategori : ");
        isianKategori = new JLabel(data[1]);
        lJenis = new JLabel("Jenis : ");
        isianJenis = new JLabel(data[2]);        
        lHarga = new JLabel("Harga : ");
        isianHarga = new JLabel(data[3]);
        lBanyak = new JLabel("Banyak : ");
        isianBanyak = new JLabel(data[4]);
        
        bBack = new JButton("Back");
        
        setLayout(null); add(lJudul);
        add(lNama); add(isianNama);
        add(lKategori); add(isianKategori);
        add(lJenis); add(isianJenis);
        add(lHarga); add(isianHarga);
        add(lBanyak); add(isianBanyak);
        add(bBack); 
        
        lJudul.setFont(new Font("", Font.BOLD, 13));
        lJudul.setBounds(85,20,120,20);
        lNama.setBounds(20,60,120,20);
        isianNama.setBounds(92,60,190,20);
        lKategori.setBounds(20,90,120,20);
        isianKategori.setBounds(92,90,190,20);
        lJenis.setBounds(20,120,120,20);
        isianJenis.setBounds(92,120,190,20);
        lHarga.setBounds(20,150,120,20);
        isianHarga.setBounds(92,150,190,20);
        lBanyak.setBounds(20,180,60,20);
        isianBanyak.setBounds(92,180,60,20);
        bBack.setBounds(90,250,118,20);
        
        bBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bBack.addActionListener(this);
       
        setSize(300,330);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bBack){
            ControllerTransaction lihat = new ControllerTransaction();
            lihat.viewHistory();
            dispose();
        }
    }
}