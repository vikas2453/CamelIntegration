package com.learning.fun.CamelIntegration.processor;

import com.google.gson.Gson;
import com.learning.fun.CamelIntegration.model.OrderPayload;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

@AllArgsConstructor
@NoArgsConstructor
@Log
public class OrderProcessor extends MyAbstractProcessor {
	
	private OrderPayload payload;
	
	Gson gson = new Gson();

	@Override
	public void execute() {
		payload=gson.fromJson(getPayloadString(), OrderPayload.class);
		
		
		log.info(" is being executed with customer value as "+gson.toJson(payload) );

	}

	

}
