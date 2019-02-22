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
package de.acegen.extensions.java;

import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerView;
import de.acegen.aceGen.HttpServerViewFunction;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ViewExtension {
  public String viewName(final HttpServerView it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("View");
    return _builder.toString();
  }
  
  public String viewInterfaceName(final HttpServerView it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("I");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("View");
    return _builder.toString();
  }
  
  public String viewNameWithPackage(final HttpServerView it) {
    StringConcatenation _builder = new StringConcatenation();
    EObject _eContainer = it.eContainer();
    String _name = ((HttpServer) _eContainer).getName();
    _builder.append(_name);
    _builder.append(".views.");
    String _viewName = this.viewName(it);
    _builder.append(_viewName);
    return _builder.toString();
  }
  
  public String viewNameAsVariable(final HttpServerView it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstLower = StringExtensions.toFirstLower(it.getName());
    _builder.append(_firstLower);
    _builder.append("View");
    return _builder.toString();
  }
  
  public String viewFunctionWithViewName(final HttpServerViewFunction it) {
    StringConcatenation _builder = new StringConcatenation();
    EObject _eContainer = it.eContainer();
    String _viewName = this.viewName(((HttpServerView) _eContainer));
    _builder.append(_viewName);
    _builder.append(".");
    String _name = it.getName();
    _builder.append(_name);
    return _builder.toString();
  }
  
  public String viewFunctionWithViewNameAsVariable(final HttpServerViewFunction it) {
    StringConcatenation _builder = new StringConcatenation();
    EObject _eContainer = it.eContainer();
    String _viewNameAsVariable = this.viewNameAsVariable(((HttpServerView) _eContainer));
    _builder.append(_viewNameAsVariable);
    _builder.append(".");
    String _name = it.getName();
    _builder.append(_name);
    return _builder.toString();
  }
  
  public HttpServerView view(final HttpServerViewFunction it) {
    EObject _eContainer = it.eContainer();
    return ((HttpServerView) _eContainer);
  }
}
