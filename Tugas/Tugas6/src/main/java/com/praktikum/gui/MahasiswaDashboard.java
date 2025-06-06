package main.java.com.praktikum.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import main.java.com.praktikum.users.Mahasiswa;
import main.java.com.praktikum.data.DataStore;
import main.java.com.praktikum.data.Item;
import main.java.com.praktikum.main.LoginSystem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MahasiswaDashboard extends VBox {
    private String nama;
    private TableView<Item> laporanTable;
    private Mahasiswa mahasiswa;

    public MahasiswaDashboard(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
        setSpacing(10);
        setPadding(new Insets(20));
        setPrefSize(800, 500);

        Label welcome = new Label("Selamat datang, " + mahasiswa.getName());
        HBox inputBox = new HBox(5);
        TextField namaBarang = new TextField();
        namaBarang.setPromptText("Nama Barang");
        TextField deskripsi = new TextField();
        deskripsi.setPromptText("Deskripsi");
        TextField lokasi = new TextField();
        lokasi.setPromptText("Lokasi");
        Button laporBtn = new Button("Laporkan");
        inputBox.getChildren().addAll(namaBarang, deskripsi, lokasi, laporBtn);

        laporanTable = new TableView<>();
        TableColumn<Item, String> namaCol = new TableColumn<>("Nama");
        namaCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getName()));
        TableColumn<Item, String> lokasiCol = new TableColumn<>("Lokasi");
        lokasiCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getLokasi()));
        laporanTable.getColumns().addAll(namaCol, lokasiCol);
        laporanTable.setPrefHeight(200);
        refreshTable();

        laporBtn.setOnAction(e -> {
            String n = namaBarang.getText();
            String d = deskripsi.getText();
            String l = lokasi.getText();
            if (!n.isEmpty() && !l.isEmpty()) {
                Item item = new Item(n, d, l, "Reported", mahasiswa.getUsername());
                ObservableList<Item> items = FXCollections.observableArrayList(DataStore.loadItems());
                items.add(item);
                DataStore.saveItems(items);
                refreshTable();
                namaBarang.clear(); deskripsi.clear(); lokasi.clear();
            }
        });

        Button logoutBtn = new Button("Logout");
        logoutBtn.setOnAction(e -> LoginSystem.setScene(new javafx.scene.Scene(new main.java.com.praktikum.gui.LoginPane(), 800, 500)));

        getChildren().addAll(welcome, inputBox, new Label("Daftar Laporan Anda"), laporanTable, logoutBtn);
    }

    private void refreshTable() {
        ObservableList<Item> items = FXCollections.observableArrayList(DataStore.loadItems());
        items.removeIf(i -> !i.getPelapor().equals(mahasiswa.getUsername()));
        laporanTable.setItems(items);
    }
}
