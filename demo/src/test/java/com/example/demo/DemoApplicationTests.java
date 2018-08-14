package com.example.demo;

import com.example.demo.service.RedisService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private RedisService redisService;

	@Test
	public void contextLoads() {
		stringRedisTemplate.opsForValue().set("zzp","big z");
		Assert.assertEquals("big z",stringRedisTemplate.opsForValue().get("zzp"));
	}

	@Test
	public void getString() {
		redisService.set("name","zhangsan");
		System.out.println(redisService.get("name"));
	}
}
