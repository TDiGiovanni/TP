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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'take'", "'mL'", "'from'", "'mix'", "'in'", "'clean'", "'exit'", "'cup'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int RULE_INT=4;
    public static final int T__18=18;
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

                if ( (LA1_0==11||LA1_0==14||(LA1_0>=16 && LA1_0<=17)) ) {
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


    // $ANTLR start "entryRuleTake"
    // InternalMixin.g:103:1: entryRuleTake : ruleTake EOF ;
    public final void entryRuleTake() throws RecognitionException {
        try {
            // InternalMixin.g:104:1: ( ruleTake EOF )
            // InternalMixin.g:105:1: ruleTake EOF
            {
             before(grammarAccess.getTakeRule()); 
            pushFollow(FOLLOW_1);
            ruleTake();

            state._fsp--;

             after(grammarAccess.getTakeRule()); 
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
    // $ANTLR end "entryRuleTake"


    // $ANTLR start "ruleTake"
    // InternalMixin.g:112:1: ruleTake : ( ( rule__Take__Group__0 ) ) ;
    public final void ruleTake() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:116:2: ( ( ( rule__Take__Group__0 ) ) )
            // InternalMixin.g:117:2: ( ( rule__Take__Group__0 ) )
            {
            // InternalMixin.g:117:2: ( ( rule__Take__Group__0 ) )
            // InternalMixin.g:118:3: ( rule__Take__Group__0 )
            {
             before(grammarAccess.getTakeAccess().getGroup()); 
            // InternalMixin.g:119:3: ( rule__Take__Group__0 )
            // InternalMixin.g:119:4: rule__Take__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Take__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTakeAccess().getGroup()); 

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
    // $ANTLR end "ruleTake"


    // $ANTLR start "entryRuleMix"
    // InternalMixin.g:128:1: entryRuleMix : ruleMix EOF ;
    public final void entryRuleMix() throws RecognitionException {
        try {
            // InternalMixin.g:129:1: ( ruleMix EOF )
            // InternalMixin.g:130:1: ruleMix EOF
            {
             before(grammarAccess.getMixRule()); 
            pushFollow(FOLLOW_1);
            ruleMix();

            state._fsp--;

             after(grammarAccess.getMixRule()); 
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
    // $ANTLR end "entryRuleMix"


    // $ANTLR start "ruleMix"
    // InternalMixin.g:137:1: ruleMix : ( ( rule__Mix__Group__0 ) ) ;
    public final void ruleMix() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:141:2: ( ( ( rule__Mix__Group__0 ) ) )
            // InternalMixin.g:142:2: ( ( rule__Mix__Group__0 ) )
            {
            // InternalMixin.g:142:2: ( ( rule__Mix__Group__0 ) )
            // InternalMixin.g:143:3: ( rule__Mix__Group__0 )
            {
             before(grammarAccess.getMixAccess().getGroup()); 
            // InternalMixin.g:144:3: ( rule__Mix__Group__0 )
            // InternalMixin.g:144:4: rule__Mix__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Mix__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMixAccess().getGroup()); 

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
    // $ANTLR end "ruleMix"


    // $ANTLR start "entryRuleClean"
    // InternalMixin.g:153:1: entryRuleClean : ruleClean EOF ;
    public final void entryRuleClean() throws RecognitionException {
        try {
            // InternalMixin.g:154:1: ( ruleClean EOF )
            // InternalMixin.g:155:1: ruleClean EOF
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
    // InternalMixin.g:162:1: ruleClean : ( ( rule__Clean__Group__0 ) ) ;
    public final void ruleClean() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:166:2: ( ( ( rule__Clean__Group__0 ) ) )
            // InternalMixin.g:167:2: ( ( rule__Clean__Group__0 ) )
            {
            // InternalMixin.g:167:2: ( ( rule__Clean__Group__0 ) )
            // InternalMixin.g:168:3: ( rule__Clean__Group__0 )
            {
             before(grammarAccess.getCleanAccess().getGroup()); 
            // InternalMixin.g:169:3: ( rule__Clean__Group__0 )
            // InternalMixin.g:169:4: rule__Clean__Group__0
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


    // $ANTLR start "entryRuleExit"
    // InternalMixin.g:178:1: entryRuleExit : ruleExit EOF ;
    public final void entryRuleExit() throws RecognitionException {
        try {
            // InternalMixin.g:179:1: ( ruleExit EOF )
            // InternalMixin.g:180:1: ruleExit EOF
            {
             before(grammarAccess.getExitRule()); 
            pushFollow(FOLLOW_1);
            ruleExit();

            state._fsp--;

             after(grammarAccess.getExitRule()); 
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
    // $ANTLR end "entryRuleExit"


    // $ANTLR start "ruleExit"
    // InternalMixin.g:187:1: ruleExit : ( ( rule__Exit__Group__0 ) ) ;
    public final void ruleExit() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:191:2: ( ( ( rule__Exit__Group__0 ) ) )
            // InternalMixin.g:192:2: ( ( rule__Exit__Group__0 ) )
            {
            // InternalMixin.g:192:2: ( ( rule__Exit__Group__0 ) )
            // InternalMixin.g:193:3: ( rule__Exit__Group__0 )
            {
             before(grammarAccess.getExitAccess().getGroup()); 
            // InternalMixin.g:194:3: ( rule__Exit__Group__0 )
            // InternalMixin.g:194:4: rule__Exit__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Exit__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getExitAccess().getGroup()); 

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
    // $ANTLR end "ruleExit"


    // $ANTLR start "rule__Instruction__Alternatives"
    // InternalMixin.g:202:1: rule__Instruction__Alternatives : ( ( ruleTake ) | ( ruleClean ) | ( ruleMix ) | ( ruleExit ) );
    public final void rule__Instruction__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:206:1: ( ( ruleTake ) | ( ruleClean ) | ( ruleMix ) | ( ruleExit ) )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt2=1;
                }
                break;
            case 16:
                {
                alt2=2;
                }
                break;
            case 14:
                {
                alt2=3;
                }
                break;
            case 17:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalMixin.g:207:2: ( ruleTake )
                    {
                    // InternalMixin.g:207:2: ( ruleTake )
                    // InternalMixin.g:208:3: ruleTake
                    {
                     before(grammarAccess.getInstructionAccess().getTakeParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleTake();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getTakeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMixin.g:213:2: ( ruleClean )
                    {
                    // InternalMixin.g:213:2: ( ruleClean )
                    // InternalMixin.g:214:3: ruleClean
                    {
                     before(grammarAccess.getInstructionAccess().getCleanParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleClean();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getCleanParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalMixin.g:219:2: ( ruleMix )
                    {
                    // InternalMixin.g:219:2: ( ruleMix )
                    // InternalMixin.g:220:3: ruleMix
                    {
                     before(grammarAccess.getInstructionAccess().getMixParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleMix();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getMixParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalMixin.g:225:2: ( ruleExit )
                    {
                    // InternalMixin.g:225:2: ( ruleExit )
                    // InternalMixin.g:226:3: ruleExit
                    {
                     before(grammarAccess.getInstructionAccess().getExitParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleExit();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getExitParserRuleCall_3()); 

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


    // $ANTLR start "rule__Take__Group__0"
    // InternalMixin.g:235:1: rule__Take__Group__0 : rule__Take__Group__0__Impl rule__Take__Group__1 ;
    public final void rule__Take__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:239:1: ( rule__Take__Group__0__Impl rule__Take__Group__1 )
            // InternalMixin.g:240:2: rule__Take__Group__0__Impl rule__Take__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Take__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Take__Group__1();

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
    // $ANTLR end "rule__Take__Group__0"


    // $ANTLR start "rule__Take__Group__0__Impl"
    // InternalMixin.g:247:1: rule__Take__Group__0__Impl : ( 'take' ) ;
    public final void rule__Take__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:251:1: ( ( 'take' ) )
            // InternalMixin.g:252:1: ( 'take' )
            {
            // InternalMixin.g:252:1: ( 'take' )
            // InternalMixin.g:253:2: 'take'
            {
             before(grammarAccess.getTakeAccess().getTakeKeyword_0()); 
            match(input,11,FOLLOW_2); 
             after(grammarAccess.getTakeAccess().getTakeKeyword_0()); 

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
    // $ANTLR end "rule__Take__Group__0__Impl"


    // $ANTLR start "rule__Take__Group__1"
    // InternalMixin.g:262:1: rule__Take__Group__1 : rule__Take__Group__1__Impl rule__Take__Group__2 ;
    public final void rule__Take__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:266:1: ( rule__Take__Group__1__Impl rule__Take__Group__2 )
            // InternalMixin.g:267:2: rule__Take__Group__1__Impl rule__Take__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Take__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Take__Group__2();

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
    // $ANTLR end "rule__Take__Group__1"


    // $ANTLR start "rule__Take__Group__1__Impl"
    // InternalMixin.g:274:1: rule__Take__Group__1__Impl : ( ( rule__Take__QuantityAssignment_1 ) ) ;
    public final void rule__Take__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:278:1: ( ( ( rule__Take__QuantityAssignment_1 ) ) )
            // InternalMixin.g:279:1: ( ( rule__Take__QuantityAssignment_1 ) )
            {
            // InternalMixin.g:279:1: ( ( rule__Take__QuantityAssignment_1 ) )
            // InternalMixin.g:280:2: ( rule__Take__QuantityAssignment_1 )
            {
             before(grammarAccess.getTakeAccess().getQuantityAssignment_1()); 
            // InternalMixin.g:281:2: ( rule__Take__QuantityAssignment_1 )
            // InternalMixin.g:281:3: rule__Take__QuantityAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Take__QuantityAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTakeAccess().getQuantityAssignment_1()); 

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
    // $ANTLR end "rule__Take__Group__1__Impl"


    // $ANTLR start "rule__Take__Group__2"
    // InternalMixin.g:289:1: rule__Take__Group__2 : rule__Take__Group__2__Impl rule__Take__Group__3 ;
    public final void rule__Take__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:293:1: ( rule__Take__Group__2__Impl rule__Take__Group__3 )
            // InternalMixin.g:294:2: rule__Take__Group__2__Impl rule__Take__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__Take__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Take__Group__3();

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
    // $ANTLR end "rule__Take__Group__2"


    // $ANTLR start "rule__Take__Group__2__Impl"
    // InternalMixin.g:301:1: rule__Take__Group__2__Impl : ( 'mL' ) ;
    public final void rule__Take__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:305:1: ( ( 'mL' ) )
            // InternalMixin.g:306:1: ( 'mL' )
            {
            // InternalMixin.g:306:1: ( 'mL' )
            // InternalMixin.g:307:2: 'mL'
            {
             before(grammarAccess.getTakeAccess().getMLKeyword_2()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getTakeAccess().getMLKeyword_2()); 

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
    // $ANTLR end "rule__Take__Group__2__Impl"


    // $ANTLR start "rule__Take__Group__3"
    // InternalMixin.g:316:1: rule__Take__Group__3 : rule__Take__Group__3__Impl rule__Take__Group__4 ;
    public final void rule__Take__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:320:1: ( rule__Take__Group__3__Impl rule__Take__Group__4 )
            // InternalMixin.g:321:2: rule__Take__Group__3__Impl rule__Take__Group__4
            {
            pushFollow(FOLLOW_4);
            rule__Take__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Take__Group__4();

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
    // $ANTLR end "rule__Take__Group__3"


    // $ANTLR start "rule__Take__Group__3__Impl"
    // InternalMixin.g:328:1: rule__Take__Group__3__Impl : ( 'from' ) ;
    public final void rule__Take__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:332:1: ( ( 'from' ) )
            // InternalMixin.g:333:1: ( 'from' )
            {
            // InternalMixin.g:333:1: ( 'from' )
            // InternalMixin.g:334:2: 'from'
            {
             before(grammarAccess.getTakeAccess().getFromKeyword_3()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getTakeAccess().getFromKeyword_3()); 

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
    // $ANTLR end "rule__Take__Group__3__Impl"


    // $ANTLR start "rule__Take__Group__4"
    // InternalMixin.g:343:1: rule__Take__Group__4 : rule__Take__Group__4__Impl ;
    public final void rule__Take__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:347:1: ( rule__Take__Group__4__Impl )
            // InternalMixin.g:348:2: rule__Take__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Take__Group__4__Impl();

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
    // $ANTLR end "rule__Take__Group__4"


    // $ANTLR start "rule__Take__Group__4__Impl"
    // InternalMixin.g:354:1: rule__Take__Group__4__Impl : ( ( rule__Take__InputCupAssignment_4 ) ) ;
    public final void rule__Take__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:358:1: ( ( ( rule__Take__InputCupAssignment_4 ) ) )
            // InternalMixin.g:359:1: ( ( rule__Take__InputCupAssignment_4 ) )
            {
            // InternalMixin.g:359:1: ( ( rule__Take__InputCupAssignment_4 ) )
            // InternalMixin.g:360:2: ( rule__Take__InputCupAssignment_4 )
            {
             before(grammarAccess.getTakeAccess().getInputCupAssignment_4()); 
            // InternalMixin.g:361:2: ( rule__Take__InputCupAssignment_4 )
            // InternalMixin.g:361:3: rule__Take__InputCupAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Take__InputCupAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getTakeAccess().getInputCupAssignment_4()); 

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
    // $ANTLR end "rule__Take__Group__4__Impl"


    // $ANTLR start "rule__Mix__Group__0"
    // InternalMixin.g:370:1: rule__Mix__Group__0 : rule__Mix__Group__0__Impl rule__Mix__Group__1 ;
    public final void rule__Mix__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:374:1: ( rule__Mix__Group__0__Impl rule__Mix__Group__1 )
            // InternalMixin.g:375:2: rule__Mix__Group__0__Impl rule__Mix__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Mix__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Mix__Group__1();

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
    // $ANTLR end "rule__Mix__Group__0"


    // $ANTLR start "rule__Mix__Group__0__Impl"
    // InternalMixin.g:382:1: rule__Mix__Group__0__Impl : ( 'mix' ) ;
    public final void rule__Mix__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:386:1: ( ( 'mix' ) )
            // InternalMixin.g:387:1: ( 'mix' )
            {
            // InternalMixin.g:387:1: ( 'mix' )
            // InternalMixin.g:388:2: 'mix'
            {
             before(grammarAccess.getMixAccess().getMixKeyword_0()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getMixAccess().getMixKeyword_0()); 

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
    // $ANTLR end "rule__Mix__Group__0__Impl"


    // $ANTLR start "rule__Mix__Group__1"
    // InternalMixin.g:397:1: rule__Mix__Group__1 : rule__Mix__Group__1__Impl rule__Mix__Group__2 ;
    public final void rule__Mix__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:401:1: ( rule__Mix__Group__1__Impl rule__Mix__Group__2 )
            // InternalMixin.g:402:2: rule__Mix__Group__1__Impl rule__Mix__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Mix__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Mix__Group__2();

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
    // $ANTLR end "rule__Mix__Group__1"


    // $ANTLR start "rule__Mix__Group__1__Impl"
    // InternalMixin.g:409:1: rule__Mix__Group__1__Impl : ( ( rule__Mix__QuantityAssignment_1 ) ) ;
    public final void rule__Mix__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:413:1: ( ( ( rule__Mix__QuantityAssignment_1 ) ) )
            // InternalMixin.g:414:1: ( ( rule__Mix__QuantityAssignment_1 ) )
            {
            // InternalMixin.g:414:1: ( ( rule__Mix__QuantityAssignment_1 ) )
            // InternalMixin.g:415:2: ( rule__Mix__QuantityAssignment_1 )
            {
             before(grammarAccess.getMixAccess().getQuantityAssignment_1()); 
            // InternalMixin.g:416:2: ( rule__Mix__QuantityAssignment_1 )
            // InternalMixin.g:416:3: rule__Mix__QuantityAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Mix__QuantityAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getMixAccess().getQuantityAssignment_1()); 

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
    // $ANTLR end "rule__Mix__Group__1__Impl"


    // $ANTLR start "rule__Mix__Group__2"
    // InternalMixin.g:424:1: rule__Mix__Group__2 : rule__Mix__Group__2__Impl rule__Mix__Group__3 ;
    public final void rule__Mix__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:428:1: ( rule__Mix__Group__2__Impl rule__Mix__Group__3 )
            // InternalMixin.g:429:2: rule__Mix__Group__2__Impl rule__Mix__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__Mix__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Mix__Group__3();

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
    // $ANTLR end "rule__Mix__Group__2"


    // $ANTLR start "rule__Mix__Group__2__Impl"
    // InternalMixin.g:436:1: rule__Mix__Group__2__Impl : ( 'mL' ) ;
    public final void rule__Mix__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:440:1: ( ( 'mL' ) )
            // InternalMixin.g:441:1: ( 'mL' )
            {
            // InternalMixin.g:441:1: ( 'mL' )
            // InternalMixin.g:442:2: 'mL'
            {
             before(grammarAccess.getMixAccess().getMLKeyword_2()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getMixAccess().getMLKeyword_2()); 

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
    // $ANTLR end "rule__Mix__Group__2__Impl"


    // $ANTLR start "rule__Mix__Group__3"
    // InternalMixin.g:451:1: rule__Mix__Group__3 : rule__Mix__Group__3__Impl rule__Mix__Group__4 ;
    public final void rule__Mix__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:455:1: ( rule__Mix__Group__3__Impl rule__Mix__Group__4 )
            // InternalMixin.g:456:2: rule__Mix__Group__3__Impl rule__Mix__Group__4
            {
            pushFollow(FOLLOW_4);
            rule__Mix__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Mix__Group__4();

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
    // $ANTLR end "rule__Mix__Group__3"


    // $ANTLR start "rule__Mix__Group__3__Impl"
    // InternalMixin.g:463:1: rule__Mix__Group__3__Impl : ( 'in' ) ;
    public final void rule__Mix__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:467:1: ( ( 'in' ) )
            // InternalMixin.g:468:1: ( 'in' )
            {
            // InternalMixin.g:468:1: ( 'in' )
            // InternalMixin.g:469:2: 'in'
            {
             before(grammarAccess.getMixAccess().getInKeyword_3()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getMixAccess().getInKeyword_3()); 

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
    // $ANTLR end "rule__Mix__Group__3__Impl"


    // $ANTLR start "rule__Mix__Group__4"
    // InternalMixin.g:478:1: rule__Mix__Group__4 : rule__Mix__Group__4__Impl ;
    public final void rule__Mix__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:482:1: ( rule__Mix__Group__4__Impl )
            // InternalMixin.g:483:2: rule__Mix__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Mix__Group__4__Impl();

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
    // $ANTLR end "rule__Mix__Group__4"


    // $ANTLR start "rule__Mix__Group__4__Impl"
    // InternalMixin.g:489:1: rule__Mix__Group__4__Impl : ( ( rule__Mix__DestinationCupAssignment_4 ) ) ;
    public final void rule__Mix__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:493:1: ( ( ( rule__Mix__DestinationCupAssignment_4 ) ) )
            // InternalMixin.g:494:1: ( ( rule__Mix__DestinationCupAssignment_4 ) )
            {
            // InternalMixin.g:494:1: ( ( rule__Mix__DestinationCupAssignment_4 ) )
            // InternalMixin.g:495:2: ( rule__Mix__DestinationCupAssignment_4 )
            {
             before(grammarAccess.getMixAccess().getDestinationCupAssignment_4()); 
            // InternalMixin.g:496:2: ( rule__Mix__DestinationCupAssignment_4 )
            // InternalMixin.g:496:3: rule__Mix__DestinationCupAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Mix__DestinationCupAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getMixAccess().getDestinationCupAssignment_4()); 

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
    // $ANTLR end "rule__Mix__Group__4__Impl"


    // $ANTLR start "rule__Clean__Group__0"
    // InternalMixin.g:505:1: rule__Clean__Group__0 : rule__Clean__Group__0__Impl rule__Clean__Group__1 ;
    public final void rule__Clean__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:509:1: ( rule__Clean__Group__0__Impl rule__Clean__Group__1 )
            // InternalMixin.g:510:2: rule__Clean__Group__0__Impl rule__Clean__Group__1
            {
            pushFollow(FOLLOW_8);
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
    // InternalMixin.g:517:1: rule__Clean__Group__0__Impl : ( () ) ;
    public final void rule__Clean__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:521:1: ( ( () ) )
            // InternalMixin.g:522:1: ( () )
            {
            // InternalMixin.g:522:1: ( () )
            // InternalMixin.g:523:2: ()
            {
             before(grammarAccess.getCleanAccess().getCleanAction_0()); 
            // InternalMixin.g:524:2: ()
            // InternalMixin.g:524:3: 
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
    // InternalMixin.g:532:1: rule__Clean__Group__1 : rule__Clean__Group__1__Impl ;
    public final void rule__Clean__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:536:1: ( rule__Clean__Group__1__Impl )
            // InternalMixin.g:537:2: rule__Clean__Group__1__Impl
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
    // InternalMixin.g:543:1: rule__Clean__Group__1__Impl : ( 'clean' ) ;
    public final void rule__Clean__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:547:1: ( ( 'clean' ) )
            // InternalMixin.g:548:1: ( 'clean' )
            {
            // InternalMixin.g:548:1: ( 'clean' )
            // InternalMixin.g:549:2: 'clean'
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


    // $ANTLR start "rule__Exit__Group__0"
    // InternalMixin.g:559:1: rule__Exit__Group__0 : rule__Exit__Group__0__Impl rule__Exit__Group__1 ;
    public final void rule__Exit__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:563:1: ( rule__Exit__Group__0__Impl rule__Exit__Group__1 )
            // InternalMixin.g:564:2: rule__Exit__Group__0__Impl rule__Exit__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__Exit__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Exit__Group__1();

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
    // $ANTLR end "rule__Exit__Group__0"


    // $ANTLR start "rule__Exit__Group__0__Impl"
    // InternalMixin.g:571:1: rule__Exit__Group__0__Impl : ( 'exit' ) ;
    public final void rule__Exit__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:575:1: ( ( 'exit' ) )
            // InternalMixin.g:576:1: ( 'exit' )
            {
            // InternalMixin.g:576:1: ( 'exit' )
            // InternalMixin.g:577:2: 'exit'
            {
             before(grammarAccess.getExitAccess().getExitKeyword_0()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getExitAccess().getExitKeyword_0()); 

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
    // $ANTLR end "rule__Exit__Group__0__Impl"


    // $ANTLR start "rule__Exit__Group__1"
    // InternalMixin.g:586:1: rule__Exit__Group__1 : rule__Exit__Group__1__Impl rule__Exit__Group__2 ;
    public final void rule__Exit__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:590:1: ( rule__Exit__Group__1__Impl rule__Exit__Group__2 )
            // InternalMixin.g:591:2: rule__Exit__Group__1__Impl rule__Exit__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Exit__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Exit__Group__2();

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
    // $ANTLR end "rule__Exit__Group__1"


    // $ANTLR start "rule__Exit__Group__1__Impl"
    // InternalMixin.g:598:1: rule__Exit__Group__1__Impl : ( 'cup' ) ;
    public final void rule__Exit__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:602:1: ( ( 'cup' ) )
            // InternalMixin.g:603:1: ( 'cup' )
            {
            // InternalMixin.g:603:1: ( 'cup' )
            // InternalMixin.g:604:2: 'cup'
            {
             before(grammarAccess.getExitAccess().getCupKeyword_1()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getExitAccess().getCupKeyword_1()); 

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
    // $ANTLR end "rule__Exit__Group__1__Impl"


    // $ANTLR start "rule__Exit__Group__2"
    // InternalMixin.g:613:1: rule__Exit__Group__2 : rule__Exit__Group__2__Impl ;
    public final void rule__Exit__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:617:1: ( rule__Exit__Group__2__Impl )
            // InternalMixin.g:618:2: rule__Exit__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Exit__Group__2__Impl();

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
    // $ANTLR end "rule__Exit__Group__2"


    // $ANTLR start "rule__Exit__Group__2__Impl"
    // InternalMixin.g:624:1: rule__Exit__Group__2__Impl : ( ( rule__Exit__CupAssignment_2 ) ) ;
    public final void rule__Exit__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:628:1: ( ( ( rule__Exit__CupAssignment_2 ) ) )
            // InternalMixin.g:629:1: ( ( rule__Exit__CupAssignment_2 ) )
            {
            // InternalMixin.g:629:1: ( ( rule__Exit__CupAssignment_2 ) )
            // InternalMixin.g:630:2: ( rule__Exit__CupAssignment_2 )
            {
             before(grammarAccess.getExitAccess().getCupAssignment_2()); 
            // InternalMixin.g:631:2: ( rule__Exit__CupAssignment_2 )
            // InternalMixin.g:631:3: rule__Exit__CupAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Exit__CupAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getExitAccess().getCupAssignment_2()); 

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
    // $ANTLR end "rule__Exit__Group__2__Impl"


    // $ANTLR start "rule__Model__InstructionsAssignment"
    // InternalMixin.g:640:1: rule__Model__InstructionsAssignment : ( ruleInstruction ) ;
    public final void rule__Model__InstructionsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:644:1: ( ( ruleInstruction ) )
            // InternalMixin.g:645:2: ( ruleInstruction )
            {
            // InternalMixin.g:645:2: ( ruleInstruction )
            // InternalMixin.g:646:3: ruleInstruction
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


    // $ANTLR start "rule__Take__QuantityAssignment_1"
    // InternalMixin.g:655:1: rule__Take__QuantityAssignment_1 : ( RULE_INT ) ;
    public final void rule__Take__QuantityAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:659:1: ( ( RULE_INT ) )
            // InternalMixin.g:660:2: ( RULE_INT )
            {
            // InternalMixin.g:660:2: ( RULE_INT )
            // InternalMixin.g:661:3: RULE_INT
            {
             before(grammarAccess.getTakeAccess().getQuantityINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getTakeAccess().getQuantityINTTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__Take__QuantityAssignment_1"


    // $ANTLR start "rule__Take__InputCupAssignment_4"
    // InternalMixin.g:670:1: rule__Take__InputCupAssignment_4 : ( RULE_INT ) ;
    public final void rule__Take__InputCupAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:674:1: ( ( RULE_INT ) )
            // InternalMixin.g:675:2: ( RULE_INT )
            {
            // InternalMixin.g:675:2: ( RULE_INT )
            // InternalMixin.g:676:3: RULE_INT
            {
             before(grammarAccess.getTakeAccess().getInputCupINTTerminalRuleCall_4_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getTakeAccess().getInputCupINTTerminalRuleCall_4_0()); 

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
    // $ANTLR end "rule__Take__InputCupAssignment_4"


    // $ANTLR start "rule__Mix__QuantityAssignment_1"
    // InternalMixin.g:685:1: rule__Mix__QuantityAssignment_1 : ( RULE_INT ) ;
    public final void rule__Mix__QuantityAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:689:1: ( ( RULE_INT ) )
            // InternalMixin.g:690:2: ( RULE_INT )
            {
            // InternalMixin.g:690:2: ( RULE_INT )
            // InternalMixin.g:691:3: RULE_INT
            {
             before(grammarAccess.getMixAccess().getQuantityINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getMixAccess().getQuantityINTTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__Mix__QuantityAssignment_1"


    // $ANTLR start "rule__Mix__DestinationCupAssignment_4"
    // InternalMixin.g:700:1: rule__Mix__DestinationCupAssignment_4 : ( RULE_INT ) ;
    public final void rule__Mix__DestinationCupAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:704:1: ( ( RULE_INT ) )
            // InternalMixin.g:705:2: ( RULE_INT )
            {
            // InternalMixin.g:705:2: ( RULE_INT )
            // InternalMixin.g:706:3: RULE_INT
            {
             before(grammarAccess.getMixAccess().getDestinationCupINTTerminalRuleCall_4_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getMixAccess().getDestinationCupINTTerminalRuleCall_4_0()); 

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
    // $ANTLR end "rule__Mix__DestinationCupAssignment_4"


    // $ANTLR start "rule__Exit__CupAssignment_2"
    // InternalMixin.g:715:1: rule__Exit__CupAssignment_2 : ( RULE_INT ) ;
    public final void rule__Exit__CupAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMixin.g:719:1: ( ( RULE_INT ) )
            // InternalMixin.g:720:2: ( RULE_INT )
            {
            // InternalMixin.g:720:2: ( RULE_INT )
            // InternalMixin.g:721:3: RULE_INT
            {
             before(grammarAccess.getExitAccess().getCupINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getExitAccess().getCupINTTerminalRuleCall_2_0()); 

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
    // $ANTLR end "rule__Exit__CupAssignment_2"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000034802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000040000L});

}