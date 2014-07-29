package br.com.caelum.vraptor.javaone.config;

import javax.enterprise.inject.Specializes;
import javax.inject.Inject;

import br.com.caelum.vraptor.http.FormatResolver;
import br.com.caelum.vraptor.view.DefaultPathResolver;

@Specializes
public class MyPathResolver extends DefaultPathResolver {

	@Inject
	public MyPathResolver(FormatResolver resolver) {
		super(resolver);
	}
	
	@Override
	protected String getPrefix() {
		return "/WEB-INF/pages/";
	}
}
