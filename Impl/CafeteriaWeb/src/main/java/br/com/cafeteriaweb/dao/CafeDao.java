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
	
	public void delete(Long idCafe) {
		Cafe cafe = (Cafe) session().get(Cafe.class, idCafe);
		session().delete(cafe);
		session().flush();
	}
	
	public Cafe create(Cafe cafe) {
		session().save(cafe);
		session().flush();
		return cafe;
	}

	private Session session() {
		return sessionFactory.getCurrentSession();
	}
	
}
