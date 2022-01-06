package fr.insa.mas.ReadsBlackboardPositionMS.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ReadPosition")
public class BlackboardPosition {

	@GetMapping("")
	public double getPosition() {
		// We suppose teachers are between 145cm tall and 200cm tall
		// so we return a random value between 145cm and 200cm for the blackboard position 
		return (int) (Math.random() * (200-145)) + 145;
	}
		

}
