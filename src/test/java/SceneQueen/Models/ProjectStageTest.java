package SceneQueen.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProjectStageTest {

    private Stage stage;

    @BeforeEach
    void setUp() {
        stage = new Stage("Test Project", 800, 600);
    }

    @Test
    void setProjectNameTest() {
        stage.setProjectName("New Project Name");
        assertEquals("New Project Name", stage.getProjectName());
    }

    @Test
    void setWidthTest() {
        stage.setWidth(1024);
        assertEquals(1024, stage.getWidth());
    }

    @Test
    void getHeightTest() {
        stage.setHeight(768);
        assertEquals(768, stage.getHeight());
    }

    @Test
    void setElementsTest() {
        ArrayList<Element> elements = new ArrayList<>();
        elements.add(new Element("Element 1"));
        elements.add(new Element("Element 2"));
        stage.setElements(elements);
        assertEquals(2, stage.getElements().size());
    }
}