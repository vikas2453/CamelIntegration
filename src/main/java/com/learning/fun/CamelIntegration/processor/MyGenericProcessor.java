package com.learning.fun.CamelIntegration.processor;

import java.util.LinkedHashMap;
import java.util.Map;

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
		String defaultBodyMap= exchange.getIn().getBody(String.class);
		LinkedHashMap<String, String> modelObj= exchange.getIn().getBody(LinkedHashMap.class);
		log.info("Received defaultBodyMap: "+defaultBodyMap);
		
		log.info("modelObj: "+modelObj);
		
		Class<MyAbstractProcessor> myAbstractProcessorClass= (Class<MyAbstractProcessor>)Class.forName("com.learning.fun.CamelIntegration.processor."+modelObj.get("processorName"));
		
		MyAbstractProcessor myAbstractProcessor = myAbstractProcessorClass.getConstructor().newInstance();
	
		myAbstractProcessor.setPayloadString(modelObj.get("payload"));
		
		myAbstractProcessor.execute();

	}


	/*private ProcessorModel getModel(String json) {
		String [] splitted=json.split("=");
		ProcessorModel modelObj = new ProcessorModel();
		
		
		modelObj.setId(Integer.parseInt(splitted[1].split(",")[0]));
		modelObj.setProcessorName(splitted[2].split(",")[0]);
		int lastIndex=splitted[3].length()-1;
		String payload=splitted[3].substring(0, lastIndex);
		modelObj.setPayload(payload);
		return modelObj;
	}*/
	
	

}
