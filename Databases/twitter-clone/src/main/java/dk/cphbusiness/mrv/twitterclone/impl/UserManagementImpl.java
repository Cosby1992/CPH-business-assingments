package dk.cphbusiness.mrv.twitterclone.impl;

import dk.cphbusiness.mrv.twitterclone.contract.UserManagement;
import dk.cphbusiness.mrv.twitterclone.dto.UserCreation;
import dk.cphbusiness.mrv.twitterclone.dto.UserOverview;
import dk.cphbusiness.mrv.twitterclone.dto.UserUpdate;
import dk.cphbusiness.mrv.twitterclone.util.Time;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserManagementImpl implements UserManagement {

    private Jedis jedis;

    public UserManagementImpl(Jedis jedis) {
        this.jedis = jedis;
    }

    @Override
    public boolean createUser(UserCreation userCreation) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public UserOverview getUserOverview(String username) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean updateUser(UserUpdate userUpdate) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean followUser(String username, String usernameToFollow) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean unfollowUser(String username, String usernameToUnfollow) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Set<String> getFollowedUsers(String username) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Set<String> getUsersFollowing(String username) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
