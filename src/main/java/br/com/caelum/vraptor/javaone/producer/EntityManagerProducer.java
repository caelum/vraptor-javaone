package br.com.caelum.vraptor.javaone.producer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@RequestScoped
public class EntityManagerProducer {

	@Inject
	private EntityManagerFactory emf;

	@Produces
	public EntityManager produce() {
		return this.emf.createEntityManager();
	}

	public void dispose(@Disposes EntityManager em) {
		em.close();
	}

}
