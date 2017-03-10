/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package price.calculation.commons.model.response;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author root
 */
public class CalculatedPrice extends Response {

    double price;
    Date date;

    public CalculatedPrice() {
        this.message = "Success!";
        this.statusCode = 200;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static CalculatedPrice fromJson(String json) {
        CalculatedPrice price = new CalculatedPrice();
        JSONParser parser = new JSONParser();
        try {
            System.out.println(json);
            JSONObject jObj = (JSONObject) parser.parse(json);
            price.setDate(new Date((long)jObj.get("date")));
            price.setPrice((double)jObj.get("price"));
        } catch (ParseException ex) {
            Logger.getLogger(CalculatedPrice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return price;
    }
}
