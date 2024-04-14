package org.example.projectscenequeen;

import javafx.event.ActionEvent;

import java.io.IOException;

public class NewProjectController {
    public void onMeetTheTeamMenuItem() {
    }

    public void onLogoutButton() throws IOException {
        SceneQueenApp.setRoot("Welcome");
    }
}
