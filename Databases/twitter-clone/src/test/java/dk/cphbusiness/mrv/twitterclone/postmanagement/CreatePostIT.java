package dk.cphbusiness.mrv.twitterclone.postmanagement;

import dk.cphbusiness.mrv.twitterclone.TestBase;
import dk.cphbusiness.mrv.twitterclone.dto.Post;
import dk.cphbusiness.mrv.twitterclone.dto.UserCreation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class CreatePostIT extends TestBase {
    private UserCreation albert;

    private void createAlbert() {
        albert = getAlbert();
        um.createUser(albert);
    }

    private String createPost(String username, long timestamp) {
        time.setCurrentTime(timestamp);
        String message = "this is a post created at " + timestamp + " by " + username;
        pm.createPost(username, message);
        return message;
    }

    @Test
    public void createPostMustReturnFalseIfUserDoesNotExist() {
        // Arrange
        // Act
        var result = pm.createPost("bleb", "some post");

        // Assert
        assertFalse(result);
    }

    @Test
    @DisplayName("createPost must return true")
    public void createPostMustReturnTrue() {
        // Arrange
        var albert = getAlbert();
        um.createUser(albert);
        time.setCurrentTime(1000);
        String post = "this is a nice post, tweeet tweet";

        // Act
        var result = pm.createPost(albert.username, post);

        // Assert
        assertTrue(result);
    }

    @Test
    public void createdPostMustBeRetrieved() {
        // Arrange
        createAlbert();
        String createdMessage = createPost(albert.username, 100);

        // Act
        var posts = pm.getPosts(albert.username);

        // Assert
        assertEquals(createdMessage, posts.get(0).message);
        assertEquals(100, posts.get(0).timestamp);
    }

    @ParameterizedTest
    @CsvSource(value = {"150, 350", "200, 300"})
    public void createdPostMustBeRetrievedIfInsideInterval(String start, String end) {
        // Arrange
        createAlbert();
        String msg1 = createPost(albert.username, 100);
        String msg2 = createPost(albert.username, 200);
        String msg3 = createPost(albert.username, 300);
        String msg4 = createPost(albert.username, 400);

        // Act
        long startTime = Long.parseLong(start);
        long endTime = Long.parseLong(end);
        var posts = pm.getPostsBetween(albert.username, startTime, endTime);

        // Assert
        assertEquals(2, posts.size());
        assertEquals(msg2, posts.get(0).message);
        assertEquals(msg3, posts.get(1).message);
    }
}
