package SceneQueen;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
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
    public PasswordField passwordTextField;
    public PasswordField confirmPasswordTextField;

    @FXML
    protected void onReturnToLoginBtn() {
        try {
            SceneQueenApp.setRoot("SignIn");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void onSubmitButton(ActionEvent actionEvent) {
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String email = emailTextField.getText();
        String password = passwordTextField.getText();
        String confirmPassword = confirmPasswordTextField.getText();

        if (!password.equals(confirmPassword)) {
            // Display error message to User
            System.out.println("Passwords do not match.");

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Password Error");
            alert.setContentText("Passwords do not match.");
            alert.showAndWait();

            return;
        }

        Map<String, Object> data = new HashMap<>();
        // Hash the password
        String hashedPassword = Ecryptor.encryptPassword(password);
        data.put("firstName", firstName);
        data.put("lastName", lastName);
        data.put("email", email);
        data.put("password", hashedPassword);

        Firestore firestore = SceneQueenApp.getFirestore();
        DocumentReference docRef = firestore.collection("users").document(UUID.randomUUID().toString());

        UserRecord userRecord;

        try {
            UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                    .setEmail(email)
                    .setEmailVerified(true);

            userRecord = SceneQueenApp.fauth.createUser(request);
            System.out.println("Email authenticated.");

            // Check if user already exists
            DocumentSnapshot document = docRef.get().get();
            if (document.exists()) {
                // User already exists, display error message
                System.out.println("User with email " + email + " already exists");
            } else {
                // User does not exist, add user to database
                docRef.set(data).get();
                // User added successfully, navigate to sign in page
                System.out.println("User added successfully");
                try {
                    SceneQueenApp.setRoot("SignIn");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error accessing database: " + e.getMessage());
        } catch (FirebaseAuthException e) {
            System.out.println("Error authenticating.");
        }
    }
}

