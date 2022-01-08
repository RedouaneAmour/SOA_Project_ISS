 package fr.insa.mas.BlackboardManagementMS.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import fr.insa.mas.OperationModel.model.OperationModel;
import fr.insa.mas.TeacherModel.model.TeacherModel;


 
@RestController
@RequestMapping("/BlackboardManagement")
public class BlackboardManagement {
	
	@GetMapping("/{teacherID}")
	public OperationModel manageBlackboard(@PathVariable int teacherID){
		RestTemplate restTemplate = new RestTemplate();
		String readBlackboardPositionURL = "http://localhost:8181/ReadPosition/";
		String teacherInformationURL = "http://localhost:8182/TeacherInformation/"+teacherID;
		
		
		int currentBlackboardPosition = restTemplate.getForObject(readBlackboardPositionURL, Integer.class);	
		
		TeacherModel teacher = restTemplate.getForObject(teacherInformationURL, TeacherModel.class);
		
		String adjustBlackboardPositionURL = "http://localhost:8183/AdjustBlackboardPosition/" + teacher.getSize() + "/" + currentBlackboardPosition ;
		
		OperationModel operation = restTemplate.getForObject( adjustBlackboardPositionURL, OperationModel.class) ;
		
		return operation;
		
	}
}
