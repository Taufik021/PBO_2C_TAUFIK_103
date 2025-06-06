package main.java.com.praktikum.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import main.java.com.praktikum.data.DataStore;
import main.java.com.praktikum.data.Item;
import main.java.com.praktikum.users.Mahasiswa;

public class MahasiswaDashboard extends VBox {
    private final Mahasiswa mahasiswa;
    private final TableView<Item> tableView;
    private final ObservableList<Item> laporanSaya;

    public MahasiswaDashboard(Mahasiswa mahasiswa, Runnable onLogout) {
        this.mahasiswa = mahasiswa;
        this.laporanSaya = FXCollections.observableArrayList();

        setSpacing(10);
        setPadding(new Insets(15));

        Label welcomeLabel = new Label("Selamat datang, " + mahasiswa.getNama());
        Label laporanLabel = new Label("Laporkan Barang Hilang/Temuan");

        TextField namaField = new TextField();
        namaField.setPromptText("Nama Barang");

        TextField lokasiField = new TextField();
        lokasiField.setPromptText("Lokasi");

        Button laporButton = new Button("Laporkan");

        laporButton.setOnAction(e -> {
            String nama = namaField.getText().trim();
            String lokasi = lokasiField.getText().trim();
            if (!nama.isEmpty() && !lokasi.isEmpty()) {
                Item item = new Item(nama, lokasi, "Reported", mahasiswa);
                DataStore.itemList.add(item);
                laporanSaya.add(item);
                namaField.clear();
                lokasiField.clear();
            }
        });

        tableView = new TableView<>();
        tableView.setItems(laporanSaya);

        TableColumn<Item, String> namaCol = new TableColumn<>("Nama");
        namaCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNama()));

        TableColumn<Item, String> lokasiCol = new TableColumn<>("Lokasi");
        lokasiCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getLokasi()));

        tableView.getColumns().addAll(namaCol, lokasiCol);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        for (Item item : DataStore.itemList) {
            if (item.getPelapor().getNim().equals(mahasiswa.getNim())) {
                laporanSaya.add(item);
            }
        }

        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(e -> onLogout.run());

        getChildren().addAll(welcomeLabel, laporanLabel, new HBox(10, namaField, lokasiField, laporButton),
                new Label("Daftar Laporan Anda"), tableView, logoutButton);
    }
}
