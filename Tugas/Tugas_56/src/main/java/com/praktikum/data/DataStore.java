package main.java.com.praktikum.data;

import main.java.com.praktikum.users.Admin;
import main.java.com.praktikum.users.Mahasiswa;

import java.util.ArrayList;
import java.util.Arrays;

public class DataStore {
    public static ArrayList<Item> laporan = new ArrayList<>();
    public static ArrayList<Mahasiswa> mahasiswa = new ArrayList<>();
    public static ArrayList<Admin> admin = new ArrayList<>();
    public static Item itemList;
    public static Arrays mahasiswaList;

    static {
        mahasiswa.add(new Mahasiswa ("Taufik", "103", "123"));
        mahasiswa.add(new Mahasiswa ("Angara", "346", "456"));
        admin.add(new Admin ("Administator", "admin", "admin"));
    }
}
