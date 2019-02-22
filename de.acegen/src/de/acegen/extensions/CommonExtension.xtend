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
 

package de.acegen.extensions

import de.acegen.aceGen.Attribute
import de.acegen.aceGen.Model
import java.util.List

class CommonExtension {

	def String copyright() '''
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



	'''
	
	def String sdg() '''
	
	
	/******* S.D.G. *******/
	
	
	'''
	
	def void allAttributesRec(Model it, List<Attribute> attrs) {
		for (attribute : attributes) {
			if (!attrs.containsAttribute(attribute)) {
				attrs.add(attribute)
			}
		}
		for(superModel : superModels) {
			superModel.allAttributesRec(attrs);
		}
	}
	
	def boolean containsAttribute(List<Attribute> it, Attribute attribute) {
		if (size == 0) {
			return false
		} else {
			for (attr : it) {
				if (attr.name.equals(attribute.name)) {
					return true
				}
			}
		}
		return false;
	}
	
	
}

	
	
/******* S.D.G. *******/
	
	
