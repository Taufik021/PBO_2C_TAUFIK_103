import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        String usnValid = "Admin103";
        String passValid = "password103";
        String namaValid = "Taufikurahman";
        String NIMValid = "202410370110103";
        String username;
        String password;
        String nama;
        String nim;

        System.out.println("Pilih Login : ");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan Pilihan : ");
        pilihan = scanner.nextInt();
        scanner.nextLine();

        if (pilihan == 1){
            System.out.print("Masukkan username : ");
            username = scanner.nextLine();
            System.out.print("Masukkan password : ");
            password = scanner.nextLine();
            if (username.equals(usnValid) && password.equals(passValid)){
                System.out.println("Login Admin Berhasil!");
            } else {
                System.out.println("Login gagal! Username atau password yang anda masukkan salah!");
            }
        } else if (pilihan == 2){
            System.out.print("Masukkan Nama : ");
            nama = scanner.nextLine();
            System.out.print("Masukkan NIM : ");
            nim = scanner.nextLine();
            if (nama.equalsIgnoreCase(namaValid) && nim.equals(NIMValid)){
                System.out.println("Login mahasiswa berhasil!");
                System.out.println("Nama :" + nama);
                System.out.println("NIM : " + nim);
            } else {
                System.out.println("Login gagal! Nama atau NIM salah");
            }
        } else {
            System.out.println("Pilihan yang anda masukkan tidak valid!");
        }
    }

}
