package com.learning.fun.CamelIntegration.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.learning.fun.CamelIntegration.processor.MyGenericProcessor;

@Configuration
public class SqlOrderProcessorRoute extends RouteBuilder {

	public static final String ROUTE_NAME = "SqlLogRoute";
	
	@Autowired
	private MyGenericProcessor myProcessor;
	
	@Override
	public void configure() throws Exception {
		onException(Exception.class).to("sql: update Orders.camelProcessing set status='F' where id=:#id");
		//onCompletion().to("sql: update Orders.camelProcessing set status='O' where id=:#id");
		
		/*from("sql:SELECT room_id FROM ROOM where room_name in('Chatty room')")
				.to("log:com.learning.fun.CamelIntegration.Config?level=INFO");
*/
		//from("timer://foo?fixedRate=true&period=60000").
		//from("timer://simpleTimer?period=1000").
		from("scheduler:myScheduler?delay=2000").
		to("sql:select id, processorName, payload from Orders.camelProcessing where status ='N'?consumer.onConsume=update Orders.camelProcessing set status='P' where id=:#id")
		//from("sql:select id from Orders.customer where status ='N'?consumer.onConsume=update Orders.order set status='P' where id=:#id")
		//from("sql:select firstName,  email from Orders.customer where  id>1003")
		//.convertBodyTo(ProcessorModel.class)
		.process(myProcessor)
		//.to("sql: update Orders.camelProcessing set status='O' where id=:#id")
		;
		//.to("log:com.learning.fun.CamelIntegration.Config?level=INFO");
	}
}
