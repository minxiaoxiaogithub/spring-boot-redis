package com.fiberhome.ms.redis.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiberhome.ms.redis.entity.User;

@RestController
public class RedisUI {

  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  @Autowired
  private RedisTemplate<String, Object> redisTemplate;

  @GetMapping(value = "/redis/string")
  public void addString() {
    stringRedisTemplate.opsForValue().set("xx", "xx");
  }

  @GetMapping(value = "/redis/string/get")
  public String getString() {
    return stringRedisTemplate.opsForValue().get("xx");
  }

  @GetMapping(value = "/redis/string/object")
  public void addStrObj() {
    User user = new User();
    user.setId("1");
    user.setName("xy");
    redisTemplate.opsForValue().set("xy", user);
  }
  
  @GetMapping(value = "/redis/string/object/get")
  public Object getStrObj() {
    return redisTemplate.opsForValue().get("xy");
  }
}
