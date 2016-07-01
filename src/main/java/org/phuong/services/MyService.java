package org.phuong.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.phuong.model.SimpleObject;
import org.phuong.resources.MyResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("myService")
@Stateless
public class MyService {

	private final static Logger log = LoggerFactory.getLogger(MyService.class);
	
	@PersistenceContext(unitName="simple-rest-pu")
	EntityManager em;

	public MyService() {
		super();
	}

	public String sayHello() {
		return "Hello";
	}

	@SuppressWarnings("unchecked")
	@Transactional()
	public List<SimpleObject> getHeroes() {
		Query query = em.createQuery("SELECT e FROM SimpleObject e");
		return query.getResultList();
	}
	
	public SimpleObject getHero(Integer id) {
		return em.find(SimpleObject.class, id);
	}
	
	public SimpleObject saveHero(Integer id) {
		return em.find(SimpleObject.class, id);
	}

	@Transactional()
	public SimpleObject saveHero(SimpleObject json) {
		SimpleObject entity = em.find(SimpleObject.class, json.getId());
		entity.setName(json.getName());
		entity.setMsg("modified on " + new Date());
		return entity;
	}
}
