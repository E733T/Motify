package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Model;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginController {
    private AnchorPane mainPane;
    @FXML
    private TextField field1;
    @FXML
    private TextField field2;

    public LoginController() throws FileNotFoundException {
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