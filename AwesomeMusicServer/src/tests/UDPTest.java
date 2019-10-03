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
//                                         			   "\"password\" : \"password\"}" +
//                                         "}");
            // signUpUser Example
//        	response = client.sendRequest("{\"remoteMethod\":\"z\"," +
//                    			    "\"objectName\": \"LoginServices\"," +
//                    			    "\"param\" : {\"name\" : \"Justin Terry\"," +
//                    			    			 "\"email\" : \"foobbar@email.com\", " +
//                    			    			 "\"password\" : \"password\"}" +
//                    				"}");
        	// searchForSong Example
        	// If page is empty, the return will be an empty array i.e. {"ret": "[]"}
        	response = client.sendRequest("{\"remoteMethod\":\"searchForSong\"," +
						    			   "\"objectName\": \"SongLibraryServices\"," +
						    			   "\"param\" : {\"searchParam\" : \"the\"," +
						    			   			    "\"pageNumber\" : \"1\"} " +
						    			  "}");
        	System.out.println(response);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}