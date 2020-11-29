import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Node {
    // **********************
    // Server side attributes
    // **********************
    private ServerSocket server;
    private int portListen; // port to recieve messages to
    private Socket socketServer; // this will be the connection request from the client
    private ObjectInputStream oisServer; // buffer to get the client input
    private ObjectOutputStream oosServer; // buffer to send back a message to the client

    // **********************
    // Client side attributes
    // **********************
    private InetAddress hostIp; // node to talk to
    private Socket socketClient; // socket from which the node connect to host node
    private ObjectOutputStream oosClient;
    private ObjectInputStream oisClient;


    // Constructor
    public Node() {
        super();
        oosClient = null;
        oisClient = null;
    }

    public Node(int portListen) throws IOException {
        this.portListen = portListen;
        this.server = new ServerSocket(this.portListen); // open server for listening to message
    }

    // *******************
    // Server side methods
    // *******************
    /**
     * Accept the connection from the client
     * @throws IOException
     */
    public void acceptConnection() throws IOException {
        socketServer = server.accept();
    }

    /**
     * Get the client input
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void getClientInput() throws IOException, ClassNotFoundException {
        oisServer = new ObjectInputStream(socketServer.getInputStream());
        String message = (String)oisServer.readObject();
        System.out.println("Client : " + message);
    }

    /**
     * Send a confirmation message to the client
     * @throws IOException
     */
    public void sendClientAnswer() throws IOException {
        oosServer = new ObjectOutputStream(socketServer.getOutputStream());
        oosServer.writeObject("Got your message");
    }

    /**
     * Close all server resources
     * @throws IOException
     */
    public void closeServerResources() throws IOException {
        oisServer.close();
        oosServer.close();
        socketServer.close();
    }

    // *******************
    // Client side methods
    // *******************
    /**
     * Connect to the server side of the node
     * @param host IP of the host
     * @param hostPort Port of the host
     * @throws IOException
     */
    public void connectToServer(InetAddress host, int hostPort) throws IOException {
        socketClient = new Socket(host, hostPort);
        oosClient = new ObjectOutputStream(socketClient.getOutputStream());
    }

    /**
     * Send a message to the person connected to
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException, ClassNotFoundException {
        oosClient.writeObject(message);

        // Print message that the server sent
        oisClient = new ObjectInputStream(socketClient.getInputStream());
        String responseServer = (String) oisClient.readObject();
        System.out.println("Host : " + responseServer);
    }

    /**
     * Close client resources
     * @throws IOException
     */
    public void closeClientResources() throws IOException {
        oisClient.close();
        oosClient.close();
    }
}
