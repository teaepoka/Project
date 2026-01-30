package data;

import core.User;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

//This class is responsible for handling file input and output operations.
public class FileManager {
	

// File where user data will be stored
	    private static final String USER_FILE = "users.dat";

	    // Serializes the list of User objects and writes it to a file
	    public static void saveUsers(List<User> users) {
	        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USER_FILE))) {
	            oos.writeObject(users);
	            System.out.println("Users saved successfully.");
	        } catch (IOException e) {
	            System.out.println("Error saving users: " + e.getMessage());
	        }
	    }

	    //Load users from file
	 // Suppress unchecked cast warning when reading generic data from file
	    @SuppressWarnings("unchecked")
	    public static List<User> loadUsers() {
	        List<User> users = new ArrayList<>();
	        File file = new File(USER_FILE);
	        if (!file.exists()) return users;

	        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USER_FILE))) {
	            users = (List<User>) ois.readObject();
	            System.out.println("Users loaded successfully.");
	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("Error loading users: " + e.getMessage());
	        }
	        return users;
	    }

}
