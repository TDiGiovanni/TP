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

                if ( (LA1_0==11||LA1_0==16) ) {
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
    // InternalMixin.g:107:1: ruleInstruction returns [EObject current=null] : (this_Move_0= ruleMove | this_Clean_1= ruleClean ) ;
    public final EObject ruleInstruction() throws RecognitionException {
        EObject current = null;

        EObject this_Move_0 = null;

        EObject this_Clean_1 = null;



        	enterRule();

        try {
            // InternalMixin.g:113:2: ( (this_Move_0= ruleMove | this_Clean_1= ruleClean ) )
            // InternalMixin.g:114:2: (this_Move_0= ruleMove | this_Clean_1= ruleClean )
            {
            // InternalMixin.g:114:2: (this_Move_0= ruleMove | this_Clean_1= ruleClean )
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
                    // InternalMixin.g:115:3: this_Move_0= ruleMove
                    {

                    			newCompositeNode(grammarAccess.getInstructionAccess().getMoveParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Move_0=ruleMove();

                    state._fsp--;


                    			current = this_Move_0;
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


    // $ANTLR start "entryRuleMove"
    // InternalMixin.g:136:1: entryRuleMove returns [EObject current=null] : iv_ruleMove= ruleMove EOF ;
    public final EObject entryRuleMove() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMove = null;


        try {
            // InternalMixin.g:136:45: (iv_ruleMove= ruleMove EOF )
            // InternalMixin.g:137:2: iv_ruleMove= ruleMove EOF
            {
             newCompositeNode(grammarAccess.getMoveRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMove=ruleMove();

            state._fsp--;

             current =iv_ruleMove; 
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
    // $ANTLR end "entryRuleMove"


    // $ANTLR start "ruleMove"
    // InternalMixin.g:143:1: ruleMove returns [EObject current=null] : (otherlv_0= 'move' ( (lv_quantity_1_0= RULE_INT ) ) otherlv_2= 'mL' otherlv_3= 'from' otherlv_4= 'cup' ( (lv_sourceCup_5_0= RULE_INT ) ) otherlv_6= 'to' otherlv_7= 'cup' ( (lv_destinationCup_8_0= RULE_INT ) ) ) ;
    public final EObject ruleMove() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_quantity_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_sourceCup_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_destinationCup_8_0=null;


        	enterRule();

        try {
            // InternalMixin.g:149:2: ( (otherlv_0= 'move' ( (lv_quantity_1_0= RULE_INT ) ) otherlv_2= 'mL' otherlv_3= 'from' otherlv_4= 'cup' ( (lv_sourceCup_5_0= RULE_INT ) ) otherlv_6= 'to' otherlv_7= 'cup' ( (lv_destinationCup_8_0= RULE_INT ) ) ) )
            // InternalMixin.g:150:2: (otherlv_0= 'move' ( (lv_quantity_1_0= RULE_INT ) ) otherlv_2= 'mL' otherlv_3= 'from' otherlv_4= 'cup' ( (lv_sourceCup_5_0= RULE_INT ) ) otherlv_6= 'to' otherlv_7= 'cup' ( (lv_destinationCup_8_0= RULE_INT ) ) )
            {
            // InternalMixin.g:150:2: (otherlv_0= 'move' ( (lv_quantity_1_0= RULE_INT ) ) otherlv_2= 'mL' otherlv_3= 'from' otherlv_4= 'cup' ( (lv_sourceCup_5_0= RULE_INT ) ) otherlv_6= 'to' otherlv_7= 'cup' ( (lv_destinationCup_8_0= RULE_INT ) ) )
            // InternalMixin.g:151:3: otherlv_0= 'move' ( (lv_quantity_1_0= RULE_INT ) ) otherlv_2= 'mL' otherlv_3= 'from' otherlv_4= 'cup' ( (lv_sourceCup_5_0= RULE_INT ) ) otherlv_6= 'to' otherlv_7= 'cup' ( (lv_destinationCup_8_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,11,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getMoveAccess().getMoveKeyword_0());
            		
            // InternalMixin.g:155:3: ( (lv_quantity_1_0= RULE_INT ) )
            // InternalMixin.g:156:4: (lv_quantity_1_0= RULE_INT )
            {
            // InternalMixin.g:156:4: (lv_quantity_1_0= RULE_INT )
            // InternalMixin.g:157:5: lv_quantity_1_0= RULE_INT
            {
            lv_quantity_1_0=(Token)match(input,RULE_INT,FOLLOW_5); 

            					newLeafNode(lv_quantity_1_0, grammarAccess.getMoveAccess().getQuantityINTTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMoveRule());
            					}
            					setWithLastConsumed(
            						current,
            						"quantity",
            						lv_quantity_1_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getMoveAccess().getMLKeyword_2());
            		
            otherlv_3=(Token)match(input,13,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getMoveAccess().getFromKeyword_3());
            		
            otherlv_4=(Token)match(input,14,FOLLOW_4); 

            			newLeafNode(otherlv_4, grammarAccess.getMoveAccess().getCupKeyword_4());
            		
            // InternalMixin.g:185:3: ( (lv_sourceCup_5_0= RULE_INT ) )
            // InternalMixin.g:186:4: (lv_sourceCup_5_0= RULE_INT )
            {
            // InternalMixin.g:186:4: (lv_sourceCup_5_0= RULE_INT )
            // InternalMixin.g:187:5: lv_sourceCup_5_0= RULE_INT
            {
            lv_sourceCup_5_0=(Token)match(input,RULE_INT,FOLLOW_8); 

            					newLeafNode(lv_sourceCup_5_0, grammarAccess.getMoveAccess().getSourceCupINTTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMoveRule());
            					}
            					setWithLastConsumed(
            						current,
            						"sourceCup",
            						lv_sourceCup_5_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_6=(Token)match(input,15,FOLLOW_7); 

            			newLeafNode(otherlv_6, grammarAccess.getMoveAccess().getToKeyword_6());
            		
            otherlv_7=(Token)match(input,14,FOLLOW_4); 

            			newLeafNode(otherlv_7, grammarAccess.getMoveAccess().getCupKeyword_7());
            		
            // InternalMixin.g:211:3: ( (lv_destinationCup_8_0= RULE_INT ) )
            // InternalMixin.g:212:4: (lv_destinationCup_8_0= RULE_INT )
            {
            // InternalMixin.g:212:4: (lv_destinationCup_8_0= RULE_INT )
            // InternalMixin.g:213:5: lv_destinationCup_8_0= RULE_INT
            {
            lv_destinationCup_8_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            					newLeafNode(lv_destinationCup_8_0, grammarAccess.getMoveAccess().getDestinationCupINTTerminalRuleCall_8_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMoveRule());
            					}
            					setWithLastConsumed(
            						current,
            						"destinationCup",
            						lv_destinationCup_8_0,
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
    // $ANTLR end "ruleMove"


    // $ANTLR start "entryRuleClean"
    // InternalMixin.g:233:1: entryRuleClean returns [EObject current=null] : iv_ruleClean= ruleClean EOF ;
    public final EObject entryRuleClean() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClean = null;


        try {
            // InternalMixin.g:233:46: (iv_ruleClean= ruleClean EOF )
            // InternalMixin.g:234:2: iv_ruleClean= ruleClean EOF
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
    // InternalMixin.g:240:1: ruleClean returns [EObject current=null] : ( () otherlv_1= 'clean' ) ;
    public final EObject ruleClean() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMixin.g:246:2: ( ( () otherlv_1= 'clean' ) )
            // InternalMixin.g:247:2: ( () otherlv_1= 'clean' )
            {
            // InternalMixin.g:247:2: ( () otherlv_1= 'clean' )
            // InternalMixin.g:248:3: () otherlv_1= 'clean'
            {
            // InternalMixin.g:248:3: ()
            // InternalMixin.g:249:4: 
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

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000010802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008000L});

}