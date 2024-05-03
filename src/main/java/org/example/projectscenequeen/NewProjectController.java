package org.example.projectscenequeen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class NewProjectController {
    @FXML
    protected void onMeetTheTeamMenuItem() {
    }

    @FXML
    protected void onLogoutButton() throws IOException {
        SceneQueenApp.setRoot("SignIn");
    }
}
