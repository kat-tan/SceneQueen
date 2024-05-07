package SceneQueen.Controllers;

import SceneQueen.Models.Project;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class NewProjectControllerTest {

    private static NewProjectController controller;

    @BeforeAll
    static void setUp() {

        // Initialize JavaFX toolkit
        Platform.startup(JFXPanel::new);

        controller = new NewProjectController();
        controller.projectNameTextField = new TextField();
        controller.projectNameTextField.setText("My Project");
        controller.enterEmailTextField = new TextField();
        controller.alertVBox = new VBox();
    }

//    @Test
//    void onDragOver() {
//        DragEvent dragEvent = new DragEvent(DragEvent.DRAG_OVER);
//        dragEvent.acceptTransferModes(TransferMode.ANY);
//
//        controller.onDragOver(dragEvent);
//
//        assertEquals(TransferMode.ANY, dragEvent.getAcceptedTransferMode());
//    }

    @Test
    void onVerifyBtn() {
        controller.enterEmailTextField.setText("test@example.com");

        controller.onVerifyBtn();

        assertEquals("test@example.com", NewProjectController.email);
        assertFalse(controller.alertVBox.isVisible());
    }

    @Test
    void initialize() {
        controller.initialize();

        assertEquals("My Project", controller.projectName);
        assertEquals(new Project("email", "My Project"), controller.newProject);
    }

    @AfterAll
    static void tearDown() {
        Platform.exit();
    }
}