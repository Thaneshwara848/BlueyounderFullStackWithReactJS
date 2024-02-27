package com.wipro.part9.Lab75;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		// TODO Auto-generated method stub
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object command, Errors errors) {
		// TODO Auto-generated method stub
		User user=(User) command;
		if(user.getUsername()==null || user.getUsername().length()==0){
			errors.rejectValue("username", "error.username.required",null,"Usernamerequired.");
		}

		if(user.getPassword()==null || user.getPassword().length()==0){
			errors.rejectValue("password", "error.password.required",null,"Passwordrequired.");
		}
	}

}
