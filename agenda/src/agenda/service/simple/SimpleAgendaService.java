package agenda.service.simple;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import agenda.api.Agenda;
import agenda.api.Conference;

public class SimpleAgendaService implements Agenda{

	private final List<Conference> conferences = new CopyOnWriteArrayList<>();

	public void start() {
		System.out.println("Incremental update test");
		
		conferences.add(new Conference("OSGi Devcon", "Boston"));
		conferences.add(new Conference("JavaOne RU", "Mowcow"));
		conferences.add(new Conference("JavaOne US", "San Fransisco"));
		conferences.add(new Conference("Devoxx", "Antwerp"));
	}
	
	@Override
	public List<Conference> listConferences() {
		return conferences;
	}

	@Override
	public void addConference(Conference conference) {
		conferences.add(conference);
	}
	
}
