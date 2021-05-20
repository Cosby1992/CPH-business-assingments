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

        boolean exists = jedis.exists("user:"+userCreation.username);

        if(!exists){
            jedis.set("user:"+userCreation.username,userCreation.username);
            jedis.set("user:"+userCreation.username+":firstname",userCreation.firstname);
            jedis.set("user:"+userCreation.username+":lastname",userCreation.lastname);
            jedis.set("user:"+userCreation.username+":password",userCreation.passwordHash);
            jedis.set("user:"+userCreation.username+":birthday",userCreation.birthday);
            jedis.set("user:"+userCreation.username+":numFollowers","0");
            jedis.set("user:"+userCreation.username+":numFollowing","0");

            
        }

        return !exists;
    
    }

    @Override
    public UserOverview getUserOverview(String username) {
        
        boolean exists = jedis.exists("user:" + username);

        if(!exists) return null;

        String rootKey = "user:" + username + ":";
        UserOverview overview = new UserOverview();

        overview.username = username;
        overview.firstname = jedis.get(rootKey + "firstname");
        overview.lastname = jedis.get(rootKey + "lastname");
        overview.numFollowers = Integer.valueOf(jedis.get(rootKey + "numFollowers"));
        overview.numFollowing = Integer.valueOf(jedis.get(rootKey + "numFollowing"));

        return overview;

    }

    @Override
    public boolean updateUser(UserUpdate userUpdate) {

        boolean exists = jedis.exists("user:"+userUpdate.username);

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

        return exists;
    }

    @Override
    public boolean followUser(String username, String usernameToFollow) {

        String follower = "user:" + username;
        String followed = "user:" + usernameToFollow;

        if(!jedis.exists(follower) || !jedis.exists(followed)) return false;
        
        String rootKeyFollowing = follower + ":following";
        String rootKeyFollowers = followed + ":followers";

        jedis.lpush(rootKeyFollowers, username);
        jedis.incr(follower + ":numFollowing");
        jedis.lpush(rootKeyFollowing, usernameToFollow);
        jedis.incr(followed + ":numFollowers");
        
        return true;
    }

    @Override
    public boolean unfollowUser(String username, String usernameToUnfollow) {
        
        String follower = "user:" + username;
        String followed = "user:" + usernameToUnfollow;

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
        if(!jedis.exists(userKey)) return null;

        String rootKeyFollowers = userKey + ":following";
        
        List<String> followers = jedis.lrange(rootKeyFollowers, 0, -1);

        Set<String> hSet = new HashSet<String>();
        
        for (String x : followers)
            hSet.add(x);
        
        return hSet;



    }

    @Override
    public Set<String> getUsersFollowing(String username) {

        String userKey = "user:" + username;
        if(!jedis.exists(userKey)) return null;

        String rootKeyFollowers = userKey + ":followers";
        
        List<String> followers = jedis.lrange(rootKeyFollowers, 0, -1);

        Set<String> hSet = new HashSet<String>();
        
        for (String x : followers)
            hSet.add(x);
        
        return hSet;
    }

}
