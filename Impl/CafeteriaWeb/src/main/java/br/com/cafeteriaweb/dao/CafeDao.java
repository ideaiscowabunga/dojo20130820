package br.com.cafeteriaweb.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cafeteriaweb.model.Cafe;

public class CafeDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Cafe> findAll() {
		Criteria criteria = session().createCriteria(Cafe.class);
		return (List<Cafe>) criteria.list();
	}

	private Session session() {
		return sessionFactory.getCurrentSession();
	}

	public void delete(String string) {
		
	}
	
	
}
