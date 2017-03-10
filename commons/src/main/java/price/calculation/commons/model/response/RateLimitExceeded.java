/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package price.calculation.commons.model.response;

/**
 *
 * @author root
 */
public class RateLimitExceeded extends Response{
    public RateLimitExceeded(){
        this.message = "Rate Limit Exceeded";
        this.statusCode = 429;
    }
}
