package dk.cphbusiness.mrv.twitterclone.contract;

import dk.cphbusiness.mrv.twitterclone.dto.Post;

import java.util.List;
import java.util.Set;

public interface PostManagement {
    boolean createPost(String username, String message);
    List<Post> getPosts(String username);
    List<Post> getPostsBetween(String username, long timeFrom, long timeTo);
}
