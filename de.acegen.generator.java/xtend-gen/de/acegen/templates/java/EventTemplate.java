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
package de.acegen.templates.java;

import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.aceGen.HttpServerAceRead;
import de.acegen.aceGen.HttpServerAceWrite;
import de.acegen.aceGen.HttpServerOutcome;
import de.acegen.aceGen.HttpServerView;
import de.acegen.aceGen.HttpServerViewFunction;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.java.AceExtension;
import de.acegen.extensions.java.ModelExtension;
import de.acegen.extensions.java.ViewExtension;
import java.util.Arrays;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class EventTemplate {
  @Inject
  @Extension
  private AceExtension _aceExtension;
  
  @Inject
  @Extension
  private ViewExtension _viewExtension;
  
  @Inject
  @Extension
  private ModelExtension _modelExtension;
  
  @Inject
  @Extension
  private CommonExtension _commonExtension;
  
  public CharSequence generateAbstractEventFile(final HttpServerAce it, final HttpServerOutcome outcome, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = java.getName();
    _builder.append(_name);
    _builder.append(".events;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.Event;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.IDaoProvider;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.ViewProvider;");
    _builder.newLine();
    _builder.newLine();
    String _dataImport = this._modelExtension.dataImport(it.getModel());
    _builder.append(_dataImport);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _eventName = this._aceExtension.eventName(it, outcome);
    _builder.append(_eventName);
    _builder.append(" extends Event<");
    String _dataParamType = this._modelExtension.dataParamType(it.getModel());
    _builder.append(_dataParamType);
    _builder.append("> {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _eventName_1 = this._aceExtension.eventName(it, outcome);
    _builder.append(_eventName_1, "\t");
    _builder.append("(");
    String _dataParamType_1 = this._modelExtension.dataParamType(it.getModel());
    _builder.append(_dataParamType_1, "\t");
    _builder.append(" eventData, IDaoProvider daoProvider, ViewProvider viewProvider) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(\"");
    String _name_1 = java.getName();
    _builder.append(_name_1, "\t\t");
    _builder.append(".events.");
    String _eventName_2 = this._aceExtension.eventName(it, outcome);
    _builder.append(_eventName_2, "\t\t");
    _builder.append("\", eventData, daoProvider, viewProvider);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateView(final HttpServerView it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = java.getName();
    _builder.append(_name);
    _builder.append(".views;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.IDaoProvider;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.jdbi.v3.core.Handle;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.IDataContainer;");
    _builder.newLine();
    {
      EList<HttpServerViewFunction> _renderFunctions = it.getRenderFunctions();
      for(final HttpServerViewFunction renderFunction : _renderFunctions) {
        String _dataImport = this._modelExtension.dataImport(renderFunction.getModel());
        _builder.append(_dataImport);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("public class ");
    String _viewName = this._viewExtension.viewName(it);
    _builder.append(_viewName);
    _builder.append(" implements ");
    String _viewInterfaceName = this._viewExtension.viewInterfaceName(it);
    _builder.append(_viewInterfaceName);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private IDaoProvider daoProvider;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _viewName_1 = this._viewExtension.viewName(it);
    _builder.append(_viewName_1, "\t");
    _builder.append("(IDaoProvider daoProvider) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.daoProvider = daoProvider;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<HttpServerViewFunction> _renderFunctions_1 = it.getRenderFunctions();
      for(final HttpServerViewFunction renderFunction_1 : _renderFunctions_1) {
        _builder.append("\t");
        _builder.append("public void ");
        String _name_1 = renderFunction_1.getName();
        _builder.append(_name_1, "\t");
        _builder.append("(");
        String _dataInterfaceName = this._modelExtension.dataInterfaceName(renderFunction_1.getModel());
        _builder.append(_dataInterfaceName, "\t");
        _builder.append(" data, Handle handle) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateViewInterface(final HttpServerView it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = java.getName();
    _builder.append(_name);
    _builder.append(".views;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.jdbi.v3.core.Handle;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.IDataContainer;");
    _builder.newLine();
    {
      EList<HttpServerViewFunction> _renderFunctions = it.getRenderFunctions();
      for(final HttpServerViewFunction renderFunction : _renderFunctions) {
        String _dataImport = this._modelExtension.dataImport(renderFunction.getModel());
        _builder.append(_dataImport);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"all\")");
    _builder.newLine();
    _builder.append("public interface ");
    String _viewInterfaceName = this._viewExtension.viewInterfaceName(it);
    _builder.append(_viewInterfaceName);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      EList<HttpServerViewFunction> _renderFunctions_1 = it.getRenderFunctions();
      for(final HttpServerViewFunction renderFunction_1 : _renderFunctions_1) {
        _builder.append("\t");
        _builder.append("void ");
        String _name_1 = renderFunction_1.getName();
        _builder.append(_name_1, "\t");
        _builder.append("(");
        String _dataInterfaceName = this._modelExtension.dataInterfaceName(renderFunction_1.getModel());
        _builder.append(_dataInterfaceName, "\t");
        _builder.append(" data, Handle handle);");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateEvent() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package com.anfelisa.ace;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.jdbi.v3.core.Handle;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public abstract class Event<T extends IDataContainer> implements IEvent {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected T eventData;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private String eventName;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected IDaoProvider daoProvider;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private ViewProvider viewProvider;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Event(String eventName, T eventData, IDaoProvider daoProvider, ViewProvider viewProvider) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.eventData = eventData;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.eventName = eventName;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.daoProvider = daoProvider;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.viewProvider = viewProvider;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void notifyListeners(Handle handle) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("List<EventConsumer> consumerList = viewProvider.getConsumerForEvent(eventName);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (consumerList != null) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("for (EventConsumer consumer : consumerList) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("consumer.consumeEvent(this.eventData, handle);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public IDataContainer getEventData() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return eventData;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String getEventName() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return eventName;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void publish(Handle handle, Handle timelineHandle) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("daoProvider.getAceDao().addEventToTimeline(this, timelineHandle);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.notifyListeners(handle);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateIEvent() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package com.anfelisa.ace;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.jdbi.v3.core.Handle;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public interface IEvent {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String getEventName();");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("IDataContainer getEventData();");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("void publish(Handle handle, Handle timelineHandle);");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("void notifyListeners(Handle handle);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateEventFactory(final HttpServer it) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = it.getName();
    _builder.append(_name);
    _builder.append(".events;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.IDaoProvider;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.IEvent;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.ViewProvider;");
    _builder.newLine();
    _builder.append("import ");
    String _name_1 = it.getName();
    _builder.append(_name_1);
    _builder.append(".data.*;");
    _builder.newLineIfNotEmpty();
    _builder.append("import com.anfelisa.ace.JodaObjectMapper;");
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.databind.DeserializationFeature;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.IDataContainer;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.io.IOException;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class EventFactory {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static JodaObjectMapper mapper = new JodaObjectMapper();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static final Logger LOG = LoggerFactory.getLogger(EventFactory.class);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static IEvent createEvent(String eventClass, String json, IDaoProvider daoProvider, ViewProvider viewProvider) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("try {");
    _builder.newLine();
    {
      EList<HttpServerAce> _aceOperations = it.getAceOperations();
      for(final HttpServerAce ace : _aceOperations) {
        _builder.append("\t\t\t");
        CharSequence _createEvent = this.createEvent(ace, it);
        _builder.append(_createEvent, "\t\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("} catch (IOException e) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("LOG.error(\"failed to create event {} with data {}\", eventClass, json, e);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static IEvent createEvent(String eventClass, IDataContainer data, IDaoProvider daoProvider, ViewProvider viewProvider) {");
    _builder.newLine();
    {
      EList<HttpServerAce> _aceOperations_1 = it.getAceOperations();
      for(final HttpServerAce ace_1 : _aceOperations_1) {
        _builder.append("\t\t");
        CharSequence _createEventFromData = this.createEventFromData(ace_1, it);
        _builder.append(_createEventFromData, "\t\t");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence _createEvent(final HttpServerAceWrite it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<HttpServerOutcome> _outcomes = it.getOutcomes();
      for(final HttpServerOutcome outcome : _outcomes) {
        {
          int _size = outcome.getListeners().size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            _builder.append("if (eventClass.equals(\"");
            String _name = java.getName();
            _builder.append(_name);
            _builder.append(".events.");
            String _eventName = this._aceExtension.eventName(it, outcome);
            _builder.append(_eventName);
            _builder.append("\")) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            String _dataName = this._modelExtension.dataName(it.getModel());
            _builder.append(_dataName, "\t");
            _builder.append(" data = mapper.readValue(json, ");
            String _dataName_1 = this._modelExtension.dataName(it.getModel());
            _builder.append(_dataName_1, "\t");
            _builder.append(".class);");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("data.migrateLegacyData(json);");
            _builder.newLine();
            _builder.append("\t");
            String _eventName_1 = this._aceExtension.eventName(it, outcome);
            _builder.append(_eventName_1, "\t");
            _builder.append(" event = new ");
            String _eventName_2 = this._aceExtension.eventName(it, outcome);
            _builder.append(_eventName_2, "\t");
            _builder.append("(data, daoProvider, viewProvider);");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("return event;");
            _builder.newLine();
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    return _builder;
  }
  
  private CharSequence _createEvent(final HttpServerAceRead it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  private CharSequence _createEventFromData(final HttpServerAceWrite it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<HttpServerOutcome> _outcomes = it.getOutcomes();
      for(final HttpServerOutcome outcome : _outcomes) {
        {
          int _size = outcome.getListeners().size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            _builder.append("if (eventClass.equals(\"");
            String _name = java.getName();
            _builder.append(_name);
            _builder.append(".events.");
            String _eventName = this._aceExtension.eventName(it, outcome);
            _builder.append(_eventName);
            _builder.append("\")) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("return new ");
            String _eventName_1 = this._aceExtension.eventName(it, outcome);
            _builder.append(_eventName_1, "\t");
            _builder.append("((");
            String _dataName = this._modelExtension.dataName(it.getModel());
            _builder.append(_dataName, "\t");
            _builder.append(")data, daoProvider, viewProvider);");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    return _builder;
  }
  
  private CharSequence _createEventFromData(final HttpServerAceRead it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  public CharSequence generateEventFactory() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package com.anfelisa.ace;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class EventFactory {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static IEvent createEvent(String eventClass, String json, IDaoProvider daoProvider, ViewProvider viewProvider) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("//delegate to package EventFactory");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static IEvent createEvent(String eventClass, IDataContainer data, IDaoProvider daoProvider, ViewProvider viewProvider) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("//delegate to package EventFactory");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence createEvent(final HttpServerAce it, final HttpServer java) {
    if (it instanceof HttpServerAceRead) {
      return _createEvent((HttpServerAceRead)it, java);
    } else if (it instanceof HttpServerAceWrite) {
      return _createEvent((HttpServerAceWrite)it, java);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, java).toString());
    }
  }
  
  private CharSequence createEventFromData(final HttpServerAce it, final HttpServer java) {
    if (it instanceof HttpServerAceRead) {
      return _createEventFromData((HttpServerAceRead)it, java);
    } else if (it instanceof HttpServerAceWrite) {
      return _createEventFromData((HttpServerAceWrite)it, java);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, java).toString());
    }
  }
}
