package de.acegen.generator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import de.acegen.generator.java.JavaGenerator;

public class Activator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		AceGenGenerator.register("JAVA", new JavaGenerator());
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		AceGenGenerator.unregister("JAVA");
	}

}
