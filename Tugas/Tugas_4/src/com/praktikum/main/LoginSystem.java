package com.praktikum.main;


import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import com.praktikum.users.User;

import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user = null;

        int pilihan;
        do {
            Mahasiswa mahasiswa = new Mahasiswa("Taufikurahman", "103");
            Admin admin = new Admin("Admin103", "password103");
            System.out.println("Menu");
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Masukkan pilihan anda: ");
            pilihan = scanner.nextInt();

            if (pilihan == 1){
                System.out.print("Masukkan Username: ");
                String username = scanner.nextLine();
                scanner.nextLine();
                System.out.print("Masukkan Password: ");
                String password = scanner.nextLine();
                if (admin.login(username, password)){
                    admin.displayInfo();
                    user = admin;
                    user.displayAppMenu();
                } else {
                    System.out.println("Login gagal");
                }
            } else if (pilihan ==2){
                System.out.print("Masukkan Nama: ");
                String nama = scanner.nextLine();
                scanner.nextLine();
                System.out.print("Masukkan NIM: ");
                String nim = scanner.nextLine();
                if (mahasiswa.login(nama, nim)){
                    mahasiswa.displayInfo();
                    user = mahasiswa;
                    user.displayAppMenu();
                } else {
                    System.out.println("Login gagal");
                }
            } else if (pilihan == 0){
                System.out.println("Keluar dari Program.");
            } else {
                System.out.println("Pilihan Tidak Valid!");
            }
        } while (pilihan != 0);
    }
}