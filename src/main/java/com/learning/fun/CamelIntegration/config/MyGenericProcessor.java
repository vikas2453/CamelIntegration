package com.learning.fun.CamelIntegration.config;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;
import com.learning.fun.CamelIntegration.model.ProcessorModel;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class MyGenericProcessor implements Processor {
	Gson gson = new Gson();
	

	@Override
	public void process(Exchange exchange) throws Exception {
		
		String json=exchange.getIn().getBody(String.class);
		log.info("Received Json: "+json);
		ProcessorModel modelObj= getModel(json);
		log.info("modelObj: "+modelObj);
		
		Class<MyAbstractProcessor> myAbstractProcessorClass= (Class<MyAbstractProcessor>)Class.forName("com.learning.fun.CamelIntegration.config."+modelObj.getProcessorName());
		
		MyAbstractProcessor myAbstractProcessor = myAbstractProcessorClass.getConstructor().newInstance();
	
		myAbstractProcessor.setPayloadString(modelObj.getPayload());
		
		myAbstractProcessor.execute();

	}


	private ProcessorModel getModel(String json) {
		String [] splitted=json.split("=");
		ProcessorModel modelObj = new ProcessorModel();
		
		
		modelObj.setId(Integer.parseInt(splitted[1].split(",")[0]));
		modelObj.setProcessorName(splitted[2].split(",")[0]);
		int lastIndex=splitted[3].length()-1;
		String payload=splitted[3].substring(0, lastIndex);
		modelObj.setPayload(payload);
		return modelObj;
	}
	
	

}
