package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server extends Thread{
	private DatagramSocket socket;
    private boolean running;
    private byte[] buf;

    public Server() {
        try {
            socket = new DatagramSocket(3000);
        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void run() {
        running = true;
        while (running) {
            buf = new byte[256];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            try {
                socket.receive(packet);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            packet = new DatagramPacket(buf, buf.length, address, port);
            System.out.println(new String(packet.getData()));
            String received = new String(packet.getData(), 0, packet.getLength());

            try {
                socket.send(packet);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            if (received.trim().equals("end")) {
                running = false;
                continue;
            }
        }
        socket.close();
    }
}