package org.example.projectscenequeen;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class MainPageController {

    public MenuButton aboutButton;
    public MenuItem meetTheTeamButton;
    public Button NoThanksButton2;
    public Button NextButton2;
    public AnchorPane firstToolTip;
    public AnchorPane thirdToolTip;

    public void onMeetTheTeamMenuItem(ActionEvent actionEvent) {
    }

    public void onLogoutButton(ActionEvent actionEvent) throws IOException {
        SceneQueenApp.setRoot("SignIn");
    }

    public void onCreateProjectButton(ActionEvent actionEvent) {
    }

    public void onContinueProjectButton(ActionEvent actionEvent) {
    }

    public void handleNoThanksButton(ActionEvent actionEvent) {
        // Get the parent of FirstToolTip, which should be the VBox in the layout
        VBox parent = (VBox) firstToolTip.getParent();
        // Remove the FirstToolTip from its parent
        parent.getChildren().remove(firstToolTip);
    }

    public void handleNextButton(ActionEvent actionEvent) {
    }
}
