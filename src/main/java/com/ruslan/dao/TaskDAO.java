package com.ruslan.dao;

import java.util.List;

import com.ruslan.model.Task;


public interface TaskDAO {
	
	public List<Task> findAll();
	
	public Task findById(int theId);
	
	public void save(Task employee);
	
	public void deleteById(int theID);
	
}
