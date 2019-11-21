/*
 * generated by Xtext 2.19.0
 */
package mixin.ide

import com.google.inject.Guice
import mixin.MixinRuntimeModule
import mixin.MixinStandaloneSetup
import org.eclipse.xtext.util.Modules2

/**
 * Initialization support for running Xtext languages as language servers.
 */
class MixinIdeSetup extends MixinStandaloneSetup {

	override createInjector() {
		Guice.createInjector(Modules2.mixin(new MixinRuntimeModule, new MixinIdeModule))
	}
	
}