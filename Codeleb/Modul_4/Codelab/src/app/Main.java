package app;

import perpustakaan.*;

public class Main {
    public static void main(String[] args) {

        NonFiksi buku1 = new NonFiksi("Berpikir Yang Bagus", "Taufik", "Positif");
        Fiksi buku2 = new Fiksi("Hutan Seram", "Babang", "Dongeng");

        buku1.displayInfo();
        buku2.displayInfo();
        System.out.println();

        Anggota anggota1 = new Anggota("Taufik", "2C103");
        Anggota anggota2 = new Anggota("Rezha Rivai", "2C222");

        anggota1.tampilkanInfo();
        anggota2.tampilkanInfo();
        System.out.println();

        anggota1.pinjamBuku("Berpikir yang bagus");
        anggota2.pinjamBuku("Hutan Seram", 7);
        System.out.println();
        anggota1.kembalikanBuku("Berpikir Yang Bagus");
        anggota2.kembalikanBuku("Hutan Seram");
    }
}