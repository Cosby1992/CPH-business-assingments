package dk.cphbusiness.mrv.twitterclone.usermanagement;

import dk.cphbusiness.mrv.twitterclone.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class FollowUserIT extends TestBase {
    @Test
    @DisplayName("Must be able to follow user")
    public void mustBeAbleToFollowUser() {
        // Arrange
        var albert = getAlbert();
        var benny = getBenny();
        um.createUser(albert);
        um.createUser(benny);

        // Act
        var result = um.followUser(albert.username, albert.username);

        // Assert
        assertTrue(result);
    }

    @Test
    @DisplayName("Followed user must have a follower")
    public void followedUserMustHaveFollower() {
        // Arrange
        var albert = getAlbert();
        var benny = getBenny();
        um.createUser(albert);
        um.createUser(benny);

        // Act
        um.followUser(albert.username, benny.username);
        var followingBenny = um.getUsersFollowing(benny.username);

        // Assert
        assertTrue(followingBenny.contains(albert.username),
                "if a follows b, then the result of getUsersFollowing(b) should contain a");
    }

    @Test
    @DisplayName("FollowUser must return null if username does not exist")
    public void followUserMustReturnNullIfUsernameDoesNotExist() {
        // Arrange
        var benny = getBenny();
        um.createUser(benny);

        // Act
        var result = um.followUser("albert", benny.username);

        // Assert
        assertFalse(result);
    }

    @Test
    @DisplayName("FollowUser must return null if followed user does not exist")
    public void followUserMustReturnNullIfFollowedUserDoesNotExist() {
        // Arrange
        var albert = getAlbert();
        um.createUser(albert);

        // Act
        var result = um.followUser(albert.username, "benny");

        // Assert
        assertFalse(result);
    }

    @Test
    @DisplayName("Followed user must appear in the list of followed users")
    public void followedUserMustAppearInListOfFollowedUsers(){
        // Arrange
        var albert = getAlbert();
        var benny = getBenny();
        var carl = getCarl();
        var dennis = getDennis();
        um.createUser(albert);
        um.createUser(benny);
        um.createUser(carl);
        um.createUser(dennis);

        // Act
        um.followUser(albert.username, benny.username);
        um.followUser(albert.username, carl.username);

        // Assert
        Set<String> usernames = um.getFollowedUsers(albert.username);
        assertTrue(usernames.containsAll(List.of(benny.username, carl.username)),
                "If followUser(a,b) was called, the result of getFollowedUsers(a) should contain b");
        assertFalse(usernames.contains(dennis.username),
                "If followUser(a,b) was never called, the result of getFollowedUsers(a) must not contain b");
    }

    @Test
    @DisplayName("User overview must contain number of followed users")
    public void userOverviewMustContainNumberOfFollowedUsers() {
        // Arrange
        var albert = getAlbert();
        var benny = getBenny();
        um.createUser(albert);
        um.createUser(benny);

        // Act
        var userOverview = um.getUserOverview(albert.username);

        // Assert
        assertEquals(0, userOverview.numFollowing);

        // Act
        um.followUser(albert.username, benny.username);
        userOverview = um.getUserOverview(albert.username);

        // Assert
        assertEquals(0, userOverview.numFollowers, "NumFollowers should not have changed. a->b, a has 0 followers and b has 1.");
        assertEquals(1, userOverview.numFollowing, "NumFollowing should have changed. a->b, a is following 1 user.");
    }

    @Test
    @DisplayName("User overview must contain number of following users")
    public void userOverviewMustContainNumberOfFollowingUsers() {
        // Arrange
        var albert = getAlbert();
        var benny = getBenny();
        um.createUser(albert);
        um.createUser(benny);

        // Act
        var userOverview = um.getUserOverview(albert.username);

        // Assert
        assertEquals(0, userOverview.numFollowers);

        // Act
        um.followUser(albert.username, benny.username);
        userOverview = um.getUserOverview(benny.username);

        // Assert
        assertEquals(1, userOverview.numFollowers);
    }

    @Test
    @DisplayName("getUsersFollowing must return null if username does not exist")
    public void getUsersFollowingMustReturnNullIfUsernameDoesNotExist() {
        // Arrange
        var albert = getAlbert();
        um.createUser(albert);

        // Act
        var result = um.getUsersFollowing("bleb");

        // Assert
        assertNull(result);
    }

    @Test
    @DisplayName("getFollowedUsers must return null if username does not exist")
    public void getFollowedUsersMustReturnNullIfUsernameDoesNotExist() {
        // Arrange
        // Act
        var result = um.getFollowedUsers("bleb");

        // Assert
        assertNull(result);
    }
}
