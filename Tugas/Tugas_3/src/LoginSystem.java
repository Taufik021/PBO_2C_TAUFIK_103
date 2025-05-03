import java.util.Scanner;
 
public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Admin admin = new Admin("Admin Utama", "103", "admin", "2025");
        Mahasiswa mahasiswa = new Mahasiswa("Taufik", "103");

        System.out.println("=== Sistem Login ===");
        System.out.print("Login sebagai Admin/Mahasiswa: ");
        String pilihan = scanner.nextLine().toLowerCase();

        if (pilihan.equals("admin")) {
            System.out.print("Masukkan username: ");
            String username = scanner.nextLine();
            System.out.print("Masukkan password: ");
            String password = scanner.nextLine();

            if (admin.login(username, password)) {
                admin.displayInfo();
            } else {
                System.out.println("Login Admin gagal. Username atau password salah.");
            }

        } else if (pilihan.equals("mahasiswa")) {
            System.out.print("Masukkan nama: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan NIM: ");
            String nim = scanner.nextLine();

            if (mahasiswa.login(nama, nim)) {
                mahasiswa.displayInfo();
            } else {
                System.out.println("Login Mahasiswa gagal. Nama atau NIM salah.");
            }

        } else {
            System.out.println("Pilihan tidak valid.");
        }

        scanner.close();
    }
}