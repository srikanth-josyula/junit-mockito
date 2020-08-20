package com.sample.mockito.xample.java;

import com.sample.mockito.xample.java.services.CustomService;

public class Utility {
	private CustomService service;
	
	public Utility(CustomService service) {
        this.service = service;
    }
	
	public String process() {
        String response = service.printSomething();
        return "The Response is: " + response;
    }
}
