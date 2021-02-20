package de.acegen.templates.es6

import de.acegen.aceGen.GroupedClientAttribute
import de.acegen.aceGen.HttpClient
import de.acegen.aceGen.SingleClientAttribute
import de.acegen.extensions.CommonExtension
import de.acegen.extensions.es6.Es6Extension
import javax.inject.Inject

class ReactTemplate {
	
	@Inject
	extension CommonExtension
	
	@Inject
	extension Es6Extension
	
	dispatch def generateComponent(SingleClientAttribute it, String subFolder, String folderPrefix) '''
		«copyright»

		import React, {useState} from 'react';
		import { uiElement } from "«folderPrefix»../../src/components«subFolder»/«componentName»";
		
		«IF !list»
			export const set«componentName»State = (newState) => {
			    if (functions.setState) {
			        functions.setState(newState);
			    }
			}
			
			let functions = {};
		«ENDIF»
		
		export const «reactComponentName» = (props) => {
			«IF !list»
			    const [state, setState] = useState();
			    functions.setState = setState;
			    return uiElement({...props, ...state});
			«ELSE»
			    return uiElement({...props});
			«ENDIF»
		}
		
		«sdg»
		
	'''
	
	dispatch def generateComponent(GroupedClientAttribute it, String subFolder, String folderPrefix) '''
		«copyright»

		import React, {useState} from 'react';
		import { uiElement } from "«folderPrefix»../../src/components«subFolder»/«componentName»";
		
		export const set«componentName»State = (newState) => {
		    if (functions.setState) {
		        functions.setState(newState);
		    }
		}
		
		let functions = {};
		
		export const «reactComponentName» = (props) => {
		    const [state, setState] = useState();
		    functions.setState = setState;
		    return uiElement({...props, ...state});
		}
		
		«sdg»
		
	'''
	
	def dispatch generateComponentStruct(SingleClientAttribute it, String folderPrefix) '''
		«copyright»
		
		import { pre«FOR attribute: attributes.filter[a | a instanceof SingleClientAttribute && (a as SingleClientAttribute).attributes.size > 0 || a instanceof GroupedClientAttribute] BEFORE "," SEPARATOR ","» «attribute.reactTagName»«ENDFOR» } from "«folderPrefix»../../gen/components/ReactHelper";
		
		export function uiElement(attributes) {
			const json = JSON.stringify(attributes, null, '\t');
			return pre({}, [json]);
		}
		
		«sdg»
		
	'''
	
	def dispatch generateComponentStruct(GroupedClientAttribute it, String folderPrefix) '''
		«copyright»

		import { «FOR attribute: attributeGroup SEPARATOR ","» «attribute.reactTagName»«ENDFOR»} from "«folderPrefix»../../gen/components/ReactHelper";
		
		export function uiElement(attributes) {
			«FOR attribute: attributeGroup»
				if (attributes.is«attribute.name.toFirstUpper» === true) {
					return «attribute.reactTagName»(attributes);
				}
			«ENDFOR»
			return null;
		}
		
		«sdg»
		
	'''
	
	def generateReactHelper(HttpClient httpClient) '''
		«copyright»

		import React from 'react';
		«FOR attribute: httpClient.container.attributes»
			«attribute.componentImports("/" + httpClient.container.name.toFirstLower)»
		«ENDFOR»

		const normalize = (options) => {
		    if (options && options.class !== undefined) {
		        options.className = options.class
		        delete options.class;
		    }
		    if (options && options.id) {
		    	options.key = options.id;
		    }
		    return options;
		}
		
		export const generic = (type, options, children) => {
		    return React.createElement(
		        type,
		        normalize(options),
		        children ? [...children] : undefined
		    )
		}
		
		export const br = () => {
		    return generic("br");
		}
		
		export const hr = () => {
		    return generic("hr");
		}
		
		export const p = (options, children) => {
		    return generic("p", options, children);
		}
		
		export const ul = (options, children) => {
		    return generic("ul", options, children);
		}
		
		export const ol = (options, children) => {
		    return generic("ol", options, children);
		}
		
		export const li = (options, children) => {
		    return generic("li", options, children);
		}
		
		export const label = (options, children) => {
		    return generic("label", options, children);
		}
		
		export const button = (options, children) => {
		    return generic("button", options, children);
		}
		
		export const div = (options, children) => {
		    return generic("div", options, children);
		}
		
		export const span = (options, children) => {
		    return generic("span", options, children);
		}
		
		export const a = (options, children) => {
		    return generic("a", options, children);
		}
		
		export const h1 = (options, children) => {
		    return generic("h1", options, children);
		}
		
		export const h2 = (options, children) => {
		    return generic("h2", options, children);
		}
		
		export const h3 = (options, children) => {
		    return generic("h3", options, children);
		}
		
		export const h4 = (options, children) => {
		    return generic("h4", options, children);
		}
		
		export const h5 = (options, children) => {
		    return generic("h5", options, children);
		}
		
		export const h6 = (options, children) => {
		    return generic("h6", options, children);
		}
		
		export const pre = (options, children) => {
		    return generic("pre", options, children);
		}
		
		export const table = (options, children) => {
		    return generic("table", options, children);
		}
		
		export const tbody = (options, children) => {
		    return generic("tbody", options, children);
		}
		
		export const thead = (options, children) => {
		    return generic("thead", options, children);
		}
		
		export const tr = (options, children) => {
		    return generic("tr", options, children);
		}
		
		export const td = (options, children) => {
		    return generic("td", options, children);
		}
		
		export const th = (options, children) => {
		    return generic("th", options, children);
		}
		
		export const i = (options, children) => {
		    return generic("i", options, children);
		}
		
		export const select = (options, children) => {
		    return generic("select", options, children);
		}
		
		export const option = (options, children) => {
		    return generic("option", options, children);
		}
		
		export const img = (options, children) => {
		    return generic("img", options, children);
		}
		
		export const textarea = (options) => {
		    return generic("textarea", options);
		}
		
		export const iframe = (options) => {
		    return generic("iframe", options);
		}
		
		export const input = (options) => {
		    return <input {...normalize(options)}/>
		}
		
		
		«FOR attribute: httpClient.container.attributes»
			«attribute.components(false)»
		«ENDFOR»

		«sdg»
		
	'''
	
	def dispatch CharSequence componentImports(SingleClientAttribute it, String subFolder) '''
		«IF attributes.size > 0 && !noComponent»
			import { «reactComponentName» } from ".«subFolder»/«reactComponentName»";
			«FOR attribute: attributes»
				«componentImports(attribute, '''«subFolder»/«name.toFirstLower»''')»
			«ENDFOR»
		«ENDIF»
	''' 
	
	def dispatch CharSequence componentImports(GroupedClientAttribute it, String subFolder) '''
		import { «reactComponentName» } from ".«subFolder»/«reactComponentName»";
		«IF attributeGroup.size > 0»
			«FOR attribute: attributeGroup»
				«componentImports(attribute, '''«subFolder»/«name.toFirstLower»''')»
			«ENDFOR»
		«ENDIF»
	'''
	
	def dispatch CharSequence components(SingleClientAttribute it, boolean isGroupedChild) '''
		«IF attributes.size > 0 || isGroupedChild»
			export const «reactTagName» = (options) => {
			    return <«reactComponentName» {...normalize(options)}/>
			}
			«FOR attribute: attributes»
				«components(attribute, false)»
			«ENDFOR»
		«ENDIF»
	''' 
	
	def dispatch CharSequence components(GroupedClientAttribute it, boolean isGroupedChild) '''
		export const «reactTagName» = (options) => {
		    return <«reactComponentName» {...normalize(options)}/>
		}
		«IF attributeGroup.size > 0»
			«FOR attribute: attributeGroup»
				«components(attribute, true)»
			«ENDFOR»
		«ENDIF»
	'''
	
	
	
}