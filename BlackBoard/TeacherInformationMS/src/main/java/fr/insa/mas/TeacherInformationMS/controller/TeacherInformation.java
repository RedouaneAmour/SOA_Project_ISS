package fr.insa.mas.TeacherInformationMS.controller;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import fr.insa.mas.TeacherInformationMS.model.TeacherModel;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/TeacherInformation")
public class TeacherInformation {
	
	@GetMapping("/{teacherID}")
	public TeacherModel getTeacherInformation(@PathVariable int teacherID) {
		List<TeacherModel> teachersArray = new ArrayList<>();
		teachersArray.add(new TeacherModel(0, (int) (Math.random()*(200-145)) + 145, "Lafont"));
		teachersArray.add(new TeacherModel(1, (int) (Math.random()*(200-145)) + 145, "Hebras"));
		teachersArray.add(new TeacherModel(2, (int) (Math.random()*(200-145)) + 145, "Quinio"));
		return teachersArray.stream()
				  .filter(teacher -> teacher.getId() == teacherID)
				  .findAny()
				  .orElse(new TeacherModel(-1, 0, ""));
	}
		

}
