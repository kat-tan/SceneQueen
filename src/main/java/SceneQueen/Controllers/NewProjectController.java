package SceneQueen.Controllers;

import SceneQueen.Models.Element;
import SceneQueen.Models.Project;
import SceneQueen.SceneQueenApplication;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewProjectController {
    public Project newProject;
    @FXML
    TextField projectNameTextField;
    @FXML
    TextField enterEmailTextField;
    @FXML
    VBox alertVBox;
    @FXML
    private Pane stagePane;
    @FXML
    private ImageView table;
    @FXML
    private ImageView chair;
    @FXML
    private ImageView light;
    @FXML
    private ImageView couch;
    @FXML
    private ImageView plant;

    String projectName;
    private Project project;
    static String email;
    private double xStageVal;
    private double yStageVal;

    @FXML
    protected void onDragDetected(MouseEvent mouseEvent) {
        ImageView element = (ImageView)mouseEvent.getSource();

        Dragboard db = element.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb = new ClipboardContent();
        cb.putImage(element.getImage());
        db.setContent(cb);
        mouseEvent.consume();
    }

    @FXML
    protected void onDragOver(DragEvent dragEvent) {
        if (dragEvent.getDragboard().hasString()|| dragEvent.getDragboard().hasImage()) {
            dragEvent.acceptTransferModes(TransferMode.ANY);
        }
    }

    @FXML
    protected void onDragDrop(DragEvent dragEvent) {
        if (dragEvent.getDragboard().hasImage()){
            Image image = dragEvent.getDragboard().getImage();
            ImageView imageView = new ImageView(image);
            stagePane.getChildren().add(imageView);

            // Update position of the image during dragging
            imageView.setOnMousePressed(mouseEvent -> {
                xStageVal = mouseEvent.getSceneX() - imageView.getLayoutX();
                yStageVal = mouseEvent.getSceneY() - imageView.getLayoutY();
            });

            imageView.setOnMouseDragged(mouseEvent -> {
                double newX = mouseEvent.getSceneX() - xStageVal;
                double newY = mouseEvent.getSceneY() - yStageVal;

                // Keep the image within the bounds of the Stage
                if (newX >= 0 && newX <= stagePane.getWidth() &&
                        newY >= 0 && newY <= stagePane.getHeight()) {
                    imageView.setLayoutX(newX);
                    imageView.setLayoutY(newY);
                }
            });

            dragEvent.setDropCompleted(true);
        }

    }

    @FXML
    protected void onSaveProjectBtn() {
        String email = enterEmailTextField.getText();
        String projectName = projectNameTextField.getText();
        project = new Project(email, projectName);

//        Map<String, Object> projectInfo = new HashMap<>();
//        projectInfo.put("projectName", projectName);

        saveProjectToFirebase(project, email);
    }

    private void saveProjectToFirebase(Project project, String email) {
        Firestore firestore = SceneQueenApplication.getFirestore();
        DocumentReference userRef = firestore.collection("users").document(email);
        CollectionReference projectsRef = userRef.collection("projects");

        Map<String, Object> projectInfo = new HashMap<>();
        projectInfo.put("email", project.getEmail());
        projectInfo.put("projectName", project.getProjectName());

        List<Map<String, Object>> elementsInfo = new ArrayList<>();
        for (Element element : project.getElements()) {
            Map<String, Object> elementInfo = new HashMap<>();
            elementInfo.put("elementName", element.getElementName());
            elementInfo.put("xPosition", element.getxPosition());
            elementInfo.put("yPosition", element.getyPosition());
            elementsInfo.add(elementInfo);
        }
        projectInfo.put("elements", elementsInfo);

        projectsRef.add(projectInfo);
    }

    @FXML
    public void onVerifyBtn() {
        email = enterEmailTextField.getText();

        // check if email is in db
        alertVBox.setVisible(false);
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
    protected void onLogoClicked(MouseEvent mouseEvent) {
        try {
            SceneQueenApplication.setRoot("MainPage");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void initialize() {
        projectNameTextField.setText("My Project");
        projectName = "My Project";
        Project newProject = new Project("email", projectName);

    }

    public static String getCurrentUserEmail() {
        return email;
    }

}
