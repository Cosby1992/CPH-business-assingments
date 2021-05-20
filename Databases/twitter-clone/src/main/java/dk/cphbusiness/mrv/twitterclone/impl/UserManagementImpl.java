package dk.cphbusiness.mrv.twitterclone.impl;

import dk.cphbusiness.mrv.twitterclone.contract.UserManagement;
import dk.cphbusiness.mrv.twitterclone.dto.UserCreation;
import dk.cphbusiness.mrv.twitterclone.dto.UserOverview;
import dk.cphbusiness.mrv.twitterclone.dto.UserUpdate;
import dk.cphbusiness.mrv.twitterclone.util.Time;
import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;
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

        boolean exists = jedis.exists("user:"+userCreation.username);
        System.out.println("testing bool " + exists);

        if(!exists){
            jedis.set("user:"+userCreation.username,userCreation.username);
            jedis.set("user:"+userCreation.username+":"+userCreation.firstname,userCreation.firstname);
            jedis.set("user:"+userCreation.username+":"+userCreation.lastname,userCreation.lastname);
            jedis.set("user:"+userCreation.username+":"+userCreation.passwordHash,userCreation.passwordHash);
            jedis.set("user:"+userCreation.username+":"+userCreation.birthday,userCreation.birthday);
            jedis.set("user:"+userCreation.username+":numFollowers","0");
            jedis.set("user:"+userCreation.username+":numFollowing","0");

            
        }

        return !exists;
    
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
