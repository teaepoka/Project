package core;

import java.io.Serializable;

public abstract class User implements Serializable{
	// Required for Serializable classes
	  private static final long serialVersionUID = 1L;
	  
	// Common attributes for all users
    protected String username;
    protected String password;
    protected String fullName;
    protected String email;

    // Constructor
    public User(String username, String password, String fullName, String email) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
    }

    //Abstract methods to be implemented by subclasses
    public abstract boolean login(String username, String password);
    public abstract void logout();

    //Common methodfor displaying basic account information
    public void viewProfile() {
        System.out.println("Username: " + username);
        System.out.println("Full Name: " + fullName);
        System.out.println("Email: " + email);
    }

    //Allows users to update their profile details.
    public void editProfile(String fullName, String email, String password) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        System.out.println("Profile updated successfully.");
    }

    
    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Password setter (simple demo, not encrypted)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
