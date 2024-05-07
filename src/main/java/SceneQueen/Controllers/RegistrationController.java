package SceneQueen.Controllers;

import SceneQueen.Models.Encryptor;
import SceneQueen.SceneQueenApplication;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * This class will handle registration functions for a new user to create a SceneQueen account.
 */
public class RegistrationController {
    @FXML
    private VBox vBoxRoot;
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private PasswordField confirmPasswordTextField;

    private Alert alert = new Alert(Alert.AlertType.WARNING);

    /**
     * This method brings the user back to the main sign in page.
     */
    @FXML
    protected void onReturnToLoginBtn() {
        try {
            SceneQueenApplication.setRoot("SignIn");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method will verify the user input, mostly the email and password. The passwords must match
     * each other and the email must be valid. Using Firebase, the email is checked for authentication.
     * If valid, a new user will be created in Firestore database and the user will be navigated back to
     * the sign in page.
     *
     * @param actionEvent
     */
    @FXML
    protected void onSubmitButton(ActionEvent actionEvent) {
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String email = emailTextField.getText();
        String password = passwordTextField.getText();
        String confirmPassword = confirmPasswordTextField.getText();
        UserRecord userRecord;

        if (!password.equals(confirmPassword)) {
            // Display error message to User
            // System.out.println("Passwords do not match.");

            alert.setTitle("Error");
            alert.setHeaderText("Password Error");
            alert.setContentText("Passwords do not match.");
            alert.showAndWait();

            return;
        }

        if (!email.matches("[a-zA-Z0-9.]+@[a-zA-Z]+.[a-zA-Z]+")) {
            alert.setTitle("Error");
            alert.setHeaderText("Email Error");
            alert.setContentText("Please enter a valid email address.");
            alert.showAndWait();
        }

        try {
            Map<String, Object> data = new HashMap<>();
            // Hash the password
            String hashedPassword = Encryptor.encryptPassword(password);
            data.put("firstName", firstName);
            data.put("lastName", lastName);
            data.put("email", email);
            data.put("password", hashedPassword);

            Firestore firestore = SceneQueenApplication.getFirestore();
            DocumentReference docRef = firestore.collection("users").document(email);

            UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                    .setEmail(email)
                    .setEmailVerified(true);

            userRecord = SceneQueenApplication.fauth.createUser(request);
            // System.out.println("Email authenticated.");

            // Check if user already exists
            DocumentSnapshot document = docRef.get().get();
            if (document.exists()) {
                // User already exists, display error message
                // System.out.println("User with email " + email + " already exists");
                alert.setTitle("Error");
                alert.setHeaderText("Duplicate Error");
                alert.setContentText("Email already has an account.");
                alert.showAndWait();

            } else {
                // User does not exist, add user to database
                docRef.set(data).get();
                // User added successfully, navigate to sign in page
                // System.out.println("User added successfully");

                ImageView icon = new ImageView(getClass().getResource("/org/example/projectscenequeen/Images/SQCrown.png").toString());
                icon.setFitHeight(50);
                icon.setFitWidth(50);
                alert.setTitle("Confirmation");
                alert.setHeaderText("Account Confirmation");
                alert.setContentText("A SceneQueen account has been created!");
                alert.setGraphic(icon);
                alert.showAndWait();

                try {
                    SceneQueenApplication.setRoot("SignIn");
                } catch (IOException e) {
                    System.out.println("Error");
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            // System.out.println("Error accessing database: " + e.getMessage());
        } catch (FirebaseAuthException e) {
            // System.out.println("Error authenticating.");

            alert.setTitle("Error");
            alert.setHeaderText("Email Error");
            alert.setContentText("Please enter a valid email address.");
            alert.showAndWait();
        }
    }
}

