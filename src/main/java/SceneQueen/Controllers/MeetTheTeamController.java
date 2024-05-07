package SceneQueen.Controllers;

import SceneQueen.SceneQueenApplication;
import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class MeetTheTeamController {

    @FXML
    private Hyperlink linkLuisa, linkKat, linkLiiv, linkMichelle;

    private HostServices hostServices;

    public void setHostServices(HostServices hostServices) {
        this.hostServices = hostServices;
    }

    @FXML
    public void initialize() {
        // Initialize method to set up hyperlinks if needed or other startup logic
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
    protected void onLogoClicked(MouseEvent mouseEvent) {
        try {
            SceneQueenApplication.setRoot("MainPage");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


        // Existing declarations

        @FXML
        public void openWebpage(ActionEvent event) {
            if (hostServices != null) {
                Hyperlink clickedLink = (Hyperlink) event.getSource();
                String url = clickedLink.getText();
                hostServices.showDocument(url);
            } else {
                System.out.println("HostServices not initialized.");
            }
        }
    }
