package impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class HelloerActivator implements BundleActivator
{
	protected Helloer helloer = new Helloer();
	
	@Override
	public void start(BundleContext context) throws Exception
	{
		helloer.sayHello();
	}
	
	@Override
	public void stop(BundleContext context) throws Exception
	{
		helloer.sayGoodbye();
	}
}
