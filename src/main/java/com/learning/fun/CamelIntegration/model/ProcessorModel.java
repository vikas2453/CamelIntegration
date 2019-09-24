package com.learning.fun.CamelIntegration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProcessorModel {
	
	private String id;
	
	private String processorName;
	
	//Json Payload
	private String payload;

}
