package SceneQueen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.IOException;

public class SceneQueenApplication extends Application {
    public static Scene scene;
    public static Firestore fstore;
    public static FirebaseAuth fauth;

    @Override
    public void start(Stage stage) throws IOException {
        FileInputStream serviceAccount = new FileInputStream
                ("src/main/resources/org/example/projectscenequeen/json/scenequeen-firebase-adminsdk.json");
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        FirebaseApp.initializeApp(options);

        fstore = FirestoreClient.getFirestore();
        fauth = FirebaseAuth.getInstance();

        scene = new Scene(loadFXML("SignIn"));
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
        scene.getWindow().sizeToScene();
        scene.getWindow().centerOnScreen();
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SceneQueenApplication.class.getResource(
                "/org/example/projectscenequeen/FXML/" + fxml + ".fxml")
        );
        return fxmlLoader.load();
    }

    public static Firestore getFirestore() {
        return FirestoreClient.getFirestore();
    }

    public static void main(String[] args) {
        launch();
    }
}