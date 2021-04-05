package com.xworkz.servletHibernate.service;

import java.util.List;

import com.xworkz.servletHibernate.entity.ContactEntity;

public interface ContactService {
public boolean validateAndSave(ContactEntity entity);
public ContactEntity validateAndSaveSearchByName(String name);
public ContactEntity validateAndSaveSearchByEmail(String email);
public List<ContactEntity> getall();
}
