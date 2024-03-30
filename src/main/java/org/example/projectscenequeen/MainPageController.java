package org.example.projectscenequeen;

import javafx.fxml.FXML;

import java.io.IOException;

public class MainPageController {
    @FXML
    public void handleBacktoLoginBtn() throws IOException {
        SceneQueenApp.setRoot("SignInPage");
    }
}
