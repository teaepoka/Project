package application;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import core.User;

public class Login {

    public static void show(Stage stage) {
        TextField username = new TextField();
        PasswordField password = new PasswordField();

        Button loginBtn = new Button("Login");
        Button registerBtn = new Button("Register");

        Label msg = new Label();

        loginBtn.setOnAction(e -> {
        	User user = FileRegistration.userService.login(
        		    username.getText().trim(),
        		    password.getText().trim()
        		);           
        	if (user != null) {
                Role.show(stage, user);
            } else {
                msg.setText("Invalid credentials");
            }
        });

        registerBtn.setOnAction(e -> Registration.show(stage));

        VBox root = new VBox(10, new Label("Username"), username, new Label("Password"), password, loginBtn, registerBtn, msg);

        stage.setScene(new Scene(root, 300, 300));
        stage.setTitle("Music Streaming App - Login");
        stage.show();
    }
}

