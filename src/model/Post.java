package model;

import java.time.LocalDateTime;


public class Post {
    private int author;
    private LocalDateTime date;
    private String body;

    public Post(int idauthor, String body_) {
        this.author = idauthor;
        this.date = LocalDateTime.now();
        this.body = body_;
    }


    //getter methods

    public int getAuthor() {
        return this.author;
    }

    public String getBody() {
        return this.body;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public int getLenBody(){
        return this.body.length();
    }

    //setter methods

    public void setAuthor(int id){
        this.author = id;
    }

    public void setBody(String newBody){
        this.body = newBody;
    }



}
