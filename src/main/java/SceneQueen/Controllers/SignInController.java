package SceneQueen.Controllers;

import SceneQueen.Encryptor;
import SceneQueen.SceneQueenApplication;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class SignInController {
    @FXML
    private TextField emailTextField;
    @FXML
    private PasswordField passwordField;
    @FXML
    protected VBox vBoxRoot;

    @FXML
    protected void onSubmitButton() throws IOException {
        String email = emailTextField.getText();
        String password = passwordField.getText();

        boolean authenticated = authenticateUser(email, password);

        if (authenticated) {
            SceneQueenApplication.setRoot("MainPage");
        } else {
            System.out.println("Error: Not Authenticated");

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login Error");
            alert.setHeaderText("Invalid Information");
            alert.setContentText("Email or password is incorrect.");
            alert.showAndWait();
        }
    }

    private boolean authenticateUser(String email, String password) {
        CollectionReference users = SceneQueenApplication.fstore.collection("users");
        String hashedPassword = Encryptor.encryptPassword(password);

        Query query = users.whereEqualTo("email", email).whereEqualTo("password", hashedPassword);
        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        // System.out.println("Hashed Password: " + hashedPassword);

        try {
            List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();
            return !documents.isEmpty(); // Return true if the query returned any documents (user exists with the given email and password)
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return false;
        }
    }

    @FXML
    protected void forgotPasswordPrompt(MouseEvent mouseEvent) {
        // Future implementation
    }

    @FXML
    protected void onGoogleLoginImage(MouseEvent mouseEvent) throws IOException {
        // google authentication
    }

    @FXML
    protected void onSignUpHerePrompt(MouseEvent mouseEvent) throws IOException {
        SceneQueenApplication.setRoot("Registration");
    }

    @FXML
    protected void initialize() {

    }

}