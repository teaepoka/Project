package core;
import java.util.ArrayList;
import java.util.List;

//This class represents an artist user in the music streaming system.

public class Artist extends User {
	
	// List that stores the names of songs uploaded by this artist
	 private List<String> songsUploaded;

	    public Artist(String username, String password, String fullName, String email) {
	        super(username, password, fullName, email);
	        this.songsUploaded = new ArrayList<>();
	    }

	    //Performs a simple check to verify artist credentials
	    @Override
	    public boolean login(String username, String password) {
	        if(this.username.equals(username) && this.password.equals(password)) {
	            System.out.println("Artist " + fullName + " logged in successfully.");
	            return true;
	        } else {
	            System.out.println("Login failed for Artist " + username);
	            return false;
	        }
	    }

	    
	    //Displays a message when the artist logs out of the system
	    @Override
	    public void logout() {
	        System.out.println("Artist " + fullName + " logged out successfully.");
	    }

	    //Adds a song name to the list of uploaded songs.
	    public void uploadSong(String songName) {
	        songsUploaded.add(songName);
	        System.out.println("Song \"" + songName + "\" uploaded by " + fullName);
	    }

	    //Displays all songs that were uploaded by this artist
	    public void viewUploadedSongs() {
	        System.out.println("Songs uploaded by " + fullName + ":");
	        for(String song : songsUploaded) {
	            System.out.println("- " + song);
	        }
	    }

	    //Removes a song from the artist's uploaded list if it exists.
	    public void removeSong(String songName) {
	        if(songsUploaded.remove(songName)) {
	            System.out.println("Song \"" + songName + "\" removed successfully.");
	        } else {
	            System.out.println("Song \"" + songName + "\" not found.");
	        }
	    }

	    //Returns the list of songs uploaded by the artist.
	    public List<String> getSongsUploaded() {
	        return songsUploaded;
	    }

		
}
