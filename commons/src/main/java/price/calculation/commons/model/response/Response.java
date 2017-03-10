/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package price.calculation.commons.model.response;

import com.google.gson.Gson;

/**
 * General class that represents custom responses
 * @author root
 */
public class Response {

    String message;
    int statusCode;

    public Response() {

    }

    public Response(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
    
    public String toJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
    
    public static Response fromJson(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, Response.class);
    }
}
