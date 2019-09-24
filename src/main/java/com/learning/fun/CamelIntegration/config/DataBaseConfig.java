package com.learning.fun.CamelIntegration.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataBaseConfig {

	/*
	 * Below method and property are only required if you want to set a different
	 * data pool other Hik
	 * 
	 * @Value("${spring.datasource.url}") private String JdbcUrl;
	 * 
	 * @Value("${spring.datasource.driverClassName}") private String
	 * driverClassName;
	 * 
	 * @Value("${spring.datasource.username}") private String username;
	 * 
	 * @Value("${spring.datasource.password}") private String password;
	 * 
	 * @Bean
	 * 
	 * @ConfigurationProperties(prefix="spring.datasource") public DataSource
	 * createDataSource() { BasicDataSource ds = new BasicDataSource();
	 * ds.setUrl(JdbcUrl); ds.setUsername(username); ds.setPassword(password);
	 * ds.setDriverClassName(driverClassName); return ds;
	 * 
	 * }
	 */

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource createDataSource() {
		DataSource dataSource = DataSourceBuilder.create().build();
		return dataSource;
	}
	
	@Bean
	
	@Autowired
	public JdbcTemplate createjdbcTemlate( DataSource ds) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
		return jdbcTemplate;
	}

}
