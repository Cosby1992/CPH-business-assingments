package dk.cphbusiness.mrv.twitterclone.impl;

import dk.cphbusiness.mrv.twitterclone.contract.UserManagement;
import dk.cphbusiness.mrv.twitterclone.dto.UserCreation;
import dk.cphbusiness.mrv.twitterclone.dto.UserOverview;
import dk.cphbusiness.mrv.twitterclone.dto.UserUpdate;
import dk.cphbusiness.mrv.twitterclone.util.Time;
import redis.clients.jedis.Jedis;

import java.util.HashSet;
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

        // Check is user key exists in db
        boolean exists = jedis.exists("user:"+userCreation.username);

        // If it doesn't exist, create user in db
        if(!exists){
            jedis.set("user:"+userCreation.username,userCreation.username);
            jedis.set("user:"+userCreation.username+":firstname",userCreation.firstname);
            jedis.set("user:"+userCreation.username+":lastname",userCreation.lastname);
            jedis.set("user:"+userCreation.username+":password",userCreation.passwordHash);
            jedis.set("user:"+userCreation.username+":birthday",userCreation.birthday);
            jedis.set("user:"+userCreation.username+":numFollowers","0");
            jedis.set("user:"+userCreation.username+":numFollowing","0");

        }

        // false if user exists, true if user was created
        return !exists;
    
    }

    @Override
    public UserOverview getUserOverview(String username) {

        // Return null if user does not exist
        if(!jedis.exists("user:" + username)) return null;

        String rootKey = "user:" + username + ":";
        UserOverview overview = new UserOverview();

        // Build UserOverview with data from db
        overview.username = username;
        overview.firstname = jedis.get(rootKey + "firstname");
        overview.lastname = jedis.get(rootKey + "lastname");
        overview.numFollowers = Integer.valueOf(jedis.get(rootKey + "numFollowers"));
        overview.numFollowing = Integer.valueOf(jedis.get(rootKey + "numFollowing"));

        // Return the userdata
        return overview;

    }

    @Override
    public boolean updateUser(UserUpdate userUpdate) {

        // Check is user key exists in db
        boolean exists = jedis.exists("user:"+userUpdate.username);

        // If user exists, update values
        if(exists){
            if(userUpdate.firstname != null) {
            jedis.set("user:"+userUpdate.username+":firstname",userUpdate.firstname);
            }    
            if(userUpdate.lastname != null) {
            jedis.set("user:"+userUpdate.username+":lastname",userUpdate.lastname);
            }
            if(userUpdate.birthday != null) {
            jedis.set("user:"+userUpdate.username+":birthday",userUpdate.birthday);
            }
            
        }

        // Return false if user does not exist, true if user was updated
        return exists;
    }

    @Override
    public boolean followUser(String username, String usernameToFollow) {

        String follower = "user:" + username;
        String followed = "user:" + usernameToFollow;

        // Check if the usernames exists in the db (return false if users does not exist)
        if(!jedis.exists(follower) || !jedis.exists(followed)) return false;
        
        String rootKeyFollowing = follower + ":following";
        String rootKeyFollowers = followed + ":followers";

        // Push to following and followers lists respectively for the two users
        jedis.lpush(rootKeyFollowers, username);
        jedis.incr(follower + ":numFollowing");
        jedis.lpush(rootKeyFollowing, usernameToFollow);
        jedis.incr(followed + ":numFollowers");
        
        // Return true for success
        return true;
    }

    @Override
    public boolean unfollowUser(String username, String usernameToUnfollow) {
        
        String follower = "user:" + username;
        String followed = "user:" + usernameToUnfollow;

        // Check if the usernames exists in the db (return false if users does not exist)
        if(!jedis.exists(follower) || !jedis.exists(followed)) return false;

        //remove from following username
        jedis.lrem(follower + ":following", 0, usernameToUnfollow);
        jedis.decr(follower + ":numFollowing");

        //remove from followers usernameToUnfollow
        jedis.lrem(followed + ":followers", 0, username);
        jedis.decr(followed + ":numFollowers");

        return true;

    }

    @Override
    public Set<String> getFollowedUsers(String username) {
        
        String userKey = "user:" + username;

        // Return null if user does not exist
        if(!jedis.exists(userKey)) return null;

        String rootKeyFollowers = userKey + ":following";
        
        // Get list of followed users from db
        List<String> followers = jedis.lrange(rootKeyFollowers, 0, -1);

        Set<String> hSet = new HashSet<String>();
        
        for (String x : followers)
            hSet.add(x);
        
        // Return as set<String>
        return hSet;

    }

    @Override
    public Set<String> getUsersFollowing(String username) {

        String userKey = "user:" + username;

        // Return null if user does not exist
        if(!jedis.exists(userKey)) return null;

        String rootKeyFollowers = userKey + ":followers";
        
        // Get list of follewed users from db
        List<String> followers = jedis.lrange(rootKeyFollowers, 0, -1);

        Set<String> hSet = new HashSet<String>();
        
        for (String x : followers)
            hSet.add(x);
        
        // Return as Set<String>
        return hSet;
    }

}
