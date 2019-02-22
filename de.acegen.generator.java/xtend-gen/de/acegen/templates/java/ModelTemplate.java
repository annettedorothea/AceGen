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
import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.aceGen.Model;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.java.AceExtension;
import de.acegen.extensions.java.AttributeExtension;
import de.acegen.extensions.java.ModelExtension;
import java.util.List;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ModelTemplate {
  @Inject
  @Extension
  private ModelExtension _modelExtension;
  
  @Inject
  @Extension
  private AttributeExtension _attributeExtension;
  
  @Inject
  @Extension
  private AceExtension _aceExtension;
  
  @Inject
  @Extension
  private CommonExtension _commonExtension;
  
  public CharSequence generateModel(final Model it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = java.getName();
    _builder.append(_name);
    _builder.append(".models;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.databind.annotation.JsonDeserialize;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"unused\")");
    _builder.newLine();
    _builder.append("@JsonDeserialize(as=");
    String _modelClassName = this._modelExtension.modelClassName(it);
    _builder.append(_modelClassName);
    _builder.append(".class)");
    _builder.newLineIfNotEmpty();
    _builder.append("public interface ");
    String _modelName = this._modelExtension.modelName(it);
    _builder.append(_modelName);
    _builder.append(" ");
    {
      int _size = it.getSuperModels().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        _builder.append("extends ");
        {
          EList<Model> _superModels = it.getSuperModels();
          boolean _hasElements = false;
          for(final Model superModel : _superModels) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(",", "");
            }
            String _interfaceWithPackage = this._modelExtension.interfaceWithPackage(superModel);
            _builder.append(_interfaceWithPackage);
          }
        }
      }
    }
    _builder.append("{");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      EList<Attribute> _attributes = it.getAttributes();
      for(final Attribute attribute : _attributes) {
        _builder.append("\t");
        String _interfaceGetter = this._attributeExtension.interfaceGetter(attribute);
        _builder.append(_interfaceGetter, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _interfaceSetter = this._attributeExtension.interfaceSetter(attribute);
        _builder.append(_interfaceSetter, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    {
      boolean _containsPrimitiveAttributes = this._modelExtension.containsPrimitiveAttributes(it);
      if (_containsPrimitiveAttributes) {
        _builder.append("\t");
        _builder.append("List<String> equalsPrimitiveTypes(");
        String _interfaceWithPackage_1 = this._modelExtension.interfaceWithPackage(it);
        _builder.append(_interfaceWithPackage_1, "\t");
        _builder.append(" other);");
        _builder.newLineIfNotEmpty();
      }
    }
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
  
  public CharSequence generateModelClass(final Model it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = java.getName();
    _builder.append(_name);
    _builder.append(".models;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.annotation.JsonProperty;");
    _builder.newLine();
    _builder.append("import javax.validation.constraints.NotNull;");
    _builder.newLine();
    _builder.append("import org.hibernate.validator.constraints.NotEmpty;");
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.append("import java.util.ArrayList;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"all\")");
    _builder.newLine();
    _builder.append("public class ");
    String _modelClassName = this._modelExtension.modelClassName(it);
    _builder.append(_modelClassName);
    _builder.append(" implements ");
    String _modelName = this._modelExtension.modelName(it);
    _builder.append(_modelName);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      List<Attribute> _allAttributes = this._modelExtension.allAttributes(it);
      for(final Attribute attribute : _allAttributes) {
        _builder.append("\t");
        String _declaration = this._attributeExtension.declaration(attribute);
        _builder.append(_declaration, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.newLine();
    {
      int _length = ((Object[])Conversions.unwrapArray(it.getAttributes(), Object.class)).length;
      boolean _greaterThan = (_length > 0);
      if (_greaterThan) {
        _builder.append("\t");
        _builder.append("public ");
        String _modelClassName_1 = this._modelExtension.modelClassName(it);
        _builder.append(_modelClassName_1, "\t");
        _builder.append("() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _modelClassName_2 = this._modelExtension.modelClassName(it);
    _builder.append(_modelClassName_2, "\t");
    _builder.append("(");
    _builder.newLineIfNotEmpty();
    {
      List<Attribute> _allAttributes_1 = this._modelExtension.allAttributes(it);
      boolean _hasElements = false;
      for(final Attribute attribute_1 : _allAttributes_1) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "\t\t");
        }
        _builder.append("\t\t");
        String _param = this._attributeExtension.param(attribute_1, true);
        _builder.append(_param, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append(") {");
    _builder.newLine();
    {
      List<Attribute> _allAttributes_2 = this._modelExtension.allAttributes(it);
      for(final Attribute attribute_2 : _allAttributes_2) {
        _builder.append("\t\t");
        String _assign = this._attributeExtension.assign(attribute_2);
        _builder.append(_assign, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      List<Attribute> _allAttributes_3 = this._modelExtension.allAttributes(it);
      for(final Attribute attribute_3 : _allAttributes_3) {
        _builder.append("\t");
        String _ter = this._attributeExtension.getter(attribute_3, true);
        _builder.append(_ter, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _setter = this._attributeExtension.setter(attribute_3);
        _builder.append(_setter, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    {
      List<Model> _allSuperModels = this._modelExtension.allSuperModels(it);
      for(final Model superModel : _allSuperModels) {
        {
          boolean _containsPrimitiveAttributes = this._modelExtension.containsPrimitiveAttributes(superModel);
          if (_containsPrimitiveAttributes) {
            _builder.append("\t");
            _builder.append("public List<String> equalsPrimitiveTypes(");
            String _interfaceWithPackage = this._modelExtension.interfaceWithPackage(superModel);
            _builder.append(_interfaceWithPackage, "\t");
            _builder.append(" other) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("List<String> differingAttributes = new ArrayList<String>();");
            _builder.newLine();
            {
              EList<Attribute> _attributes = superModel.getAttributes();
              for(final Attribute attribute_4 : _attributes) {
                {
                  boolean _isPrimitive = this._attributeExtension.isPrimitive(attribute_4);
                  if (_isPrimitive) {
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("if (!(this.");
                    String _terCall = this._attributeExtension.getterCall(attribute_4);
                    _builder.append(_terCall, "\t\t");
                    _builder.append(" == null && other.");
                    String _terCall_1 = this._attributeExtension.getterCall(attribute_4);
                    _builder.append(_terCall_1, "\t\t");
                    _builder.append(" == null) && !this.");
                    String _terCall_2 = this._attributeExtension.getterCall(attribute_4);
                    _builder.append(_terCall_2, "\t\t");
                    _builder.append(".equals(other.");
                    String _terCall_3 = this._attributeExtension.getterCall(attribute_4);
                    _builder.append(_terCall_3, "\t\t");
                    _builder.append(")) {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("differingAttributes.add(\"");
                    String _name_1 = attribute_4.getName();
                    _builder.append(_name_1, "\t\t\t");
                    _builder.append(": \" + this.");
                    String _terCall_4 = this._attributeExtension.getterCall(attribute_4);
                    _builder.append(_terCall_4, "\t\t\t");
                    _builder.append(" + \" \" + other.");
                    String _terCall_5 = this._attributeExtension.getterCall(attribute_4);
                    _builder.append(_terCall_5, "\t\t\t");
                    _builder.append(");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                  }
                }
              }
            }
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("return differingAttributes;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
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
  
  public CharSequence generateDataInterface(final Model it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = java.getName();
    _builder.append(_name);
    _builder.append(".data;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.databind.annotation.JsonDeserialize;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.IDataContainer;");
    _builder.newLine();
    _builder.newLine();
    String _importModel = this._modelExtension.importModel(it);
    _builder.append(_importModel);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("@JsonDeserialize(as=");
    String _dataName = this._modelExtension.dataName(it);
    _builder.append(_dataName);
    _builder.append(".class)");
    _builder.newLineIfNotEmpty();
    _builder.append("public interface ");
    String _dataInterfaceName = this._modelExtension.dataInterfaceName(it);
    _builder.append(_dataInterfaceName);
    _builder.append(" extends ");
    String _modelName = this._modelExtension.modelName(it);
    _builder.append(_modelName);
    _builder.append(", IDataContainer {");
    _builder.newLineIfNotEmpty();
    {
      EList<Model> _superModels = it.getSuperModels();
      for(final Model superModel : _superModels) {
        _builder.append("\t");
        _builder.append("void mapFrom(");
        String _interfaceWithPackage = this._modelExtension.interfaceWithPackage(superModel);
        _builder.append(_interfaceWithPackage, "\t");
        _builder.append(" model);");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    {
      List<Attribute> _allAttributes = this._modelExtension.allAttributes(it);
      for(final Attribute attribute : _allAttributes) {
        _builder.append("\t");
        String _dataInterfaceName_1 = this._modelExtension.dataInterfaceName(it);
        _builder.append(_dataInterfaceName_1, "\t");
        _builder.append(" with");
        String _firstUpper = StringExtensions.toFirstUpper(attribute.getName());
        _builder.append(_firstUpper, "\t");
        _builder.append("(");
        String _javaType = this._attributeExtension.javaType(attribute);
        _builder.append(_javaType, "\t");
        _builder.append(" ");
        String _name_1 = attribute.getName();
        _builder.append(_name_1, "\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
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
  
  public CharSequence generateAbstractData(final Model it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = java.getName();
    _builder.append(_name);
    _builder.append(".data;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.annotation.JsonProperty;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import javax.validation.constraints.NotNull;");
    _builder.newLine();
    _builder.append("import org.hibernate.validator.constraints.NotEmpty;");
    _builder.newLine();
    _builder.append("import org.joda.time.DateTime;");
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.append("import java.util.ArrayList;");
    _builder.newLine();
    String _importModel = this._modelExtension.importModel(it);
    _builder.append(_importModel);
    _builder.newLineIfNotEmpty();
    {
      EList<Model> _superModels = it.getSuperModels();
      for(final Model superModel : _superModels) {
        String _importModel_1 = this._modelExtension.importModel(superModel);
        _builder.append(_importModel_1);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.AbstractData;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.IDataContainer;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"unused\")");
    _builder.newLine();
    _builder.append("public abstract class ");
    String _abstractDataName = this._modelExtension.abstractDataName(it);
    _builder.append(_abstractDataName);
    _builder.append(" extends AbstractData implements ");
    String _dataInterfaceName = this._modelExtension.dataInterfaceName(it);
    _builder.append(_dataInterfaceName);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final Logger LOG = LoggerFactory.getLogger(");
    String _abstractDataName_1 = this._modelExtension.abstractDataName(it);
    _builder.append(_abstractDataName_1, "\t");
    _builder.append(".class);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    {
      List<Attribute> _allAttributes = this._modelExtension.allAttributes(it);
      for(final Attribute attribute : _allAttributes) {
        _builder.append("\t");
        String _declaration = this._attributeExtension.declaration(attribute);
        _builder.append(_declaration, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _abstractDataName_2 = this._modelExtension.abstractDataName(it);
    _builder.append(_abstractDataName_2, "\t");
    _builder.append("(");
    _builder.newLineIfNotEmpty();
    {
      List<Attribute> _allAttributes_1 = this._modelExtension.allAttributes(it);
      boolean _hasElements = false;
      for(final Attribute attribute_1 : _allAttributes_1) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "\t\t");
        }
        _builder.append("\t\t");
        String _param = this._attributeExtension.param(attribute_1, true);
        _builder.append(_param, "\t\t");
        _builder.newLineIfNotEmpty();
      }
      if (_hasElements) {
        _builder.append(",", "\t\t");
      }
    }
    _builder.append("\t\t");
    _builder.append("@JsonProperty(\"uuid\") String uuid");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(") {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super(uuid);");
    _builder.newLine();
    {
      List<Attribute> _allAttributes_2 = this._modelExtension.allAttributes(it);
      for(final Attribute attribute_2 : _allAttributes_2) {
        _builder.append("\t\t");
        String _assign = this._attributeExtension.assign(attribute_2);
        _builder.append(_assign, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      int _length = ((Object[])Conversions.unwrapArray(this._modelExtension.allAttributes(it), Object.class)).length;
      boolean _greaterThan = (_length > 0);
      if (_greaterThan) {
        _builder.append("\t");
        _builder.append("public ");
        String _abstractDataName_3 = this._modelExtension.abstractDataName(it);
        _builder.append(_abstractDataName_3, "\t");
        _builder.append("( String uuid ) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("super(uuid);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.newLine();
    {
      List<Attribute> _allAttributes_3 = this._modelExtension.allAttributes(it);
      for(final Attribute attribute_3 : _allAttributes_3) {
        _builder.append("\t");
        String _ter = this._attributeExtension.getter(attribute_3, true);
        _builder.append(_ter, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _setter = this._attributeExtension.setter(attribute_3);
        _builder.append(_setter, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _with = this._attributeExtension.with(attribute_3, it);
        _builder.append(_with, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    {
      EList<Model> _superModels_1 = it.getSuperModels();
      for(final Model superModel_1 : _superModels_1) {
        _builder.append("\t");
        _builder.append("public void mapFrom(");
        String _interfaceWithPackage = this._modelExtension.interfaceWithPackage(superModel_1);
        _builder.append(_interfaceWithPackage, "\t");
        _builder.append(" model) {");
        _builder.newLineIfNotEmpty();
        {
          List<Attribute> _allAttributes_4 = this._modelExtension.allAttributes(superModel_1);
          for(final Attribute attribute_4 : _allAttributes_4) {
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("this.");
            String _name_1 = attribute_4.getName();
            _builder.append(_name_1, "\t\t");
            _builder.append(" = model.");
            String _terCall = this._attributeExtension.getterCall(attribute_4);
            _builder.append(_terCall, "\t\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    {
      List<Model> _allSuperModels = this._modelExtension.allSuperModels(it);
      for(final Model superModel_2 : _allSuperModels) {
        {
          boolean _containsPrimitiveAttributes = this._modelExtension.containsPrimitiveAttributes(superModel_2);
          if (_containsPrimitiveAttributes) {
            _builder.append("\t");
            _builder.append("public List<String> equalsPrimitiveTypes(");
            String _interfaceWithPackage_1 = this._modelExtension.interfaceWithPackage(superModel_2);
            _builder.append(_interfaceWithPackage_1, "\t");
            _builder.append(" other) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("List<String> differingAttributes = new ArrayList<String>();");
            _builder.newLine();
            {
              EList<Attribute> _attributes = superModel_2.getAttributes();
              for(final Attribute attribute_5 : _attributes) {
                {
                  boolean _isPrimitive = this._attributeExtension.isPrimitive(attribute_5);
                  if (_isPrimitive) {
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("if (!(this.");
                    String _terCall_1 = this._attributeExtension.getterCall(attribute_5);
                    _builder.append(_terCall_1, "\t\t");
                    _builder.append(" == null && other.");
                    String _terCall_2 = this._attributeExtension.getterCall(attribute_5);
                    _builder.append(_terCall_2, "\t\t");
                    _builder.append(" == null) && !this.");
                    String _terCall_3 = this._attributeExtension.getterCall(attribute_5);
                    _builder.append(_terCall_3, "\t\t");
                    _builder.append(".equals(other.");
                    String _terCall_4 = this._attributeExtension.getterCall(attribute_5);
                    _builder.append(_terCall_4, "\t\t");
                    _builder.append(")) {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("differingAttributes.add(\"");
                    String _name_2 = attribute_5.getName();
                    _builder.append(_name_2, "\t\t\t");
                    _builder.append(": \" + this.");
                    String _terCall_5 = this._attributeExtension.getterCall(attribute_5);
                    _builder.append(_terCall_5, "\t\t\t");
                    _builder.append(" + \" \" + other.");
                    String _terCall_6 = this._attributeExtension.getterCall(attribute_5);
                    _builder.append(_terCall_6, "\t\t\t");
                    _builder.append(");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                  }
                }
              }
            }
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("return differingAttributes;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.newLine();
      }
    }
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
  
  public CharSequence generateData(final Model it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = java.getName();
    _builder.append(_name);
    _builder.append(".data;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.annotation.JsonProperty;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.joda.time.DateTime;");
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.AbstractData;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _dataName = this._modelExtension.dataName(it);
    _builder.append(_dataName);
    _builder.append(" extends ");
    String _abstractDataName = this._modelExtension.abstractDataName(it);
    _builder.append(_abstractDataName);
    _builder.append(" implements ");
    String _dataInterfaceName = this._modelExtension.dataInterfaceName(it);
    _builder.append(_dataInterfaceName);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _dataName_1 = this._modelExtension.dataName(it);
    _builder.append(_dataName_1, "\t");
    _builder.append("(");
    _builder.newLineIfNotEmpty();
    {
      List<Attribute> _allAttributes = this._modelExtension.allAttributes(it);
      for(final Attribute attribute : _allAttributes) {
        _builder.append("\t\t");
        String _param = this._attributeExtension.param(attribute, true);
        _builder.append(_param, "\t\t");
        _builder.append(", ");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("@JsonProperty(\"uuid\") String uuid");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(") {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super(");
    _builder.newLine();
    {
      List<Attribute> _allAttributes_1 = this._modelExtension.allAttributes(it);
      for(final Attribute attribute_1 : _allAttributes_1) {
        _builder.append("\t\t\t");
        String _name_1 = attribute_1.getName();
        _builder.append(_name_1, "\t\t\t");
        _builder.append(",");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t\t");
    _builder.append("uuid");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append(");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      int _length = ((Object[])Conversions.unwrapArray(this._modelExtension.allAttributes(it), Object.class)).length;
      boolean _greaterThan = (_length > 0);
      if (_greaterThan) {
        _builder.append("\t");
        _builder.append("public ");
        String _dataName_2 = this._modelExtension.dataName(it);
        _builder.append(_dataName_2, "\t");
        _builder.append("( String uuid ) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("super(uuid);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("public void migrateLegacyData(String json) {");
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
  
  public CharSequence generateAbstractData() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package com.anfelisa.ace;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.joda.time.DateTime;");
    _builder.newLine();
    _builder.append("import java.util.HashMap;");
    _builder.newLine();
    _builder.append("import java.util.Map;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.annotation.JsonProperty;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public abstract class AbstractData implements IDataContainer {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private String uuid;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private String outcome;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private DateTime systemTime;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private Map<String, String> uuidsForTriggeredAction;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public AbstractData( String uuid ) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.uuid = uuid;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.uuidsForTriggeredAction = new HashMap<String, String>();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonProperty");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String getUuid() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return this.uuid;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonProperty");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void setUuid(String uuid) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.uuid = uuid;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonProperty");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public DateTime getSystemTime() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return systemTime;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonProperty");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void setSystemTime(DateTime systemTime) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.systemTime = systemTime;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonProperty");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String getOutcome() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return outcome;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonProperty");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void setOutcome(String outcome) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.outcome = outcome;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonProperty");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Map<String, String> getUuidsForTriggeredAction() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return uuidsForTriggeredAction;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonProperty");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void setUuidsForTriggeredAction(Map<String, String> uuidsForTriggeredAction) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.uuidsForTriggeredAction = uuidsForTriggeredAction;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void addUuidForTriggeredAction(String actionName, String uuid) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("uuidsForTriggeredAction.put(actionName, uuid);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String getUuidForTriggeredAction(String actionName) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return uuidsForTriggeredAction.get(actionName);");
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
  
  public CharSequence generateResponseData(final HttpServerAce it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = java.getName();
    _builder.append(_name);
    _builder.append(".data;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.annotation.JsonProperty;");
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.annotation.JsonIgnore;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import javax.validation.constraints.NotNull;");
    _builder.newLine();
    _builder.append("import org.hibernate.validator.constraints.NotEmpty;");
    _builder.newLine();
    _builder.append("import org.joda.time.DateTime;");
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.IDataContainer;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"all\")");
    _builder.newLine();
    _builder.append("public class ");
    String _responseDataName = this._aceExtension.responseDataName(it);
    _builder.append(_responseDataName);
    _builder.append(" implements ");
    String _responseDataInterfaceName = this._aceExtension.responseDataInterfaceName(it);
    _builder.append(_responseDataInterfaceName);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    {
      EList<Attribute> _response = it.getResponse();
      for(final Attribute attribute : _response) {
        _builder.append("\t");
        String _declaration = this._attributeExtension.declaration(attribute);
        _builder.append(_declaration, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("public ");
    String _responseDataName_1 = this._aceExtension.responseDataName(it);
    _builder.append(_responseDataName_1, "\t");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _responseDataName_2 = this._aceExtension.responseDataName(it);
    _builder.append(_responseDataName_2, "\t");
    _builder.append("(");
    String _interfaceWithPackage = this._modelExtension.interfaceWithPackage(it.getModel());
    _builder.append(_interfaceWithPackage, "\t");
    _builder.append(" data) {");
    _builder.newLineIfNotEmpty();
    {
      EList<Attribute> _response_1 = it.getResponse();
      for(final Attribute attribute_1 : _response_1) {
        _builder.append("\t\t");
        String _name_1 = attribute_1.getName();
        _builder.append(_name_1, "\t\t");
        _builder.append(" = data.");
        String _terCall = this._attributeExtension.getterCall(attribute_1);
        _builder.append(_terCall, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      EList<Attribute> _response_2 = it.getResponse();
      for(final Attribute attribute_2 : _response_2) {
        _builder.append("\t");
        String _ter = this._attributeExtension.getter(attribute_2, true);
        _builder.append(_ter, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
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
  
  public CharSequence generateReponseDataInterface(final HttpServerAce it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = java.getName();
    _builder.append(_name);
    _builder.append(".data;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public interface ");
    String _responseDataInterfaceName = this._aceExtension.responseDataInterfaceName(it);
    _builder.append(_responseDataInterfaceName);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    {
      EList<Attribute> _response = it.getResponse();
      for(final Attribute attribute : _response) {
        _builder.append("\t");
        String _interfaceGetter = this._attributeExtension.interfaceGetter(attribute);
        _builder.append(_interfaceGetter, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
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
  
  public CharSequence generateAbstractDao(final Model it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = java.getName();
    _builder.append(_name);
    _builder.append(".models;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.jdbi.v3.core.Handle;");
    _builder.newLine();
    _builder.append("import org.jdbi.v3.core.statement.Update;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.append("import java.util.Optional;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"all\")");
    _builder.newLine();
    _builder.append("public class ");
    String _abstractModelDao = this._modelExtension.abstractModelDao(it);
    _builder.append(_abstractModelDao);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void insert(Handle handle, ");
    String _modelName = this._modelExtension.modelName(it);
    _builder.append(_modelName, "\t");
    _builder.append(" ");
    String _modelParam = this._modelExtension.modelParam(it);
    _builder.append(_modelParam, "\t");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("Update statement = handle.createUpdate(\"INSERT INTO ");
    String _table = this._modelExtension.table(it);
    _builder.append(_table, "\t\t");
    _builder.append(" (");
    {
      EList<Attribute> _attributes = it.getAttributes();
      boolean _hasElements = false;
      for(final Attribute attribute : _attributes) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "\t\t");
        }
        String _lowerCase = attribute.getName().toLowerCase();
        _builder.append(_lowerCase, "\t\t");
      }
    }
    _builder.append(") VALUES (");
    {
      EList<Attribute> _attributes_1 = it.getAttributes();
      boolean _hasElements_1 = false;
      for(final Attribute attribute_1 : _attributes_1) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
        } else {
          _builder.appendImmediate(", ", "\t\t");
        }
        String _modelAttributeSqlValue = this._modelExtension.modelAttributeSqlValue(it, attribute_1);
        _builder.append(_modelAttributeSqlValue, "\t\t");
      }
    }
    _builder.append(")\");");
    _builder.newLineIfNotEmpty();
    {
      EList<Attribute> _attributes_2 = it.getAttributes();
      for(final Attribute attribute_2 : _attributes_2) {
        _builder.append("\t\t");
        _builder.append("statement.bind(\"");
        String _lowerCase_1 = attribute_2.getName().toLowerCase();
        _builder.append(_lowerCase_1, "\t\t");
        _builder.append("\", ");
        String _modelGetAttribute = this._modelExtension.modelGetAttribute(it, attribute_2);
        _builder.append(_modelGetAttribute, "\t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("statement.execute();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      List<Attribute> _allUniqueAttributes = this._modelExtension.allUniqueAttributes(it);
      for(final Attribute attribute_3 : _allUniqueAttributes) {
        _builder.append("\t");
        _builder.append("public void updateBy");
        String _firstUpper = StringExtensions.toFirstUpper(attribute_3.getName());
        _builder.append(_firstUpper, "\t");
        _builder.append("(Handle handle, ");
        String _modelName_1 = this._modelExtension.modelName(it);
        _builder.append(_modelName_1, "\t");
        _builder.append(" ");
        String _modelParam_1 = this._modelExtension.modelParam(it);
        _builder.append(_modelParam_1, "\t");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("Update statement = handle.createUpdate(\"UPDATE ");
        String _table_1 = this._modelExtension.table(it);
        _builder.append(_table_1, "\t\t");
        _builder.append(" SET ");
        {
          EList<Attribute> _attributes_3 = it.getAttributes();
          boolean _hasElements_2 = false;
          for(final Attribute attr : _attributes_3) {
            if (!_hasElements_2) {
              _hasElements_2 = true;
            } else {
              _builder.appendImmediate(", ", "\t\t");
            }
            String _lowerCase_2 = attr.getName().toLowerCase();
            _builder.append(_lowerCase_2, "\t\t");
            _builder.append(" = :");
            String _lowerCase_3 = attr.getName().toLowerCase();
            _builder.append(_lowerCase_3, "\t\t");
          }
        }
        _builder.append(" WHERE ");
        String _lowerCase_4 = attribute_3.getName().toLowerCase();
        _builder.append(_lowerCase_4, "\t\t");
        _builder.append(" = :");
        String _lowerCase_5 = attribute_3.getName().toLowerCase();
        _builder.append(_lowerCase_5, "\t\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        {
          EList<Attribute> _attributes_4 = it.getAttributes();
          for(final Attribute attr_1 : _attributes_4) {
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("statement.bind(\"");
            String _lowerCase_6 = attr_1.getName().toLowerCase();
            _builder.append(_lowerCase_6, "\t\t");
            _builder.append("\", ");
            String _modelGetAttribute_1 = this._modelExtension.modelGetAttribute(it, attr_1);
            _builder.append(_modelGetAttribute_1, "\t\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("statement.bind(\"");
        String _lowerCase_7 = attribute_3.getName().toLowerCase();
        _builder.append(_lowerCase_7, "\t\t");
        _builder.append("\", ");
        String _modelGetAttribute_2 = this._modelExtension.modelGetAttribute(it, attribute_3);
        _builder.append(_modelGetAttribute_2, "\t\t");
        _builder.append(" );");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("statement.execute();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void deleteBy");
        String _firstUpper_1 = StringExtensions.toFirstUpper(attribute_3.getName());
        _builder.append(_firstUpper_1, "\t");
        _builder.append("(Handle handle, ");
        String _javaType = this._attributeExtension.javaType(attribute_3);
        _builder.append(_javaType, "\t");
        _builder.append(" ");
        String _name_1 = attribute_3.getName();
        _builder.append(_name_1, "\t");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("Update statement = handle.createUpdate(\"DELETE FROM ");
        String _table_2 = this._modelExtension.table(it);
        _builder.append(_table_2, "\t\t");
        _builder.append(" WHERE ");
        String _lowerCase_8 = attribute_3.getName().toLowerCase();
        _builder.append(_lowerCase_8, "\t\t");
        _builder.append(" = :");
        String _lowerCase_9 = attribute_3.getName().toLowerCase();
        _builder.append(_lowerCase_9, "\t\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("statement.bind(\"");
        String _lowerCase_10 = attribute_3.getName().toLowerCase();
        _builder.append(_lowerCase_10, "\t\t");
        _builder.append("\", ");
        String _name_2 = attribute_3.getName();
        _builder.append(_name_2, "\t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("statement.execute();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        String _modelName_2 = this._modelExtension.modelName(it);
        _builder.append(_modelName_2, "\t");
        _builder.append(" selectBy");
        String _firstUpper_2 = StringExtensions.toFirstUpper(attribute_3.getName());
        _builder.append(_firstUpper_2, "\t");
        _builder.append("(Handle handle, ");
        String _javaType_1 = this._attributeExtension.javaType(attribute_3);
        _builder.append(_javaType_1, "\t");
        _builder.append(" ");
        String _name_3 = attribute_3.getName();
        _builder.append(_name_3, "\t");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("Optional<");
        String _modelName_3 = this._modelExtension.modelName(it);
        _builder.append(_modelName_3, "\t\t");
        _builder.append("> optional = handle.createQuery(\"SELECT ");
        {
          EList<Attribute> _attributes_5 = it.getAttributes();
          boolean _hasElements_3 = false;
          for(final Attribute attr_2 : _attributes_5) {
            if (!_hasElements_3) {
              _hasElements_3 = true;
            } else {
              _builder.appendImmediate(", ", "\t\t");
            }
            String _lowerCase_11 = attr_2.getName().toLowerCase();
            _builder.append(_lowerCase_11, "\t\t");
          }
        }
        _builder.append(" FROM ");
        String _table_3 = this._modelExtension.table(it);
        _builder.append(_table_3, "\t\t");
        _builder.append(" WHERE ");
        String _lowerCase_12 = attribute_3.getName().toLowerCase();
        _builder.append(_lowerCase_12, "\t\t");
        _builder.append(" = :");
        String _lowerCase_13 = attribute_3.getName().toLowerCase();
        _builder.append(_lowerCase_13, "\t\t");
        _builder.append("\")");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append(".bind(\"");
        String _lowerCase_14 = attribute_3.getName().toLowerCase();
        _builder.append(_lowerCase_14, "\t\t\t");
        _builder.append("\", ");
        String _name_4 = attribute_3.getName();
        _builder.append(_name_4, "\t\t\t");
        _builder.append(")");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append(".map(new ");
        String _modelMapper = this._modelExtension.modelMapper(it);
        _builder.append(_modelMapper, "\t\t\t");
        _builder.append("())");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append(".findFirst();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return optional.isPresent() ? optional.get() : null;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public List<");
    String _modelName_4 = this._modelExtension.modelName(it);
    _builder.append(_modelName_4, "\t");
    _builder.append("> selectAll(Handle handle) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("return handle.createQuery(\"SELECT ");
    {
      EList<Attribute> _attributes_6 = it.getAttributes();
      boolean _hasElements_4 = false;
      for(final Attribute attr_3 : _attributes_6) {
        if (!_hasElements_4) {
          _hasElements_4 = true;
        } else {
          _builder.appendImmediate(", ", "\t\t");
        }
        String _lowerCase_15 = attr_3.getName().toLowerCase();
        _builder.append(_lowerCase_15, "\t\t");
      }
    }
    _builder.append(" FROM ");
    String _table_4 = this._modelExtension.table(it);
    _builder.append(_table_4, "\t\t");
    _builder.append("\")");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append(".map(new ");
    String _modelMapper_1 = this._modelExtension.modelMapper(it);
    _builder.append(_modelMapper_1, "\t\t\t");
    _builder.append("())");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append(".list();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void truncate(Handle handle) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Update statement = handle.createUpdate(\"TRUNCATE TABLE ");
    String _table_5 = this._modelExtension.table(it);
    _builder.append(_table_5, "\t\t");
    _builder.append(" CASCADE\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("statement.execute();");
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
  
  public CharSequence generateDao(final Model it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = java.getName();
    _builder.append(_name);
    _builder.append(".models;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _modelDao = this._modelExtension.modelDao(it);
    _builder.append(_modelDao);
    _builder.append(" extends ");
    String _abstractModelDao = this._modelExtension.abstractModelDao(it);
    _builder.append(_abstractModelDao);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
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
  
  public CharSequence generateMigration(final Model it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<createTable tableName=\"");
    String _lowerCase = it.getName().toLowerCase();
    _builder.append(_lowerCase);
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    {
      EList<Attribute> _attributes = it.getAttributes();
      for(final Attribute attribute : _attributes) {
        _builder.append("\t");
        _builder.append("<column name=\"");
        String _lowerCase_1 = attribute.getName().toLowerCase();
        _builder.append(_lowerCase_1, "\t");
        _builder.append("\" type=\"");
        String _sqlType = this._attributeExtension.sqlType(attribute);
        _builder.append(_sqlType, "\t");
        _builder.append("\">");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("<constraints ");
        {
          boolean _isPrimaryKey = attribute.isPrimaryKey();
          if (_isPrimaryKey) {
            _builder.append("primaryKey=\"true\"");
          }
        }
        _builder.append(" ");
        {
          if (((attribute.getConstraint() != null) && attribute.getConstraint().equals("NotNull"))) {
            _builder.append("nullable=\"false\"");
          }
        }
        _builder.append(" ");
        {
          Attribute _foreignKey = attribute.getForeignKey();
          boolean _tripleNotEquals = (_foreignKey != null);
          if (_tripleNotEquals) {
            _builder.append("\treferences=\"");
            String _tableName = this._attributeExtension.tableName(attribute.getForeignKey());
            _builder.append(_tableName, "\t\t");
            _builder.append("(");
            String _lowerCase_2 = attribute.getForeignKey().getName().toLowerCase();
            _builder.append(_lowerCase_2, "\t\t");
            _builder.append(")\" deleteCascade=\"true\" foreignKeyName=\"fk_");
            String _table = this._modelExtension.table(it);
            _builder.append(_table, "\t\t");
            _builder.append("_");
            String _lowerCase_3 = attribute.getForeignKey().getName().toLowerCase();
            _builder.append(_lowerCase_3, "\t\t");
            _builder.append("\"");
          }
        }
        _builder.append(" />");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("</column>");
        _builder.newLine();
      }
    }
    _builder.append("</createTable>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateMapper(final Model it, final HttpServer java) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package ");
    String _name = java.getName();
    _builder.append(_name);
    _builder.append(".models;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.sql.ResultSet;");
    _builder.newLine();
    _builder.append("import java.sql.SQLException;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.jdbi.v3.core.mapper.RowMapper;");
    _builder.newLine();
    _builder.append("import org.jdbi.v3.core.statement.StatementContext;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _modelMapper = this._modelExtension.modelMapper(it);
    _builder.append(_modelMapper);
    _builder.append(" implements RowMapper<");
    String _modelName = this._modelExtension.modelName(it);
    _builder.append(_modelName);
    _builder.append("> {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _modelName_1 = this._modelExtension.modelName(it);
    _builder.append(_modelName_1, "\t");
    _builder.append(" map(ResultSet r, StatementContext ctx) throws SQLException {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("return new ");
    String _modelClassName = this._modelExtension.modelClassName(it);
    _builder.append(_modelClassName, "\t\t");
    _builder.append("(");
    _builder.newLineIfNotEmpty();
    {
      List<Attribute> _allAttributes = this._modelExtension.allAttributes(it);
      boolean _hasElements = false;
      for(final Attribute attribute : _allAttributes) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "\t\t\t");
        }
        _builder.append("\t\t\t");
        String _mapperInit = this._attributeExtension.mapperInit(attribute);
        _builder.append(_mapperInit, "\t\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append(");");
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
  
  public CharSequence generateDatabaseHandle() {
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
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.append("import org.jdbi.v3.core.Jdbi;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class DatabaseHandle {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final Logger LOG = LoggerFactory.getLogger(DatabaseHandle.class);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private Handle handle;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private Handle readonlyHandle;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private Handle timelineHandle;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public DatabaseHandle(Jdbi jdbi) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.handle = jdbi.open();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.readonlyHandle = jdbi.open();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.timelineHandle = jdbi.open();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("synchronized public void beginTransaction() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("handle.begin();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("readonlyHandle.begin();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("timelineHandle.begin();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("synchronized public void commitTransaction() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("handle.commit();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("readonlyHandle.rollback();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("timelineHandle.commit();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("synchronized public void rollbackTransaction() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("handle.rollback();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("readonlyHandle.rollback();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("timelineHandle.commit();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("synchronized public void close() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("handle.close();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("readonlyHandle.close();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("timelineHandle.close();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Handle getHandle() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return handle;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Handle getReadonlyHandle() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return readonlyHandle;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Handle getTimelineHandle() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return timelineHandle;");
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
  
  public CharSequence generateIDataContainer() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package com.anfelisa.ace;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.joda.time.DateTime;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public interface IDataContainer {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String getUuid();");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("void setUuid(String uuid);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String getOutcome();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("void setOutcome(String outcome);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("DateTime getSystemTime();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("void setSystemTime(DateTime systemTime);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("void migrateLegacyData(String json);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("void addUuidForTriggeredAction(String actionName, String uuid);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String getUuidForTriggeredAction(String actionName);");
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
}
