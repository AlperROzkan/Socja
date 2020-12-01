package Nodes;

import java.io.IOException;
import java.net.InetAddress;
import model.Node;


public class MainNode1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Create a new node registered on a localhost IP with a port
        Node node1 = new Node(InetAddress.getByName("127.0.0.3"), 6666);

        while (true) {
            System.out.println("Waiting for client communication");

            node1.acceptConnection(); // accept incoming connections
            node1.getClientInput(); // get their message
            node1.sendClientAnswer(); // send back confirmation
            node1.closeServerResources(); // close all resources
        }
    }
}
