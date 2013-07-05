package agenda.console;

import java.util.Properties;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.apache.felix.service.command.CommandProcessor;
import org.osgi.framework.BundleContext;

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
		props.put(CommandProcessor.COMMAND_SCOPE, "agenda");
		props.put(CommandProcessor.COMMAND_FUNCTION, new String[] {"lc", "ac"});
		
		
		dm.add(createComponent().setInterface(Object.class.getName(), props)
				.setImplementation(Console.class).add(createServiceDependency().setService(Agenda.class).setRequired(false)));
	}

}
