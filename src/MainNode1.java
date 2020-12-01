import java.io.IOException;
import java.net.InetAddress;

public class MainNode1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Node node1 = new Node(InetAddress.getByName("127.0.0.3"), 6666);

        while (true) {
            System.out.println("Waiting for client communication");
            node1.acceptConnection();
            node1.getClientInput();
            node1.sendClientAnswer();
            node1.closeServerResources();
        }
    }
}
