package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;
import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions {
    public Mahasiswa(String username, String password) {
        super(username, password);
    }

    @Override
    public boolean login(String username, String password) {
        return username.equals(username) && password.equals(password);
    }

    @Override
    public void reportItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nama Barang: ");
        String nama = scanner.nextLine();
        System.out.print("Deskripsi Barang: ");
        String deskripsi = scanner.nextLine();
        System.out.print("Lokasi Terakhir/Ditemukan: ");
        String lokasi = scanner.nextLine();
        System.out.println(">> Laporan telah disimpan. Terima kasih! <<");
    }

    public void displayInfo(){
        System.out.println("Login Mahasiswa Berhasil");
        System.out.println("Nama: " + getUsername());
        System.out.println("NIM: " + getPassword());
    }

    @Override
    public void viewReportedItem() {
        System.out.println(">> Fitur Lihat Laporan Belum Tersedia <<");
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n== Menu Mahasiswa ==");
            System.out.println("1. Laporkan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("0. Logout");
            System.out.print("Pilih: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> reportItem();
                case 2 -> viewReportedItem();
                case 0 -> System.out.println("Logout...");
                default -> System.out.println("Pilihan tidak valid!");
            }
        } while (choice != 0);
    }
}