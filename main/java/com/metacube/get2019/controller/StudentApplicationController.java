package com.metacube.get2019.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.metacube.get2019.model.commands.StudentCommands;

/**
 * It is the controller to manage the student application
 * @author Kritika
 *
 */
@Controller
public class StudentApplicationController {
	
	/**
	 * Returns to the home page
	 * @return home.jsp
	 */
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	/**
	 * Returns to the sign up page
	 * @param model
	 * @return AddStudentDetail.jsp
	 */
	@GetMapping("/AddStudentDetail")
	public String addStudentDetail(Model model) {
		model.addAttribute("studentCommands",new StudentCommands());
		return "AddStudentDetail";
	}

	/**
	 * Binds the fields to the model, gives validations and redirect to the homepage
	 * @param studentCommands
	 * @param result
	 * 
	 */
	@PostMapping("/addStudentDetails")
	public String doRegistration(@Validated StudentCommands studentCommands, BindingResult result) {
		if( result.hasErrors()) {
			return "AddStudentDetail";
		} else {
			return "redirect:/home";
		}
	}
	
	/**
	 * Redirects to the show students page
	 * @return
	 */
	@GetMapping("/showStudent")
	public String showStudents() {
		return "ShowStudent";
	}
}
