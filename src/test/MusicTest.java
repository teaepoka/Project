package test;

// LUKI

import core.Song;
import core.Playlist;
import service.MusicLibraryService;

public class MusicTest {

	public static void main(String[] args) {
		
		System.out.println("=== MUSIC SYSTEM TEST START ===");

        // 1️ Create the music library (loads songs from file if any exist)
        MusicLibraryService musicService = new MusicLibraryService();

        // 2️ Create songs (simulate artist upload)
        Song song1 = new Song("Blinding Lights", "artist1", "Pop", 200);
        Song song2 = new Song("Levitating", "artist1", "Pop", 203);

        // 3️ Add songs to library
        musicService.addSong(song1);
        musicService.addSong(song2);

        // 4️ Display all songs
        System.out.println("\nAll songs in library:");
        for (Song s : musicService.getAllSongs()) {
            System.out.println(s);
        }

        // 5️ Play a song (simulate listener)
        System.out.println("\nPlaying a song...");
        song1.play();
        song1.play();

        // 6️ Create a playlist
        Playlist playlist = new Playlist("My Favorites", "listener1");

        // 7️ Add songs to playlist
        playlist.addSong(song1);
        playlist.addSong(song2);

        // 8️ View playlist contents
        System.out.println("\nViewing playlist:");
        playlist.viewPlaylist();

        System.out.println("\n=== MUSIC SYSTEM TEST END ===");
     }
}
