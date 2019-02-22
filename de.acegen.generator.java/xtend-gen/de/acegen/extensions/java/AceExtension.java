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
import de.acegen.aceGen.HttpServerAce;
import de.acegen.aceGen.HttpServerOutcome;
import de.acegen.extensions.java.ModelExtension;
import java.util.ArrayList;
import javax.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class AceExtension {
  @Inject
  @Extension
  private ModelExtension _modelExtension;
  
  public String abstractActionName(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Abstract");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Action");
    return _builder.toString();
  }
  
  public String actionName(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Action");
    return _builder.toString();
  }
  
  public String actionNameWithPackage(final HttpServerAce it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = java.getName();
    _builder.append(_name);
    _builder.append(".actions.");
    String _actionName = this.actionName(it);
    _builder.append(_actionName);
    return _builder.toString();
  }
  
  public String abstractName(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Abstract");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    return _builder.toString();
  }
  
  public String nameUppercase(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    return _builder.toString();
  }
  
  public String resourceName(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Resource");
    return _builder.toString();
  }
  
  public String actionNameWithPackage(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    EObject _eContainer = it.eContainer();
    String _name = ((HttpServer) _eContainer).getName();
    _builder.append(_name);
    _builder.append(".actions.");
    String _actionName = this.actionName(it);
    _builder.append(_actionName);
    return _builder.toString();
  }
  
  public String newAction(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("final ");
    String _actionNameWithPackage = this.actionNameWithPackage(it);
    _builder.append(_actionNameWithPackage);
    _builder.append(" action = new ");
    String _actionNameWithPackage_1 = this.actionNameWithPackage(it);
    _builder.append(_actionNameWithPackage_1);
    _builder.append("(");
    CharSequence _newFromCommandData = this._modelExtension.newFromCommandData(it.getModel());
    _builder.append(_newFromCommandData);
    _builder.append(", DatabaseService.getDatabaseHandle());");
    return _builder.toString();
  }
  
  public String abstractCommandName(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Abstract");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Command");
    return _builder.toString();
  }
  
  public String commandName(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Command");
    return _builder.toString();
  }
  
  public String commandNameWithPackage(final HttpServerAce it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = java.getName();
    _builder.append(_name);
    _builder.append(".commands.");
    String _commandName = this.commandName(it);
    _builder.append(_commandName);
    return _builder.toString();
  }
  
  public String eventName(final HttpServerAce it, final HttpServerOutcome outcome) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    String _firstUpper_1 = StringExtensions.toFirstUpper(outcome.getName());
    _builder.append(_firstUpper_1);
    _builder.append("Event");
    return _builder.toString();
  }
  
  public String eventNameWithPackage(final HttpServerAce it, final HttpServerOutcome outcome) {
    StringConcatenation _builder = new StringConcatenation();
    EObject _eContainer = it.eContainer();
    String _name = ((HttpServer) _eContainer).getName();
    _builder.append(_name);
    _builder.append(".events.");
    String _eventName = this.eventName(it, outcome);
    _builder.append(_eventName);
    return _builder.toString();
  }
  
  public String responseDataName(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Response");
    return _builder.toString();
  }
  
  public String responseDataNameWithPackage(final HttpServerAce it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = java.getName();
    _builder.append(_name);
    _builder.append(".data.");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Response");
    return _builder.toString();
  }
  
  public String responseDataInterfaceName(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("I");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("Response");
    return _builder.toString();
  }
  
  public String urlWithPathParams(final HttpServerAce it) {
    int _size = it.getPathParams().size();
    boolean _equals = (_size == 0);
    if (_equals) {
      return it.getUrl();
    }
    final String[] split1 = it.getUrl().split("\\{");
    ArrayList<String> urlElements = new ArrayList<String>();
    for (final String split : split1) {
      {
        final String[] split2 = split.split("\\}");
        CollectionExtensions.<String>addAll(urlElements, split2);
      }
    }
    String urlWithPathParam = "";
    for (int i = 0; (i < urlElements.size()); i++) {
      if (((i % 2) == 0)) {
        String _urlWithPathParam = urlWithPathParam;
        String _get = urlElements.get(i);
        urlWithPathParam = (_urlWithPathParam + _get);
      } else {
        String _urlWithPathParam_1 = urlWithPathParam;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("\" + ");
        String _get_1 = urlElements.get(i);
        _builder.append(_get_1);
        _builder.append(" + \"");
        urlWithPathParam = (_urlWithPathParam_1 + _builder);
      }
    }
    return urlWithPathParam;
  }
}
