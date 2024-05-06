package SceneQueen.Controllers;

import SceneQueen.SceneQueenApplication;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.common.util.concurrent.MoreExecutors;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class MainPageController {

    @FXML
    AnchorPane firstToolTip;
    @FXML
    AnchorPane secondToolTip;
    @FXML
    AnchorPane thirdToolTip;
    @FXML
    AnchorPane fourthToolTip;
    @FXML
    AnchorPane fifthToolTip;
    @FXML
    List<Node> toolTips = new ArrayList<>();
    @FXML
    Pane stagePane;
    int currentToolTipIndex = 0;
    public static Scene scene;

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
    protected void onCreateProjectButton(ActionEvent actionEvent) {
        try {
            SceneQueenApplication.setRoot("NewProject");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void onContinueProjectButton(ActionEvent actionEvent) {
        try {
            SceneQueenApplication.setRoot("ContinueProject");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void handleNextButton(ActionEvent event) {
        if (currentToolTipIndex < toolTips.size() - 1) {

            Node currentToolTip = toolTips.get(currentToolTipIndex);
            currentToolTip.setVisible(false);

            currentToolTipIndex++;
            currentToolTip = toolTips.get(currentToolTipIndex);
            currentToolTip.setVisible(true);
        }
    }

    @FXML
    void handleNoThanksButton(ActionEvent event) {
        clearToolTips();
    }

    private void clearToolTips() {
        toolTips.forEach(tip -> {
            tip.setVisible(false);
        });
        currentToolTipIndex = 0;
    }

    @FXML
    void initialize() {
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

