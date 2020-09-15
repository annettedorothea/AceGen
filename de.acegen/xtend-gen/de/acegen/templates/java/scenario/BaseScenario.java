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
package de.acegen.templates.java.scenario;

import de.acegen.extensions.CommonExtension;
import javax.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class BaseScenario {
  @Inject
  @Extension
  private CommonExtension _commonExtension;
  
  public CharSequence generateBaseScenario() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package de.acegen;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import static org.hamcrest.CoreMatchers.is;");
    _builder.newLine();
    _builder.append("import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.io.File;");
    _builder.newLine();
    _builder.append("import java.util.Base64;");
    _builder.newLine();
    _builder.append("import java.util.UUID;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import javax.ws.rs.client.Client;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.client.Entity;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.client.Invocation.Builder;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.core.Response;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.glassfish.jersey.client.JerseyClientBuilder;");
    _builder.newLine();
    _builder.append("import org.jdbi.v3.core.Jdbi;");
    _builder.newLine();
    _builder.append("import java.time.LocalDateTime;");
    _builder.newLine();
    _builder.append("import org.junit.jupiter.api.AfterAll;");
    _builder.newLine();
    _builder.append("import org.junit.jupiter.api.AfterEach;");
    _builder.newLine();
    _builder.append("import org.junit.jupiter.api.BeforeAll;");
    _builder.newLine();
    _builder.append("import org.junit.jupiter.api.BeforeEach;");
    _builder.newLine();
    _builder.append("import org.junit.jupiter.api.Test;");
    _builder.newLine();
    _builder.append("import org.junit.platform.runner.JUnitPlatform;");
    _builder.newLine();
    _builder.append("import org.junit.runner.RunWith;");
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.databind.DeserializationFeature;");
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.databind.ObjectMapper;");
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@RunWith(JUnitPlatform.class)");
    _builder.newLine();
    _builder.append("public abstract class BaseScenario extends AbstractBaseScenario {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final Logger LOG = LoggerFactory.getLogger(BaseScenario.class);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static Jdbi jdbi;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static int port;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static String host = \"localhost\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static String protocol;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static String rootPath;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private String testId;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Client client;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@BeforeAll");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static void beforeClass() throws Exception {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ObjectMapper mapper = new ObjectMapper(new YAMLFactory())");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append(".configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("YamlConfiguration config = mapper.readValue(new File(\"test.yml\"), YamlConfiguration.class);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("port = Integer.parseInt(config.getServer().getApplicationConnectors()[0].getPort());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("protocol = config.getServer().getApplicationConnectors()[0].getType();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("rootPath = config.getServer().getRootPath();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("jdbi = Jdbi.create(config.getDatabase().getUrl());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@AfterAll");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static void afterClass() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@BeforeEach");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void before() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("daoProvider = new DaoProvider();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("handle = new PersistenceHandle(jdbi.open());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("testId = randomString();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("client = new JerseyClientBuilder().build();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("LOG.info(\"testId {}\", testId);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("LOG.info(\"*********************************************************************************\");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("LOG.info(\"********   {} test id {}\", this.scenarioName(), testId);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("LOG.info(\"*********************************************************************************\");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@AfterEach");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void after() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("handle.getHandle().close();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Test");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void test() throws Exception {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.runTest();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private String buidlUrl(String path) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return String.format(\"%s://%s:%d%s%s\", protocol, host, port, rootPath, path);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected Response httpGet(String path, String authorization) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Builder builder = client.target(buidlUrl(path)).request();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (authorization != null) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("builder.header(\"Authorization\", authorization);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return builder.get();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected Response httpPost(String path, Object data, String authorization) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Builder builder = client.target(buidlUrl(path)).request();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (authorization != null) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("builder.header(\"Authorization\", authorization);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return builder.post(Entity.json(data));");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected Response httpPut(String path, Object data, String authorization) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Builder builder = client.target(buidlUrl(path)).request();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (authorization != null) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("builder.header(\"Authorization\", authorization);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return builder.put(Entity.json(data));");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected Response httpDelete(String path, String authorization) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Builder builder = client.target(buidlUrl(path)).request();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (authorization != null) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("builder.header(\"Authorization\", authorization);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return builder.delete();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected String randomString() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return randomUUID().replace(\"-\", \"\").substring(0, 8);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected String randomUUID() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return UUID.randomUUID().toString();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected String authorization(String username, String password) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String string = username.replace(\"${testId}\", testId) + \":\" + password;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String hash = Base64.getEncoder().encodeToString(string.getBytes());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return \"basic \" + hash;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void assertThat(int actual, int expected) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.hamcrest.MatcherAssert.assertThat(actual, is(expected));");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void assertFail(String message) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.junit.jupiter.api.Assertions.fail(message);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void assertThat(Object actual, Object expected) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (actual == null) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("assertIsNull(expected);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.hamcrest.MatcherAssert.assertThat(actual, is(samePropertyValuesAs(expected)));");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void assertIsNull(Object actual) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.junit.jupiter.api.Assertions.assertNull(actual);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void assertIsNotNull(Object actual) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.junit.jupiter.api.Assertions.assertNotNull(actual);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void assertTrue(boolean b) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.junit.jupiter.api.Assertions.assertTrue(b);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void assertFalse(boolean b) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.junit.jupiter.api.Assertions.assertFalse(b);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected boolean prerequisite(String scenarioName) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return true;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected String getTestId() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return testId;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected String replaceTestId(String string) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return string.replace(\"${testId}\", testId);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected Response callNotReplayableDataProviderPutValue(");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("String uuid, String key, Object data) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Client client = new JerseyClientBuilder().build();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Builder builder = client");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append(".target(String.format(\"%s://%s:%d%s/test/not-replayable/value?uuid=\" + uuid + \"&key=\" + key, protocol,");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("host, port, rootPath))");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append(".request();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return builder.put(Entity.json(data));");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected Response callNotReplayableDataProviderPutSystemTime(");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("String uuid, LocalDateTime dateTime) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Client client = new JerseyClientBuilder().build();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Builder builder = client");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append(".target(String.format(");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("\"%s://%s:%d%s/test/not-replayable/system-time?uuid=\" + uuid + \"&system-time=\" + dateTime,");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("protocol, host, port, rootPath))");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append(".request();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return builder.put(Entity.json(dateTime));");
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
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateAbstractBaseScenario() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package de.acegen;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.databind.ObjectMapper;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.core.Response;");
    _builder.newLine();
    _builder.append("import java.time.LocalDateTime;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public abstract class AbstractBaseScenario {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected final ObjectMapper mapper = new ObjectMapper();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected DaoProvider daoProvider;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected PersistenceHandle handle;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected ObjectMapper objectMapper;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public AbstractBaseScenario() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("objectMapper = new ObjectMapper();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract void runTest() throws Exception;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract Response httpGet(String path, String authorization);");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract Response httpPost(String path, Object data, String authorization);");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract Response httpPut(String path, Object data, String authorization);");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract Response httpDelete(String path, String authorization);");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract String randomString();");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract String randomUUID();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract String authorization(String username, String password);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract void assertThat(int actual, int expected);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract void assertThat(Object actual, Object expected);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract void assertIsNull(Object actual);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract void assertIsNotNull(Object actual);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract void assertFail(String message);");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract void assertTrue(boolean b);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract void assertFalse(boolean b);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract String scenarioName();");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract String getTestId();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract boolean prerequisite(String scenarioName);");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract Response callNotReplayableDataProviderPutValue(");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("String uuid, String key, Object data);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract Response callNotReplayableDataProviderPutSystemTime(");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("String uuid, LocalDateTime dateTime);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected abstract void addToMetrics(String action, Long duration);");
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
