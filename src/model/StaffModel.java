package model;

import entity.StaffEntity;
import java.util.ArrayList;

public class StaffModel {
    static ArrayList<StaffEntity> arrayStaff = new ArrayList<>();

    public static ArrayList<StaffEntity> all(){
        return arrayStaff;
    }

    public static void initialStaff(){
        arrayStaff.add(new StaffEntity("dandy", "444"));
        arrayStaff.add(new StaffEntity("nafisa", "111"));
        arrayStaff.add(new StaffEntity("sedati", "perak"));
    }
}