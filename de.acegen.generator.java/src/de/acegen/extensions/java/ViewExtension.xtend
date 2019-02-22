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
 

package de.acegen.extensions.java

import de.acegen.aceGen.HttpServer
import de.acegen.aceGen.HttpServerView
import de.acegen.aceGen.HttpServerViewFunction

class ViewExtension {
	def String viewName(HttpServerView it) '''«getName.toFirstUpper»View'''
	def String viewInterfaceName(HttpServerView it) '''I«getName.toFirstUpper»View'''
	def String viewNameWithPackage(HttpServerView it) '''«(eContainer as HttpServer).getName».views.«viewName»'''
	def String viewNameAsVariable(HttpServerView it) '''«getName.toFirstLower»View'''
	def String viewFunctionWithViewName(HttpServerViewFunction it) '''«(it.eContainer as HttpServerView).viewName».«getName»'''
	def String viewFunctionWithViewNameAsVariable(HttpServerViewFunction it) '''«(it.eContainer as HttpServerView).viewNameAsVariable».«getName»'''
	def HttpServerView view(HttpServerViewFunction it) {
		return it.eContainer as HttpServerView;
	}
	
}
	
	
/******* S.D.G. *******/
	
	
