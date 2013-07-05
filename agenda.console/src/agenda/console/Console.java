package agenda.console;

import java.util.List;

import agenda.api.Agenda;
import agenda.api.Conference;

public class Console {
	private volatile Agenda agenda;

	public void lc() {
		List<Conference> conferences = agenda.listConferences();
		if (conferences != null) {
			for (Conference conference : conferences) {
				System.out.println(conference);
			}
		} else {
			System.out.println("Agenda not available");
		}

	}

	public void ac(String name, String location) {
		agenda.addConference(new Conference(name, location));
	}
}
