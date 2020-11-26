import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketClient {
    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException {
        InetAddress host = InetAddress.getLocalHost(); // get IP of the host
        Socket socket = null; // socket to connect to the host

        // Fluxes to get and send messages
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        // Scanner to write messages to the host
        Scanner sc = new Scanner(System.in);

        for(int i=0; i<6; i++) {
            // Connect to a server
            socket = new Socket(host.getHostName(), 9876);
            oos = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Sending request to socket");

            // Ping the server 5 times before stopping
            if (i==5)
                oos.writeObject("exit");
            else
                // Write a message to send to the host
                System.out.print("Me : ");
                oos.writeObject(sc.nextLine());

            // Print message that the server sent
            ois = new ObjectInputStream(socket.getInputStream());
            String message = (String) ois.readObject();
            System.out.println("Host : " + message);

            // Close resources
            ois.close();
            oos.close();
            Thread.sleep(100);
        }

    }
}
