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


package de.acegen.generator.java

import de.acegen.aceGen.HttpServer
import de.acegen.aceGen.HttpServerAceWrite
import de.acegen.aceGen.Project
import de.acegen.extensions.java.AceExtension
import de.acegen.extensions.java.JavaExtension
import de.acegen.extensions.java.ModelExtension
import de.acegen.extensions.java.ViewExtension
import de.acegen.generator.ACEOutputConfigurationProvider
import de.acegen.templates.java.AceTemplate
import de.acegen.templates.java.ActionTemplate
import de.acegen.templates.java.CommandTemplate
import de.acegen.templates.java.EventTemplate
import de.acegen.templates.java.ModelTemplate
import javax.inject.Inject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext

class JavaGenerator extends AbstractGenerator {
	@Inject
	ActionTemplate actionTemplate;

	@Inject
	CommandTemplate commandTemplate;

	@Inject
	EventTemplate eventTemplate;

	@Inject
	AceTemplate aceTemplate;

	@Inject
	ModelTemplate modelTemplate;

	@Inject
	extension ViewExtension

	@Inject
	extension JavaExtension

	@Inject
	extension ModelExtension

	@Inject
	extension AceExtension

	def void doGenerate(HttpServer java, IFileSystemAccess2 fsa) {
		var authUser = java.getAuthUser
		if (authUser === null) {
			authUser = java.getAuthUserRef
		}
		for (model : java.models) {
			fsa.generateFile(java.packageFolder + '/models/' + model.modelName + '.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, modelTemplate.generateModel(model, java));
			fsa.generateFile(java.packageFolder + '/models/' + model.modelClassName + '.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, modelTemplate.generateModelClass(model, java));
			fsa.generateFile(java.packageFolder + '/models/' + model.modelMapper + '.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, modelTemplate.generateMapper(model, java));
			if (model.persistent) {
				fsa.generateFile(java.packageFolder + '/models/' + model.abstractModelDao + '.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, modelTemplate.generateAbstractDao(model, java));
				fsa.generateFile(java.packageFolder + '/models/' + model.modelDao + '.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, modelTemplate.generateDao(model, java));
				fsa.generateFile(java.packageFolder + '/' + model.name + '_creation.xml',
					ACEOutputConfigurationProvider.DEFAULT_RESOURCE_OUTPUT,
					modelTemplate.generateMigration(model, java));
			}
			fsa.generateFile(java.packageFolder + '/data/' + model.dataInterfaceName + '.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, modelTemplate.generateDataInterface(model, java));
			fsa.generateFile(java.packageFolder + '/data/' + model.abstractDataName + '.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, modelTemplate.generateAbstractData(model, java));
			fsa.generateFile(java.packageFolder + '/data/' + model.dataName + '.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, modelTemplate.generateData(model, java));
		}
		for (ace : java.aceOperations) {
			fsa.generateFile(java.packageFolder + '/actions/' + ace.abstractActionName + '.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
				actionTemplate.generateAbstractActionFile(ace, java, authUser));
			fsa.generateFile(java.packageFolder + '/actions/' + ace.actionName + '.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE,
				actionTemplate.generateInitialActionFile(ace, java));
			if (!'GET'.equals(ace.getType)) {
				fsa.generateFile(java.packageFolder + '/commands/' + ace.abstractCommandName + '.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
					commandTemplate.generateAbstractCommandFile(ace as HttpServerAceWrite, java));
				fsa.generateFile(java.packageFolder + '/commands/' + ace.commandName + '.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE,
					commandTemplate.generateInitialCommandFile(ace as HttpServerAceWrite, java));
				val aceWrite = ace as HttpServerAceWrite
				for (outcome : aceWrite.outcomes) {
					fsa.generateFile(java.packageFolder + '/events/' + ace.eventName(outcome) + '.java',
						ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
						eventTemplate.generateAbstractEventFile(ace, outcome, java));
				}
			}
			if (ace.response.size > 0) {
				fsa.generateFile(java.packageFolder + '/data/' + ace.responseDataName + '.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, modelTemplate.generateResponseData(ace, java));
				fsa.generateFile(java.packageFolder + '/data/' + ace.responseDataInterfaceName + '.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
					modelTemplate.generateReponseDataInterface(ace, java));
			}
		}
		for (view : java.views) {
			fsa.generateFile(java.packageFolder + '/views/' + view.viewName + '.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, eventTemplate.generateView(view, java));
			fsa.generateFile(java.packageFolder + '/views/' + view.viewInterfaceName + '.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, eventTemplate.generateViewInterface(view, java));
		}

		fsa.generateFile('com/anfelisa/ace/AbstractBaseTest.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			aceTemplate.generateBaseTest());

		fsa.generateFile(java.packageFolder + '/TestUtils.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			aceTemplate.generateTestUtils(java));

		fsa.generateFile(java.packageFolder + '/ActionCalls.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			aceTemplate.generateActionCalls(java));

		fsa.generateFile(java.packageFolder + '/events/EventFactory.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, eventTemplate.generateEventFactory(java));

		fsa.generateFile(java.packageFolder + '/actions/AceDataFactory.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, actionTemplate.generateAceDataFactory(java));

		fsa.generateFile('com/anfelisa/ace/EventFactory.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE,
			eventTemplate.generateEventFactory());

		fsa.generateFile(java.packageFolder + '/AppRegistration.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, actionTemplate.generateAppRegistration(java));

		fsa.generateFile("com/anfelisa/ace" + '/App.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE,
			aceTemplate.generateApp());
		fsa.generateFile("com/anfelisa/ace" + '/AppRegistration.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, aceTemplate.generateAppRegistration());
		fsa.generateFile("com/anfelisa/ace" + '/AppConfiguration.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generateAppConfiguration());
		fsa.generateFile("com/anfelisa/ace" + '/CustomAppConfiguration.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, aceTemplate.generateCustomAppConfiguration());
		fsa.generateFile("com/anfelisa/ace" + '/E2E.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			aceTemplate.generateE2E());
		fsa.generateFile("com/anfelisa/ace" + '/ServerConfiguration.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generateServerConfiguration());
		fsa.generateFile("com/anfelisa/ace" + '/StartE2ESessionResource.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generateStartE2ESessionResource());
		fsa.generateFile("com/anfelisa/ace" + '/ReplayEventsResource.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generateReplayEventsResource());
		fsa.generateFile("com/anfelisa/ace" + '/SetSystemTimeResource.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generateSetSystemTimeResource());
		fsa.generateFile("com/anfelisa/ace" + '/StopE2ESessionResource.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generateStopE2ESessionResource());
		fsa.generateFile("com/anfelisa/ace" + '/AceOperation.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			aceTemplate.generateAceOperation());
		fsa.generateFile("com/anfelisa/ace" + '/PrepareE2EResource.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generatePrepareE2EResource());
		fsa.generateFile("com/anfelisa/ace" + '/GetServerTimelineResource.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generateGetServerTimelineResource());
		fsa.generateFile("com/anfelisa/ace" + '/ServerInfo.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			aceTemplate.generateServerInfo());
		fsa.generateFile("com/anfelisa/ace" + '/GetServerInfoResource.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generateGetServerInfoResource());
		fsa.generateFile("com/anfelisa/ace" + '/EventReplayCommand.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generateEventReplayCommand());

		fsa.generateFile("com/anfelisa/ace" + '/AceDao.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			aceTemplate.generateAceDao());
		fsa.generateFile("com/anfelisa/ace" + '/AceExecutionMode.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generateAceExecutionMode());
		fsa.generateFile("com/anfelisa/ace" + '/Action.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			actionTemplate.generateAction());
		fsa.generateFile("com/anfelisa/ace" + '/Command.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			commandTemplate.generateCommand());
		fsa.generateFile("com/anfelisa/ace" + '/DatabaseHandle.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, modelTemplate.generateDatabaseHandle());
		fsa.generateFile("com/anfelisa/ace" + '/Event.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			eventTemplate.generateEvent());
		fsa.generateFile("com/anfelisa/ace" + '/HttpMethod.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			actionTemplate.generateHttpMethod());
		fsa.generateFile("com/anfelisa/ace" + '/IAction.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			actionTemplate.generateIAction());
		fsa.generateFile("com/anfelisa/ace" + '/ICommand.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			commandTemplate.generateICommand());
		fsa.generateFile("com/anfelisa/ace" + '/IDataContainer.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, modelTemplate.generateIDataContainer());
		fsa.generateFile("com/anfelisa/ace" + '/IEvent.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			eventTemplate.generateIEvent());
		fsa.generateFile("com/anfelisa/ace" + '/ITimelineItem.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			aceTemplate.generateITimelineItem());
		fsa.generateFile("com/anfelisa/ace" + '/JodaObjectMapper.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generateJodaObjectMapper());
		fsa.generateFile("com/anfelisa/ace" + '/TimelineItem.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			aceTemplate.generateTimelineItem());
		fsa.generateFile("com/anfelisa/ace" + '/TimelineItemMapper.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generateTimelineItemMapper());
		fsa.generateFile("com/anfelisa/ace" + '/AbstractData.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			modelTemplate.generateAbstractData());

		fsa.generateFile("com/anfelisa/ace" + '/AbstractDaoProvider.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generateAbstractDaoProvider());
		fsa.generateFile("com/anfelisa/ace" + '/DaoProvider.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, aceTemplate.generateDaoProvider());
		fsa.generateFile("com/anfelisa/ace" + '/IDaoProvider.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, aceTemplate.generateIDaoProvider());
		fsa.generateFile("com/anfelisa/ace" + '/ViewProvider.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, aceTemplate.generateViewProvider());
		fsa.generateFile("com/anfelisa/ace" + '/AbstractViewProvider.java',
			ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generateAbstractViewProvider());

		fsa.generateFile("com/anfelisa/ace" + '/EventConsumer.java', ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
			aceTemplate.generateEventconsumer());

		fsa.generateFile('ace_creation.xml', ACEOutputConfigurationProvider.DEFAULT_RESOURCE_OUTPUT,
			aceTemplate.generateAceMigration());

		if (authUser !== null) {
			fsa.generateFile('com/anfelisa/auth/' + authUser.name.toFirstUpper + '.java',
				ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, aceTemplate.generateAuthUser(authUser));
		}

	}

	override doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		if (resource !== null && resource.contents !== null && resource.contents.size > 0) {
			val project = resource.contents.get(0) as Project

			if (project.httpServer !== null) {
				doGenerate(project.httpServer, fsa);
			}

		}
	}

}
/******* S.D.G. *******/
