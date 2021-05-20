package dk.cphbusiness.mrv.twitterclone.impl;

import dk.cphbusiness.mrv.twitterclone.contract.PostManagement;
import dk.cphbusiness.mrv.twitterclone.dto.Post;
import dk.cphbusiness.mrv.twitterclone.util.Time;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PostManagementImpl implements PostManagement {
    private Jedis jedis;
    private Time time;

    public PostManagementImpl(Jedis jedis, Time time) {
        this.jedis = jedis;
        this.time = time;
    }

    @Override
    public boolean createPost(String username, String message) {
        boolean exists = jedis.exists("user:"+username );
        
        if(exists){
            jedis.set("post:"+username+":"+time, message);
            //jedis.rpush("post:"+username+":posttime",""+time);

            jedis.zadd("post:"+username+":posttime",0,String.valueOf(time));
            exists = true;
        }

        return exists;
    }

    @Override
    public List<Post> getPosts(String username) {
        boolean exists = jedis.exists("user:" + username);
        if(!exists) return null;
        
        Set<String> timestamps = jedis.zrange("post:"+username+":posttime", 0, -1);
        List<Post> postList = new ArrayList<Post>();

        for (String ts : timestamps) {

            postList.add(new Post(Long.parseLong(ts), jedis.get("post:"+username+":"+ts)));
        }

        return postList;
    }

    @Override
    public List<Post> getPostsBetween(String username, long timeFrom, long timeTo) {
        boolean exists = jedis.exists("user:" + username);
        if(!exists) return null;

        long start = 0;
                

        Set<String> timestamps = jedis.zrangeByLex("post:"+username+":posttime", String.valueOf(timeFrom-1), String.valueOf(timeTo+1));
        List<Post> postList = new ArrayList<Post>();

        for (String ts : timestamps) {

            postList.add(new Post(Long.parseLong(ts), jedis.get("post:"+username+":"+ts)));
        }

        return postList;
    }
}
