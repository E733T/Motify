package model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import static org.junit.Assert.*;


public class THAppTest {

    private static Properties properties = new Properties();
    private static Properties userProperties = new Properties();
    private static HashMap<String, String> inventory=new HashMap<String, String>();

    @org.junit.Test
    public void setUp(){
        System.out.println("Beginning test");
    }

    @org.junit.Test
    public void addUser() throws IOException {
        String user = "lfs282";
        String password = "password";
        Model.addUser("lfs282", "password");
        boolean expected = true;
        boolean actual = Model.addUser(user, password);
        assertEquals(expected,actual);
    }

    @org.junit.Test
    public void addSong() throws IOException {
//        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void deleteSong() throws IOException {
//        assertEquals(expected, actual);
    }
}