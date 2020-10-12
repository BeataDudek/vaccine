package com.vaccine.view;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vaccine.model.Issue;
import com.vaccine.model.User;
import com.vaccine.repository.IssueRepository;
import com.vaccine.repository.UserRepository;

@Controller
public class HomeController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	IssueRepository issueRepository;

	@GetMapping("home")
	public ModelAndView homeView(Model model, HttpServletRequest req) {
		String id = (String) req.getSession().getAttribute("id");
		if (id != null) {
			User user = userRepository.findById(Integer.valueOf(id));
			model.addAttribute("role", "1");
		}

		List<Issue> issueList = issueRepository.findAll();
		model.addAttribute("issueList", issueList);

		return new ModelAndView("home");
	}
}