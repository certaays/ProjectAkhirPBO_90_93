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
public class ViewStruck1 extends JFrame implements ActionListener{
    private JLabel lNama, lJudul, lKategori, lJenis, lHarga, lBanyak, lTotal, lPembayaran, lKembalian, isianNama, isianKategori, isianJenis, isianHarga, isianBanyak, isianTotal, isianPembayaran, isianKembalian;          
    private JButton bBack, bBuy;
    private String id_obat;

    public void ViewStruck1(String[] Data){
        //this.id_obat = data[0];
        
        setTitle("Struk");
        lJudul = new JLabel("Selamat Pembelian Berhasil!!!");
        lNama = new JLabel("Nama        : ");
        isianNama = new JLabel(Data[0]);
        lKategori = new JLabel("Kategori   : ");
        isianKategori = new JLabel(Data[1]);
        lJenis = new JLabel("Jenis        : ");
        isianJenis = new JLabel(Data[2]);        
        lHarga = new JLabel("Harga       : ");
        isianHarga = new JLabel(Data[3]);
        lBanyak = new JLabel("Banyak   :");
        isianBanyak = new JLabel(Data[4]);
        lTotal = new JLabel("Total        : ");
        isianTotal = new JLabel();
        isianTotal = new JLabel(Data[5]);
        lPembayaran = new JLabel("Bayar  :");
        isianPembayaran = new JLabel(Data[6]);
        lKembalian = new JLabel("Kembalian :");
        isianKembalian = new JLabel(Data[7]);
        bBack = new JButton("oke");
        
        setLayout(null); add(lJudul);
        add(lNama); add(isianNama);
        add(lKategori); add(isianKategori);
        add(lJenis); add(isianJenis);
        add(lHarga); add(isianHarga);
        add(lBanyak); add(isianBanyak);
        add(lTotal); add(isianTotal);
        add(lPembayaran); add(isianPembayaran);
        add(lKembalian); add(isianKembalian);
        add(bBack);         

        lJudul.setFont(new Font("", Font.BOLD, 15));
        lJudul.setBounds(40,20,300,20);
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
        lTotal.setBounds(20,210,190,20);
        isianTotal.setBounds(92,210,190,20);
        lPembayaran.setBounds(20,240,120,20);
        isianPembayaran.setBounds(92,240,120,20);
        lKembalian.setBounds(20,270,120,20);
        isianKembalian.setBounds(92,270,120,20);
        bBack.setBounds(85,320,118,20);
      
        bBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bBack.addActionListener(this);

        setSize(300,400);
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