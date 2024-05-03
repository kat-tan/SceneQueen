package SceneQueen;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Collections;
import java.util.UUID;

public class NewProjectController {
    @FXML
    protected TextField projectNameTextField;

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
        SceneQueenApp.setRoot("SignIn");
    }

    @FXML
    protected void initialize() throws IOException {
        projectNameTextField.setText("New Project");
        projectName = "New Project";
        SceneQueen.UserProject newProject = new SceneQueen.UserProject("email", projectName, Collections.emptyList());

        Firestore firestore = SceneQueenApp.getFirestore();
        DocumentReference docRef = firestore.collection("users").document(UUID.randomUUID().toString());
    }
}
