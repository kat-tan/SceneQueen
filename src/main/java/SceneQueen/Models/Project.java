package SceneQueen.Models;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private String email;
    private String projectName;
    private Stage project;
    private List<Element> elements;

    public Project(String email, String projectName) {
        this.email = email;
        this.projectName = projectName;
        this.elements = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Element> getElements() { return elements; }

    public void addElement(Element element) { elements.add(element); }

    public void removeElement(Element element) { elements.remove(element); }

}
