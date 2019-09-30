package com.metacube.get2019.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.metacube.get2019.model.dto.EmployeeDetails;
import com.metacube.get2019.model.dto.LoginForm;
import com.metacube.get2019.model.dto.Pass;
import com.metacube.get2019.model.dto.SignUpForm;
import com.metacube.get2019.model.dto.VehicleForm;
import com.metacube.get2019.model.pojo.Employee;
import com.metacube.get2019.model.pojo.Vehicle;
import com.metacube.get2019.service.ParkingService;
import com.metacube.get2019.util.DTOUtil;

/**
 * The controller for the Metacube Parking System application
 * @author  Kritika
 *
 */

@Controller
public class ParkingController {

	@Autowired
	ParkingService parkingService;

	/**
	 * Controlling for the first welcome page
	 * @return
	 */
	@GetMapping("/home")
	public String getLoginPage(Model model) {

		model.addAttribute(new LoginForm());
		return "index";
	}

	/**
	 * get mapping for signup page
	 * @param model
	 * @return view
	 */
	@GetMapping("/SignUp")
	public String getSignUpPage(Model model) {
		model.addAttribute(new SignUpForm());
		return "SignUp";
	}

	/**
	 * post mapping for login
	 * @param model
	 * @param loginForm
	 * @param result
	 * @param session
	 * @return view
	 */
	@PostMapping("/login")
	public String validateEmployee(Model model,@Validated LoginForm loginForm, BindingResult result,HttpSession session) {
		boolean validated = parkingService.validateEmployee(loginForm.getEmail(),loginForm.getPassword());
		if(validated) {
			session.setAttribute("email_id", loginForm.getEmail());
			return ("redirect:/welcomePage/"+loginForm.getEmail());
		} else {
			ObjectError error=new ObjectError("employee","Email or password is incorrect!!");
			result.addError(error);
			return "index";
		}
	}

	/**
	 * Get mapping for welcome page
	 * @param email
	 * @param model
	 * @return view
	 */
	@GetMapping("/welcomePage/{email}")
	public String welcomeEmployee(@PathVariable("email") String email,Model model) {
		model.addAttribute(new SignUpForm());
		Employee employee = parkingService.getEmployee(email);
		model.addAttribute("employee",employee);
		model.addAttribute("message", "Hi "+employee.getFullName());
		Vehicle vehicle = parkingService.getVehicle(employee.getEmployeeId());
		model.addAttribute("vehicle",vehicle);
		Pass pass = parkingService.getPass(employee.getEmployeeId());
		model.addAttribute("pass",pass);
		model.addAttribute(new EmployeeDetails());
		model.addAttribute("email",email);
		return "WelcomeEmployee";
	}

	/**
	 * Controlling the application when errors come and after the 
	 * correct submission in the Registration Form
	 * @param signUpForm
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/Registration")
	public String doRegistration(@Validated SignUpForm signUpForm, BindingResult result,Model model) {
		if(!signUpForm.getConfirmPassword().equals(signUpForm.getPassword())) {
			ObjectError error=new ObjectError("confirmPassword","Both the passwords don't match");
			result.addError(error);
		}
		if( result.hasErrors()) {
			return "SignUp";
		} else { 
			Employee employee  = DTOUtil.map(signUpForm, Employee.class);
			boolean inserted = parkingService.addEmployee(employee);
			if(inserted) {
				model.addAttribute(new VehicleForm());
				model.addAttribute("employeeId",employee.getEmployeeId());
				model.addAttribute("message","Congratulations!!You have been successfully registered.Your employee id is ");
				return "VehicleRegistrationForm";
			} else {
				ObjectError error=new ObjectError("email","Duplicate email id or contact number!!");
				result.addError(error);
				return "SignUp";
			}
		}
	}

	/**
	 * Controlling for the errors in vehicle registration form 
	 * and after successful registration of the vehicle
	 * @param vehicleform
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/VehicleRegistrationForm")
	public String getVehicleRegistrationData(@Validated VehicleForm vehicleform,BindingResult result,Model model) {
		if( result.hasErrors()) {
			return "VehicleRegistrationForm";
		} else { 
			boolean inserted = parkingService.addVehicle(vehicleform);
			if(inserted) {
				model.addAttribute(new Pass());
				model.addAttribute("employeeId",vehicleform.getEmployeeId());
				model.addAttribute("vehicleNumber",vehicleform.getVehicleNumber());
				if(vehicleform.getVehicleType().equalsIgnoreCase("MotorCycle")) {
					return "MotorCyclePass";
				} else if(vehicleform.getVehicleType().equalsIgnoreCase("Cycle")) {
					return "CyclePass";
				} else {
					return "FourWheelerPass";
				}
			} else {
				ObjectError error=new ObjectError("vehicleNumber","Vehicle Number already exists!!");
				result.addError(error);
				return "VehicleRegistrationForm";
			}
		}
	}

	/**
	 * Controlling for the Pass page
	 * @param pass
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/getPassDetails")
	public String getPass(@Validated Pass pass,BindingResult result,Model model) {
		if( result.hasErrors()) {
			if(pass.getVehicleType().equalsIgnoreCase("cycle")) {
				return "CyclePass";
			} else if(pass.getVehicleType().equalsIgnoreCase("motorcycle")) {
				return "MotorCyclePass";
			} else {
				return "FourWheelerPass";
			} 
		} else { 
			boolean inserted = parkingService.addPass(pass);
			if(inserted) {
				double billpassPrice=pass.billPassPrice(pass.getCurrencyType(),pass.getPassPrice());
				String finalPrice=billpassPrice+" "+pass.getCurrencyType();
				model.addAttribute("billPassPrice",finalPrice);
				return "SuccessfulSignUp";
			} else {
				ObjectError error=new ObjectError("signUp","Something went wrong!");
				result.addError(error);
				model.addAttribute(new SignUpForm());
				return "SignUp";
			}
		}
	}

	/**
	 * Controls edit profile page
	 * @param model
	 * @param employeeDetails
	 * @return
	 */
	@PostMapping("/EditYourProfile")
	public String editProfile(Model model ,EmployeeDetails employeeDetails) {
		model.addAttribute("employee", employeeDetails);
		model.addAttribute(new EmployeeDetails());
		return "EditProfile";
	}

	/**
	 * Controls update profile page
	 * @param employeeDetails
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/updateProfile")
	public String updateProfileboo(@Validated EmployeeDetails employeeDetails,BindingResult result, Model model) {
		if(result.hasErrors()||result.getErrorCount()>0) {
			return "EditProfile";
		} else {
			Employee employee  = DTOUtil.map(employeeDetails, Employee.class);
			boolean updated = parkingService.updateEmployee(employee);
			System.out.println(updated);
			if(updated) {
				model.addAttribute("message","Your details have been successfully edited and saved!!");
			} else {
				ObjectError error=new ObjectError("update","Something went wrong!");
				result.addError(error);
			}
			return "EditProfile";
		}
	}

	/**
	 * Get Mapping to retrive friend list
	 * @param employeeDetails
	 * @param model
	 * @param email
	 * @param session
	 * @return
	 */
	@GetMapping("/getFriends/{email}")
	public String getFriends(EmployeeDetails employeeDetails,Model model,@PathVariable("email")String email,HttpSession session) {
		Employee employee  = DTOUtil.map(employeeDetails, Employee.class);
		List<Employee> friendsList=parkingService.getFriends(email);
		Employee sessionEmployee = parkingService.getEmployee(email);
		model.addAttribute("email", session.getAttribute("email_id"));
		if(friendsList.size()==0) {
			model.addAttribute("message","Your Friend List is empty!!");
		} else {
			model.addAttribute("message", "Meet your friends "+sessionEmployee.getFullName());
			model.addAttribute("friendsList",friendsList);
		}
		return "FriendsPage";
	}

	/**
	 * controller to view profile of each employee
	 * @param email
	 * @param model
	 * @param session
	 * @return
	 */
	@GetMapping("/ViewProfile/{email}")
	public String updateStudent(@PathVariable("email")String email,Model model,HttpSession session ) {
		Employee employee = parkingService.getEmployee(email);
		model.addAttribute("email", session.getAttribute("email_id"));
		model.addAttribute("employee",employee);
		model.addAttribute("message",employee.getFullName());
		Vehicle vehicle = parkingService.getVehicle(employee.getEmployeeId());
		model.addAttribute("vehicle",vehicle);
		Pass pass = parkingService.getPass(employee.getEmployeeId());
		model.addAttribute("pass",pass);
		model.addAttribute(new EmployeeDetails());
		return "FriendProfile";
	}

	/**
	 * controller for logout
	 * @param session
	 * @param model
	 * @return
	 */

	@GetMapping("/logout")
	public String logout(HttpSession session,Model model) {

		model.addAttribute(new LoginForm());
		session.invalidate();
		return "redirect:/home";
	}
}
