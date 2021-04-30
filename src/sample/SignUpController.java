package sample;

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

public class SignUpController {

    private AnchorPane mainPane;
    @FXML
    private TextField field1;
    @FXML
    private TextField field2;

    public SignUpController() throws FileNotFoundException {
    }

    public void switchSceneToMain(ActionEvent event) throws IOException {
//        System.out.print("TESTING");
//        getScene().setRoot();

        mainPane = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene scene = new Scene(mainPane);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void scanFile(ActionEvent event) throws IOException {
        String s1 = field1.getText().toString();
        field2.setText(Model.getNumberOfItemsInInventory(s1));
    }

}