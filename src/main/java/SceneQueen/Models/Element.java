package SceneQueen.Models;

public class Element {
    private String elementName;
    private double xPosition;
    private double yPosition;

    public Element(String elementName, double xPosition, double yPosition) {
        this.elementName = elementName;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public Element(String elementName) { } // Used for TEST

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
}
