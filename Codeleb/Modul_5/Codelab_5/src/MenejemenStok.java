import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class MenejemenStok {
    public static void main(String[] args ) {
        ArrayList<Barang> daftarBarang = new ArrayList<>();
        Scanner scanner = new Scanner (System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n==== Menu Menejemen Stok ====");
            System.out.println("1. Tambahkan Barang Baru");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Kurangi Stok Barang");
            System.out.println("0. Keluar");
            System.out.println("Pilih Opsi: ");
            String pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1":
                    System.out.println("Masukkan Nama Barang: ");
                    String nama = scanner.nextLine();
                    try {
                        System.out.println("Masukkan Stok Awal: ");
                        int stok = Integer.parseInt(scanner.nextLine());
                        daftarBarang.add(new Barang(nama, stok));
                        System.out.println("Barang'" +  nama + "' Berhasil ditambahkan.");
                    } catch (NumberFormatException e) {
                        System.out.println("Input Harus Berupa Angka!");
                    } break;
                case "2":
                    System.out.println("\n--- Daftar Barang ---");
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Stok kosong.");
                    } else {
                        for (int i = 0; i < daftarBarang.size(); i++) {
                            Barang b = daftarBarang.get(i);
                            System.out.println(i + ". Nama: " + b.getNama() + ", Stok: " + b.getStok());
                        }
                    }
                    System.out.println("-----------------------");
                    break;
                case "3":
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Stok kosong, tidak bisa dikurangi.");
                        break;
                    }
                    System.out.println("\n--- Daftar Barang (Pilih untuk Kurangi Stok) ---");
                    for (int i = 0; i < daftarBarang.size(); i++) {
                        Barang b = daftarBarang.get(i);
                        System.out.println(i + ". " + b.getNama() + " (Stok: " + b.getStok() + ")");
                    }
                    try {
                        System.out.print("Masukkan nomor indeks barang: ");
                        int index = Integer.parseInt(scanner.nextLine());
                        Barang b = daftarBarang.get(index);

                        System.out.print("Masukkan jumlah stok yang akan diambil: ");
                        int ambil = Integer.parseInt(scanner.nextLine());

                        if (ambil > b.getStok())
                            throw new StokTidakCukupException("Stok untuk '" + b.getNama() +
                                    "' tidak mencukupi. Sisa stok: " + b.getStok());

                        b.setStok(b.getStok() - ambil);
                        System.out.println("Stok barang '" + b.getNama() + "' berhasil dikurangi. Sisa stok: " + b.getStok());

                    } catch (NumberFormatException e) {
                        System.out.println("Input harus berupa angka.");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Indeks tidak valid.");
                    } catch (StokTidakCukupException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "0":
                    System.out.println("Terima kasih! Program berakhir.");
                    running = false;
                    break;

                default:
                    System.out.println("Opsi tidak valid.");
            }
        }
        scanner.close();
    }
}
