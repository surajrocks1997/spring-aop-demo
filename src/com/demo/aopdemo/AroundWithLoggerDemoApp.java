package com.demo.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {

	private static Logger logger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService",
				TrafficFortuneService.class);

		logger.info("Main Program: AroundDemoApp");

		logger.info("Calling Get Fortune");

		String data = trafficFortuneService.getFortune();

		logger.info("Fortune is: " + data);

		logger.info("Finished");

		context.close();
	}
}
