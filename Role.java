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

        VBox root = new VBox(10, welcome);

        if (user instanceof Listener) {
            TextField song = new TextField();
            Button play = new Button("Play Song");

            play.setOnAction(e ->
                ((Listener) user).listenToSong(song.getText())
            );

            root.getChildren().addAll(new Label("Listen to song:"), song, play);
        }

        if (user instanceof Artist) {
            TextField song = new TextField();
            Button upload = new Button("Upload Song");

            upload.setOnAction(e ->
                ((Artist) user).uploadSong(song.getText())
            );

            root.getChildren().addAll(new Label("Upload song:"), song, upload);
        }

        if (user instanceof Admin) {
            Label adminLabel = new Label("Admin Dashboard");
            root.getChildren().add(adminLabel);
        }

        logout.setOnAction(e -> Login.show(stage));
        root.getChildren().add(logout);

        stage.setScene(new Scene(root, 400, 300));
        stage.setTitle("Dashboard");
    }
}
