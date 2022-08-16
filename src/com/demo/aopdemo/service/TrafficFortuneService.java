package com.demo.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		return "Expect Heavy Traffic this Morning";
	}

	public String getFortune(boolean tripWire) {
		if (tripWire) {
			throw new RuntimeException("Major accident! Highway is closed.");
		}

		return getFortune();
	}
}
