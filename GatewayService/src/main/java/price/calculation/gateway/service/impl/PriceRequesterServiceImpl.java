/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package price.calculation.gateway.service.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;
import price.calculation.commons.model.response.CalculatedPrice;
import price.calculation.commons.model.Product;
import price.calculation.commons.model.response.CalculationTimedOut;
import price.calculation.commons.model.response.Response;
import price.calculation.gateway.service.PriceRequesterService;

/**
 *
 * @author root
 */
@Component
public class PriceRequesterServiceImpl implements PriceRequesterService{

    String url;
    int timeout;
    Response res;
    public PriceRequesterServiceImpl(){}
    
    public PriceRequesterServiceImpl(String url, int timeout){
        this.url = url;
        this.timeout = timeout;
    }
    
    @Override
    public Response calulatePrice(Product product) {
        res = null;
        final HttpClient client = new DefaultHttpClient();
        final HttpPost post = new HttpPost(url);
        try {
            post.setHeader("Content-type", "application/json");
            post.setEntity(new StringEntity(product.toJson()));
        } catch (UnsupportedEncodingException ex) {
            res = new Response("Invalid encoding", 400);
            Logger.getLogger(PriceRequesterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        TimerTask calculationTask = new TimerTask(){

            @Override
            public void run() {
                if(post != null){
                    res = new CalculationTimedOut();
                    post.abort();
                }
            }
        
        };
        new Timer(true).schedule(calculationTask, timeout*1000);
        try {
            HttpResponse httpResponse = client.execute(post);
            String jsonResp = EntityUtils.toString(httpResponse.getEntity());
            res = CalculatedPrice.fromJson(jsonResp);
        } catch (IOException ex) {
            res = new Response("Service Unavailable",503);
            Logger.getLogger(PriceRequesterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }
    
}
