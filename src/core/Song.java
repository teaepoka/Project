package core;
// LUKI
import java.io.Serializable;

// This class represents a Song in the music streaming system.
// It is Serializable so it can be saved to a file.

public class Song implements Serializable {
	 private static final long serialVersionUID = 1L;

	    private String title;
	    private String artistUsername;
	    private String genre;
	    private int duration; // in seconds

	    // Constructor
	    public Song(String title, String artistUsername, String genre, int duration) {
	        this.title = title;
	        this.artistUsername = artistUsername;
	        this.genre = genre;
	        this.duration = duration;
	    }

	    // Called when a listener plays a song
	    public void play() {
	        System.out.println("Playing song: " + title + " by " + artistUsername);
	    }

	    // Getters
	    public String getTitle() {
	        return title;
	    }

	    public String getArtistUsername() {
	        return artistUsername;
	    }

	    public String getGenre() {
	        return genre;
	    }

	    public int getDuration() {
	        return duration;
	    }

	    // Setters
	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public void setGenre(String genre) {
	        this.genre = genre;
	    }

	    public void setDuration(int duration) {
	        this.duration = duration;
	    }

	    @Override
	    public String toString() {
	        return title + " - " + artistUsername + " (" + genre ;
	    }
}

