package service;

import core.Album;
import core.Song;
import data.AlbumFileManager;

import java.util.List;

// Service class that manages album-related operations.

public class AlbumService {

	private List<Album> albums;

    public AlbumService() {
        albums = AlbumFileManager.loadAlbums();
    }

    // Create a new album
    public void createAlbum(Album album) {
        albums.add(album);
        AlbumFileManager.saveAlbums(albums);
        System.out.println("Album \"" + album.getTitle() + "\" created successfully.");
    }

    // Add a song to an album
    public void addSongToAlbum(Album album, Song song) {
        album.addSong(song);
        AlbumFileManager.saveAlbums(albums);
    }

    // Return all albums
    public List<Album> getAllAlbums() {
        return albums;
    }
	
}

