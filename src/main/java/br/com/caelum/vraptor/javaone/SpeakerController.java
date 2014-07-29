package br.com.caelum.vraptor.javaone;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.javaone.dao.SpeakerDao;
import br.com.caelum.vraptor.javaone.model.Speaker;

@Controller
public class SpeakerController {

	@Inject
	private SpeakerDao speakerDao;

	@Inject
	private Result result;

	@Get("/add")
	public void add() {
	}

	@Transactional
	@Post("/add")
	public void add(Speaker speaker) {
		speakerDao.save(speaker);
		result.redirectTo(this).list();
	}

	public void list() {
		result.include("speakers", speakerDao.list());
	}

}
