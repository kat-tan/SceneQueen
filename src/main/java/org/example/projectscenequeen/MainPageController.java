package org.example.projectscenequeen;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainPageController {

    @FXML
    private AnchorPane firstToolTip, secondToolTip, thirdToolTip, fourthToolTip;
    @FXML
    private List<Node> toolTips = new ArrayList<>();
    private int currentToolTipIndex = 0;

    @FXML
    protected void onMeetTheTeamMenuItem() {
    }

    @FXML
    protected void onLogoutButton() throws IOException {
        SceneQueenApp.setRoot("SignIn");
    }

    @FXML
    protected void onCreateProjectButton() throws IOException {
        SceneQueenApp.setRoot("NewProject");
    }

    @FXML
    protected void onContinueProjectButton() {

    }

    @FXML
    private void handleNextButton(ActionEvent event) {
        if (currentToolTipIndex < toolTips.size() - 1) {

            Node currentToolTip = toolTips.get(currentToolTipIndex);
            currentToolTip.setVisible(false);

            currentToolTipIndex++;
            currentToolTip = toolTips.get(currentToolTipIndex);
            currentToolTip.setVisible(true);
            currentToolTip.setStyle("-fx-background-color: pink;");
        }
    }

    @FXML
    private void handleNoThanksButton(ActionEvent event) {
        clearToolTips();
    }

    private void clearToolTips() {
        toolTips.forEach(tip -> {
            tip.setVisible(false);
            tip.setStyle("-fx-background-color: #FFFFFF;");
        });
        currentToolTipIndex = 0;
    }

    @FXML
    private void initialize() {
        toolTips.add(firstToolTip);
        toolTips.add(secondToolTip);
        toolTips.add(thirdToolTip);
        toolTips.add(fourthToolTip);

        toolTips.forEach(tip -> {
            if (tip != null) {
                tip.setVisible(false);
            }
        });
        if (!toolTips.isEmpty() && toolTips.get(0) != null) {
            toolTips.get(0).setVisible(true);
            toolTips.get(0).setStyle("-fx-background-color: pink;");
        }
    }
}

