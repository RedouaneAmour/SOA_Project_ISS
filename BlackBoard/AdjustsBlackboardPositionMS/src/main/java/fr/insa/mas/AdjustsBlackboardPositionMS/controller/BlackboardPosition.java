package fr.insa.mas.AdjustsBlackboardPositionMS.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.mas.OperationModel.model.OperationModel;

@RestController
@RequestMapping("/AdjustBlackboardPosition/{teacherSize}/{currentBlackboardPosition}")
public class BlackboardPosition {
	@GetMapping("")
	public OperationModel adjustBlackboardPosition(@PathVariable int teacherSize, @PathVariable int currentBlackboardPosition){
		OperationModel operation = new OperationModel(true, "No need to adjust the board, it is still easy for the teacher to write");
		
		if((teacherSize >= 145) && (teacherSize <= 200)) {
			if((teacherSize <= (currentBlackboardPosition - 5)) || (teacherSize >= (currentBlackboardPosition + 5))){
				operation.setReason("adjusting blackboard to position " + teacherSize + " because the teacher is " + teacherSize + " cm tall");
			}
			
		}else {
			operation.setReason("no adjustment made since teacher is unknown");
			operation.setSuccess(false);
		}
		return operation;
	}
}
