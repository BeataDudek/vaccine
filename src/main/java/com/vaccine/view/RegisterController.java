package com.vaccine.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vaccine.model.User;
import com.vaccine.repository.UserRepository;

@Controller
public class RegisterController {

	@Autowired
	UserRepository userRepository;

	@GetMapping("register")
	public ModelAndView registerView() {
		return new ModelAndView("register");
	}

	@PostMapping("register")
	public String registerUser(Model model, @RequestParam String firstName, @RequestParam String lastName,
	                           @RequestParam String username, @RequestParam String password) {

		if (userRepository.findByUsernameAndPassword(username, password) != null) {
			model.addAttribute("messageType", "danger");
			model.addAttribute("message", "Uzytkownik już istnieje");
			return "register";
		} else {
			User user = new User(null, firstName, lastName, username, password, true, "admin", null);
			userRepository.save(user);
			return "login";
		}
	}
}
