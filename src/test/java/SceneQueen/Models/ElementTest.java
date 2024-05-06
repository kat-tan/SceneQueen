package SceneQueen.Models;

import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

class ElementTest {

    private Element element;

    @BeforeEach
    void setUp() {
        element = new Element("TestElement", 100.0, 200.0, "src/main/resources/org/example/projectscenequeen/Elements/chair.png");
    }

    @Test
    void createElementFromImage() {
        Element elementFromImage = Element.createElementFromImage("src/main/resources/org/example/projectscenequeen/Elements/chair.png");
        assertNotNull(elementFromImage);
        assertEquals("Element", elementFromImage.getElementName());
        assertEquals(0.0, elementFromImage.getxPosition());
        assertEquals(0.0, elementFromImage.getyPosition());
        assertEquals("src/main/resources/org/example/projectscenequeen/Elements/chair.png", elementFromImage.getImagePath());
    }
}

