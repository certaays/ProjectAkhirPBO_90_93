/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.Connector;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class Model {
    
    Connector connect = new Connector();
    
    public int numRows(String t) {
        int jml = 0;
        try{
            connect.statement = connect.koneksi.createStatement();
            String query = "SELECT * FROM "+t+" ";
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
