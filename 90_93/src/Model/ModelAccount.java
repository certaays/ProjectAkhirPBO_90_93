/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.*;
import Database.Connector;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class ModelAccount {
    
    Connector connect = new Connector();
    
    public void login(String[] data){
        try{
            String query = "SELECT * FROM user WHERE username = '"+data[0]+"' and password = '"+data[1]+"' ";
            connect.statement = connect.koneksi.createStatement();
            
            ResultSet s = connect.statement.executeQuery(query);
            if(s.next()){
            JOptionPane.showMessageDialog(null, "Login Berhasil");     
            ControllerMenu enter = new ControllerMenu();
            enter.viewMenu1();
            }else{
            JOptionPane.showMessageDialog(null, "Username atau Password salah!!");    
            ControllerAccount login = new ControllerAccount();
            login.viewLogin();
            }
            
            connect.statement.close();
            connect.koneksi.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void regist(String[] data){
        try{
            String sql = "SELECT * FROM user WHERE id_karyawan = '"+data[0]+"' or username = '"+data[1]+"' ";
            String sql1 = "SELECT * FROM user WHERE id_karyawan = '"+data[0]+"'";
            String sql2 = "SELECT * FROM user WHERE username = '"+data[1]+"'";
            String query = "INSERT INTO user (id_karyawan, username, password) VALUES ('"+data[0]+"', '"+data[1]+"', '"+data[2]+"')";
            connect.statement = connect.koneksi.createStatement();
            
            ResultSet testIdUser = connect.statement.executeQuery(sql);
            if(testIdUser.next()){
                
            ResultSet testId = connect.statement.executeQuery(sql1);
            if(testId.next()){
            JOptionPane.showMessageDialog(null, "Id anda sudah terdaftar");
            }
            
            ResultSet testUsername = connect.statement.executeQuery(sql2);
            if(testUsername.next()){
            JOptionPane.showMessageDialog(null, "Username anda sudah terdaftar");
            }
            
            ControllerAccount regist = new ControllerAccount();
            regist.viewRegist();
            
            }
            else{
            connect.statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Register Berhasil");     
            ControllerMenu ent = new ControllerMenu();
            ent.viewMenu1();
            }

            connect.statement.close();
            connect.koneksi.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }

    
}
