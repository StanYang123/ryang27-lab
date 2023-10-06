package edu.iit.sat.itmd4515.ryang27.config;

/**
 * @author Wang
 * @Information annotation
 * @date: 2022/9/13 16:52
 */
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    //Specify the current object as a bean
    @Bean(name = "dataSource")
    //指定dataSource来DI
    @Qualifier(value = "dataSource")
    //Specify dataSource to DI
    @Primary
    //Add the prefix c3p0 to the application.properties file
    @ConfigurationProperties(prefix = "c3p0")
    public  DataSource dataSource(){
        return DataSourceBuilder.create().type(com.mchange.v2.c3p0.ComboPooledDataSource.class).build();
    }

}

