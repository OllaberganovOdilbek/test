/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package extp.store.configs;

import com.mchange.v2.c3p0.DriverManagerDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Ollaberganov-PC
 */
@Configuration
@EnableTransactionManagement
public class DatabaseConfig {
    
    @Autowired
    private Environment environment;
     
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClass(environment.getProperty("datasource.driver"));
        dataSource.setJdbcUrl(environment.getProperty("datasource.url"));
        dataSource.setUser(environment.getProperty("datasource.username"));
        dataSource.setPassword(environment.getProperty("datasource.password"));
        return dataSource;
    } 
    
}