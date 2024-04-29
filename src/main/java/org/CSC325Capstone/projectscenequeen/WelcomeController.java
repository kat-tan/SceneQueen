package org.CSC325Capstone.projectscenequeen;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class WelcomeController {
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;

    @FXML
    protected void onSubmitButton() throws IOException {
        SceneQueenApp.setRoot("MainPage");
    }

    @FXML
    protected void forgotPasswordPrompt(MouseEvent mouseEvent) {

    }

    @FXML
    protected void onGoogleLoginImage(MouseEvent mouseEvent) throws IOException {
        // google authentication
    }

    @FXML
    protected void onSignUpHerePrompt(MouseEvent mouseEvent) {
        // setRoot to sign up form
    }

    protected void initialize() {

    }

}