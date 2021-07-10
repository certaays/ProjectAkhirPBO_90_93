/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.Connector;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author ASUS
 */
public class ModelObat {
    
    Connector connect = new Connector();
    
    public void addObat(String[] data){
        try{
            String query = "INSERT INTO obat (nama_obat, kategori_obat, jenis_obat, harga_obat) VALUES ('"+data[0]+"', '"+data[1]+"', '"+data[2]+"', '"+data[3]+"')";
            connect.statement = connect.koneksi.createStatement();
            connect.statement.executeUpdate(query);
            
            connect.statement.close();
            connect.koneksi.close();
            JOptionPane.showMessageDialog(null, "Input Berhasil");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }
   
    public String[][] viewObat(){
        try{
            int c = 0;
            Model model = new Model();
            int numb = model.numRows("obat");
            if(numb==0){
                return null;
            }
            String[][] data = new String[numb][5];
            String query = "SELECT * FROM obat";
            connect.statement = connect.koneksi.createStatement();
            ResultSet resultSet = connect.statement.executeQuery(query);
            while (resultSet.next()){
                data[c][0] = resultSet.getString("id_obat");
                data[c][1] = resultSet.getString("nama_obat");
                data[c][2] = resultSet.getString("kategori_obat");
                data[c][3] = resultSet.getString("jenis_obat");
                data[c][4] = resultSet.getString("harga_obat");
                c++;
            }
            return data;
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
    
    
    public String[] viewObat(String select){
        try{
            String[] data = new String[5];
            connect.statement = connect.koneksi.createStatement();
            String query = "SELECT * FROM obat WHERE id_obat = '"+select+"'";
            ResultSet resultSet = connect.statement.executeQuery(query);
            while (resultSet.next()){
                data[0] = resultSet.getString("id_obat");
                data[1] = resultSet.getString("nama_obat");
                data[2] = resultSet.getString("kategori_obat");
                data[3] = resultSet.getString("jenis_obat");
                data[4] = resultSet.getString("harga_obat");
            }
            return data;         
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
    
    public void updateObat(String[] data){
       try{
            String query = "UPDATE obat SET nama_obat = '"+data[0]+"', kategori_obat = '"+data[1]+"', jenis_obat = '"+data[2]+"', harga_obat = '"+data[3]+"' WHERE id_obat = '"+data[4]+"'";
            connect.statement = connect.koneksi.createStatement();
            connect.statement.executeUpdate(query);
            
            connect.statement.close();
            connect.koneksi.close();
            JOptionPane.showMessageDialog(null, "Update Berhasil");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Gagal Diupdate!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public String getData(String column, String table, String where, String value){
        try{
            String data = new String();
            connect.statement = connect.koneksi.createStatement();
            String query = "select "+column+" from "+table+" where "+where+" = '" + value + "'";
            ResultSet resultSet = connect.statement.executeQuery(query);
            while (resultSet.next()){
                data = resultSet.getString(column);
            }
            return data;
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
    
        public void deleteObat(String id){
        try {
            String query = "DELETE FROM obat WHERE id_obat = '"+id+"'";
            connect.statement = connect.koneksi.createStatement();
            connect.statement.executeUpdate(query);
            
            connect.statement.close();
            connect.koneksi.close();
            JOptionPane.showMessageDialog(null, "Hapus Berhasil");
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Obat tidak dapat dihapus");
        }
      }
}
