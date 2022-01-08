package fr.insa.mas.TeacherInformationMS;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import fr.insa.mas.TeacherInformationMS.controller.TeacherInformation;
import fr.insa.mas.TeacherInformationMS.model.TeacherModel;

@SpringBootTest
class TeacherInformationMsApplicationTests {

	@Mock
	private Mock model;
	
	@Test
	void contextLoads() {
		
		TeacherInformation controller = new TeacherInformation();
		assertTrue(testTeachers(new TeacherModel(-1, 0, ""), controller.getTeacherInformation(-1)));
		
		List<TeacherModel> teachersArray = new ArrayList<>();
		teachersArray.add(new TeacherModel(0, (int) (Math.random()*(200-145)) + 145, "Lafont"));
		teachersArray.add(new TeacherModel(1, (int) (Math.random()*(200-145)) + 145, "Hebras"));
		teachersArray.add(new TeacherModel(2, (int) (Math.random()*(200-145)) + 145, "Quinio"));
		assertTrue(testTeachersNames(teachersArray.stream()
				  .filter(teacher -> teacher.getId() == 0)
				  .findAny().orElse(new TeacherModel(-1, 0, "")), controller.getTeacherInformation(0)));
		
	}
	private boolean testTeachers(TeacherModel  A, TeacherModel B) {
		if((A.getName() == B.getName()) && (A.getId() == B.getId()) && (A.getSize() == B.getSize())){
			return true;
		}else {
			return false;
		}
	}
	private boolean testTeachersNames(TeacherModel  A, TeacherModel B) {
		if((A.getName() == B.getName())){
			return true;
		}else {
			return false;
		}
	}

}
