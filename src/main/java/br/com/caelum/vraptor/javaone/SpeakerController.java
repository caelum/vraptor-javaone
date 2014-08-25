package br.com.caelum.vraptor.javaone;
import javax.annotation.Resource;
import javax.ejb.ScheduleExpression;
import javax.ejb.TimerService;
import javax.inject.Inject;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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

	@Resource(mappedName = "java:/smtp/gmail")
	private Session mySession;

	@Get("/add")
	public void add() {
	}

	@Transactional
	@Post("/add")
	public void add(Speaker speaker) throws MessagingException {
		speakerDao.save(speaker);
		speakerScheduler.schedule();
		result.redirectTo(this).list();

		Message message = new MimeMessage(mySession);
		message.setFrom(new InternetAddress("admin@caelum.com.br"));
		Address toAddress = new InternetAddress(speaker.getEmail());
		message.addRecipient(Message.RecipientType.TO, toAddress);
		message.setSubject("Welcome!");
		message.setContent("Hello, speaker!" , "text/plain");
		Transport.send(message);

	}

	public void list() {
		result.include("speakers", speakerDao.list());
	}

}
