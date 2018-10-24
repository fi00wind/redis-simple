package cn.coolwind.redis.controller;

import cn.coolwind.redis.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private TestDao testDao;

    @GetMapping("/string")
    public Object test() {
        testDao.set("aaa", "111");
        return testDao.get("aaa");
    }

    @GetMapping("/list")
    public Object list() {
        testDao.lpush("list", "111", "222", "333","111");
        return testDao.lRangeAll("list");
    }

    @GetMapping("/hash")
    public Object hash() {
        testDao.hset("hash", "a", "1");
        return testDao.hget("hash", "a");
    }

    @GetMapping("/set")
    public Object set() {
        testDao.sadd("set", "a", "b", "c", "a");
        return testDao.smembers("set");
    }

    @GetMapping("/zset")
    public Object zset() {
        testDao.zadd("zset",1,"za");
        testDao.zadd("zset",2,"zb");
        return testDao.zRangeAll("zset");
    }
}
