package org.example.projectscenequeen;


import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;





public class DragController {


    @FXML
    private ImageView Chair;


    @FXML
    private Circle lights;


    @FXML
    private ImageView Sofa;


    @FXML
    private Pane Stage;


    @FXML
    private ImageView Table;


    private double x;
    private double y;

    @FXML
    void dragDetect_lights(MouseEvent event) {
        Dragboard db = lights.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb = new ClipboardContent();
        cb.putString(lights.getStyle());
        db.setContent(cb);
        event.consume();


    }


    @FXML
    void dragDetect_table(MouseEvent event) {

        Dragboard db = Table.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb = new ClipboardContent();
        cb.putImage(Table.getImage());
        db.setContent(cb);
        event.consume();
    }
    @FXML
    void dragDetect_Chair(MouseEvent event) {
        Dragboard db = Chair.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb = new ClipboardContent();
        cb.putImage(Chair.getImage());
        db.setContent(cb);
        event.consume();


    }


    @FXML
    void dragDetect_Sofa(MouseEvent event) {
        Dragboard db = Sofa.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb = new ClipboardContent();
        cb.putImage(Sofa.getImage());
        db.setContent(cb);
        event.consume();

    }


    @FXML
    void DragOver(DragEvent event) {
        if (event.getDragboard().hasString()|| event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
        }


    }


    @FXML
    void DragDrop(DragEvent event) {
        if (event.getDragboard().hasString()) {
            String str = event.getDragboard().getString();
            // Assuming you want to change the color of the dropped circle
            lights.setStyle(str);
            // Assuming you want to add the circle to the Stage
            Stage.getChildren().add(lights);
            lights.setOnMousePressed(mouseEvent -> {
                x = mouseEvent.getSceneX() - lights.getCenterX();
                y = mouseEvent.getSceneY() - lights.getCenterY();
            });


            lights.setOnMouseDragged(mouseEvent -> {
                double newX = mouseEvent.getSceneX() - x;
                double newY = mouseEvent.getSceneY() - y;


                // Keep the circle within the bounds of the Pane
                if (newX >= 0 && newX <= Stage.getWidth() && newY >= 0 && newY <= Stage.getHeight()) {
                    lights.setCenterX(newX);
                    lights.setCenterY(newY);
                }
            });


        } else if (event.getDragboard().hasImage()){
            Image image = event.getDragboard().getImage();
            ImageView imageView = new ImageView(image);
            Stage.getChildren().add(imageView);

            // Update position of the image during dragging
            imageView.setOnMousePressed(mouseEvent -> {
                x = mouseEvent.getSceneX() - imageView.getLayoutX();
                y = mouseEvent.getSceneY() - imageView.getLayoutY();
            });

            imageView.setOnMouseDragged(mouseEvent -> {
                double newX = mouseEvent.getSceneX() - x;
                double newY = mouseEvent.getSceneY() - y;
                // Keep the image within the bounds of the Stage
                if (newX >= 0 && newX <= Stage.getWidth() - imageView.getFitWidth() &&
                        newY >= 0 && newY <= Stage.getHeight() - imageView.getFitHeight()) {
                    imageView.setLayoutX(newX);
                    imageView.setLayoutY(newY);
                }
            });
            event.setDropCompleted(true);
        }


    }


}
