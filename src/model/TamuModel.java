package model;

import entity.TamuLokalEntity;
import entity.TamuLuarNegeriEntity;
import entity.ReservasiLokal;
import entity.ReservasiLuar;
import entity.KamarEntity;
import utils.DateString;

import java.util.ArrayList;

public class TamuModel {
    static ArrayList<ReservasiLokal> arrayLokal = new ArrayList<>();
    static ArrayList<ReservasiLuar> arrayLuar = new ArrayList<>();
    static ArrayList<KamarEntity> arrayKamar = new ArrayList<>();
    
    public static void initialKamar(){
        arrayKamar.add(new KamarEntity("110", "Singgle Bed", true));
        arrayKamar.add(new KamarEntity("111", "Double Bed", true));
        arrayKamar.add(new KamarEntity("112", "Family Bed", true));
        arrayKamar.add(new KamarEntity("113", "Reguller Bed", true));
        arrayKamar.add(new KamarEntity("114", "VVIP Bed", true));
    }

    public static KamarEntity cari(String noKamar){
        for(KamarEntity objek : arrayKamar){
            if(objek.getNo_kamar().equals(noKamar)){
                return objek;
            }
        }
        return null;
    }

    public static void hapus(String noKamar){
        int index = indexData(noKamar);
        if(index!=-1){
            arrayKamar.remove(index);
        }
    }
    public static int indexData(String noKamar){
        KamarEntity kamar = cari(noKamar);
        return arrayKamar.indexOf(kamar);
    }

    public static void inputLokal(String nama, String noHp, String alamat, int lama,int ktp,String kamar){
        TamuLokalEntity tamu = new TamuLokalEntity(nama, noHp, alamat, lama, ktp);
        KamarEntity kamarCari = cari(kamar);
        arrayLokal.add(new ReservasiLokal(tamu, kamarCari));
    }

    public static void inputLuar(String nama, String noHp, String alamat, int lama,int pasport,String kamar){
        TamuLuarNegeriEntity tamu = new TamuLuarNegeriEntity(nama, noHp, alamat, lama, pasport);
        KamarEntity kamarCari = cari(kamar);
        arrayLuar.add(new ReservasiLuar(tamu, kamarCari));
    }

    public static int cariReservasibyKodeKamarLokal(String kodeKamar) {
        int i = -1;
        for (ReservasiLokal objek : arrayLokal) {
            i += 1;
            if (objek.getKamar().getNo_kamar().equals(kodeKamar)){
                if (!objek.getKamar().getStatus_kamar()) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static int cariReservasibyKodeKamarLuar(String kodeKamar) {
        int i = -1;
        for (ReservasiLuar objek : arrayLuar) {
            i += 1;
            if (objek.getKamar().getNo_kamar().equals(kodeKamar)){
                if (!objek.getKamar().getStatus_kamar()) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void checkoutLokal(int index){
        ReservasiLokal reservasi = arrayLokal.get(index);
        reservasi.setChecout(DateString.now());
        KamarEntity kamar = reservasi.getKamar();
        updateLokal(kamar, true);
        arrayLokal.set(index, reservasi);
    }

    public static void checkOutLuar(int index){
        ReservasiLuar reservasi = arrayLuar.get(index);
        reservasi.setChecout(DateString.now());
        KamarEntity kamar = reservasi.getKamar();
        updateLokal(kamar, true);
        arrayLuar.set(index, reservasi);
    }

    private static void updateLokal(KamarEntity kamar, boolean status){
        for(KamarEntity objek : arrayKamar){
            if(kamar.getNo_kamar().equals(objek.getNo_kamar())){
                objek.setStatus_kamar(status);
                break;
            }
        }
    }

    public static ArrayList<ReservasiLokal> allLokal(){
        return arrayLokal;
    }
    
    public static ArrayList<ReservasiLuar> allLuar(){
        return arrayLuar;
    }

    public static ArrayList<KamarEntity> allKamar(){
        return arrayKamar;
    }
}