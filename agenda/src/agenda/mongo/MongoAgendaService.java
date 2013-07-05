package agenda.mongo;

import java.util.ArrayList;
import java.util.List;

import net.vz.mongodb.jackson.DBCursor;
import net.vz.mongodb.jackson.JacksonDBCollection;

import org.amdatu.mongo.MongoDBService;

import com.mongodb.DBCollection;

import agenda.api.Agenda;
import agenda.api.Conference;

public class MongoAgendaService implements Agenda{

	private volatile MongoDBService mongoDBService;
	
	@Override
	public List<Conference> listConferences() {
		
		DBCollection collection = mongoDBService.getDB().getCollection("conferences");
		JacksonDBCollection<Conference, Object> conferences = JacksonDBCollection.wrap(collection, Conference.class);
		
		DBCursor<Conference> cursor = conferences.find();
		List<Conference> result = new ArrayList<>();
		
		while(cursor.hasNext()) {
			result.add(cursor.next());
		}
		
		return result;
	}

	@Override
	public void addConference(Conference conference) {
		DBCollection collection = mongoDBService.getDB().getCollection("conferences");
		JacksonDBCollection<Conference, Object> conferences = JacksonDBCollection.wrap(collection, Conference.class);
		
		conferences.save(conference);
	}

}
