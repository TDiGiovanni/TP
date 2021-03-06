/*
 * generated by Xtext 2.19.0
 */
package mixin.ui;

import com.google.inject.Injector;
import mixin.ui.internal.MixinActivator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class MixinExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return Platform.getBundle(MixinActivator.PLUGIN_ID);
	}
	
	@Override
	protected Injector getInjector() {
		MixinActivator activator = MixinActivator.getInstance();
		return activator != null ? activator.getInjector(MixinActivator.MIXIN_MIXIN) : null;
	}

}
