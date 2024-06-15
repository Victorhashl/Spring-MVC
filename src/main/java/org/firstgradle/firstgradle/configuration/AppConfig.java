package org.firstgradle.firstgradle.configuration;

import org.firstgradle.firstgradle.DB;
import org.firstgradle.firstgradle.DevDB;
import org.firstgradle.firstgradle.ProdDB;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    @ConditionalOnProperty(name="project.mode",havingValue = "development")
    public DB getDevDbBean(){ //name of bean doesn't matter
        return new DevDB();
    }

    @Bean
    @ConditionalOnProperty(name="project.mode",havingValue = "production")
    public DB getProdDbBean(){
        return new ProdDB();
    }
}
