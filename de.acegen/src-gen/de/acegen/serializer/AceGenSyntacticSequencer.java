/*
 * generated by Xtext 2.25.0
 */
package de.acegen.serializer;

import com.google.inject.Inject;
import de.acegen.services.AceGenGrammarAccess;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class AceGenSyntacticSequencer extends AbstractSyntacticSequencer {

	protected AceGenGrammarAccess grammarAccess;
	protected AbstractElementAlias match_ClientScenario_GIVENKeyword_1_0_q;
	protected AbstractElementAlias match_ClientThenBlock_ExpectedStateKeyword_1_0_q;
	protected AbstractElementAlias match_ClientThenBlock_VerificationsKeyword_2_0_q;
	protected AbstractElementAlias match_ClientWhenBlock___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q;
	protected AbstractElementAlias match_Count_CommaKeyword_3_0_q;
	protected AbstractElementAlias match_HttpClientOutcome___LeftParenthesisKeyword_2_0_RightParenthesisKeyword_2_2__q;
	protected AbstractElementAlias match_HttpClientOutcome___TriggersKeyword_3_0_LeftParenthesisKeyword_3_1_RightParenthesisKeyword_3_3__q;
	protected AbstractElementAlias match_HttpClient_ACEKeyword_1_0_q;
	protected AbstractElementAlias match_HttpClient_ScenariosKeyword_3_0_q;
	protected AbstractElementAlias match_HttpServerAceRead_PathParamsKeyword_7_0_q;
	protected AbstractElementAlias match_HttpServerAceRead_PayloadKeyword_9_0_q;
	protected AbstractElementAlias match_HttpServerAceRead_QueryParamsKeyword_8_0_q;
	protected AbstractElementAlias match_HttpServerAceRead_ResponseKeyword_10_0_q;
	protected AbstractElementAlias match_HttpServerAceWrite_PathParamsKeyword_7_0_q;
	protected AbstractElementAlias match_HttpServerAceWrite_PayloadKeyword_9_0_q;
	protected AbstractElementAlias match_HttpServerAceWrite_QueryParamsKeyword_8_0_q;
	protected AbstractElementAlias match_HttpServerAceWrite_ResponseKeyword_10_0_q;
	protected AbstractElementAlias match_HttpServerOutcome___LeftParenthesisKeyword_2_0_RightParenthesisKeyword_2_2__a;
	protected AbstractElementAlias match_HttpServerOutcome___RightParenthesisKeyword_2_2_LeftParenthesisKeyword_2_0__a;
	protected AbstractElementAlias match_HttpServerView___LeftCurlyBracketKeyword_2_0_RightCurlyBracketKeyword_2_2__q;
	protected AbstractElementAlias match_HttpServer_ACEKeyword_7_0_q;
	protected AbstractElementAlias match_HttpServer_ModelsKeyword_9_0_q;
	protected AbstractElementAlias match_HttpServer_ScenariosKeyword_10_0_q;
	protected AbstractElementAlias match_HttpServer_ViewsKeyword_8_0_q;
	protected AbstractElementAlias match_JsonObject_JsonKeyword_1_0_q;
	protected AbstractElementAlias match_Model___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_2__q;
	protected AbstractElementAlias match_Project___HttpClientKeyword_1_0_0_or_HttpServerKeyword_1_1_0__q;
	protected AbstractElementAlias match_Scenario_GIVENKeyword_1_0_q;
	protected AbstractElementAlias match_SelectByPrimaryKeys_CommaKeyword_3_0_q;
	protected AbstractElementAlias match_SingleClientAttribute___LeftCurlyBracketKeyword_5_0_RightCurlyBracketKeyword_5_2__q;
	protected AbstractElementAlias match_ThenBlock_PersistenceKeyword_2_0_q;
	protected AbstractElementAlias match_ThenBlock_VerificationsKeyword_3_0_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (AceGenGrammarAccess) access;
		match_ClientScenario_GIVENKeyword_1_0_q = new TokenAlias(false, true, grammarAccess.getClientScenarioAccess().getGIVENKeyword_1_0());
		match_ClientThenBlock_ExpectedStateKeyword_1_0_q = new TokenAlias(false, true, grammarAccess.getClientThenBlockAccess().getExpectedStateKeyword_1_0());
		match_ClientThenBlock_VerificationsKeyword_2_0_q = new TokenAlias(false, true, grammarAccess.getClientThenBlockAccess().getVerificationsKeyword_2_0());
		match_ClientWhenBlock___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getClientWhenBlockAccess().getLeftParenthesisKeyword_1_0()), new TokenAlias(false, false, grammarAccess.getClientWhenBlockAccess().getRightParenthesisKeyword_1_2()));
		match_Count_CommaKeyword_3_0_q = new TokenAlias(false, true, grammarAccess.getCountAccess().getCommaKeyword_3_0());
		match_HttpClientOutcome___LeftParenthesisKeyword_2_0_RightParenthesisKeyword_2_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getHttpClientOutcomeAccess().getLeftParenthesisKeyword_2_0()), new TokenAlias(false, false, grammarAccess.getHttpClientOutcomeAccess().getRightParenthesisKeyword_2_2()));
		match_HttpClientOutcome___TriggersKeyword_3_0_LeftParenthesisKeyword_3_1_RightParenthesisKeyword_3_3__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getHttpClientOutcomeAccess().getTriggersKeyword_3_0()), new TokenAlias(false, false, grammarAccess.getHttpClientOutcomeAccess().getLeftParenthesisKeyword_3_1()), new TokenAlias(false, false, grammarAccess.getHttpClientOutcomeAccess().getRightParenthesisKeyword_3_3()));
		match_HttpClient_ACEKeyword_1_0_q = new TokenAlias(false, true, grammarAccess.getHttpClientAccess().getACEKeyword_1_0());
		match_HttpClient_ScenariosKeyword_3_0_q = new TokenAlias(false, true, grammarAccess.getHttpClientAccess().getScenariosKeyword_3_0());
		match_HttpServerAceRead_PathParamsKeyword_7_0_q = new TokenAlias(false, true, grammarAccess.getHttpServerAceReadAccess().getPathParamsKeyword_7_0());
		match_HttpServerAceRead_PayloadKeyword_9_0_q = new TokenAlias(false, true, grammarAccess.getHttpServerAceReadAccess().getPayloadKeyword_9_0());
		match_HttpServerAceRead_QueryParamsKeyword_8_0_q = new TokenAlias(false, true, grammarAccess.getHttpServerAceReadAccess().getQueryParamsKeyword_8_0());
		match_HttpServerAceRead_ResponseKeyword_10_0_q = new TokenAlias(false, true, grammarAccess.getHttpServerAceReadAccess().getResponseKeyword_10_0());
		match_HttpServerAceWrite_PathParamsKeyword_7_0_q = new TokenAlias(false, true, grammarAccess.getHttpServerAceWriteAccess().getPathParamsKeyword_7_0());
		match_HttpServerAceWrite_PayloadKeyword_9_0_q = new TokenAlias(false, true, grammarAccess.getHttpServerAceWriteAccess().getPayloadKeyword_9_0());
		match_HttpServerAceWrite_QueryParamsKeyword_8_0_q = new TokenAlias(false, true, grammarAccess.getHttpServerAceWriteAccess().getQueryParamsKeyword_8_0());
		match_HttpServerAceWrite_ResponseKeyword_10_0_q = new TokenAlias(false, true, grammarAccess.getHttpServerAceWriteAccess().getResponseKeyword_10_0());
		match_HttpServerOutcome___LeftParenthesisKeyword_2_0_RightParenthesisKeyword_2_2__a = new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getHttpServerOutcomeAccess().getLeftParenthesisKeyword_2_0()), new TokenAlias(false, false, grammarAccess.getHttpServerOutcomeAccess().getRightParenthesisKeyword_2_2()));
		match_HttpServerOutcome___RightParenthesisKeyword_2_2_LeftParenthesisKeyword_2_0__a = new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getHttpServerOutcomeAccess().getRightParenthesisKeyword_2_2()), new TokenAlias(false, false, grammarAccess.getHttpServerOutcomeAccess().getLeftParenthesisKeyword_2_0()));
		match_HttpServerView___LeftCurlyBracketKeyword_2_0_RightCurlyBracketKeyword_2_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getHttpServerViewAccess().getLeftCurlyBracketKeyword_2_0()), new TokenAlias(false, false, grammarAccess.getHttpServerViewAccess().getRightCurlyBracketKeyword_2_2()));
		match_HttpServer_ACEKeyword_7_0_q = new TokenAlias(false, true, grammarAccess.getHttpServerAccess().getACEKeyword_7_0());
		match_HttpServer_ModelsKeyword_9_0_q = new TokenAlias(false, true, grammarAccess.getHttpServerAccess().getModelsKeyword_9_0());
		match_HttpServer_ScenariosKeyword_10_0_q = new TokenAlias(false, true, grammarAccess.getHttpServerAccess().getScenariosKeyword_10_0());
		match_HttpServer_ViewsKeyword_8_0_q = new TokenAlias(false, true, grammarAccess.getHttpServerAccess().getViewsKeyword_8_0());
		match_JsonObject_JsonKeyword_1_0_q = new TokenAlias(false, true, grammarAccess.getJsonObjectAccess().getJsonKeyword_1_0());
		match_Model___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_3_0()), new TokenAlias(false, false, grammarAccess.getModelAccess().getRightCurlyBracketKeyword_3_2()));
		match_Project___HttpClientKeyword_1_0_0_or_HttpServerKeyword_1_1_0__q = new AlternativeAlias(false, true, new TokenAlias(false, false, grammarAccess.getProjectAccess().getHttpClientKeyword_1_0_0()), new TokenAlias(false, false, grammarAccess.getProjectAccess().getHttpServerKeyword_1_1_0()));
		match_Scenario_GIVENKeyword_1_0_q = new TokenAlias(false, true, grammarAccess.getScenarioAccess().getGIVENKeyword_1_0());
		match_SelectByPrimaryKeys_CommaKeyword_3_0_q = new TokenAlias(false, true, grammarAccess.getSelectByPrimaryKeysAccess().getCommaKeyword_3_0());
		match_SingleClientAttribute___LeftCurlyBracketKeyword_5_0_RightCurlyBracketKeyword_5_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getSingleClientAttributeAccess().getLeftCurlyBracketKeyword_5_0()), new TokenAlias(false, false, grammarAccess.getSingleClientAttributeAccess().getRightCurlyBracketKeyword_5_2()));
		match_ThenBlock_PersistenceKeyword_2_0_q = new TokenAlias(false, true, grammarAccess.getThenBlockAccess().getPersistenceKeyword_2_0());
		match_ThenBlock_VerificationsKeyword_3_0_q = new TokenAlias(false, true, grammarAccess.getThenBlockAccess().getVerificationsKeyword_3_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_ClientScenario_GIVENKeyword_1_0_q.equals(syntax))
				emit_ClientScenario_GIVENKeyword_1_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ClientThenBlock_ExpectedStateKeyword_1_0_q.equals(syntax))
				emit_ClientThenBlock_ExpectedStateKeyword_1_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ClientThenBlock_VerificationsKeyword_2_0_q.equals(syntax))
				emit_ClientThenBlock_VerificationsKeyword_2_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ClientWhenBlock___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q.equals(syntax))
				emit_ClientWhenBlock___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Count_CommaKeyword_3_0_q.equals(syntax))
				emit_Count_CommaKeyword_3_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_HttpClientOutcome___LeftParenthesisKeyword_2_0_RightParenthesisKeyword_2_2__q.equals(syntax))
				emit_HttpClientOutcome___LeftParenthesisKeyword_2_0_RightParenthesisKeyword_2_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_HttpClientOutcome___TriggersKeyword_3_0_LeftParenthesisKeyword_3_1_RightParenthesisKeyword_3_3__q.equals(syntax))
				emit_HttpClientOutcome___TriggersKeyword_3_0_LeftParenthesisKeyword_3_1_RightParenthesisKeyword_3_3__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_HttpClient_ACEKeyword_1_0_q.equals(syntax))
				emit_HttpClient_ACEKeyword_1_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_HttpClient_ScenariosKeyword_3_0_q.equals(syntax))
				emit_HttpClient_ScenariosKeyword_3_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_HttpServerAceRead_PathParamsKeyword_7_0_q.equals(syntax))
				emit_HttpServerAceRead_PathParamsKeyword_7_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_HttpServerAceRead_PayloadKeyword_9_0_q.equals(syntax))
				emit_HttpServerAceRead_PayloadKeyword_9_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_HttpServerAceRead_QueryParamsKeyword_8_0_q.equals(syntax))
				emit_HttpServerAceRead_QueryParamsKeyword_8_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_HttpServerAceRead_ResponseKeyword_10_0_q.equals(syntax))
				emit_HttpServerAceRead_ResponseKeyword_10_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_HttpServerAceWrite_PathParamsKeyword_7_0_q.equals(syntax))
				emit_HttpServerAceWrite_PathParamsKeyword_7_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_HttpServerAceWrite_PayloadKeyword_9_0_q.equals(syntax))
				emit_HttpServerAceWrite_PayloadKeyword_9_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_HttpServerAceWrite_QueryParamsKeyword_8_0_q.equals(syntax))
				emit_HttpServerAceWrite_QueryParamsKeyword_8_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_HttpServerAceWrite_ResponseKeyword_10_0_q.equals(syntax))
				emit_HttpServerAceWrite_ResponseKeyword_10_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_HttpServerOutcome___LeftParenthesisKeyword_2_0_RightParenthesisKeyword_2_2__a.equals(syntax))
				emit_HttpServerOutcome___LeftParenthesisKeyword_2_0_RightParenthesisKeyword_2_2__a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_HttpServerOutcome___RightParenthesisKeyword_2_2_LeftParenthesisKeyword_2_0__a.equals(syntax))
				emit_HttpServerOutcome___RightParenthesisKeyword_2_2_LeftParenthesisKeyword_2_0__a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_HttpServerView___LeftCurlyBracketKeyword_2_0_RightCurlyBracketKeyword_2_2__q.equals(syntax))
				emit_HttpServerView___LeftCurlyBracketKeyword_2_0_RightCurlyBracketKeyword_2_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_HttpServer_ACEKeyword_7_0_q.equals(syntax))
				emit_HttpServer_ACEKeyword_7_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_HttpServer_ModelsKeyword_9_0_q.equals(syntax))
				emit_HttpServer_ModelsKeyword_9_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_HttpServer_ScenariosKeyword_10_0_q.equals(syntax))
				emit_HttpServer_ScenariosKeyword_10_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_HttpServer_ViewsKeyword_8_0_q.equals(syntax))
				emit_HttpServer_ViewsKeyword_8_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_JsonObject_JsonKeyword_1_0_q.equals(syntax))
				emit_JsonObject_JsonKeyword_1_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Model___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_2__q.equals(syntax))
				emit_Model___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Project___HttpClientKeyword_1_0_0_or_HttpServerKeyword_1_1_0__q.equals(syntax))
				emit_Project___HttpClientKeyword_1_0_0_or_HttpServerKeyword_1_1_0__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Scenario_GIVENKeyword_1_0_q.equals(syntax))
				emit_Scenario_GIVENKeyword_1_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_SelectByPrimaryKeys_CommaKeyword_3_0_q.equals(syntax))
				emit_SelectByPrimaryKeys_CommaKeyword_3_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_SingleClientAttribute___LeftCurlyBracketKeyword_5_0_RightCurlyBracketKeyword_5_2__q.equals(syntax))
				emit_SingleClientAttribute___LeftCurlyBracketKeyword_5_0_RightCurlyBracketKeyword_5_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ThenBlock_PersistenceKeyword_2_0_q.equals(syntax))
				emit_ThenBlock_PersistenceKeyword_2_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ThenBlock_VerificationsKeyword_3_0_q.equals(syntax))
				emit_ThenBlock_VerificationsKeyword_3_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     'GIVEN'?
	 *
	 * This ambiguous syntax occurs at:
	 *     name=ID (ambiguity) 'WHEN' 'THEN' thenBlock=ClientThenBlock
	 *     name=ID (ambiguity) 'WHEN' 'delayInMillis' delayInMillis=INT
	 *     name=ID (ambiguity) 'WHEN' whenBlock=ClientWhenBlock
	 */
	protected void emit_ClientScenario_GIVENKeyword_1_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'expectedState'?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) 'verifications' verifications+=ID
	 *     (rule start) (ambiguity) 'verifications'? (rule start)
	 */
	protected void emit_ClientThenBlock_ExpectedStateKeyword_1_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'verifications'?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) 'expectedState'? (ambiguity) (rule start)
	 *     stateVerifications+=StateVerification (ambiguity) (rule end)
	 */
	protected void emit_ClientThenBlock_VerificationsKeyword_2_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('(' ')')?
	 *
	 * This ambiguous syntax occurs at:
	 *     action=[HttpClientAce|QualifiedName] (ambiguity) 'squishyValues' squishyValues+=SquishyValue
	 *     action=[HttpClientAce|QualifiedName] (ambiguity) (rule end)
	 */
	protected void emit_ClientWhenBlock___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ','?
	 *
	 * This ambiguous syntax occurs at:
	 *     attributeAndValues+=AttributeAndValue (ambiguity) ')' 'shouldBe' expected=INT
	 */
	protected void emit_Count_CommaKeyword_3_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('(' ')')?
	 *
	 * This ambiguous syntax occurs at:
	 *     name=ID (ambiguity) 'triggers' '(' triggerdAceOperations+=TriggerdAceOperation
	 *     name=ID (ambiguity) ('triggers' '(' ')')? (rule end)
	 */
	protected void emit_HttpClientOutcome___LeftParenthesisKeyword_2_0_RightParenthesisKeyword_2_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('triggers' '(' ')')?
	 *
	 * This ambiguous syntax occurs at:
	 *     listeners+=HttpClientStateFunction ')' (ambiguity) (rule end)
	 *     name=ID ('(' ')')? (ambiguity) (rule end)
	 */
	protected void emit_HttpClientOutcome___TriggersKeyword_3_0_LeftParenthesisKeyword_3_1_RightParenthesisKeyword_3_3__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'ACE'?
	 *
	 * This ambiguous syntax occurs at:
	 *     name=QualifiedName (ambiguity) 'scenarios' scenarios+=ClientScenario
	 *     name=QualifiedName (ambiguity) 'scenarios'? (rule end)
	 *     name=QualifiedName (ambiguity) 'ui' container=SingleClientAttribute
	 *     name=QualifiedName (ambiguity) 'ui' react16_8?='React_16.8'
	 */
	protected void emit_HttpClient_ACEKeyword_1_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'scenarios'?
	 *
	 * This ambiguous syntax occurs at:
	 *     aceOperations+=HttpClientAce (ambiguity) (rule end)
	 *     container=SingleClientAttribute (ambiguity) (rule end)
	 *     name=QualifiedName 'ACE'? (ambiguity) (rule end)
	 */
	protected void emit_HttpClient_ScenariosKeyword_3_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'pathParams'?
	 *
	 * This ambiguous syntax occurs at:
	 *     authorize?='authorize' (ambiguity) 'queryParams' queryParams+=AttributeParamRef
	 *     authorize?='authorize' (ambiguity) 'queryParams'? 'payload' payload+=AttributeParamRef
	 *     authorize?='authorize' (ambiguity) 'queryParams'? 'payload'? 'response' response+=[Attribute|QualifiedName]
	 *     authorize?='authorize' (ambiguity) 'queryParams'? 'payload'? 'response'? (rule end)
	 *     url=STRING (ambiguity) 'queryParams' queryParams+=AttributeParamRef
	 *     url=STRING (ambiguity) 'queryParams'? 'payload' payload+=AttributeParamRef
	 *     url=STRING (ambiguity) 'queryParams'? 'payload'? 'response' response+=[Attribute|QualifiedName]
	 *     url=STRING (ambiguity) 'queryParams'? 'payload'? 'response'? (rule end)
	 */
	protected void emit_HttpServerAceRead_PathParamsKeyword_7_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'payload'?
	 *
	 * This ambiguous syntax occurs at:
	 *     authorize?='authorize' 'pathParams'? 'queryParams'? (ambiguity) 'response' response+=[Attribute|QualifiedName]
	 *     authorize?='authorize' 'pathParams'? 'queryParams'? (ambiguity) 'response'? (rule end)
	 *     pathParams+=AttributeParamRef 'queryParams'? (ambiguity) 'response' response+=[Attribute|QualifiedName]
	 *     pathParams+=AttributeParamRef 'queryParams'? (ambiguity) 'response'? (rule end)
	 *     queryParams+=AttributeParamRef (ambiguity) 'response' response+=[Attribute|QualifiedName]
	 *     queryParams+=AttributeParamRef (ambiguity) 'response'? (rule end)
	 *     url=STRING 'pathParams'? 'queryParams'? (ambiguity) 'response' response+=[Attribute|QualifiedName]
	 *     url=STRING 'pathParams'? 'queryParams'? (ambiguity) 'response'? (rule end)
	 */
	protected void emit_HttpServerAceRead_PayloadKeyword_9_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'queryParams'?
	 *
	 * This ambiguous syntax occurs at:
	 *     authorize?='authorize' 'pathParams'? (ambiguity) 'payload' payload+=AttributeParamRef
	 *     authorize?='authorize' 'pathParams'? (ambiguity) 'payload'? 'response' response+=[Attribute|QualifiedName]
	 *     authorize?='authorize' 'pathParams'? (ambiguity) 'payload'? 'response'? (rule end)
	 *     pathParams+=AttributeParamRef (ambiguity) 'payload' payload+=AttributeParamRef
	 *     pathParams+=AttributeParamRef (ambiguity) 'payload'? 'response' response+=[Attribute|QualifiedName]
	 *     pathParams+=AttributeParamRef (ambiguity) 'payload'? 'response'? (rule end)
	 *     url=STRING 'pathParams'? (ambiguity) 'payload' payload+=AttributeParamRef
	 *     url=STRING 'pathParams'? (ambiguity) 'payload'? 'response' response+=[Attribute|QualifiedName]
	 *     url=STRING 'pathParams'? (ambiguity) 'payload'? 'response'? (rule end)
	 */
	protected void emit_HttpServerAceRead_QueryParamsKeyword_8_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'response'?
	 *
	 * This ambiguous syntax occurs at:
	 *     authorize?='authorize' 'pathParams'? 'queryParams'? 'payload'? (ambiguity) (rule end)
	 *     pathParams+=AttributeParamRef 'queryParams'? 'payload'? (ambiguity) (rule end)
	 *     payload+=AttributeParamRef (ambiguity) (rule end)
	 *     queryParams+=AttributeParamRef 'payload'? (ambiguity) (rule end)
	 *     url=STRING 'pathParams'? 'queryParams'? 'payload'? (ambiguity) (rule end)
	 */
	protected void emit_HttpServerAceRead_ResponseKeyword_10_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'pathParams'?
	 *
	 * This ambiguous syntax occurs at:
	 *     authorize?='authorize' (ambiguity) 'queryParams' queryParams+=AttributeParamRef
	 *     authorize?='authorize' (ambiguity) 'queryParams'? 'payload' payload+=AttributeParamRef
	 *     authorize?='authorize' (ambiguity) 'queryParams'? 'payload'? 'response' response+=[Attribute|QualifiedName]
	 *     authorize?='authorize' (ambiguity) 'queryParams'? 'payload'? 'response'? (rule end)
	 *     authorize?='authorize' (ambiguity) 'queryParams'? 'payload'? 'response'? outcomes+=HttpServerOutcome
	 *     url=STRING (ambiguity) 'queryParams' queryParams+=AttributeParamRef
	 *     url=STRING (ambiguity) 'queryParams'? 'payload' payload+=AttributeParamRef
	 *     url=STRING (ambiguity) 'queryParams'? 'payload'? 'response' response+=[Attribute|QualifiedName]
	 *     url=STRING (ambiguity) 'queryParams'? 'payload'? 'response'? (rule end)
	 *     url=STRING (ambiguity) 'queryParams'? 'payload'? 'response'? outcomes+=HttpServerOutcome
	 */
	protected void emit_HttpServerAceWrite_PathParamsKeyword_7_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'payload'?
	 *
	 * This ambiguous syntax occurs at:
	 *     authorize?='authorize' 'pathParams'? 'queryParams'? (ambiguity) 'response' response+=[Attribute|QualifiedName]
	 *     authorize?='authorize' 'pathParams'? 'queryParams'? (ambiguity) 'response'? (rule end)
	 *     authorize?='authorize' 'pathParams'? 'queryParams'? (ambiguity) 'response'? outcomes+=HttpServerOutcome
	 *     pathParams+=AttributeParamRef 'queryParams'? (ambiguity) 'response' response+=[Attribute|QualifiedName]
	 *     pathParams+=AttributeParamRef 'queryParams'? (ambiguity) 'response'? (rule end)
	 *     pathParams+=AttributeParamRef 'queryParams'? (ambiguity) 'response'? outcomes+=HttpServerOutcome
	 *     queryParams+=AttributeParamRef (ambiguity) 'response' response+=[Attribute|QualifiedName]
	 *     queryParams+=AttributeParamRef (ambiguity) 'response'? (rule end)
	 *     queryParams+=AttributeParamRef (ambiguity) 'response'? outcomes+=HttpServerOutcome
	 *     url=STRING 'pathParams'? 'queryParams'? (ambiguity) 'response' response+=[Attribute|QualifiedName]
	 *     url=STRING 'pathParams'? 'queryParams'? (ambiguity) 'response'? (rule end)
	 *     url=STRING 'pathParams'? 'queryParams'? (ambiguity) 'response'? outcomes+=HttpServerOutcome
	 */
	protected void emit_HttpServerAceWrite_PayloadKeyword_9_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'queryParams'?
	 *
	 * This ambiguous syntax occurs at:
	 *     authorize?='authorize' 'pathParams'? (ambiguity) 'payload' payload+=AttributeParamRef
	 *     authorize?='authorize' 'pathParams'? (ambiguity) 'payload'? 'response' response+=[Attribute|QualifiedName]
	 *     authorize?='authorize' 'pathParams'? (ambiguity) 'payload'? 'response'? (rule end)
	 *     authorize?='authorize' 'pathParams'? (ambiguity) 'payload'? 'response'? outcomes+=HttpServerOutcome
	 *     pathParams+=AttributeParamRef (ambiguity) 'payload' payload+=AttributeParamRef
	 *     pathParams+=AttributeParamRef (ambiguity) 'payload'? 'response' response+=[Attribute|QualifiedName]
	 *     pathParams+=AttributeParamRef (ambiguity) 'payload'? 'response'? (rule end)
	 *     pathParams+=AttributeParamRef (ambiguity) 'payload'? 'response'? outcomes+=HttpServerOutcome
	 *     url=STRING 'pathParams'? (ambiguity) 'payload' payload+=AttributeParamRef
	 *     url=STRING 'pathParams'? (ambiguity) 'payload'? 'response' response+=[Attribute|QualifiedName]
	 *     url=STRING 'pathParams'? (ambiguity) 'payload'? 'response'? (rule end)
	 *     url=STRING 'pathParams'? (ambiguity) 'payload'? 'response'? outcomes+=HttpServerOutcome
	 */
	protected void emit_HttpServerAceWrite_QueryParamsKeyword_8_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'response'?
	 *
	 * This ambiguous syntax occurs at:
	 *     authorize?='authorize' 'pathParams'? 'queryParams'? 'payload'? (ambiguity) (rule end)
	 *     authorize?='authorize' 'pathParams'? 'queryParams'? 'payload'? (ambiguity) outcomes+=HttpServerOutcome
	 *     pathParams+=AttributeParamRef 'queryParams'? 'payload'? (ambiguity) (rule end)
	 *     pathParams+=AttributeParamRef 'queryParams'? 'payload'? (ambiguity) outcomes+=HttpServerOutcome
	 *     payload+=AttributeParamRef (ambiguity) (rule end)
	 *     payload+=AttributeParamRef (ambiguity) outcomes+=HttpServerOutcome
	 *     queryParams+=AttributeParamRef 'payload'? (ambiguity) (rule end)
	 *     queryParams+=AttributeParamRef 'payload'? (ambiguity) outcomes+=HttpServerOutcome
	 *     url=STRING 'pathParams'? 'queryParams'? 'payload'? (ambiguity) (rule end)
	 *     url=STRING 'pathParams'? 'queryParams'? 'payload'? (ambiguity) outcomes+=HttpServerOutcome
	 */
	protected void emit_HttpServerAceWrite_ResponseKeyword_10_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('(' ')')*
	 *
	 * This ambiguous syntax occurs at:
	 *     listeners+=[HttpServerViewFunction|QualifiedName] ')' (ambiguity) (rule end)
	 *     name=ID (ambiguity) (rule end)
	 */
	protected void emit_HttpServerOutcome___LeftParenthesisKeyword_2_0_RightParenthesisKeyword_2_2__a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (')' '(')*
	 *
	 * This ambiguous syntax occurs at:
	 *     listeners+=[HttpServerViewFunction|QualifiedName] (ambiguity) listeners+=[HttpServerViewFunction|QualifiedName]
	 *     name=ID '(' (ambiguity) listeners+=[HttpServerViewFunction|QualifiedName]
	 */
	protected void emit_HttpServerOutcome___RightParenthesisKeyword_2_2_LeftParenthesisKeyword_2_0__a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('{' '}')?
	 *
	 * This ambiguous syntax occurs at:
	 *     name=ID (ambiguity) (rule end)
	 */
	protected void emit_HttpServerView___LeftCurlyBracketKeyword_2_0_RightCurlyBracketKeyword_2_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'ACE'?
	 *
	 * This ambiguous syntax occurs at:
	 *     authUser=AuthUser (ambiguity) 'views' views+=HttpServerView
	 *     authUser=AuthUser (ambiguity) 'views'? 'models' models+=Model
	 *     authUser=AuthUser (ambiguity) 'views'? 'models'? 'scenarios' scenarios+=Scenario
	 *     authUser=AuthUser (ambiguity) 'views'? 'models'? 'scenarios'? (rule end)
	 *     authUserRef=[AuthUser|QualifiedName] (ambiguity) 'views' views+=HttpServerView
	 *     authUserRef=[AuthUser|QualifiedName] (ambiguity) 'views'? 'models' models+=Model
	 *     authUserRef=[AuthUser|QualifiedName] (ambiguity) 'views'? 'models'? 'scenarios' scenarios+=Scenario
	 *     authUserRef=[AuthUser|QualifiedName] (ambiguity) 'views'? 'models'? 'scenarios'? (rule end)
	 *     name=QualifiedName (ambiguity) 'views' views+=HttpServerView
	 *     name=QualifiedName (ambiguity) 'views'? 'models' models+=Model
	 *     name=QualifiedName (ambiguity) 'views'? 'models'? 'scenarios' scenarios+=Scenario
	 *     name=QualifiedName (ambiguity) 'views'? 'models'? 'scenarios'? (rule end)
	 */
	protected void emit_HttpServer_ACEKeyword_7_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'models'?
	 *
	 * This ambiguous syntax occurs at:
	 *     aceOperations+=HttpServerAce 'views'? (ambiguity) 'scenarios' scenarios+=Scenario
	 *     aceOperations+=HttpServerAce 'views'? (ambiguity) 'scenarios'? (rule end)
	 *     authUser=AuthUser 'ACE'? 'views'? (ambiguity) 'scenarios' scenarios+=Scenario
	 *     authUser=AuthUser 'ACE'? 'views'? (ambiguity) 'scenarios'? (rule end)
	 *     authUserRef=[AuthUser|QualifiedName] 'ACE'? 'views'? (ambiguity) 'scenarios' scenarios+=Scenario
	 *     authUserRef=[AuthUser|QualifiedName] 'ACE'? 'views'? (ambiguity) 'scenarios'? (rule end)
	 *     name=QualifiedName 'ACE'? 'views'? (ambiguity) 'scenarios' scenarios+=Scenario
	 *     name=QualifiedName 'ACE'? 'views'? (ambiguity) 'scenarios'? (rule end)
	 *     views+=HttpServerView (ambiguity) 'scenarios' scenarios+=Scenario
	 *     views+=HttpServerView (ambiguity) 'scenarios'? (rule end)
	 */
	protected void emit_HttpServer_ModelsKeyword_9_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'scenarios'?
	 *
	 * This ambiguous syntax occurs at:
	 *     aceOperations+=HttpServerAce 'views'? 'models'? (ambiguity) (rule end)
	 *     authUser=AuthUser 'ACE'? 'views'? 'models'? (ambiguity) (rule end)
	 *     authUserRef=[AuthUser|QualifiedName] 'ACE'? 'views'? 'models'? (ambiguity) (rule end)
	 *     models+=Model (ambiguity) (rule end)
	 *     name=QualifiedName 'ACE'? 'views'? 'models'? (ambiguity) (rule end)
	 *     views+=HttpServerView 'models'? (ambiguity) (rule end)
	 */
	protected void emit_HttpServer_ScenariosKeyword_10_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'views'?
	 *
	 * This ambiguous syntax occurs at:
	 *     aceOperations+=HttpServerAce (ambiguity) 'models' models+=Model
	 *     aceOperations+=HttpServerAce (ambiguity) 'models'? 'scenarios' scenarios+=Scenario
	 *     aceOperations+=HttpServerAce (ambiguity) 'models'? 'scenarios'? (rule end)
	 *     authUser=AuthUser 'ACE'? (ambiguity) 'models' models+=Model
	 *     authUser=AuthUser 'ACE'? (ambiguity) 'models'? 'scenarios' scenarios+=Scenario
	 *     authUser=AuthUser 'ACE'? (ambiguity) 'models'? 'scenarios'? (rule end)
	 *     authUserRef=[AuthUser|QualifiedName] 'ACE'? (ambiguity) 'models' models+=Model
	 *     authUserRef=[AuthUser|QualifiedName] 'ACE'? (ambiguity) 'models'? 'scenarios' scenarios+=Scenario
	 *     authUserRef=[AuthUser|QualifiedName] 'ACE'? (ambiguity) 'models'? 'scenarios'? (rule end)
	 *     name=QualifiedName 'ACE'? (ambiguity) 'models' models+=Model
	 *     name=QualifiedName 'ACE'? (ambiguity) 'models'? 'scenarios' scenarios+=Scenario
	 *     name=QualifiedName 'ACE'? (ambiguity) 'models'? 'scenarios'? (rule end)
	 */
	protected void emit_HttpServer_ViewsKeyword_8_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'json'?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) string=STRING
	 */
	protected void emit_JsonObject_JsonKeyword_1_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('{' '}')?
	 *
	 * This ambiguous syntax occurs at:
	 *     name=ID (ambiguity) (rule end)
	 *     superModels+=[Model|QualifiedName] (ambiguity) (rule end)
	 */
	protected void emit_Model___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('HttpClient' | 'HttpServer')?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) (rule start)
	 */
	protected void emit_Project___HttpClientKeyword_1_0_0_or_HttpServerKeyword_1_1_0__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'GIVEN'?
	 *
	 * This ambiguous syntax occurs at:
	 *     name=ID (ambiguity) 'WHEN' whenBlock=WhenBlock
	 */
	protected void emit_Scenario_GIVENKeyword_1_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ','?
	 *
	 * This ambiguous syntax occurs at:
	 *     attributeAndValues+=AttributeAndValue (ambiguity) ')' 'shouldBe' expected=SelectByExpectation
	 */
	protected void emit_SelectByPrimaryKeys_CommaKeyword_3_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('{' '}')?
	 *
	 * This ambiguous syntax occurs at:
	 *     hash?='location.hash' (ambiguity) (rule end)
	 *     name=ID (ambiguity) (rule end)
	 *     storage?='storage' (ambiguity) (rule end)
	 */
	protected void emit_SingleClientAttribute___LeftCurlyBracketKeyword_5_0_RightCurlyBracketKeyword_5_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'persistence'?
	 *
	 * This ambiguous syntax occurs at:
	 *     response=DataDefinition (ambiguity) 'verifications' verifications+=Verification
	 *     response=DataDefinition (ambiguity) 'verifications'? (rule end)
	 *     statusCode=INT (ambiguity) 'verifications' verifications+=Verification
	 *     statusCode=INT (ambiguity) 'verifications'? (rule end)
	 */
	protected void emit_ThenBlock_PersistenceKeyword_2_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'verifications'?
	 *
	 * This ambiguous syntax occurs at:
	 *     persistenceVerifications+=PersistenceVerification (ambiguity) (rule end)
	 *     response=DataDefinition 'persistence'? (ambiguity) (rule end)
	 *     statusCode=INT 'persistence'? (ambiguity) (rule end)
	 */
	protected void emit_ThenBlock_VerificationsKeyword_3_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
