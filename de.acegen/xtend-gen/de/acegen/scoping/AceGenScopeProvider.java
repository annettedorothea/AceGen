/**
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 * 
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */
package de.acegen.scoping;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import de.acegen.aceGen.AceGenPackage;
import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.aceGen.HttpServerAceWrite;
import de.acegen.aceGen.HttpServerOutcome;
import de.acegen.aceGen.HttpServerViewFunction;
import de.acegen.aceGen.Model;
import de.acegen.extensions.CommonExtension;
import de.acegen.scoping.AbstractAceGenScopeProvider;
import java.util.ArrayList;
import javax.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.FilteringScope;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * This class contains custom scoping description.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
@SuppressWarnings("all")
public class AceGenScopeProvider extends AbstractAceGenScopeProvider {
  @Inject
  @Extension
  private CommonExtension _commonExtension;
  
  @Override
  public IScope getScope(final EObject context, final EReference reference) {
    if (((context instanceof HttpServerAce) && 
      (((Objects.equal(reference, AceGenPackage.Literals.HTTP_SERVER_ACE__QUERY_PARAMS) || 
        Objects.equal(reference, AceGenPackage.Literals.HTTP_SERVER_ACE__PATH_PARAMS)) || 
        Objects.equal(reference, AceGenPackage.Literals.HTTP_SERVER_ACE__PAYLOAD)) || Objects.equal(reference, AceGenPackage.Literals.HTTP_SERVER_ACE__RESPONSE)))) {
      final HttpServerAce javaAce = ((HttpServerAce) context);
      final ArrayList<Attribute> attrs = new ArrayList<Attribute>();
      this._commonExtension.allAttributesRec(javaAce.getModel(), attrs);
      return Scopes.scopeFor(attrs);
    }
    if ((context instanceof HttpServerOutcome)) {
      EObject _eContainer = ((HttpServerOutcome)context).eContainer();
      final Model aceModel = ((HttpServerAceWrite) _eContainer).getModel();
      boolean _equals = reference.getName().equals("listeners");
      if (_equals) {
        final IScope scope = super.getScope(context, reference);
        final Predicate<IEObjectDescription> _function = (IEObjectDescription it) -> {
          EObject _eObjectOrProxy = it.getEObjectOrProxy();
          return ((HttpServerViewFunction) _eObjectOrProxy).getModel().equals(aceModel);
        };
        return new FilteringScope(scope, _function);
      } else {
        boolean _equals_1 = reference.getName().equals("aceOperations");
        if (_equals_1) {
          final IScope scope_1 = super.getScope(context, reference);
          final Predicate<IEObjectDescription> _function_1 = (IEObjectDescription it) -> {
            EObject _eObjectOrProxy = it.getEObjectOrProxy();
            return ((HttpServerAceWrite) _eObjectOrProxy).getModel().equals(aceModel);
          };
          return new FilteringScope(scope_1, _function_1);
        }
      }
    }
    if ((context instanceof Model)) {
      final Model aceModel_1 = ((Model) context);
      final IScope scope_2 = super.getScope(context, reference);
      final Predicate<IEObjectDescription> _function_2 = (IEObjectDescription it) -> {
        EObject _eObjectOrProxy = it.getEObjectOrProxy();
        boolean _equals_2 = ((Model) _eObjectOrProxy).equals(aceModel_1);
        return (!_equals_2);
      };
      return new FilteringScope(scope_2, _function_2);
    }
    return super.getScope(context, reference);
  }
}
