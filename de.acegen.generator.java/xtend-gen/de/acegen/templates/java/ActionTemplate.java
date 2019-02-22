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

import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.AuthUser;
import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.aceGen.HttpServerAceRead;
import de.acegen.aceGen.HttpServerAceWrite;
import de.acegen.aceGen.HttpServerOutcome;
import de.acegen.aceGen.HttpServerViewFunction;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.java.AceExtension;
import de.acegen.extensions.java.AttributeExtension;
import de.acegen.extensions.java.ModelExtension;
import de.acegen.extensions.java.ViewExtension;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ActionTemplate {
  @Inject
  @Extension
  private ModelExtension _modelExtension;
  
  @Inject
  @Extension
  private AceExtension _aceExtension;
  
  @Inject
  @Extension
  private ViewExtension _viewExtension;
  
  @Inject
  @Extension
  private AttributeExtension _attributeExtension;
  
  @Inject
  @Extension
  private CommonExtension _commonExtension;
  
  protected CharSequence _generateAbstractActionFile(final HttpServerAceWrite it, final HttpServer java, final AuthUser authUser) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = java.getName();
    _builder.append(_name);
    _builder.append(".actions;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.util.UUID;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import javax.validation.constraints.NotNull;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.Consumes;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.POST;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.PUT;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.DELETE;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.GET;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.Path;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.Produces;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.core.MediaType;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.core.Response;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.QueryParam;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.PathParam;");
    _builder.newLine();
    _builder.append("import io.dropwizard.auth.Auth;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.HeaderParam;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.CustomAppConfiguration;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.ViewProvider;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.IDaoProvider;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.IDataContainer;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.App;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.DatabaseHandle;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.ServerConfiguration;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.E2E;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.ITimelineItem;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.IAction;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.SetSystemTimeResource;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.JodaObjectMapper;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.codahale.metrics.annotation.Timed;");
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.core.JsonProcessingException;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.jdbi.v3.core.Jdbi;");
    _builder.newLine();
    _builder.append("import org.jdbi.v3.core.Handle;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.Action;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.HttpMethod;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.ICommand;");
    _builder.newLine();
    _builder.append("import org.joda.time.DateTime;");
    _builder.newLine();
    _builder.append("import org.joda.time.DateTimeZone;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import javax.ws.rs.WebApplicationException;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    {
      if ((it.isAuthorize() && (authUser != null))) {
        _builder.append("import com.anfelisa.auth.");
        String _firstUpper = StringExtensions.toFirstUpper(authUser.getName());
        _builder.append(_firstUpper);
        _builder.append(";");
      }
    }
    _builder.newLineIfNotEmpty();
    String _dataImport = this._modelExtension.dataImport(it.getModel());
    _builder.append(_dataImport);
    _builder.newLineIfNotEmpty();
    String _dataClassImport = this._modelExtension.dataClassImport(it.getModel());
    _builder.append(_dataClassImport);
    _builder.newLineIfNotEmpty();
    {
      int _size = it.getOutcomes().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        _builder.append("import ");
        String _commandNameWithPackage = this._aceExtension.commandNameWithPackage(it, java);
        _builder.append(_commandNameWithPackage);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("@Path(\"");
    String _url = it.getUrl();
    _builder.append(_url);
    _builder.append("\")");
    _builder.newLineIfNotEmpty();
    _builder.append("@SuppressWarnings(\"unused\")");
    _builder.newLine();
    _builder.append("public abstract class ");
    String _abstractActionName = this._aceExtension.abstractActionName(it);
    _builder.append(_abstractActionName);
    _builder.append(" extends Action<");
    String _dataParamType = this._modelExtension.dataParamType(it.getModel());
    _builder.append(_dataParamType);
    _builder.append("> {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final Logger LOG = LoggerFactory.getLogger(");
    String _abstractActionName_1 = this._aceExtension.abstractActionName(it);
    _builder.append(_abstractActionName_1, "\t");
    _builder.append(".class);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private DatabaseHandle databaseHandle;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private Jdbi jdbi;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected JodaObjectMapper mapper;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected CustomAppConfiguration appConfiguration;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected IDaoProvider daoProvider;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private ViewProvider viewProvider;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private E2E e2e;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _abstractActionName_2 = this._aceExtension.abstractActionName(it);
    _builder.append(_abstractActionName_2, "\t");
    _builder.append("(Jdbi jdbi, CustomAppConfiguration appConfiguration, ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super(\"");
    String _actionNameWithPackage = this._aceExtension.actionNameWithPackage(it, java);
    _builder.append(_actionNameWithPackage, "\t\t");
    _builder.append("\", HttpMethod.");
    String _type = it.getType();
    _builder.append(_type, "\t\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("this.jdbi = jdbi;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("mapper = new JodaObjectMapper();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.appConfiguration = appConfiguration;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.daoProvider = daoProvider;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.viewProvider = viewProvider;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.e2e = e2e;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ICommand getCommand() {");
    _builder.newLine();
    {
      int _size_1 = it.getOutcomes().size();
      boolean _greaterThan_1 = (_size_1 > 0);
      if (_greaterThan_1) {
        _builder.append("\t\t");
        _builder.append("return new ");
        String _commandName = this._aceExtension.commandName(it);
        _builder.append(_commandName, "\t\t");
        _builder.append("(this.actionData, daoProvider, viewProvider, this.appConfiguration);");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("\t\t");
        _builder.append("return null;");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void setActionData(IDataContainer data) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.actionData = (");
    String _dataParamType_1 = this._modelExtension.dataParamType(it.getModel());
    _builder.append(_dataParamType_1, "\t\t");
    _builder.append(")data;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    {
      String _type_1 = it.getType();
      boolean _tripleNotEquals = (_type_1 != null);
      if (_tripleNotEquals) {
        _builder.append("@");
        String _type_2 = it.getType();
        _builder.append(_type_2, "\t");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("@Timed");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Produces(MediaType.APPLICATION_JSON)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Consumes(MediaType.APPLICATION_JSON)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Response ");
    String _firstLower = StringExtensions.toFirstLower(this._aceExtension.resourceName(it));
    _builder.append(_firstLower, "\t");
    _builder.append("(");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    {
      if ((it.isAuthorize() && (authUser != null))) {
        _builder.append("@Auth ");
        String _firstUpper_1 = StringExtensions.toFirstUpper(authUser.getName());
        _builder.append(_firstUpper_1, "\t\t\t");
        _builder.append(" ");
        String _firstLower_1 = StringExtensions.toFirstLower(authUser.getName());
        _builder.append(_firstLower_1, "\t\t\t");
        _builder.append(", ");
      }
    }
    _builder.newLineIfNotEmpty();
    {
      EList<Attribute> _queryParams = it.getQueryParams();
      for(final Attribute param : _queryParams) {
        _builder.append("\t\t\t");
        _builder.append("@QueryParam(\"");
        String _name_1 = param.getName();
        _builder.append(_name_1, "\t\t\t");
        _builder.append("\") ");
        String _resourceParamType = this._attributeExtension.resourceParamType(param);
        _builder.append(_resourceParamType, "\t\t\t");
        _builder.append(" ");
        String _name_2 = param.getName();
        _builder.append(_name_2, "\t\t\t");
        _builder.append(", ");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<Attribute> _pathParams = it.getPathParams();
      for(final Attribute param_1 : _pathParams) {
        _builder.append("\t\t\t");
        _builder.append("@PathParam(\"");
        String _name_3 = param_1.getName();
        _builder.append(_name_3, "\t\t\t");
        _builder.append("\") ");
        String _resourceParamType_1 = this._attributeExtension.resourceParamType(param_1);
        _builder.append(_resourceParamType_1, "\t\t\t");
        _builder.append(" ");
        String _name_4 = param_1.getName();
        _builder.append(_name_4, "\t\t\t");
        _builder.append(", ");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t\t");
    {
      int _size_2 = it.getPayload().size();
      boolean _greaterThan_2 = (_size_2 > 0);
      if (_greaterThan_2) {
        _builder.append("@NotNull ");
        String _dataParamType_2 = this._modelExtension.dataParamType(it.getModel());
        _builder.append(_dataParamType_2, "\t\t\t");
        _builder.append(" payload)");
      } else {
        _builder.append("@NotNull @QueryParam(\"uuid\") String uuid)");
      }
    }
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("throws JsonProcessingException {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.actionData = new ");
    String _dataName = this._modelExtension.dataName(it.getModel());
    _builder.append(_dataName, "\t\t");
    _builder.append("(");
    {
      int _size_3 = it.getPayload().size();
      boolean _greaterThan_3 = (_size_3 > 0);
      if (_greaterThan_3) {
        _builder.append("payload.getUuid()");
      } else {
        _builder.append("uuid");
      }
    }
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    {
      EList<Attribute> _queryParams_1 = it.getQueryParams();
      for(final Attribute param_2 : _queryParams_1) {
        _builder.append("\t\t");
        _builder.append("this.actionData.");
        String _setterCall = this._attributeExtension.setterCall(param_2, this._attributeExtension.resourceParam(param_2));
        _builder.append(_setterCall, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<Attribute> _pathParams_1 = it.getPathParams();
      for(final Attribute param_3 : _pathParams_1) {
        _builder.append("\t\t");
        _builder.append("this.actionData.");
        String _setterCall_1 = this._attributeExtension.setterCall(param_3, this._attributeExtension.resourceParam(param_3));
        _builder.append(_setterCall_1, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<Attribute> _payload = it.getPayload();
      for(final Attribute attribute : _payload) {
        _builder.append("\t\t");
        _builder.append("this.actionData.");
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("payload.");
        String _terCall = this._attributeExtension.getterCall(attribute);
        _builder_1.append(_terCall);
        String _setterCall_2 = this._attributeExtension.setterCall(attribute, _builder_1.toString());
        _builder.append(_setterCall_2, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      if ((it.isAuthorize() && (authUser != null))) {
        {
          List<Attribute> _allAttributes = this._modelExtension.allAttributes(it.getModel());
          for(final Attribute param_4 : _allAttributes) {
            _builder.append("\t\t");
            {
              boolean _containsAttribute = this._commonExtension.containsAttribute(authUser.getAttributes(), param_4);
              if (_containsAttribute) {
                _builder.append("this.actionData.");
                StringConcatenation _builder_2 = new StringConcatenation();
                String _firstLower_2 = StringExtensions.toFirstLower(authUser.getName());
                _builder_2.append(_firstLower_2);
                _builder_2.append(".");
                String _terCall_1 = this._attributeExtension.getterCall(param_4);
                _builder_2.append(_terCall_1);
                String _setterCall_3 = this._attributeExtension.setterCall(param_4, _builder_2.toString());
                _builder.append(_setterCall_3, "\t\t");
                _builder.append(";");
              }
            }
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return this.apply();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Response apply() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("databaseHandle = new DatabaseHandle(jdbi);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("databaseHandle.beginTransaction();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (ServerConfiguration.DEV.equals(appConfiguration.getServerConfiguration().getMode())");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("|| ServerConfiguration.LIVE.equals(appConfiguration.getServerConfiguration().getMode())) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (daoProvider.getAceDao().contains(databaseHandle.getHandle(), this.actionData.getUuid())) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("databaseHandle.commitTransaction();");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("throwBadRequest(\"uuid already exists - please choose another one\");");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("this.actionData.setSystemTime(new DateTime());");
    _builder.newLine();
    {
      EList<HttpServerOutcome> _outcomes = it.getOutcomes();
      for(final HttpServerOutcome outcome : _outcomes) {
        {
          EList<HttpServerAceWrite> _aceOperations = outcome.getAceOperations();
          for(final HttpServerAceWrite triggeredAction : _aceOperations) {
            _builder.append("\t\t\t\t");
            _builder.append("this.actionData.addUuidForTriggeredAction(\"");
            String _actionNameWithPackage_1 = this._aceExtension.actionNameWithPackage(triggeredAction);
            _builder.append(_actionNameWithPackage_1, "\t\t\t\t");
            _builder.append("\", UUID.randomUUID().toString());");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\t\t\t\t");
    _builder.append("this.initActionData();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("} else if (ServerConfiguration.REPLAY.equals(appConfiguration.getServerConfiguration().getMode())) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("ITimelineItem timelineItem = e2e.selectAction(this.actionData.getUuid());");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("IDataContainer originalData = AceDataFactory.createAceData(timelineItem.getName(), timelineItem.getData());");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("this.actionData = (");
    String _dataParamType_3 = this._modelExtension.dataParamType(it.getModel());
    _builder.append(_dataParamType_3, "\t\t\t\t");
    _builder.append(")originalData;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("} else if (ServerConfiguration.TEST.equals(appConfiguration.getServerConfiguration().getMode())) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (SetSystemTimeResource.systemTime != null) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("this.actionData.setSystemTime(SetSystemTimeResource.systemTime);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("this.actionData.setSystemTime(new DateTime());");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    {
      EList<HttpServerOutcome> _outcomes_1 = it.getOutcomes();
      for(final HttpServerOutcome outcome_1 : _outcomes_1) {
        {
          EList<HttpServerAceWrite> _aceOperations_1 = outcome_1.getAceOperations();
          for(final HttpServerAceWrite triggeredAction_1 : _aceOperations_1) {
            _builder.append("\t\t\t\t");
            _builder.append("this.actionData.addUuidForTriggeredAction(\"");
            String _actionNameWithPackage_2 = this._aceExtension.actionNameWithPackage(triggeredAction_1);
            _builder.append(_actionNameWithPackage_2, "\t\t\t\t");
            _builder.append("\", UUID.randomUUID().toString());");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("daoProvider.getAceDao().addActionToTimeline(this, this.databaseHandle.getTimelineHandle());");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("ICommand command = this.getCommand();");
    _builder.newLine();
    {
      boolean _isProxy = it.isProxy();
      if (_isProxy) {
        _builder.append("\t\t\t");
        _builder.append("if (ServerConfiguration.REPLAY.equals(appConfiguration.getServerConfiguration().getMode())) {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("\t");
        _builder.append("ITimelineItem timelineItem = e2e.selectCommand(this.actionData.getUuid());");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("\t");
        _builder.append("IDataContainer originalData = AceDataFactory.createAceData(timelineItem.getName(), timelineItem.getData());");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("\t");
        _builder.append("command.setCommandData(originalData);");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("} else {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("\t");
        _builder.append("command.execute(this.databaseHandle.getReadonlyHandle(), this.databaseHandle.getTimelineHandle());");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("}");
        _builder.newLine();
      } else {
        _builder.append("\t\t\t");
        _builder.append("command.execute(this.databaseHandle.getReadonlyHandle(), this.databaseHandle.getTimelineHandle());");
        _builder.newLine();
      }
    }
    _builder.append("\t\t\t");
    _builder.append("command.publishEvents(this.databaseHandle.getHandle(), this.databaseHandle.getTimelineHandle());");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("Response response = Response.ok(this.createReponse()).build();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("databaseHandle.commitTransaction();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    {
      EList<HttpServerOutcome> _outcomes_2 = it.getOutcomes();
      for(final HttpServerOutcome outcome_2 : _outcomes_2) {
        {
          EList<HttpServerAceWrite> _aceOperations_2 = outcome_2.getAceOperations();
          for(final HttpServerAceWrite triggeredAction_2 : _aceOperations_2) {
            _builder.append("\t\t\t");
            String _firstUpper_2 = StringExtensions.toFirstUpper(triggeredAction_2.getName());
            _builder.append(_firstUpper_2, "\t\t\t");
            _builder.append("Thread ");
            String _firstLower_3 = StringExtensions.toFirstLower(triggeredAction_2.getName());
            _builder.append(_firstLower_3, "\t\t\t");
            _builder.append("Thread = new ");
            String _firstUpper_3 = StringExtensions.toFirstUpper(triggeredAction_2.getName());
            _builder.append(_firstUpper_3, "\t\t\t");
            _builder.append("Thread(");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t");
            _builder.append("\t");
            _builder.append("jdbi, mapper, appConfiguration, daoProvider, viewProvider, e2e, command.getCommandData());");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("e2e.addTriggeredThread(");
            String _firstLower_4 = StringExtensions.toFirstLower(triggeredAction_2.getName());
            _builder.append(_firstLower_4, "\t\t\t");
            _builder.append("Thread);");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t");
            String _firstLower_5 = StringExtensions.toFirstLower(triggeredAction_2.getName());
            _builder.append(_firstLower_5, "\t\t\t");
            _builder.append("Thread.start();");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t\t\t");
        _builder.newLine();
      }
    }
    _builder.append("\t\t\t");
    _builder.append("return response;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} catch (WebApplicationException x) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("LOG.error(actionName + \" failed \" + x.getMessage());");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("databaseHandle.rollbackTransaction();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("daoProvider.getAceDao().addExceptionToTimeline(this.actionData.getUuid(), x, this.databaseHandle.getTimelineHandle());");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("App.reportException(x);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("} catch (Exception ex) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("LOG.error(\"failed to rollback or to save or report exception \" + ex.getMessage());");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return Response.status(x.getResponse().getStatusInfo()).entity(x.getMessage()).build();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} catch (Exception x) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("LOG.error(actionName + \" failed \" + x.getMessage());");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("databaseHandle.rollbackTransaction();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("daoProvider.getAceDao().addExceptionToTimeline(this.actionData.getUuid(), x, this.databaseHandle.getTimelineHandle());");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("App.reportException(x);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("} catch (Exception ex) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("LOG.error(\"failed to rollback or to save or report exception \" + ex.getMessage());");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return Response.status(500).entity(x.getMessage()).build();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} finally {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("databaseHandle.close();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      EList<HttpServerOutcome> _outcomes_3 = it.getOutcomes();
      for(final HttpServerOutcome outcome_3 : _outcomes_3) {
        {
          EList<HttpServerAceWrite> _aceOperations_3 = outcome_3.getAceOperations();
          for(final HttpServerAceWrite triggeredAction_3 : _aceOperations_3) {
            _builder.append("\t");
            _builder.append("public class ");
            String _firstUpper_4 = StringExtensions.toFirstUpper(triggeredAction_3.getName());
            _builder.append(_firstUpper_4, "\t");
            _builder.append("Thread extends Thread {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("private Jdbi jdbi;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("private JodaObjectMapper mapper;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("private CustomAppConfiguration appConfiguration;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("private IDaoProvider daoProvider;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("private ViewProvider viewProvider;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("private IDataContainer commandData;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("private E2E e2e;");
            _builder.newLine();
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("public ");
            String _firstUpper_5 = StringExtensions.toFirstUpper(triggeredAction_3.getName());
            _builder.append(_firstUpper_5, "\t\t");
            _builder.append("Thread(Jdbi jdbi, JodaObjectMapper mapper, CustomAppConfiguration appConfiguration,");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e, IDataContainer commandData) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t   ");
            _builder.append("this.jdbi = jdbi;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t   ");
            _builder.append("this.mapper = mapper;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t   ");
            _builder.append("this.appConfiguration = appConfiguration;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t   ");
            _builder.append("this.daoProvider = daoProvider;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t   ");
            _builder.append("this.viewProvider = viewProvider;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t   ");
            _builder.append("this.e2e = e2e;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t   ");
            _builder.append("this.commandData = commandData;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t   ");
            _builder.append("this.setName(\"");
            String _firstUpper_6 = StringExtensions.toFirstUpper(triggeredAction_3.getName());
            _builder.append(_firstUpper_6, "\t\t   ");
            _builder.append("Thread\");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("public void run() {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("try {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("LOG.info(\"trigger ");
            String _name_5 = triggeredAction_3.getName();
            _builder.append(_name_5, "\t\t\t\t");
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t\t");
            String _actionNameWithPackage_3 = this._aceExtension.actionNameWithPackage(triggeredAction_3);
            _builder.append(_actionNameWithPackage_3, "\t\t\t\t");
            _builder.append(" ");
            String _firstLower_6 = StringExtensions.toFirstLower(triggeredAction_3.getName());
            _builder.append(_firstLower_6, "\t\t\t\t");
            _builder.append(" ");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t\t\t");
            _builder.append("= new ");
            String _actionNameWithPackage_4 = this._aceExtension.actionNameWithPackage(triggeredAction_3);
            _builder.append(_actionNameWithPackage_4, "\t\t\t\t\t");
            _builder.append("(jdbi, appConfiguration, daoProvider, viewProvider, e2e);");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("IDataContainer data = AceDataFactory.createAceData(\"");
            String _actionNameWithPackage_5 = this._aceExtension.actionNameWithPackage(triggeredAction_3);
            _builder.append(_actionNameWithPackage_5, "\t\t\t\t");
            _builder.append("\", mapper.writeValueAsString(commandData));");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("data.setUuid(commandData.getUuidForTriggeredAction(\"");
            String _actionNameWithPackage_6 = this._aceExtension.actionNameWithPackage(triggeredAction_3);
            _builder.append(_actionNameWithPackage_6, "\t\t\t\t");
            _builder.append("\"));");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t\t");
            String _firstLower_7 = StringExtensions.toFirstLower(triggeredAction_3.getName());
            _builder.append(_firstLower_7, "\t\t\t\t");
            _builder.append(".setActionData(data);");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t\t");
            String _firstLower_8 = StringExtensions.toFirstLower(triggeredAction_3.getName());
            _builder.append(_firstLower_8, "\t\t\t\t");
            _builder.append(".apply();");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("LOG.info(\"trigger ");
            String _name_6 = triggeredAction_3.getName();
            _builder.append(_name_6, "\t\t\t\t");
            _builder.append(" finished\");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("} catch (Exception x) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("LOG.error(\"failed to trigger ");
            String _name_7 = triggeredAction_3.getName();
            _builder.append(_name_7, "\t\t\t\t");
            _builder.append(" \" + x.getMessage());");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("};");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    {
      int _size_4 = it.getResponse().size();
      boolean _greaterThan_4 = (_size_4 > 0);
      if (_greaterThan_4) {
        _builder.append("\t");
        _builder.append("protected Object createReponse() {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return new ");
        String _responseDataNameWithPackage = this._aceExtension.responseDataNameWithPackage(it, java);
        _builder.append(_responseDataNameWithPackage, "\t\t");
        _builder.append("(this.actionData);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
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
  
  protected CharSequence _generateAbstractActionFile(final HttpServerAceRead it, final HttpServer java, final AuthUser authUser) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = java.getName();
    _builder.append(_name);
    _builder.append(".actions;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import javax.validation.constraints.NotNull;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.Consumes;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.POST;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.PUT;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.DELETE;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.GET;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.Path;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.Produces;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.core.MediaType;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.core.Response;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.QueryParam;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.PathParam;");
    _builder.newLine();
    _builder.append("import io.dropwizard.auth.Auth;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.CustomAppConfiguration;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.ViewProvider;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.IDaoProvider;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.IDataContainer;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.App;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.DatabaseHandle;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.ServerConfiguration;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.E2E;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.ITimelineItem;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.IAction;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.SetSystemTimeResource;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.JodaObjectMapper;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.codahale.metrics.annotation.Timed;");
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.core.JsonProcessingException;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.jdbi.v3.core.Jdbi;");
    _builder.newLine();
    _builder.append("import org.jdbi.v3.core.Handle;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.Action;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.HttpMethod;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.ICommand;");
    _builder.newLine();
    _builder.append("import org.joda.time.DateTime;");
    _builder.newLine();
    _builder.append("import org.joda.time.DateTimeZone;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import javax.ws.rs.WebApplicationException;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    {
      if ((it.isAuthorize() && (authUser != null))) {
        _builder.append("import com.anfelisa.auth.");
        String _firstUpper = StringExtensions.toFirstUpper(authUser.getName());
        _builder.append(_firstUpper);
        _builder.append(";");
      }
    }
    _builder.newLineIfNotEmpty();
    String _dataImport = this._modelExtension.dataImport(it.getModel());
    _builder.append(_dataImport);
    _builder.newLineIfNotEmpty();
    String _dataClassImport = this._modelExtension.dataClassImport(it.getModel());
    _builder.append(_dataClassImport);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("@Path(\"");
    String _url = it.getUrl();
    _builder.append(_url);
    _builder.append("\")");
    _builder.newLineIfNotEmpty();
    _builder.append("@SuppressWarnings(\"unused\")");
    _builder.newLine();
    _builder.append("public abstract class ");
    String _abstractActionName = this._aceExtension.abstractActionName(it);
    _builder.append(_abstractActionName);
    _builder.append(" extends Action<");
    String _dataParamType = this._modelExtension.dataParamType(it.getModel());
    _builder.append(_dataParamType);
    _builder.append("> {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final Logger LOG = LoggerFactory.getLogger(");
    String _abstractActionName_1 = this._aceExtension.abstractActionName(it);
    _builder.append(_abstractActionName_1, "\t");
    _builder.append(".class);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private DatabaseHandle databaseHandle;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private Jdbi jdbi;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected JodaObjectMapper mapper;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected CustomAppConfiguration appConfiguration;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected IDaoProvider daoProvider;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private ViewProvider viewProvider;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private E2E e2e;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _abstractActionName_2 = this._aceExtension.abstractActionName(it);
    _builder.append(_abstractActionName_2, "\t");
    _builder.append("(Jdbi jdbi, CustomAppConfiguration appConfiguration, ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super(\"");
    String _actionNameWithPackage = this._aceExtension.actionNameWithPackage(it, java);
    _builder.append(_actionNameWithPackage, "\t\t");
    _builder.append("\", HttpMethod.");
    String _type = it.getType();
    _builder.append(_type, "\t\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("this.jdbi = jdbi;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("mapper = new JodaObjectMapper();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.appConfiguration = appConfiguration;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.daoProvider = daoProvider;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.viewProvider = viewProvider;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.e2e = e2e;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ICommand getCommand() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void setActionData(IDataContainer data) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.actionData = (");
    String _dataParamType_1 = this._modelExtension.dataParamType(it.getModel());
    _builder.append(_dataParamType_1, "\t\t");
    _builder.append(")data;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract void loadDataForGetRequest(Handle readonlyHandle);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    {
      String _type_1 = it.getType();
      boolean _tripleNotEquals = (_type_1 != null);
      if (_tripleNotEquals) {
        _builder.append("@");
        String _type_2 = it.getType();
        _builder.append(_type_2, "\t");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("@Timed");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Produces(MediaType.APPLICATION_JSON)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Consumes(MediaType.APPLICATION_JSON)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Response ");
    String _firstLower = StringExtensions.toFirstLower(this._aceExtension.resourceName(it));
    _builder.append(_firstLower, "\t");
    _builder.append("(");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    {
      if ((it.isAuthorize() && (authUser != null))) {
        _builder.append("@Auth ");
        String _firstUpper_1 = StringExtensions.toFirstUpper(authUser.getName());
        _builder.append(_firstUpper_1, "\t\t\t");
        _builder.append(" ");
        String _firstLower_1 = StringExtensions.toFirstLower(authUser.getName());
        _builder.append(_firstLower_1, "\t\t\t");
        _builder.append(", ");
      }
    }
    _builder.newLineIfNotEmpty();
    {
      EList<Attribute> _queryParams = it.getQueryParams();
      for(final Attribute param : _queryParams) {
        _builder.append("\t\t\t");
        _builder.append("@QueryParam(\"");
        String _name_1 = param.getName();
        _builder.append(_name_1, "\t\t\t");
        _builder.append("\") ");
        String _resourceParamType = this._attributeExtension.resourceParamType(param);
        _builder.append(_resourceParamType, "\t\t\t");
        _builder.append(" ");
        String _name_2 = param.getName();
        _builder.append(_name_2, "\t\t\t");
        _builder.append(", ");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<Attribute> _pathParams = it.getPathParams();
      for(final Attribute param_1 : _pathParams) {
        _builder.append("\t\t\t");
        _builder.append("@PathParam(\"");
        String _name_3 = param_1.getName();
        _builder.append(_name_3, "\t\t\t");
        _builder.append("\") ");
        String _resourceParamType_1 = this._attributeExtension.resourceParamType(param_1);
        _builder.append(_resourceParamType_1, "\t\t\t");
        _builder.append(" ");
        String _name_4 = param_1.getName();
        _builder.append(_name_4, "\t\t\t");
        _builder.append(", ");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t\t");
    {
      int _size = it.getPayload().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        _builder.append("@NotNull ");
        String _dataParamType_2 = this._modelExtension.dataParamType(it.getModel());
        _builder.append(_dataParamType_2, "\t\t\t");
        _builder.append(" payload)");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
      } else {
        _builder.append("@NotNull @QueryParam(\"uuid\") String uuid)");
      }
    }
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("throws JsonProcessingException {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.actionData = new ");
    String _dataName = this._modelExtension.dataName(it.getModel());
    _builder.append(_dataName, "\t\t");
    _builder.append("(");
    {
      int _size_1 = it.getPayload().size();
      boolean _greaterThan_1 = (_size_1 > 0);
      if (_greaterThan_1) {
        _builder.append("payload.getUuid()");
      } else {
        _builder.append("uuid");
      }
    }
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    {
      EList<Attribute> _queryParams_1 = it.getQueryParams();
      for(final Attribute param_2 : _queryParams_1) {
        _builder.append("\t\t");
        _builder.append("this.actionData.");
        String _setterCall = this._attributeExtension.setterCall(param_2, this._attributeExtension.resourceParam(param_2));
        _builder.append(_setterCall, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<Attribute> _pathParams_1 = it.getPathParams();
      for(final Attribute param_3 : _pathParams_1) {
        _builder.append("\t\t");
        _builder.append("this.actionData.");
        String _setterCall_1 = this._attributeExtension.setterCall(param_3, this._attributeExtension.resourceParam(param_3));
        _builder.append(_setterCall_1, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<Attribute> _payload = it.getPayload();
      for(final Attribute attribute : _payload) {
        _builder.append("\t\t");
        _builder.append("this.actionData.");
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("payload.");
        String _terCall = this._attributeExtension.getterCall(attribute);
        _builder_1.append(_terCall);
        String _setterCall_2 = this._attributeExtension.setterCall(attribute, _builder_1.toString());
        _builder.append(_setterCall_2, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      if ((it.isAuthorize() && (authUser != null))) {
        {
          List<Attribute> _allAttributes = this._modelExtension.allAttributes(it.getModel());
          for(final Attribute param_4 : _allAttributes) {
            _builder.append("\t\t");
            {
              boolean _containsAttribute = this._commonExtension.containsAttribute(authUser.getAttributes(), param_4);
              if (_containsAttribute) {
                _builder.append("this.actionData.");
                StringConcatenation _builder_2 = new StringConcatenation();
                String _firstLower_2 = StringExtensions.toFirstLower(authUser.getName());
                _builder_2.append(_firstLower_2);
                _builder_2.append(".");
                String _terCall_1 = this._attributeExtension.getterCall(param_4);
                _builder_2.append(_terCall_1);
                String _setterCall_3 = this._attributeExtension.setterCall(param_4, _builder_2.toString());
                _builder.append(_setterCall_3, "\t\t");
                _builder.append(";");
              }
            }
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\t\t");
    _builder.append("return this.apply();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Response apply() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("databaseHandle = new DatabaseHandle(jdbi);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("databaseHandle.beginTransaction();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (ServerConfiguration.DEV.equals(appConfiguration.getServerConfiguration().getMode())");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("|| ServerConfiguration.LIVE.equals(appConfiguration.getServerConfiguration().getMode())) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (daoProvider.getAceDao().contains(databaseHandle.getHandle(), this.actionData.getUuid())) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("databaseHandle.commitTransaction();");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("throwBadRequest(\"uuid already exists - please choose another one\");");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("this.actionData.setSystemTime(new DateTime());");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("this.initActionData();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("} else if (ServerConfiguration.REPLAY.equals(appConfiguration.getServerConfiguration().getMode())) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("ITimelineItem timelineItem = e2e.selectAction(this.actionData.getUuid());");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("IDataContainer originalData = AceDataFactory.createAceData(timelineItem.getName(), timelineItem.getData());");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("this.actionData = (");
    String _dataParamType_3 = this._modelExtension.dataParamType(it.getModel());
    _builder.append(_dataParamType_3, "\t\t\t\t");
    _builder.append(")originalData;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("} else if (ServerConfiguration.TEST.equals(appConfiguration.getServerConfiguration().getMode())) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (SetSystemTimeResource.systemTime != null) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("this.actionData.setSystemTime(SetSystemTimeResource.systemTime);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("this.actionData.setSystemTime(new DateTime());");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    {
      boolean _isProxy = it.isProxy();
      if (_isProxy) {
        _builder.append("\t\t\t");
        _builder.append("if (!ServerConfiguration.REPLAY.equals(appConfiguration.getServerConfiguration().getMode())) {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("\t");
        _builder.append("this.loadDataForGetRequest(this.databaseHandle.getReadonlyHandle());");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("}");
        _builder.newLine();
      } else {
        _builder.append("\t\t\t");
        _builder.append("this.loadDataForGetRequest(this.databaseHandle.getReadonlyHandle());");
        _builder.newLine();
      }
    }
    _builder.append("\t\t\t");
    _builder.append("daoProvider.getAceDao().addActionToTimeline(this, this.databaseHandle.getTimelineHandle());");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("Response response = Response.ok(this.createReponse()).build();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("databaseHandle.commitTransaction();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return response;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} catch (WebApplicationException x) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("LOG.error(actionName + \" failed \" + x.getMessage());");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("databaseHandle.rollbackTransaction();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("daoProvider.getAceDao().addExceptionToTimeline(this.actionData.getUuid(), x, this.databaseHandle.getTimelineHandle());");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("App.reportException(x);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("} catch (Exception ex) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("LOG.error(\"failed to rollback or to save or report exception \" + ex.getMessage());");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return Response.status(x.getResponse().getStatusInfo()).entity(x.getMessage()).build();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} catch (Exception x) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("LOG.error(actionName + \" failed \" + x.getMessage());");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("databaseHandle.rollbackTransaction();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("daoProvider.getAceDao().addExceptionToTimeline(this.actionData.getUuid(), x, this.databaseHandle.getTimelineHandle());");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("App.reportException(x);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("} catch (Exception ex) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("LOG.error(\"failed to rollback or to save or report exception \" + ex.getMessage());");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return Response.status(500).entity(x.getMessage()).build();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} finally {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("databaseHandle.close();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    {
      int _size_2 = it.getResponse().size();
      boolean _greaterThan_2 = (_size_2 > 0);
      if (_greaterThan_2) {
        _builder.append("\t");
        _builder.append("protected Object createReponse() {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return new ");
        String _responseDataNameWithPackage = this._aceExtension.responseDataNameWithPackage(it, java);
        _builder.append(_responseDataNameWithPackage, "\t\t");
        _builder.append("(this.actionData);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
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
  
  public CharSequence generateInitialActionFile(final HttpServerAce it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = java.getName();
    _builder.append(_name);
    _builder.append(".actions;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.CustomAppConfiguration;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.ViewProvider;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.IDaoProvider;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.E2E;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.jdbi.v3.core.Handle;");
    _builder.newLine();
    _builder.append("import org.jdbi.v3.core.Jdbi;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _actionName = this._aceExtension.actionName(it);
    _builder.append(_actionName);
    _builder.append(" extends ");
    String _abstractActionName = this._aceExtension.abstractActionName(it);
    _builder.append(_abstractActionName);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final Logger LOG = LoggerFactory.getLogger(");
    String _actionName_1 = this._aceExtension.actionName(it);
    _builder.append(_actionName_1, "\t");
    _builder.append(".class);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _actionName_2 = this._aceExtension.actionName(it);
    _builder.append(_actionName_2, "\t");
    _builder.append("(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("ViewProvider viewProvider, E2E e2e) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super(jdbi,appConfiguration, daoProvider, viewProvider, e2e);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    {
      boolean _equals = it.getType().equals("GET");
      if (_equals) {
        _builder.append("\t");
        _builder.append("protected void loadDataForGetRequest(Handle readonlyHandle) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void initActionData() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// init not replayable data here");
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
  
  public CharSequence generateAction() {
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
    _builder.newLine();
    _builder.append("public abstract class Action<T extends IDataContainer> implements IAction {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected T actionData;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected String actionName;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private HttpMethod httpMethod;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Action(String actionName, HttpMethod httpMethod) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.actionName = actionName;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.httpMethod = httpMethod;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String getActionName() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return this.actionName;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public HttpMethod getHttpMethod() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return this.httpMethod;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public IDataContainer getActionData() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return this.actionData;");
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
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void throwServiceUnavailable(String error) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("throw new WebApplicationException(error, Response.Status.SERVICE_UNAVAILABLE);");
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
    _builder.append("\t");
    _builder.append("protected Object createReponse() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return this.actionData.getUuid();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateHttpMethod() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package com.anfelisa.ace;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public enum HttpMethod {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("GET, POST, PUT, DELETE");
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
  
  public CharSequence generateIAction() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package com.anfelisa.ace;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import javax.ws.rs.core.Response;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public interface IAction {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String getActionName();");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("HttpMethod getHttpMethod();");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("IDataContainer getActionData();");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("void setActionData(IDataContainer data);");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ICommand getCommand();");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("Response apply();");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("void initActionData();");
    _builder.newLine();
    _builder.append("    ");
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
  
  public CharSequence generateAppRegistration(final HttpServer it) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = it.getName();
    _builder.append(_name);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import io.dropwizard.setup.Environment;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.CustomAppConfiguration;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.AceExecutionMode;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.IDaoProvider;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.ViewProvider;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.ServerConfiguration;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.E2E;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.jdbi.v3.core.Jdbi;");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    {
      int _size = it.getAceOperations().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        _builder.append("import ");
        String _name_1 = it.getName();
        _builder.append(_name_1);
        _builder.append(".actions.*;");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"all\")");
    _builder.newLine();
    _builder.append("public class AppRegistration {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static void registerResources(Environment environment, Jdbi jdbi, CustomAppConfiguration appConfiguration, ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {");
    _builder.newLine();
    {
      EList<HttpServerAce> _aceOperations = it.getAceOperations();
      for(final HttpServerAce aceOperation : _aceOperations) {
        _builder.append("\t\t");
        _builder.append("environment.jersey().register(new ");
        String _actionName = this._aceExtension.actionName(aceOperation);
        _builder.append(_actionName, "\t\t");
        _builder.append("(jdbi, appConfiguration, daoProvider, viewProvider, e2e));");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static void registerConsumers(ViewProvider viewProvider, String mode) {");
    _builder.newLine();
    {
      EList<HttpServerAce> _aceOperations_1 = it.getAceOperations();
      for(final HttpServerAce aceOperation_1 : _aceOperations_1) {
        _builder.append("\t\t");
        CharSequence _registerConsumer = this.registerConsumer(aceOperation_1, it);
        _builder.append(_registerConsumer, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("    ");
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
  
  private CharSequence _registerConsumer(final HttpServerAceWrite it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<HttpServerOutcome> _outcomes = it.getOutcomes();
      for(final HttpServerOutcome outcome : _outcomes) {
        {
          EList<HttpServerViewFunction> _listeners = outcome.getListeners();
          for(final HttpServerViewFunction listener : _listeners) {
            CharSequence _addConsumers = this.addConsumers(java, it, outcome, listener);
            _builder.append(_addConsumers);
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  private CharSequence _registerConsumer(final HttpServerAceRead it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  private CharSequence addConsumers(final HttpServer java, final HttpServerAce aceOperation, final HttpServerOutcome outcome, final HttpServerViewFunction listener) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("viewProvider.addConsumer(\"");
    String _name = java.getName();
    _builder.append(_name);
    _builder.append(".events.");
    String _eventName = this._aceExtension.eventName(aceOperation, outcome);
    _builder.append(_eventName);
    _builder.append("\", (dataContainer, handle) -> {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("viewProvider.");
    String _viewFunctionWithViewNameAsVariable = this._viewExtension.viewFunctionWithViewNameAsVariable(listener);
    _builder.append(_viewFunctionWithViewNameAsVariable, "\t");
    _builder.append("((");
    String _dataNameWithPackage = this._modelExtension.dataNameWithPackage(listener.getModel());
    _builder.append(_dataNameWithPackage, "\t");
    _builder.append(") dataContainer, handle);");
    _builder.newLineIfNotEmpty();
    _builder.append("});");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateAceDataFactory(final HttpServer it) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = it.getName();
    _builder.append(_name);
    _builder.append(".actions;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.io.IOException;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.IDataContainer;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.JodaObjectMapper;");
    _builder.newLine();
    _builder.append("import ");
    String _name_1 = it.getName();
    _builder.append(_name_1);
    _builder.append(".data.*;");
    _builder.newLineIfNotEmpty();
    _builder.append("import com.fasterxml.jackson.databind.DeserializationFeature;\t\t");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class AceDataFactory {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static JodaObjectMapper mapper = new JodaObjectMapper();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static final Logger LOG = LoggerFactory.getLogger(AceDataFactory.class);");
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
    _builder.append("public static IDataContainer createAceData(String className, String json) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("try {");
    _builder.newLine();
    {
      EList<HttpServerAce> _aceOperations = it.getAceOperations();
      for(final HttpServerAce ace : _aceOperations) {
        _builder.append("\t\t\t");
        CharSequence _createData = this.createData(ace, it);
        _builder.append(_createData, "\t\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("} catch (IOException e) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("LOG.error(\"failed to create ace data {} with data {}\", className, json, e);");
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
  
  private CharSequence _createData(final HttpServerAceWrite it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (className.equals(\"");
    String _name = java.getName();
    _builder.append(_name);
    _builder.append(".actions.");
    String _actionName = this._aceExtension.actionName(it);
    _builder.append(_actionName);
    _builder.append("\") ||");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("className.equals(\"");
    String _name_1 = java.getName();
    _builder.append(_name_1, "\t\t");
    _builder.append(".commands.");
    String _commandName = this._aceExtension.commandName(it);
    _builder.append(_commandName, "\t\t");
    _builder.append("\") ");
    {
      int _length = ((Object[])Conversions.unwrapArray(it.getOutcomes(), Object.class)).length;
      boolean _greaterThan = (_length > 0);
      if (_greaterThan) {
        _builder.append("||");
      }
    }
    _builder.newLineIfNotEmpty();
    {
      EList<HttpServerOutcome> _outcomes = it.getOutcomes();
      boolean _hasElements = false;
      for(final HttpServerOutcome outcome : _outcomes) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("||", "\t\t");
        }
        _builder.append("\t\t");
        _builder.append("className.equals(\"");
        String _name_2 = java.getName();
        _builder.append(_name_2, "\t\t");
        _builder.append(".events.");
        String _eventName = this._aceExtension.eventName(it, outcome);
        _builder.append(_eventName, "\t\t");
        _builder.append("\")");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append(") {");
    _builder.newLine();
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
    _builder.append("return data;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence _createData(final HttpServerAceRead it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (className.equals(\"");
    String _name = java.getName();
    _builder.append(_name);
    _builder.append(".actions.");
    String _actionName = this._aceExtension.actionName(it);
    _builder.append(_actionName);
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
    _builder.append("return data;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateAbstractActionFile(final HttpServerAce it, final HttpServer java, final AuthUser authUser) {
    if (it instanceof HttpServerAceRead) {
      return _generateAbstractActionFile((HttpServerAceRead)it, java, authUser);
    } else if (it instanceof HttpServerAceWrite) {
      return _generateAbstractActionFile((HttpServerAceWrite)it, java, authUser);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, java, authUser).toString());
    }
  }
  
  private CharSequence registerConsumer(final HttpServerAce it, final HttpServer java) {
    if (it instanceof HttpServerAceRead) {
      return _registerConsumer((HttpServerAceRead)it, java);
    } else if (it instanceof HttpServerAceWrite) {
      return _registerConsumer((HttpServerAceWrite)it, java);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, java).toString());
    }
  }
  
  private CharSequence createData(final HttpServerAce it, final HttpServer java) {
    if (it instanceof HttpServerAceRead) {
      return _createData((HttpServerAceRead)it, java);
    } else if (it instanceof HttpServerAceWrite) {
      return _createData((HttpServerAceWrite)it, java);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, java).toString());
    }
  }
}
