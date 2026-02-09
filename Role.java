package application;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import core.*;

public class Role {

    public static void show(Stage stage, User user) {

        Label welcome = new Label("Welcome, " + user.getFullName());
        Button logout = new Button("Logout");
        
        welcome.setStyle("-fx-text-fill: #F7EC74;"+"-fx-font-weight: bold;"+"-fx-font-size: 30px;");
        logout.setStyle("-fx-text-fill: #F5534B;"+"-fx-background-color: #F7EC74;"+"-fx-font-weight: bold;");

        VBox root = new VBox(10, welcome);
        root.setStyle("-fx-background-color: #ED9E9A");

        if (user instanceof Listener) {
            TextField song = new TextField();
            Button play = new Button("Play Song");
            
            song.setStyle("-fx-background-color: #F5F3DC");
            play.setStyle("-fx-text-fill: #F5534B;"+"-fx-background-color: #F7EC74;"+"-fx-font-weight: bold;");

            play.setOnAction(e ->
                ((Listener) user).listenToSong(song.getText())
            );
            Label ListenToSong = new Label();
            ListenToSong.setStyle("-fx-text-fill: #F7EC74;"+"-fx-font-weight: bold;"+"-fx-font-size: 15px;");

            root.getChildren().addAll(song,ListenToSong, play);
        }

        if (user instanceof Artist) {
            TextField song = new TextField();
            Button upload = new Button("Upload Song");
            
            song.setStyle("-fx-background-color: #F5F3DC");
            upload.setStyle("-fx-text-fill: #F5534B;"+"-fx-background-color: #F7EC74;"+"-fx-font-weight: bold;");

            upload.setOnAction(e ->
                ((Artist) user).uploadSong(song.getText())
            );
            Label UploadSong = new Label();
            UploadSong.setStyle("-fx-text-fill: #F7EC74;"+"-fx-font-weight: bold;"+"-fx-font-size: 15px;");

            root.getChildren().addAll(song,UploadSong, upload);
        }

        if (user instanceof Admin) {
            Label adminLabel = new Label("Admin Dashboard");
            adminLabel.setStyle("-fx-text-fill: #F7EC74;"+"-fx-font-weight: bold;"+"-fx-font-size: 15px;");
            root.getChildren().add(adminLabel);
        }

        logout.setOnAction(e -> Login.show(stage));
        root.getChildren().add(logout);

        stage.setScene(new Scene(root, 350, 250));
        stage.setTitle("Dashboard");
    }
}
