/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package price.calculation.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import price.calculation.gateway.controller.PriceCalculationGateController;

/**
 *
 * @author root
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackageClasses={PriceCalculationGateController.class})
@ImportResource("classpath:application-context.xml")
public class Main {
    public static void main(String args[]) throws InterruptedException{
        SpringApplication.run(Main.class, args);
    }
}
