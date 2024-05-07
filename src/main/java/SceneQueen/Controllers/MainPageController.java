package SceneQueen.Controllers;

import SceneQueen.SceneQueenApplication;
import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Hyperlink;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;


import java.util.ArrayList;
import java.util.List;

public class MainPageController {

    @FXML
    private AnchorPane firstToolTip, secondToolTip, thirdToolTip, fourthToolTip, fifthToolTip;
    @FXML
    private List<Node> toolTips = new ArrayList<>();
    private int currentToolTipIndex = 0;
    private HostServices hostServices;
    @FXML
    private Hyperlink itemRequestHyperLink;

    public void setHostServices(HostServices hostServices) {
        this.hostServices = hostServices;
    }

    @FXML
    public void Hyperlink() {
        itemRequestHyperLink.setOnAction(event -> handleItemRequest());
    }

    private void handleItemRequest() {
        String url = "https://docs.google.com/forms/d/e/1FAIpQLSd-VxOPhPRYJb_Hk3VMcjvZt9DIwMNaMKpOeksppacNfVRFWA/viewform?usp=sf_link";
        if (hostServices != null) {
            hostServices.showDocument(url);
        } else {
            System.out.println("HostServices not initialized.");
        }
    }


    @FXML
    protected void onMeetTheTeamMenuItem() {
        try {
            SceneQueenApplication.setRoot("MeetTheTeam");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void onLogoutButton() {
        try {
            SceneQueenApplication.setRoot("SignIn");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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

    @FXML
    private void onCloseBtn (ActionEvent event) {
        clearToolTips();
    }

    private void clearToolTips() {
        toolTips.forEach(tip -> {
            tip.setVisible(false);
        });
        currentToolTipIndex = 0;
    }

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

    @FXML
    protected void onLogoClicked(MouseEvent mouseEvent) {
        try {
            SceneQueenApplication.setRoot("MainPage");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

