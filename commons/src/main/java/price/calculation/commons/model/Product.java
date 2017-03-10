/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package price.calculation.commons.model;

import com.google.gson.Gson;

/**
 *
 * @author root
 */
public class Product {
    String id;
    double underlyingValue;
    double underlyingValueVolatility;
    
    public Product(){
    
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getUnderlyingValue() {
        return underlyingValue;
    }

    public void setUnderlyingValue(double underlyingValue) {
        this.underlyingValue = underlyingValue;
    }

    public double getUnderlyingValueVolatility() {
        return underlyingValueVolatility;
    }

    public void setUnderlyingValueVolatility(double underlyingValueVolatility) {
        this.underlyingValueVolatility = underlyingValueVolatility;
    }
    
    public String toJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
