package fr.insa.mas.AirConditionerManagementMS.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import fr.insa.mas.OperationModel.model.OperationModel;

@RestController
@RequestMapping("/AirConditionerManagement")
public class AirConditionerManagement {
	
	// we assume there is only one clean room, so no need to provide room id
	// we already know where the clean room is located
	@GetMapping("")
	public OperationModel manageAirConditioner() {
		
		OperationModel operation = new OperationModel(true, "");
		RestTemplate restTemplate = new RestTemplate();
		String smokeRateURL = "http://localhost:8281/SmokeRate/";
		String triggerAlarmURL = "http://localhost:8282/TriggerAlarm/";
		
		//we get the smoke rate so we know what to do next
		double smokeRate = restTemplate.getForObject( smokeRateURL, Double.class) ;		
		
		// we assume that under a rate of 0.3, there is no danger
		if((smokeRate >= 0.4) && (smokeRate <= 1)) {
		
			// we send a trigger alarm request : the alarm will be fired every 1/smokeRate seconds
			// the higher the rate is, the fastest the alarm should be fired
			operation = restTemplate.postForObject(triggerAlarmURL + smokeRate, null, OperationModel.class);
		}else if((smokeRate >= 0) && (smokeRate < 0.4)){
			operation.setReason("Alarm is not triggered because of very low smoke rate : " + smokeRate);
		}else {
			operation.setSuccess(false);
			operation.setReason("invalid smoke rate : check the smoke detector is still functional");
		}
		
		return operation;	 
	}
	
	@GetMapping("/ShutDownAlarm")
	public OperationModel shutDownAlarm() {
		OperationModel operation = new OperationModel(true, "success");
		String shutAlarmURL = "http://localhost:8282/TriggerAlarm/ShutDown";
		RestTemplate restTemplate = new RestTemplate();
		operation = restTemplate.getForObject(shutAlarmURL, OperationModel.class);
		return operation;
	}
}
