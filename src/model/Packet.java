package model;

public abstract class Packet {
    private String author;
    private String recipient;

    /**
     * Constructor of the packet class
     *
     * @param author
     * @param recipient
     */
    public Packet(String author, String recipient) {
        this.author = author;
        this.recipient = recipient;
    }

    /**
     * Getter for the author
     * @return The author of the packet
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Getter for the recipient of the packet
     * @return The recipient of the message
     */
    public String getRecipient() {
        return recipient;
    }

}
