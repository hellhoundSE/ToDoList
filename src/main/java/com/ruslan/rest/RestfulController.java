package com.ruslan.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruslan.model.Task;
import com.ruslan.service.MainService;

@RestController
@RequestMapping("/api")
public class RestfulController {
	
	@Autowired
	MainService mainService;
	
	@GetMapping("/tasks")
	public List<Task> allTasks(){
		return mainService.getTaskService().findAll();
	}
	
	@GetMapping("/tasks/{taskId}")
	public Task taskById(@PathVariable int taskId) {
		for (Task theTask : mainService.getTaskService().findAll()) {
			if (taskId == theTask.getId()) {
				return theTask;
			}
		}
		return null;
	}
	@DeleteMapping("/tasks/{taskId}")
	public void deleteTask(@PathVariable int taskId) {
		mainService.getTaskService().deleteById(taskId);
	}
	
	@PostMapping("/tasks")
	public Task addTask(@RequestBody Task theTask) {
		theTask.setId(0);
		mainService.getTaskService().save(theTask);
		return theTask;
	}
	
	@PutMapping("/tasks")
	public Task updateTask(@RequestBody Task theTask) {
		mainService.getTaskService().save(theTask);
		return theTask;
	}
	
	
	

}
