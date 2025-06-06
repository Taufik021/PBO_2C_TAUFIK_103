package main.java.com.praktikum.users;


import main.java.com.praktikum.gui.MainApp;
import main.java.com.praktikum.data.DataStore;


//import java.com.praktikum.gui.MainApp;

public class Test {
    public static void main(String[] args) {

        DataStore.mahasiswaList.add(new Mahasiswa ("202410370110103", "Taufikurahman", "103"));
        DataStore.mahasiswaList.add(new Mahasiswa ("123456", "sdfgh", "234567"));
        DataStore.adminList.add(new Admin ("admin12", "admin34", "admin56"));

        MainApp.main(args);
    }
}
