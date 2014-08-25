package br.com.caelum.vraptor.javaone.cron;

import javax.annotation.Resource;
import javax.ejb.*;

@Stateless
public class SpeakerScheduler {
	@Resource
	private TimerService timerService;

	public void schedule() {
		ScheduleExpression expression = new ScheduleExpression();
		expression.year(2014).month("Aug").dayOfMonth("*").hour("*").minute("*");
		timerService.createCalendarTimer(expression);
	}

	@Timeout
	public void execute(Timer timer) {
		System.out.println("executando...");
	}
}
