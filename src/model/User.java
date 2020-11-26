package model;

import java.util.Date;
import java.util.Map;

public class User {
    // Attributes describing the user
    private final String firstname;
    private final String lastname;
    private String status;
    private int id; // id
    private Map<Date, Post> publications;

    private static int user_count; // static variable used to count the users

    public User(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

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

    public Map<Date, Post> getPublications() {
        return publications;
    }

    public void setPublications(Map<Date, Post> publications) {
        this.publications = publications;
    }
}