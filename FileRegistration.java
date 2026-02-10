package application;
import java.util.ArrayList;
import java.util.List;

import core.Song;
import core.User;
import service.*;

public class FileRegistration {
	
    public static final UserService userService = new UserService();
    
    //access users from admin to role
    public static final List<Song> allSongs = new ArrayList<>();
    //access users from admin to role
    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    //add a song to the global list
    public static void addSong(Song song) {
        allSongs.add(song);
    }
    //get all songs
    public static List<Song> getAllSongs() {
        return allSongs;
    }

    public static Song findSongByTitle(String title) {
        for (Song s : allSongs) {
            if (s.getTitle().equalsIgnoreCase(title)) 
            	return s;
        }
        return null;
    }
}


