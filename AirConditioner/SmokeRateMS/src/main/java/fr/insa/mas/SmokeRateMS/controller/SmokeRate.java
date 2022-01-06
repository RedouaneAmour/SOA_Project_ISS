package fr.insa.mas.SmokeRateMS.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/SmokeRate")
public class SmokeRate {
	
	@GetMapping("")
	public double getRate() {
		// we return a random value between 145cm and 200cm for the blackboard position 
		return (Math.random());
	}
}
