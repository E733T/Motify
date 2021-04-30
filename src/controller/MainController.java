package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
//    public Label test;
//
    public void sayHelloWorld(ActionEvent actionEvent) {
//        test.setText("Hello World");
        System.out.print("TEST");
    }

    private AnchorPane mainPane;
// Attempt at switching scenes withing window

    public void switchSceneToLogin(ActionEvent event) throws IOException {

        mainPane = FXMLLoader.load(getClass().getResource("../view/login.fxml"));
        Scene scene = new Scene(mainPane);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }
    public void switchSceneToSignUp(ActionEvent event) throws IOException {

        mainPane = FXMLLoader.load(getClass().getResource("../view/signup.fxml"));
        Scene scene = new Scene(mainPane);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void switchSceneToNeedGive(ActionEvent event) throws IOException {
//        System.out.print("TESTING");
//        getScene().setRoot();

        mainPane = FXMLLoader.load(getClass().getResource("../view/songsPage.fxml"));
        Scene scene = new Scene(mainPane);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
