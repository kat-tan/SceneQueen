package org.example.projectscenequeen;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

import java.io.IOException;

public class MainPageController {
    @FXML
    private MenuButton aboutButton;
    @FXML
    private MenuItem meetTheTeamButton;

    @FXML
    protected void onMeetTheTeamMenuItem(ActionEvent event) {

    }

    @FXML
    protected void onLogoutButton(ActionEvent actionEvent) throws IOException {
        SceneQueenApp.setRoot("Welcome");
    }

}
