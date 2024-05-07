package SceneQueen.Controllers;

import SceneQueen.SceneQueenApplication;
import javafx.fxml.FXML;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * This class contains functionalities of the Meet the Team page.
 */
public class MeetTheTeamController {

    private String url;

    /**
     * This method opens Kat's GitHub page.
     */
    @FXML
    protected void onKatGitHub() {
        url = "https://github.com/kat-tan";
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void onOliviaGitHub() {
        url = "https://github.com/liivsan";
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void onMichelleGitHub() {
        url = "https://github.com/Mparisi03";
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void onLuisaGitHub() {
        url = "https://github.com/Luisa-Valencia-C";
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method brings user to a form they can fill out for element requests.
     */
    @FXML
    protected void onItemRequest() {
        url = "https://docs.google.com/forms/d/e/1FAIpQLSd-VxOPhPRYJb_Hk3VMcjvZt9DIwMNaMKpOeksppacNfVRFWA/viewform?usp=sf_link";
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException e) {
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
    protected void onLogoClicked() {
        try {
            SceneQueenApplication.setRoot("MainPage");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
