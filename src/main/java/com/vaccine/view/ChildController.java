package com.vaccine.view;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vaccine.model.Child;
import com.vaccine.model.User;
import com.vaccine.model.Vaccine;
import com.vaccine.model.VaccineCalendar;
import com.vaccine.repository.ChildRepository;
import com.vaccine.repository.UserRepository;
import com.vaccine.repository.VaccineCalendarRepository;
import com.vaccine.repository.VaccineRepository;

@Controller
public class ChildController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ChildRepository childRepository;

	@Autowired
	VaccineRepository vaccineRepository;

	@Autowired
	VaccineCalendarRepository vaccineCalendarRepository;

	@GetMapping("addChild")
	public ModelAndView addChildView(Model model, HttpServletRequest req) {
		String id = (String) req.getSession().getAttribute("id");
		if (id != null) {
			User user = userRepository.findById(Integer.valueOf(id));
			model.addAttribute("role", "1");
		}
		return new ModelAndView("addChild");
	}

	@PostMapping("addChild")
	public String addCustomerView(Model model, HttpServletRequest req,
	                              @RequestParam String firstName,
	                              @RequestParam String lastName,
	                              @RequestParam String birth) {

		String id = (String) req.getSession().getAttribute("id");
		User user = null;
		if (id != null) {
			user = userRepository.findById(Integer.valueOf(id));
			model.addAttribute("role", "1");
		}

		if(LocalDate.parse(birth).isBefore(LocalDate.now())){
			Child child = new Child(firstName, lastName, LocalDate.parse(birth), null, user);
			childRepository.save(child);
			model.addAttribute("messageType", "info");
			model.addAttribute("message", "Dziecko zostało dodane");
		} else {
			model.addAttribute("messageType", "danger");
			model.addAttribute("message", "Data urodzin nie może być datą z przyszłości");
		}

		return "warning";
	}

	@PostMapping("/removeChild")
	public String removeChildView(Model model, @RequestParam String childId, HttpServletRequest req) {
		String id = (String) req.getSession().getAttribute("id");
		if (id != null) {
			User user = userRepository.findById(Integer.valueOf(id));
			model.addAttribute("role", "1");
		}

		Child child = childRepository.findById(Integer.valueOf(childId));
		childRepository.delete(child);
		model.addAttribute("messageType", "danger");
		model.addAttribute("message", "Dziecko zostało usunięte");
		return "warning";
	}

	@GetMapping("child")
	public ModelAndView childView(Model model, HttpServletRequest req) {
		String id = (String) req.getSession().getAttribute("id");
		User user = null;
		if (id != null) {
			user = userRepository.findById(Integer.valueOf(id));
			model.addAttribute("role", "1");
		}

		List<Child> childList = childRepository.findAllByUser(user);
		model.addAttribute("childList", childList);
		return new ModelAndView("child");
	}

	@PostMapping("/addVaccine")
	public String addVaccineView(Model model, @RequestParam String childId, @RequestParam String name, HttpServletRequest req) {
		String id = (String) req.getSession().getAttribute("id");
		if (id != null) {
			User user = userRepository.findById(Integer.valueOf(id));
			model.addAttribute("role", "1");
		}

		Child child = childRepository.findById(Integer.valueOf(childId));

		Vaccine vaccine = new Vaccine(name, LocalDate.now(), child);
		vaccineRepository.save(vaccine);

		model.addAttribute("messageType", "info");
		model.addAttribute("message", "Szczepienie zostało dodane");
		return "warning";
	}

	@GetMapping("childVaccine")
	public ModelAndView childView(Model model, HttpServletRequest req, @RequestParam String childId) {
		String id = (String) req.getSession().getAttribute("id");
		if (id != null) {
			User user = userRepository.findById(Integer.valueOf(id));
			model.addAttribute("role", "1");
		}

		Child child = childRepository.findById(Integer.valueOf(childId));
		model.addAttribute("vaccineList", child.getVaccineList());
		return new ModelAndView("childVaccine");
	}

	@GetMapping("childVaccineCalendar")
	public ModelAndView childVaccineCalendarView(Model model, HttpServletRequest req, @RequestParam String childId) {
		String id = (String) req.getSession().getAttribute("id");
		if (id != null) {
			User user = userRepository.findById(Integer.valueOf(id));
			model.addAttribute("role", "1");
		}

		Child child = childRepository.findById(Integer.valueOf(childId));

		LocalDate today = LocalDate.now();
		Period age = Period.between(child.getBirth(), today);
		int childMonth = age.getMonths();

		List<VaccineCalendar> vaccineCalendarList = vaccineCalendarRepository.findAll();
		List<VaccineCalendar> vaccineList = new ArrayList<>();

		for(VaccineCalendar vaccineCalendar : vaccineCalendarList){
			if (vaccineCalendar.getMonths() >= childMonth && vaccineCalendar.getMonths() <= (childMonth + 1) ){
				vaccineList.add(vaccineCalendar);
			}
		}

		model.addAttribute("vaccineList", vaccineList);
		return new ModelAndView("childVaccineCalendar");
	}
}