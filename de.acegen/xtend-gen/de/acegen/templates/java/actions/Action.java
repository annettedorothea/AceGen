/**
 * Copyright (c) 2020 Annette Pohl
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License v. 2.0 are satisfied: GNU General Public License, version 2
 * with the GNU Classpath Exception which is available at
 * https://www.gnu.org/software/classpath/license.html.
 * 
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */
package de.acegen.templates.java.actions;

import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.aceGen.HttpServerAceRead;
import de.acegen.aceGen.HttpServerAceWrite;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.java.AceExtension;
import de.acegen.extensions.java.AttributeExtension;
import de.acegen.extensions.java.ModelExtension;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class Action {
  @Inject
  @Extension
  private ModelExtension _modelExtension;
  
  @Inject
  @Extension
  private AceExtension _aceExtension;
  
  @Inject
  @Extension
  private AttributeExtension _attributeExtension;
  
  @Inject
  @Extension
  private CommonExtension _commonExtension;
  
  protected CharSequence _generateAbstractActionFile(final HttpServerAceWrite it, final HttpServer httpServer) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = httpServer.getName();
    _builder.append(_name);
    _builder.append(".actions;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.time.LocalDateTime;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.apache.commons.lang3.StringUtils;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import de.acegen.CustomAppConfiguration;");
    _builder.newLine();
    _builder.append("import de.acegen.HttpMethod;");
    _builder.newLine();
    _builder.append("import de.acegen.ICommand;");
    _builder.newLine();
    _builder.append("import de.acegen.IDaoProvider;");
    _builder.newLine();
    _builder.append("import de.acegen.IDataContainer;");
    _builder.newLine();
    _builder.append("import de.acegen.ITimelineItem;");
    _builder.newLine();
    _builder.append("import de.acegen.ViewProvider;");
    _builder.newLine();
    _builder.append("import de.acegen.SquishyDataProvider;");
    _builder.newLine();
    _builder.append("import de.acegen.PersistenceConnection;");
    _builder.newLine();
    _builder.append("import de.acegen.WriteAction;");
    _builder.newLine();
    _builder.newLine();
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
        String _commandNameWithPackage = this._aceExtension.commandNameWithPackage(it);
        _builder.append(_commandNameWithPackage);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"unused\")");
    _builder.newLine();
    _builder.append("public abstract class ");
    String _abstractActionName = this._aceExtension.abstractActionName(it);
    _builder.append(_abstractActionName);
    _builder.append(" extends WriteAction<");
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
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _constructor = this.constructor(it);
    _builder.append(_constructor, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(\"");
    String _actionNameWithPackage = this._aceExtension.actionNameWithPackage(it);
    _builder.append(_actionNameWithPackage, "\t\t");
    _builder.append("\", persistenceConnection, appConfiguration, daoProvider,");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("viewProvider);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ICommand<");
    String _dataParamType_1 = this._modelExtension.dataParamType(it.getModel());
    _builder.append(_dataParamType_1, "\t");
    _builder.append("> getCommand() {");
    _builder.newLineIfNotEmpty();
    {
      int _size_1 = it.getOutcomes().size();
      boolean _greaterThan_1 = (_size_1 > 0);
      if (_greaterThan_1) {
        _builder.append("\t\t");
        _builder.append("return new ");
        String _commandName = this._aceExtension.commandName(it);
        _builder.append(_commandName, "\t\t");
        _builder.append("(daoProvider, viewProvider, this.appConfiguration);");
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
    CharSequence _initActionDataFromSquishyDataProvider = this.initActionDataFromSquishyDataProvider(it);
    _builder.append(_initActionDataFromSquishyDataProvider, "\t");
    _builder.append("\t\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _dataParamType_2 = this._modelExtension.dataParamType(it.getModel());
    _builder.append(_dataParamType_2, "\t");
    _builder.append(" initActionData(");
    String _dataParamType_3 = this._modelExtension.dataParamType(it.getModel());
    _builder.append(_dataParamType_3, "\t");
    _builder.append(" data) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("return data;");
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
  
  protected CharSequence _generateAbstractActionFile(final HttpServerAceRead it, final HttpServer httpServer) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = httpServer.getName();
    _builder.append(_name);
    _builder.append(".actions;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.time.LocalDateTime;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.apache.commons.lang3.StringUtils;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import de.acegen.CustomAppConfiguration;");
    _builder.newLine();
    _builder.append("import de.acegen.IDaoProvider;");
    _builder.newLine();
    _builder.append("import de.acegen.IDataContainer;");
    _builder.newLine();
    _builder.append("import de.acegen.ViewProvider;");
    _builder.newLine();
    _builder.append("import de.acegen.PersistenceConnection;");
    _builder.newLine();
    _builder.append("import de.acegen.PersistenceHandle;");
    _builder.newLine();
    _builder.append("import de.acegen.ReadAction;");
    _builder.newLine();
    _builder.append("import de.acegen.ITimelineItem;");
    _builder.newLine();
    _builder.append("import de.acegen.SquishyDataProvider;");
    _builder.newLine();
    _builder.newLine();
    String _dataImport = this._modelExtension.dataImport(it.getModel());
    _builder.append(_dataImport);
    _builder.newLineIfNotEmpty();
    String _dataClassImport = this._modelExtension.dataClassImport(it.getModel());
    _builder.append(_dataClassImport);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"unused\")");
    _builder.newLine();
    _builder.append("public abstract class ");
    String _abstractActionName = this._aceExtension.abstractActionName(it);
    _builder.append(_abstractActionName);
    _builder.append(" extends ReadAction<");
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
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _constructor = this.constructor(it);
    _builder.append(_constructor, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(\"");
    String _actionNameWithPackage = this._aceExtension.actionNameWithPackage(it);
    _builder.append(_actionNameWithPackage, "\t\t");
    _builder.append("\", persistenceConnection, appConfiguration, daoProvider, viewProvider);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract ");
    String _dataParamType_1 = this._modelExtension.dataParamType(it.getModel());
    _builder.append(_dataParamType_1, "\t");
    _builder.append(" loadDataForGetRequest(");
    String _dataParamType_2 = this._modelExtension.dataParamType(it.getModel());
    _builder.append(_dataParamType_2, "\t");
    _builder.append(" data, PersistenceHandle readonlyHandle);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _initActionDataFromSquishyDataProvider = this.initActionDataFromSquishyDataProvider(it);
    _builder.append(_initActionDataFromSquishyDataProvider, "\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _dataParamType_3 = this._modelExtension.dataParamType(it.getModel());
    _builder.append(_dataParamType_3, "\t");
    _builder.append(" initActionData(");
    String _dataParamType_4 = this._modelExtension.dataParamType(it.getModel());
    _builder.append(_dataParamType_4, "\t");
    _builder.append(" data) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("return data;");
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
  
  public CharSequence generateInitialActionFile(final HttpServerAce it, final HttpServer httpServer) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = httpServer.getName();
    _builder.append(_name);
    _builder.append(".actions;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import de.acegen.CustomAppConfiguration;");
    _builder.newLine();
    _builder.append("import de.acegen.ViewProvider;");
    _builder.newLine();
    _builder.append("import de.acegen.IDaoProvider;");
    _builder.newLine();
    _builder.append("import de.acegen.PersistenceConnection;");
    _builder.newLine();
    {
      boolean _equals = it.getType().equals("GET");
      if (_equals) {
        _builder.append("import de.acegen.PersistenceHandle;");
        _builder.newLine();
      }
    }
    {
      if (((this._modelExtension.allNonDeterministicAttributes(it.getModel()).size() > 0) || it.getType().equals("GET"))) {
        String _dataImport = this._modelExtension.dataImport(it.getModel());
        _builder.append(_dataImport);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
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
    _builder.append("(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("ViewProvider viewProvider) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super(persistenceConnection, appConfiguration, daoProvider, viewProvider);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    {
      boolean _equals_1 = it.getType().equals("GET");
      if (_equals_1) {
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected ");
        String _dataParamType = this._modelExtension.dataParamType(it.getModel());
        _builder.append(_dataParamType, "\t");
        _builder.append(" loadDataForGetRequest(");
        String _dataParamType_1 = this._modelExtension.dataParamType(it.getModel());
        _builder.append(_dataParamType_1, "\t");
        _builder.append(" data, PersistenceHandle readonlyHandle) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        String _interfaceWithPackage = this._modelExtension.interfaceWithPackage(it.getModel());
        _builder.append(_interfaceWithPackage, "\t\t");
        _builder.append(" testData = ");
        String _dataNameWithPackage = this._modelExtension.dataNameWithPackage(it.getModel());
        _builder.append(_dataNameWithPackage, "\t\t");
        _builder.append(".generateTestData();");
        _builder.newLineIfNotEmpty();
        {
          EList<Attribute> _attributes = it.getModel().getAttributes();
          for(final Attribute attribute : _attributes) {
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("data.");
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("testData.");
            String _terCall = this._attributeExtension.getterCall(attribute);
            _builder_1.append(_terCall);
            String _setterCall = this._attributeExtension.setterCall(attribute, _builder_1.toString());
            _builder.append(_setterCall, "\t\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return data;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    {
      int _size = this._modelExtension.allNonDeterministicAttributes(it.getModel()).size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        _builder.append("\t");
        _builder.append("public ");
        String _dataParamType_2 = this._modelExtension.dataParamType(it.getModel());
        _builder.append(_dataParamType_2, "\t");
        _builder.append(" initActionData(");
        String _dataParamType_3 = this._modelExtension.dataParamType(it.getModel());
        _builder.append(_dataParamType_3, "\t");
        _builder.append(" data) {");
        _builder.newLineIfNotEmpty();
        {
          List<Attribute> _allNonDeterministicAttributes = this._modelExtension.allNonDeterministicAttributes(it.getModel());
          for(final Attribute attribute_1 : _allNonDeterministicAttributes) {
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("// ");
            String _name_1 = attribute_1.getName();
            _builder.append(_name_1, "\t\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return data;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
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
  
  public CharSequence generateAction() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package de.acegen;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public abstract class Action<T extends IDataContainer> implements IAction<T> {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected String actionName;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Action(String actionName) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.actionName = actionName;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
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
    _builder.append("protected void throwSecurityException() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("throw new SecurityException();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void throwIllegalArgumentException(String error) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("throw new IllegalArgumentException(error);");
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
  
  public CharSequence generateReadAction() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package de.acegen;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.time.LocalDateTime;");
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public abstract class ReadAction<T extends IDataContainer> extends Action<T> {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final Logger LOG = LoggerFactory.getLogger(ReadAction.class);");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private PersistenceConnection persistenceConnection;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected CustomAppConfiguration appConfiguration;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected IDaoProvider daoProvider;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ReadAction(String actionName, PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("IDaoProvider daoProvider, ViewProvider viewProvider) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super(actionName);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.persistenceConnection = persistenceConnection;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.appConfiguration = appConfiguration;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.daoProvider = daoProvider;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract T loadDataForGetRequest(T data, PersistenceHandle readonlyHandle);");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract T initActionDataFromSquishyDataProvider(T data);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public T apply(T data) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("DatabaseHandle databaseHandle = new DatabaseHandle(persistenceConnection.getJdbi(), appConfiguration);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("databaseHandle.beginTransaction();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (!daoProvider.getAceDao().checkUuid(data.getUuid())) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("databaseHandle.rollbackTransaction();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("LOG.warn(\"duplicate request {} {} \", actionName, data.getUuid());");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("databaseHandle.rollbackTransaction();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return data;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("data.setSystemTime(LocalDateTime.now());");
    _builder.newLine();
    _builder.append("\t\t\t");
    CharSequence _addActionToTimeline = this.addActionToTimeline();
    _builder.append(_addActionToTimeline, "\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("data = this.initActionData(data);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (Config.DEV.equals(appConfiguration.getConfig().getMode())) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("data = initActionDataFromSquishyDataProvider(data);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("data = this.loadDataForGetRequest(data, databaseHandle.getReadonlyHandle());");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("databaseHandle.commitTransaction();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return data;");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _catchFinallyBlock = this.catchFinallyBlock();
    _builder.append(_catchFinallyBlock, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
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
  
  public CharSequence generateWriteAction() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package de.acegen;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.time.LocalDateTime;");
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public abstract class WriteAction<T extends IDataContainer> extends Action<T> {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final Logger LOG = LoggerFactory.getLogger(WriteAction.class);");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private PersistenceConnection persistenceConnection;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected CustomAppConfiguration appConfiguration;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected IDaoProvider daoProvider;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected ViewProvider viewProvider;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public WriteAction(String actionName, PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("IDaoProvider daoProvider, ViewProvider viewProvider) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super(actionName);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.persistenceConnection = persistenceConnection;");
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
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract T initActionDataFromSquishyDataProvider(T data);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract ICommand<T> getCommand();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public T apply(T data) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("DatabaseHandle databaseHandle = new DatabaseHandle(persistenceConnection.getJdbi(), appConfiguration);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("databaseHandle.beginTransaction();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (!daoProvider.getAceDao().checkUuid(data.getUuid())) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("LOG.warn(\"duplicate request {} {} \", actionName, data.getUuid());");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("databaseHandle.rollbackTransaction();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return data;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("data.setSystemTime(LocalDateTime.now());");
    _builder.newLine();
    _builder.append("\t\t\t");
    CharSequence _addActionToTimeline = this.addActionToTimeline();
    _builder.append(_addActionToTimeline, "\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("data = this.initActionData(data);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (Config.DEV.equals(appConfiguration.getConfig().getMode())) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("data = initActionDataFromSquishyDataProvider(data);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("ICommand<T> command = this.getCommand();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("data = command.execute(data, databaseHandle.getReadonlyHandle(), databaseHandle.getTimelineHandle());");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("command.publishEvents(data, databaseHandle.getHandle(), databaseHandle.getTimelineHandle());");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("databaseHandle.commitTransaction();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("command.publishAfterCommitEvents(data, databaseHandle.getHandle(), databaseHandle.getTimelineHandle());");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return data;");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _catchFinallyBlock = this.catchFinallyBlock();
    _builder.append(_catchFinallyBlock, "\t\t");
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
  
  public CharSequence generateHttpMethod() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package de.acegen;");
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
    _builder.append("package de.acegen;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public interface IAction<T> {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String getActionName();");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("T apply(T data);");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("T initActionData(T data);");
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
  
  private CharSequence constructor(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public ");
    String _abstractActionName = this._aceExtension.abstractActionName(it);
    _builder.append(_abstractActionName);
    _builder.append("(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("IDaoProvider daoProvider, ViewProvider viewProvider) {");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence initActionDataFromSquishyDataProvider(final HttpServerAce it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("protected ");
    String _dataParamType = this._modelExtension.dataParamType(it.getModel());
    _builder.append(_dataParamType);
    _builder.append(" initActionDataFromSquishyDataProvider(");
    String _dataParamType_1 = this._modelExtension.dataParamType(it.getModel());
    _builder.append(_dataParamType_1);
    _builder.append(" data) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("LocalDateTime systemTime = SquishyDataProvider.consumeSystemTime(data.getUuid());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (systemTime != null) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("data.setSystemTime(systemTime);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    {
      List<Attribute> _allAttributes = this._modelExtension.allAttributes(it.getModel());
      for(final Attribute attribute : _allAttributes) {
        {
          boolean _isSquishy = attribute.isSquishy();
          if (_isSquishy) {
            _builder.append("\t");
            _builder.append("String ");
            String _name = attribute.getName();
            _builder.append(_name, "\t");
            _builder.append("Object = SquishyDataProvider.consumeValue(data.getUuid(), \"");
            String _name_1 = attribute.getName();
            _builder.append(_name_1, "\t");
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("if (");
            String _name_2 = attribute.getName();
            _builder.append(_name_2, "\t");
            _builder.append("Object != null) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("try {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            String _javaType = this._attributeExtension.javaType(attribute);
            _builder.append(_javaType, "\t\t\t");
            _builder.append(" ");
            String _name_3 = attribute.getName();
            _builder.append(_name_3, "\t\t\t");
            _builder.append(" = (");
            String _javaType_1 = this._attributeExtension.javaType(attribute);
            _builder.append(_javaType_1, "\t\t\t");
            _builder.append(")");
            String _name_4 = attribute.getName();
            _builder.append(_name_4, "\t\t\t");
            _builder.append("Object;");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("data.");
            String _setterCall = this._attributeExtension.setterCall(attribute, attribute.getName());
            _builder.append(_setterCall, "\t\t\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("} catch (Exception x) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("LOG.warn(\"");
            String _name_5 = attribute.getName();
            _builder.append(_name_5, "\t\t\t");
            _builder.append(" is declared as non-deterministnic and failed to parse {} from SquishyDataProvider.\", ");
            String _name_6 = attribute.getName();
            _builder.append(_name_6, "\t\t\t");
            _builder.append("Object);");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("} else {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("LOG.warn(\"");
            String _name_7 = attribute.getName();
            _builder.append(_name_7, "\t\t");
            _builder.append(" is declared as non-deterministnic but no value was found in SquishyDataProvider.\");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("\t");
    _builder.append("return data;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence addActionToTimeline() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (appConfiguration.getConfig().writeTimeline()) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("daoProvider.getAceDao().addActionToTimeline(this.getActionName(), data, databaseHandle.getTimelineHandle());");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence addExceptionToTimeline() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (appConfiguration.getConfig().writeError()) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("daoProvider.getAceDao().addExceptionToTimeline(data.getUuid(), x, databaseHandle.getTimelineHandle());");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence catchFinallyBlock() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("} catch (IllegalArgumentException x) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("LOG.error(actionName + \" IllegalArgumentException {} \", x.getMessage());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _addExceptionToTimeline = this.addExceptionToTimeline();
    _builder.append(_addExceptionToTimeline, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("databaseHandle.rollbackTransaction();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} catch (Exception ex) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("LOG.error(actionName + \": failed to rollback or to save or report exception \" + ex.getMessage());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("throw x;");
    _builder.newLine();
    _builder.append("} catch (SecurityException x) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("LOG.error(actionName + \" SecurityException\");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _addExceptionToTimeline_1 = this.addExceptionToTimeline();
    _builder.append(_addExceptionToTimeline_1, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("databaseHandle.rollbackTransaction();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} catch (Exception ex) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("LOG.error(actionName + \": failed to rollback or to save or report exception \" + ex.getMessage());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("throw x;");
    _builder.newLine();
    _builder.append("} catch (Exception x) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("LOG.error(actionName + \" Exception {} \", x.getMessage());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _addExceptionToTimeline_2 = this.addExceptionToTimeline();
    _builder.append(_addExceptionToTimeline_2, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("databaseHandle.rollbackTransaction();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} catch (Exception ex) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("LOG.error(actionName + \": failed to rollback or to save or report exception \" + ex.getMessage());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("throw x;");
    _builder.newLine();
    _builder.append("} finally {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("databaseHandle.close();");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateAbstractActionFile(final HttpServerAce it, final HttpServer httpServer) {
    if (it instanceof HttpServerAceRead) {
      return _generateAbstractActionFile((HttpServerAceRead)it, httpServer);
    } else if (it instanceof HttpServerAceWrite) {
      return _generateAbstractActionFile((HttpServerAceWrite)it, httpServer);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, httpServer).toString());
    }
  }
}
