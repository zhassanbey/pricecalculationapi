/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package price.calculation.gateway.service.impl;

import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.RedisConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import price.calculation.gateway.config.AppConfig;
import price.calculation.gateway.service.RateLimiterService;

/**
 *
 * @author root
 */
@Component
public class RedisRateLimiterServiceImpl implements RateLimiterService {

    @Autowired
    RedisClient redisClient;
    
    RedisConnection<String, String> connection;
    int rateLimit;
    
    public RedisRateLimiterServiceImpl(){
    
    }
    
    public RedisRateLimiterServiceImpl(int rateLimit){
        this.rateLimit = rateLimit;
    }

    private void connect(){
        if(connection == null || !connection.isOpen()){
            connection = redisClient.connect();
        }
    }
    
    @Override
    public boolean isRateLimitExceeded(String id) {
        connect();
        connection.incr(id);
        long ttl = connection.ttl(id);
        System.out.println("ttl = "+ttl);
        if(ttl  == -1){
            connection.expire(id, 10);
            return false;
        }
        if (Integer.parseInt(connection.get(id)) > rateLimit) {
            return true;
        }
        return false;
    }

}
