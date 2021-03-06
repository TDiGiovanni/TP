/*
 * generated by Xtext 2.19.0
 */
grammar InternalMixin;

options {
	superClass=AbstractInternalContentAssistParser;
}

@lexer::header {
package mixin.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package mixin.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import mixin.services.MixinGrammarAccess;

}
@parser::members {
	private MixinGrammarAccess grammarAccess;

	public void setGrammarAccess(MixinGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}

	@Override
	protected Grammar getGrammar() {
		return grammarAccess.getGrammar();
	}

	@Override
	protected String getValueForTokenName(String tokenName) {
		return tokenName;
	}
}

// Entry rule entryRuleModel
entryRuleModel
:
{ before(grammarAccess.getModelRule()); }
	 ruleModel
{ after(grammarAccess.getModelRule()); } 
	 EOF 
;

// Rule Model
ruleModel 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getModelAccess().getInstructionsAssignment()); }
		(rule__Model__InstructionsAssignment)*
		{ after(grammarAccess.getModelAccess().getInstructionsAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleInstruction
entryRuleInstruction
:
{ before(grammarAccess.getInstructionRule()); }
	 ruleInstruction
{ after(grammarAccess.getInstructionRule()); } 
	 EOF 
;

// Rule Instruction
ruleInstruction 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getInstructionAccess().getAlternatives()); }
		(rule__Instruction__Alternatives)
		{ after(grammarAccess.getInstructionAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleMove
entryRuleMove
:
{ before(grammarAccess.getMoveRule()); }
	 ruleMove
{ after(grammarAccess.getMoveRule()); } 
	 EOF 
;

// Rule Move
ruleMove 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getMoveAccess().getGroup()); }
		(rule__Move__Group__0)
		{ after(grammarAccess.getMoveAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleClean
entryRuleClean
:
{ before(grammarAccess.getCleanRule()); }
	 ruleClean
{ after(grammarAccess.getCleanRule()); } 
	 EOF 
;

// Rule Clean
ruleClean 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getCleanAccess().getGroup()); }
		(rule__Clean__Group__0)
		{ after(grammarAccess.getCleanAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Instruction__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getInstructionAccess().getMoveParserRuleCall_0()); }
		ruleMove
		{ after(grammarAccess.getInstructionAccess().getMoveParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getInstructionAccess().getCleanParserRuleCall_1()); }
		ruleClean
		{ after(grammarAccess.getInstructionAccess().getCleanParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Move__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Move__Group__0__Impl
	rule__Move__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Move__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMoveAccess().getMoveKeyword_0()); }
	'move'
	{ after(grammarAccess.getMoveAccess().getMoveKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Move__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Move__Group__1__Impl
	rule__Move__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Move__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMoveAccess().getQuantityAssignment_1()); }
	(rule__Move__QuantityAssignment_1)
	{ after(grammarAccess.getMoveAccess().getQuantityAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Move__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Move__Group__2__Impl
	rule__Move__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Move__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMoveAccess().getMLKeyword_2()); }
	'mL'
	{ after(grammarAccess.getMoveAccess().getMLKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Move__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Move__Group__3__Impl
	rule__Move__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Move__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMoveAccess().getFromKeyword_3()); }
	'from'
	{ after(grammarAccess.getMoveAccess().getFromKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Move__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Move__Group__4__Impl
	rule__Move__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Move__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMoveAccess().getCupKeyword_4()); }
	'cup'
	{ after(grammarAccess.getMoveAccess().getCupKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Move__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Move__Group__5__Impl
	rule__Move__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__Move__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMoveAccess().getSourceCupAssignment_5()); }
	(rule__Move__SourceCupAssignment_5)
	{ after(grammarAccess.getMoveAccess().getSourceCupAssignment_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Move__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Move__Group__6__Impl
	rule__Move__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__Move__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMoveAccess().getToKeyword_6()); }
	'to'
	{ after(grammarAccess.getMoveAccess().getToKeyword_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Move__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Move__Group__7__Impl
	rule__Move__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__Move__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMoveAccess().getCupKeyword_7()); }
	'cup'
	{ after(grammarAccess.getMoveAccess().getCupKeyword_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Move__Group__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Move__Group__8__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Move__Group__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMoveAccess().getDestinationCupAssignment_8()); }
	(rule__Move__DestinationCupAssignment_8)
	{ after(grammarAccess.getMoveAccess().getDestinationCupAssignment_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Clean__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Clean__Group__0__Impl
	rule__Clean__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Clean__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCleanAccess().getCleanAction_0()); }
	()
	{ after(grammarAccess.getCleanAccess().getCleanAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Clean__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Clean__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Clean__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCleanAccess().getCleanKeyword_1()); }
	'clean'
	{ after(grammarAccess.getCleanAccess().getCleanKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Model__InstructionsAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getModelAccess().getInstructionsInstructionParserRuleCall_0()); }
		ruleInstruction
		{ after(grammarAccess.getModelAccess().getInstructionsInstructionParserRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Move__QuantityAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMoveAccess().getQuantityINTTerminalRuleCall_1_0()); }
		RULE_INT
		{ after(grammarAccess.getMoveAccess().getQuantityINTTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Move__SourceCupAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMoveAccess().getSourceCupINTTerminalRuleCall_5_0()); }
		RULE_INT
		{ after(grammarAccess.getMoveAccess().getSourceCupINTTerminalRuleCall_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Move__DestinationCupAssignment_8
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMoveAccess().getDestinationCupINTTerminalRuleCall_8_0()); }
		RULE_INT
		{ after(grammarAccess.getMoveAccess().getDestinationCupINTTerminalRuleCall_8_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
