/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import View.*;

/**
 *
 * @author ASUS
 */
public class ControllerObat {
    
    public void addObat(){
        ViewAddObat view = new ViewAddObat();
        view.ViewAdd();
    }
    
    public void addObat(String[] data){
        ModelObat model = new ModelObat();
        model.addObat(data);
    }
    
    public void viewObat(){
        ModelObat model = new ModelObat();
        String[][] data = model.viewObat();
        if(data == null)
            new ViewMenu();
        else
            new ViewObat(data);
    }
    
    public void viewObatA(){
        ModelObat model = new ModelObat();
        String[][] data = model.viewObat();
        if(data == null)
            new ViewMenu();
        else
            new ViewObatA(data);
    }
    
    public void detailObat(String select){
        ModelObat model = new ModelObat();
        ViewDetail view = new ViewDetail();
        view.openDetail(model.viewObat(select));
    }
    
    public void detailObatA(String select){
        ModelObat model = new ModelObat();
        ViewDetailA view = new ViewDetailA();
        view.openDetail(model.viewObat(select));
    }
    
    public void updateObat(String id){
        ModelObat model = new ModelObat();
        String kode = model.getData("id_obat", "obat", "id_obat", id);
        ViewEdit update = new ViewEdit();
        update.ViewEdit(model.viewObat(kode)); 
    }
    
    public void updateObat(String[] data){
        ModelObat model = new ModelObat(); 
        model.updateObat(data);
    }
    
    public void deleteObat(String id){
        ModelObat model = new ModelObat(); 
        model.deleteObat(id);  
    }
}
