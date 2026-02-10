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
        
        username.setStyle("-fx-background-color: #F0D6E9");
        fullName.setStyle("-fx-background-color: #F0D6E9");
        email.setStyle("-fx-background-color: #F0D6E9");
        password.setStyle("-fx-background-color: #F0D6E9");

        ComboBox<String> role = new ComboBox<>(); 
        role.getItems().addAll("Listener", "Artist", "Admin");
        role.setStyle("-fx-background-color: #F0D6E9");

        Button register = new Button("Register");
        Button back = new Button("Back");
        
        register.setStyle("-fx-text-fill: #F0D6E9;"+"-fx-background-color: #184966;"+"-fx-font-weight: bold;");
        back.setStyle("-fx-text-fill: #F0D6E9;"+"-fx-background-color: #184966;"+"-fx-font-weight: bold;");
        
        register.setPrefWidth(200);
        back.setPrefWidth(200);

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
        
        Label uName= new Label("Username");
        Label fName= new Label("Full Name");
        Label Email= new Label("Email");
        Label pWord= new Label("Password");
        Label Role= new Label("Role");
        
        uName.setStyle("-fx-text-fill: #184966;"+"-fx-font-weight: bold;"+"-fx-font-size: 15px;");
        fName.setStyle("-fx-text-fill: #184966;"+"-fx-font-weight: bold;"+"-fx-font-size: 15px;");
        Email.setStyle("-fx-text-fill: #184966;"+"-fx-font-weight: bold;"+"-fx-font-size: 15px;");
        pWord.setStyle("-fx-text-fill: #184966;"+"-fx-font-weight: bold;"+"-fx-font-size: 15px;");
        Role.setStyle("-fx-text-fill: #184966;"+"-fx-font-weight: bold;"+"-fx-font-size: 15px;");

        VBox vroot = new VBox(10,uName, username, fName, fullName, Email, email, pWord, password, Role, role, register, back);
        vroot.setStyle("-fx-background-color: #FCABE5");

        stage.setScene(new Scene(vroot, 350, 420));
        stage.setTitle("Register");
    }
}

