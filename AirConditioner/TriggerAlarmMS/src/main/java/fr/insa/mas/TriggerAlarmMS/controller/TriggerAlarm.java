package fr.insa.mas.TriggerAlarmMS.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.mas.OperationModel.model.OperationModel;

@RestController
@RequestMapping("/TriggerAlarm")
public class TriggerAlarm {
	
	@PostMapping("/{frequency}")
	public OperationModel triggerAlarm(@PathVariable double frequency) {
		OperationModel operation = new OperationModel(true, "");
		if((frequency >= 0) && (frequency <= 1)) {
			operation.setReason("alarm is currently being triggered every " + (1/frequency) + " seconds because of high smoke rate detected : " + frequency);
		}else {
			operation.setSuccess(false);
			operation.setReason("invalid smoke rate : alarm triggering could not be performed");
		}		
		return operation;
	}
	
	@GetMapping("/ShutDown")
	public OperationModel triggerAlarm() {
		return new OperationModel(true, "alarm has been successfully turned off");
	}
}
