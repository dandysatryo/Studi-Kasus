package controller;

import entity.StaffEntity;
import model.StaffModel;
import view.StaffView;

import java.util.ArrayList;

public class StaffController implements InterfaceController{

    public void toMain(){
        StaffView staff = new StaffView();
        staff.menu();
    }

    public boolean cari(String username,String password){
        ArrayList<StaffEntity> staff = StaffModel.all();
        for(StaffEntity objek : staff){
            if(objek.getUsername().equals(username)&&objek.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}
