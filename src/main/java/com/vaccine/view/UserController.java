package com.vaccine.view;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
public class UserController {

	@Autowired
	UserRepository userRepository;

	@PostMapping("/removeUser")
	public String remove(Model model, @RequestParam String userId, HttpServletRequest req) {
		String id = (String) req.getSession().getAttribute("id");
		if (id != null) {
			User user = userRepository.findById(Integer.valueOf(id));
			model.addAttribute("role", "1");
		}

		User user = userRepository.findById(Integer.valueOf(userId));
		userRepository.delete(user);
		model.addAttribute("messageType", "danger");
		model.addAttribute("message", "Użytkownik został usunięty");
		return "warning";
	}

	@PostMapping("/activeUser")
	public String active(Model model, @RequestParam String userId, HttpServletRequest req) {
		String id = (String) req.getSession().getAttribute("id");
		if (id != null) {
			User user = userRepository.findById(Integer.valueOf(id));
			model.addAttribute("role", "1");
		}

		User user = userRepository.findById(Integer.valueOf(userId));
		user.setActive(true);
		userRepository.save(user);
		model.addAttribute("messageType", "info");
		model.addAttribute("message", "Użytkownik jest już aktywny");
		return "warning";
	}

	@GetMapping("user")
	public ModelAndView userView(Model model, HttpServletRequest req) {
		String id = (String) req.getSession().getAttribute("id");
		if (id != null) {
			User user = userRepository.findById(Integer.valueOf(id));
			model.addAttribute("role", "1");
		}

		List<User> userList = userRepository.findAll();
		model.addAttribute("users", userList);
		return new ModelAndView("user");
	}
}