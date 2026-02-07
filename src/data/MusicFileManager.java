package data;
import core.Song;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Handles file input/output for Song objects.

public class MusicFileManager {
	 private static final String SONG_FILE = "songs.dat";

	    // Save list of songs to file
	    public static void saveSongs(List<Song> songs) {
	        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SONG_FILE))) {
	            oos.writeObject(songs);
	            System.out.println("Songs saved successfully.");
	        } catch (IOException e) {
	            System.out.println("Error saving songs: " + e.getMessage());
	        }
	    }

	    // Load songs from file
	    @SuppressWarnings("unchecked")
	    public static List<Song> loadSongs() {
	        List<Song> songs = new ArrayList<>();
	        File file = new File(SONG_FILE);

	        if (!file.exists()) return songs;

	        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SONG_FILE))) {
	            songs = (List<Song>) ois.readObject();
	            System.out.println("Songs loaded successfully.");
	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("Error loading songs: " + e.getMessage());
	        }
	        return songs;
	    }
}


