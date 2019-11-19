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



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMixinParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'move'", "'mL'", "'from'", "'cup'", "'to'", "'clean'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int RULE_INT=4;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalMixinParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMixinParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMixinParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMixin.g"; }


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



    // $ANTLR start "entryRuleModel"
    // InternalMixin.g:53:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalMixin.g:54:1: ( ruleModel EOF )
            // InternalMixin.g:55:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalMixin.g:62:1: ruleModel : ( ( rule__Model__InstructionsAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:66:2: ( ( ( rule__Model__InstructionsAssignment )* ) )
            // InternalMixin.g:67:2: ( ( rule__Model__InstructionsAssignment )* )
            {
            // InternalMixin.g:67:2: ( ( rule__Model__InstructionsAssignment )* )
            // InternalMixin.g:68:3: ( rule__Model__InstructionsAssignment )*
            {
             before(grammarAccess.getModelAccess().getInstructionsAssignment()); 
            // InternalMixin.g:69:3: ( rule__Model__InstructionsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11||LA1_0==16) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMixin.g:69:4: rule__Model__InstructionsAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__Model__InstructionsAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getInstructionsAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleInstruction"
    // InternalMixin.g:78:1: entryRuleInstruction : ruleInstruction EOF ;
    public final void entryRuleInstruction() throws RecognitionException {
        try {
            // InternalMixin.g:79:1: ( ruleInstruction EOF )
            // InternalMixin.g:80:1: ruleInstruction EOF
            {
             before(grammarAccess.getInstructionRule()); 
            pushFollow(FOLLOW_1);
            ruleInstruction();

            state._fsp--;

             after(grammarAccess.getInstructionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleInstruction"


    // $ANTLR start "ruleInstruction"
    // InternalMixin.g:87:1: ruleInstruction : ( ( rule__Instruction__Alternatives ) ) ;
    public final void ruleInstruction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:91:2: ( ( ( rule__Instruction__Alternatives ) ) )
            // InternalMixin.g:92:2: ( ( rule__Instruction__Alternatives ) )
            {
            // InternalMixin.g:92:2: ( ( rule__Instruction__Alternatives ) )
            // InternalMixin.g:93:3: ( rule__Instruction__Alternatives )
            {
             before(grammarAccess.getInstructionAccess().getAlternatives()); 
            // InternalMixin.g:94:3: ( rule__Instruction__Alternatives )
            // InternalMixin.g:94:4: rule__Instruction__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Instruction__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getInstructionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInstruction"


    // $ANTLR start "entryRuleMove"
    // InternalMixin.g:103:1: entryRuleMove : ruleMove EOF ;
    public final void entryRuleMove() throws RecognitionException {
        try {
            // InternalMixin.g:104:1: ( ruleMove EOF )
            // InternalMixin.g:105:1: ruleMove EOF
            {
             before(grammarAccess.getMoveRule()); 
            pushFollow(FOLLOW_1);
            ruleMove();

            state._fsp--;

             after(grammarAccess.getMoveRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMove"


    // $ANTLR start "ruleMove"
    // InternalMixin.g:112:1: ruleMove : ( ( rule__Move__Group__0 ) ) ;
    public final void ruleMove() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:116:2: ( ( ( rule__Move__Group__0 ) ) )
            // InternalMixin.g:117:2: ( ( rule__Move__Group__0 ) )
            {
            // InternalMixin.g:117:2: ( ( rule__Move__Group__0 ) )
            // InternalMixin.g:118:3: ( rule__Move__Group__0 )
            {
             before(grammarAccess.getMoveAccess().getGroup()); 
            // InternalMixin.g:119:3: ( rule__Move__Group__0 )
            // InternalMixin.g:119:4: rule__Move__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Move__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMoveAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMove"


    // $ANTLR start "entryRuleClean"
    // InternalMixin.g:128:1: entryRuleClean : ruleClean EOF ;
    public final void entryRuleClean() throws RecognitionException {
        try {
            // InternalMixin.g:129:1: ( ruleClean EOF )
            // InternalMixin.g:130:1: ruleClean EOF
            {
             before(grammarAccess.getCleanRule()); 
            pushFollow(FOLLOW_1);
            ruleClean();

            state._fsp--;

             after(grammarAccess.getCleanRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleClean"


    // $ANTLR start "ruleClean"
    // InternalMixin.g:137:1: ruleClean : ( ( rule__Clean__Group__0 ) ) ;
    public final void ruleClean() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:141:2: ( ( ( rule__Clean__Group__0 ) ) )
            // InternalMixin.g:142:2: ( ( rule__Clean__Group__0 ) )
            {
            // InternalMixin.g:142:2: ( ( rule__Clean__Group__0 ) )
            // InternalMixin.g:143:3: ( rule__Clean__Group__0 )
            {
             before(grammarAccess.getCleanAccess().getGroup()); 
            // InternalMixin.g:144:3: ( rule__Clean__Group__0 )
            // InternalMixin.g:144:4: rule__Clean__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Clean__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCleanAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleClean"


    // $ANTLR start "rule__Instruction__Alternatives"
    // InternalMixin.g:152:1: rule__Instruction__Alternatives : ( ( ruleMove ) | ( ruleClean ) );
    public final void rule__Instruction__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:156:1: ( ( ruleMove ) | ( ruleClean ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            else if ( (LA2_0==16) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalMixin.g:157:2: ( ruleMove )
                    {
                    // InternalMixin.g:157:2: ( ruleMove )
                    // InternalMixin.g:158:3: ruleMove
                    {
                     before(grammarAccess.getInstructionAccess().getMoveParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleMove();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getMoveParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMixin.g:163:2: ( ruleClean )
                    {
                    // InternalMixin.g:163:2: ( ruleClean )
                    // InternalMixin.g:164:3: ruleClean
                    {
                     before(grammarAccess.getInstructionAccess().getCleanParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleClean();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getCleanParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Alternatives"


    // $ANTLR start "rule__Move__Group__0"
    // InternalMixin.g:173:1: rule__Move__Group__0 : rule__Move__Group__0__Impl rule__Move__Group__1 ;
    public final void rule__Move__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:177:1: ( rule__Move__Group__0__Impl rule__Move__Group__1 )
            // InternalMixin.g:178:2: rule__Move__Group__0__Impl rule__Move__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Move__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Move__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Move__Group__0"


    // $ANTLR start "rule__Move__Group__0__Impl"
    // InternalMixin.g:185:1: rule__Move__Group__0__Impl : ( 'move' ) ;
    public final void rule__Move__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:189:1: ( ( 'move' ) )
            // InternalMixin.g:190:1: ( 'move' )
            {
            // InternalMixin.g:190:1: ( 'move' )
            // InternalMixin.g:191:2: 'move'
            {
             before(grammarAccess.getMoveAccess().getMoveKeyword_0()); 
            match(input,11,FOLLOW_2); 
             after(grammarAccess.getMoveAccess().getMoveKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Move__Group__0__Impl"


    // $ANTLR start "rule__Move__Group__1"
    // InternalMixin.g:200:1: rule__Move__Group__1 : rule__Move__Group__1__Impl rule__Move__Group__2 ;
    public final void rule__Move__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:204:1: ( rule__Move__Group__1__Impl rule__Move__Group__2 )
            // InternalMixin.g:205:2: rule__Move__Group__1__Impl rule__Move__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Move__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Move__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Move__Group__1"


    // $ANTLR start "rule__Move__Group__1__Impl"
    // InternalMixin.g:212:1: rule__Move__Group__1__Impl : ( ( rule__Move__QuantityAssignment_1 ) ) ;
    public final void rule__Move__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:216:1: ( ( ( rule__Move__QuantityAssignment_1 ) ) )
            // InternalMixin.g:217:1: ( ( rule__Move__QuantityAssignment_1 ) )
            {
            // InternalMixin.g:217:1: ( ( rule__Move__QuantityAssignment_1 ) )
            // InternalMixin.g:218:2: ( rule__Move__QuantityAssignment_1 )
            {
             before(grammarAccess.getMoveAccess().getQuantityAssignment_1()); 
            // InternalMixin.g:219:2: ( rule__Move__QuantityAssignment_1 )
            // InternalMixin.g:219:3: rule__Move__QuantityAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Move__QuantityAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getMoveAccess().getQuantityAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Move__Group__1__Impl"


    // $ANTLR start "rule__Move__Group__2"
    // InternalMixin.g:227:1: rule__Move__Group__2 : rule__Move__Group__2__Impl rule__Move__Group__3 ;
    public final void rule__Move__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:231:1: ( rule__Move__Group__2__Impl rule__Move__Group__3 )
            // InternalMixin.g:232:2: rule__Move__Group__2__Impl rule__Move__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__Move__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Move__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Move__Group__2"


    // $ANTLR start "rule__Move__Group__2__Impl"
    // InternalMixin.g:239:1: rule__Move__Group__2__Impl : ( 'mL' ) ;
    public final void rule__Move__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:243:1: ( ( 'mL' ) )
            // InternalMixin.g:244:1: ( 'mL' )
            {
            // InternalMixin.g:244:1: ( 'mL' )
            // InternalMixin.g:245:2: 'mL'
            {
             before(grammarAccess.getMoveAccess().getMLKeyword_2()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getMoveAccess().getMLKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Move__Group__2__Impl"


    // $ANTLR start "rule__Move__Group__3"
    // InternalMixin.g:254:1: rule__Move__Group__3 : rule__Move__Group__3__Impl rule__Move__Group__4 ;
    public final void rule__Move__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:258:1: ( rule__Move__Group__3__Impl rule__Move__Group__4 )
            // InternalMixin.g:259:2: rule__Move__Group__3__Impl rule__Move__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__Move__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Move__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Move__Group__3"


    // $ANTLR start "rule__Move__Group__3__Impl"
    // InternalMixin.g:266:1: rule__Move__Group__3__Impl : ( 'from' ) ;
    public final void rule__Move__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:270:1: ( ( 'from' ) )
            // InternalMixin.g:271:1: ( 'from' )
            {
            // InternalMixin.g:271:1: ( 'from' )
            // InternalMixin.g:272:2: 'from'
            {
             before(grammarAccess.getMoveAccess().getFromKeyword_3()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getMoveAccess().getFromKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Move__Group__3__Impl"


    // $ANTLR start "rule__Move__Group__4"
    // InternalMixin.g:281:1: rule__Move__Group__4 : rule__Move__Group__4__Impl rule__Move__Group__5 ;
    public final void rule__Move__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:285:1: ( rule__Move__Group__4__Impl rule__Move__Group__5 )
            // InternalMixin.g:286:2: rule__Move__Group__4__Impl rule__Move__Group__5
            {
            pushFollow(FOLLOW_4);
            rule__Move__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Move__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Move__Group__4"


    // $ANTLR start "rule__Move__Group__4__Impl"
    // InternalMixin.g:293:1: rule__Move__Group__4__Impl : ( 'cup' ) ;
    public final void rule__Move__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:297:1: ( ( 'cup' ) )
            // InternalMixin.g:298:1: ( 'cup' )
            {
            // InternalMixin.g:298:1: ( 'cup' )
            // InternalMixin.g:299:2: 'cup'
            {
             before(grammarAccess.getMoveAccess().getCupKeyword_4()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getMoveAccess().getCupKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Move__Group__4__Impl"


    // $ANTLR start "rule__Move__Group__5"
    // InternalMixin.g:308:1: rule__Move__Group__5 : rule__Move__Group__5__Impl rule__Move__Group__6 ;
    public final void rule__Move__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:312:1: ( rule__Move__Group__5__Impl rule__Move__Group__6 )
            // InternalMixin.g:313:2: rule__Move__Group__5__Impl rule__Move__Group__6
            {
            pushFollow(FOLLOW_8);
            rule__Move__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Move__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Move__Group__5"


    // $ANTLR start "rule__Move__Group__5__Impl"
    // InternalMixin.g:320:1: rule__Move__Group__5__Impl : ( ( rule__Move__SourceCupAssignment_5 ) ) ;
    public final void rule__Move__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:324:1: ( ( ( rule__Move__SourceCupAssignment_5 ) ) )
            // InternalMixin.g:325:1: ( ( rule__Move__SourceCupAssignment_5 ) )
            {
            // InternalMixin.g:325:1: ( ( rule__Move__SourceCupAssignment_5 ) )
            // InternalMixin.g:326:2: ( rule__Move__SourceCupAssignment_5 )
            {
             before(grammarAccess.getMoveAccess().getSourceCupAssignment_5()); 
            // InternalMixin.g:327:2: ( rule__Move__SourceCupAssignment_5 )
            // InternalMixin.g:327:3: rule__Move__SourceCupAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Move__SourceCupAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getMoveAccess().getSourceCupAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Move__Group__5__Impl"


    // $ANTLR start "rule__Move__Group__6"
    // InternalMixin.g:335:1: rule__Move__Group__6 : rule__Move__Group__6__Impl rule__Move__Group__7 ;
    public final void rule__Move__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:339:1: ( rule__Move__Group__6__Impl rule__Move__Group__7 )
            // InternalMixin.g:340:2: rule__Move__Group__6__Impl rule__Move__Group__7
            {
            pushFollow(FOLLOW_7);
            rule__Move__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Move__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Move__Group__6"


    // $ANTLR start "rule__Move__Group__6__Impl"
    // InternalMixin.g:347:1: rule__Move__Group__6__Impl : ( 'to' ) ;
    public final void rule__Move__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:351:1: ( ( 'to' ) )
            // InternalMixin.g:352:1: ( 'to' )
            {
            // InternalMixin.g:352:1: ( 'to' )
            // InternalMixin.g:353:2: 'to'
            {
             before(grammarAccess.getMoveAccess().getToKeyword_6()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getMoveAccess().getToKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Move__Group__6__Impl"


    // $ANTLR start "rule__Move__Group__7"
    // InternalMixin.g:362:1: rule__Move__Group__7 : rule__Move__Group__7__Impl rule__Move__Group__8 ;
    public final void rule__Move__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:366:1: ( rule__Move__Group__7__Impl rule__Move__Group__8 )
            // InternalMixin.g:367:2: rule__Move__Group__7__Impl rule__Move__Group__8
            {
            pushFollow(FOLLOW_4);
            rule__Move__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Move__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Move__Group__7"


    // $ANTLR start "rule__Move__Group__7__Impl"
    // InternalMixin.g:374:1: rule__Move__Group__7__Impl : ( 'cup' ) ;
    public final void rule__Move__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:378:1: ( ( 'cup' ) )
            // InternalMixin.g:379:1: ( 'cup' )
            {
            // InternalMixin.g:379:1: ( 'cup' )
            // InternalMixin.g:380:2: 'cup'
            {
             before(grammarAccess.getMoveAccess().getCupKeyword_7()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getMoveAccess().getCupKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Move__Group__7__Impl"


    // $ANTLR start "rule__Move__Group__8"
    // InternalMixin.g:389:1: rule__Move__Group__8 : rule__Move__Group__8__Impl ;
    public final void rule__Move__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:393:1: ( rule__Move__Group__8__Impl )
            // InternalMixin.g:394:2: rule__Move__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Move__Group__8__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Move__Group__8"


    // $ANTLR start "rule__Move__Group__8__Impl"
    // InternalMixin.g:400:1: rule__Move__Group__8__Impl : ( ( rule__Move__DestinationCupAssignment_8 ) ) ;
    public final void rule__Move__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:404:1: ( ( ( rule__Move__DestinationCupAssignment_8 ) ) )
            // InternalMixin.g:405:1: ( ( rule__Move__DestinationCupAssignment_8 ) )
            {
            // InternalMixin.g:405:1: ( ( rule__Move__DestinationCupAssignment_8 ) )
            // InternalMixin.g:406:2: ( rule__Move__DestinationCupAssignment_8 )
            {
             before(grammarAccess.getMoveAccess().getDestinationCupAssignment_8()); 
            // InternalMixin.g:407:2: ( rule__Move__DestinationCupAssignment_8 )
            // InternalMixin.g:407:3: rule__Move__DestinationCupAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__Move__DestinationCupAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getMoveAccess().getDestinationCupAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Move__Group__8__Impl"


    // $ANTLR start "rule__Clean__Group__0"
    // InternalMixin.g:416:1: rule__Clean__Group__0 : rule__Clean__Group__0__Impl rule__Clean__Group__1 ;
    public final void rule__Clean__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:420:1: ( rule__Clean__Group__0__Impl rule__Clean__Group__1 )
            // InternalMixin.g:421:2: rule__Clean__Group__0__Impl rule__Clean__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__Clean__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Clean__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clean__Group__0"


    // $ANTLR start "rule__Clean__Group__0__Impl"
    // InternalMixin.g:428:1: rule__Clean__Group__0__Impl : ( () ) ;
    public final void rule__Clean__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:432:1: ( ( () ) )
            // InternalMixin.g:433:1: ( () )
            {
            // InternalMixin.g:433:1: ( () )
            // InternalMixin.g:434:2: ()
            {
             before(grammarAccess.getCleanAccess().getCleanAction_0()); 
            // InternalMixin.g:435:2: ()
            // InternalMixin.g:435:3: 
            {
            }

             after(grammarAccess.getCleanAccess().getCleanAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clean__Group__0__Impl"


    // $ANTLR start "rule__Clean__Group__1"
    // InternalMixin.g:443:1: rule__Clean__Group__1 : rule__Clean__Group__1__Impl ;
    public final void rule__Clean__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:447:1: ( rule__Clean__Group__1__Impl )
            // InternalMixin.g:448:2: rule__Clean__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Clean__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clean__Group__1"


    // $ANTLR start "rule__Clean__Group__1__Impl"
    // InternalMixin.g:454:1: rule__Clean__Group__1__Impl : ( 'clean' ) ;
    public final void rule__Clean__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:458:1: ( ( 'clean' ) )
            // InternalMixin.g:459:1: ( 'clean' )
            {
            // InternalMixin.g:459:1: ( 'clean' )
            // InternalMixin.g:460:2: 'clean'
            {
             before(grammarAccess.getCleanAccess().getCleanKeyword_1()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getCleanAccess().getCleanKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clean__Group__1__Impl"


    // $ANTLR start "rule__Model__InstructionsAssignment"
    // InternalMixin.g:470:1: rule__Model__InstructionsAssignment : ( ruleInstruction ) ;
    public final void rule__Model__InstructionsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:474:1: ( ( ruleInstruction ) )
            // InternalMixin.g:475:2: ( ruleInstruction )
            {
            // InternalMixin.g:475:2: ( ruleInstruction )
            // InternalMixin.g:476:3: ruleInstruction
            {
             before(grammarAccess.getModelAccess().getInstructionsInstructionParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleInstruction();

            state._fsp--;

             after(grammarAccess.getModelAccess().getInstructionsInstructionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__InstructionsAssignment"


    // $ANTLR start "rule__Move__QuantityAssignment_1"
    // InternalMixin.g:485:1: rule__Move__QuantityAssignment_1 : ( RULE_INT ) ;
    public final void rule__Move__QuantityAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:489:1: ( ( RULE_INT ) )
            // InternalMixin.g:490:2: ( RULE_INT )
            {
            // InternalMixin.g:490:2: ( RULE_INT )
            // InternalMixin.g:491:3: RULE_INT
            {
             before(grammarAccess.getMoveAccess().getQuantityINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getMoveAccess().getQuantityINTTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Move__QuantityAssignment_1"


    // $ANTLR start "rule__Move__SourceCupAssignment_5"
    // InternalMixin.g:500:1: rule__Move__SourceCupAssignment_5 : ( RULE_INT ) ;
    public final void rule__Move__SourceCupAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:504:1: ( ( RULE_INT ) )
            // InternalMixin.g:505:2: ( RULE_INT )
            {
            // InternalMixin.g:505:2: ( RULE_INT )
            // InternalMixin.g:506:3: RULE_INT
            {
             before(grammarAccess.getMoveAccess().getSourceCupINTTerminalRuleCall_5_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getMoveAccess().getSourceCupINTTerminalRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Move__SourceCupAssignment_5"


    // $ANTLR start "rule__Move__DestinationCupAssignment_8"
    // InternalMixin.g:515:1: rule__Move__DestinationCupAssignment_8 : ( RULE_INT ) ;
    public final void rule__Move__DestinationCupAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:519:1: ( ( RULE_INT ) )
            // InternalMixin.g:520:2: ( RULE_INT )
            {
            // InternalMixin.g:520:2: ( RULE_INT )
            // InternalMixin.g:521:3: RULE_INT
            {
             before(grammarAccess.getMoveAccess().getDestinationCupINTTerminalRuleCall_8_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getMoveAccess().getDestinationCupINTTerminalRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Move__DestinationCupAssignment_8"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000010802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010800L});

}