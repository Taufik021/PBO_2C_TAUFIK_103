package main.java.com.praktikum.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import main.java.com.praktikum.main.LoginSystem;
import main.java.com.praktikum.users.Admin;
import main.java.com.praktikum.users.Mahasiswa;
import main.java.com.praktikum.users.User;

import java.awt.*;

public class LoginPane extends VBox {
    private ComboBox<String> roleBox;
    private TextField usernameField;
    //private TextField NamaField;
    private PasswordField passwordField;
    private Label messageLabel;

    public LoginPane() {
        setSpacing(10);
        setPadding(new Insets(20));
        setAlignment(Pos.CENTER);
        setPrefSize(800, 500);


        Label vep = new Label("Taufikurahman");

        Label title = new Label("Login Sistem Lost & Found");
        roleBox = new ComboBox<>();
        roleBox.getItems().addAll("Mahasiswa", "Admin");
        roleBox.setValue("Mahasiswa");

        //NamaField = new TextField();
       // NamaField.setPromptText("Nama");

        usernameField = new TextField();
        usernameField.setPromptText("Username");
        passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginBtn = new Button("Login");
        messageLabel = new Label();

      //  Button Taufik  = new Button("Taufik");
      //  HBox satukan = new HBox(loginBtn, Taufik);
       // satukan.setAlignment(Pos.CENTER);

        loginBtn.setOnAction(e -> handleLogin());

        getChildren().addAll(vep, title, roleBox, usernameField, passwordField, loginBtn, messageLabel);
    }

    private void handleLogin() {
        String role = roleBox.getValue();
        String user = usernameField.getText();
        String pass = passwordField.getText();

        if (role.equals("Admin") && user.equals("admin") && pass.equals("123")) {
            main.java.com.praktikum.main.LoginSystem.setScene(
                new javafx.scene.Scene(new AdminDashboard(new main.java.com.praktikum.users.Admin("Administrator", "admin", "admin")), 800, 500)
            );
            return;
        }

        User loginUser = main.java.com.praktikum.data.DataStore.loadUsers().stream()
            .filter(u -> u.getUsername().equals(user) && u.getPassword().equals(pass) &&
                (role.equals("Mahasiswa") && u instanceof Mahasiswa))
            .findFirst().orElse(null);

        if (loginUser != null) {
            main.java.com.praktikum.main.LoginSystem.setScene(
                new javafx.scene.Scene(new MahasiswaDashboard((Mahasiswa) loginUser), 800, 500)
            );
        } else {
            messageLabel.setText("Login gagal! Username atau Password salah.");
        }
    }
}
