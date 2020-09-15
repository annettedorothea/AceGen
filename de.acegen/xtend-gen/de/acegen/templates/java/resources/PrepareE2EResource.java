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
package de.acegen.templates.java.resources;

import de.acegen.extensions.CommonExtension;
import javax.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class PrepareE2EResource {
  @Inject
  @Extension
  private CommonExtension _commonExtension;
  
  public CharSequence generate() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package de.acegen.resources;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import javax.validation.constraints.NotNull;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.Consumes;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.PUT;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.Path;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.Produces;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.QueryParam;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.WebApplicationException;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.core.MediaType;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.core.Response;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.jdbi.v3.core.Jdbi;");
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import de.acegen.Config;");
    _builder.newLine();
    _builder.append("import de.acegen.CustomAppConfiguration;");
    _builder.newLine();
    _builder.append("import de.acegen.DatabaseHandle;");
    _builder.newLine();
    _builder.append("import de.acegen.E2E;");
    _builder.newLine();
    _builder.append("import de.acegen.EventFactory;");
    _builder.newLine();
    _builder.append("import de.acegen.IDaoProvider;");
    _builder.newLine();
    _builder.append("import de.acegen.IEvent;");
    _builder.newLine();
    _builder.append("import de.acegen.ITimelineItem;");
    _builder.newLine();
    _builder.append("import de.acegen.ViewProvider;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Path(\"/e2e\")");
    _builder.newLine();
    _builder.append("@Produces(MediaType.APPLICATION_JSON)");
    _builder.newLine();
    _builder.append("@Consumes(MediaType.APPLICATION_JSON)");
    _builder.newLine();
    _builder.append("public class PrepareE2EResource {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private Jdbi jdbi;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private CustomAppConfiguration configuration;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final Logger LOG = LoggerFactory.getLogger(PrepareE2EResource.class);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private IDaoProvider daoProvider;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private ViewProvider viewProvider;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private E2E e2e;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public PrepareE2EResource(Jdbi jdbi, IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e, CustomAppConfiguration configuration) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.jdbi = jdbi;");
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
    _builder.append("\t\t");
    _builder.append("this.configuration = configuration;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@PUT");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Path(\"/prepare\")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Response put(@NotNull @QueryParam(\"uuid\") String uuid) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (Config.LIVE.equals(configuration.getConfig().getMode())) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("throw new WebApplicationException(\"prepare e2e replay is not available in a live environment\", Response.Status.FORBIDDEN);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("DatabaseHandle databaseHandle = new DatabaseHandle(jdbi, configuration);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("LOG.info(\"PREPARE ACTION \" + uuid);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("databaseHandle.beginTransaction();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("int eventCount = 0;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("ITimelineItem nextAction = e2e.selectNextAction();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("while (nextAction != null && !nextAction.getUuid().equals(uuid)) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("ITimelineItem nextEvent = e2e.selectEvent(nextAction.getUuid());");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (nextEvent != null) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("LOG.info(\"PUBLISH EVENT \" + nextEvent.getUuid() + \" - \" + nextEvent.getName());");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("IEvent event = EventFactory.createEvent(nextEvent.getName(), nextEvent.getData(), daoProvider, viewProvider, configuration);");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("if (event != null) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("event.notifyListeners(databaseHandle.getHandle());");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("daoProvider.getAceDao().addPreparingEventToTimeline(event, nextAction.getUuid(), databaseHandle.getTimelineHandle());");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("eventCount++;");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("LOG.error(\"failed to create \" + nextEvent.getName());");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("nextAction = e2e.selectNextAction();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("databaseHandle.commitTransaction();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return Response.ok(\"prepared action \" + uuid + \" by publishing \" + eventCount + \" events\").build();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} catch (Exception e) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("databaseHandle.rollbackTransaction();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("LOG.error(\"exception during prepare action \" + uuid);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("LOG.error(e.getMessage());");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("throw new WebApplicationException(e);");
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
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
}
