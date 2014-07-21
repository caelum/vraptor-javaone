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
}
