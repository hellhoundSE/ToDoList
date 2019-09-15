package com.ruslan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Getter;

@Getter
@Service
public class MainService {
	
	@Autowired
	TaskService taskService;

}
