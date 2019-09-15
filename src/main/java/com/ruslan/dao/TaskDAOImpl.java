package com.ruslan.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ruslan.model.Task;

@Component
public class TaskDAOImpl implements TaskDAO{

	@Autowired
	EntityManager entityManager;
	
	@Override
	public List<Task> findAll() {
		Session session = entityManager.unwrap(Session.class);
		Query<Task> query = session.createQuery("from Task order by is_finished,finish_date DESC", Task.class);
		List<Task> list = query.getResultList();
		return list;
	}

	@Override
	public Task findById(int theId) {
		Session session = entityManager.unwrap(Session.class);
		Task theTask = session.get(Task.class, theId);
		return theTask;
	}

	@Override
	public void save(Task theTask) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(theTask);

	}

	@Override
	public void deleteById(int theId) {
		Session session = entityManager.unwrap(Session.class);
		Query theQuery = session.createQuery("delete from Task where id = :taskId");
		theQuery.setParameter("taskId", theId);
		theQuery.executeUpdate();
	}

}
