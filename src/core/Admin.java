package core;
import java.util.List;
public class Admin extends User {
	

	    // Constructor
	    public Admin(String username, String password, String fullName, String email) {
	        super(username, password, fullName, email);
	    }

	    // Implement abstract login method
	    //This method provides a simple login check for the admin user.
	    //This is a simple demo login, not a real security implementation
	    @Override
	    public boolean login(String username, String password) {
	        if(this.username.equals(username) && this.password.equals(password)) {
	            System.out.println("Admin " + fullName + " logged in successfully.");
	            return true;
	        } else {
	            System.out.println("Login failed for Admin " + username);
	            return false;
	        }
	    }

	    // Implement abstract logout method
	    //This method is called when the admin logs out of the system.
	    @Override
	    public void logout() {
	        System.out.println("Admin " + fullName + " logged out successfully.");
	    }

	    // Admin-specific methods
	    //This method allows the admin to add any type of user (Listener, Artist, Admin) to the user list.
	    public void addUser(List<User> userList, User user) {
	        userList.add(user);
	        System.out.println("User " + user.getFullName() + " added successfully.");
	    }

	    //Delete an existing user from the system
	    public void deleteUser(List<User> userList, User user) {
	        if(userList.remove(user)) {
	            System.out.println("User " + user.getFullName() + " removed successfully.");
	        } else {
	            System.out.println("User " + user.getFullName() + " not found.");
	        }
	    }

	    //Allows the admin to update user information such as full name,email, and password.
	    public void editUser(User user, String fullName, String email, String password) {
	        user.setFullName(fullName);
	        user.setEmail(email);
	        user.setPassword(password);
	        System.out.println("User " + user.getUsername() + " updated successfully.");
	    }

	    //Prints a list of all users and their roles.
	    public void viewAllUsers(List<User> userList) {
	        System.out.println("All users:");
	        for(User u : userList) {
	            System.out.println("- " + u.getFullName() + " (" + u.getClass().getSimpleName() + ")");
	        }
	    }
}
