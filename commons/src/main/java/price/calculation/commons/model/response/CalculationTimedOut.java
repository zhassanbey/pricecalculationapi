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
public class CalculationTimedOut extends Response{
    
    public CalculationTimedOut(){
        this.message = "Calculation Timed Out";
        this.statusCode = 408;
    }
    
}
