package com.learning.fun.CamelIntegration.Config;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IntegrationConfig extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("sql:SELECT room_id FROM ROOM where room_name in('Chatty room')")
				.to("log:com.learning.fun.CamelIntegration.Config?level=INFO");

	}
}
