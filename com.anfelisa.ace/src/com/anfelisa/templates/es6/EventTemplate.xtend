package com.anfelisa.templates.es6

import com.anfelisa.ace.ES6
import com.anfelisa.ace.ES6_ACE
import com.anfelisa.ace.ES6_Outcome
import com.anfelisa.extensions.es6.AceExtension
import com.anfelisa.extensions.es6.Es6Extension
import javax.inject.Inject

class EventTemplate {
	
	@Inject
	extension AceExtension

	@Inject
	extension Es6Extension
	
	def generateAbstractEventFile(ES6_ACE it, ES6_Outcome outcome, ES6 es6) '''
		import Event from "../../../gen/ace/Event";
		
		export default class «eventName(outcome)» extends Event {
		    constructor(eventData) {
		        super(eventData, '«es6.name».«eventName(outcome)»');
		    }
		}
		
		
		/*       S.D.G.       */
	'''
	def generateEventListenerRegistration(ES6 it) '''
		import ACEController from "../ace/ACEController";
		import * as AppState from "../ace/AppState";
		
		export default class EventListenerRegistration«projectName» {
		
			static init() {
				«FOR aceOperation : aceOperations»
					«FOR outcome : aceOperation.outcomes»
						«FOR listener : outcome.listeners»
							ACEController.registerListener('«name».«aceOperation.eventName(outcome)»', «listener.appStateFunction()»);
						«ENDFOR»
					«ENDFOR»
				«ENDFOR»
			}
		
		}
		
		/*       S.D.G.       */
	'''

	def generateEvent() '''
		import AppUtils from "../../src/app/AppUtils";
		import ACEController from "./ACEController";
		
		export default class Event {
		    constructor(eventData, eventName) {
		        this.eventName = eventName;
		        this.eventData = AppUtils.deepCopy(eventData);
		    }
		
		    publish() {
		        this.notifyListeners();
				ACEController.addItemToTimeLine({event: this});
		    }
		
		    notifyListeners() {
		        let i, listener;
		        if (this.eventName !== undefined) {
		            const listenersForEvent = ACEController.listeners[this.eventName];
		            if (listenersForEvent !== undefined) {
		                for (i = 0; i < listenersForEvent.length; i += 1) {
		                    listener = listenersForEvent[i];
							listener(AppUtils.deepCopy(this.eventData));
		                }
		            }
		        }
		    }
		
		}
		
		/*       S.D.G.       */
		
		
	'''
	
}