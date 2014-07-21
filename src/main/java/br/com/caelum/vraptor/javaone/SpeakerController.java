package br.com.caelum.vraptor.javaone;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.javaone.dao.SpeakerDao;
import br.com.caelum.vraptor.javaone.model.Speaker;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Controller
public class SpeakerController {

	@Inject
	private SpeakerDao speakerDao;

	@Inject
	private Result result;

	@Get("/add")
	public void add() {
	}

	@Post("/add")
	public void add(Speaker speaker) {
		speakerDao.save(speaker);
		result.redirectTo(this).list();
	}

	public void list() {
		result.include("speakers", speakerDao.list());
	}

}
