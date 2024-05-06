package org.CSC325Capstone.projectscenequeen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class MainPageController {
    @FXML
    private MenuButton aboutButton;
    @FXML
    private MenuItem meetTheTeamButton;
    @FXML
    private AnchorPane FirstToolTip;
    @FXML
    private Button NoThanksButton;
    @FXML
    private Button NextButton;

    @FXML
    private void handleNoThanksButton(ActionEvent event) {
        // Get the parent of FirstToolTip, which should be the VBox in the layout
        VBox parent = (VBox) FirstToolTip.getParent();
        // Remove the FirstToolTip from its parent
        parent.getChildren().remove(FirstToolTip);
    }

    @FXML
    protected void onMeetTheTeamMenuItem(ActionEvent event) {

    }

    @FXML
    protected void onLogoutButton(ActionEvent actionEvent) throws IOException {
        SceneQueenApp.setRoot("Welcome");
    }

    @FXML
    protected void onCreateProjectButton() throws IOException {
        SceneQueenApp.setRoot("NewProject");
    }

    @FXML
    protected void onContinueProjectButton() {
    }
}
