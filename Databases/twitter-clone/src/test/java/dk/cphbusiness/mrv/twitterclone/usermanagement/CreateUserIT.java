package dk.cphbusiness.mrv.twitterclone.usermanagement;

import dk.cphbusiness.mrv.twitterclone.TestBase;
import dk.cphbusiness.mrv.twitterclone.dto.UserCreation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreateUserIT extends TestBase {
    @Test
    public void createUserMustReturnFalseIfUserExists(){
        // Arrange
        UserCreation uc = getAlbert();
        boolean res = um.createUser(uc);
        assertTrue(res);

        // Act
        res = um.createUser(uc);

        // Assert
        assertFalse(res);
    }

    @Test
    public void userMustExistWhenCreated(){
        // Arrange
        var user = getAlbert();
        um.createUser(user);

        // Act
        var userOverview = um.getUserOverview(user.username);

        // Assert
        assertEquals(user.firstname, userOverview.firstname);
        assertEquals(user.lastname, userOverview.lastname);
    }

}
