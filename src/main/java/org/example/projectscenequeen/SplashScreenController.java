package org.example.projectscenequeen;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.Parent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static org.example.projectscenequeen.SceneQueenApp.loadFXML;

public class SplashScreenController implements Initializable {
    @FXML
    private StackPane splashRoot;
    private VBox vBox;
    @FXML
    public void initialize(URL url, ResourceBundle rb) {

    }

//    private void splashScreen() {
//        new Thread() {
//            public void run() {
//                try {
//                    Thread.sleep(400);
//                } catch (InterruptedException e) {
//                    System.out.println("e");
//                }
//                Platform.runLater(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            vBox = FXMLLoader.load(SceneQueenApp.class.getResource("Welcome"));
//                            Stage stage = new Stage();
//                            Scene scene = new Scene(vBox);
//                            stage.setTitle("Welcome to SceneQueen");
//                            stage.setScene(scene);
//                            stage.show();
//
//                            splashRoot.getScene().getWindow().hide();
//                        } catch (IOException e) {
//                            throw new RuntimeException(e);
//                        }
//                    }
//                });
//            }
//        }.start();
//
//    }
//    class SplashScreen extends Thread {
//        public void run() {
//            try {
//                Thread.sleep(4000);
//
//                Platform.runLater(new Runnable() {
//
//                    public void run() {
//                        FXMLLoader fxmlLoader = new FXMLLoader(SceneQueenApp.class.getResource("Welcome.fxml"));
//
//
//                        Scene scene;
//                        try {
//                            scene = new Scene(SceneQueenApp.loadFXML("SignInPage"));
//                        } catch (IOException e) {
//                            throw new RuntimeException(e);
//                        }
//
//                        Stage stage = new Stage();
//                        stage.setTitle("Welcome to SceneQueen");
//                        stage.setScene(scene);
//                        stage.show();
//
//                        splashRoot.getScene().getWindow().hide();
//                    }
//                });
//
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
    // }
}
