package com.learning.fun.CamelIntegration.Config;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SqlLogRoute extends RouteBuilder {

	public static final String ROUTE_NAME = "SqlLogRoute";
	
	@Override
	public void configure() throws Exception {
		/*from("sql:SELECT room_id FROM ROOM where room_name in('Chatty room')")
				.to("log:com.learning.fun.CamelIntegration.Config?level=INFO");
*/
		from("sql:select id from Orders.order where status ='N'?period=10000?consumer.onConsume=update Orders.order set status='P' where id=:#id")
		.to("log:com.learning.fun.CamelIntegration.Config?level=INFO");
	}
}
