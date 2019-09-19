package com.learning.fun.CamelIntegration.config;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		//from("file:C:\\Users\\vikas\\OneDrive\\Pictures\\iCloud Photos\\Downloads?noop=true").to("file:E:\\old computer photos\\PHOTOS\\US\\2019\\temp\\");
	}
}

