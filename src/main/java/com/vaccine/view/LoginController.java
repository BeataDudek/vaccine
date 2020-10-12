package com.vaccine.view;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vaccine.model.User;
import com.vaccine.repository.UserRepository;

@Controller
public class LoginController {

	@Autowired
	UserRepository userRepository;

	@GetMapping("login")
	public ModelAndView loginView() {
		return new ModelAndView("login");
	}

	@PostMapping("login")
	public String login(@RequestParam String username, @RequestParam String password, HttpServletRequest request) {
		User user = userRepository.findByUsernameAndPassword(username, password);
		if (user != null && user.getPassword().equals(password) && user.isActive()) {
			request.getSession().setAttribute("id", Integer.toString(user.getId()));
			return "redirect:home";
		} else {
			return "login";
		}
	}
}
