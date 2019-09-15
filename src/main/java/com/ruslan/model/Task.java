package com.ruslan.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "task")
@NoArgsConstructor
@Data
public class Task {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "start_date")
	private Timestamp startDate;
	
	@Column(name = "finish_date")
	private Timestamp finishDate;
	
	@Column(name = "is_finished")
	private boolean finished;

	public Task(String content, Timestamp startDate) {
		this.content = content;
		this.startDate = startDate;
	}

	public void finish() {
		finished=true;
		finishDate = new Timestamp(new Date().getTime());
	}


	

}
