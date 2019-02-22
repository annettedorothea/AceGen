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

import com.google.common.base.Objects;
import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.aceGen.Model;
import de.acegen.extensions.java.ModelExtension;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class AttributeExtension {
  @Inject
  @Extension
  private ModelExtension _modelExtension;
  
  public String resourceParamType(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _equals = it.getType().equals("DateTime");
      if (_equals) {
        _builder.append("String");
      } else {
        String _type = it.getType();
        _builder.append(_type);
      }
    }
    return _builder.toString();
  }
  
  public String resourceParam(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _equals = it.getType().equals("DateTime");
      if (_equals) {
        _builder.append("new DateTime(");
        String _name = it.getName();
        _builder.append(_name);
        _builder.append(").withZone(DateTimeZone.UTC)");
      } else {
        String _name_1 = it.getName();
        _builder.append(_name_1);
      }
    }
    return _builder.toString();
  }
  
  public String getterCall(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("get");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("()");
    return _builder.toString();
  }
  
  public String type(final Attribute it) {
    String _type = it.getType();
    boolean _tripleNotEquals = (_type != null);
    if (_tripleNotEquals) {
      return it.getType();
    }
    return null;
  }
  
  public String javaType(final Attribute it) {
    String _type = it.getType();
    boolean _tripleNotEquals = (_type != null);
    if (_tripleNotEquals) {
      StringConcatenation _builder = new StringConcatenation();
      {
        boolean _isList = it.isList();
        if (_isList) {
          _builder.append("java.util.List<");
        }
      }
      {
        boolean _equals = it.getType().equals("DateTime");
        if (_equals) {
          _builder.append("org.joda.time.DateTime");
        } else {
          String _type_1 = it.getType();
          _builder.append(_type_1);
        }
      }
      {
        boolean _isList_1 = it.isList();
        if (_isList_1) {
          _builder.append(">");
        }
      }
      return _builder.toString();
    }
    Model _model = it.getModel();
    boolean _tripleNotEquals_1 = (_model != null);
    if (_tripleNotEquals_1) {
      StringConcatenation _builder_1 = new StringConcatenation();
      {
        boolean _isList_2 = it.isList();
        if (_isList_2) {
          _builder_1.append("java.util.List<");
        }
      }
      String _interfaceWithPackage = this._modelExtension.interfaceWithPackage(it.getModel());
      _builder_1.append(_interfaceWithPackage);
      {
        boolean _isList_3 = it.isList();
        if (_isList_3) {
          _builder_1.append(">");
        }
      }
      return _builder_1.toString();
    }
    return null;
  }
  
  public String mapperInit(final Attribute it) {
    String _type = it.getType();
    boolean _tripleNotEquals = (_type != null);
    if (_tripleNotEquals) {
      StringConcatenation _builder = new StringConcatenation();
      {
        boolean _isList = it.isList();
        if (_isList) {
          _builder.append("null");
        } else {
          boolean _equals = it.getType().equals("DateTime");
          if (_equals) {
            _builder.append("r.getTimestamp(\"");
            String _name = it.getName();
            _builder.append(_name);
            _builder.append("\") != null ? new org.joda.time.DateTime(r.getTimestamp(\"");
            String _name_1 = it.getName();
            _builder.append(_name_1);
            _builder.append("\")) : null");
          } else {
            boolean _equals_1 = it.getType().equals("Integer");
            if (_equals_1) {
              _builder.append("r.getObject(\"");
              String _name_2 = it.getName();
              _builder.append(_name_2);
              _builder.append("\") != null ? r.getInt(\"");
              String _name_3 = it.getName();
              _builder.append(_name_3);
              _builder.append("\") : null");
            } else {
              boolean _equals_2 = it.getType().equals("Serial");
              if (_equals_2) {
                _builder.append("r.getInt(\"");
                String _name_4 = it.getName();
                _builder.append(_name_4);
                _builder.append("\")");
              } else {
                _builder.append("r.get");
                String _javaType = this.javaType(it);
                _builder.append(_javaType);
                _builder.append("(\"");
                String _name_5 = it.getName();
                _builder.append(_name_5);
                _builder.append("\")");
              }
            }
          }
        }
      }
      return _builder.toString();
    }
    Model _model = it.getModel();
    boolean _tripleNotEquals_1 = (_model != null);
    if (_tripleNotEquals_1) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("null");
      return _builder_1.toString();
    }
    return null;
  }
  
  public String sqlType(final Attribute it) {
    String _xifexpression = null;
    String _type = it.getType();
    boolean _tripleNotEquals = (_type != null);
    if (_tripleNotEquals) {
      String _switchResult = null;
      String _type_1 = it.getType();
      if (_type_1 != null) {
        switch (_type_1) {
          case "Integer":
            _switchResult = "integer";
            break;
          case "Long":
            _switchResult = "bigint";
            break;
          case "String":
            _switchResult = "character varying";
            break;
          case "Float":
            _switchResult = "numeric";
            break;
          case "Boolean":
            _switchResult = "boolean";
            break;
          case "DateTime":
            _switchResult = "timestamp with time zone";
            break;
        }
      }
      _xifexpression = _switchResult;
    }
    return _xifexpression;
  }
  
  public String constraint(final Attribute it) {
    String _type = it.getType();
    boolean _tripleNotEquals = (_type != null);
    if (_tripleNotEquals) {
      return it.getConstraint();
    }
    return null;
  }
  
  public String tableName(final Attribute it) {
    String _xifexpression = null;
    String _type = it.getType();
    boolean _tripleNotEquals = (_type != null);
    if (_tripleNotEquals) {
      StringConcatenation _builder = new StringConcatenation();
      EObject _eContainer = it.eContainer();
      String _table = this._modelExtension.table(((Model) _eContainer));
      _builder.append(_table);
      _xifexpression = _builder.toString();
    }
    return _xifexpression;
  }
  
  public String declaration(final Attribute it) {
    String _type = it.getType();
    boolean _tripleNotEquals = (_type != null);
    if (_tripleNotEquals) {
      StringConcatenation _builder = new StringConcatenation();
      {
        String _constraint = it.getConstraint();
        boolean _tripleNotEquals_1 = (_constraint != null);
        if (_tripleNotEquals_1) {
          _builder.append("@");
          String _constraint_1 = it.getConstraint();
          _builder.append(_constraint_1);
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("private ");
      String _javaType = this.javaType(it);
      _builder.append(_javaType);
      _builder.append(" ");
      String _firstLower = StringExtensions.toFirstLower(it.getName());
      _builder.append(_firstLower);
      {
        boolean _equals = it.getType().equals("Boolean");
        if (_equals) {
          _builder.append(" = false");
        }
      }
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      return _builder.toString();
    }
    Model _model = it.getModel();
    boolean _tripleNotEquals_2 = (_model != null);
    if (_tripleNotEquals_2) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("private ");
      String _javaType_1 = this.javaType(it);
      _builder_1.append(_javaType_1);
      _builder_1.append(" ");
      String _name = it.getName();
      _builder_1.append(_name);
      _builder_1.append(";");
      _builder_1.newLineIfNotEmpty();
      return _builder_1.toString();
    }
    return null;
  }
  
  public String typeWithParam(final Attribute it) {
    String _type = it.getType();
    boolean _tripleNotEquals = (_type != null);
    if (_tripleNotEquals) {
      StringConcatenation _builder = new StringConcatenation();
      String _javaType = this.javaType(it);
      _builder.append(_javaType);
      _builder.append(" ");
      String _firstLower = StringExtensions.toFirstLower(it.getName());
      _builder.append(_firstLower);
      return _builder.toString();
    }
    Model _model = it.getModel();
    boolean _tripleNotEquals_1 = (_model != null);
    if (_tripleNotEquals_1) {
      StringConcatenation _builder_1 = new StringConcatenation();
      String _javaType_1 = this.javaType(it);
      _builder_1.append(_javaType_1);
      _builder_1.append(" ");
      String _name = it.getName();
      _builder_1.append(_name);
      return _builder_1.toString();
    }
    return null;
  }
  
  public String param(final Attribute it, final boolean jsonProperty) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (jsonProperty) {
        _builder.append("@JsonProperty(\"");
        String _name = it.getName();
        _builder.append(_name);
        _builder.append("\") ");
      }
    }
    String _javaType = this.javaType(it);
    _builder.append(_javaType);
    _builder.append(" ");
    String _name_1 = it.getName();
    _builder.append(_name_1);
    return _builder.toString();
  }
  
  public String interfaceGetter(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    String _javaType = this.javaType(it);
    _builder.append(_javaType);
    _builder.append(" get");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("();");
    return _builder.toString();
  }
  
  public String interfaceSetter(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("void set");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("(");
    String _javaType = this.javaType(it);
    _builder.append(_javaType);
    _builder.append(" ");
    String _firstLower = StringExtensions.toFirstLower(it.getName());
    _builder.append(_firstLower);
    _builder.append(");");
    return _builder.toString();
  }
  
  public String assign(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("this.");
    String _name = it.getName();
    _builder.append(_name);
    _builder.append(" = ");
    String _name_1 = it.getName();
    _builder.append(_name_1);
    _builder.append(";");
    return _builder.toString();
  }
  
  public String getter(final Attribute it, final boolean jsonProperty) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (jsonProperty) {
        _builder.append("@JsonProperty");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("public ");
    String _javaType = this.javaType(it);
    _builder.append(_javaType);
    _builder.append(" get");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return this.");
    String _name = it.getName();
    _builder.append(_name, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    return _builder.toString();
  }
  
  public String with(final Attribute it, final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public ");
    String _dataInterfaceName = this._modelExtension.dataInterfaceName(model);
    _builder.append(_dataInterfaceName);
    _builder.append(" with");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("(");
    String _javaType = this.javaType(it);
    _builder.append(_javaType);
    _builder.append(" ");
    String _name = it.getName();
    _builder.append(_name);
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("this.");
    String _name_1 = it.getName();
    _builder.append(_name_1, "\t");
    _builder.append(" = ");
    String _name_2 = it.getName();
    _builder.append(_name_2, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return this;");
    _builder.newLine();
    _builder.append("}");
    return _builder.toString();
  }
  
  public String setter(final Attribute it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public void set");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("(");
    String _javaType = this.javaType(it);
    _builder.append(_javaType);
    _builder.append(" ");
    String _name = it.getName();
    _builder.append(_name);
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("this.");
    String _name_1 = it.getName();
    _builder.append(_name_1, "\t");
    _builder.append(" = ");
    String _name_2 = it.getName();
    _builder.append(_name_2, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    return _builder.toString();
  }
  
  public String setterCall(final Attribute it, final String param) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("set");
    String _firstUpper = StringExtensions.toFirstUpper(it.getName());
    _builder.append(_firstUpper);
    _builder.append("(");
    _builder.append(param);
    _builder.append(")");
    return _builder.toString();
  }
  
  public Attribute foreignKey(final Attribute it) {
    String _type = it.getType();
    boolean _tripleNotEquals = (_type != null);
    if (_tripleNotEquals) {
      return it.getForeignKey();
    }
    return null;
  }
  
  public boolean isPrimaryKey(final Attribute it) {
    String _type = it.getType();
    boolean _tripleNotEquals = (_type != null);
    if (_tripleNotEquals) {
      return it.isPrimaryKey();
    }
    return false;
  }
  
  public boolean isUnique(final Attribute it) {
    String _type = it.getType();
    boolean _tripleNotEquals = (_type != null);
    if (_tripleNotEquals) {
      return it.isUnique();
    }
    return false;
  }
  
  public boolean isPrimitive(final Attribute it) {
    return ((!it.isList()) && (it.getModel() == null));
  }
  
  public List<String> mergeAttributesForGet(final HttpServerAce it) {
    ArrayList<String> attributeList = new ArrayList<String>();
    attributeList.add("String uuid");
    EList<Attribute> _queryParams = it.getQueryParams();
    for (final Attribute queryParam : _queryParams) {
      {
        final String typeWithParam = this.typeWithParam(queryParam);
        boolean _contains = attributeList.contains(typeWithParam);
        boolean _not = (!_contains);
        if (_not) {
          attributeList.add(typeWithParam);
        }
      }
    }
    EList<Attribute> _pathParams = it.getPathParams();
    for (final Attribute pathParam : _pathParams) {
      {
        final String typeWithParam = this.typeWithParam(pathParam);
        boolean _contains = attributeList.contains(typeWithParam);
        boolean _not = (!_contains);
        if (_not) {
          attributeList.add(typeWithParam);
        }
      }
    }
    attributeList.add("int port");
    return attributeList;
  }
  
  public List<String> mergeAttributesForPut(final HttpServerAce it) {
    ArrayList<String> attributeList = new ArrayList<String>();
    attributeList.add("String uuid");
    EList<Attribute> _queryParams = it.getQueryParams();
    for (final Attribute queryParam : _queryParams) {
      {
        final String typeWithParam = this.typeWithParam(queryParam);
        boolean _contains = attributeList.contains(typeWithParam);
        boolean _not = (!_contains);
        if (_not) {
          attributeList.add(typeWithParam);
        }
      }
    }
    EList<Attribute> _pathParams = it.getPathParams();
    for (final Attribute pathParam : _pathParams) {
      {
        final String typeWithParam = this.typeWithParam(pathParam);
        boolean _contains = attributeList.contains(typeWithParam);
        boolean _not = (!_contains);
        if (_not) {
          attributeList.add(typeWithParam);
        }
      }
    }
    EList<Attribute> _payload = it.getPayload();
    for (final Attribute attr : _payload) {
      {
        final String typeWithParam = this.typeWithParam(attr);
        boolean _contains = attributeList.contains(typeWithParam);
        boolean _not = (!_contains);
        if (_not) {
          attributeList.add(typeWithParam);
        }
      }
    }
    attributeList.add("int port");
    return attributeList;
  }
  
  public List<String> mergeAttributesForPost(final HttpServerAce it) {
    ArrayList<String> attributeList = new ArrayList<String>();
    attributeList.add("String uuid");
    EList<Attribute> _queryParams = it.getQueryParams();
    for (final Attribute queryParam : _queryParams) {
      {
        final String typeWithParam = this.typeWithParam(queryParam);
        boolean _contains = attributeList.contains(typeWithParam);
        boolean _not = (!_contains);
        if (_not) {
          attributeList.add(typeWithParam);
        }
      }
    }
    EList<Attribute> _pathParams = it.getPathParams();
    for (final Attribute pathParam : _pathParams) {
      {
        final String typeWithParam = this.typeWithParam(pathParam);
        boolean _contains = attributeList.contains(typeWithParam);
        boolean _not = (!_contains);
        if (_not) {
          attributeList.add(typeWithParam);
        }
      }
    }
    EList<Attribute> _payload = it.getPayload();
    for (final Attribute attr : _payload) {
      {
        final String typeWithParam = this.typeWithParam(attr);
        boolean _contains = attributeList.contains(typeWithParam);
        boolean _not = (!_contains);
        if (_not) {
          attributeList.add(typeWithParam);
        }
      }
    }
    attributeList.add("int port");
    return attributeList;
  }
  
  public List<String> mergeAttributesForDelete(final HttpServerAce it) {
    ArrayList<String> attributeList = new ArrayList<String>();
    attributeList.add("String uuid");
    EList<Attribute> _queryParams = it.getQueryParams();
    for (final Attribute queryParam : _queryParams) {
      {
        final String typeWithParam = this.typeWithParam(queryParam);
        boolean _contains = attributeList.contains(typeWithParam);
        boolean _not = (!_contains);
        if (_not) {
          attributeList.add(typeWithParam);
        }
      }
    }
    EList<Attribute> _pathParams = it.getPathParams();
    for (final Attribute pathParam : _pathParams) {
      {
        final String typeWithParam = this.typeWithParam(pathParam);
        boolean _contains = attributeList.contains(typeWithParam);
        boolean _not = (!_contains);
        if (_not) {
          attributeList.add(typeWithParam);
        }
      }
    }
    attributeList.add("int port");
    return attributeList;
  }
  
  public List<String> mergeAttributes(final HttpServerAce it) {
    ArrayList<String> attributeList = new ArrayList<String>();
    attributeList.add("UUID.randomUUID().toString()");
    if ((Objects.equal(it.getType(), "PUT") || Objects.equal(it.getType(), "POST"))) {
      EList<Attribute> _queryParams = it.getQueryParams();
      for (final Attribute queryParam : _queryParams) {
        {
          final String getter = this.getterCall(queryParam);
          boolean _contains = attributeList.contains(getter);
          boolean _not = (!_contains);
          if (_not) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("((");
            String _dataParamType = this._modelExtension.dataParamType(it.getModel());
            _builder.append(_dataParamType);
            _builder.append(")command.getCommandData()).");
            _builder.append(getter);
            attributeList.add(_builder.toString());
          }
        }
      }
      EList<Attribute> _pathParams = it.getPathParams();
      for (final Attribute pathParam : _pathParams) {
        {
          final String getter = this.getterCall(pathParam);
          boolean _contains = attributeList.contains(getter);
          boolean _not = (!_contains);
          if (_not) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("((");
            String _dataParamType = this._modelExtension.dataParamType(it.getModel());
            _builder.append(_dataParamType);
            _builder.append(")command.getCommandData()).");
            _builder.append(getter);
            attributeList.add(_builder.toString());
          }
        }
      }
      EList<Attribute> _payload = it.getPayload();
      for (final Attribute attr : _payload) {
        {
          final String getter = this.getterCall(attr);
          boolean _contains = attributeList.contains(getter);
          boolean _not = (!_contains);
          if (_not) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("((");
            String _dataParamType = this._modelExtension.dataParamType(it.getModel());
            _builder.append(_dataParamType);
            _builder.append(")command.getCommandData()).");
            _builder.append(getter);
            attributeList.add(_builder.toString());
          }
        }
      }
    } else {
      String _type = it.getType();
      boolean _equals = Objects.equal(_type, "DELETE");
      if (_equals) {
        EList<Attribute> _queryParams_1 = it.getQueryParams();
        for (final Attribute queryParam_1 : _queryParams_1) {
          {
            final String getter = this.getterCall(queryParam_1);
            boolean _contains = attributeList.contains(getter);
            boolean _not = (!_contains);
            if (_not) {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("((");
              String _dataParamType = this._modelExtension.dataParamType(it.getModel());
              _builder.append(_dataParamType);
              _builder.append(")command.getCommandData()).");
              _builder.append(getter);
              attributeList.add(_builder.toString());
            }
          }
        }
        EList<Attribute> _pathParams_1 = it.getPathParams();
        for (final Attribute pathParam_1 : _pathParams_1) {
          {
            final String getter = this.getterCall(pathParam_1);
            boolean _contains = attributeList.contains(getter);
            boolean _not = (!_contains);
            if (_not) {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("((");
              String _dataParamType = this._modelExtension.dataParamType(it.getModel());
              _builder.append(_dataParamType);
              _builder.append(")command.getCommandData()).");
              _builder.append(getter);
              attributeList.add(_builder.toString());
            }
          }
        }
      }
    }
    attributeList.add("appConfiguration.getPort()");
    boolean _isAuthorize = it.isAuthorize();
    if (_isAuthorize) {
      attributeList.add("authorization");
    }
    return attributeList;
  }
}
