package com.metacube.get2019.controller;

import java.awt.List;
import java.util.concurrent.SynchronousQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.metacube.get2019.model.dto.LoginForm;
import com.metacube.get2019.model.dto.Pass;
import com.metacube.get2019.model.dto.SignUpForm;
import com.metacube.get2019.model.dto.VehicleForm;
import com.metacube.get2019.model.pojo.Employee;
import com.metacube.get2019.service.ParkingService;

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
	public String getLoginPage() {
		return "index";
	}
	
	@PostMapping("/home")
	public String validateEmployee(Model model,@Validated LoginForm loginForm, BindingResult result) {
		boolean validated = parkingService.validateEmployee(loginForm.getEmail(),loginForm.getPassword());
		if(validated) {
			Employee employee = parkingService.getEmployee(loginForm.getEmail());
			model.addAttribute("employee",employee);
			return "SignUp";
		} else {
			ObjectError error=new ObjectError("employee","Email or password is incorrect!!");
			result.addError(error);
			return "index";
		}
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
			System.out.println("error added");
			ObjectError error=new ObjectError("confirmPassword","Both the passwords don't match");
			result.addError(error);
		}
		if( result.hasErrors()) {
			return "SignUp";
		} else { 
			boolean inserted = parkingService.addEmployee(signUpForm);
			if(inserted) {
				model.addAttribute(new VehicleForm());
				return "VehicleRegistrationForm";
			} else {
				ObjectError error=new ObjectError("email","Email id already exists!!");
				result.addError(error);
				return "SignUP";
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
				return "SignUP";
			}
		}
	}
}
