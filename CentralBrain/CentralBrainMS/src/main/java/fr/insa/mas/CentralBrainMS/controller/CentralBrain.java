package fr.insa.mas.CentralBrainMS.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import fr.insa.mas.OperationModel.model.OperationModel;

@RestController
@RequestMapping("/WebApplication")
public class CentralBrain {
	
	@GetMapping("/Blackboard")
	public OperationModel handleBlackboard(@RequestParam("teacherID") int teacherID) {
		RestTemplate restTemplate = new RestTemplate();
		String blackboardURL = "http://localhost:8180/BlackboardManagement/" + teacherID;		
		OperationModel blackboardOperation = restTemplate.getForObject(blackboardURL, OperationModel.class);
		return blackboardOperation;
	}
	
	@GetMapping("/AirConditioner")
	public OperationModel handleAirConditions() {
		RestTemplate restTemplate = new RestTemplate();
		String airConditionerURL = "http://localhost:8280/AirConditionerManagement/";
		OperationModel airConditionerOperation = restTemplate.getForObject(airConditionerURL, OperationModel.class);
		
		return airConditionerOperation;
	}
	
}
