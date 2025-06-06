package main.java.com.praktikum.data;

import java.io.*;
import java.util.*;
import main.java.com.praktikum.users.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DataStore {
    private static final String USER_FILE = "users.txt";
    private static final String ITEM_FILE = "items.txt";

    public static List<User> loadUsers() {
        List<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5 && parts[0].equals("mahasiswa")) {
                    String name = parts[1];
                    String username = parts[2];
                    String password = parts[3];
                    String nim = parts[4];
                    users.add(new Mahasiswa(name, username, password, nim));
                }
            }
        } catch (IOException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("File Error");
            alert.setHeaderText(null);
            alert.setContentText("[loadUsers] Gagal membaca users.txt: " + e.getMessage());
            alert.showAndWait();
        }
        return users;
    }

    public static void saveUsers(List<User> users) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(USER_FILE))) {
            for (User u : users) {
                if (u instanceof Admin) {
                    pw.println("admin," + u.getName() + "," + u.getUsername() + "," + u.getPassword());
                } else if (u instanceof Mahasiswa) {
                    Mahasiswa m = (Mahasiswa) u;
                    pw.println("mahasiswa," + m.getName() + "," + m.getUsername() + "," + m.getPassword() + "," + m.getNim());
                }
            }
        } catch (IOException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("File Error");
            alert.setHeaderText(null);
            alert.setContentText("[saveUsers] Gagal menulis users.txt: " + e.getMessage());
            alert.showAndWait();
        }
    }

    public static List<Item> loadItems() {
        List<Item> items = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ITEM_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    String name = parts[0];
                    String desc = parts[1];
                    String lokasi = parts[2];
                    String status = parts[3];
                    String pelapor = parts.length > 4 ? parts[4] : "";
                    items.add(new Item(name, desc, lokasi, status, pelapor));
                }
            }
        } catch (IOException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("File Error");
            alert.setHeaderText(null);
            alert.setContentText("[loadItems] Gagal membaca items.txt: " + e.getMessage());
            alert.showAndWait();
        }
        return items;
    }

    public static void saveItems(List<Item> items) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ITEM_FILE))) {
            for (Item i : items) {
                pw.println(i.getName() + "," + i.getDescription() + "," + i.getLokasi() + "," + i.getStatus() + "," + i.getPelapor());
            }
        } catch (IOException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("File Error");
            alert.setHeaderText(null);
            alert.setContentText("[saveItems] Gagal menulis items.txt: " + e.getMessage());
            alert.showAndWait();
        }
    }
}
