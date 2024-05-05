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
    requires com.google.common;

    opens SceneQueen to javafx.fxml;
    exports SceneQueen;
    exports SceneQueen.Controllers;
    opens SceneQueen.Controllers to javafx.fxml;
    exports SceneQueen.Models;
    opens SceneQueen.Models to javafx.fxml;

}