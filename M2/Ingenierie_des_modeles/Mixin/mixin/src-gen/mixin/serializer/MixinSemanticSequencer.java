/*
 * generated by Xtext 2.19.0
 */
package mixin.serializer;

import com.google.inject.Inject;
import java.util.Set;
import mixin.mixin.Clean;
import mixin.mixin.MixinPackage;
import mixin.mixin.Model;
import mixin.mixin.Move;
import mixin.services.MixinGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class MixinSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private MixinGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == MixinPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case MixinPackage.CLEAN:
				sequence_Clean(context, (Clean) semanticObject); 
				return; 
			case MixinPackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			case MixinPackage.MOVE:
				sequence_Move(context, (Move) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     Instruction returns Clean
	 *     Clean returns Clean
	 *
	 * Constraint:
	 *     {Clean}
	 */
	protected void sequence_Clean(ISerializationContext context, Clean semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Model returns Model
	 *
	 * Constraint:
	 *     instructions+=Instruction+
	 */
	protected void sequence_Model(ISerializationContext context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Instruction returns Move
	 *     Move returns Move
	 *
	 * Constraint:
	 *     (quantity=INT sourceCup=INT destinationCup=INT)
	 */
	protected void sequence_Move(ISerializationContext context, Move semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MixinPackage.Literals.MOVE__QUANTITY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MixinPackage.Literals.MOVE__QUANTITY));
			if (transientValues.isValueTransient(semanticObject, MixinPackage.Literals.MOVE__SOURCE_CUP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MixinPackage.Literals.MOVE__SOURCE_CUP));
			if (transientValues.isValueTransient(semanticObject, MixinPackage.Literals.MOVE__DESTINATION_CUP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MixinPackage.Literals.MOVE__DESTINATION_CUP));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getMoveAccess().getQuantityINTTerminalRuleCall_1_0(), semanticObject.getQuantity());
		feeder.accept(grammarAccess.getMoveAccess().getSourceCupINTTerminalRuleCall_5_0(), semanticObject.getSourceCup());
		feeder.accept(grammarAccess.getMoveAccess().getDestinationCupINTTerminalRuleCall_8_0(), semanticObject.getDestinationCup());
		feeder.finish();
	}
	
	
}
