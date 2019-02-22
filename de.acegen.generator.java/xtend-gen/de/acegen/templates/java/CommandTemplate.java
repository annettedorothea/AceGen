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
import de.acegen.aceGen.HttpServerAceWrite;
import de.acegen.aceGen.HttpServerOutcome;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.java.AceExtension;
import de.acegen.extensions.java.ModelExtension;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class CommandTemplate {
  @Inject
  @Extension
  private AceExtension _aceExtension;
  
  @Inject
  @Extension
  private ModelExtension _modelExtension;
  
  @Inject
  @Extension
  private CommonExtension _commonExtension;
  
  public CharSequence generateAbstractCommandFile(final HttpServerAceWrite it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = java.getName();
    _builder.append(_name);
    _builder.append(".commands;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import javax.ws.rs.WebApplicationException;");
    _builder.newLine();
    _builder.append("import org.jdbi.v3.core.Handle;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.Command;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.CustomAppConfiguration;");
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
    _builder.append("public abstract class ");
    String _abstractCommandName = this._aceExtension.abstractCommandName(it);
    _builder.append(_abstractCommandName);
    _builder.append(" extends Command<");
    String _dataParamType = this._modelExtension.dataParamType(it.getModel());
    _builder.append(_dataParamType);
    _builder.append("> {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      EList<HttpServerOutcome> _outcomes = it.getOutcomes();
      for(final HttpServerOutcome outcome : _outcomes) {
        _builder.append("\t");
        _builder.append("protected static final String ");
        String _name_1 = outcome.getName();
        _builder.append(_name_1, "\t");
        _builder.append(" = \"");
        String _name_2 = outcome.getName();
        _builder.append(_name_2, "\t");
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _abstractCommandName_1 = this._aceExtension.abstractCommandName(it);
    _builder.append(_abstractCommandName_1, "\t");
    _builder.append("(");
    String _dataParamType_1 = this._modelExtension.dataParamType(it.getModel());
    _builder.append(_dataParamType_1, "\t");
    _builder.append(" commandParam, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(\"");
    String _name_3 = java.getName();
    _builder.append(_name_3, "\t\t");
    _builder.append(".commands.");
    String _commandName = this._aceExtension.commandName(it);
    _builder.append(_commandName, "\t\t");
    _builder.append("\", commandParam, daoProvider, viewProvider, appConfiguration);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void publishEvents(Handle handle, Handle timelineHandle) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("switch (this.commandData.getOutcome()) {");
    _builder.newLine();
    {
      EList<HttpServerOutcome> _outcomes_1 = it.getOutcomes();
      for(final HttpServerOutcome outcome_1 : _outcomes_1) {
        _builder.append("\t\t");
        _builder.append("case ");
        String _name_4 = outcome_1.getName();
        _builder.append(_name_4, "\t\t");
        _builder.append(":");
        _builder.newLineIfNotEmpty();
        {
          int _size = outcome_1.getListeners().size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("new ");
            String _eventNameWithPackage = this._aceExtension.eventNameWithPackage(it, outcome_1);
            _builder.append(_eventNameWithPackage, "\t\t\t");
            _builder.append("(this.commandData, daoProvider, viewProvider).publish(handle, timelineHandle);");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("break;");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.append("default:");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("throw new WebApplicationException(\"unhandled outcome \" + this.commandData.getOutcome());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
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
  
  public CharSequence generateInitialCommandFile(final HttpServerAceWrite it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = java.getName();
    _builder.append(_name);
    _builder.append(".commands;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.ViewProvider;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.IDaoProvider;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.CustomAppConfiguration;");
    _builder.newLine();
    _builder.append("import org.jdbi.v3.core.Handle;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    String _dataImport = this._modelExtension.dataImport(it.getModel());
    _builder.append(_dataImport);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _commandName = this._aceExtension.commandName(it);
    _builder.append(_commandName);
    _builder.append(" extends ");
    String _abstractCommandName = this._aceExtension.abstractCommandName(it);
    _builder.append(_abstractCommandName);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final Logger LOG = LoggerFactory.getLogger(");
    String _commandName_1 = this._aceExtension.commandName(it);
    _builder.append(_commandName_1, "\t");
    _builder.append(".class);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _commandName_2 = this._aceExtension.commandName(it);
    _builder.append(_commandName_2, "\t");
    _builder.append("(");
    String _dataParamType = this._modelExtension.dataParamType(it.getModel());
    _builder.append(_dataParamType, "\t");
    _builder.append(" commandData, IDaoProvider daoProvider, ViewProvider viewProvider, ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("CustomAppConfiguration appConfiguration) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super(commandData, daoProvider, viewProvider, appConfiguration);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void executeCommand(Handle readonlyHandle) {");
    _builder.newLine();
    {
      int _size = it.getOutcomes().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        _builder.append("\t\t");
        _builder.append("this.commandData.setOutcome(");
        String _name_1 = it.getOutcomes().get(0).getName();
        _builder.append(_name_1, "\t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
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
  
  public CharSequence generateCommand() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package com.anfelisa.ace;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import javax.ws.rs.WebApplicationException;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.core.Response;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.CustomAppConfiguration;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.jdbi.v3.core.Handle;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public abstract class Command<T extends IDataContainer> implements ICommand {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected T commandData;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private String commandName;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected JodaObjectMapper mapper;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected IDaoProvider daoProvider;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected ViewProvider viewProvider;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected CustomAppConfiguration appConfiguration;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Command(String commandName, T commandData, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.commandData = commandData;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.commandName = commandName;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("mapper = new JodaObjectMapper();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.daoProvider = daoProvider;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.viewProvider = viewProvider;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.appConfiguration = appConfiguration;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract void executeCommand(Handle readonlyHandle);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void execute(Handle readonlyHandle, Handle timelineHandle) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.executeCommand(readonlyHandle);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("daoProvider.getAceDao().addCommandToTimeline(this, timelineHandle);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public IDataContainer getCommandData() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return commandData;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@SuppressWarnings(\"unchecked\")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void setCommandData(IDataContainer data) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("commandData = (T)data;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String getCommandName() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return commandName;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void throwUnauthorized() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("throw new WebApplicationException(Response.Status.UNAUTHORIZED);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void throwBadRequest() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("throw new WebApplicationException(Response.Status.BAD_REQUEST);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void throwBadRequest(String error) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("throw new WebApplicationException(error, Response.Status.BAD_REQUEST);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void throwForbidden(String error) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("throw new WebApplicationException(error, Response.Status.FORBIDDEN);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void throwInternalServerError(Exception x) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String message = x.getMessage();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("StackTraceElement[] stackTrace = x.getStackTrace();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("int i = 1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for (StackTraceElement stackTraceElement : stackTrace) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("message += \"\\n\" + stackTraceElement.toString();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (i > 3) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("message += \"\\n\" + (stackTrace.length - 4) + \" more...\";");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("break;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("i++;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("throw new WebApplicationException(message, Response.Status.INTERNAL_SERVER_ERROR);");
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
  
  public CharSequence generateICommand() {
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
    _builder.append("public interface ICommand {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String getCommandName();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("IDataContainer getCommandData();");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("void setCommandData(IDataContainer data);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("void execute(Handle readonlyHandle, Handle timelineHandle);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("void publishEvents(Handle handle, Handle timelineHandle);");
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
}
