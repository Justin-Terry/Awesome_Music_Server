package server;

public class ServerMain {

	public static void main(String[] args) {
		// Create the song library
		SongLibrary.getInstance();
		// Start the server
		new Server().start();
	}

}