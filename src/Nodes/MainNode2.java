package Nodes;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import model.Node;

public class MainNode2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        // Create a new node registered on a localhost IP with a port
        Node node2 = new Node(InetAddress.getByName("127.0.0.1"), 6666);

        while(true) {
            node2.connectToServer(InetAddress.getByName("127.0.0.3"), 6666);
            node2.sendMessage("Hi Server");

            node2.closeClientResources();
            Thread.sleep(100);
        }
    }
}
