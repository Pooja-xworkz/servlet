package com.xworkz.servletHibernate.dao;

import java.util.List;

import com.xworkz.servletHibernate.entity.ContactEntity;

public interface ContactDAO {
	public void save(ContactEntity entity);
	public Object findByName(String name);
	public Object findByEmail(String email);
	public List<ContactEntity> findAll();

}
