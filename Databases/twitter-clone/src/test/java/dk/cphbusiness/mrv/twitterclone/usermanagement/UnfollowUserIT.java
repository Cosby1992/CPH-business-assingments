package dk.cphbusiness.mrv.twitterclone.usermanagement;

import dk.cphbusiness.mrv.twitterclone.TestBase;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UnfollowUserIT extends TestBase {
    @Test
    public void mustBeAbleToUnfollowUser(){
        // Arrange
        var albert = getAlbert();
        var benny = getBenny();
        var carl = getCarl();
        um.createUser(albert);
        um.createUser(benny);
        um.createUser(carl);
        um.followUser(albert.username, benny.username);
        um.followUser(albert.username, carl.username);
        assertTrue(um.getFollowedUsers(albert.username).containsAll(List.of(benny.username, carl.username)));

        // Act
        um.unfollowUser(albert.username, carl.username);

        // Assert
        var followedUsers = um.getFollowedUsers(albert.username);
        assertTrue(followedUsers.contains(benny.username));
        assertFalse(followedUsers.contains(carl.username));
    }

    @Test
    public void mustReturnFalseIfUserDoesNotExist(){
        // Arrange
        var albert = getAlbert();
        um.createUser(albert);

        // Act
        var result = um.unfollowUser("bleb", albert.username);

        // Assert
        assertFalse(result);
    }
}
