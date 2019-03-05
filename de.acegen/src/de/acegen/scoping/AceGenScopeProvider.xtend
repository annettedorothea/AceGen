/* 
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 * 
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.

 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */


package de.acegen.scoping

import de.acegen.aceGen.AceGenPackage
import de.acegen.aceGen.Attribute
import de.acegen.aceGen.AttributeDefinition
import de.acegen.aceGen.AttributeDefinitionList
import de.acegen.aceGen.HttpServerAce
import de.acegen.aceGen.HttpServerAceWrite
import de.acegen.aceGen.HttpServerOutcome
import de.acegen.aceGen.HttpServerViewFunction
import de.acegen.aceGen.ListAttributeDefinitionList
import de.acegen.aceGen.Model
import de.acegen.aceGen.Scenario
import de.acegen.aceGen.ScenarioEvent
import de.acegen.aceGen.Verification
import de.acegen.extensions.java.ModelExtension
import java.util.ArrayList
import javax.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.xtext.scoping.impl.FilteringScope

/**
 * This class contains custom scoping description.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
class AceGenScopeProvider extends AbstractAceGenScopeProvider {

	@Inject
	extension ModelExtension

	override getScope(EObject context, EReference reference) {
		if (context instanceof HttpServerAce && (
				reference == AceGenPackage.Literals.HTTP_SERVER_ACE__QUERY_PARAMS ||
			reference == AceGenPackage.Literals.HTTP_SERVER_ACE__PATH_PARAMS ||
			reference == AceGenPackage.Literals.HTTP_SERVER_ACE__PAYLOAD || reference == AceGenPackage.Literals.HTTP_SERVER_ACE__RESPONSE
			)) {
			val javaAce = context as HttpServerAce;
			val attrs = new ArrayList<Attribute>();
			javaAce.getModel.allAttributesRec(attrs);
			return Scopes.scopeFor(attrs)
		}
		if (context instanceof HttpServerOutcome) {
			val aceModel = (context.eContainer as HttpServerAceWrite).getModel
			if (reference.name.equals("listeners")) {
				val scope = super.getScope(context, reference)
				return new FilteringScope(scope, [
					(getEObjectOrProxy as HttpServerViewFunction).getModel.equals(aceModel)
				])
			} else if (reference.name.equals("aceOperations")) {
				val scope = super.getScope(context, reference)
				return new FilteringScope(scope, [(getEObjectOrProxy as HttpServerAceWrite).getModel.equals(aceModel)])
			}
		}
		if (context instanceof Model) {
			val aceModel = context as Model
			val scope = super.getScope(context, reference)
			return new FilteringScope(scope, [!(getEObjectOrProxy as Model).equals(aceModel)])
		}
		if (context instanceof AttributeDefinitionList || context instanceof ListAttributeDefinitionList ||
			context instanceof AttributeDefinition) {
			var parent = context.eContainer
			while (parent !== null && !(
					(parent instanceof ScenarioEvent) || (parent instanceof Verification) ||
				(parent instanceof Scenario) || (parent instanceof AttributeDefinition)
				)) {
				parent = parent.eContainer
			}
			if (parent instanceof ScenarioEvent) {
				val scenarioEvent = parent as ScenarioEvent;
				val aceModel = scenarioEvent.event.model;
				if (aceModel !== null) {
					return getScopeFor(aceModel);
				}
			}
			if (parent instanceof Verification) {
				val verification = parent as Verification;
				val aceModel = verification.action.model;
				if (aceModel !== null) {
					return getScopeFor(aceModel);
				}
			}
			if (parent instanceof Scenario) {
				val scenario = parent as Scenario;
				val aceModel = scenario.action.model;
				if (aceModel !== null) {
					return getScopeFor(aceModel);
				}
			}
			if (parent instanceof AttributeDefinition) {
				val attributeDefinition = parent as AttributeDefinition;
				if (attributeDefinition.attribute.model !== null) {
					val model = attributeDefinition.attribute.model as Model
					return getScopeFor(model);
				}
			}
		}
		return super.getScope(context, reference);
	}

	def IScope getScopeFor(Model aceModel) {
		val attrs = new ArrayList<Attribute>();
		aceModel.allAttributesRec(attrs);
		return Scopes.scopeFor(attrs)
	}

}
/******* S.D.G. *******/
