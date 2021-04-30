package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Model;
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class songsPageController<e> {
    public Button amountButton;
    public Button needButton;
    public Button giveButton;
    public Button submit;
    public TextField songField;
    public TextField albumField;

    public void saySomething(ActionEvent actionEvent) {

//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setTitle("Confirmation Dialog");
//        alert.setHeaderText("Look, a Confirmation Dialog");
//        alert.setContentText("Click the okay button now please");

//        Optional<ButtonType> result = alert.showAndWait();
//        if (result.get() == ButtonType.OK){
//            songField.clear();
//            albumField.clear();
//            givenQuantityField.clear();
//
//        }

    }
    private AnchorPane mainPane;
    public void switchSceneToMain(ActionEvent event) throws IOException {
//        System.out.print("TESTING");
//        getScene().setRoot();

        mainPane = FXMLLoader.load(getClass().getResource("../view/Main.fxml"));
        Scene scene = new Scene(mainPane);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }



    HashMap<String, String> h1=new HashMap<String, String>();

    public void addMe(ActionEvent event) throws IOException {
        String key=albumField.getText().toString();
        String song = songField.getText().toString();
        Model.addItem(key,song);
//        Model.addUser(userId, );
        albumField.clear();
        songField.clear();

    }
    public void updateMe(ActionEvent event ) throws IOException {
        String key=albumField.getText().toString();
//        String value=givenQuantityField.getText().toString();
        String userId= songField.getText().toString();
//        Model.subtractItem(key, value);
        albumField.clear();
        songField.clear();

    }

    public void addQuantity(ActionEvent event) throws IOException {

        String item = albumField.getText().toString();
//        String givenQuantity = givenQuantityField.getText().toString();
        File f = new File(getClass().getResource("inventory.txt").getFile());

        songField.clear();
        albumField.clear();

        File temp;

        temp = File.createTempFile("myTempFile", ".txt");

        BufferedWriter bw = new BufferedWriter(new FileWriter(temp));

        Scanner scanner = new Scanner(f);
        while(scanner.hasNextLine())
        {
//            System.out.println(scanner.nextLine());
            String line = scanner.nextLine();
            String[] values = line.split(",");
            values[1] = values[1].trim();
//            System.out.println("Values[0] ==> " + values[0]);
            if ((values[0].toLowerCase()).equals(item.toLowerCase())){
//                values[1] = new String(String.valueOf(Integer.parseInt(values[1]) + Integer.parseInt(givenQuantity)));
//                System.out.println("New quantity ===> " + values[1]);
                String joined = String.join(",",values);
//                System.out.println(joined);
                bw.write(joined);
                bw.newLine();
            } else {
//                System.out.print("Didn't match\n");
                bw.write(String.join(",",values));
                bw.newLine();
            }
        }
        bw.close();
        scanner.close();
        Scanner scanner2 = new Scanner(temp);
        BufferedWriter bw2 = new BufferedWriter(new FileWriter(f));
        while(scanner2.hasNextLine()){
            bw2.write(scanner2.nextLine());
            bw2.newLine();
        }
        scanner2.close();
        bw2.close();
        temp.deleteOnExit();

//        Alert a = new Alert(Alert.AlertType.NONE);
//        // set alert type
//        a.setAlertType(Alert.AlertType.CONFIRMATION);
//        // show the dialog
//        String answer = String.format("You have given %s %s",givenQuantity, item);
//        a.setContentText(answer);
//        a.show();
    }

    public void subtractQuantity(ActionEvent event) throws IOException {
        String item = albumField.getText().toString();
//        String givenQuantity = givenQuantityField.getText().toString();
        File f = new File(getClass().getResource("inventory.txt").getFile());

        songField.clear();
        albumField.clear();
        File temp;

        temp = File.createTempFile("myTempFile", ".txt");

        BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
        Scanner scanner = new Scanner(f);
        while(scanner.hasNextLine())
        {
//            System.out.println(scanner.nextLine());
            String line = scanner.nextLine();
            String[] values = line.split(",");
            values[1] = values[1].trim();
//            System.out.println("Values[0] ==> " + values[0]);
            if ((values[0].toLowerCase()).equals(item.toLowerCase())){
//                System.out.print("IN HERE\n");
//                values[1] = new String(String.valueOf(Integer.parseInt(values[1]) - Integer.parseInt(givenQuantity)));
//                System.out.println("New quantity ===> " + values[1]);
                String joined = String.join(",",values);
//                System.out.println(joined);
                bw.write(joined);
                bw.newLine();
            } else {
//                System.out.print("Didn't match\n");
                bw.write(String.join(",",values));
                bw.newLine();
            }
        }
        bw.close();
        scanner.close();
        Scanner scanner2 = new Scanner(temp);
        BufferedWriter bw2 = new BufferedWriter(new FileWriter(f));
        while(scanner2.hasNextLine()){
//            System.out.println("IN next loop");
//            System.out.println(scanner2.nextLine());
            bw2.write(scanner2.nextLine());
            bw2.newLine();
        }
        scanner2.close();
        bw2.close();
        temp.deleteOnExit();
//        Alert a = new Alert(Alert.AlertType.NONE);
//        // set alert type
//        a.setAlertType(Alert.AlertType.CONFIRMATION);
//        // show the dialog
//        String answer = String.format("You have taken %s %s",givenQuantity, item);
//        a.setContentText(answer);
//        a.show();
    }

}//end file
