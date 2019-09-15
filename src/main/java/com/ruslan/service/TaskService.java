package com.ruslan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ruslan.model.Task;


@Service
public interface TaskService {

		public List<Task> findAll();
		
		public Task findById(int theId);
		
		public void save(Task theTask);
		
		public void deleteById(int theID);
}