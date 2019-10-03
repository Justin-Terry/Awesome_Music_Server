package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * LoginServices Class
 * 
 * @author Justin
 * @resources https://www.baeldung.com/udp-in-java
 */

public class Server extends Thread {
	private final int BUF_LENGTH = 256;
	private DatagramSocket socket;
	private boolean running;
	private byte[] buf;

	// Creates server and assigns it to a port, 3000.
	public Server() {
		try {
			socket = new DatagramSocket(3000);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Starts a thread for the server and gets it running
	public void run() {
		System.out.println("Server Up");
		running = true;
		while (running) {
			// This byte buffer may need to be adjusted for our application
			buf = new byte[BUF_LENGTH];
			// Creates a DatagramPacket with an empty byte array and a length of BUF_LENGTH
			DatagramPacket packet = new DatagramPacket(buf, BUF_LENGTH);
			try {
				// Attempt to receive packet
				socket.receive(packet);
			} catch (IOException e) {
				e.printStackTrace();
			}

			// Get some info from the packet for the return
			InetAddress address = packet.getAddress();
			int port = packet.getPort();

			// Create an instance of the dispatcher and pass it the request
			Dispatcher dis = new Dispatcher();
			String returnString = dis.dispatch(new String(packet.getData()));
			System.out.println(returnString.length() + " " + returnString);
			// Add the returned string to the buffer
			buf = returnString.getBytes();
			// Create the return packet
			packet = new DatagramPacket(buf, buf.length, address, port);

			try {
				// Return the packet
				socket.send(packet);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		socket.close();
	}
}