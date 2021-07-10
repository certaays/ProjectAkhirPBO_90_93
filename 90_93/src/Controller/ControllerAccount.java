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
public class ControllerAccount {
    public void viewLogin(){
        ViewLogin view = new ViewLogin();
        view.ViewLogin();
    }
    
    public void viewLogin(String[] data){
        ModelAccount model = new ModelAccount();
        model.login(data);
    }
    
    public void viewRegist(){
        ViewRegist view = new ViewRegist();
        view.ViewRegist();
    }
    
    public void viewRegist(String[] data){
        ModelAccount model = new ModelAccount();
        model.regist(data);
    }
}
