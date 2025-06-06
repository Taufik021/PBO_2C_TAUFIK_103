package com.praktikum.users;

import com.praktikum.actions.AdminActions;
import java.util.Scanner;

public class Admin extends User implements AdminActions {
    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public boolean login(String username, String password){
        return username.equals(username) && password.equals(password);
    }

    @Override
    public void displayInfo(){
        System.out.println("Login Admin Berhasil");
        System.out.println("Username: " + getUsername());
        System.out.println("Password: " + getPassword());

    }

    @Override
    public void manageItems() {
        System.out.println(">> Fitur Kelola Barang Belum Tersedia <<");
    }

    @Override
    public void manageUsers() {
        System.out.println(">> Fitur Kelola Mahasiswa Belum Tersedia <<");
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n== Menu Admin ==");
            System.out.println("1. Laporan Barang Temuan/Hilang");
            System.out.println("2. Lihat Datar Laporan");
            System.out.println("0. Logout");
            System.out.println("Pilih: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> manageItems();
                case 2 -> manageUsers();
                case 0 -> System.out.println("Logout");
                default -> System.out.println("Pilih Tidak Valid");
            }
        } while (choice != 0);

    }
}
