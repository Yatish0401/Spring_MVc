package org.jsp.usermvcapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.jsp.usermvcapp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class UserDao {
	@Autowired
	private EntityManager manager;
	public User saveUser(User u) {
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(u);
		transaction.begin();
		transaction.commit();
		return u;
		
	}
	public User updateUser(User u) {
		EntityTransaction transaction = manager.getTransaction();
		manager.merge(u);
		transaction.begin();
		transaction.commit();
		return u;
		
	}
	public User verifyByUser(long phone , String password) {
		Query q = manager.createQuery("select u from User u where u.phone=?1 and u.Password=?2");
		q.setParameter(1, phone);
		q.setParameter(2, password);
		try {
			return(User) q.getSingleResult();
			
		}
		catch(NoResultException e) {
			return null;
		}
		
		
	}
	public User verifyByUser(String email , String password) {
		Query q = manager.createQuery("select u from User u where u.Email=?1 and u.Password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		try {
			return(User) q.getSingleResult();
			
		}
		catch(NoResultException e) {
			return null;
		}
		
		
	}
	public User verifyByUser(int age , String password) {
		Query q = manager.createQuery("select u from User u where u.age=?1 and u.Password=?2");
		q.setParameter(1, age);
		q.setParameter(2, password);
		try {
			return(User) q.getSingleResult();
			
		}
		catch(NoResultException e) {
			return null;
		}
		
		
	}
	public boolean deleteUser(int id )
	
	{User u = manager.find(User.class, id);
	if(u!= null)
	{
		EntityTransaction transaction = manager.getTransaction();
		manager.remove(u);
		transaction.begin();
		transaction.commit();
		return true;
	}
		
		return false;
		
	}
	public User findUserById(int id) {
		
		return manager.find(User.class, id);
	}

}
