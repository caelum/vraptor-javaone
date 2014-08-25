package br.com.caelum.vraptor.javaone.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Speaker {

	private String email;
	private String name;

	@Id @GeneratedValue
	private Long id;

	//getters and setters or constructor


	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
