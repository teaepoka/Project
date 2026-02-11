package test;
import service.UserService;
import core.*;
import java.util.Scanner;
import java.util.List;

public class Main {

	public static void main(String[] args) {		
		
		Scanner sc = new Scanner(System.in);
        UserService userService = new UserService();

        System.out.println("=== CREATE A NEW USER ===");

        // Ask for type of user
        System.out.print("Enter user type (Listener/Artist/Admin): ");
        String userType = sc.nextLine().trim();

        // Ask for common data
        System.out.print("Enter username: ");
        String username = sc.nextLine().trim();

        System.out.print("Enter password: ");
        String password = sc.nextLine().trim();

        System.out.print("Enter full name: ");
        String fullName = sc.nextLine().trim();

        System.out.print("Enter email: ");
        String email = sc.nextLine().trim();

        // Create user based on type
        User user = null;
        switch (userType.toLowerCase()) {
            case "listener":
                user = new Listener(username, password, fullName, email);
                break;
            case "artist":
                user = new Artist(username, password, fullName, email);
                break;
            case "admin":
                user = new Admin(username, password, fullName, email);
                break;
            default:
                System.out.println("Invalid user type!");
                System.exit(0);
        }

        // Register user
        userService.registerUser(user);

        System.out.println("\n=== LOGIN TEST ===");
        System.out.print("Enter username to login: ");
        String loginUsername = sc.nextLine().trim();

        System.out.print("Enter password: ");
        String loginPassword = sc.nextLine().trim();

        User loggedInUser = userService.login(loginUsername, loginPassword);

        if (loggedInUser != null) {
            System.out.println("Login successful! Welcome " + loggedInUser.getFullName());
        } else {
            System.out.println("Login failed!");
        }

        // Optional: test specific methods
        if (loggedInUser instanceof Listener) {
            Listener l = (Listener) loggedInUser;
            System.out.print("Enter a song to listen to: ");
            String song = sc.nextLine().trim();
            l.listenToSong(song);
        } else if (loggedInUser instanceof Artist) {
            Artist a = (Artist) loggedInUser;
            System.out.print("Enter a song to upload: ");
            String song = sc.nextLine().trim();
            a.uploadSong(song);
        }

        // View all users for Admin
        if (loggedInUser instanceof Admin) {
            Admin admin = (Admin) loggedInUser;
            admin.viewAllUsers(userService.getAllUsers());
        }

        sc.close();
    }

	}


