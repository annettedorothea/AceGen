/*
 * generated by Xtext 2.10.0
 */
package com.anfelisa.generator

import com.anfelisa.ace.Project
import com.anfelisa.extensions.ActionExtension
import com.anfelisa.extensions.CommandExtension
import com.anfelisa.extensions.DataExtension
import com.anfelisa.extensions.EventExtension
import com.anfelisa.extensions.ModelExtension
import com.anfelisa.extensions.ProjectExtension
import com.anfelisa.extensions.ViewExtension
import javax.inject.Inject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class AceGenerator extends AbstractGenerator {

	@Inject
	ES6Template es6Template;

	@Inject
	JavaTemplate javaTemplate;

	@Inject
	extension ActionExtension

	@Inject
	extension CommandExtension

	@Inject
	extension EventExtension

	@Inject
	extension ViewExtension

	@Inject
	extension ProjectExtension

	@Inject
	extension ModelExtension

	@Inject
	extension DataExtension

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		if (resource !== null && resource.contents !== null && resource.contents.size > 0) {
			val project = resource.contents.get(0) as Project

			if (project.target == 'ES6') {
				for (action : project.actions) {
					fsa.generateFile(project.name + '/actions/' + action.abstractActionName + '.js',
						IFileSystemAccess.DEFAULT_OUTPUT, es6Template.generateAbstractActionFile(action, project));
					fsa.generateFile(project.name + '/actions/' + action.actionName + '.js',
						ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE,
						es6Template.generateInitialActionFile(action, project));
				}
				for (command : project.commands) {
					fsa.generateFile(project.name + '/commands/' + command.abstractCommandName + '.js',
						IFileSystemAccess.DEFAULT_OUTPUT, es6Template.generateAbstractCommandFile(command, project));
					fsa.generateFile(project.name + '/commands/' + command.commandName + '.js',
						ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE,
						es6Template.generateInitialCommandFile(command, project));
				}
				fsa.generateFile(project.name + '/EventListenerRegistration.js', IFileSystemAccess.DEFAULT_OUTPUT,
					es6Template.generateEventListenerRegistration(project));
				fsa.generateFile(project.name + '/ActionFactoryRegistration.js', IFileSystemAccess.DEFAULT_OUTPUT,
					es6Template.generateActionFactoryRegistration(project));
				for (event : project.events) {
					fsa.generateFile(project.name + '/events/' + event.abstractEventName + '.js',
						IFileSystemAccess.DEFAULT_OUTPUT, es6Template.generateAbstractEventFile(event, project));
					fsa.generateFile(project.name + '/events/' + event.eventName + '.js',
						ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE, es6Template.generateInitialEventFile(event, project));
				}
				for (view : project.views) {
					fsa.generateFile(project.name + '/views/' + view.viewName + '.js',
						ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE, es6Template.generateView(view, project));
				}
				fsa.generateFile('app/App.js',
					ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE, es6Template.generateAppStub(project));
				fsa.generateFile('app/AppUtils.js',
					ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE, es6Template.generateAppUtilsStub(project));
				fsa.generateFile('app/ReplayUtils.js',
					ACEOutputConfigurationProvider.DEFAULT_JAVASCRIPT_OUTPUT_ONCE, es6Template.generateReplayUtilsStub(project));
				fsa.generateFile('ace/Action.js', IFileSystemAccess.DEFAULT_OUTPUT,
					es6Template.generateAction(project));
				fsa.generateFile('ace/Command.js', IFileSystemAccess.DEFAULT_OUTPUT,
					es6Template.generateCommand(project));
				fsa.generateFile('ace/Event.js', IFileSystemAccess.DEFAULT_OUTPUT,
					es6Template.generateEvent(project));
				fsa.generateFile('ace/ACEController.js', IFileSystemAccess.DEFAULT_OUTPUT,
					es6Template.generateACEController(project));
				fsa.generateFile('ace/TriggerAction.js', IFileSystemAccess.DEFAULT_OUTPUT,
					es6Template.generateTriggerAction(project));
			} else if (project.target == 'JAVA') {
				for (model : project.models) {
					fsa.generateFile(project.packageFolder + '/models/' + model.modelName + '.java',
						ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
						javaTemplate.generateModel(model, project));
					fsa.generateFile(project.packageFolder + '/models/' + model.modelClassName + '.java',
						ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
						javaTemplate.generateModelClass(model, project));
					fsa.generateFile(project.packageFolder + '/' + model.name + '.html',
						ACEOutputConfigurationProvider.DEFAULT_RESOURCE_OUTPUT,
						javaTemplate.generateModelResource(model));
					if (model.persistent) {
						fsa.generateFile(project.packageFolder + '/models/' + model.modelDao + '.java',
							ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
							javaTemplate.generateDao(model, project));
						fsa.generateFile(project.packageFolder + '/models/' + model.modelMapper + '.java',
							ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
							javaTemplate.generateMapper(model, project));
						fsa.generateFile(project.packageFolder + '/' + model.name + '_creation.xml',
							ACEOutputConfigurationProvider.DEFAULT_RESOURCE_OUTPUT,
							javaTemplate.generateMigration(model, project));
					}
				}
				for (data : project.data) {
					fsa.generateFile(project.packageFolder + '/data/' + data.dataInterfaceName + '.java',
						ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
						javaTemplate.generateDataInterface(data, project));
					fsa.generateFile(project.packageFolder + '/data/' + data.dataName + '.java',
						ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
						javaTemplate.generateData(data, project));
				}
				for (action : project.actions) {
					fsa.generateFile(project.packageFolder + '/actions/' + action.abstractActionName + '.java',
						ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
						javaTemplate.generateAbstractActionFile(action, project));
					fsa.generateFile(project.packageFolder + '/actions/' + action.actionName + '.java',
						ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE,
						javaTemplate.generateInitialActionFile(action, project));
					/*fsa.generateFile(project.packageFolder + '/resources/' + action.resourceName + '.java',
						ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE,
						javaTemplate.generateInitialResourceFile(action, project));*/
				}
				for (command : project.commands) {
					fsa.generateFile(project.packageFolder + '/commands/' + command.abstractCommandName + '.java',
						ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
						javaTemplate.generateAbstractCommandFile(command, project));
					fsa.generateFile(project.packageFolder + '/commands/' + command.commandName + '.java',
						ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE,
						javaTemplate.generateInitialCommandFile(command, project));
				}
				for (event : project.events) {
					fsa.generateFile(project.packageFolder + '/events/' + event.abstractEventName + '.java',
						ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT,
						javaTemplate.generateAbstractEventFile(event, project));
					fsa.generateFile(project.packageFolder + '/events/' + event.eventName + '.java',
						ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE,
						javaTemplate.generateInitialEventFile(event, project));
				}
				for (view : project.views) {
					fsa.generateFile(project.packageFolder + '/views/' + view.viewName + '.java',
						ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT_ONCE, javaTemplate.generateView(view, project));
				}
				fsa.generateFile(project.packageFolder + '/AppRegistration.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, javaTemplate.generateAppRegistration(project));

				fsa.generateFile("com/anfelisa/ace" + '/AceController.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, javaTemplate.generateAceController());
				fsa.generateFile("com/anfelisa/ace" + '/AceDao.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, javaTemplate.generateAceDao());
				fsa.generateFile("com/anfelisa/ace" + '/AceExecutionMode.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, javaTemplate.generateAceExecutionMode());
				fsa.generateFile("com/anfelisa/ace" + '/Action.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, javaTemplate.generateAction());
				fsa.generateFile("com/anfelisa/ace" + '/Command.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, javaTemplate.generateCommand());
				fsa.generateFile("com/anfelisa/ace" + '/DatabaseHandle.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, javaTemplate.generateDatabaseHandle());
				fsa.generateFile("com/anfelisa/ace" + '/DataContainer.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, javaTemplate.generateDataContainer());
				fsa.generateFile("com/anfelisa/ace" + '/Event.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, javaTemplate.generateEvent());
				fsa.generateFile("com/anfelisa/ace" + '/HttpMethod.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, javaTemplate.generateHttpMethod());
				fsa.generateFile("com/anfelisa/ace" + '/IAction.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, javaTemplate.generateIAction());
				fsa.generateFile("com/anfelisa/ace" + '/ICommand.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, javaTemplate.generateICommand());
				fsa.generateFile("com/anfelisa/ace" + '/IDataContainer.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, javaTemplate.generateIDataContainer());
				fsa.generateFile("com/anfelisa/ace" + '/IEvent.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, javaTemplate.generateIEvent());
				fsa.generateFile("com/anfelisa/ace" + '/ITimelineItem.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, javaTemplate.generateITimelineItem());
				fsa.generateFile("com/anfelisa/ace" + '/JodaObjectMapper.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, javaTemplate.generateJodaObjectMapper());
				fsa.generateFile("com/anfelisa/ace" + '/Resource.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, javaTemplate.generateResource());
				fsa.generateFile("com/anfelisa/ace" + '/TimelineItem.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, javaTemplate.generateTimelineItem());
				fsa.generateFile("com/anfelisa/ace" + '/TimelineItemMapper.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, javaTemplate.generateTimelineItemMapper());

				fsa.generateFile("com/anfelisa/ace/encryption" + '/AESEncryption.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, javaTemplate.generateAESEncryption());
				fsa.generateFile("com/anfelisa/ace/encryption" + '/EncryptionService.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, javaTemplate.generateEncryptionService());
				fsa.generateFile("com/anfelisa/ace/encryption" + '/IEncryptionService.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, javaTemplate.generateIEncryptionService());
				fsa.generateFile("com/anfelisa/ace/encryption" + '/KeyStoreUtils.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, javaTemplate.generateKeystoreUtils());
				fsa.generateFile("com/anfelisa/ace/encryption" + '/NoEncryption.java',
					ACEOutputConfigurationProvider.DEFAULT_JAVA_OUTPUT, javaTemplate.generateNoEncryption());
			}
		}
	}
}
