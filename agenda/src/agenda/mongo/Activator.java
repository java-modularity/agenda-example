package agenda.mongo;

import java.util.Properties;

import org.amdatu.mongo.MongoDBService;
import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;

import agenda.api.Agenda;

public class Activator extends DependencyActivatorBase {

	@Override
	public void destroy(BundleContext arg0, DependencyManager arg1)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(BundleContext arg0, DependencyManager dm) throws Exception {
		Properties props = new Properties();
		props.put(Constants.SERVICE_RANKING, 10);
		
		dm.add(createComponent()
				.setInterface(Agenda.class.getName(), props)
				.setImplementation(MongoAgendaService.class)
				.add(createServiceDependency().setService(MongoDBService.class)
						.setRequired(true)));
	}
}
