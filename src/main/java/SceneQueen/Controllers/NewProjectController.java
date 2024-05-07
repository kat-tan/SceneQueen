package SceneQueen.Controllers;

import SceneQueen.Models.Project;
import SceneQueen.SceneQueenApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class handles the functions of a New Project selection by the user.
 */
public class NewProjectController {
    @FXML
    private TextField projectNameTextField;
    @FXML
    private TextField enterEmailTextField;
    @FXML
    private VBox alertVBox;
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
    @FXML
    private ImageView bed;
    @FXML
    private VBox firstToolTip, secondToolTip, thirdToolTip, fourthToolTip, fifthToolTip;

    private List<Node> toolTips = new ArrayList<>();
    private int currentToolTipIndex = 0;
    private String projectName;
    private String email;
    private double xStageVal;
    private double yStageVal;
    private ImageView lastClickedImageView = null;

    /**
     * This method will be triggered when a user drags an element.
     *
     * @param mouseEvent
     */
    @FXML
    protected void onDragDetected(MouseEvent mouseEvent) {
        ImageView element = (ImageView)mouseEvent.getSource();
        Dragboard db = element.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb = new ClipboardContent();

        cb.putImage(element.getImage());
        db.setContent(cb);
        mouseEvent.consume();
    }

    /**
     * This method is invoked when a drag gesture enters the boundary of the UI element.
     *
     * @param dragEvent The DragEvent representing the drag operation.
     *                  It provides information about the drag and allows the current
     *                  UI element to accept or reject the drag.
     */
    @FXML
    protected void onDragOver(DragEvent dragEvent) {
        if (dragEvent.getDragboard().hasString()|| dragEvent.getDragboard().hasImage()) {
            dragEvent.acceptTransferModes(TransferMode.ANY);
        }
    }

    /**
     * This method handles the drop function when the user stops holding the node.
     *
     * @param dragEvent
     */
    @FXML
    protected void onDragDrop(DragEvent dragEvent) {
        if (dragEvent.getDragboard().hasImage()){
            Image image = dragEvent.getDragboard().getImage();
            ImageView imageView = new ImageView(image);
            imageView.setOnMouseClicked(lastCLick -> lastClickedImageView = imageView);

            stagePane.getChildren().add(imageView);

            // Update position of the image during dragging
            imageView.setOnMousePressed(mouseEvent -> {
                xStageVal = mouseEvent.getSceneX() - imageView.getLayoutX();
                yStageVal = mouseEvent.getSceneY() - imageView.getLayoutY();
            });

            imageView.setOnMouseDragged(mouseEvent -> {
                double newX = mouseEvent.getSceneX() - xStageVal;
                double newY = mouseEvent.getSceneY() - yStageVal;


                double stageMinX = 0;
                double stageMinY = 0;
                double stageMaxX = stagePane.getWidth() - imageView.getBoundsInParent().getWidth();
                double stageMaxY = stagePane.getHeight() - imageView.getBoundsInParent().getHeight();


                newX = Math.max(stageMinX, Math.min(newX, stageMaxX));
                newY = Math.max(stageMinY, Math.min(newY, stageMaxY));


                imageView.setLayoutX(newX);
                imageView.setLayoutY(newY);
            });

            dragEvent.setDropCompleted(true);
        }

    }

    /**
     * This method removes the last clicked object by the user.
     */
    @FXML
    protected void onDeleteButton() {
        if (lastClickedImageView != null) {
            stagePane.getChildren().remove(lastClickedImageView);
            lastClickedImageView = null;
        }
    }


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
        alertVBox.setVisible(false);

    }

    /**
     * This method will move to the next tool tip when the next button is clicked.
     *
     * @param event
     */
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

    /**
     * This method will close the tool tip.
     *
     * @param event
     */
    @FXML
    private void onCloseBtn (ActionEvent event) {
        clearToolTips();
    }

    /**
     * This method will close the tool tip.
     */
    @FXML
    private void clearToolTips() {
        toolTips.forEach(tip -> {
            tip.setVisible(false);
        });
        currentToolTipIndex = 0;
    }

    /**
     * This method will navigate to the Meet the Team page.
     */
    @FXML
    protected void onMeetTheTeamMenuItem() {
        try {
            SceneQueenApplication.setRoot("MeetTheTeam");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method brings user to a form they can fill out for element requests.
     */
    @FXML
    private void onItemRequest() {
        String url = "https://docs.google.com/forms/d/e/1FAIpQLSd-VxOPhPRYJb_Hk3VMcjvZt9DIwMNaMKpOeksppacNfVRFWA/viewform?usp=sf_link";
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method moves the user back to the sign in page of SceneQueen.
     */
    @FXML
    protected void onLogoutButton() {
        try {
            SceneQueenApplication.setRoot("SignIn");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method moves the UI back to the main page.
     *
     * @param mouseEvent
     */
    @FXML
    protected void onLogoClicked(MouseEvent mouseEvent) {
        try {
            SceneQueenApplication.setRoot("MainPage");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Initializes functions needed for the functionalities of the page.
     */
    @FXML
    protected void initialize() {
        projectNameTextField.setText("My Project");
        projectName = "My Project";
        Project newProject = new Project("email", projectName);

        toolTips.add(firstToolTip);
        toolTips.add(secondToolTip);
        toolTips.add(thirdToolTip);
        toolTips.add(fourthToolTip);

        toolTips.forEach(tip -> {
            if (tip != null) {
                tip.setVisible(false);
            }
        });
        if (!toolTips.isEmpty() && toolTips.get(0) != null) {
            toolTips.get(0).setVisible(true);
        }
    }
}
