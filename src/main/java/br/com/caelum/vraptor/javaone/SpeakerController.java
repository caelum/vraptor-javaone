package br.com.caelum.vraptor.javaone;
import javax.annotation.Resource;
import javax.ejb.ScheduleExpression;
import javax.ejb.TimerService;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.javaone.cron.SpeakerScheduler;
import br.com.caelum.vraptor.javaone.dao.SpeakerDao;
import br.com.caelum.vraptor.javaone.model.Speaker;

@Controller
public class SpeakerController {

	@Inject
	private SpeakerDao speakerDao;

	@Inject
	private Result result;

	@Inject
	private SpeakerScheduler speakerScheduler;

	@Get("/add")
	public void add() {
	}

	@Transactional
	@Post("/add")
	public void add(Speaker speaker) {
		speakerDao.save(speaker);
		speakerScheduler.schedule();
		result.redirectTo(this).list();
	}

	public void list() {
		result.include("speakers", speakerDao.list());
	}

}
