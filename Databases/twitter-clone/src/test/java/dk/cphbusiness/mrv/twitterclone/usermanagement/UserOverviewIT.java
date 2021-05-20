package dk.cphbusiness.mrv.twitterclone.usermanagement;

import dk.cphbusiness.mrv.twitterclone.TestBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class UserOverviewIT extends TestBase {
    @Test
    public void getUserOverviewMustReturnNullIfUsernameDoesNotExist() {
        // Arrange
        // Act
        var result = um.getUserOverview("blub");

        // Assert
        assertNull(result, "Expected user 'blub' did not exist, but getUserOverview did not return null!");
    }
}
