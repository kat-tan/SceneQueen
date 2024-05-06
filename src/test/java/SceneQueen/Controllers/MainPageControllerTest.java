package SceneQueen.Controllers;

import SceneQueen.SceneQueenApplication;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class MainPageControllerTest {

    private MainPageController controller;

    @BeforeEach
    void setUp() {
        controller = new MainPageController();
        controller.firstToolTip = new AnchorPane();
        controller.secondToolTip = new AnchorPane();
        controller.thirdToolTip = new AnchorPane();
        controller.fourthToolTip = new AnchorPane();
        controller.fifthToolTip = new AnchorPane();
        controller.stagePane = new Pane();
        controller.toolTips = new ArrayList<>();
    }

    @Test
    void testHandleNextButton() {
        // Setup
        controller.toolTips.addAll(Arrays.asList(controller.firstToolTip, controller.secondToolTip, controller.thirdToolTip));
        controller.currentToolTipIndex = 0;
        controller.firstToolTip.setVisible(true);

        // Action
        controller.handleNextButton(new ActionEvent());

        // Assertion
        assertFalse(controller.firstToolTip.isVisible());
        assertTrue(controller.secondToolTip.isVisible());
        assertEquals(1, controller.currentToolTipIndex);
    }

//    @Test
//    void testHandleNextButton_LastToolTip() {
//        // Setup
//        controller.toolTips.addAll(Arrays.asList(controller.firstToolTip, controller.secondToolTip, controller.thirdToolTip));
//        controller.currentToolTipIndex = 2;
//        controller.thirdToolTip.setVisible(true);
//
//        // Action
//        controller.handleNextButton(new ActionEvent());
//
//        // Assertion
//        assertFalse(controller.thirdToolTip.isVisible());
//        assertEquals(2, controller.currentToolTipIndex);
//    }

    @Test
    void testHandleNoThanksButton() {
        // Setup
        controller.toolTips.addAll(Arrays.asList(controller.firstToolTip, controller.secondToolTip, controller.thirdToolTip));
        controller.currentToolTipIndex = 2;
        controller.thirdToolTip.setVisible(true);

        // Action
        controller.handleNoThanksButton(new ActionEvent());

        // Assertion
        assertFalse(controller.firstToolTip.isVisible());
        assertFalse(controller.secondToolTip.isVisible());
        assertFalse(controller.thirdToolTip.isVisible());
        assertEquals(0, controller.currentToolTipIndex);
    }

//    @Test
//    void testInitialize() {
//        // Setup
//        controller.firstToolTip = new AnchorPane();
//        controller.secondToolTip = new AnchorPane();
//        controller.thirdToolTip = new AnchorPane();
//        controller.fourthToolTip = new AnchorPane();
//        controller.fifthToolTip = new AnchorPane();
//
//        // Action
//        controller.initialize();
//
//        // Assertion
//        assertFalse(controller.firstToolTip.isVisible());
//        assertFalse(controller.secondToolTip.isVisible());
//        assertFalse(controller.thirdToolTip.isVisible());
//        assertFalse(controller.fourthToolTip.isVisible());
//        assertFalse(controller.fifthToolTip.isVisible());
//        assertEquals(0, controller.currentToolTipIndex);
//    }

    @Test
    void testOnLogoClicked() {
        // Action & Assertion
        assertThrows(RuntimeException.class, () -> controller.onLogoClicked(new MouseEvent(MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, MouseButton.PRIMARY, 1, false, false, false, false, false, false, false, false, false, false, null)));
    }
}
