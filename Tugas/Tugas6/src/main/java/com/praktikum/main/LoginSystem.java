package main.java.com.praktikum.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.com.praktikum.gui.LoginPane;

public class LoginSystem extends Application {
    private static Stage primaryStage;

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        setScene(new Scene(new LoginPane(), 800, 500));
        primaryStage.setTitle("Lost & Found Kampus");
        primaryStage.show();
    }

    public static void setScene(Scene scene) {
        if (primaryStage != null) {
            primaryStage.setScene(scene);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
