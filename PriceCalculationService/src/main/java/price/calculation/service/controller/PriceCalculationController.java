/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package price.calculation.service.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import price.calculation.commons.model.response.CalculatedPrice;
import price.calculation.commons.model.Product;
import price.calculation.commons.model.response.Response;
import price.calculation.service.service.PriceCalculationService;

/**
 *
 * @author root
 */
@RestController
public class PriceCalculationController {
    
    @Autowired
    PriceCalculationService calculationService;
    
    int calculationTime = 2000;
    
    @RequestMapping(value = "/getPrice", method=RequestMethod.POST)
    public Response getPrice(@RequestBody Product product) throws InterruptedException{
           Thread.sleep(calculationTime);
           CalculatedPrice resp = calculationService.calculatePrice(product);
           return resp;
    }
    
}
