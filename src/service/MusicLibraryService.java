package service;
import core.Song;
import data.MusicFileManager;
import java.util.List;
// LUKI
//Service class that manages all music-related operations

public class MusicLibraryService {
	 private List<Song> songs;

	    public MusicLibraryService() {
	        songs = MusicFileManager.loadSongs();
	    }

	    // Artist uploads a song
	    public void addSong(Song song) {
	        songs.add(song);
	        MusicFileManager.saveSongs(songs);
	        System.out.println("Song \"" + song.getTitle() + "\" added to library.");
	    }

	    // Remove song
	    public void removeSong(Song song) {
	        if (songs.remove(song)) {
	            MusicFileManager.saveSongs(songs);
	            System.out.println("Song \"" + song.getTitle() + "\" removed.");
	        } else {
	            System.out.println("Song not found.");
	        }
	    }

	    // Find song by title
	    public Song findSongByTitle(String title) {
	        for (Song s : songs) {
	            if (s.getTitle().equalsIgnoreCase(title)) {
	                return s;
	            }
	        }
	        return null;
	    }

	    // Return all songs
	    public List<Song> getAllSongs() {
	        return songs;
	    }
}









