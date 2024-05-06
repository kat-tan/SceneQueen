module org.example.projectscenequeen {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    requires firebase.admin;
    requires com.google.auth;
    requires com.google.auth.oauth2;
    requires google.cloud.firestore;
    requires google.cloud.core;
    requires com.google.api.apicommon;

    opens org.CSC325Capstone.projectscenequeen to javafx.fxml;
    exports org.CSC325Capstone.projectscenequeen;
}