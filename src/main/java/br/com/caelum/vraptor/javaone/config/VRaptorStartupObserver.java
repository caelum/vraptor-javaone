package br.com.caelum.vraptor.javaone.config;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import br.com.caelum.vraptor.events.VRaptorInitialized;

@ApplicationScoped
public class VRaptorStartupObserver {
	
	public void init(@Observes VRaptorInitialized event) {
		// send an email here?
	}
}
