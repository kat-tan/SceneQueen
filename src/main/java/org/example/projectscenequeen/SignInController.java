package org.example.projectscenequeen;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class SignInController {
    @FXML
    private TextField emailTextField;
    @FXML
    private PasswordField passwordField;

    @FXML
    protected void onSubmitButton() throws IOException {
        String email = emailTextField.getText();
        String password = passwordField.getText();

        boolean authenticated = authenticateUser(email, password);

        if (authenticated) {
            SceneQueenApp.setRoot("MainPage");
        } else {
            System.out.println("Error: Not Authenticated");// Display error message
        }
    }

    private boolean authenticateUser(String email, String password) {
        // Note: This is a basic example and should be improved for a production environment
        // You should hash the password and compare it to a hashed value stored in Firestore
        // Also, consider using Firebase Authentication for a more secure authentication solution
        CollectionReference users = SceneQueenApp.fstore.collection("users");
        Query query = users.whereEqualTo("email", email).whereEqualTo("password", password);
        ApiFuture<QuerySnapshot> querySnapshot = query.get();

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
        // I think we should get rid of this
    }

    @FXML
    protected void onGoogleLoginImage(MouseEvent mouseEvent) throws IOException {
        // google authentication
    }

    @FXML
    protected void onSignUpHerePrompt(MouseEvent mouseEvent) throws IOException {
        SceneQueenApp.setRoot("Registration");
    }

    protected void initialize() {

    }

}