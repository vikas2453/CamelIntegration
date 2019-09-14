package com.learning.fun.CamelIntegration.Config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataBaseConfig {
	
	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource createDataSource() {
		DataSource dataSource =DataSourceBuilder.create().build();	
		
		return dataSource;	
		
	}
	

}
