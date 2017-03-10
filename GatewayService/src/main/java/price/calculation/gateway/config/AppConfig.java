/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package price.calculation.gateway.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class AppConfig {

    private static class Holder {

        public static AppConfig instance = new AppConfig();
    }

    private AppConfig() {
        
    }

    public static AppConfig getInstance() {
        return Holder.instance;
    }
    
    public Properties getProperties(String name){
        Properties props = new Properties();
        InputStream is = AppConfig.class.getClassLoader().getResourceAsStream(name);
        try {
            props.load(is);
        } catch (IOException ex) {
            Logger.getLogger(AppConfig.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return props;
    }
}
