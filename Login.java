package application;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
        
        loginBtn.setPrefWidth(220);
        registerBtn.setPrefWidth(220);

        Label msg = new Label();
        msg.setStyle("-fx-text-fill: #D10700;"+"-fx-font-weight: bold;"+"-fx-font-size: 15px;");

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

        VBox bBox = new VBox(10, loginBtn, registerBtn);
        bBox.setAlignment(Pos.CENTER);

        Image image = new Image("file:src/images/MusicApp.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(110);
        imageView.setFitHeight(110);
        imageView.setPreserveRatio(true);

        HBox actionBox = new HBox(20, bBox, imageView);
        actionBox.setAlignment(Pos.CENTER);

        VBox vroot1 = new VBox(10, uname, username, pword, password, actionBox, msg);
                
        vroot1.setStyle("-fx-background-color: #D8A6F7");

        Scene scene = new Scene(vroot1, 370, 300);
        stage.setScene(scene);
        stage.setTitle("Music Streaming App: Echo Flow");
        stage.show();
    }
}

