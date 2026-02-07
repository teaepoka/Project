package application;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import core.*;

public class Registration {

    public static void show(Stage stage) {
        TextField username = new TextField();
        TextField fullName = new TextField();
        TextField email = new TextField();
        PasswordField password = new PasswordField();

        ComboBox<String> role = new ComboBox<>();
        role.getItems().addAll("Listener", "Artist", "Admin");

        Button register = new Button("Register");
        Button back = new Button("Back");

        register.setOnAction(e -> {
            User user;
            switch (role.getValue()) {
                case "Artist":
                    user = new Artist(username.getText(), password.getText(), fullName.getText(), email.getText());
                    break;
                case "Admin":
                    user = new Admin(username.getText(), password.getText(), fullName.getText(), email.getText());
                    break;
                default:
                    user = new Listener(username.getText(), password.getText(), fullName.getText(), email.getText());
            }
            FileRegistration.userService.registerUser(user);
            Login.show(stage);
        });

        back.setOnAction(e -> Login.show(stage));

        VBox root = new VBox(10,
                new Label("Username"), username,
                new Label("Full Name"), fullName,
                new Label("Email"), email,
                new Label("Password"), password,
                new Label("Role"), role,
                register, back
        );

        stage.setScene(new Scene(root, 350, 400));
        stage.setTitle("Register");
    }
}

