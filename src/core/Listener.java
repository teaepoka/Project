package core;

public class Listener extends User {

    public Listener(String username, String password, String fullName, String email) {
        super(username, password, fullName, email);
    }

    @Override
    public boolean login(String username, String password) {
        if(this.username.equals(username) && this.password.equals(password)) {
            System.out.println("Listener " + fullName + " logged in successfully.");
            return true;
        } else {
            System.out.println("Login failed for Listener " + username);
            return false;
        }
    }

    @Override
    public void logout() {
        System.out.println("Listener " + fullName + " logged out successfully.");
    }

    // Listener-specific method
    public void listenToSong(String songName) {
        System.out.println(fullName + " is listening to: " + songName);
    }
	
}
