package controller;
import model.TamuModel;

public class TamuController {
    public void lokal(String nama, String noHp, String alamat, int lama,int ktp,String kamar){
        TamuModel.inputLokal(nama, noHp, alamat, lama, ktp, kamar);
    }

    public void luar(String nama, String noHp, String alamat, int lama,int pasport,String kamar){
        TamuModel.inputLuar(nama, noHp, alamat, lama, pasport, kamar);
    }
}
