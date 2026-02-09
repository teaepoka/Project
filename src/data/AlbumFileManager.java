package data;
import core.Album;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Handles file input/output for Album objects.

public class AlbumFileManager {
	private static final String ALBUM_FILE = "albums.dat";

    // Save albums to file
    public static void saveAlbums(List<Album> albums) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(ALBUM_FILE))) {
            oos.writeObject(albums);
            System.out.println("Albums saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving albums: " + e.getMessage());
        }
    }

    // Load albums from file
    @SuppressWarnings("unchecked")
    public static List<Album> loadAlbums() {
        File file = new File(ALBUM_FILE);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(ALBUM_FILE))) {
            return (List<Album>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading albums: " + e.getMessage());
        }
        return new ArrayList<>();
    }
}










