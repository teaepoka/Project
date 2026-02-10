package core;
//LUKI
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//This class represents a Playlist in the music streaming system.
// A playlist contains multiple Song objects.

public class Playlist implements Serializable{
	 private static final long serialVersionUID = 1L;

	    private String name;
	    private String ownerUsername; // Listener or Artist
	    private List<Song> songs;

	    // Constructor
	    public Playlist(String name, String ownerUsername) {
	        this.name = name;
	        this.ownerUsername = ownerUsername;
	        this.songs = new ArrayList<>();
	    }

	    // Add a song to the playlist
	    public void addSong(Song song) {
	        songs.add(song);
	        System.out.println("Song \"" + song.getTitle() + "\" added to playlist \"" + name + "\".");
	    }

	    // Remove a song from the playlist
	    public void removeSong(Song song) {
	        if (songs.remove(song)) {
	            System.out.println("Song \"" + song.getTitle() + "\" removed from playlist \"" + name + "\".");
	        } else {
	            System.out.println("Song not found in playlist.");
	        }
	    }

	    //Display all songs in the playlist
	    public String viewPlaylist() {
	        StringBuilder sb = new StringBuilder();
	        sb.append("Playlist: ").append(name).append("\n");
	        for (Song s : songs) {
	            sb.append("- ").append(s).append("\n");
	        }
	        return sb.toString();
	    }

	    // Getters
	    public String getName() {
	        return name;
	    }

	    public String getOwnerUsername() {
	        return ownerUsername;
	    }

	    public List<Song> getSongs() {
	        return songs;
	    }
	 @Override
	    public String toString() {
	        return name;
	    }
	  }



