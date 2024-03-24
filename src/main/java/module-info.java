module org.example.projectscenequeen {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens org.example.projectscenequeen to javafx.fxml;
    exports org.example.projectscenequeen;
}