import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class MainNode2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Node node2 = new Node();

        while(true) {
            node2.connectToServer(InetAddress.getLocalHost(), 6666);
            node2.sendMessage("Hi Server");
            node2.closeClientResources();
            Thread.sleep(100);
        }
    }
}
