package br.com.caelum.vraptor.javaone.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerFactoryProducer {

	@Produces
	public EntityManagerFactory produce() {
		return Persistence
				.createEntityManagerFactory("default");
	}

	public void dispose(@Disposes EntityManagerFactory emf) {
		emf.close();
	}
}
