package dk.cphbusiness.mrv.twitterclone.dto;

public class Post {
    public long timestamp;
    public String message;

    public Post(long timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }
}
