public class PacketMessage extends Packet {
    private String message;

    /**
     * Constructor of the PacketMessage class
     * Calls Packet constructor super
     *
     * @param author The author of the packet
     * @param recipient The recipient of the message
     */
    public PacketMessage(String author, String recipient, String message) {
        super(author, recipient);
        this.message = message;
    }
}
