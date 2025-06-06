package main.java.com.praktikum.gui;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import main.java.com.praktikum.users.User;

import java.util.Optional;

public class LoginPane extends VBox {
    private final ComboBox<String> roleBox;
    private final TextField nimField;
    private final PasswordField passwordField;
    private final Button loginButton;
    private final Text statusText;

    public interface LoginCallback {
        void onLoginSuccess(User user);
    }

    public LoginPane(LoginCallback callback) {
        setPadding(new Insets(20));
        setSpacing(10);

        Label titleLabel = new Label("Login Sistem Lost & Found");
        roleBox = new ComboBox<>();
        roleBox.getItems().addAll("Mahasiswa", "Admin");
        roleBox.setValue("Mahasiswa");

        nimField = new TextField();
        nimField.setPromptText("NIM/Nama Pengguna");

        passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        loginButton = new Button("Login");
        statusText = new Text();

        loginButton.setOnAction(e -> handleLogin(callback));

        getChildren().addAll(titleLabel, roleBox, nimField, passwordField, loginButton, statusText);
    }

    private void handleLogin(LoginCallback callback) {
        String role = roleBox.getValue();
        String nim = nimField.getText().trim();
        String pass = passwordField.getText().trim();

        Optional<? extends User> matchedUser = Optional.empty();

        if (role.equals("Mahasiswa")) {
         matchedUser = DataStore.mahasiswaList.stream()
                 .filter(m -> m.getNim().equals(nim) && m.getPassword().equals(pass))
                 .findFirst();
        } else if (role.equals("Admin")) {
          matchedUser = DataStore.adminList.stream()
                   .filter(a -> a.getNim().equals(nim) && a.getPassword().equals(pass))
                  .findFirst();

        if (matchedUser.isPresent()) {
            statusText.setText("");
            callback.onLoginSuccess(matchedUser.get());
        } else {
            statusText.setText("Login gagal, periksa kredensial.");
        }
    }
}
