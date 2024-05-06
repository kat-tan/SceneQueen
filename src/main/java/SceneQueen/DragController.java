package SceneQueen;


import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.Pane;

public class DragController {
    @FXML
    private ImageView table;
    @FXML
    private ImageView chair;
    @FXML
    private ImageView light;
    @FXML
    private ImageView couch;
    @FXML
    private Pane Stage;

    private double x;
    private double y;

    @FXML
    protected void dragDetect_lights(MouseEvent event) {
        Dragboard db = light.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb = new ClipboardContent();
        cb.putImage(light.getImage());
        db.setContent(cb);
        event.consume();
    }


    @FXML
    protected void dragDetect_table(MouseEvent event) {
        Dragboard db = table.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb = new ClipboardContent();
        cb.putImage(table.getImage());
        db.setContent(cb);
        event.consume();
    }

    @FXML
    protected void dragDetect_Chair(MouseEvent event) {
        Dragboard db = chair.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb = new ClipboardContent();
        cb.putImage(chair.getImage());
        db.setContent(cb);
        event.consume();
    }

    @FXML
    protected void dragDetect_Sofa(MouseEvent event) {
        Dragboard db = couch.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb = new ClipboardContent();
        cb.putImage(couch.getImage());
        db.setContent(cb);
        event.consume();

    }

    @FXML
    protected void DragOver(DragEvent event) {
        if (event.getDragboard().hasString()|| event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
        }
    }

    @FXML
    protected void DragDrop(DragEvent event) {
        if (event.getDragboard().hasImage()){
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
                if (newX >= 0 && newX <= Stage.getWidth() &&
                        newY >= 0 && newY <= Stage.getHeight()) {
                    imageView.setLayoutX(newX);
                    imageView.setLayoutY(newY);
                }
            });

            event.setDropCompleted(true);
        }
    }
}
