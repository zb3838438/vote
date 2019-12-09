package com.zb.vote.controller;

import com.zb.vote.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("vote/")
public class VoteController {
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("hello")
    public String getHello(String name) {
        return "hello " + name;
    }

    @RequestMapping("getTitle")
    public Map<String, String> getVote(String titleId) {
        return redisUtil.hgetAll(titleId);
    }

    @RequestMapping("setTitle")
    public String setVote(String titleId) {
        Map<String, String> map = new HashMap<>();
        map.put("title", "java初级");
        map.put("user", "zb");
        map.put("time", new Date().toString());
        map.put("vote", "1");
        return redisUtil.hmset(titleId, map);
    }
}
