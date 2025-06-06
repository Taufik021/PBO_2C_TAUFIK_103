import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import java.util.Random;

public class Main extends Application {
    private int angkaRahasia;
    private int JumlahPercobaan = 0;
    private boolean selesai = false;

    @Override
    public void start(Stage primaryStage) {
        Label nama = new Label(" ▼Taufikurahman▼ ");
        nama.setTextFill(Color.BLACK);

        Label tebak = new Label("Masuka Tebakan Fik");
        tebak.setTextFill(Color.RED);
        //nama.setFont(Font.font("Arial," 10));
        Label judul = new Label ("Tebak Angka 1-100");

        judul.setFont(Font.font("Arial", 30));
        judul.setTextFill(Color.BLUE);
        TextField input = new TextField();

        input.setPromptText("Masukkan Tebakanmu!");
        input.setStyle("-fx-control-inner-background: lightyellow;");
        input.setMaxWidth(150);

        Button tombol = new Button("\uD83E\uDD33Coba Tebak!");
        tombol.setStyle("-fx-background-color: #28a745; -fx-text-fill: white;");
        tombol.setTextFill(Color.BLACK);
        Label feedback = new Label();

        Label labelJumlah_Percobaan = new Label("Jumlah Percoabaan: 0");
        labelJumlah_Percobaan.setTextFill(Color.BLACK);

        HBox inputArea = new HBox(10, input, tombol);
        inputArea.setAlignment(Pos.CENTER);
        //VBox root = new VBox();
        //root.setStyle("-fx-background-color: lightblue;");
       // VBox root = new VBox(15, judul, inputArea, feedback, labelJumlah_Percobaan);

       VBox root = new VBox(15, nama, tebak, judul, inputArea, feedback, labelJumlah_Percobaan);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: lightblue;");
        acakAngkaBaru();

        tombol.setOnAction( e -> {
            if (selesai) {
                acakAngkaBaru();
                input.setDisable(false);
                tombol.setText("Coba Tebak");
                feedback.setTextFill(Color.DODGERBLUE);
                feedback.setText("");
                labelJumlah_Percobaan.setText("Jumlah Percobaan: 0");
                feedback.setTextFill(Color.BLACK);
                input.clear();
                selesai = false;
                return;

            }

            try {
                int tebakan = Integer.parseInt(input.getText());
                JumlahPercobaan++;
                if(tebakan < angkaRahasia) {
                    feedback.setText("Masukan Tebakanmu");
                   // feedback.setTextFill("");
                    feedback.setText("▼ Terlalu Keccil");
                    feedback.setTextFill(Color.ORANGE);
                } else if (tebakan < angkaRahasia) {
                    feedback.setText("▲ Terlalu Besar");
                    feedback.setTextFill(Color.ORANGE);
                } else {
                    feedback.setText("✓ Tebakan Benar");
                    feedback.setTextFill(Color.YELLOW);
                    input.setDisable(true);
                    tombol.setText("\uD83D\uDD04Main Lagi");
                    feedback.setTextFill(Color.BLUE);
                    selesai = true;
                }
                 labelJumlah_Percobaan.setText("Jumlah Percbaan: " + JumlahPercobaan);
            } catch (NumberFormatException ex) {
                feedback.setText("Masukan Angka Valid");
                feedback.setTextFill(Color.RED);
            }
        });

        Scene scene = new Scene( root,400, 300);
        primaryStage.setTitle("Tebak Angka");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void acakAngkaBaru() {
        angkaRahasia = new Random().nextInt(100) + 1;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
