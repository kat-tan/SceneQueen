package org.example.projectscenequeen;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

import static org.example.projectscenequeen.SceneQueenApp.scene;

public class PrimaryController {
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;

    @FXML
    protected void handleSubmitButton() throws IOException {
        SceneQueenApp.setRoot("MainPage");
        System.out.println("next page");
    }

    @FXML
    protected void forgotPasswordPrompt(MouseEvent mouseEvent) {
    }

    @FXML
    protected void googleLoginAction(MouseEvent mouseEvent) throws IOException {
        SceneQueenApp.setRoot("MainPage");
    }

    @FXML
    protected void signUpHerePrompt(MouseEvent mouseEvent) {

    }

    protected void initialize() {

    }

}