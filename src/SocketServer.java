import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    private static ServerSocket server;
    private static final int port = 9876; // port to listen to

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        server = new ServerSocket(port); // Open a server to a port

        while (true) {
            System.out.println("Waiting for client connection : ");

            // Accept connection to socket from the client
            Socket socket = server.accept();

            // Get input from client
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String message = (String)ois.readObject();
            System.out.println("Client : " + message);

            // Send an answer to the client
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject("You told me \"" + message + "\"");

            // Close ressources
            ois.close();
            oos.close();
            socket.close();

            if(message.equalsIgnoreCase("exit")) break;
        }
        System.out.println("Shutting down Socket server!!");
        server.close();
    }
}
