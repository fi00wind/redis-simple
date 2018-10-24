package cn.coolwind.redis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Set;

@Repository
public class TestDao  {
    @Autowired
    private JedisPool jedisPool;

    public String get(String key) {
        return jedisPool.getResource().get(key);
    }

    public String set(String key, String value) {
        return jedisPool.getResource().set(key,value);
    }

    public Long lpush(String key,String... value) {
        return jedisPool.getResource().lpush(key,value);
    }

    public List<String> lRangeAll(String key) {
        return jedisPool.getResource().lrange(key, 0, -1);
    }

    public Long hset(String key,String field,String value) {
        return jedisPool.getResource().hset(key, field, value);
    }

    public String hget(String key, String field) {
        return jedisPool.getResource().hget(key, field);
    }

    public Long sadd(String key,String... numbers) {
        return jedisPool.getResource().sadd(key, numbers);
    }

    public Set<String> smembers(String key) {
        return jedisPool.getResource().smembers(key);
    }

    public Long zadd(String key, double score, String value) {
        return jedisPool.getResource().zadd(key, score, value);
    }

    public Set<String> zRangeAll(String key) {
        return jedisPool.getResource().zrange(key, 0, -1);
    }
}
