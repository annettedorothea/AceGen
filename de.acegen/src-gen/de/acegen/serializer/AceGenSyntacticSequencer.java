/*
 * generated by Xtext 2.14.0
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
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class AceGenSyntacticSequencer extends AbstractSyntacticSequencer {

	protected AceGenGrammarAccess grammarAccess;
	protected AbstractElementAlias match_HttpClientOutcome___LeftParenthesisKeyword_2_0_RightParenthesisKeyword_2_2__q;
	protected AbstractElementAlias match_HttpClientOutcome___TriggersKeyword_3_0_LeftParenthesisKeyword_3_1_RightParenthesisKeyword_3_3__q;
	protected AbstractElementAlias match_HttpClient_ACEKeyword_1_0_q;
	protected AbstractElementAlias match_HttpServerAceRead_PathParamsKeyword_8_0_q;
	protected AbstractElementAlias match_HttpServerAceRead_PayloadKeyword_10_0_q;
	protected AbstractElementAlias match_HttpServerAceRead_QueryParamsKeyword_9_0_q;
	protected AbstractElementAlias match_HttpServerAceRead_ResponseKeyword_11_0_q;
	protected AbstractElementAlias match_HttpServerAceWrite_PathParamsKeyword_8_0_q;
	protected AbstractElementAlias match_HttpServerAceWrite_PayloadKeyword_10_0_q;
	protected AbstractElementAlias match_HttpServerAceWrite_QueryParamsKeyword_9_0_q;
	protected AbstractElementAlias match_HttpServerAceWrite_ResponseKeyword_11_0_q;
	protected AbstractElementAlias match_HttpServerOutcome___LeftParenthesisKeyword_2_0_RightParenthesisKeyword_2_2__a;
	protected AbstractElementAlias match_HttpServerOutcome___RightParenthesisKeyword_2_2_LeftParenthesisKeyword_2_0__a;
	protected AbstractElementAlias match_HttpServerOutcome___TriggersKeyword_3_0_LeftParenthesisKeyword_3_1_RightParenthesisKeyword_3_3__q;
	protected AbstractElementAlias match_HttpServerView___LeftCurlyBracketKeyword_1_0_RightCurlyBracketKeyword_1_2__q;
	protected AbstractElementAlias match_HttpServer_ACEKeyword_3_0_q;
	protected AbstractElementAlias match_HttpServer_ModelsKeyword_5_0_q;
	protected AbstractElementAlias match_HttpServer_ViewsKeyword_4_0_q;
	protected AbstractElementAlias match_Model___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_2__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (AceGenGrammarAccess) access;
		match_HttpClientOutcome___LeftParenthesisKeyword_2_0_RightParenthesisKeyword_2_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getHttpClientOutcomeAccess().getLeftParenthesisKeyword_2_0()), new TokenAlias(false, false, grammarAccess.getHttpClientOutcomeAccess().getRightParenthesisKeyword_2_2()));
		match_HttpClientOutcome___TriggersKeyword_3_0_LeftParenthesisKeyword_3_1_RightParenthesisKeyword_3_3__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getHttpClientOutcomeAccess().getTriggersKeyword_3_0()), new TokenAlias(false, false, grammarAccess.getHttpClientOutcomeAccess().getLeftParenthesisKeyword_3_1()), new TokenAlias(false, false, grammarAccess.getHttpClientOutcomeAccess().getRightParenthesisKeyword_3_3()));
		match_HttpClient_ACEKeyword_1_0_q = new TokenAlias(false, true, grammarAccess.getHttpClientAccess().getACEKeyword_1_0());
		match_HttpServerAceRead_PathParamsKeyword_8_0_q = new TokenAlias(false, true, grammarAccess.getHttpServerAceReadAccess().getPathParamsKeyword_8_0());
		match_HttpServerAceRead_PayloadKeyword_10_0_q = new TokenAlias(false, true, grammarAccess.getHttpServerAceReadAccess().getPayloadKeyword_10_0());
		match_HttpServerAceRead_QueryParamsKeyword_9_0_q = new TokenAlias(false, true, grammarAccess.getHttpServerAceReadAccess().getQueryParamsKeyword_9_0());
		match_HttpServerAceRead_ResponseKeyword_11_0_q = new TokenAlias(false, true, grammarAccess.getHttpServerAceReadAccess().getResponseKeyword_11_0());
		match_HttpServerAceWrite_PathParamsKeyword_8_0_q = new TokenAlias(false, true, grammarAccess.getHttpServerAceWriteAccess().getPathParamsKeyword_8_0());
		match_HttpServerAceWrite_PayloadKeyword_10_0_q = new TokenAlias(false, true, grammarAccess.getHttpServerAceWriteAccess().getPayloadKeyword_10_0());
		match_HttpServerAceWrite_QueryParamsKeyword_9_0_q = new TokenAlias(false, true, grammarAccess.getHttpServerAceWriteAccess().getQueryParamsKeyword_9_0());
		match_HttpServerAceWrite_ResponseKeyword_11_0_q = new TokenAlias(false, true, grammarAccess.getHttpServerAceWriteAccess().getResponseKeyword_11_0());
		match_HttpServerOutcome___LeftParenthesisKeyword_2_0_RightParenthesisKeyword_2_2__a = new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getHttpServerOutcomeAccess().getLeftParenthesisKeyword_2_0()), new TokenAlias(false, false, grammarAccess.getHttpServerOutcomeAccess().getRightParenthesisKeyword_2_2()));
		match_HttpServerOutcome___RightParenthesisKeyword_2_2_LeftParenthesisKeyword_2_0__a = new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getHttpServerOutcomeAccess().getRightParenthesisKeyword_2_2()), new TokenAlias(false, false, grammarAccess.getHttpServerOutcomeAccess().getLeftParenthesisKeyword_2_0()));
		match_HttpServerOutcome___TriggersKeyword_3_0_LeftParenthesisKeyword_3_1_RightParenthesisKeyword_3_3__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getHttpServerOutcomeAccess().getTriggersKeyword_3_0()), new TokenAlias(false, false, grammarAccess.getHttpServerOutcomeAccess().getLeftParenthesisKeyword_3_1()), new TokenAlias(false, false, grammarAccess.getHttpServerOutcomeAccess().getRightParenthesisKeyword_3_3()));
		match_HttpServerView___LeftCurlyBracketKeyword_1_0_RightCurlyBracketKeyword_1_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getHttpServerViewAccess().getLeftCurlyBracketKeyword_1_0()), new TokenAlias(false, false, grammarAccess.getHttpServerViewAccess().getRightCurlyBracketKeyword_1_2()));
		match_HttpServer_ACEKeyword_3_0_q = new TokenAlias(false, true, grammarAccess.getHttpServerAccess().getACEKeyword_3_0());
		match_HttpServer_ModelsKeyword_5_0_q = new TokenAlias(false, true, grammarAccess.getHttpServerAccess().getModelsKeyword_5_0());
		match_HttpServer_ViewsKeyword_4_0_q = new TokenAlias(false, true, grammarAccess.getHttpServerAccess().getViewsKeyword_4_0());
		match_Model___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_3_0()), new TokenAlias(false, false, grammarAccess.getModelAccess().getRightCurlyBracketKeyword_3_2()));
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
			if (match_HttpClientOutcome___LeftParenthesisKeyword_2_0_RightParenthesisKeyword_2_2__q.equals(syntax))
				emit_HttpClientOutcome___LeftParenthesisKeyword_2_0_RightParenthesisKeyword_2_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_HttpClientOutcome___TriggersKeyword_3_0_LeftParenthesisKeyword_3_1_RightParenthesisKeyword_3_3__q.equals(syntax))
				emit_HttpClientOutcome___TriggersKeyword_3_0_LeftParenthesisKeyword_3_1_RightParenthesisKeyword_3_3__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_HttpClient_ACEKeyword_1_0_q.equals(syntax))
				emit_HttpClient_ACEKeyword_1_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_HttpServerAceRead_PathParamsKeyword_8_0_q.equals(syntax))
				emit_HttpServerAceRead_PathParamsKeyword_8_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_HttpServerAceRead_PayloadKeyword_10_0_q.equals(syntax))
				emit_HttpServerAceRead_PayloadKeyword_10_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_HttpServerAceRead_QueryParamsKeyword_9_0_q.equals(syntax))
				emit_HttpServerAceRead_QueryParamsKeyword_9_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_HttpServerAceRead_ResponseKeyword_11_0_q.equals(syntax))
				emit_HttpServerAceRead_ResponseKeyword_11_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_HttpServerAceWrite_PathParamsKeyword_8_0_q.equals(syntax))
				emit_HttpServerAceWrite_PathParamsKeyword_8_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_HttpServerAceWrite_PayloadKeyword_10_0_q.equals(syntax))
				emit_HttpServerAceWrite_PayloadKeyword_10_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_HttpServerAceWrite_QueryParamsKeyword_9_0_q.equals(syntax))
				emit_HttpServerAceWrite_QueryParamsKeyword_9_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_HttpServerAceWrite_ResponseKeyword_11_0_q.equals(syntax))
				emit_HttpServerAceWrite_ResponseKeyword_11_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_HttpServerOutcome___LeftParenthesisKeyword_2_0_RightParenthesisKeyword_2_2__a.equals(syntax))
				emit_HttpServerOutcome___LeftParenthesisKeyword_2_0_RightParenthesisKeyword_2_2__a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_HttpServerOutcome___RightParenthesisKeyword_2_2_LeftParenthesisKeyword_2_0__a.equals(syntax))
				emit_HttpServerOutcome___RightParenthesisKeyword_2_2_LeftParenthesisKeyword_2_0__a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_HttpServerOutcome___TriggersKeyword_3_0_LeftParenthesisKeyword_3_1_RightParenthesisKeyword_3_3__q.equals(syntax))
				emit_HttpServerOutcome___TriggersKeyword_3_0_LeftParenthesisKeyword_3_1_RightParenthesisKeyword_3_3__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_HttpServerView___LeftCurlyBracketKeyword_1_0_RightCurlyBracketKeyword_1_2__q.equals(syntax))
				emit_HttpServerView___LeftCurlyBracketKeyword_1_0_RightCurlyBracketKeyword_1_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_HttpServer_ACEKeyword_3_0_q.equals(syntax))
				emit_HttpServer_ACEKeyword_3_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_HttpServer_ModelsKeyword_5_0_q.equals(syntax))
				emit_HttpServer_ModelsKeyword_5_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_HttpServer_ViewsKeyword_4_0_q.equals(syntax))
				emit_HttpServer_ViewsKeyword_4_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Model___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_2__q.equals(syntax))
				emit_Model___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     ('(' ')')?
	 *
	 * This ambiguous syntax occurs at:
	 *     name=ID (ambiguity) 'triggers' '(' aceOperations+=[HttpClientAce|QualifiedName]
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
	 *     name=QualifiedName (ambiguity) 'appState' appState=HttpClientStateElement
	 *     name=QualifiedName (ambiguity) (rule end)
	 */
	protected void emit_HttpClient_ACEKeyword_1_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'pathParams'?
	 *
	 * This ambiguous syntax occurs at:
	 *     authorize?='authorize' (ambiguity) 'queryParams' queryParams+=[Attribute|QualifiedName]
	 *     authorize?='authorize' (ambiguity) 'queryParams'? 'payload' payload+=[Attribute|QualifiedName]
	 *     authorize?='authorize' (ambiguity) 'queryParams'? 'payload'? 'response' response+=[Attribute|QualifiedName]
	 *     authorize?='authorize' (ambiguity) 'queryParams'? 'payload'? 'response'? (rule end)
	 *     url=STRING (ambiguity) 'queryParams' queryParams+=[Attribute|QualifiedName]
	 *     url=STRING (ambiguity) 'queryParams'? 'payload' payload+=[Attribute|QualifiedName]
	 *     url=STRING (ambiguity) 'queryParams'? 'payload'? 'response' response+=[Attribute|QualifiedName]
	 *     url=STRING (ambiguity) 'queryParams'? 'payload'? 'response'? (rule end)
	 */
	protected void emit_HttpServerAceRead_PathParamsKeyword_8_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'payload'?
	 *
	 * This ambiguous syntax occurs at:
	 *     authorize?='authorize' 'pathParams'? 'queryParams'? (ambiguity) 'response' response+=[Attribute|QualifiedName]
	 *     authorize?='authorize' 'pathParams'? 'queryParams'? (ambiguity) 'response'? (rule end)
	 *     pathParams+=[Attribute|QualifiedName] 'queryParams'? (ambiguity) 'response' response+=[Attribute|QualifiedName]
	 *     pathParams+=[Attribute|QualifiedName] 'queryParams'? (ambiguity) 'response'? (rule end)
	 *     queryParams+=[Attribute|QualifiedName] (ambiguity) 'response' response+=[Attribute|QualifiedName]
	 *     queryParams+=[Attribute|QualifiedName] (ambiguity) 'response'? (rule end)
	 *     url=STRING 'pathParams'? 'queryParams'? (ambiguity) 'response' response+=[Attribute|QualifiedName]
	 *     url=STRING 'pathParams'? 'queryParams'? (ambiguity) 'response'? (rule end)
	 */
	protected void emit_HttpServerAceRead_PayloadKeyword_10_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'queryParams'?
	 *
	 * This ambiguous syntax occurs at:
	 *     authorize?='authorize' 'pathParams'? (ambiguity) 'payload' payload+=[Attribute|QualifiedName]
	 *     authorize?='authorize' 'pathParams'? (ambiguity) 'payload'? 'response' response+=[Attribute|QualifiedName]
	 *     authorize?='authorize' 'pathParams'? (ambiguity) 'payload'? 'response'? (rule end)
	 *     pathParams+=[Attribute|QualifiedName] (ambiguity) 'payload' payload+=[Attribute|QualifiedName]
	 *     pathParams+=[Attribute|QualifiedName] (ambiguity) 'payload'? 'response' response+=[Attribute|QualifiedName]
	 *     pathParams+=[Attribute|QualifiedName] (ambiguity) 'payload'? 'response'? (rule end)
	 *     url=STRING 'pathParams'? (ambiguity) 'payload' payload+=[Attribute|QualifiedName]
	 *     url=STRING 'pathParams'? (ambiguity) 'payload'? 'response' response+=[Attribute|QualifiedName]
	 *     url=STRING 'pathParams'? (ambiguity) 'payload'? 'response'? (rule end)
	 */
	protected void emit_HttpServerAceRead_QueryParamsKeyword_9_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'response'?
	 *
	 * This ambiguous syntax occurs at:
	 *     authorize?='authorize' 'pathParams'? 'queryParams'? 'payload'? (ambiguity) (rule end)
	 *     pathParams+=[Attribute|QualifiedName] 'queryParams'? 'payload'? (ambiguity) (rule end)
	 *     payload+=[Attribute|QualifiedName] (ambiguity) (rule end)
	 *     queryParams+=[Attribute|QualifiedName] 'payload'? (ambiguity) (rule end)
	 *     url=STRING 'pathParams'? 'queryParams'? 'payload'? (ambiguity) (rule end)
	 */
	protected void emit_HttpServerAceRead_ResponseKeyword_11_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'pathParams'?
	 *
	 * This ambiguous syntax occurs at:
	 *     authorize?='authorize' (ambiguity) 'queryParams' queryParams+=[Attribute|QualifiedName]
	 *     authorize?='authorize' (ambiguity) 'queryParams'? 'payload' payload+=[Attribute|QualifiedName]
	 *     authorize?='authorize' (ambiguity) 'queryParams'? 'payload'? 'response' response+=[Attribute|QualifiedName]
	 *     authorize?='authorize' (ambiguity) 'queryParams'? 'payload'? 'response'? (rule end)
	 *     authorize?='authorize' (ambiguity) 'queryParams'? 'payload'? 'response'? outcomes+=HttpServerOutcome
	 *     url=STRING (ambiguity) 'queryParams' queryParams+=[Attribute|QualifiedName]
	 *     url=STRING (ambiguity) 'queryParams'? 'payload' payload+=[Attribute|QualifiedName]
	 *     url=STRING (ambiguity) 'queryParams'? 'payload'? 'response' response+=[Attribute|QualifiedName]
	 *     url=STRING (ambiguity) 'queryParams'? 'payload'? 'response'? (rule end)
	 *     url=STRING (ambiguity) 'queryParams'? 'payload'? 'response'? outcomes+=HttpServerOutcome
	 */
	protected void emit_HttpServerAceWrite_PathParamsKeyword_8_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
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
	 *     pathParams+=[Attribute|QualifiedName] 'queryParams'? (ambiguity) 'response' response+=[Attribute|QualifiedName]
	 *     pathParams+=[Attribute|QualifiedName] 'queryParams'? (ambiguity) 'response'? (rule end)
	 *     pathParams+=[Attribute|QualifiedName] 'queryParams'? (ambiguity) 'response'? outcomes+=HttpServerOutcome
	 *     queryParams+=[Attribute|QualifiedName] (ambiguity) 'response' response+=[Attribute|QualifiedName]
	 *     queryParams+=[Attribute|QualifiedName] (ambiguity) 'response'? (rule end)
	 *     queryParams+=[Attribute|QualifiedName] (ambiguity) 'response'? outcomes+=HttpServerOutcome
	 *     url=STRING 'pathParams'? 'queryParams'? (ambiguity) 'response' response+=[Attribute|QualifiedName]
	 *     url=STRING 'pathParams'? 'queryParams'? (ambiguity) 'response'? (rule end)
	 *     url=STRING 'pathParams'? 'queryParams'? (ambiguity) 'response'? outcomes+=HttpServerOutcome
	 */
	protected void emit_HttpServerAceWrite_PayloadKeyword_10_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'queryParams'?
	 *
	 * This ambiguous syntax occurs at:
	 *     authorize?='authorize' 'pathParams'? (ambiguity) 'payload' payload+=[Attribute|QualifiedName]
	 *     authorize?='authorize' 'pathParams'? (ambiguity) 'payload'? 'response' response+=[Attribute|QualifiedName]
	 *     authorize?='authorize' 'pathParams'? (ambiguity) 'payload'? 'response'? (rule end)
	 *     authorize?='authorize' 'pathParams'? (ambiguity) 'payload'? 'response'? outcomes+=HttpServerOutcome
	 *     pathParams+=[Attribute|QualifiedName] (ambiguity) 'payload' payload+=[Attribute|QualifiedName]
	 *     pathParams+=[Attribute|QualifiedName] (ambiguity) 'payload'? 'response' response+=[Attribute|QualifiedName]
	 *     pathParams+=[Attribute|QualifiedName] (ambiguity) 'payload'? 'response'? (rule end)
	 *     pathParams+=[Attribute|QualifiedName] (ambiguity) 'payload'? 'response'? outcomes+=HttpServerOutcome
	 *     url=STRING 'pathParams'? (ambiguity) 'payload' payload+=[Attribute|QualifiedName]
	 *     url=STRING 'pathParams'? (ambiguity) 'payload'? 'response' response+=[Attribute|QualifiedName]
	 *     url=STRING 'pathParams'? (ambiguity) 'payload'? 'response'? (rule end)
	 *     url=STRING 'pathParams'? (ambiguity) 'payload'? 'response'? outcomes+=HttpServerOutcome
	 */
	protected void emit_HttpServerAceWrite_QueryParamsKeyword_9_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'response'?
	 *
	 * This ambiguous syntax occurs at:
	 *     authorize?='authorize' 'pathParams'? 'queryParams'? 'payload'? (ambiguity) (rule end)
	 *     authorize?='authorize' 'pathParams'? 'queryParams'? 'payload'? (ambiguity) outcomes+=HttpServerOutcome
	 *     pathParams+=[Attribute|QualifiedName] 'queryParams'? 'payload'? (ambiguity) (rule end)
	 *     pathParams+=[Attribute|QualifiedName] 'queryParams'? 'payload'? (ambiguity) outcomes+=HttpServerOutcome
	 *     payload+=[Attribute|QualifiedName] (ambiguity) (rule end)
	 *     payload+=[Attribute|QualifiedName] (ambiguity) outcomes+=HttpServerOutcome
	 *     queryParams+=[Attribute|QualifiedName] 'payload'? (ambiguity) (rule end)
	 *     queryParams+=[Attribute|QualifiedName] 'payload'? (ambiguity) outcomes+=HttpServerOutcome
	 *     url=STRING 'pathParams'? 'queryParams'? 'payload'? (ambiguity) (rule end)
	 *     url=STRING 'pathParams'? 'queryParams'? 'payload'? (ambiguity) outcomes+=HttpServerOutcome
	 */
	protected void emit_HttpServerAceWrite_ResponseKeyword_11_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('(' ')')*
	 *
	 * This ambiguous syntax occurs at:
	 *     listeners+=[HttpServerViewFunction|QualifiedName] ')' (ambiguity) 'triggers' '(' aceOperations+=[HttpServerAceWrite|QualifiedName]
	 *     listeners+=[HttpServerViewFunction|QualifiedName] ')' (ambiguity) ('triggers' '(' ')')? (rule end)
	 *     name=ID (ambiguity) 'triggers' '(' aceOperations+=[HttpServerAceWrite|QualifiedName]
	 *     name=ID (ambiguity) ('triggers' '(' ')')? (rule end)
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
	 *     ('triggers' '(' ')')?
	 *
	 * This ambiguous syntax occurs at:
	 *     listeners+=[HttpServerViewFunction|QualifiedName] ')' ('(' ')')* (ambiguity) (rule end)
	 *     name=ID ('(' ')')* (ambiguity) (rule end)
	 */
	protected void emit_HttpServerOutcome___TriggersKeyword_3_0_LeftParenthesisKeyword_3_1_RightParenthesisKeyword_3_3__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('{' '}')?
	 *
	 * This ambiguous syntax occurs at:
	 *     name=ID (ambiguity) (rule end)
	 */
	protected void emit_HttpServerView___LeftCurlyBracketKeyword_1_0_RightCurlyBracketKeyword_1_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'ACE'?
	 *
	 * This ambiguous syntax occurs at:
	 *     authUser=AuthUser (ambiguity) 'views' views+=HttpServerView
	 *     authUser=AuthUser (ambiguity) 'views'? 'models' models+=Model
	 *     authUser=AuthUser (ambiguity) 'views'? 'models'? (rule end)
	 *     authUserRef=[AuthUser|QualifiedName] (ambiguity) 'views' views+=HttpServerView
	 *     authUserRef=[AuthUser|QualifiedName] (ambiguity) 'views'? 'models' models+=Model
	 *     authUserRef=[AuthUser|QualifiedName] (ambiguity) 'views'? 'models'? (rule end)
	 *     name=QualifiedName (ambiguity) 'views' views+=HttpServerView
	 *     name=QualifiedName (ambiguity) 'views'? 'models' models+=Model
	 *     name=QualifiedName (ambiguity) 'views'? 'models'? (rule end)
	 */
	protected void emit_HttpServer_ACEKeyword_3_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'models'?
	 *
	 * This ambiguous syntax occurs at:
	 *     aceOperations+=HttpServerAce 'views'? (ambiguity) (rule end)
	 *     authUser=AuthUser 'ACE'? 'views'? (ambiguity) (rule end)
	 *     authUserRef=[AuthUser|QualifiedName] 'ACE'? 'views'? (ambiguity) (rule end)
	 *     name=QualifiedName 'ACE'? 'views'? (ambiguity) (rule end)
	 *     views+=HttpServerView (ambiguity) (rule end)
	 */
	protected void emit_HttpServer_ModelsKeyword_5_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'views'?
	 *
	 * This ambiguous syntax occurs at:
	 *     aceOperations+=HttpServerAce (ambiguity) 'models' models+=Model
	 *     aceOperations+=HttpServerAce (ambiguity) 'models'? (rule end)
	 *     authUser=AuthUser 'ACE'? (ambiguity) 'models' models+=Model
	 *     authUser=AuthUser 'ACE'? (ambiguity) 'models'? (rule end)
	 *     authUserRef=[AuthUser|QualifiedName] 'ACE'? (ambiguity) 'models' models+=Model
	 *     authUserRef=[AuthUser|QualifiedName] 'ACE'? (ambiguity) 'models'? (rule end)
	 *     name=QualifiedName 'ACE'? (ambiguity) 'models' models+=Model
	 *     name=QualifiedName 'ACE'? (ambiguity) 'models'? (rule end)
	 */
	protected void emit_HttpServer_ViewsKeyword_4_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
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
	
}
