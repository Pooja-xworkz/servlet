package com.xworkz.servletHibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.xworkz.servletHibernate.entity.ContactEntity;
import com.xworkz.util.PersistenceUtil;

public class ContactDAOImpl implements ContactDAO {

	private EntityManagerFactory factory = PersistenceUtil.getFactory();

	public ContactDAOImpl() {
		System.out.println("created " + this.getClass().getSimpleName());
	}

	@Override
	public void save(ContactEntity entity) {
		EntityManager session = null;
		try {
			session = factory.createEntityManager();
			session.getTransaction().begin();
			session.persist(entity);
			session.flush();
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}

	}

	@Override
	public Object findByName(String name) {
		EntityManager session = null;
		try {
			session = factory.createEntityManager();
			session.getTransaction().begin();
			Query q = session.createNamedQuery("findByName");
			q.setParameter("nm", name);
			Object entity = q.getSingleResult();
			if (entity != null) {
				return entity;
			} else {
				
				return null;
			}}catch (Exception e) {
				return null;
			}
		

	}

	@Override
	public Object findByEmail(String email) {
		EntityManager session = null;
		try {
			session = factory.createEntityManager();
			session.getTransaction().begin();
			Query q = session.createNamedQuery("findByEmail");
			q.setParameter("email", email);
			Object entity = q.getSingleResult();
			return entity;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return null;
		}

	}

	@Override
	public List<ContactEntity> findAll() {
		EntityManager session = null;
		try {
			session = factory.createEntityManager();
			session.getTransaction().begin();
			Query q = session.createNamedQuery("findAll");
			List<ContactEntity> entity = q.getResultList();
			return entity;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return null;
		}
	}
}
