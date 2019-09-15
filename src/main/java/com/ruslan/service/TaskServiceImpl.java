package com.ruslan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruslan.dao.TaskDAO;
import com.ruslan.model.Task;

@Service
public class TaskServiceImpl implements TaskService {

	
	@Autowired
	TaskDAO taskDAO;
	
	@Override
	@Transactional
	public List<Task> findAll() {
		return taskDAO.findAll();
	}

	@Override
	@Transactional
	public Task findById(int theId) {
		return taskDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Task theTask) {
		taskDAO.save(theTask);
	}

	@Override
	@Transactional
	public void deleteById(int theID) {
		taskDAO.deleteById(theID);

	}

}
