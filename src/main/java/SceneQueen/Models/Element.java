package SceneQueen.Models;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.io.File;

import java.io.IOException;

public class Element {
    private String elementName;
    private double xPosition;
    private double yPosition;
    private String imagePath;

    public Element(String elementName, double xPosition, double yPosition, String imagePath) {
        this.elementName = elementName;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.imagePath = imagePath;
    }

    public static Element createElementFromImage(String imagePath) {
        return new Element("Element", 0, 0, imagePath);
    }

    public Element(String elementName) { } // Used for TEST

    public Element(String elementName, double xPosition, double yPosition) { }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public double getxPosition() {
        return xPosition;
    }

    public void setxPosition(double xPosition) {
        this.xPosition = xPosition;
    }

    public double getyPosition() {
        return yPosition;
    }

    public void setyPosition(double yPosition) {
        this.yPosition = yPosition;
    }

    public String getImagePath() { return imagePath; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }

    public void addToPane(Pane pane) {
            Image image = new Image(new File(imagePath).toURI().toString());
            ImageView imageView = new ImageView(image);
            imageView.setLayoutX(xPosition);
            imageView.setLayoutY(yPosition);
            pane.getChildren().add(imageView);
    }
}
