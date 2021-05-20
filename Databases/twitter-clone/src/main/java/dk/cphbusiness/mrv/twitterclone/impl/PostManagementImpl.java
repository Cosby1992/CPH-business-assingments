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
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public List<Post> getPosts(String username) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public List<Post> getPostsBetween(String username, long timeFrom, long timeTo) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
