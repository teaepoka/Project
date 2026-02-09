package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainGui extends Application {

    @Override
    public void start(Stage stage) {
        Login.show(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
