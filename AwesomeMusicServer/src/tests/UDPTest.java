package tests;
import org.junit.Before;

import java.io.IOException;

import org.junit.Test;

public class UDPTest {
    EchoClient client;

    @Before
    public void setup(){
        client = new EchoClient();
    }

    @Test
    public void whenCanSendAndReceivePacket_thenCorrect() {
        String response;
        try {
        	// signInUser Example
//            response = client.sendRequest("{\"remoteMethod\":\"signInUser\"," +
//                                         " \"objectName\": \"LoginServices\"," +
//                                         " \"param\" : {\"email\": \"foo@email.com\", " +
//                                         			     "\"password\" : \"password\"}" +
//                                         "}");
        	
            // signUpUser Example
//        	response = client.sendRequest("{\"remoteMethod\":\"z\"," +
//                    			    	   "\"objectName\": \"LoginServices\"," +
//                    			    	   "\"param\" : {\"name\" : \"Justin Terry\"," +
//                    			    			 		"\"email\" : \"foobbar@email.com\", " +
//                    			    			 		"\"password\" : \"password\"}" +
//                    					   "}");
        	
        	// searchForSong Example
        	// If page is empty, the return will be an empty array i.e. {"ret": "[]"}
//        	response = client.sendRequest("{\"remoteMethod\":\"searchForSong\"," +
//						    			   "\"objectName\": \"SongLibraryServices\"," +
//						    			   "\"param\" : {\"searchParam\" : \" \"," +
//						    			   			    "\"pageNumber\" : \"1\"} " +
//						    			  "}");
        	
        	// Search the song library by song.id
        	// Returns a SongItem object ret : {SongItem}
        	response = client.sendRequest("{\"remoteMethod\":\"searchForSongById\"," +
						    			  "\"objectName\": \"SongLibraryServices\"," +
						    			  "\"param\" : {\"searchParam\" : \"SOMMAMA12A8C13F9E7\"}" +
						    			  "}");
        	
        	// Create a new Playlist
//        	response = client.sendRequest("{\"remoteMethod\":\"createPlaylist\"," +
//	    			   					   "\"objectName\": \"PlaylistServices\"," +
//	    			   					   "\"param\" : {\"playlistname\" : \"Test Playlist\"," +
//		   			   									"\"userId\" : \"1\"} " +
//        			   					   "}");
        	
        	// Add a song to a playlist
//        	response = client.sendRequest("{\"remoteMethod\":\"addSongToPlaylist\"," +
//	    			   					   "\"objectName\": \"PlaylistServices\"," +
//	    			   					   "\"param\" : {\"userId\" : \"1\"," +
//		   			   									"\"playlistName\" : \"Test Playlist\"," +
//		   			   									"\"songId\" : \"SOEIJSK12AB0183835\"} " +
//     			  						   "}");
        	
        	// Get all playlists for a specific userId
//        	response = client.sendRequest("{\"remoteMethod\":\"getPlaylists\"," +
//			   							   "\"objectName\": \"PlaylistServices\"," +
//			   							   "\"param\" : {\"userId\" : \"1\"} " +
//			  							  "}");
        	
//        	// Delete a playlist
//        	response = client.sendRequest("{\"remoteMethod\":\"removePlaylist\"," +
//									   	   "\"objectName\": \"PlaylistServices\"," +
//									       "\"param\" : {\"playlistname\" : \"Best Songs!\"," +
//									   					"\"userId\" : \"1\"} " +
//									       "}");
        	
        	// Delete a playlist
//        	response = client.sendRequest("{\"remoteMethod\":\"getSongChunk\"," +
//									   	   "\"objectName\": \"SongServices\"," +
//									       "\"param\" : {\"song\" : " + 490183 + "," +
//									   					"\"fragment\" : " + 1 + "} " +
//									       "}");
        	
        	System.out.println("Response sent: \n" + response);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}