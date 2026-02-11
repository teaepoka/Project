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
        setPassword(password);
        this.fullName = fullName;
        setEmail(email);
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
        if(password==null || password.length()<8) {
        	throw new IllegalArgumentException(
                    "Password length must be at least 8 characters long"
                );
        }
        this.password=password;
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
        if (email == null || !email.endsWith("@gmail.com")) {
            throw new IllegalArgumentException(
                "Email must end with @gmail.com"
            );
        }
        this.email = email;
    }

}
