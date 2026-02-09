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
        
        username.setStyle("-fx-background-color: #E0CEEB");
        password.setStyle("-fx-background-color: #E0CEEB");

        Button loginBtn = new Button("Login");
        Button registerBtn = new Button("Register");
        
        loginBtn.setStyle("-fx-text-fill: #E0CEEB;"+"-fx-background-color: #156124;"+"-fx-font-weight: bold;");
        registerBtn.setStyle("-fx-text-fill: #E0CEEB;"+"-fx-background-color: #156124;"+"-fx-font-weight: bold;");
        
        loginBtn.setPrefWidth(200);
        registerBtn.setPrefWidth(200);

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
        
        Label uname= new Label("Username");
        Label pword= new Label("Password");
        
        uname.setStyle("-fx-text-fill: #156124;"+"-fx-font-weight: bold;"+"-fx-font-size: 18px;");
        pword.setStyle("-fx-text-fill: #156124;"+"-fx-font-weight: bold;"+"-fx-font-size: 18px;");
        
        VBox vroot = new VBox(10, uname, username, pword, password, loginBtn, registerBtn, msg);
        vroot.setStyle("-fx-background-color: #D8A6F7");

        stage.setScene(new Scene(vroot, 300, 250));
        stage.setTitle("Music Streaming App - Login");
        stage.show();
    }
}

