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



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMixinParser extends AbstractInternalAntlrParser {
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




    // $ANTLR start "entryRuleModel"
    // InternalMixin.g:64:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalMixin.g:64:46: (iv_ruleModel= ruleModel EOF )
            // InternalMixin.g:65:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalMixin.g:71:1: ruleModel returns [EObject current=null] : ( (lv_instructions_0_0= ruleInstruction ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_instructions_0_0 = null;



        	enterRule();

        try {
            // InternalMixin.g:77:2: ( ( (lv_instructions_0_0= ruleInstruction ) )* )
            // InternalMixin.g:78:2: ( (lv_instructions_0_0= ruleInstruction ) )*
            {
            // InternalMixin.g:78:2: ( (lv_instructions_0_0= ruleInstruction ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11||LA1_0==14||(LA1_0>=16 && LA1_0<=17)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMixin.g:79:3: (lv_instructions_0_0= ruleInstruction )
            	    {
            	    // InternalMixin.g:79:3: (lv_instructions_0_0= ruleInstruction )
            	    // InternalMixin.g:80:4: lv_instructions_0_0= ruleInstruction
            	    {

            	    				newCompositeNode(grammarAccess.getModelAccess().getInstructionsInstructionParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_instructions_0_0=ruleInstruction();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getModelRule());
            	    				}
            	    				add(
            	    					current,
            	    					"instructions",
            	    					lv_instructions_0_0,
            	    					"mixin.Mixin.Instruction");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleInstruction"
    // InternalMixin.g:100:1: entryRuleInstruction returns [EObject current=null] : iv_ruleInstruction= ruleInstruction EOF ;
    public final EObject entryRuleInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstruction = null;


        try {
            // InternalMixin.g:100:52: (iv_ruleInstruction= ruleInstruction EOF )
            // InternalMixin.g:101:2: iv_ruleInstruction= ruleInstruction EOF
            {
             newCompositeNode(grammarAccess.getInstructionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInstruction=ruleInstruction();

            state._fsp--;

             current =iv_ruleInstruction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInstruction"


    // $ANTLR start "ruleInstruction"
    // InternalMixin.g:107:1: ruleInstruction returns [EObject current=null] : (this_Take_0= ruleTake | this_Clean_1= ruleClean | this_Mix_2= ruleMix | this_Exit_3= ruleExit ) ;
    public final EObject ruleInstruction() throws RecognitionException {
        EObject current = null;

        EObject this_Take_0 = null;

        EObject this_Clean_1 = null;

        EObject this_Mix_2 = null;

        EObject this_Exit_3 = null;



        	enterRule();

        try {
            // InternalMixin.g:113:2: ( (this_Take_0= ruleTake | this_Clean_1= ruleClean | this_Mix_2= ruleMix | this_Exit_3= ruleExit ) )
            // InternalMixin.g:114:2: (this_Take_0= ruleTake | this_Clean_1= ruleClean | this_Mix_2= ruleMix | this_Exit_3= ruleExit )
            {
            // InternalMixin.g:114:2: (this_Take_0= ruleTake | this_Clean_1= ruleClean | this_Mix_2= ruleMix | this_Exit_3= ruleExit )
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
                    // InternalMixin.g:115:3: this_Take_0= ruleTake
                    {

                    			newCompositeNode(grammarAccess.getInstructionAccess().getTakeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Take_0=ruleTake();

                    state._fsp--;


                    			current = this_Take_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMixin.g:124:3: this_Clean_1= ruleClean
                    {

                    			newCompositeNode(grammarAccess.getInstructionAccess().getCleanParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Clean_1=ruleClean();

                    state._fsp--;


                    			current = this_Clean_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMixin.g:133:3: this_Mix_2= ruleMix
                    {

                    			newCompositeNode(grammarAccess.getInstructionAccess().getMixParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Mix_2=ruleMix();

                    state._fsp--;


                    			current = this_Mix_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalMixin.g:142:3: this_Exit_3= ruleExit
                    {

                    			newCompositeNode(grammarAccess.getInstructionAccess().getExitParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Exit_3=ruleExit();

                    state._fsp--;


                    			current = this_Exit_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInstruction"


    // $ANTLR start "entryRuleTake"
    // InternalMixin.g:154:1: entryRuleTake returns [EObject current=null] : iv_ruleTake= ruleTake EOF ;
    public final EObject entryRuleTake() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTake = null;


        try {
            // InternalMixin.g:154:45: (iv_ruleTake= ruleTake EOF )
            // InternalMixin.g:155:2: iv_ruleTake= ruleTake EOF
            {
             newCompositeNode(grammarAccess.getTakeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTake=ruleTake();

            state._fsp--;

             current =iv_ruleTake; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTake"


    // $ANTLR start "ruleTake"
    // InternalMixin.g:161:1: ruleTake returns [EObject current=null] : (otherlv_0= 'take' ( (lv_quantity_1_0= RULE_INT ) ) otherlv_2= 'mL' otherlv_3= 'from' ( (lv_inputCup_4_0= RULE_INT ) ) ) ;
    public final EObject ruleTake() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_quantity_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_inputCup_4_0=null;


        	enterRule();

        try {
            // InternalMixin.g:167:2: ( (otherlv_0= 'take' ( (lv_quantity_1_0= RULE_INT ) ) otherlv_2= 'mL' otherlv_3= 'from' ( (lv_inputCup_4_0= RULE_INT ) ) ) )
            // InternalMixin.g:168:2: (otherlv_0= 'take' ( (lv_quantity_1_0= RULE_INT ) ) otherlv_2= 'mL' otherlv_3= 'from' ( (lv_inputCup_4_0= RULE_INT ) ) )
            {
            // InternalMixin.g:168:2: (otherlv_0= 'take' ( (lv_quantity_1_0= RULE_INT ) ) otherlv_2= 'mL' otherlv_3= 'from' ( (lv_inputCup_4_0= RULE_INT ) ) )
            // InternalMixin.g:169:3: otherlv_0= 'take' ( (lv_quantity_1_0= RULE_INT ) ) otherlv_2= 'mL' otherlv_3= 'from' ( (lv_inputCup_4_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,11,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getTakeAccess().getTakeKeyword_0());
            		
            // InternalMixin.g:173:3: ( (lv_quantity_1_0= RULE_INT ) )
            // InternalMixin.g:174:4: (lv_quantity_1_0= RULE_INT )
            {
            // InternalMixin.g:174:4: (lv_quantity_1_0= RULE_INT )
            // InternalMixin.g:175:5: lv_quantity_1_0= RULE_INT
            {
            lv_quantity_1_0=(Token)match(input,RULE_INT,FOLLOW_5); 

            					newLeafNode(lv_quantity_1_0, grammarAccess.getTakeAccess().getQuantityINTTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTakeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"quantity",
            						lv_quantity_1_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getTakeAccess().getMLKeyword_2());
            		
            otherlv_3=(Token)match(input,13,FOLLOW_4); 

            			newLeafNode(otherlv_3, grammarAccess.getTakeAccess().getFromKeyword_3());
            		
            // InternalMixin.g:199:3: ( (lv_inputCup_4_0= RULE_INT ) )
            // InternalMixin.g:200:4: (lv_inputCup_4_0= RULE_INT )
            {
            // InternalMixin.g:200:4: (lv_inputCup_4_0= RULE_INT )
            // InternalMixin.g:201:5: lv_inputCup_4_0= RULE_INT
            {
            lv_inputCup_4_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            					newLeafNode(lv_inputCup_4_0, grammarAccess.getTakeAccess().getInputCupINTTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTakeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"inputCup",
            						lv_inputCup_4_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTake"


    // $ANTLR start "entryRuleMix"
    // InternalMixin.g:221:1: entryRuleMix returns [EObject current=null] : iv_ruleMix= ruleMix EOF ;
    public final EObject entryRuleMix() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMix = null;


        try {
            // InternalMixin.g:221:44: (iv_ruleMix= ruleMix EOF )
            // InternalMixin.g:222:2: iv_ruleMix= ruleMix EOF
            {
             newCompositeNode(grammarAccess.getMixRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMix=ruleMix();

            state._fsp--;

             current =iv_ruleMix; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMix"


    // $ANTLR start "ruleMix"
    // InternalMixin.g:228:1: ruleMix returns [EObject current=null] : (otherlv_0= 'mix' ( (lv_quantity_1_0= RULE_INT ) ) otherlv_2= 'mL' otherlv_3= 'in' ( (lv_destinationCup_4_0= RULE_INT ) ) ) ;
    public final EObject ruleMix() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_quantity_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_destinationCup_4_0=null;


        	enterRule();

        try {
            // InternalMixin.g:234:2: ( (otherlv_0= 'mix' ( (lv_quantity_1_0= RULE_INT ) ) otherlv_2= 'mL' otherlv_3= 'in' ( (lv_destinationCup_4_0= RULE_INT ) ) ) )
            // InternalMixin.g:235:2: (otherlv_0= 'mix' ( (lv_quantity_1_0= RULE_INT ) ) otherlv_2= 'mL' otherlv_3= 'in' ( (lv_destinationCup_4_0= RULE_INT ) ) )
            {
            // InternalMixin.g:235:2: (otherlv_0= 'mix' ( (lv_quantity_1_0= RULE_INT ) ) otherlv_2= 'mL' otherlv_3= 'in' ( (lv_destinationCup_4_0= RULE_INT ) ) )
            // InternalMixin.g:236:3: otherlv_0= 'mix' ( (lv_quantity_1_0= RULE_INT ) ) otherlv_2= 'mL' otherlv_3= 'in' ( (lv_destinationCup_4_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getMixAccess().getMixKeyword_0());
            		
            // InternalMixin.g:240:3: ( (lv_quantity_1_0= RULE_INT ) )
            // InternalMixin.g:241:4: (lv_quantity_1_0= RULE_INT )
            {
            // InternalMixin.g:241:4: (lv_quantity_1_0= RULE_INT )
            // InternalMixin.g:242:5: lv_quantity_1_0= RULE_INT
            {
            lv_quantity_1_0=(Token)match(input,RULE_INT,FOLLOW_5); 

            					newLeafNode(lv_quantity_1_0, grammarAccess.getMixAccess().getQuantityINTTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMixRule());
            					}
            					setWithLastConsumed(
            						current,
            						"quantity",
            						lv_quantity_1_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getMixAccess().getMLKeyword_2());
            		
            otherlv_3=(Token)match(input,15,FOLLOW_4); 

            			newLeafNode(otherlv_3, grammarAccess.getMixAccess().getInKeyword_3());
            		
            // InternalMixin.g:266:3: ( (lv_destinationCup_4_0= RULE_INT ) )
            // InternalMixin.g:267:4: (lv_destinationCup_4_0= RULE_INT )
            {
            // InternalMixin.g:267:4: (lv_destinationCup_4_0= RULE_INT )
            // InternalMixin.g:268:5: lv_destinationCup_4_0= RULE_INT
            {
            lv_destinationCup_4_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            					newLeafNode(lv_destinationCup_4_0, grammarAccess.getMixAccess().getDestinationCupINTTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMixRule());
            					}
            					setWithLastConsumed(
            						current,
            						"destinationCup",
            						lv_destinationCup_4_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMix"


    // $ANTLR start "entryRuleClean"
    // InternalMixin.g:288:1: entryRuleClean returns [EObject current=null] : iv_ruleClean= ruleClean EOF ;
    public final EObject entryRuleClean() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClean = null;


        try {
            // InternalMixin.g:288:46: (iv_ruleClean= ruleClean EOF )
            // InternalMixin.g:289:2: iv_ruleClean= ruleClean EOF
            {
             newCompositeNode(grammarAccess.getCleanRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleClean=ruleClean();

            state._fsp--;

             current =iv_ruleClean; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClean"


    // $ANTLR start "ruleClean"
    // InternalMixin.g:295:1: ruleClean returns [EObject current=null] : ( () otherlv_1= 'clean' ) ;
    public final EObject ruleClean() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMixin.g:301:2: ( ( () otherlv_1= 'clean' ) )
            // InternalMixin.g:302:2: ( () otherlv_1= 'clean' )
            {
            // InternalMixin.g:302:2: ( () otherlv_1= 'clean' )
            // InternalMixin.g:303:3: () otherlv_1= 'clean'
            {
            // InternalMixin.g:303:3: ()
            // InternalMixin.g:304:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getCleanAccess().getCleanAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getCleanAccess().getCleanKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClean"


    // $ANTLR start "entryRuleExit"
    // InternalMixin.g:318:1: entryRuleExit returns [EObject current=null] : iv_ruleExit= ruleExit EOF ;
    public final EObject entryRuleExit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExit = null;


        try {
            // InternalMixin.g:318:45: (iv_ruleExit= ruleExit EOF )
            // InternalMixin.g:319:2: iv_ruleExit= ruleExit EOF
            {
             newCompositeNode(grammarAccess.getExitRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExit=ruleExit();

            state._fsp--;

             current =iv_ruleExit; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExit"


    // $ANTLR start "ruleExit"
    // InternalMixin.g:325:1: ruleExit returns [EObject current=null] : (otherlv_0= 'exit' otherlv_1= 'cup' ( (lv_cup_2_0= RULE_INT ) ) ) ;
    public final EObject ruleExit() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_cup_2_0=null;


        	enterRule();

        try {
            // InternalMixin.g:331:2: ( (otherlv_0= 'exit' otherlv_1= 'cup' ( (lv_cup_2_0= RULE_INT ) ) ) )
            // InternalMixin.g:332:2: (otherlv_0= 'exit' otherlv_1= 'cup' ( (lv_cup_2_0= RULE_INT ) ) )
            {
            // InternalMixin.g:332:2: (otherlv_0= 'exit' otherlv_1= 'cup' ( (lv_cup_2_0= RULE_INT ) ) )
            // InternalMixin.g:333:3: otherlv_0= 'exit' otherlv_1= 'cup' ( (lv_cup_2_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,17,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getExitAccess().getExitKeyword_0());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getExitAccess().getCupKeyword_1());
            		
            // InternalMixin.g:341:3: ( (lv_cup_2_0= RULE_INT ) )
            // InternalMixin.g:342:4: (lv_cup_2_0= RULE_INT )
            {
            // InternalMixin.g:342:4: (lv_cup_2_0= RULE_INT )
            // InternalMixin.g:343:5: lv_cup_2_0= RULE_INT
            {
            lv_cup_2_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            					newLeafNode(lv_cup_2_0, grammarAccess.getExitAccess().getCupINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getExitRule());
            					}
            					setWithLastConsumed(
            						current,
            						"cup",
            						lv_cup_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExit"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000034802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000040000L});

}