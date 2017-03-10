/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package price.calculation.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import price.calculation.service.controller.PriceCalculationController;

/**
 *
 * @author root
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackageClasses={PriceCalculationController.class})
@ImportResource("classpath:application-context.xml")
public class Main {
    
    public static void main(String arsg[]){
        SpringApplication.run(Main.class, arsg);
    }
}
