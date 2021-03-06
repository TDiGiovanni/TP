/*
 * generated by Xtext 2.19.0
 */
grammar InternalMixin;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package mixin.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package mixin.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import mixin.services.MixinGrammarAccess;

}

@parser::members {

 	private MixinGrammarAccess grammarAccess;

    public InternalMixinParser(TokenStream input, MixinGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "Model";
   	}

   	@Override
   	protected MixinGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleModel
entryRuleModel returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getModelRule()); }
	iv_ruleModel=ruleModel
	{ $current=$iv_ruleModel.current; }
	EOF;

// Rule Model
ruleModel returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getModelAccess().getInstructionsInstructionParserRuleCall_0());
			}
			lv_instructions_0_0=ruleInstruction
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getModelRule());
				}
				add(
					$current,
					"instructions",
					lv_instructions_0_0,
					"mixin.Mixin.Instruction");
				afterParserOrEnumRuleCall();
			}
		)
	)*
;

// Entry rule entryRuleInstruction
entryRuleInstruction returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getInstructionRule()); }
	iv_ruleInstruction=ruleInstruction
	{ $current=$iv_ruleInstruction.current; }
	EOF;

// Rule Instruction
ruleInstruction returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getInstructionAccess().getMoveParserRuleCall_0());
		}
		this_Move_0=ruleMove
		{
			$current = $this_Move_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getInstructionAccess().getCleanParserRuleCall_1());
		}
		this_Clean_1=ruleClean
		{
			$current = $this_Clean_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleMove
entryRuleMove returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMoveRule()); }
	iv_ruleMove=ruleMove
	{ $current=$iv_ruleMove.current; }
	EOF;

// Rule Move
ruleMove returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='move'
		{
			newLeafNode(otherlv_0, grammarAccess.getMoveAccess().getMoveKeyword_0());
		}
		(
			(
				lv_quantity_1_0=RULE_INT
				{
					newLeafNode(lv_quantity_1_0, grammarAccess.getMoveAccess().getQuantityINTTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getMoveRule());
					}
					setWithLastConsumed(
						$current,
						"quantity",
						lv_quantity_1_0,
						"org.eclipse.xtext.common.Terminals.INT");
				}
			)
		)
		otherlv_2='mL'
		{
			newLeafNode(otherlv_2, grammarAccess.getMoveAccess().getMLKeyword_2());
		}
		otherlv_3='from'
		{
			newLeafNode(otherlv_3, grammarAccess.getMoveAccess().getFromKeyword_3());
		}
		otherlv_4='cup'
		{
			newLeafNode(otherlv_4, grammarAccess.getMoveAccess().getCupKeyword_4());
		}
		(
			(
				lv_sourceCup_5_0=RULE_INT
				{
					newLeafNode(lv_sourceCup_5_0, grammarAccess.getMoveAccess().getSourceCupINTTerminalRuleCall_5_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getMoveRule());
					}
					setWithLastConsumed(
						$current,
						"sourceCup",
						lv_sourceCup_5_0,
						"org.eclipse.xtext.common.Terminals.INT");
				}
			)
		)
		otherlv_6='to'
		{
			newLeafNode(otherlv_6, grammarAccess.getMoveAccess().getToKeyword_6());
		}
		otherlv_7='cup'
		{
			newLeafNode(otherlv_7, grammarAccess.getMoveAccess().getCupKeyword_7());
		}
		(
			(
				lv_destinationCup_8_0=RULE_INT
				{
					newLeafNode(lv_destinationCup_8_0, grammarAccess.getMoveAccess().getDestinationCupINTTerminalRuleCall_8_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getMoveRule());
					}
					setWithLastConsumed(
						$current,
						"destinationCup",
						lv_destinationCup_8_0,
						"org.eclipse.xtext.common.Terminals.INT");
				}
			)
		)
	)
;

// Entry rule entryRuleClean
entryRuleClean returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getCleanRule()); }
	iv_ruleClean=ruleClean
	{ $current=$iv_ruleClean.current; }
	EOF;

// Rule Clean
ruleClean returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getCleanAccess().getCleanAction_0(),
					$current);
			}
		)
		otherlv_1='clean'
		{
			newLeafNode(otherlv_1, grammarAccess.getCleanAccess().getCleanKeyword_1());
		}
	)
;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
