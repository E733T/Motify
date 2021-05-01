package model;

import javafx.scene.control.Alert;

import java.io.*;
import java.util.HashMap;
import java.util.Properties;

public class Model {
    private static HashMap<String, String> h1 = new HashMap<String,String>();
    private static HashMap<String, String> inventory=new HashMap<String, String>();
    private static HashMap<String, String> users=new HashMap<String, String>();
    private static Properties properties = new Properties();
    private static Properties userProperties = new Properties();


    public static boolean addUser(String user, String password) throws IOException {
//        Properties properties = new Properties();

        if(user==null || user.isEmpty() || password==null || password.isEmpty()){
            Alert error=new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error message");
            error.setHeaderText("Missing Information");
            error.setContentText("Please, try again!");
            error.showAndWait();
            return false;
        }

        users.put(user, password);

        userProperties.putAll(users);
        System.out.println(userProperties);

        properties.load(new FileInputStream("users.properties"));
        for (String keys:userProperties.stringPropertyNames()){
            inventory.put(keys, userProperties.get(keys).toString());
        }
        if (inventory.containsKey(user)){
//            System.out.println("That user already exists, exiting");
            return true;
        }

        File file = new File("users.properties");
        FileOutputStream writer=new FileOutputStream(file,true);
        properties.store(writer, null);
        return true;
    }

    public static int addItem(String key, String value) throws IOException {

        if(key==null || key.isEmpty() || value == null || value.isEmpty()){
            Alert error=new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error message");
            error.setHeaderText("Missing Information");
            error.setContentText("Please, try again!");
            error.showAndWait();
        } else {
            int oldValue=0, newValue=0;
            properties.load(new FileInputStream("songs.properties"));
            for (String keys:properties.stringPropertyNames()){
                inventory.put(keys, properties.get(keys).toString());
            }
            if (inventory.containsKey(key)){
                System.out.println("In if ");
                oldValue=Integer.parseInt(inventory.get(key).toString());
                newValue=oldValue+Integer.parseInt(value);
                h1.put(key,String.valueOf(newValue));
                System.out.println(oldValue);
                System.out.println(newValue);
            } else {
                System.out.println("In else ");
                h1.put(key,value);
            }
            properties.putAll(h1);
            FileOutputStream file = new FileOutputStream("songs.properties",true);
            properties.store(file, null);
        }

        return Integer.parseInt(value);
    }

    public static int subtractItem(String key, String value) throws IOException {

        if(key==null || key.isEmpty() || value == null || value.isEmpty()){
            Alert error=new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error message");
            error.setHeaderText("Missing Information");
            error.setContentText("Please, try again!");
            error.showAndWait();
        } else {
            int oldValue=0, newValue=0;
            properties.load(new FileInputStream("songs.properties"));
            for (String keys:properties.stringPropertyNames()){
                inventory.put(keys, properties.get(keys).toString());
            }
            if (inventory.containsKey(key)){
                oldValue=Integer.parseInt(inventory.get(key).toString());
                newValue=oldValue-Integer.parseInt(value);
                h1.put(key,String.valueOf(newValue));
                System.out.println(oldValue);
                System.out.println(newValue);
            }
            properties.putAll(h1);
            FileOutputStream file = new FileOutputStream("songs.properties",true);
            properties.store(file, null);
        }
        return Integer.parseInt(value);
    }

    public static String getNumberOfItemsInInventory(String key) throws IOException {

        if(key==null || key.isEmpty()){
//            Alert error=new Alert(Alert.AlertType.ERROR);
//            error.setTitle("Error message");
//            error.setHeaderText("Missing Information");
//            error.setContentText("Please, try again!");
//            error.showAndWait();
        } else {
//            int oldValue=0, newValue=0;
            properties.load(new FileInputStream("songs.properties"));
            for (String keys:properties.stringPropertyNames()){
                inventory.put(keys, properties.get(keys).toString());
            }
            if (inventory.containsKey(key)){
//                oldValue=Integer.parseInt(inventory.get(key).toString());
//                newValue=oldValue-Integer.parseInt(value);
//                h1.put(key,String.valueOf(newValue));

//                System.out.println(oldValue);
//                System.out.println(newValue);
//                System.out.print(inventory.get(key));
                return String.valueOf(Integer.parseInt(inventory.get(key)));
            }
//            properties.putAll(h1);
//            FileOutputStream file = new FileOutputStream("songs.properties",true);
//            properties.store(file, null);
        }

        return String.valueOf(Integer.parseInt(key) - 1);
    }
}
