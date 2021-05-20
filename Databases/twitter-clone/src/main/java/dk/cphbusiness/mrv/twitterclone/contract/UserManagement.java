package dk.cphbusiness.mrv.twitterclone.contract;

import dk.cphbusiness.mrv.twitterclone.dto.Post;
import dk.cphbusiness.mrv.twitterclone.dto.UserCreation;
import dk.cphbusiness.mrv.twitterclone.dto.UserOverview;
import dk.cphbusiness.mrv.twitterclone.dto.UserUpdate;

import java.util.List;
import java.util.Set;

public interface UserManagement {
    boolean createUser(UserCreation userCreation);
    UserOverview getUserOverview(String username);
    boolean updateUser(UserUpdate userUpdate);
    boolean followUser(String username, String usernameToFollow);
    boolean unfollowUser(String username, String usernameToUnfollow);
    Set<String> getFollowedUsers(String username);
    Set<String> getUsersFollowing(String username);
}

