package server;

public class ServerMain {

	public static void main(String[] args) {
		// Create the song library
		SongLibrary.getInstance();
		// Start the server
		new Server().start();
		
		SongLibraryServices sls = new SongLibraryServices();
		System.out.println(sls.searchForSong("The", "1"));
	}

}
