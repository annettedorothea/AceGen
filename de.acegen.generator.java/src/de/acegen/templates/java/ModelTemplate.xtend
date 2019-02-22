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
import de.acegen.aceGen.HttpServerAce
import de.acegen.aceGen.Model
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.java.AceExtension
import de.acegen.extensions.java.AttributeExtension
import de.acegen.extensions.java.ModelExtension
import javax.inject.Inject

class ModelTemplate {
	
	@Inject
	extension ModelExtension
	
	@Inject
	extension AttributeExtension
	
	@Inject
	extension AceExtension
	
	@Inject
	extension CommonExtension
	
	def generateModel(Model it, HttpServer java) '''
		«copyright»
		
		package «java.getName».models;
		
		import java.util.List;
		import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
		
		@SuppressWarnings("unused")
		@JsonDeserialize(as=«modelClassName».class)
		public interface «modelName» «IF superModels.size > 0»extends «FOR superModel : superModels SEPARATOR ','»«superModel.interfaceWithPackage»«ENDFOR»«ENDIF»{
		
			«FOR attribute : attributes»
				«attribute.interfaceGetter»
				«attribute.interfaceSetter»
				
			«ENDFOR»
			
			«IF containsPrimitiveAttributes»
				List<String> equalsPrimitiveTypes(«interfaceWithPackage» other);
			«ENDIF»
			
		}
		
		
		«sdg»
		
	'''
	
	def generateModelClass(Model it, HttpServer java) '''
		«copyright»
		
		package «java.getName».models;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		import javax.validation.constraints.NotNull;
		import org.hibernate.validator.constraints.NotEmpty;
		import java.util.List;
		import java.util.ArrayList;

		@SuppressWarnings("all")
		public class «modelClassName» implements «modelName» {
		
			«FOR attribute : allAttributes»
				«attribute.declaration»
				
			«ENDFOR»
		
			«IF attributes.length > 0»
				public «modelClassName»() {
				}
			«ENDIF»
		
			public «modelClassName»(
				«FOR attribute : allAttributes SEPARATOR ','»
					«attribute.param(true)»
				«ENDFOR»
			) {
				«FOR attribute : allAttributes»
					«attribute.assign»
				«ENDFOR»
			}
		
			«FOR attribute : allAttributes»
				«attribute.getter(true)»
				«attribute.setter»
				
			«ENDFOR»
			
			«FOR superModel : allSuperModels»
				«IF superModel.containsPrimitiveAttributes»
					public List<String> equalsPrimitiveTypes(«superModel.interfaceWithPackage» other) {
						List<String> differingAttributes = new ArrayList<String>();
						«FOR attribute : superModel.attributes»
							«IF attribute.isPrimitive»
								if (!(this.«attribute.getterCall» == null && other.«attribute.getterCall» == null) && !this.«attribute.getterCall».equals(other.«attribute.getterCall»)) {
									differingAttributes.add("«attribute.name»: " + this.«attribute.getterCall» + " " + other.«attribute.getterCall»);
								}
							«ENDIF»
						«ENDFOR»
						return differingAttributes;
					}
				«ENDIF»
			«ENDFOR»
			
		}
		
		
		«sdg»
		
	'''
	
	def generateDataInterface(Model it, HttpServer java) '''
		«copyright»
		
		package «java.getName».data;
		
		import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
		
		import com.anfelisa.ace.IDataContainer;
		
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
	
	def generateAbstractData(Model it, HttpServer java) '''
		«copyright»
		
		package «java.getName».data;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		
		import javax.validation.constraints.NotNull;
		import org.hibernate.validator.constraints.NotEmpty;
		import org.joda.time.DateTime;
		import java.util.List;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		import java.util.ArrayList;
		«importModel»
		«FOR superModel : superModels»
			«superModel.importModel»
		«ENDFOR»
		
		import com.anfelisa.ace.AbstractData;
		import com.anfelisa.ace.IDataContainer;
		
		@SuppressWarnings("unused")
		public abstract class «abstractDataName» extends AbstractData implements «dataInterfaceName» {
			
			static final Logger LOG = LoggerFactory.getLogger(«abstractDataName».class);
			
			«FOR attribute : allAttributes»
				«attribute.declaration»
				
			«ENDFOR»
		
			public «abstractDataName»(
				«FOR attribute : allAttributes SEPARATOR ',' AFTER ','»
					«attribute.param(true)»
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
			
			«FOR superModel : allSuperModels»
				«IF superModel.containsPrimitiveAttributes»
					public List<String> equalsPrimitiveTypes(«superModel.interfaceWithPackage» other) {
						List<String> differingAttributes = new ArrayList<String>();
						«FOR attribute : superModel.attributes»
							«IF attribute.isPrimitive»
								if (!(this.«attribute.getterCall» == null && other.«attribute.getterCall» == null) && !this.«attribute.getterCall».equals(other.«attribute.getterCall»)) {
									differingAttributes.add("«attribute.name»: " + this.«attribute.getterCall» + " " + other.«attribute.getterCall»);
								}
							«ENDIF»
						«ENDFOR»
						return differingAttributes;
					}
				«ENDIF»
				
			«ENDFOR»
			
		}
		
		
		«sdg»
		
	'''
	
	def generateData(Model it, HttpServer java) '''
		«copyright»
		
		package «java.getName».data;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		
		import org.joda.time.DateTime;
		import java.util.List;
		
		import com.anfelisa.ace.AbstractData;
		
		public class «dataName» extends «abstractDataName» implements «dataInterfaceName» {
			
			public «dataName»(
				«FOR attribute : allAttributes»
					«attribute.param(true)», 
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
		
		}
		
		
		«sdg»
		
	'''
	
	def generateAbstractData() '''
		«copyright»
		
		package com.anfelisa.ace;
		
		import org.joda.time.DateTime;
		import java.util.HashMap;
		import java.util.Map;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		
		public abstract class AbstractData implements IDataContainer {
		
			private String uuid;
			
			private String outcome;
			
			private DateTime systemTime;
			
			private Map<String, String> uuidsForTriggeredAction;
			
			public AbstractData( String uuid ) {
				this.uuid = uuid;
				this.uuidsForTriggeredAction = new HashMap<String, String>();
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
			public DateTime getSystemTime() {
				return systemTime;
			}
		
			@JsonProperty
			public void setSystemTime(DateTime systemTime) {
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
			
			@JsonProperty
			public Map<String, String> getUuidsForTriggeredAction() {
				return uuidsForTriggeredAction;
			}
		
			@JsonProperty
			public void setUuidsForTriggeredAction(Map<String, String> uuidsForTriggeredAction) {
				this.uuidsForTriggeredAction = uuidsForTriggeredAction;
			}
		
			public void addUuidForTriggeredAction(String actionName, String uuid) {
				uuidsForTriggeredAction.put(actionName, uuid);
			}
		
			public String getUuidForTriggeredAction(String actionName) {
				return uuidsForTriggeredAction.get(actionName);
			}
		
		}
		
		
		«sdg»
		
	'''
	
	def generateResponseData(HttpServerAce it, HttpServer java) '''
		«copyright»
		
		package «java.getName».data;
		
		import com.fasterxml.jackson.annotation.JsonProperty;
		import com.fasterxml.jackson.annotation.JsonIgnore;
		
		import javax.validation.constraints.NotNull;
		import org.hibernate.validator.constraints.NotEmpty;
		import org.joda.time.DateTime;
		import java.util.List;
		
		import com.anfelisa.ace.IDataContainer;
		
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
	
	def generateReponseDataInterface(HttpServerAce it, HttpServer java) '''
		«copyright»
		
		package «java.getName».data;
		
		public interface «responseDataInterfaceName» {
			«FOR attribute : response»
				«attribute.interfaceGetter»
				
			«ENDFOR»
		
		}
		
		
		«sdg»
		
	'''
	
	def generateAbstractDao(Model it, HttpServer java) '''
		«copyright»
		
		package «java.getName».models;
		
		import org.jdbi.v3.core.Handle;
		import org.jdbi.v3.core.statement.Update;

		import java.util.List;
		import java.util.Optional;
		
		@SuppressWarnings("all")
		public class «abstractModelDao» {
			
			public void insert(Handle handle, «modelName» «modelParam») {
				Update statement = handle.createUpdate("INSERT INTO «table» («FOR attribute : attributes SEPARATOR ', '»«attribute.name.toLowerCase»«ENDFOR») VALUES («FOR attribute : attributes SEPARATOR ', '»«modelAttributeSqlValue(attribute)»«ENDFOR»)");
				«FOR attribute : attributes»
					statement.bind("«attribute.name.toLowerCase»", «modelGetAttribute(attribute)»);
				«ENDFOR»
				statement.execute();
			}
			
			
			«FOR attribute : allUniqueAttributes»
				public void updateBy«attribute.name.toFirstUpper»(Handle handle, «modelName» «modelParam») {
					Update statement = handle.createUpdate("UPDATE «table» SET «FOR attr : attributes SEPARATOR ', '»«attr.name.toLowerCase» = :«attr.name.toLowerCase»«ENDFOR» WHERE «attribute.name.toLowerCase» = :«attribute.name.toLowerCase»");
					«FOR attr : attributes»
						statement.bind("«attr.name.toLowerCase»", «modelGetAttribute(attr)»);
					«ENDFOR»
					statement.bind("«attribute.name.toLowerCase»", «modelGetAttribute(attribute)» );
					statement.execute();
				}

				public void deleteBy«attribute.name.toFirstUpper»(Handle handle, «attribute.javaType» «attribute.name») {
					Update statement = handle.createUpdate("DELETE FROM «table» WHERE «attribute.name.toLowerCase» = :«attribute.name.toLowerCase»");
					statement.bind("«attribute.name.toLowerCase»", «attribute.name»);
					statement.execute();
				}

				public «modelName» selectBy«attribute.name.toFirstUpper»(Handle handle, «attribute.javaType» «attribute.name») {
					Optional<«modelName»> optional = handle.createQuery("SELECT «FOR attr : attributes SEPARATOR ', '»«attr.name.toLowerCase»«ENDFOR» FROM «table» WHERE «attribute.name.toLowerCase» = :«attribute.name.toLowerCase»")
						.bind("«attribute.name.toLowerCase»", «attribute.name»)
						.map(new «modelMapper»())
						.findFirst();
					return optional.isPresent() ? optional.get() : null;
				}
			«ENDFOR»
			
			public List<«modelName»> selectAll(Handle handle) {
				return handle.createQuery("SELECT «FOR attr : attributes SEPARATOR ', '»«attr.name.toLowerCase»«ENDFOR» FROM «table»")
					.map(new «modelMapper»())
					.list();
			}

			public void truncate(Handle handle) {
				Update statement = handle.createUpdate("TRUNCATE TABLE «table» CASCADE");
				statement.execute();
			}

		}
		
		
		«sdg»
		
	'''
	
	def generateDao(Model it, HttpServer java) '''
		«copyright»
		
		package «java.getName».models;
		
		public class «modelDao» extends «abstractModelDao» {
			
		}
		
		
		«sdg»
		
	'''
	
	def generateMigration(Model it, HttpServer java) '''
		<createTable tableName="«name.toLowerCase»">
			«FOR attribute : attributes»
				<column name="«attribute.name.toLowerCase»" type="«attribute.sqlType»">
					<constraints «IF attribute.isPrimaryKey»primaryKey="true"«ENDIF» «IF attribute.constraint !== null && attribute.constraint.equals('NotNull')»nullable="false"«ENDIF» «IF attribute.foreignKey !== null»	references="«attribute.foreignKey.tableName»(«attribute.foreignKey.name.toLowerCase»)" deleteCascade="true" foreignKeyName="fk_«table»_«attribute.foreignKey.name.toLowerCase»"«ENDIF» />
				</column>
			«ENDFOR»
		</createTable>
	'''
	
	def generateMapper(Model it, HttpServer java) '''
		«copyright»
		
		package «java.getName».models;
		
		import java.sql.ResultSet;
		import java.sql.SQLException;
		
		import org.jdbi.v3.core.mapper.RowMapper;
		import org.jdbi.v3.core.statement.StatementContext;
		
		public class «modelMapper» implements RowMapper<«modelName»> {
			
			public «modelName» map(ResultSet r, StatementContext ctx) throws SQLException {
				return new «modelClassName»(
					«FOR attribute : allAttributes SEPARATOR ','»
						«attribute.mapperInit»
					«ENDFOR»
				);
			}
		}
		
		
		«sdg»
		
	'''
	
	def generateDatabaseHandle() '''
		«copyright»
		
		package com.anfelisa.ace;
		
		import org.jdbi.v3.core.Handle;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		import org.jdbi.v3.core.Jdbi;
		
		public class DatabaseHandle {
		
			static final Logger LOG = LoggerFactory.getLogger(DatabaseHandle.class);
		
			private Handle handle;
			private Handle readonlyHandle;
			private Handle timelineHandle;
		
			public DatabaseHandle(Jdbi jdbi) {
				super();
				this.handle = jdbi.open();
				this.readonlyHandle = jdbi.open();
				this.timelineHandle = jdbi.open();
			}
		
			synchronized public void beginTransaction() {
				handle.begin();
				readonlyHandle.begin();
				timelineHandle.begin();
			}
		
			synchronized public void commitTransaction() {
				handle.commit();
				readonlyHandle.rollback();
				timelineHandle.commit();
			}
		
			synchronized public void rollbackTransaction() {
				handle.rollback();
				readonlyHandle.rollback();
				timelineHandle.commit();
			}
		
			synchronized public void close() {
				handle.close();
				readonlyHandle.close();
				timelineHandle.close();
			}
		
			public Handle getHandle() {
				return handle;
			}
		
			public Handle getReadonlyHandle() {
				return readonlyHandle;
			}
		
			public Handle getTimelineHandle() {
				return timelineHandle;
			}
		
		}

		
		«sdg»
		
	'''
	
	def generateIDataContainer() '''
		«copyright»
		
		package com.anfelisa.ace;
		
		import org.joda.time.DateTime;
		
		public interface IDataContainer {
		
			String getUuid();
			
			void setUuid(String uuid);

			String getOutcome();

			void setOutcome(String outcome);
		
			DateTime getSystemTime();
		
			void setSystemTime(DateTime systemTime);
		
			void migrateLegacyData(String json);
		
			void addUuidForTriggeredAction(String actionName, String uuid);
		
			String getUuidForTriggeredAction(String actionName);

		}
		
		
		«sdg»
		
	'''
	

	
}
	
	
/******* S.D.G. *******/
	
	
