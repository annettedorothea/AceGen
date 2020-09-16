/********************************************************************************
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
 ********************************************************************************/


package de.acegen.templates.java.data

import de.acegen.aceGen.HttpServer
import de.acegen.aceGen.HttpServerAce
import de.acegen.aceGen.Model
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.java.AceExtension
import de.acegen.extensions.java.AttributeExtension
import de.acegen.extensions.java.ModelExtension
import javax.inject.Inject

class Data {

	@Inject
	extension ModelExtension
	
	@Inject
	extension AttributeExtension
	
	@Inject
	extension CommonExtension
	
	@Inject
	extension AceExtension
	
	def generateDataInterface(Model it, HttpServer httpServer) '''
		«copyright»
		
		package «httpServer.getName».data;
		
		import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
		
		import de.acegen.IDataContainer;
		
		«importModel»
		
		@JsonDeserialize(as=«dataName».class)
		public interface «dataInterfaceName» extends «modelName», IDataContainer {
			«FOR superModel : superModels»
				void mapFrom(«superModel.interfaceWithPackage» model);
			«ENDFOR»
			
			«FOR attribute : allAttributes»
				«dataInterfaceName» with«attribute.name.toFirstUpper»(«attribute.javaType» «attribute.name»);
				
			«ENDFOR»
			
		}
		
		«sdg»
		
	'''
	
	def generateAbstractData(Model it, HttpServer httpServer) '''
		«copyright»
		
		package «httpServer.getName».data;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		import com.fasterxml.jackson.databind.annotation.JsonSerialize;
		import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
		
		import java.time.LocalDateTime;
		import java.util.List;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		import java.util.ArrayList;
		«importModel»
		«FOR superModel : superModels»
			«superModel.importModel»
		«ENDFOR»
		
		import de.acegen.AbstractData;
		import de.acegen.IDataContainer;
		import de.acegen.DateTimeToStringConverter;
		import de.acegen.StringToDateTimeConverter;
		
		@SuppressWarnings("unused")
		public abstract class «abstractDataName» extends AbstractData implements «dataInterfaceName» {
			
			static final Logger LOG = LoggerFactory.getLogger(«abstractDataName».class);
			
			«FOR attribute : allAttributes»
				«attribute.declaration»
				
			«ENDFOR»
		
			public «abstractDataName»(
				«FOR attribute : allAttributes SEPARATOR ',' AFTER ','»
					«attribute.paramAsJsonProperty»
				«ENDFOR»
				@JsonProperty("uuid") String uuid
			) {
				super(uuid);
				«FOR attribute : allAttributes»
					«attribute.assign»
				«ENDFOR»
			}
		
			«IF allAttributes.length > 0»
				public «abstractDataName»( String uuid ) {
					super(uuid);
				}
			«ENDIF»
		
			«FOR attribute : allAttributes»
				«attribute.getter(true)»
				«attribute.setter»
				«attribute.with(it)»
				
			«ENDFOR»
			
			«FOR superModel : superModels»
				public void mapFrom(«superModel.interfaceWithPackage» model) {
					«FOR attribute: superModel.allAttributes»
						this.«attribute.name» = model.«attribute.getterCall»;
					«ENDFOR»
				}
			«ENDFOR»
			
		}
		
		«sdg»
		
	'''
	
	def generateData(Model it, HttpServer httpServer) '''
		«copyright»
		
		package «httpServer.getName».data;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		
		import java.time.LocalDateTime;
		import java.util.List;
		
		import de.acegen.AbstractData;
		
		public class «dataName» extends «abstractDataName» implements «dataInterfaceName» {
			
			public «dataName»(
				«FOR attribute : allAttributes»
					«attribute.paramAsJsonProperty», 
				«ENDFOR»
				@JsonProperty("uuid") String uuid
			) {
				super(
					«FOR attribute : allAttributes»
						«attribute.name»,
					«ENDFOR»
					uuid
				);
			}

			«IF allAttributes.length > 0»
				public «dataName»( String uuid ) {
					super(uuid);
				}

			«ENDIF»
			public void migrateLegacyData(String json) {
			}
		
			public static «interfaceWithPackage» generateTestData() {
				java.util.Random random = new java.util.Random();
				int n;
				«interfaceWithPackage» testData = new «modelClassNameWithPackage»();
				«FOR attribute : allAttributes»
					«IF attribute.model !== null»
						«IF attribute.list»
							java.util.List<«attribute.model.interfaceWithPackage»> «attribute.name.toFirstLower»List = new java.util.ArrayList<«attribute.model.interfaceWithPackage»>();
							n = random.nextInt(20) + 1;
							for ( int i = 0; i < n; i++ ) {
								«attribute.name.toFirstLower»List.add(«attribute.model.dataNameWithPackage».generateTestData());
							}
							testData.«attribute.setterCall('''«attribute.name.toFirstLower»List''')»;
						«ELSE»
							testData.«attribute.setterCall('''«attribute.model.dataNameWithPackage».generateTestData()''')»;
						«ENDIF»
					«ELSE»
						testData.«attribute.setterCall('''«attribute.randomValue»''')»;
					«ENDIF»
				«ENDFOR»
				return testData;
			}
			
			private static String randomString(java.util.Random random) {
				String chars = "aaaaaaabcdeeeeeeeffffghiiiiiiijkllllllmmmmnnnnnnnooooooooopqrstttuuuuuuuvxyz";
				int n = random.nextInt(20) + 5;
				StringBuilder sb = new StringBuilder(n);
				for (int i = 0; i < n; i++) {
					int index = random.nextInt(chars.length());
					sb.append(chars.charAt(index));
				}
				String string  = sb.toString(); 
				return string.substring(0,1).toUpperCase() + string.substring(1).toLowerCase();
			}
			
		}
		
		«sdg»
		
	'''
	
	def generateResponseData(HttpServerAce it, HttpServer httpServer) '''
		«copyright»
		
		package «httpServer.getName».data;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		import com.fasterxml.jackson.annotation.JsonIgnore;
		import com.fasterxml.jackson.databind.annotation.JsonSerialize;
		import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
		
		import java.time.LocalDateTime;
		import java.util.List;
		
		import de.acegen.IDataContainer;
		import de.acegen.DateTimeToStringConverter;
		import de.acegen.StringToDateTimeConverter;
		
		@SuppressWarnings("all")
		public class «responseDataName» implements «responseDataInterfaceName» {
			
			«FOR attribute : response»
				«attribute.declaration»
				
			«ENDFOR»
			public «responseDataName»() {
			}
			
			public «responseDataName»(«getModel.interfaceWithPackage» data) {
				«FOR attribute : response»
					«attribute.name» = data.«attribute.getterCall»;
				«ENDFOR»
			}
			
			«FOR attribute : response»
				«attribute.getter(true)»
				
			«ENDFOR»
		}
		
		«sdg»
		
	'''
	
	def generateReponseDataInterface(HttpServerAce it, HttpServer httpServer) '''
		«copyright»
		
		package «httpServer.getName».data;
		
		public interface «responseDataInterfaceName» {
			«FOR attribute : response»
				«attribute.interfaceGetter»
				
			«ENDFOR»
		
		}
		
		«sdg»
		
	'''
	
	def generatePayloadData(HttpServerAce it, HttpServer httpServer) '''
		«copyright»
		
		package «httpServer.getName».data;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		import com.fasterxml.jackson.annotation.JsonIgnore;
		import com.fasterxml.jackson.databind.annotation.JsonSerialize;
		import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
		
		import java.time.LocalDateTime;
		import java.util.List;
		
		import de.acegen.IDataContainer;
		import de.acegen.DateTimeToStringConverter;
		import de.acegen.StringToDateTimeConverter;
		
		@SuppressWarnings("all")
		public class «payloadDataName» implements «payloadDataInterfaceName» {
			
			«FOR attributeRef : payload»
				«attributeRef.attribute.declaration»
				
			«ENDFOR»
			public «payloadDataName»() {
			}
			
			public «payloadDataName»(«getModel.interfaceWithPackage» data) {
				«FOR attributeRef : payload»
					«attributeRef.attribute.name» = data.«attributeRef.attribute.getterCall»;
				«ENDFOR»
			}
			
			«FOR attributeRef : payload»
				«attributeRef.attribute.getter(true)»
				
			«ENDFOR»
		}
		
		«sdg»
		
	'''
	
	def generatePayloadDataInterface(HttpServerAce it, HttpServer httpServer) '''
		«copyright»
		
		package «httpServer.getName».data;
		
		public interface «payloadDataInterfaceName» {
			«FOR attributeRef : payload»
				«attributeRef.attribute.interfaceGetter»
				
			«ENDFOR»
		
		}
		
		«sdg»
		
	'''
	
	def generateIDataContainer() '''
		«copyright»
		
		package de.acegen;
		
		import java.time.LocalDateTime;
		
		public interface IDataContainer {
		
			String getUuid();
			
			void setUuid(String uuid);

			String getOutcome();

			void setOutcome(String outcome);
		
			LocalDateTime getSystemTime();
		
			void setSystemTime(LocalDateTime systemTime);
		
			void migrateLegacyData(String json);

		}
		
		
		«sdg»
		
	'''
	
	def generateAbstractData() '''
		«copyright»
		
		package de.acegen;
		
		import java.time.LocalDateTime;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
		import com.fasterxml.jackson.databind.annotation.JsonSerialize;
		
		public abstract class AbstractData implements IDataContainer {
		
			private String uuid;
			
			private String outcome;
			
			private LocalDateTime systemTime;
			
			public AbstractData( String uuid ) {
				this.uuid = uuid;
			}
		
			@JsonProperty
			public String getUuid() {
				return this.uuid;
			}
		
			@JsonProperty
			public void setUuid(String uuid) {
				this.uuid = uuid;
			}
		
			@JsonProperty
			@JsonSerialize(converter = DateTimeToStringConverter.class)
			@JsonDeserialize(converter = StringToDateTimeConverter.class)
			public LocalDateTime getSystemTime() {
				return systemTime;
			}
		
			@JsonProperty
			public void setSystemTime(LocalDateTime systemTime) {
				this.systemTime = systemTime;
			}
		
			@JsonProperty
			public String getOutcome() {
				return outcome;
			}
		
			@JsonProperty
			public void setOutcome(String outcome) {
				this.outcome = outcome;
			}
			
		}
		
		
		«sdg»
		
	'''
	
	
}