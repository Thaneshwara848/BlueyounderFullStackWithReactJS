package com.wipro.part9.Lab75;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes
public class LoginController {
	@Autowired
	private UserValidator userValidator;

	@RequestMapping(value = "/verifyUser.wipro", method = RequestMethod.POST)
	public String verifyUser(@ModelAttribute("user") User user, BindingResult result) {
		System.out.println("verify user()");

		userValidator.validate(user, result);
		if (result.hasErrors()) {
			System.out.println(result.getErrorCount());
			return "login";
		}

		// ---------------------
		String un = user.getUsername();
		String pw = user.getPassword();
		System.out.println(un);
		System.out.println(pw);
		if (!un.equals(un)) {
			return "login";
		}
		return "home";
	}

	@RequestMapping(value = "/login.wipro", method = RequestMethod.POST)
	public String showLoginForm(Map model) {
		System.out.println("showLoginForm");
		User user = new User();
		user.setUsername("Suresh");
		model.put("user", user);
		return "login";
	}

}
