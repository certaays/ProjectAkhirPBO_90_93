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
public class ModelTransaction {
 
    Connector connect = new Connector();
    
    public void insertHistory(String[] data){
        try{
            
            String query = "INSERT INTO history (id_obat, banyak_obat) VALUES ('"+data[0]+"', '"+data[1]+"')";
            connect.statement = connect.koneksi.createStatement();
            connect.statement.executeUpdate(query);
            
            connect.statement.close();
            connect.koneksi.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }
   
    public String[] viewStruck(String id){
        try{
            String[] data = new String[5];
            connect.statement = connect.koneksi.createStatement();
            String query = "SELECT obat.nama_obat, obat.kategori_obat, obat.jenis_obat, obat.harga_obat, history.banyak_obat FROM obat INNER JOIN history ON obat.id_obat=history.id_obat WHERE history.id_history = '"+id+"'";
            ResultSet resultSet = connect.statement.executeQuery(query);
            while (resultSet.next()){
                data[0] = resultSet.getString("nama_obat");
                data[1] = resultSet.getString("kategori_obat");
                data[2] = resultSet.getString("jenis_obat");
                data[3] = resultSet.getString("harga_obat");
                data[4] = resultSet.getString("banyak_obat");
            }
            return data;         
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
   }
   
    public String[][] viewStruck(){
        try{
            int c = 0;
            int numb = numRows("struck");
            if(numb==0){
                return null;
            }
            String[][] data = new String[numb][6];
            String query = "SELECT history.id_history, obat.nama_obat, obat.kategori_obat, obat.jenis_obat, obat.harga_obat, history.banyak_obat FROM obat, history WHERE obat.id_obat=history.id_obat order by history.id_history";
            ResultSet resultSet = connect.statement.executeQuery(query);
            while (resultSet.next()){
                data[c][0] = resultSet.getString("id_history");
                data[c][1] = resultSet.getString("nama_obat");
                data[c][2] = resultSet.getString("kategori_obat");
                data[c][3] = resultSet.getString("jenis_obat");
                data[c][4] = resultSet.getString("harga_obat");
                data[c][5] = resultSet.getString("banyak_obat");
                c++;
            }
            return data;
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    private int numRows(String struck) {
        int jml = 0;
        try{
            connect.statement = connect.koneksi.createStatement();
            String query = "SELECT * FROM history";
            ResultSet resultSet = connect.statement.executeQuery(query);
            while (resultSet.next()){
                jml++;
            }
            return jml;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
    }
}
