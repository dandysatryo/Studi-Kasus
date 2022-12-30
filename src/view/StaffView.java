package view;

import controller.StaffController;
import java.util.Scanner;

public class StaffView implements ClassInterface{
    Scanner input = new Scanner(System.in);
    StaffController staff = new StaffController();
    TamuView view = new TamuView();
    
    @Override
    public void menu(){
        String pilih;
        do{
            System.out.println("""
                1. Login
                2. Keluar
                """);
            System.out.print("Masukkan Pilihan = ");
            pilih = input.nextLine();
            switch(pilih){
                case "1" -> pilihan();
                case "2" -> System.out.println("exit");
                default -> System.out.println("Inputan Tidak Ada");
            }
        }while(!pilih.equals("2"));        
    }

    private void pilihan(){
        String pilih;
        do{
            System.out.println("""
                1. Staff
                2. User Input Kamar
                3. Display Kamar
                4. checkout
                5. Exit
                """);
            System.out.print("Masukkan Pilihan = ");
            pilih = input.nextLine();
            switch(pilih){
                case "1" -> login();
                case "2" -> view.inputKamar();
                case "3" -> view.dispalyKamar();
                case "4" -> pilihanCheckout();
                case "5" -> System.out.println("exit");
                default -> System.out.println("Inputan Tidak Ada");
            }
        }while(!pilih.equals("5"));
        
    }

    private void pilihanDisplay(){
        String pilih;
        do{
            System.out.println("""
                1. Lihat Daftar Reservasi
                2. Hapus Kamar
                3. Exit
                """);
            System.out.print("Masukkan Pilihan = ");
            pilih = input.nextLine();
            switch(pilih){
                case "1" -> view.daftarReservasi();
                case "2" -> view.hapusKamar();
                case "3" -> System.out.println("exit");
                default -> System.out.println("Inputan Tidak Ada");
            }
        }while(!pilih.equals("3"));  
    }

    private void pilihanCheckout(){
        String pilih;
        do{
            System.out.println("""
                1. Tamu Lokal
                2. Tamu Luar
                3. Exit
                """);
            System.out.print("Masukkan Pilihan = ");
            pilih = input.nextLine();
            switch(pilih){
                case "1" -> view.checkoutLokal();
                case "2" -> view.checkoutLuar();
                case "3" -> System.out.println("exit");
                default -> System.out.println("Inputan Tidak Ada");
            }
        }while(!pilih.equals("3"));  
    }
    private void login(){
        System.out.print("Masukkan Username = ");
        String username = input.nextLine();
        System.out.print("Masukkan Password = ");
        String password = input.nextLine();
        boolean status = staff.cari(username, password);
        if(status){
            pilihanDisplay();
        }
        else{
            System.out.println("salah");
        }
    }
}
