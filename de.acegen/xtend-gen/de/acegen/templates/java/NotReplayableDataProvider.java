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
package de.acegen.templates.java;

import de.acegen.extensions.CommonExtension;
import javax.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class NotReplayableDataProvider {
  @Inject
  @Extension
  private CommonExtension _commonExtension;
  
  public CharSequence generateNotReplayableDataProvider() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("package de.acegen;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import java.util.concurrent.ConcurrentHashMap;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import java.util.concurrent.ConcurrentMap;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import java.time.LocalDateTime;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public class NotReplayableDataProvider {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("private static ConcurrentMap<String, LocalDateTime> systemTimeMap = new ConcurrentHashMap<>();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("private static ConcurrentMap<String, ConcurrentMap<String, Object>> valueMap = new ConcurrentHashMap<>();");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public static LocalDateTime consumeSystemTime(String uuid) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("LocalDateTime value = systemTimeMap.get(uuid);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (value != null) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("systemTimeMap.remove(uuid);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return value;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public static void putSystemTime(String uuid, LocalDateTime systemTime) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("systemTimeMap.put(uuid, systemTime);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public static void put(String uuid, String key, Object value) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("ConcurrentMap<String, Object> mapForUuid = valueMap.get(uuid);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (mapForUuid == null) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("mapForUuid = new ConcurrentHashMap<String, Object>();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("valueMap.put(uuid, mapForUuid);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("mapForUuid.put(key, value);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public static Object consumeValue(String uuid, String key) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("ConcurrentMap<String, Object> mapForUuid = valueMap.get(uuid);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (mapForUuid == null) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("Object value = mapForUuid.get(key);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("mapForUuid.remove(key);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (mapForUuid.size() == 0) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("valueMap.remove(uuid);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return value;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}\t\t\t\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
}
