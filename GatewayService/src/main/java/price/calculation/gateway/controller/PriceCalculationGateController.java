/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package price.calculation.gateway.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import price.calculation.commons.model.response.CalculatedPrice;
import price.calculation.commons.model.Product;
import price.calculation.commons.model.response.RateLimitExceeded;
import price.calculation.commons.model.response.Response;
import price.calculation.gateway.service.PriceRequesterService;
import price.calculation.gateway.service.RateLimiterService;
import price.calculation.gateway.service.impl.RedisRateLimiterServiceImpl;

/**
 *
 * @author root
 */
@RestController
public class PriceCalculationGateController {
    
    @Autowired
    RateLimiterService rateLimiter;
    
    @Autowired
    PriceRequesterService priceRequester;
    
    
    @RequestMapping(value = "/getPrice", method=RequestMethod.POST)
    public Response getPrice(@RequestBody Product product){
           if(rateLimiter.isRateLimitExceeded(product.getId())){
               return new RateLimitExceeded();
           }
           Response resp = priceRequester.calulatePrice(product);
           return resp;
    }
    
}
