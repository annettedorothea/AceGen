package de.acegen.templates.es6;

import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.ClientGivenRef;
import de.acegen.aceGen.ClientScenario;
import de.acegen.aceGen.ClientWhenBlock;
import de.acegen.aceGen.HttpClient;
import de.acegen.aceGen.InputValue;
import de.acegen.aceGen.SquishyValue;
import de.acegen.aceGen.StateVerification;
import de.acegen.extensions.CommonExtension;
import de.acegen.extensions.es6.Es6Extension;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ScenarioTemplate {
  @Inject
  @Extension
  private CommonExtension _commonExtension;
  
  @Inject
  @Extension
  private Es6Extension _es6Extension;
  
  public CharSequence generateScenarioUtils() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("module.exports = {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("tearDown: async function(driver) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("await driver.quit();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("},");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("invokeAction: async function(driver, action, args) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("throw \"invokeAction not implemented\";");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("},");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("waitInMillis: async function(millis) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return new Promise(function(resolve){");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("setTimeout(resolve,millis);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("});");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("},");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("getAppState: async function(driver) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return await driver.executeScript(\'return appName.getAppState()\');");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("},");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("generateTestId: function() {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("let d = new Date().getTime();");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("return \'xxxxxxxx\'.replace(/[xy]/g, function (c) {");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("let r = (d + Math.random() * 16) % 16 | 0;");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("d = Math.floor(d / 16);");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("return (c === \'x\' ? r : (r & 0x3 | 0x8)).toString(16);");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("},");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("addNonDeterministicValueClient: async function(driver, value) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("const jsonValue = JSON.stringify(value);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("await driver.executeScript(`appName.addNonDeterministicValueClient(\'${jsonValue}\')`);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("},");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("addNonDeterministicValueServer: async function(driver, uuid, key, value) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("await driver.executeScript(`appName.addNonDeterministicValueServer(\"${uuid}\", \"${key}\", \"${value}\")`);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("},");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("defaultTimeout: 30 * 1000,");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("browserName: \"firefox\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateScenario(final ClientScenario it, final HttpClient httpClient) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("const ScenarioUtils = require(\"../../src/ScenarioUtils\");");
    _builder.newLine();
    {
      List<HttpClient> _allReferencedHttpClients = this._es6Extension.allReferencedHttpClients(it);
      for(final HttpClient referencedHttpClient : _allReferencedHttpClients) {
        _builder.append("const ");
        CharSequence _actionIdName = this._es6Extension.actionIdName(referencedHttpClient);
        _builder.append(_actionIdName);
        _builder.append("  = require(\"../../gen/actionIds/");
        String _name = referencedHttpClient.getName();
        _builder.append(_name);
        _builder.append("/");
        CharSequence _actionIdName_1 = this._es6Extension.actionIdName(referencedHttpClient);
        _builder.append(_actionIdName_1);
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      int _size = it.getThenBlock().getVerifications().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        _builder.append("const Verifications = require(\"../../src/");
        String _name_1 = httpClient.getName();
        _builder.append(_name_1);
        _builder.append("/");
        String _name_2 = it.getName();
        _builder.append(_name_2);
        _builder.append("Verifications\");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("const { Builder } = require(\'selenium-webdriver\');");
    _builder.newLine();
    _builder.newLine();
    _builder.append("jasmine.DEFAULT_TIMEOUT_INTERVAL = ScenarioUtils.defaultTimeout;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("const testId = ScenarioUtils.generateTestId();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("let driver;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("let appState;");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("describe(\"");
    String _name_3 = httpClient.getName();
    _builder.append(_name_3);
    _builder.append(".");
    String _name_4 = it.getName();
    _builder.append(_name_4);
    _builder.append("\", function () {");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("beforeAll(async function () {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("driver = new Builder()");
    _builder.newLine();
    _builder.append("    \t\t\t    ");
    _builder.append(".forBrowser(ScenarioUtils.browserName)");
    _builder.newLine();
    _builder.append("    \t\t\t    ");
    _builder.append(".build();");
    _builder.newLine();
    {
      ArrayList<ClientGivenRef> _allGivenItems = this.allGivenItems(it);
      for(final ClientGivenRef givenRef : _allGivenItems) {
        _builder.append("\t\t");
        CharSequence _initNonDeterministicData = this.initNonDeterministicData(givenRef.getScenario().getWhenBlock());
        _builder.append(_initNonDeterministicData, "\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("await ScenarioUtils.invokeAction(driver, ");
        EObject _eContainer = givenRef.getScenario().getWhenBlock().getAction().eContainer();
        CharSequence _actionIdName_2 = this._es6Extension.actionIdName(((HttpClient) _eContainer));
        _builder.append(_actionIdName_2, "\t\t");
        _builder.append(".");
        String _firstLower = StringExtensions.toFirstLower(givenRef.getScenario().getWhenBlock().getAction().getName());
        _builder.append(_firstLower, "\t\t");
        {
          EList<InputValue> _inputValues = givenRef.getScenario().getWhenBlock().getInputValues();
          boolean _hasElements = false;
          for(final InputValue arg : _inputValues) {
            if (!_hasElements) {
              _hasElements = true;
              _builder.append(", [", "\t\t");
            } else {
              _builder.appendImmediate(",", "\t\t");
            }
            Object _primitiveValueFrom = this._es6Extension.primitiveValueFrom(arg.getValue());
            _builder.append(_primitiveValueFrom, "\t\t");
          }
          if (_hasElements) {
            _builder.append("]", "\t\t");
          }
        }
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        {
          int _delayInMillis = givenRef.getScenario().getDelayInMillis();
          boolean _greaterThan_1 = (_delayInMillis > 0);
          if (_greaterThan_1) {
            _builder.append("\t\t");
            _builder.append("await ScenarioUtils.waitInMillis(");
            int _delayInMillis_1 = givenRef.getScenario().getDelayInMillis();
            _builder.append(_delayInMillis_1, "\t\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.newLine();
    {
      ClientWhenBlock _whenBlock = it.getWhenBlock();
      boolean _tripleNotEquals = (_whenBlock != null);
      if (_tripleNotEquals) {
        _builder.append("\t\t");
        CharSequence _initNonDeterministicData_1 = this.initNonDeterministicData(it.getWhenBlock());
        _builder.append(_initNonDeterministicData_1, "\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("await ScenarioUtils.invokeAction(driver, ");
        EObject _eContainer_1 = it.getWhenBlock().getAction().eContainer();
        CharSequence _actionIdName_3 = this._es6Extension.actionIdName(((HttpClient) _eContainer_1));
        _builder.append(_actionIdName_3, "\t\t");
        _builder.append(".");
        String _firstLower_1 = StringExtensions.toFirstLower(it.getWhenBlock().getAction().getName());
        _builder.append(_firstLower_1, "\t\t");
        {
          EList<InputValue> _inputValues_1 = it.getWhenBlock().getInputValues();
          boolean _hasElements_1 = false;
          for(final InputValue arg_1 : _inputValues_1) {
            if (!_hasElements_1) {
              _hasElements_1 = true;
              _builder.append(", [", "\t\t");
            } else {
              _builder.appendImmediate(",", "\t\t");
            }
            Object _primitiveValueFrom_1 = this._es6Extension.primitiveValueFrom(arg_1.getValue());
            _builder.append(_primitiveValueFrom_1, "\t\t");
          }
          if (_hasElements_1) {
            _builder.append("]", "\t\t");
          }
        }
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        {
          int _delayInMillis_2 = it.getDelayInMillis();
          boolean _greaterThan_2 = (_delayInMillis_2 > 0);
          if (_greaterThan_2) {
            _builder.append("\t\t");
            _builder.append("await ScenarioUtils.waitInMillis(");
            int _delayInMillis_3 = it.getDelayInMillis();
            _builder.append(_delayInMillis_3, "\t\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
          }
        }
      } else {
        int _delayInMillis_4 = it.getDelayInMillis();
        boolean _greaterThan_3 = (_delayInMillis_4 > 0);
        if (_greaterThan_3) {
          _builder.append("\t\t");
          _builder.append("await ScenarioUtils.waitInMillis(");
          int _delayInMillis_5 = it.getDelayInMillis();
          _builder.append(_delayInMillis_5, "\t\t");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
        }
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("appState = await ScenarioUtils.getAppState(driver);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("});");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("afterAll(async function () {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("await ScenarioUtils.tearDown(driver);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    {
      EList<StateVerification> _stateVerifications = it.getThenBlock().getStateVerifications();
      for(final StateVerification stateVerification : _stateVerifications) {
        _builder.append("\t");
        _builder.append("it(\"");
        String _name_5 = stateVerification.getName();
        _builder.append(_name_5, "\t");
        _builder.append("\", async () => {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("expect(appState.");
        String _stateRefPath = this._es6Extension.stateRefPath(stateVerification.getStateRef());
        _builder.append(_stateRefPath, "\t\t");
        _builder.append(", \"");
        String _name_6 = stateVerification.getName();
        _builder.append(_name_6, "\t\t");
        _builder.append("\").toEqual(");
        CharSequence _valueFrom = this._es6Extension.valueFrom(stateVerification.getValue());
        _builder.append(_valueFrom, "\t\t");
        _builder.append(")");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("});");
        _builder.newLine();
      }
    }
    _builder.append("    ");
    _builder.newLine();
    {
      EList<String> _verifications = it.getThenBlock().getVerifications();
      for(final String verification : _verifications) {
        _builder.append("\t");
        _builder.append("it(\"");
        _builder.append(verification, "\t");
        _builder.append("\", async () => {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("await Verifications.");
        _builder.append(verification, "\t\t");
        _builder.append("(driver, testId);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("});");
        _builder.newLine();
      }
    }
    _builder.append("    ");
    _builder.newLine();
    _builder.append("});");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence initNonDeterministicData(final ClientWhenBlock it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (((it.getSquishyValues() != null) && (it.getSquishyValues().size() > 0))) {
        {
          EList<SquishyValue> _squishyValues = it.getSquishyValues();
          for(final SquishyValue nonDeterministicValue : _squishyValues) {
            _builder.append("await ScenarioUtils.addNonDeterministicValueClient(");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("driver,");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("{");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("uuid: `");
            String _uuid = nonDeterministicValue.getUuid();
            _builder.append(_uuid, "\t\t");
            _builder.append("`");
            {
              String _clientSystemTime = nonDeterministicValue.getClientSystemTime();
              boolean _tripleNotEquals = (_clientSystemTime != null);
              if (_tripleNotEquals) {
                _builder.append(",");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("clientSystemTime: `");
                String _clientSystemTime_1 = nonDeterministicValue.getClientSystemTime();
                _builder.append(_clientSystemTime_1, "\t\t");
                _builder.append("`");
              }
            }
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append(");");
            _builder.newLine();
            {
              String _serverSystemTime = nonDeterministicValue.getServerSystemTime();
              boolean _tripleNotEquals_1 = (_serverSystemTime != null);
              if (_tripleNotEquals_1) {
                _builder.append("await ScenarioUtils.addNonDeterministicValueServer(driver, `");
                String _uuid_1 = nonDeterministicValue.getUuid();
                _builder.append(_uuid_1);
                _builder.append("`, \"system-time\", new Date(\'");
                String _serverSystemTime_1 = nonDeterministicValue.getServerSystemTime();
                _builder.append(_serverSystemTime_1);
                _builder.append("\').toISOString());");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              Attribute _attribute = nonDeterministicValue.getAttribute();
              boolean _tripleNotEquals_2 = (_attribute != null);
              if (_tripleNotEquals_2) {
                _builder.append("await ScenarioUtils.addNonDeterministicValueServer(driver, `");
                String _uuid_2 = nonDeterministicValue.getUuid();
                _builder.append(_uuid_2);
                _builder.append("`, \"");
                String _firstLower = StringExtensions.toFirstLower(nonDeterministicValue.getAttribute().getName());
                _builder.append(_firstLower);
                _builder.append("\", `");
                Object _primitiveParamFrom = this._es6Extension.primitiveParamFrom(nonDeterministicValue.getValue());
                _builder.append(_primitiveParamFrom);
                _builder.append("`);");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    return _builder;
  }
  
  private ArrayList<ClientGivenRef> allGivenItems(final ClientScenario it) {
    ArrayList<ClientGivenRef> allWhenBlocks = new ArrayList<ClientGivenRef>();
    EList<ClientGivenRef> _givenRefs = it.getGivenRefs();
    for (final ClientGivenRef given : _givenRefs) {
      if ((given instanceof ClientGivenRef)) {
        this.allGivenItemsRec(given, allWhenBlocks);
      }
    }
    return allWhenBlocks;
  }
  
  private void allGivenItemsRec(final ClientGivenRef it, final List<ClientGivenRef> allWhenBlocks) {
    if ((it instanceof ClientGivenRef)) {
      EList<ClientGivenRef> _givenRefs = it.getScenario().getGivenRefs();
      for (final ClientGivenRef given : _givenRefs) {
        this.allGivenItemsRec(given, allWhenBlocks);
      }
    }
    allWhenBlocks.add(it);
  }
  
  public CharSequence generateVerifications(final ClientScenario it) {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("module.exports = {");
    _builder.newLine();
    {
      EList<String> _verifications = it.getThenBlock().getVerifications();
      boolean _hasElements = false;
      for(final String verification : _verifications) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "\t");
        }
        _builder.append("\t");
        _builder.append(verification, "\t");
        _builder.append(": async function(driver, testId) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("fail(\"");
        _builder.append(verification, "\t\t");
        _builder.append(" not implemented\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
}
