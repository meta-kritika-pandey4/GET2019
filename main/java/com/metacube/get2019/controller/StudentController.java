package com.metacube.get2019.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.metacube.get2019.model.dto.SearchByClass;
import com.metacube.get2019.model.dto.SearchByName;
import com.metacube.get2019.model.dto.StudentCommands;
import com.metacube.get2019.model.dto.UpdateStudentCommands;
import com.metacube.get2019.model.pojo.Student;
import com.metacube.get2019.service.StudentService;

/**
 * Controller class for all the request mapping
 * @author user
 *
 */
@Controller
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	/**
	 * Returns to the home page
	 * @return home.jsp
	 */
	@GetMapping("/home")
	public String home() {
		return "index";
	}
	
	/**
	 * get mapping for addStudentDetails
	 * @param model
	 * @return view
	 */
	@GetMapping("/AddStudentDetail")
	public String addStudent(Model model) {
		model.addAttribute(new StudentCommands());
		return "AddStudentDetail";
	}
	
	/**
	 * PostMapping for add student details
	 * @param studentCommands
	 * @param result
	 * @param model
	 * @return view
	 */
	@PostMapping("/addStudentDetails")
	public String addStudentDetails(@Validated StudentCommands studentCommands,BindingResult result,Model model) {
		if(result.hasErrors()||result.getErrorCount()>0) {
			return "AddStudentDetail";
		} else {
			boolean isAdded=studentService.addStudent(studentCommands);
			if(isAdded) {
				model.addAttribute("message","Student Details added successfully!!");
			} else {
				model.addAttribute("message","This email id already  exists!!");
			}
			List<Student> studentList=studentService.getAllStudents();
			model.addAttribute("studentList",studentList);
			return "ShowStudent";
			}
		}
	
	/**
	 * Get mapping to get all student list
	 * @param model
	 * @return view
	 */
	@GetMapping("/showStudent")
	public String showStudents(Model model) {
		List<Student> studentList=studentService.getAllStudents();
		model.addAttribute("studentList",studentList);
		return "ShowStudent";
	}	
	
	/**
	 * get mapping to update student
	 * @param studentId
	 * @param model
	 * @return view
	 */
	@GetMapping("/updateStudent/{studentId}")
	public String updateStudent(@PathVariable("studentId")int studentId,Model model ) {
		Optional<Student> studentFetched=studentService.getStudentDetails(studentId);
		Student student=studentFetched.get();
		model.addAttribute(new UpdateStudentCommands());
		model.addAttribute("student",student);
		return "UpdateStudent";
	}
	
	/**
	 * post mapping to update student
	 * @param updateStudentCommands
	 * @param result
	 * @param model
	 * @return view
	 */
	@PostMapping("/updateStudent/{studentId}")
	public String updateStudentDetails(@Validated UpdateStudentCommands updateStudentCommands,BindingResult result,Model model) {
		if(result.hasErrors()||result.getErrorCount()>0) {
			return "UpdateStudent";
		} else {
			boolean updated=studentService.updateStudentDetails(updateStudentCommands);
			if(updated) {
				model.addAttribute("message", "Student Details Updated successfully");
			} else {
				model.addAttribute("message","This email id already  exists!!");
			}
			List<Student> studentList=studentService.getAllStudents();
			model.addAttribute("studentList",studentList);
			return "ShowStudent";
		}
	}
	
	/**
	 * Get mapping to search student
	 * @param model
	 * @return view
	 */
	@GetMapping("/searchStudent")
	public String searchStudent(Model model) {
		model.addAttribute(new SearchByName());
		model.addAttribute(new SearchByClass());
		return "SearchStudent";
	}
	
	/**
	 * Post mapping to search student by name
	 * @param model
	 * @param searchByClass
	 * @param searchByName
	 * @param result
	 * @return view
	 */
	@PostMapping("/searchByName")
	public String searchByName(Model model, SearchByClass searchByClass,@Validated SearchByName searchByName,BindingResult result) {
		if(result.hasErrors()) {
			return "SearchStudent";
		} else {
			List<Student> studentList=studentService.getStudentByName(searchByName.getFirstName(),searchByName.getLastName());
			if(studentList.size()==0) {
				model.addAttribute("message","No matching details found");
			} else {
				model.addAttribute("message","Matching Student Details found");
				model.addAttribute("studentList",studentList);
			}
			return "SearchStudent";
		}
	}
	
	/**
	 * Post mapping to search student by class
	 * @param model
	 * @param searchByClass
	 * @param searchByName
	 * @param result
	 * @return
	 */
	@PostMapping("/searchByClass")
	public String searchByClass(Model model,SearchByName searchByName, @Validated SearchByClass searchByClass,BindingResult result) {
		if(result.hasErrors()) {
			return "SearchStudent";
		} else {
			List<Student> studentListByClass=studentService.getStudentByClass(searchByClass.getClassName());
			if(studentListByClass.size()==0) {
				model.addAttribute("messageForClassSearch","No matching details found");
			} else {
				model.addAttribute("messageForClassSearch","Matching Student Details found");
			}
			model.addAttribute("studentListByClass",studentListByClass);
			return "SearchStudent";
		}
	}
	
	@GetMapping("/LoginPage")
		public String login() {
		return "LoginPage";
	}
	
	@GetMapping("/failure")
	public String loginFailed() {
		return "failure";
	}
}
