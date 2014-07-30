package br.com.caelum.vraptor.javaone.interceptor;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

@Interceptor @UsingTransaction
public class TransactionalInterceptor {

	@Inject private EntityManager em;
	
	@AroundInvoke
	public Object intercept(InvocationContext context) throws Exception {
		em.getTransaction().begin();
		Object proceed = context.proceed();
		em.getTransaction().commit();
		return proceed;
	}
}
