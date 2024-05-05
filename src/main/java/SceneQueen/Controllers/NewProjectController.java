package SceneQueen.Controllers;

import SceneQueen.Models.Project;
import SceneQueen.SceneQueenApplication;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.UUID;

public class NewProjectController {
    @FXML
    protected TextField projectNameTextField;
    @FXML
    protected TextField email;
    private String projectName;

    @FXML
    protected void onSaveProjectBtn() {
        projectName = projectNameTextField.getText();
    }

    @FXML
    protected void onMeetTheTeamMenuItem() {
    }

    @FXML
    protected void onLogoutButton() throws IOException {
        SceneQueenApplication.setRoot("SignIn");
    }

    @FXML
    protected void initialize() throws IOException {
        projectNameTextField.setText("New Project");
        projectName = "New Project";
        Project newProject = new Project("email", projectName);

        Firestore firestore = SceneQueenApplication.getFirestore();
        DocumentReference docRef = firestore.collection("users").document(UUID.randomUUID().toString());
    }
}
