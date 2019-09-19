package com.metacube.get2019.controller;

import java.util.concurrent.SynchronousQueue;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.metacube.get2019.model.dto.Pass;
import com.metacube.get2019.model.dto.SignUpForm;
import com.metacube.get2019.model.dto.VehicleForm;

/**
 * The controller for the Metacube Parking System application
 * @author Kritika
 *
 */

@Controller
public class ParkingController {
	
	/**
	 * Controlling for the first welcome page
	 * @return
	 */
	@GetMapping("/home")
	public String getLoginPage() {
		return "index";
	}
	
	/**
	 * Controlling for the RegistrationForm
	 * @param model
	 * @return 
	 */
	@GetMapping("/SignUp")
	public String getSignUpPage(Model model) {
		model.addAttribute(new SignUpForm());
		return "SignUp";
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
			model.addAttribute(new VehicleForm());
			return "VehicleRegistrationForm";
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
			model.addAttribute(new Pass());
			model.addAttribute("vehicleType",vehicleform.getVehicleType());
			model.addAttribute(vehicleform.getVehicleType());
			if(vehicleform.getVehicleType().equalsIgnoreCase("MotorCycle")) {
				return "MotorCyclePass";
			} else if(vehicleform.getVehicleType().equalsIgnoreCase("Cycle")) {
				return "CyclePass";
			} else if(vehicleform.getVehicleType().equalsIgnoreCase("FourWheeler")) {
				return "FourWheelerPass";
			} else {
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
		System.out.println(pass.getVehicleType());
		if( result.hasErrors()) {
			if(pass.getVehicleType().equalsIgnoreCase("cycle")) {
				return "CyclePass";
			} else if(pass.getVehicleType().equalsIgnoreCase("motorcycle")) {
				return "MotorCyclePass";
			} else if(pass.getVehicleType().equalsIgnoreCase("fourwheeler")) {
				return "FourWheelerPass";
			} else {
				return "SuccessfulSignUp";
			}
		} else { 
		  double billpassPrice=pass.billPassPrice(pass.getCurrencyType(),pass.getPassPrice());
		  String finalPrice=billpassPrice+" "+pass.getCurrencyType();
		  model.addAttribute("billPassPrice",finalPrice);
		  return "SuccessfulSignUp";
		}
	}
}
