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

import de.acegen.aceGen.HttpServer
import de.acegen.aceGen.HttpServerAceWrite
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.java.AceExtension
import de.acegen.extensions.java.ModelExtension
import javax.inject.Inject

class CommandTemplate {
	@Inject
	extension AceExtension

	@Inject
	extension ModelExtension

	@Inject
	extension CommonExtension
	
	def generateAbstractCommandFile(HttpServerAceWrite it, HttpServer java) '''
		«copyright»
		
		package «java.getName».commands;
		
		import javax.ws.rs.WebApplicationException;
		import org.jdbi.v3.core.Handle;
		
		import com.anfelisa.ace.Command;
		import com.anfelisa.ace.CustomAppConfiguration;
		import com.anfelisa.ace.IDaoProvider;
		import com.anfelisa.ace.ViewProvider;
		
		«getModel.dataImport»
		
		public abstract class «abstractCommandName» extends Command<«getModel.dataParamType»> {
		
			«FOR outcome : outcomes»
				protected static final String «outcome.getName» = "«outcome.getName»";
			«ENDFOR»
		
			public «abstractCommandName»(«getModel.dataParamType» commandParam, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
				super("«java.getName».commands.«commandName»", commandParam, daoProvider, viewProvider, appConfiguration);
			}
		
			@Override
			public void publishEvents(Handle handle, Handle timelineHandle) {
				switch (this.commandData.getOutcome()) {
				«FOR outcome : outcomes»
					case «outcome.getName»:
						«IF outcome.listeners.size > 0»
							new «eventNameWithPackage(outcome)»(this.commandData, daoProvider, viewProvider).publish(handle, timelineHandle);
						«ENDIF»
						break;
				«ENDFOR»
				default:
					throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
				}
			}
			
		}
		
		
		«sdg»
		
	'''

	def generateInitialCommandFile(HttpServerAceWrite it, HttpServer java) '''
		«copyright»
		
		package «java.getName».commands;
		
		import com.anfelisa.ace.ViewProvider;
		import com.anfelisa.ace.IDaoProvider;
		import com.anfelisa.ace.CustomAppConfiguration;
		import org.jdbi.v3.core.Handle;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		«getModel.dataImport»
		
		public class «commandName» extends «abstractCommandName» {
		
			static final Logger LOG = LoggerFactory.getLogger(«commandName».class);
		
			public «commandName»(«getModel.dataParamType» commandData, IDaoProvider daoProvider, ViewProvider viewProvider, 
					CustomAppConfiguration appConfiguration) {
				super(commandData, daoProvider, viewProvider, appConfiguration);
			}
		
			@Override
			protected void executeCommand(Handle readonlyHandle) {
				«IF outcomes.size > 0»
					this.commandData.setOutcome(«outcomes.get(0).getName»);
				«ENDIF»
			}
		
		}
		
		
		«sdg»
		
	'''

	def generateCommand() '''
		«copyright»
		
		package com.anfelisa.ace;
		
		import javax.ws.rs.WebApplicationException;
		import javax.ws.rs.core.Response;
		import com.anfelisa.ace.CustomAppConfiguration;
		
		import org.jdbi.v3.core.Handle;
		
		public abstract class Command<T extends IDataContainer> implements ICommand {
		
			protected T commandData;
			private String commandName;
			protected JodaObjectMapper mapper;
			protected IDaoProvider daoProvider;
			protected ViewProvider viewProvider;
			protected CustomAppConfiguration appConfiguration;
		
			public Command(String commandName, T commandData, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
				super();
				this.commandData = commandData;
				this.commandName = commandName;
				mapper = new JodaObjectMapper();
				this.daoProvider = daoProvider;
				this.viewProvider = viewProvider;
				this.appConfiguration = appConfiguration;
			}
		
			protected abstract void executeCommand(Handle readonlyHandle);
		
			public void execute(Handle readonlyHandle, Handle timelineHandle) {
				this.executeCommand(readonlyHandle);
				daoProvider.getAceDao().addCommandToTimeline(this, timelineHandle);
			}
		
			public IDataContainer getCommandData() {
				return commandData;
			}
			
			@SuppressWarnings("unchecked")
			public void setCommandData(IDataContainer data) {
				commandData = (T)data;
			}
		
			public String getCommandName() {
				return commandName;
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
		
		}
		
		
		«sdg»
		
	'''

	def generateICommand() '''
		«copyright»
		
		package com.anfelisa.ace;
		
		import org.jdbi.v3.core.Handle;
		
		public interface ICommand {
		
			String getCommandName();

			IDataContainer getCommandData();
			
			void setCommandData(IDataContainer data);

			void execute(Handle readonlyHandle, Handle timelineHandle);
		
			void publishEvents(Handle handle, Handle timelineHandle);
		}
		
		
		«sdg»
		
	'''
	
}
	
	
/******* S.D.G. *******/
	
	
