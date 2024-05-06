package SceneQueen.Models;

import java.util.ArrayList;

public class Stage {
    private String projectName;
    private double width;
    private double height;
    private ArrayList<Element> elements;

    public Stage(String projectName, double width, double height) {
        this.projectName = projectName;
        this.width = width;
        this.height = height;
        this.elements = new ArrayList<>();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public ArrayList<Element> getElements() {
        return elements;
    }

    public void setElements(ArrayList<Element> elements) {
        this.elements = elements;
    }


}
