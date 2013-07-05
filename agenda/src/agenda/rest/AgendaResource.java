package agenda.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.amdatu.web.rest.doc.Description;

import agenda.api.Agenda;
import agenda.api.Conference;

@Path("conferences")
public class AgendaResource {
	
	private volatile Agenda agenda;
	
	@GET
	@Produces("application/json")
	@Description("lists conferences")
	public List<Conference> list() {
		return agenda.listConferences();
	}
	
}
