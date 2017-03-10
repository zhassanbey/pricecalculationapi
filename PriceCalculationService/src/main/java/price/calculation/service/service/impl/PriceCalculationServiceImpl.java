/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package price.calculation.service.service.impl;

import java.util.Date;
import org.springframework.stereotype.Component;
import price.calculation.commons.model.Product;
import price.calculation.commons.model.response.CalculatedPrice;
import price.calculation.service.service.PriceCalculationService;

/**
 *
 * @author root
 */
@Component
public class PriceCalculationServiceImpl implements PriceCalculationService{

    @Override
    public CalculatedPrice calculatePrice(Product product) {
        CalculatedPrice price = new CalculatedPrice();
        price.setDate(new Date());
        price.setPrice(product.getUnderlyingValue()+product.getUnderlyingValueVolatility()/2);
        return price;
    }
    
}
