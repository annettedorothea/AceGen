package com.anfelisa.extensions

import com.anfelisa.ace.Attribute
import com.anfelisa.ace.Data
import com.anfelisa.ace.Project
import java.util.ArrayList
import java.util.List
import javax.inject.Inject

class DataExtension {
	
	@Inject
	extension AttributeExtension
	
	def String dataName(Data it) '''«name.toFirstUpper»Data'''
	def String dataNameWithPackage(Data it) '''«(eContainer as Project).name».data.«name.toFirstUpper»Data'''
	
	def String dataImport(Data it) '''
		«IF it != null»
			import «(eContainer as Project).name».data.«dataName»;
		«ELSE»
			import com.anfelisa.ace.IDataContainer;
		«ENDIF»
	'''
	
	def String dataParamType(Data it) '''«IF it != null»«dataName»«ELSE»IDataContainer«ENDIF»'''
	
	def List<Attribute> allAttributes(Data it) {
		val attrs = new ArrayList<Attribute>();
		for (model : models) {
			for (attribute : model.attributes) {
				if (!contains(attribute, attrs)) {
					attrs.add(attribute)
				}
			}
		}
		return attrs;
	}
	
	private def boolean contains(Attribute attribute, List<Attribute> attributes) {
		if (attributes.size == 0) {
			return false
		} else {
			for (attr : attributes) {
				if (attr.name.equals(attribute.name)) {
					return true
				}
			}
		}
	}
	
	def newFromCommandData(Data it) '''new «dataNameWithPackage»(
			«FOR attribute : allAttributes SEPARATOR ',' AFTER ','»
				this.commandData.«attribute.getterCall»
			«ENDFOR»
			this.commandData.getUuid()
		)'''
	
}