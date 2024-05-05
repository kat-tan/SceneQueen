package SceneQueen.Controllers;

import SceneQueen.SceneQueenApplication;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class MeetTheTeamController {
    @FXML
    protected void onLogoutButton() {
        try {
            SceneQueenApplication.setRoot("SignIn");
        } catch (IOException e) {
            throw new RuntimeException(e);
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
