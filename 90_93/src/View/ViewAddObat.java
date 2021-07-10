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
public class ViewAddObat extends JFrame implements ActionListener {
    private JLabel lMenu, lNama, lkategori, ljenis, lHarga;
    private JButton bSubmit, bReset, bBack; 
    private JTextField fNama, fHarga;
    private JComboBox ckategori, cjenis;
    
    public void ViewAdd() {
        setTitle("Input Barang");
        lMenu = new JLabel("Input Obat");
        lNama = new JLabel("Nama Obat");
        fNama = new JTextField(20);
        lkategori = new JLabel("Kategori Obat");
        String kategori[]={"Obat Dalam","Obat Luar"};        
        ckategori = new JComboBox(kategori);  
        ljenis = new JLabel("Jenis Obat");
        String jenis[]={"Kapsul","Tablet","Sirup","Salep","Kaplet","Cairan"};
        cjenis = new JComboBox(jenis);  
        lHarga = new JLabel("Harga");
        fHarga = new JTextField(15);
        bSubmit = new JButton("Submit");
        bReset = new JButton("Reset");
        bBack = new JButton("Back");        
        
        setLayout(null);
        add(lMenu); add(lNama); add(fNama);
        add(ljenis); add(cjenis);
        add(lkategori); add(ckategori);
        add(lHarga); add(fHarga);
        add(bSubmit); add(bReset); add(bBack);

        
        lMenu.setFont(new Font("", Font.BOLD, 15));
        lMenu.setBounds(105,20,120,20);
        lNama.setBounds(20,55,120,22);
        fNama.setBounds(20,80,250,22);
        lkategori.setBounds(20,110,120,22);
        ckategori.setBounds(20,135,250,22);
        ljenis.setBounds(20,165,120,22);
        cjenis.setBounds(20,190,250,22);
        lHarga.setBounds(20,220,120,22);
        fHarga.setBounds(20,245,250,22);
        bSubmit.setBounds(20,290,120,22);
        bReset.setBounds(150,290,120,22);
        bBack.setBounds(20,335,250,22);

        ckategori.setBackground(Color.white);
        cjenis.setBackground(Color.white);
        bSubmit.addActionListener(this);
        bSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bReset.addActionListener(this);
        bReset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bBack.addActionListener(this);
        bBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        setSize(300,415);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bSubmit) {
            if ( fNama.getText().equals("") || fHarga.getText().equals("") ) {
                if ( fNama.getText().equals("") ) {
                JOptionPane.showMessageDialog(this, "Nama harus diisi");
                }
                if ( fHarga.getText().equals("") ) {
                JOptionPane.showMessageDialog(this, "Harga harus diisi");
                }
            }
            else {
                try{
                    if(Integer.valueOf(fHarga.getText())<0){
                        JOptionPane.showMessageDialog(this, "Harga harus positif");
                    } 
                    else{
                        String[] data = {
                            fNama.getText(), ckategori.getSelectedItem().toString(), cjenis.getSelectedItem().toString(), fHarga.getText()
                        };
                        ControllerObat add = new ControllerObat();
                        add.addObat(data);
                    }
                }
                catch(NumberFormatException eror){
                    JOptionPane.showMessageDialog(this, "Harga harus angka");
                }
            }
        }
        else if(e.getSource()==bReset){
            fNama.setText("");
            fHarga.setText("");
        }
        else if(e.getSource()==bBack){
            dispose();
            ControllerMenu menu = new ControllerMenu();
            menu.viewMenu1();
        }
    }
}
