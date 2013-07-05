package agenda.api;

import java.util.List;

public interface Agenda {
	List<Conference> listConferences();
	void addConference(Conference conference);
}
