package main.java.com.praktikum.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import main.java.com.praktikum.data.DataStore;
import main.java.com.praktikum.data.Item;
import main.java.com.praktikum.users.Admin;
import main.java.com.praktikum.users.Mahasiswa;

public class AdminDashboard extends VBox {
    private final TableView<Item> laporanTable;
    private final TableView<Mahasiswa> mahasiswaTable;
    private final ObservableList<Item> laporanList;
    private final ObservableList<Mahasiswa> mahasiswaList;

    public AdminDashboard(Admin admin, Runnable onLogout) {
        setSpacing(10);
        setPadding(new Insets(15));

        Label header = new Label("Halo, Administrator admin");

        laporanList = FXCollections.observableArrayList(DataStore.itemList);
        mahasiswaList = FXCollections.observableArrayList(DataStore.mahasiswaList);

        laporanTable = new TableView<>(laporanList);
        TableColumn<Item, String> namaCol = new TableColumn<>("Nama");
        namaCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNama()));

        TableColumn<Item, String> lokasiCol = new TableColumn<>("Lokasi");
        lokasiCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getLokasi()));

        TableColumn<Item, String> statusCol = new TableColumn<>("Status");
       statusCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getStatus()));

        laporanTable.getColumns().addAll(namaCol, lokasiCol, statusCol);
        laporanTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        Button tandaiClaimedBtn = new Button("Tandai Claimed");
        tandaiClaimedBtn.setOnAction(e -> {
            Item selected = laporanTable.getSelectionModel().getSelectedItem();
            if (selected != null) {
                selected.setStatus("Claimed");
                laporanTable.refresh();
            }
        });

        mahasiswaTable = new TableView<>(mahasiswaList);
        TableColumn<Mahasiswa, String> mhsNamaCol = new TableColumn<>("Nama");
        mhsNamaCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNama()));

        TableColumn<Mahasiswa, String> mhsNimCol = new TableColumn<>("NIM");
        mhsNimCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNim()));

        mahasiswaTable.getColumns().addAll(mhsNamaCol, mhsNimCol);
        mahasiswaTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        HBox tables = new HBox(20, laporanTable, mahasiswaTable);
        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(e -> onLogout.run());

        getChildren().addAll(header, tables, tandaiClaimedBtn, logoutButton);
    }
}
