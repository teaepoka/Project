package application;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

import core.*;

public class Role {

    public static void show(Stage stage, User user) {
    	    	
        Label welcome = new Label("Welcome, " + user.getFullName());
        Button logout = new Button("Logout");
        
        welcome.setStyle("-fx-text-fill: #F7EC74;"+"-fx-font-weight: bold;"+"-fx-font-size: 30px;");
        logout.setStyle("-fx-text-fill: #F5534B;"+"-fx-background-color: #F7EC74;"+"-fx-font-weight: bold;");

        VBox root = new VBox(10, welcome);
        root.setStyle("-fx-background-color: #ED9E9A");

        if (user instanceof Listener) {
        	Listener listener = (Listener) user;

    	    TextField songField = new TextField();
    	    songField.setPromptText("Enter song title");
    	    Button play = new Button("Play Song");
    	    
    	    Label mesg = new Label();
            mesg.setStyle("-fx-text-fill: #D10700;"+"-fx-font-weight: bold;"+"-fx-font-size: 15px;");
    	    
    	    play.setStyle("-fx-text-fill: #F5534B;"+"-fx-background-color: #F7EC74;"+"-fx-font-weight: bold;");
    	    play.setOnAction(e -> {
    	    String name = songField.getText();
    	    Song song = listener.findSongByTitle(name); 
            if (song != null) {
        	    listener.listenToSong(songField.getText());
        	    mesg.setText(user.getUsername()+" is listening to "+name);
            } else {
                System.out.println("Song not found");
                mesg.setText("Song not found");
            }
    	    });

    	    Label playlistLabel = new Label("Manage Playlists");
    	    playlistLabel.setStyle("-fx-text-fill: #F7EC74; -fx-font-weight: bold; -fx-font-size: 15px;");

    	    TextField newPlaylistField =new TextField();
    	    newPlaylistField.setPromptText("New Playlist Name");
    	    Button createPlaylistBtn =new Button("Create Playlist");
    	    createPlaylistBtn.setStyle("-fx-text-fill: #F5534B;"+"-fx-background-color: #F7EC74;"+"-fx-font-weight: bold;");

    	    ComboBox<Playlist> playlistCombo = new ComboBox<>();
    	    playlistCombo.setPromptText("Select Playlist");

    	    TextField addSongField = new TextField();
    	    addSongField.setPromptText("Song to add");
    	    
    	    Button addSongBtn = new Button("Add Song");
    	    addSongBtn.setStyle("-fx-text-fill: #F5534B;"+"-fx-background-color: #F7EC74;"+"-fx-font-weight: bold;");

    	    Button viewPlaylistBtn = new Button("View Playlist");
    	    viewPlaylistBtn.setStyle("-fx-text-fill: #F5534B;"+"-fx-background-color: #F7EC74;"+"-fx-font-weight: bold;");
    	    
    	    
    	    createPlaylistBtn.setOnAction(e -> {
    	        String name = newPlaylistField.getText();
    	        if (!name.isEmpty()) {
    	            Playlist playlist = new Playlist(name, listener.getUsername());
    	            listener.addPlaylist(playlist); 
    	            playlistCombo.getItems().add(playlist);
    	            mesg.setText("Playlist created: " + name);
    	        }
    	    });

    	    addSongBtn.setOnAction(e -> {
    	        Playlist selected = playlistCombo.getValue();
    	        String songTitle = addSongField.getText();
    	        if (selected != null && !songTitle.isEmpty()) {
    	            Song song = listener.findSongByTitle(songTitle); 
    	            if (song != null) {
    	                selected.addSong(song);
    	                mesg.setText(songTitle + " added to "+selected);
    	            } else {
    	                mesg.setText("Song not found");
    	            }
    	        }
    	    });

    	    viewPlaylistBtn.setOnAction(e -> {
    	        Playlist selected = playlistCombo.getValue();
    	        if (selected != null) {
    	            mesg.setText(selected.viewPlaylist());
    	        }
    	    });

    	    root.getChildren().addAll(songField, play, playlistLabel, newPlaylistField, createPlaylistBtn,
    	                              playlistCombo, addSongField, addSongBtn, viewPlaylistBtn, mesg);
    	}
        
    	List<Album> allAlbums = new ArrayList<>();

        if (user instanceof Artist) {
        	Label songName = new Label("Song Name");
            TextField song = new TextField();
            
        	ComboBox<String> genreCombo = new ComboBox<>();
            genreCombo.getItems().addAll("Pop", "Rock", "Jazz", "Classical", "Hip Hop", "Electronic");
            genreCombo.setPromptText("Select Genre");
            
            Label songDuration = new Label("Song Duration");
            TextField Duration = new TextField();
            
            Label albumLabel = new Label("Album Name");
            TextField albumField = new TextField();
       
            Button upload = new Button("Upload Song");
            
            song.setStyle("-fx-background-color: #F5F3DC");
            Duration.setStyle("-fx-background-color: #F5F3DC");
            albumField.setStyle("-fx-background-color: #F5F3DC");
            upload.setStyle("-fx-text-fill: #F5534B;"+"-fx-background-color: #F7EC74;"+"-fx-font-weight: bold;");
            
            songName.setStyle("-fx-text-fill: #F7EC74;"+"-fx-font-weight: bold;"+"-fx-font-size: 15px;");
            songDuration.setStyle("-fx-text-fill: #F7EC74;"+"-fx-font-weight: bold;"+"-fx-font-size: 15px;");
            albumLabel.setStyle("-fx-text-fill: #F7EC74;"+"-fx-font-weight: bold;"+"-fx-font-size: 15px;");

            Label mesg = new Label();
            mesg.setStyle("-fx-text-fill: #D10700;"+"-fx-font-weight: bold;"+"-fx-font-size: 15px;");

            upload.setOnAction(e ->
            {
            String title = song.getText();
            String genre = genreCombo.getValue();
            String durationStr = Duration.getText();
            String albumTitle = albumField.getText();
            

            if(title.isEmpty() || durationStr.isEmpty()|| genre == null || albumTitle.isEmpty()) {
                mesg.setText("Please enter all song details!");
                return; }
            
            int duration;
            try {
                duration = Integer.parseInt(durationStr);
            } catch(NumberFormatException ex) {
                mesg.setText("Duration must be a number!");
                return;
            }

            //create song
            Song newestSong = new Song(title, ((Artist) user).getUsername() , genre, duration);
            FileRegistration.allSongs.add(newestSong); 

            Album album = null;
            for(Album a : allAlbums) {
                if(a.getTitle().equalsIgnoreCase(albumTitle) &&
                   a.getArtistUsername().equalsIgnoreCase(((Artist) user).getUsername())) {
                    album = a;
                    break;
                }
            }
            if(album == null) {
                album = new Album(albumTitle, ((Artist) user).getUsername());
                allAlbums.add(album);
            }
            album.addSong(newestSong);

            ((Artist) user).uploadSong(title);
            mesg.setText("Song "+title+" uploded by "+user.getUsername() +" ,Genre: " + genre + " ,Duration: " + duration + " seconds" + " ,Album: "+ albumTitle);
        });

        root.getChildren().addAll(songName, song, genreCombo, songDuration, Duration, albumLabel, albumField, upload, mesg);
    }

        if (user instanceof Admin) {
        	
        	Label adminLabel = new Label("Admin Dashboard");
            adminLabel.setStyle("-fx-text-fill: #F7EC74;"+"-fx-font-weight: bold;"+"-fx-font-size: 15px;");

            Admin admin = (Admin) user;
            List<User> users1 = FileRegistration.userService.getAllUsers();

            TextField usernameField = new TextField();
            usernameField.setPromptText("Username");

            Button add = new Button("Add User");
            Button delete = new Button("Delete User");
            Button viewUsers = new Button("View Users");
            
            add.setStyle("-fx-text-fill: #F5534B;"+"-fx-background-color: #F7EC74;"+"-fx-font-weight: bold;");
            delete.setStyle("-fx-text-fill: #F5534B;"+"-fx-background-color: #F7EC74;"+"-fx-font-weight: bold;");
            viewUsers.setStyle("-fx-text-fill: #F5534B;"+"-fx-background-color: #F7EC74;"+"-fx-font-weight: bold;");

            Label mesg = new Label();
            mesg.setStyle("-fx-text-fill: #D10700;"+"-fx-font-weight: bold;"+"-fx-font-size: 15px;");

            add.setOnAction(e -> {
                User newUser = new Listener(usernameField.getText(), "password1234",
                        usernameField.getText()+" full name","mail@gmail.com");
                admin.addUser(users1, newUser);
                mesg.setText("User " + newUser.getUsername() + " added successfully.");
                });

            delete.setOnAction(e -> {
                for (User u : users1) {
                    if (u.getUsername().equals(usernameField.getText())) {
                        admin.deleteUser(users1, u);
                        mesg.setText("User " + u.getUsername() + " removed successfully.");
                        return;
                    }
                }
                mesg.setText("User not found.");});

            viewUsers.setOnAction(e ->{
            mesg.setText(admin.viewAllUsers(users1));
            mesg.setWrapText(true);
            });
            root.getChildren().addAll(adminLabel, usernameField, add, delete, viewUsers, mesg);
        }

        logout.setOnAction(e -> Login.show(stage));
        root.getChildren().add(logout);

        stage.setScene(new Scene(root, 350, 450));
        stage.setTitle("Admin Dashboard");
    }
}
