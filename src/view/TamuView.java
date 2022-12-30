package view;
import java.util.Scanner;
import entity.KamarEntity;
import entity.ReservasiLokal;
import entity.ReservasiLuar;
import model.TamuModel;
import controller.TamuController;

public class TamuView {
    Scanner input = new Scanner(System.in);
    TamuController tamu = new TamuController();

    public void inputKamar(){
        System.out.print("Masukkan Nama     = ");
        String nama = input.nextLine();
        System.out.print("Masukkan No Hp    = ");
        String noHp = input.nextLine();
        System.out.print("Masukkan Alamat   = ");
        String alamat = input.nextLine();
        System.out.print("Masukkan Lama     = "); 
        int lama = input.nextInt();
        input.nextLine();
        System.out.println("""
                1. Tamu Lokal
                2. Tamu Luar
                """);
        System.out.print("Masukkan Pilihan = ");
        String pilih = input.nextLine();
        switch(pilih){
            case "1" -> inputLokal(nama, noHp, alamat, lama);
            case "2" -> inputLuar(nama, noHp, alamat, lama);
            default -> System.out.println("Inputan Tidak Ada");
        }   
    }

    private void inputLokal(String nama, String noHp, String alamat, int lama){
        System.out.print("Masukkan KTP          = ");
        int ktp = input.nextInt();
        CariKamarLokal(nama,noHp,alamat,lama,ktp);
    }

    private void inputLuar(String nama, String noHp, String alamat, int lama){
        System.out.print("Masukkan PASSPORT     = ");
        int pasport = input.nextInt();
        CariKamarLuar(nama, noHp, alamat, lama, pasport);
    }

    private KamarEntity CariKamarLokal(String nama, String noHp, String alamat, int lama,int ktp){
        boolean pilihKamarStatus = false;
        KamarEntity kamar;
        do {
            input.nextLine();
            System.out.print("Masukan Kode Kamar    = ");
            String noKamar = input.nextLine();
            kamar = TamuModel.cari(noKamar);
            if (kamar != null) {
                if (kamar.getStatus_kamar()) {
                    char pilihKamarIni = 'n';

                    System.out.println("No Kamar      : " + kamar.getNo_kamar());
                    System.out.println("Type kamar    : " + kamar.getTipe_kamar());

                    System.out.print("Pilih Kamar ini (y/n) : ");
                    pilihKamarIni = input.nextLine().charAt(0);

                    if (pilihKamarIni == 'y') {
                        kamar.setStatus_kamar(false);
                        tamu.lokal(nama, noHp, alamat, lama, ktp, noKamar);
                        pilihKamarStatus = true;
                        break;
                    }
                } else {
                    System.out.println("------------- KAMAR TELAH DIPESAN ------------");
                }
            } else {
                System.out.println("------------ KAMAR TIDAK DITEMUKAN -----------");
            }
        } while (pilihKamarStatus == false);

        return kamar;
    }

    public void checkoutLokal(){
        System.out.print("Masukan Kode Kamar    = ");
        String noKamar = input.nextLine();
        int index = TamuModel.cariReservasibyKodeKamarLokal(noKamar);
        if(index >-1){
            TamuModel.checkoutLokal(index);
            System.out.println("Berhasil Chekout");
        }else{
            System.out.println("Data Tidak Ditemukan");
        }
    }

    public void checkoutLuar(){
        System.out.print("Masukan Kode Kamar    = ");
        String noKamar = input.nextLine();
        int index = TamuModel.cariReservasibyKodeKamarLuar(noKamar);
        if(index >-1){
            TamuModel.checkOutLuar(index);
            System.out.println("Berhasil Chekout");
        }else{
            System.out.println("Data Tidak Ditemukan");
        }
    }

    private KamarEntity CariKamarLuar(String nama, String noHp, String alamat, int lama,int pasport){
        boolean pilihKamarStatus = false;
        KamarEntity kamar;
        do {

            input.nextLine();
            System.out.print("Masukan Kode Kamar    = ");
            String noKamar = input.nextLine();
            kamar = TamuModel.cari(noKamar);
            if (kamar != null) {
                if (kamar.getStatus_kamar()) {
                    char pilihKamarIni = 'n';

                    System.out.println("No Kamar      : " + kamar.getNo_kamar());
                    System.out.println("Type kamar    : " + kamar.getTipe_kamar());

                    System.out.print("Pilih Kamar ini (y/n) : ");
                    pilihKamarIni = input.nextLine().charAt(0);

                    if (pilihKamarIni == 'y') {
                        kamar.setStatus_kamar(false);
                        tamu.luar(nama, noHp, alamat, lama, pasport, noKamar);
                        pilihKamarStatus = true;
                        break;
                    }
                } else {
                    System.out.println("------------- KAMAR TELAH DIPESAN ------------");
                }
            } else {
                System.out.println("------------ KAMAR TIDAK DITEMUKAN -----------");
            }
        } while (pilihKamarStatus == false);

        return kamar;
    }

    public void daftarReservasi(){
        displayLokal();
        displayLuar();
    }

    public void displayLokal(){
        if(TamuModel.allLokal().isEmpty()){
            System.out.println();
            System.out.println("===========================");
            System.out.println("        Tamu Lokal");
            System.out.println("==========================");
            System.out.println("        Data Tidak Ada");
        }else{
            for(ReservasiLokal objek : TamuModel.allLokal()){
                System.out.println();
                System.out.println("====================================");
                System.out.println("        Tamu Lokal");
                System.out.println("==================================");
                System.out.println("Nama                = " + objek.getTamuLokal().getNama());
                System.out.println("No hp               = " + objek.getTamuLokal().getNoHp());
                System.out.println("Alamat              = " + objek.getTamuLokal().getAlamat());
                System.out.println("lama                = " + objek.getTamuLokal().getLama());
                System.out.println("ktp                 = " + objek.getTamuLokal().getKtp());
                System.out.println("No Kamar            = " + objek.getKamar().getNo_kamar());
                System.out.println("Type Kamar          = " + objek.getKamar().getTipe_kamar());
                System.out.println("Tanggal Chek in     = " + objek.getCheckin());
                if(objek.getChecout()==null){
                    System.out.println("==================================");
                    System.out.println("Chek Out            = Belum Checkout");
                    System.out.println("==================================");
                }else{
                    System.out.println("==================================");
                    System.out.println("Chek Out            = " + objek.getChecout());
                    System.out.println("==================================");
                }
            }
        } 
    }

    public void displayLuar(){
        if(TamuModel.allLuar().isEmpty()){
            System.out.println();
            System.out.println("==========================");
            System.out.println("        Tamu Luar");
            System.out.println("==========================");
            System.out.println("        Tidak Ada Data");
        }else{
            for(ReservasiLuar objek : TamuModel.allLuar()){
                System.out.println();
                System.out.println("==================================");
                System.out.println("        Tamu Luar");
                System.out.println("==================================");
                System.out.println("Nama                = " + objek.getTamuLuar().getLama());
                System.out.println("No hp               = " + objek.getTamuLuar().getNoHp());
                System.out.println("Alamat              = " + objek.getTamuLuar().getAlamat());
                System.out.println("lama                = " + objek.getTamuLuar().getLama());
                System.out.println("Pasport             = " + objek.getTamuLuar().getPasport());
                System.out.println("No Kamar            = " + objek.getKamar().getNo_kamar());
                System.out.println("Type Kamar          = " + objek.getKamar().getTipe_kamar());
                System.out.println("Tanggal Chek in     = " + objek.getCheckin());
                if(objek.getChecout()==null){
                    System.out.println("==================================");
                    System.out.println("Chek Out            = Belum Checkout");
                    System.out.println("==================================");
                }else{
                    System.out.println("==================================");
                    System.out.println("Chek Out            = " + objek.getChecout());
                    System.out.println("==================================");
                }
                
            }
        } 
    }

    public void dispalyKamar(){
        for(KamarEntity objek : TamuModel.allKamar()){
            System.out.println();
            System.out.println("============================");
            System.out.println("No Kamar        = " + objek.getNo_kamar());
            System.out.println("Type kamar      = " + objek.getTipe_kamar());
            if(objek.getStatus_kamar()==true){
                System.out.println("Status Kamar    = Tersedia");
                System.out.println("============================");
            }
            else{
                System.out.println("Status Kamar    = Terboking");
                System.out.println("============================");
            }
        }
    }

    public void hapusKamar(){
        System.out.print("Masukan Kode Kamar    = ");
        String noKamar = input.nextLine();
        KamarEntity kamar = TamuModel.cari(noKamar);
        if(kamar!=null){
            TamuModel.hapus(noKamar);
            System.out.println("Berhasil dihapus");
        }else{
            System.out.println("data tidak ditemukan");
        }
    }
}