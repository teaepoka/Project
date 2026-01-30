package service;
import core.User;
import data.FileManager;

import java.util.List;


public class UserService {
	
	// This list holds all the users currently in the system
    private List<User> users;

    public UserService() {
        users = FileManager.loadUsers(); // Load existing users
    }

    public void registerUser(User user) {
        users.add(user);
        FileManager.saveUsers(users);
        System.out.println("User " + user.getFullName() + " registered successfully.");
    }

    // Login method: returns a User object if credentials match
    public User login(String username, String password) {
        for(User user : users) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                user.login(username, password);
                return user;
            }
        }
        System.out.println("Login failed for username: " + username);
        return null;
    }

    // Delete a user from the system
    public void deleteUser(User user) {
        if(users.remove(user)) {
            FileManager.saveUsers(users);
            System.out.println("User " + user.getFullName() + " deleted successfully.");
        } else {
            System.out.println("User " + user.getFullName() + " not found.");
        }
    }

 // Edit/update an existing user's information
    public void editUser(User user, String fullName, String email, String password) {
        user.setFullName(fullName);
        user.setEmail(email);
        user.setPassword(password);
        FileManager.saveUsers(users);
        System.out.println("User " + user.getUsername() + " updated successfully.");
    }

 // Getter method to return all users
    public List<User> getAllUsers() {
        return users;
    }

	

}
