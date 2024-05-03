package org.example.projectscenequeen;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class RegistrationController {
    public VBox vBoxRoot;
    public TextField firstNameTextField;
    public TextField lastNameTextField;
    public TextField emailTextField;
    public TextField passwordTextField;
    public TextField confirmPasswordTextField;

    @FXML
    public void onSubmitButton(ActionEvent actionEvent) {
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String email = emailTextField.getText();
        String password = passwordTextField.getText();
        String confirmPassword = confirmPasswordTextField.getText();

        if (!password.equals(confirmPassword)) {
            // Display error message to User
            System.out.println("Passwords do not match");
            return;
        }

        Map<String, Object> data = new HashMap<>();
        data.put("firstName", firstName);
        data.put("lastName", lastName);
        data.put("email", email);
        data.put("password", password);

        Firestore firestore = SceneQueenApp.getFirestore();
        DocumentReference docRef = firestore.collection("users").document(UUID.randomUUID().toString());

        try {
            // Check if user already exists
            DocumentSnapshot document = docRef.get().get();
            if (document.exists()) {
                // User already exists, display error message or handle accordingly
                System.out.println("User with email " + email + " already exists");
            } else {
                // User does not exist, add user to database
                docRef.set(data).get();
                // User added successfully, navigate to sign in page or handle accordingly
                System.out.println("User added successfully");
                try {
                    SceneQueenApp.setRoot("SignIn");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            // Error accessing database, display error message or handle accordingly
            System.out.println("Error accessing database: " + e.getMessage());
        }
    }
}

