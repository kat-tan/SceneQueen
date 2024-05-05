package SceneQueen.Controllers;

import SceneQueen.SceneQueenApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

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
        SceneQueenApplication.setRoot("SignIn");
    }

    @FXML
    protected void onCreateProjectButton() throws IOException {
        SceneQueenApplication.setRoot("NewProject");
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
        }
    }
}

