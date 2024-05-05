package SceneQueen.Controllers;

import SceneQueen.Encryptor;
import SceneQueen.Models.Project;
import SceneQueen.SceneQueenApplication;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class NewProjectController {
    @FXML
    private TextField projectNameTextField;
    @FXML
    private TextField enterEmailTextField;
    @FXML
    private VBox vBoxRoot;
    private String projectName;
    private String email;

    @FXML
    protected void onSaveProjectBtn() {
        projectName = projectNameTextField.getText();

        Map<String, Object> projectInfo = new HashMap<>();

        projectInfo.put("projectName", projectName);

    }

    @FXML
    protected void onVerifyBtn() {
        email = enterEmailTextField.getText();

        // check if email is in db
        vBoxRoot.setVisible(false);
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
    protected void initialize() {
        projectNameTextField.setText("New Project");
        projectName = "New Project";
        Project newProject = new Project("email", projectName);

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
