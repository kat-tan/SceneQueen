package org.example.projectscenequeen;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SplashScreenController {
    @FXML
    private StackPane splashRoot;

    @FXML
    protected void initialize() {
        new SplashScreen().start();
    }
    class SplashScreen extends Thread {
        public void run() {
            try {
                Thread.sleep(4000);

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("SignInPage.fxml"));
                        Scene scene = null;
                        try {
                            scene = new Scene(fxmlLoader.load());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                        Stage stage = new Stage();
                        stage.setTitle("Welcome to SceneQueen");
                        stage.setScene(scene);
                        stage.show();

                        splashRoot.getScene().getWindow().hide();
                    }
                });

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
