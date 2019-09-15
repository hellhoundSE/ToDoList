package com.ruslan.controllers;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ruslan.model.Task;
import com.ruslan.service.MainService;

@Controller
public class HomeController {
	
	@Autowired
	MainService mainService;
	
	
	@RequestMapping("/home")
	public String mainPage(Model model) {
		List<Task> list = mainService.getTaskService().findAll(); 
		model.addAttribute("list", list);
		return "home";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Task theTask = new Task();
		model.addAttribute("newTask",theTask); 
		return "formForAdd";
	}
	
	@PostMapping("/save")
	public String saveTask(@ModelAttribute("newTask") Task theTask) {
		theTask.setStartDate(new Timestamp(new java.util.Date().getTime()));
		mainService.getTaskService().save(theTask);
		return "redirect:/home";
	}
	
	@RequestMapping("/finish")
	public String finishTaskById(@RequestParam(value = "id") int theId) {
		Task theTask = mainService.getTaskService().findById(theId);
		if(!theTask.isFinished()) {
			theTask.finish();
			mainService.getTaskService().save(theTask);
		}
		return "redirect:/home";
	}
	
	@RequestMapping("/delete")
	public String deleteTaskById(@RequestParam(value = "id") int theId) {
		mainService.getTaskService().deleteById(theId);
		return "redirect:/home";
	}
	
}
