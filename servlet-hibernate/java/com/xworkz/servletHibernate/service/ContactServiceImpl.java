package com.xworkz.servletHibernate.service;

import java.util.List;

import javax.persistence.NoResultException;

import com.xworkz.servletHibernate.dao.ContactDAO;
import com.xworkz.servletHibernate.dao.ContactDAOImpl;
import com.xworkz.servletHibernate.entity.ContactEntity;

public class ContactServiceImpl implements ContactService {
	private ContactDAO dao = new ContactDAOImpl();

	public ContactServiceImpl() {
		System.out.println("created service ");
	}

	@Override
	public boolean validateAndSave(ContactEntity entity) {
		System.out.println("Invoked validateAndSave");
		System.out.println("entity:" + entity);
		boolean valid = true;
		String name1 = entity.getName();
		System.out.println(name1);
		if (entity != null) {
			if (valid) {
				String name = entity.getName();
				System.out.println(name);
				if (name != null && !name.isEmpty() && name.length() > 3 && name.length() <= 20) {
					System.out.println("name is valid");
					valid = true;
				} else {
					System.out.println("name is invalid");
					valid = false;
				}
			}

			if (valid) {
				String email = entity.getEmail();
				if (email != null && !email.isEmpty() && email.contains("@") && email.endsWith(".com")) {
					System.out.println("email is valid");
					valid = true;
				} else {
					System.out.println("email is invalid");
					valid = false;
				}
			}
			if (valid) {
				String phoneNo = entity.getPhoneno();
				if (phoneNo != null && !phoneNo.isEmpty() && phoneNo.length() > 1 && phoneNo.length() <= 10) {
					System.out.println("phoneNo is valid");
					valid = true;
				} else {
					System.out.println("phoneNo is invalid");
					valid = false;
				}
			}
			if (valid) {
				String aboutUrself = entity.getAbouturself();
				if (aboutUrself != null && !aboutUrself.isEmpty() && aboutUrself.length() > 1
						&& aboutUrself.length() <= 300) {
					System.out.println("aboutUrself is valid");
					valid = true;
				} else {
					System.out.println("aboutUrself is invalid");
					valid = false;
				}
			}

		}

		if (valid) {
			this.dao.save(entity);
			System.out.println("contact saved ");
		} else {
			System.out.println("contact not saved");
		}

		return valid;
	}

	@Override
	public ContactEntity validateAndSaveSearchByName(String name) {
		System.out.println("invoked validateAndSaveSearchByName");
		try {
			if (name != null && !name.isEmpty() && name.length() > 3 && name.length() <= 20) {
				System.out.println("name is valid");

				ContactEntity entity = (ContactEntity) dao.findByName(name);
				System.out.println("contact entity " + entity);
				return entity;

			} else {
				System.out.println("name is invalid");
				return null;

			}
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public ContactEntity validateAndSaveSearchByEmail(String email) {
		System.out.println("invoked validateAndSaveSearchByEmail in ContactService");
		if (email != null && !email.isEmpty() && email.contains("@") && email.endsWith(".com")) {
			System.out.println("email is valid");
			ContactEntity entity = (ContactEntity) dao.findByEmail(email);
			return entity;
		} else {
			System.out.println("email is invalid");
			return null;
		}

	}

	@Override
	public List<ContactEntity> getall() {
		System.out.println("invoked list of object in ContactService");
		List<ContactEntity> entity = (List<ContactEntity>) dao.findAll();
		return entity;

	}

}
