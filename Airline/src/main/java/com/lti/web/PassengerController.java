package com.lti.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.core.entities.UserDetails;
import com.lti.core.exceptions.HrExceptions;
import com.lti.core.services.PassengerService;



@RestController
public class PassengerController {
	
	@Autowired
	private PassengerService passengerService;

	@PostMapping(value="/addPassenger",consumes = "APPLICATION/JSON")
	public void addPassenger(@RequestBody UserDetails userDetails) throws HrExceptions{
		System.out.println(userDetails);
		
			boolean b=passengerService.addPassenger(userDetails);
			if(b){
				System.out.println(b);
				
			}
			else
			{
				System.out.println(b);
			}
		
		//return true;
	}
	
//	@PostMapping(value="/addDept",consumes = "application/json")
//	public void getDeptList(@RequestBody Department dept) throws HrException{
//		System.out.println(dept);
//		boolean b=service.createDept(dept);
//		System.out.println(b);
//		service.createDept(dept);
//		
//	}
	@PostMapping(value="/login",consumes = "application/json")
	public UserDetails loginPage(@RequestBody @RequestParam("email") String userName,@RequestParam("password") String password) throws HrExceptions{
		System.out.println(userName);
		return passengerService.userLogin(userName, password);
	}
}
