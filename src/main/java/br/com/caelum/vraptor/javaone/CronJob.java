package br.com.caelum.vraptor.javaone;

import javax.ejb.Schedule;
import javax.ejb.Stateless;

@Stateless
public class CronJob {
	@Schedule(minute = "*", hour = "*")
	public void log() {
		System.out.println("executing job");
	}
}
