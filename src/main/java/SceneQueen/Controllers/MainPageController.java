package SceneQueen.Controllers;

import SceneQueen.SceneQueenApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class will handle the main page functions. The user can create a new project or continue one.
 */
public class MainPageController {
    @FXML
    private AnchorPane firstToolTip, secondToolTip, thirdToolTip, fourthToolTip, fifthToolTip;
    @FXML
    private List<Node> toolTips = new ArrayList<>();
    private int currentToolTipIndex = 0;

    /**
     * This method will navigate to the Meet the Team page.
     */
    @FXML
    protected void onMeetTheTeamMenuItem() {
        try {
            SceneQueenApplication.setRoot("MeetTheTeam");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method moves the user back to the sign in page of SceneQueen.
     */
    @FXML
    protected void onLogoutButton() {
        try {
            SceneQueenApplication.setRoot("SignIn");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method moves the user to a New Project page.
     */
    @FXML
    protected void onCreateProjectButton() {
        try {
            SceneQueenApplication.setRoot("NewProject");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    protected void onContinueProjectButton() {
        try {
            SceneQueenApplication.setRoot("ContinueProject");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method will move to the next tool tip when the next button is clicked.
     *
     * @param event
     */
    @FXML
    private void onNextBtn(ActionEvent event) {
        if (currentToolTipIndex < toolTips.size() - 1) {

            Node currentToolTip = toolTips.get(currentToolTipIndex);
            currentToolTip.setVisible(false);

            currentToolTipIndex++;
            currentToolTip = toolTips.get(currentToolTipIndex);
            currentToolTip.setVisible(true);
        }
    }

    /**
     * This method will close the tool tip.
     */
    @FXML
    private void onCloseBtn (ActionEvent event) {
        clearToolTips();
    }

    /**
     * This method will close the tool tip.
     */
    private void clearToolTips() {
        toolTips.forEach(tip -> {
            tip.setVisible(false);
        });
        currentToolTipIndex = 0;
    }

    /**
     * Initializes functions needed for the functionalities of the page.
     */
    @FXML
    private void initialize() {
        toolTips.add(firstToolTip);
        toolTips.add(secondToolTip);
        toolTips.add(thirdToolTip);
        toolTips.add(fourthToolTip);
        toolTips.add(fifthToolTip);

        toolTips.forEach(tip -> {
            if (tip != null) {
                tip.setVisible(false);
            }
        });
        if (!toolTips.isEmpty() && toolTips.get(0) != null) {
            toolTips.get(0).setVisible(true);
        }
    }

    /**
     * This method moves the UI back to the main page.
     *
     * @param mouseEvent
     */
    @FXML
    protected void onLogoClicked(MouseEvent mouseEvent) {
        try {
            SceneQueenApplication.setRoot("MainPage");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

