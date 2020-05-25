/* 
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.

 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */
 

package de.acegen.templates.java

import de.acegen.aceGen.AuthUser
import de.acegen.aceGen.HttpServer
import de.acegen.aceGen.HttpServerAce
import de.acegen.aceGen.HttpServerAceRead
import de.acegen.aceGen.HttpServerAceWrite
import de.acegen.aceGen.HttpServerOutcome
import de.acegen.aceGen.HttpServerViewFunction
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.java.AceExtension
import de.acegen.extensions.java.AttributeExtension
import de.acegen.extensions.java.ModelExtension
import de.acegen.extensions.java.ViewExtension
import javax.inject.Inject

class ActionTemplate {

	@Inject
	extension ModelExtension

	@Inject
	extension AceExtension

	@Inject
	extension ViewExtension

	@Inject
	extension AttributeExtension

	@Inject
	extension CommonExtension
	
	def dispatch generateAbstractActionFile(HttpServerAceWrite it, HttpServer java, AuthUser authUser) '''
		«copyright»
		
		package «java.getName».actions;
		
		import javax.ws.rs.Consumes;
		import javax.ws.rs.Path;
		import javax.ws.rs.Produces;
		import javax.ws.rs.core.MediaType;
		import javax.ws.rs.core.Response;
		import javax.ws.rs.PathParam;
		import javax.ws.rs.QueryParam;
		
		import org.joda.time.DateTime;
		import org.joda.time.DateTimeZone;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import org.apache.commons.lang3.StringUtils;
		
		import com.fasterxml.jackson.databind.ObjectMapper;
		
		import de.acegen.CustomAppConfiguration;
		import de.acegen.E2E;
		import de.acegen.HttpMethod;
		import de.acegen.ICommand;
		import de.acegen.IDaoProvider;
		import de.acegen.IDataContainer;
		import de.acegen.ITimelineItem;
		import de.acegen.ViewProvider;
		import de.acegen.NotReplayableDataProvider;
		import de.acegen.PersistenceConnection;
		import de.acegen.«IF proxy»Proxy«ENDIF»WriteAction;

		«IF authorize»
			import de.acegen.auth.AuthUser;
			import io.dropwizard.auth.Auth;
		«ENDIF»

		import com.codahale.metrics.annotation.Timed;
		import com.codahale.metrics.annotation.Metered;
		import com.codahale.metrics.annotation.ExceptionMetered;
		import com.codahale.metrics.annotation.ResponseMetered;

		import com.fasterxml.jackson.core.JsonProcessingException;

		import javax.ws.rs.POST;
		import javax.ws.rs.PUT;
		import javax.ws.rs.DELETE;
		
		«getModel.dataImport»
		«getModel.dataClassImport»
		«IF outcomes.size > 0»
			import «commandNameWithPackage(java)»;
		«ENDIF»
		
		@Path("«getUrl»")
		@SuppressWarnings("unused")
		public abstract class «abstractActionName» extends «IF isProxy»Proxy«ENDIF»WriteAction<«getModel.dataParamType»> {

			static final Logger LOG = LoggerFactory.getLogger(«abstractActionName».class);
			
			private ObjectMapper objectMapper;

			«constructor»
				super("«actionNameWithPackage(java)»", persistenceConnection, appConfiguration, daoProvider,
								viewProvider, e2e, HttpMethod.«getType»);
				objectMapper = new ObjectMapper();
			}
		
			@Override
			public ICommand getCommand() {
				«IF outcomes.size > 0»
					return new «commandName»(this.actionData, daoProvider, viewProvider, this.appConfiguration);
				«ELSE»
					return null;
				«ENDIF»
			}
			
			«initActionDataFrom»

			«IF proxy»
				@Override
				protected IScheduledCardsData createDataFrom(ITimelineItem timelineItem) {
					IDataContainer originalData = AceDataFactory.createAceData(timelineItem.getName(), timelineItem.getData());
					return («getModel.dataParamType»)originalData;
				}
			«ENDIF»

			«initActionDataFromNotReplayableDataProvider»		

			«method(authUser)»
		
			«IF response.size > 0»
				protected Object createReponse() {
					return new «responseDataNameWithPackage(java)»(this.actionData);
				}
			«ENDIF»

		}
		
		
		«sdg»
		
	'''

	def dispatch generateAbstractActionFile(HttpServerAceRead it, HttpServer java, AuthUser authUser) '''
		«copyright»
		
		package «java.getName».actions;
		
		import javax.ws.rs.Consumes;
		import javax.ws.rs.Path;
		import javax.ws.rs.Produces;
		import javax.ws.rs.core.MediaType;
		import javax.ws.rs.core.Response;
		import javax.ws.rs.PathParam;
		import javax.ws.rs.QueryParam;
		
		import org.joda.time.DateTime;
		import org.joda.time.DateTimeZone;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import org.apache.commons.lang3.StringUtils;
		
		import de.acegen.CustomAppConfiguration;
		import de.acegen.E2E;
		import de.acegen.IDaoProvider;
		import de.acegen.IDataContainer;
		import de.acegen.ViewProvider;
		import de.acegen.PersistenceConnection;
		import de.acegen.PersistenceHandle;
		import de.acegen.ReadAction;
		import de.acegen.ITimelineItem;
		import de.acegen.NotReplayableDataProvider;
		
		«IF authorize»
			import de.acegen.auth.AuthUser;
			import io.dropwizard.auth.Auth;
		«ENDIF»

		import com.codahale.metrics.annotation.Timed;
		import com.codahale.metrics.annotation.Metered;
		import com.codahale.metrics.annotation.ExceptionMetered;
		import com.codahale.metrics.annotation.ResponseMetered;

		import com.fasterxml.jackson.core.JsonProcessingException;
		
		import javax.ws.rs.GET;
		
		«getModel.dataImport»
		«getModel.dataClassImport»
		
		@Path("«getUrl»")
		@SuppressWarnings("unused")
		public abstract class «abstractActionName» extends ReadAction<«getModel.dataParamType»> {
		
			static final Logger LOG = LoggerFactory.getLogger(«abstractActionName».class);
			
			private ObjectMapper objectMapper;
			
			«constructor»
				super("«actionNameWithPackage(java)»", persistenceConnection, appConfiguration, daoProvider,
								viewProvider, e2e);
				objectMapper = new ObjectMapper();
			}
		
			protected abstract void loadDataForGetRequest(PersistenceHandle readonlyHandle);
		
			«initActionDataFrom»
			
			«initActionDataFromNotReplayableDataProvider»

			«method(authUser)»

			«IF response.size > 0»
				protected Object createReponse() {
					return new «responseDataNameWithPackage(java)»(this.actionData);
				}
			«ENDIF»
			
		}
		
		
		«sdg»
		
	'''
	
	private def initActionDataFrom(HttpServerAce it) '''
		@Override
		protected void initActionDataFrom(ITimelineItem timelineItem) {
			IDataContainer originalData = AceDataFactory.createAceData(timelineItem.getName(), timelineItem.getData());
			«getModel.dataParamType» originalActionData = («getModel.dataParamType»)originalData;
			this.actionData.setSystemTime(originalActionData.getSystemTime());
			«FOR attribute : getModel.allAttributes»
				«IF attribute.notReplayable»
					this.actionData.«attribute.setterCall('''(originalActionData.«attribute.getterCall»)''')»;
				«ENDIF»
			«ENDFOR»
		}
	'''
	
	private def initActionDataFromNotReplayableDataProvider(HttpServerAce it) '''
		@Override
		protected void initActionDataFromNotReplayableDataProvider() {
			DateTime systemTime = NotReplayableDataProvider.consumeSystemTime(this.actionData.getUuid());
			if (systemTime != null) {
				this.actionData.setSystemTime(systemTime);
			} else {
				this.actionData.setSystemTime(DateTime.now().withZone(DateTimeZone.UTC));
			}
			«FOR attribute : getModel.allAttributes»
				«IF attribute.notReplayable»
					Object value = NotReplayableDataProvider.consumeValue(this.actionData.getUuid(), "«attribute.name»");
					if (value != null) {
						try {
							«attribute.type» «attribute.name» = («attribute.type»)value;
							this.actionData.«attribute.setterCall(attribute.name)»;
						} catch (Exception x) {
							LOG.warn("«attribute.name» is declared as not replayable and failed to parse {} from NotReplayableDataProvider.", value);
						}
					} else {
						LOG.warn("«attribute.name» is declared as not replayable but no value was found in NotReplayableDataProvider.");
					}
				«ENDIF»
			«ENDFOR»
		}
	'''
	
	private def addActionToTimeline() '''
		if (appConfiguration.getConfig().writeTimeline()) {
			daoProvider.getAceDao().addActionToTimeline(this, databaseHandle.getTimelineHandle());
		}
	'''
	
	private def addExceptionToTimeline() '''
		if (appConfiguration.getConfig().writeError()) {
			daoProvider.getAceDao().addExceptionToTimeline(this.actionData.getUuid(), x, databaseHandle.getTimelineHandle());
		}
	'''
	
	private def constructor(HttpServerAce it) '''
		public «abstractActionName»(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
				IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
	'''
	
	private def method(HttpServerAce it, AuthUser authUser) '''
		«IF getType !== null»@«getType»«ENDIF»
		@Timed(name = "«actionName»Timed")
		@Metered(name = "«actionName»Metered")
		@ExceptionMetered
		@ResponseMetered
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public Response «resourceName.toFirstLower»(
				«IF isAuthorize && authUser !== null»@Auth «authUser.name.toFirstUpper» «authUser.name.toFirstLower», «ENDIF»
				«FOR param : queryParams»
					@QueryParam("«param.attribute.name»") «param.attribute.resourceParamType» «param.attribute.name», 
				«ENDFOR»
				«FOR param : pathParams»
					@PathParam("«param.attribute.name»") «param.attribute.resourceParamType» «param.attribute.name», 
				«ENDFOR»
				«IF payload.size > 0»«getModel.dataParamType» payload)
				«ELSE»@QueryParam("uuid") String uuid)«ENDIF» 
				throws JsonProcessingException {
			«IF payload.size > 0»
				if (payload == null) {
					throwBadRequest("payload must not be null");
				}
			«ELSE»
				if (StringUtils.isBlank(uuid)) {
					throwBadRequest("uuid must not be blank or null");
				}
			«ENDIF»
			this.actionData = new «getModel.dataName»(«IF payload.size > 0»payload.getUuid()«ELSE»uuid«ENDIF»);
			«FOR paramRef : queryParams»
				«paramRef.initActionData»
			«ENDFOR»
			«FOR paramRef : pathParams»
				«paramRef.initActionData»
			«ENDFOR»
			«FOR attributeRef : payload»
				«attributeRef.initActionDataFromPayload»
			«ENDFOR»
			«IF isAuthorize && authUser !== null»
				«FOR param : getModel.allAttributes»
						«IF authUser.attributes.containsAttribute(param)»
							this.actionData.«param.setterCall('''«authUser.name.toFirstLower».«getterCall(param)»''')»;
						«ENDIF»
				«ENDFOR»
			«ENDIF»
			
			return this.apply();
		}
	'''

	def generateInitialActionFile(HttpServerAce it, HttpServer java) '''
		«copyright»
		
		package «java.getName».actions;
		
		import de.acegen.CustomAppConfiguration;
		import de.acegen.ViewProvider;
		import de.acegen.IDaoProvider;
		import de.acegen.E2E;
		import de.acegen.PersistenceConnection;
		«IF getType.equals("GET")»
			import de.acegen.PersistenceHandle;
		«ENDIF»
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;

		public class «actionName» extends «abstractActionName» {
		
			static final Logger LOG = LoggerFactory.getLogger(«actionName».class);
		
			public «actionName»(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, 
					ViewProvider viewProvider, E2E e2e) {
				super(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e);
			}
		
		
			«IF getType.equals("GET")»
				@Override
				protected void loadDataForGetRequest(PersistenceHandle readonlyHandle) {
				}
			«ENDIF»
			
			public void initActionData() {
				// init not replayable data here
				«FOR attribute: model.allNotReplayableAttributes»
					// «attribute.name»
				«ENDFOR»
			}
		
		}
		
		
		«sdg»
		
	'''

	def generateAction() '''
		«copyright»
		
		package de.acegen;
		
		import javax.ws.rs.WebApplicationException;
		import javax.ws.rs.core.Response;
		
		public abstract class Action<T extends IDataContainer> implements IAction {
		
			protected T actionData;
			protected String actionName;
			private HttpMethod httpMethod;
		
			public Action(String actionName, HttpMethod httpMethod) {
				super();
				this.actionName = actionName;
				this.httpMethod = httpMethod;
			}
		
			public String getActionName() {
				return this.actionName;
			}
		
			public HttpMethod getHttpMethod() {
				return this.httpMethod;
			}
		
			public IDataContainer getActionData() {
				return this.actionData;
			}
		
			protected void throwUnauthorized() {
				throw new WebApplicationException(Response.Status.UNAUTHORIZED);
			}
		
			protected void throwBadRequest() {
				throw new WebApplicationException(Response.Status.BAD_REQUEST);
			}
		
			protected void throwBadRequest(String error) {
				throw new WebApplicationException(error, Response.Status.BAD_REQUEST);
			}
		
			protected void throwForbidden(String error) {
				throw new WebApplicationException(error, Response.Status.FORBIDDEN);
			}
			
			protected void throwServiceUnavailable(String error) {
				throw new WebApplicationException(error, Response.Status.SERVICE_UNAVAILABLE);
			}
		
			protected void throwInternalServerError(Exception x) {
				String message = x.getMessage();
				StackTraceElement[] stackTrace = x.getStackTrace();
				int i = 1;
				for (StackTraceElement stackTraceElement : stackTrace) {
					message += "\n" + stackTraceElement.toString();
					if (i > 3) {
						message += "\n" + (stackTrace.length - 4) + " more...";
						break;
					}
					i++;
				}
				throw new WebApplicationException(message, Response.Status.INTERNAL_SERVER_ERROR);
			}
		
			protected Object createReponse() {
				return this.actionData.getUuid();
			}

		}
		
		«sdg»
		
	'''
	
	def generateReadAction() '''
		«copyright»
		
		package de.acegen;
		
		import javax.ws.rs.WebApplicationException;
		import javax.ws.rs.core.Response;
		
		import org.joda.time.DateTime;
		import org.joda.time.DateTimeZone;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		public abstract class ReadAction<T extends IDataContainer> extends Action<T> {
		
			static final Logger LOG = LoggerFactory.getLogger(ReadAction.class);
			
			private PersistenceConnection persistenceConnection;
			protected CustomAppConfiguration appConfiguration;
			protected IDaoProvider daoProvider;
			private E2E e2e;
			
			public ReadAction(String actionName, PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
					IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
				super(actionName, HttpMethod.GET);
				this.persistenceConnection = persistenceConnection;
				this.appConfiguration = appConfiguration;
				this.daoProvider = daoProvider;
				this.e2e = e2e;
			}
		
			protected abstract void loadDataForGetRequest(PersistenceHandle readonlyHandle);
			
			protected abstract void initActionDataFrom(ITimelineItem timelineItem);

			protected abstract void initActionDataFromNotReplayableDataProvider();

			public Response apply() {
				DatabaseHandle databaseHandle = new DatabaseHandle(persistenceConnection.getJdbi(), appConfiguration);
				databaseHandle.beginTransaction();
				try {
					if (Config.DEV.equals(appConfiguration.getConfig().getMode())
							|| Config.LIVE.equals(appConfiguration.getConfig().getMode())
							|| Config.TEST.equals(appConfiguration.getConfig().getMode())) {
						if (!daoProvider.getAceDao().checkUuid(this.actionData.getUuid())) {
							databaseHandle.rollbackTransaction();
							LOG.error("duplicate request {} {} ", actionName, this.actionData.getUuid());
							return Response.status(Response.Status.OK).entity("ignoring duplicate request " +  this.actionData.getUuid()).build();
						}
						this.actionData.setSystemTime(DateTime.now().withZone(DateTimeZone.UTC));
						this.initActionData();
					} else if (Config.REPLAY.equals(appConfiguration.getConfig().getMode())) {
						ITimelineItem timelineItem = e2e.selectAction(this.actionData.getUuid());
						initActionDataFrom(timelineItem);
					}
					if (Config.TEST.equals(appConfiguration.getConfig().getMode())) {
						initActionDataFromNotReplayableDataProvider();
					}
					this.loadDataForGetRequest(databaseHandle.getReadonlyHandle());
					
					«addActionToTimeline»
					Response response = Response.ok(this.createReponse()).build();
					databaseHandle.commitTransaction();
					return response;
				} catch (WebApplicationException x) {
					LOG.error(actionName + " returns {} due to {} ", x.getResponse().getStatusInfo(), x.getMessage());
					try {
						databaseHandle.rollbackTransaction();
						«addExceptionToTimeline»
					} catch (Exception ex) {
						LOG.error(actionName + ": failed to rollback or to save or report exception " + ex.getMessage());
					}
					return Response.status(x.getResponse().getStatusInfo()).entity(x.getMessage()).build();
				} catch (Exception x) {
					LOG.error(actionName + " failed " + x.getMessage());
					x.printStackTrace();
					try {
						databaseHandle.rollbackTransaction();
						«addExceptionToTimeline»
					} catch (Exception ex) {
						LOG.error(actionName + ": failed to rollback or to save or report exception " + ex.getMessage());
					}
					String message = x.getMessage();
					StackTraceElement[] stackTrace = x.getStackTrace();
					int i = 1;
					for (StackTraceElement stackTraceElement : stackTrace) {
						message += "\n" + stackTraceElement.toString();
						if (i > 3) {
							message += "\n" + (stackTrace.length - 4) + " more...";
							break;
						}
						i++;
					}
					return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(message).build();
				} finally {
					databaseHandle.close();
				}
			}
		
		}
		
		
		«sdg»
		
	'''

	def generateWriteAction(boolean isProxy) '''
		«copyright»
		
		package de.acegen;
		
		import javax.ws.rs.WebApplicationException;
		import javax.ws.rs.core.Response;
		
		import org.joda.time.DateTime;
		import org.joda.time.DateTimeZone;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		public abstract class «IF isProxy»Proxy«ENDIF»WriteAction<T extends IDataContainer> extends Action<T> {
		
			static final Logger LOG = LoggerFactory.getLogger(«IF isProxy»Proxy«ENDIF»WriteAction.class);
			
			private PersistenceConnection persistenceConnection;
			protected CustomAppConfiguration appConfiguration;
			protected IDaoProvider daoProvider;
			protected ViewProvider viewProvider;
			private E2E e2e;
			
			public «IF isProxy»Proxy«ENDIF»WriteAction(String actionName, PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
					IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e, HttpMethod method) {
				super(actionName, method);
				this.persistenceConnection = persistenceConnection;
				this.appConfiguration = appConfiguration;
				this.daoProvider = daoProvider;
				this.viewProvider = viewProvider;
				this.e2e = e2e;
			}
		
			protected abstract void initActionDataFrom(ITimelineItem timelineItem);
		
			«IF isProxy»protected abstract T createDataFrom(ITimelineItem timelineItem);«ENDIF»
			
			protected abstract void initActionDataFromNotReplayableDataProvider();

			protected abstract ICommand getCommand();
		
			public Response apply() {
				DatabaseHandle databaseHandle = new DatabaseHandle(persistenceConnection.getJdbi(), appConfiguration);
				databaseHandle.beginTransaction();
				try {
					if (Config.DEV.equals(appConfiguration.getConfig().getMode())
							|| Config.LIVE.equals(appConfiguration.getConfig().getMode())
							|| Config.TEST.equals(appConfiguration.getConfig().getMode())) {
						if (!daoProvider.getAceDao().checkUuid(this.actionData.getUuid())) {
							databaseHandle.rollbackTransaction();
							LOG.error("duplicate request {} {} ", actionName, this.actionData.getUuid());
							return Response.status(Response.Status.OK).entity("ignoring duplicate request " +  this.actionData.getUuid()).build();
						}
						this.actionData.setSystemTime(DateTime.now().withZone(DateTimeZone.UTC));
						this.initActionData();
					} else if (Config.REPLAY.equals(appConfiguration.getConfig().getMode())) {
						ITimelineItem timelineItem = e2e.selectAction(this.actionData.getUuid());
						initActionDataFrom(timelineItem);
					}
					if (Config.TEST.equals(appConfiguration.getConfig().getMode())) {
						initActionDataFromNotReplayableDataProvider();
					}
					«addActionToTimeline»
					
					ICommand command = this.getCommand();
					«IF isProxy»
						if (Config.REPLAY.equals(appConfiguration.getConfig().getMode())) {
							ITimelineItem timelineItem = e2e.selectCommand(this.actionData.getUuid());
							T originalData = this.createDataFrom(timelineItem);
							command.setCommandData(originalData);
						} else {
							command.execute(databaseHandle.getReadonlyHandle(), databaseHandle.getTimelineHandle());
						}
					«ELSE»
						command.execute(databaseHandle.getReadonlyHandle(), databaseHandle.getTimelineHandle());
					«ENDIF»
					command.publishEvents(databaseHandle.getHandle(), databaseHandle.getTimelineHandle());
					Response response = Response.ok(this.createReponse()).build();
					databaseHandle.commitTransaction();
					return response;
				} catch (WebApplicationException x) {
					LOG.error(actionName + " returns {} due to {} ", x.getResponse().getStatusInfo(), x.getMessage());
					try {
						databaseHandle.rollbackTransaction();
						«addExceptionToTimeline»
					} catch (Exception ex) {
						LOG.error(actionName + ": failed to rollback or to save or report exception " + ex.getMessage());
					}
					return Response.status(x.getResponse().getStatusInfo()).entity(x.getMessage()).build();
				} catch (Exception x) {
					LOG.error(actionName + " failed " + x.getMessage());
					x.printStackTrace();
					try {
						databaseHandle.rollbackTransaction();
						«addExceptionToTimeline»
					} catch (Exception ex) {
						LOG.error(actionName + ": failed to rollback or to save or report exception " + ex.getMessage());
					}
					String message = x.getMessage();
					StackTraceElement[] stackTrace = x.getStackTrace();
					int i = 1;
					for (StackTraceElement stackTraceElement : stackTrace) {
						message += "\n" + stackTraceElement.toString();
						if (i > 3) {
							message += "\n" + (stackTrace.length - 4) + " more...";
							break;
						}
						i++;
					}
					return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(message).build();
				} finally {
					databaseHandle.close();
				}
			}
		
		}
		
		
		«sdg»
		
	'''

	def generateHttpMethod() '''
		«copyright»
		
		package de.acegen;
		
		public enum HttpMethod {
			GET, POST, PUT, DELETE
		}
		
		
		«sdg»
		
	'''
	
	def generateIAction() '''
		«copyright»
		
		package de.acegen;
		
		import javax.ws.rs.core.Response;
		
		public interface IAction {
		
			String getActionName();
			
			HttpMethod getHttpMethod();
			
			IDataContainer getActionData();
			
		    Response apply();
		    
		    void initActionData();
		    
		}
		
		
		«sdg»
		
	'''
	
	def generateAppRegistration(HttpServer it) '''
		«copyright»
		
		package «getName»;
		
		import io.dropwizard.setup.Environment;
		import de.acegen.CustomAppConfiguration;
		import de.acegen.IDaoProvider;
		import de.acegen.ViewProvider;
		import de.acegen.Config;
		import de.acegen.E2E;
		import de.acegen.PersistenceConnection;
		
		«IF aceOperations.size > 0»
			import «getName».actions.*;
		«ENDIF»

		@SuppressWarnings("all")
		public class AppRegistration {
		
			public static void registerResources(Environment environment, PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
					IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
				«FOR aceOperation : aceOperations»
					environment.jersey().register(new «aceOperation.actionName»(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e));
				«ENDFOR»
			}
		
			public static void registerConsumers(ViewProvider viewProvider, String mode) {
				«FOR aceOperation : aceOperations»
					«registerConsumer(aceOperation, it)»
				«ENDFOR»
		    }
		}
		
		
		«sdg»
		
	'''
	
	private def dispatch registerConsumer(HttpServerAceWrite it, HttpServer java) '''
		«FOR outcome : outcomes»
			«FOR listener : outcome.listeners»
				«addConsumers(java, it, outcome, listener)»
			«ENDFOR»
		«ENDFOR»
	'''
	
	private def dispatch registerConsumer(HttpServerAceRead it, HttpServer java) ''''''
	
	private def addConsumers(HttpServer java, HttpServerAce aceOperation, HttpServerOutcome outcome, HttpServerViewFunction listener) '''
		viewProvider.addConsumer("«java.getName».events.«aceOperation.eventName(outcome)»", (dataContainer, handle) -> {
			viewProvider.«listener.viewFunctionWithViewNameAsVariable»((«listener.getModel.dataNameWithPackage») dataContainer, handle);
		});
		
	'''

	def generateAceDataFactory(HttpServer it) '''
		«copyright»
		
		package «getName».actions;
		
		import java.io.IOException;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import de.acegen.IDataContainer;
		import de.acegen.JodaObjectMapper;
		import «getName».data.*;
		import com.fasterxml.jackson.databind.DeserializationFeature;		
		
		public class AceDataFactory {
			
			private static JodaObjectMapper mapper = new JodaObjectMapper();
			private static final Logger LOG = LoggerFactory.getLogger(AceDataFactory.class);
		
			static {
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			}
		
			public static IDataContainer createAceData(String className, String json) {
				try {
					«FOR ace : aceOperations»
						«ace.createData(it)»
					«ENDFOR»
				} catch (IOException e) {
					LOG.error("failed to create ace data {} with data {}", className, json, e);
				}
		
				return null;
			}
		}
		
		
		«sdg»
		
	'''
	
	private def dispatch createData(HttpServerAceWrite it, HttpServer java) '''
		if (className.equals("«java.getName».actions.«actionName»") ||
				className.equals("«java.getName».commands.«commandName»") «IF outcomes.length > 0»||«ENDIF»
				«FOR outcome: outcomes SEPARATOR '||'»
					className.equals("«java.getName».events.«eventName(outcome)»")
				«ENDFOR»
		) {
			«getModel.dataName» data = mapper.readValue(json, «getModel.dataName».class);
			data.migrateLegacyData(json);
			return data;
		}
	'''
	
	private def dispatch createData(HttpServerAceRead it, HttpServer java) '''
		if (className.equals("«java.getName».actions.«actionName»")) {
			«getModel.dataName» data = mapper.readValue(json, «getModel.dataName».class);
			data.migrateLegacyData(json);
			return data;
		}
	'''

}
	
	
/******* S.D.G. *******/
	
	
