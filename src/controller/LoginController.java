package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

public class LoginController {
    private AnchorPane mainPane;
    @FXML
    private TextField field1;
    @FXML
    private TextField field2;

    public LoginController() throws FileNotFoundException {
    }


    public void alertLogin(ActionEvent actionEvent) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logging into your account!");
        alert.setHeaderText("Welcome back " + field1.getText().toString()+ "!");
        alert.setContentText("Click the okay to continue to your songs list!");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            signIn(actionEvent);
        }

    }

    public void signIn(ActionEvent event) throws IOException {
        String userId=field1.getText().toString();
        String password=field2.getText().toString();
        field1.clear();
        field2.clear();
        boolean tf = Model.addUser(userId,password);
        if (tf){
            mainPane = FXMLLoader.load(getClass().getResource("../view/songsPage.fxml"));
            Scene scene = new Scene(mainPane);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        }

    }

    public void switchSceneToMain(ActionEvent event) throws IOException {
//        System.out.print("TESTING");
//        getScene().setRoot();

        mainPane = FXMLLoader.load(getClass().getResource("../view/Main.fxml"));
        Scene scene = new Scene(mainPane);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}