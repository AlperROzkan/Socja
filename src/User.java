import java.util.ArrayList;
import java.util.Date;
import java.util.Deque;
import java.util.Map;

public class User {
    // Attributes describing the user
    private final String firstname;
    private final String lastname;
    private String status;
    private int id; // id
    private Deque<Post> publications;
    private ArrayList<User> followed; //all other followed users 

    private static int user_count; // static variable used to count the users

    public User(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    //getters and setters

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Deque<Post> getPublications() {
        return publications;
    }

    public void setPublications(Deque<Post> publications) {
        this.publications = publications;
    }

    /**
     *
     * newPost will create a new publication and setting its new status to True,
     * while setting the new status of the previous post to False
     *
     * @param postbody, is the body of the post made by the user
     */
    public Post newPost(String postbody) {
        Post latest = publications.removeFirst();
        if (latest != null) {
            latest.setLatest(false);
        }
        publications.addFirst(latest);
        Post post = new Post(this.id, postbody);
        publications.addFirst(post);
        return post;
    }
}
