import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {
    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException {
        InetAddress host = InetAddress.getLocalHost(); // get IP of the host
        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        for(int i=0; i<11; i++) {
            socket = new Socket(host.getHostName(), 9876);
            oos = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Sending request to socket");

            // Exit if sent out too many request
            if (i==10)
                oos.writeObject("exit");
            // Send number of messages recieved
            else
                oos.writeObject(""+i);

            ois = new ObjectInputStream(socket.getInputStream());
            String message = (String) ois.readObject();
            System.out.println("Message: " + message);
            //close resources
            ois.close();
            oos.close();
            Thread.sleep(100);
        }

    }
}
