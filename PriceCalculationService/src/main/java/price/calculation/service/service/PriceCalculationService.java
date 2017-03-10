/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package price.calculation.service.service;

import org.springframework.stereotype.Component;
import price.calculation.commons.model.Product;
import price.calculation.commons.model.response.CalculatedPrice;

/**
 *
 * @author root
 */
@Component
public interface PriceCalculationService {
    
    public CalculatedPrice calculatePrice(Product product);
    
}
