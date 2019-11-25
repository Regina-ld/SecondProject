package com.regina.pro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

/**
 * @author Regina
 * @data 2019/11/23 9:31
 * @project repast-pro-parent
 * @declaration:
 */
@Service
public class RedisService {

    @Autowired
    private JedisCluster jedisCluster;

    /**
     * @description
     *      向redis中取出数据
     * @param [key]
     * @date 2019/11/21
     * @return java.lang.String
     * @throws
     **/
    public String get(String key) {
        return jedisCluster.get(key);
    }

    /**
     * @description
     *      从redis中存入数据
     * @param [key, value]
     * @date 2019/11/21
     * @return java.lang.String
     * @throws
     **/
    public String set(String key, String value) {
        return jedisCluster.set(key, value);
    }

}
