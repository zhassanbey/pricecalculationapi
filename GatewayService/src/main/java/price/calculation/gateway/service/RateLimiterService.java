/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package price.calculation.gateway.service;

import org.springframework.stereotype.Component;

/**
 *
 * @author root
 */
@Component
public interface RateLimiterService {
    
    public boolean isRateLimitExceeded(String id);
    
    
}
