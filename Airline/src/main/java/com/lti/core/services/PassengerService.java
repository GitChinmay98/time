package com.lti.core.services;

import com.lti.core.entities.UserDetails;
import com.lti.core.exceptions.HrExceptions;

public interface PassengerService {

	public boolean addPassenger(UserDetails details)  throws HrExceptions;
	public UserDetails userLogin(String userName, String password) throws HrExceptions;
}
