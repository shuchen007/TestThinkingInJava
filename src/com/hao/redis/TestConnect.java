package com.hao.redis;

import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * Created by Chen Yonggui on 2017/10/9.
 */
public class TestConnect {
    public static void main(String[] args) {
//        //连接本地的 Redis 服务
//        Jedis jedis = new Jedis("localhost");
//        System.out.println("连接成功");
//        //查看服务是否运行
//        System.out.println("服务正在运行: "+jedis.ping());

        //连接本地的 Redis 服务，String
        Jedis jedis = new Jedis("localhost");
        //权限认证
        jedis.auth("root");
        System.out.println("连接成功");
        //设置 redis 字符串数据
        jedis.set("runoobkey", "www.runoob.com1");
        System.out.println("redis 存储的字符串为: "+ jedis.get("runoobkey"));
        System.out.println("redis 存储的字符串为: "+ jedis.get("name"));

        //连接本地的 Redis 服务，Hash
        Jedis jedis1 = new Jedis("localhost");
        //权限认证
        jedis1.auth("root");
        System.out.println("连接成功");
        //设置 redis hash数据
        Map hash = new HashMap<String,String>();
        hash.put("username","sunhao");
        hash.put("password", "key11");
        jedis1.hmset("hash1",hash);
        System.out.println("redis 存储的hash为: "+ jedis.hget("hash1","username"));

//        //连接本地的 Redis 服务,list
//        Jedis jedis3 = new Jedis("localhost");
//        System.out.println("连接成功");
//        //存储数据到列表中
//        jedis3.lpush("site-list", "Runoob","google","taobao");
////        jedis3.lpush("site-list", "Google");
////        jedis3.lpush("site-list", "Taobao");
//        // 获取存储的数据并输出
//        List<String> list = jedis3.lrange("site-list", 0 ,16);
//        for(int i=0; i<list.size(); i++) {
//            System.out.println("列表项为: "+list.get(i));
//        }

        //连接本地的 Redis 服务,set
        Jedis jedis3 = new Jedis("localhost");
        //权限认证
        jedis3.auth("root");
        System.out.println("连接成功");
        //存储数据到列表中
        jedis3.sadd("site-set", "Runoob1","google1","taobao1");
        // 获取存储的数据并输出
        Set<String> set = jedis3.smembers("site-set");
        Iterator it1 = set.iterator();
        while(it1.hasNext()){
            System.out.println("set列表项为: "+it1.next());
        }

        //连接本地的 Redis 服务
        Jedis jedis4 = new Jedis("localhost");
        //权限认证
        jedis4.auth("root");
        System.out.println("连接成功");
        // 获取数据并输出
        Set<String> keys = jedis4.keys("*");
        Iterator<String> it=keys.iterator() ;
        while(it.hasNext()){
            String key = it.next();
            System.out.println(key);
        }
    }
}
