package main.java.com.praktikum.actions;

import main.java.com.praktikum.data.DataStore;
import main.java.com.praktikum.users.Mahasiswa;

public class MahasiswaActions {

    public static Mahasiswa login(String nim, String password) {
        for (Mahasiswa mhs : DataStore.mahasiswaList) {
            if (mhs.getUsername().equals(nim) && mhs.getPassword().equals(password)) {
                return mhs;
            }
        }
        return null;
    }

    public static void laporBarang(String nama, String lokasi) {

    }
}
