package com.xworkz.servletHibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NamedQueries({ @NamedQuery(name="findByName", query = "select contactEntity from ContactEntity contactEntity where contactEntity.name=:nm"),
	            @NamedQuery(name="findByEmail", query = "select contactEntity from ContactEntity contactEntity where contactEntity.email=:email"),
	            @NamedQuery(name="findAll", query = "select contactEntity from ContactEntity contactEntity")})
@Table(name="contact_details")
public class ContactEntity {
	@Id
	@GenericGenerator(name="auto", strategy = "increment")
	@GeneratedValue(generator="auto")
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="EMAIL")
	private String email;
	@Column(name="PHONE_NO")
	private String phoneno;
	@Column(name="ABOUTURSELF")
	private String abouturself;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getAbouturself() {
		return abouturself;
	}
	public void setAbouturself(String abouturself) {
		this.abouturself = abouturself;
	}
	
	@Override
	public String toString() {
		return "ContactEntity [id=" + id + ", name=" + name + ", email=" + email + ", phoneno=" + phoneno
				+ ", abouturself=" + abouturself + "]";
	}
	public ContactEntity(String name, String email, String phoneno, String abouturself) {
		super();
		this.name = name;
		this.email = email;
		this.phoneno = phoneno;
		this.abouturself = abouturself;
	}
	public ContactEntity() {
		System.out.println("created contactentity constructor");
	}
	
}
