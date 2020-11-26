import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    private static ServerSocket server;
    private static int port = 9876; // port to listen to

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        server = new ServerSocket(port);

        while (true) {
            System.out.println("Waiting for client connection : ");
            Socket socket = server.accept();
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            String message = (String)ois.readObject();
            System.out.println("Got message !!");

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject("HIIIIIIIIIIIIIIIIIIIIIIII " + message);

            ois.close();
            oos.close();
            socket.close();

            if(message.equalsIgnoreCase("exit")) break;
        }
        System.out.println("Shutting down Socket server!!");
        server.close();
    }
}
