package SceneQueen.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProjectStageTest {

    private ProjectStage projectStage;

    @BeforeEach
    void setUp() {
        projectStage = new ProjectStage("Test Project", 800, 600);
    }

    @Test
    void setProjectNameTest() {
        projectStage.setProjectName("New Project Name");
        assertEquals("New Project Name", projectStage.getProjectName());
    }

    @Test
    void setWidthTest() {
        projectStage.setWidth(1024);
        assertEquals(1024, projectStage.getWidth());
    }

    @Test
    void getHeightTest() {
        projectStage.setHeight(768);
        assertEquals(768, projectStage.getHeight());
    }

    @Test
    void setElementsTest() {
        ArrayList<Element> elements = new ArrayList<>();
        elements.add(new Element("Element 1"));
        elements.add(new Element("Element 2"));
        projectStage.setElements(elements);
        assertEquals(2, projectStage.getElements().size());
    }
}