package com.learning.fun.CamelIntegration.processor;

import lombok.Data;

@Data

public abstract class MyAbstractProcessor {
	
private String payloadString;

public abstract  void execute() ;

}
