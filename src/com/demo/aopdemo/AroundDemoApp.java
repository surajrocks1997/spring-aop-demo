package com.demo.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService",
				TrafficFortuneService.class);
		
		System.out.println("Main Program: AroundDemoApp");
		
		System.out.println("Calling Get Fortune");
		
		String data = trafficFortuneService.getFortune();
		
		System.out.println("Fortune is: " + data);
		
		System.out.println("Finished");

		context.close();
	}
}
