package core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// This class represents an Album in the music streaming system.
// An album belongs to an artist and contains multiple songs.
public class Album implements Serializable {
	private static final long serialVersionUID = 1L;

    private String title;
    private String artistUsername;
    private List<Song> songs;

    // Constructor
    public Album(String title, String artistUsername) {
        this.title = title;
        this.artistUsername = artistUsername;
        this.songs = new ArrayList<>();
    }

    // Add a song to the album
    public void addSong(Song song) {
        songs.add(song);
        System.out.println("Song \"" + song.getTitle() + "\" added to album \"" + title + "\".");
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getArtistUsername() {
        return artistUsername;
    }

    public List<Song> getSongs() {
        return songs;
    }

    @Override
    public String toString() {
        return title + " by " + artistUsername + " (" + songs.size() + " songs)";
    }
}
