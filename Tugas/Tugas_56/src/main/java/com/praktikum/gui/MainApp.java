package main.java.com.praktikum.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.com.praktikum.users.Admin;
import main.java.com.praktikum.users.Mahasiswa;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        showLogin(primaryStage);
    }

    private void showLogin(Stage stage) {
        LoginPane loginPane = new LoginPane(user -> {
            if (user instanceof Mahasiswa) {
                showMahasiswaDashboard(stage, (Mahasiswa) user);
            } else if (user instanceof Admin) {
                showAdminDashboard(stage, (Admin) user);
            }
        });

        Scene scene = new Scene(loginPane, 400, 300);
        stage.setTitle("Lost & Found Kampus");
        stage.setScene(scene);
        stage.show();
    }

    private void showMahasiswaDashboard(Stage stage, Mahasiswa mahasiswa) {
        MahasiswaDashboard dashboard = new MahasiswaDashboard(mahasiswa, () -> showLogin(stage));
        Scene scene = new Scene(dashboard, 600, 400);
        stage.setScene(scene);
    }

    private void showAdminDashboard(Stage stage, Admin admin) {
        AdminDashboard dashboard = new AdminDashboard(admin, () -> showLogin(stage));
        Scene scene = new Scene(dashboard, 700, 400);
        stage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
