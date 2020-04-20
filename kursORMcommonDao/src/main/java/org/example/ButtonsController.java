package org.example;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import java.io.IOException;
import java.util.Optional;


public class ButtonsController {
    public Button exitB = new Button();

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void switchToThird() throws IOException {
        App.setRoot("third");
    }

    @FXML
    private void switchToFourth() throws IOException {
        App.setRoot("fourth");
    }

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    public void exitButton ( ActionEvent actionEvent ) {
        Alert conformationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        conformationAlert.setTitle("kliknięcie");
        conformationAlert.setHeaderText("O KURZA TWARZ!");
        conformationAlert.setContentText("o ja pierdziele!1");
        Optional<ButtonType> result = conformationAlert.showAndWait();
        System.out.println(result);
        if(result.get()==ButtonType.OK) {
            Platform.exit();
            System.exit(0);
        }
    }
}
