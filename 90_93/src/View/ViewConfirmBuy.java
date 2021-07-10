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
public class ViewConfirmBuy extends JFrame implements ActionListener{
    private JLabel lJudul, lCash, lNama, lKategori, lJenis, lHarga, lBanyak, lTotal, isianNama, isianKategori, isianJenis, isianHarga, isianBanyak, isianTotal;          
    private JButton bBack, bBuy;
    private JTextField fCash;
    private String id;
    int banyak, harga, total;
    String[] Data;
    
    public void ViewConfirmBuy(String[] data){
        this.id = data[0];
        System.out.println(data[0]);
        Data=data;
      
        setTitle("Data Obat : "+data[1]);
        lJudul = new JLabel("Konfirmasi Pembelian");
        lNama = new JLabel("Nama        : ");
        isianNama = new JLabel(data[1]);
        lKategori = new JLabel("Kategori   : ");
        isianKategori = new JLabel(data[2]);
        lJenis = new JLabel("Jenis        : ");
        isianJenis = new JLabel(data[3]);        
        lHarga = new JLabel("Harga       : ");
        isianHarga = new JLabel(data[4]);
        lBanyak = new JLabel("Banyak   :");
        isianBanyak = new JLabel(data[5]);
        lTotal = new JLabel("Total        : ");
        harga = Integer.parseInt(data[4]);
        banyak = Integer.parseInt(data[5]);
        total = harga*banyak;
        String Total = String.valueOf(total);
        isianTotal = new JLabel(Total);
        lCash = new JLabel("Bayar       :");
        fCash = new JTextField(10);
        
        bBack = new JButton("Back");
        bBuy = new JButton("Buy");
        
        setLayout(null); add(lJudul);
        add(lNama); add(isianNama);
        add(lKategori); add(isianKategori);
        add(lJenis); add(isianJenis);
        add(lHarga); add(isianHarga);
        add(lBanyak); add(isianBanyak);
        add(lTotal); add(isianTotal); 
        add(lCash); add(fCash);
        add(bBack); add(bBuy);        

        lJudul.setFont(new Font("", Font.BOLD, 15));
        lJudul.setBounds(70,20,200,20);
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
        lCash.setBounds(20,240,120,20);
        fCash.setBounds(92,240,120,20);
        bBuy.setBounds(150,300,118,20);
        bBack.setBounds(20,300,118,20);
        
        bBuy.addActionListener(this);
        bBuy.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bBack.addActionListener(this);
        bBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        setSize(300,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bBack){
            String[] data = {
                id, isianNama.getText() , isianKategori.getText(), isianJenis.getText(), isianHarga.getText(), isianBanyak.getText()
            };
            ControllerTransaction transaksi = new ControllerTransaction(); 
            transaksi.viewBuy(data);
            dispose();
        }
        else if(e.getSource()==bBuy){
            if (fCash.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Anda harus Membayar!!");
            }
            else{
                try{
                    if(Integer.valueOf(fCash.getText())<0){
                        JOptionPane.showMessageDialog(this, "Anda tidak bisa mengutang!");
                    } else{
                        OptDialog();
                    }
                } catch(NumberFormatException error){
                    JOptionPane.showMessageDialog(this, "Uang harus angka!");
                }
            }
        }
    }
    
    public void OptDialog(){
        int check = JOptionPane.showOptionDialog(this, "Yakin ingin membeli?", "Hapus", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        if(check==0){
            int eq;
            eq = Integer.parseInt(fCash.getText());
            int a = eq-total;
            if(eq<total){
                
                JOptionPane.showMessageDialog(this, "Uang Anda Kurang!!");
                ControllerTransaction transaksi = new ControllerTransaction(); 
                transaksi.viewConfirm(Data);
            dispose();
            }
            else if(eq>=total){
                if(eq==total){JOptionPane.showMessageDialog(this, "Pembelian berhasil, uang anda pas!!");}
                else if(eq>total){JOptionPane.showMessageDialog(this, "Pembelian berhasil, Kembalian Anda adalah Rp. "+a+" !!");}
                String[] data = {
                    id, isianBanyak.getText()
                };
                ControllerTransaction transaksi = new ControllerTransaction();
                transaksi.transaction(data);
                dispose();

                String[] Data = {
                    isianNama.getText(),isianKategori.getText(),isianJenis.getText(),isianHarga.getText(),isianBanyak.getText(), String.valueOf(total), String.valueOf(eq), String.valueOf(a)
                };
                dispose();
                ControllerTransaction struck = new ControllerTransaction();
                struck.viewStruck(Data);
            }
            
        }
    }  
}
