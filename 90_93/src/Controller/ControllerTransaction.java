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
public class ControllerTransaction {
    
    public void viewBuy(String[] data){
        ViewBuy view = new ViewBuy();
        view.ViewBuy(data);
    }
    
    public void viewConfirm(String[] data){
        ViewConfirmBuy view = new ViewConfirmBuy();
        view.ViewConfirmBuy(data);
    }
    
    public void transaction(String[] data){
        ModelTransaction model = new ModelTransaction();
        model.insertHistory(data);
    }
    
    public void viewStruck(String id){
        ModelTransaction model = new ModelTransaction();
        ViewStruck view = new ViewStruck();
        view.ViewStruck(id, model.viewStruck(id)); 
    }
    
    public void viewStruck(String[] Data){
        ModelTransaction model = new ModelTransaction();
        ViewStruck1 view = new ViewStruck1();
        view.ViewStruck1(Data); 
    }
    
    public void viewHistory(){
        ModelTransaction model = new ModelTransaction();
        String[][] data = model.viewStruck();
        if(data == null)
            new ViewMenu();
        else
            new ViewHistory(data);
    }
}
