package dk.cphbusiness.mrv.twitterclone.usermanagement;

import dk.cphbusiness.mrv.twitterclone.TestBase;
import dk.cphbusiness.mrv.twitterclone.dto.UserUpdate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class UpdateUserIT extends TestBase {
    @ParameterizedTest
    @CsvSource(value = {
            ",Larsen,",
            "Alberta,,",
            ",,2002-01-01",
            "Albertrud,Karlsen,1991-01-01"
    })
    public void mustBeAbleToUpdateUser(String firstname, String lastname, String bday) {
        // Arrange
        var albert = getAlbert();
        um.createUser(albert);

        // Act
        var res = um.updateUser(new UserUpdate(albert.username, firstname, lastname, bday));

        // Assert
        assertTrue(res);
        var userOverview = um.getUserOverview(albert.username);

        // if firstname wasn't null, userOverview.firstname should be equal to firstname. Ditto for lastname.
        assertEquals(firstname != null, userOverview.firstname.equals(firstname));
        assertEquals(lastname != null, userOverview.lastname.equals(lastname));

        // if firstname was null, firstname should be equal to the initial firstname. Ditto for lastname.
        assertEquals(firstname == null, albert.firstname.equals(userOverview.firstname));
        assertEquals(lastname == null, albert.lastname.equals(userOverview.lastname));
    }

    @Test
    public void updateUserMustReturnFalseIfUsernameDoesNotExist(){
        // Arrange
        // Act
        var result = um.updateUser(new UserUpdate("bleb",null,null,null));

        // Assert
        assertFalse(result);
    }
}
