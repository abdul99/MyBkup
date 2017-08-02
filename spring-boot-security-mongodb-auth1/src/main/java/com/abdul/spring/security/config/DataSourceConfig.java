package com.abdul.spring.security.config;

 
import org.apache.commons.dbcp2.BasicDataSource;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
 
 

 

/**
 * Created by gkatzioura on 9/2/16.
 */
@Configuration
public class DataSourceConfig {

    @Bean
    @Profile(value = {"simple","customquery","encodedjdbcpassword"})
    public BasicDataSource createDataSource() {

      //  JdbcDataSource dataSource = new JdbcDataSource();
       // dataSource.setURL("jdbc:h2:"+System.getProperty("java.io.tmpdir")+"/database");
       // dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    	/*dataSource.setUrl("jdbc:mysql://localhost:3306/springsecurity");
    	dataSource.setPassword("admin");
    	dataSource.setUser("root");
    	dataSource.setD
    	System.out.println("datasouce created");*/
        
        BasicDataSource dataSource = new BasicDataSource();;
    	dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    	dataSource.setUrl("jdbc:mysql://localhost:3306/springsecurity");
    	dataSource.setUsername("root");
    	dataSource.setPassword("admin");
    	System.out.println("datasouce created");
        return dataSource;
    }

}
