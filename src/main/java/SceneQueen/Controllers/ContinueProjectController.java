package SceneQueen.Controllers;

import SceneQueen.SceneQueenApplication;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.common.util.concurrent.MoreExecutors;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
public class ContinueProjectController {


    public TextField projectNameTextField;
    public TextField enterEmailTextField;
    public ImageView light;
    public ImageView couch;
    public ImageView chair;
    public ImageView table;
    public ImageView plant;
    @FXML
    private Pane stagePane;
    @FXML
    private VBox alertVBox;


    private static String email;
    private double xStageVal;
    private double yStageVal;

    public void onContinueProjectButton() {
        try {
            SceneQueenApplication.setRoot("ContinueProject");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String email = getCurrentUserEmail();

        Firestore firestore = SceneQueenApplication.getFirestore();
        DocumentReference userRef = firestore.collection("users").document(email);
        CollectionReference projectsRef = userRef.collection("projects");

        ApiFuture<QuerySnapshot> querySnapshotApiFuture = projectsRef.get();
        querySnapshotApiFuture.addListener(() -> {
            try {
                QuerySnapshot querySnapshot = querySnapshotApiFuture.get();
                for (DocumentSnapshot document : querySnapshot.getDocuments()) {
                    String projectName = document.getString("projectName");
                    System.out.println("Project Name: " + projectName);

                    List<Map<String, Object>> elementsInfo = (List<Map<String, Object>>) document.get("elements");
                    if (elementsInfo != null) {
                        List<Map<String, Object>> elements = new ArrayList<>();
                        for (Map<String, Object> elementInfo : elementsInfo) {
                            String elementName = (String) elementInfo.get("elementName");
                            double xPosition = (double) elementInfo.get("xPosition");
                            double yPosition = (double) elementInfo.get("yPosition");

                            System.out.println("Element Name: " + elementName);
                            System.out.println("xPosition: " + xPosition);
                            System.out.println("yPosition: " + yPosition);

                            Map<String, Object> elementMap = new HashMap<>();
                            elementMap.put("elementName", elementName);
                            elementMap.put("xPosition", xPosition);
                            elementMap.put("yPosition", yPosition);

                            elements.add(elementMap);
                        }

                        loadProject(projectName, elements, stagePane);
                    }
                }
            } catch (InterruptedException | ExecutionException e) {
                System.err.println("Error getting documents: " + e.getMessage());
            }
        }, MoreExecutors.directExecutor());
    }

    private String getCurrentUserEmail() {
        return NewProjectController.getCurrentUserEmail();
    }

    private Image getImageForElement(String elementName) {
        String imagePath;

        switch (elementName) {
            case "table":
                imagePath = "src/main/resources/org/example/projectscenequeen/Elements/table.png";
                break;
            case "chair":
                imagePath = "src/main/resources/org/example/projectscenequeen/Elements/chair.png";
                break;
            case "light":
                imagePath = "src/main/resources/org/example/projectscenequeen/Elements/light.png";
                break;
            case "couch":
                imagePath = "src/main/resources/org/example/projectscenequeen/Elements/couch.png";
                break;
            case "plant":
                imagePath = "src/main/resources/org/example/projectscenequeen/Elements/plant.png";
                break;
            default:
                imagePath = "src/main/resources/org/example/projectscenequeen/Images/SQLogo.png";
                break;
        }

        return new Image(imagePath);
    }

    public void loadProject(String projectName, List<Map<String, Object>> elements, Pane stagePane) {
        Platform.runLater(() -> {
            projectNameTextField.setText(projectName);
            for (Map<String, Object> elementInfo : elements) {
                String elementName = (String) elementInfo.get("elementName");
                double xPosition = (double) elementInfo.get("xPosition");
                double yPosition = (double) elementInfo.get("yPosition");

                Image elementImage = getImageForElement(elementName);
                ImageView imageView = new ImageView(elementImage);
                imageView.setLayoutX(xPosition);
                imageView.setLayoutY(yPosition);
                stagePane.getChildren().add(imageView);
            }
        });
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
    protected void onDragDetected(MouseEvent mouseEvent) {
        ImageView element = (ImageView) mouseEvent.getSource();

        Dragboard db = element.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb = new ClipboardContent();
        cb.putImage(element.getImage());
        db.setContent(cb);
        mouseEvent.consume();
    }

    @FXML
    public void onVerifyBtn() {
        email = enterEmailTextField.getText();

        // check if email is in db
        alertVBox.setVisible(false);
    }

    @FXML
    protected void onDragDrop(DragEvent dragEvent) {
        if (dragEvent.getDragboard().hasImage()) {
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
    protected void onDragOver(DragEvent dragEvent) {
        if (dragEvent.getDragboard().hasString() || dragEvent.getDragboard().hasImage()) {
            dragEvent.acceptTransferModes(TransferMode.ANY);
        }
    }

    public void onSearchProjectBtn(ActionEvent actionEvent) {
        String projectName = projectNameTextField.getText();
        if (projectName.isEmpty()) {
            // Handle case where project name is empty
            return;
        }

        String email = getCurrentUserEmail();

        Firestore firestore = SceneQueenApplication.getFirestore();
        DocumentReference userRef = firestore.collection("users").document(email);
        CollectionReference projectsRef = userRef.collection("projects");

        Query query = projectsRef.whereEqualTo("projectName", projectName);
        ApiFuture<QuerySnapshot> querySnapshotApiFuture = query.get();
        querySnapshotApiFuture.addListener(() -> {
            try {
                QuerySnapshot querySnapshot = querySnapshotApiFuture.get();
                for (DocumentSnapshot document : querySnapshot.getDocuments()) {
                    String foundProjectName = document.getString("projectName");
                    System.out.println("Found Project Name: " + foundProjectName);

                    List<Map<String, Object>> elementsInfo = (List<Map<String, Object>>) document.get("elements");
                    if (elementsInfo != null) {
                        loadProject(foundProjectName, elementsInfo, stagePane);
                    }
                }
            } catch (InterruptedException | ExecutionException e) {
                System.err.println("Error getting documents: " + e.getMessage());
            }
        }, MoreExecutors.directExecutor());
    }
}
