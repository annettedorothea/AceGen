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


package de.acegen.generator

import de.acegen.aceGen.Project
import java.util.HashMap
import java.util.Map
import javax.inject.Inject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGenerator2
import org.eclipse.xtext.generator.IGeneratorContext

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class AceGenGenerator extends AbstractGenerator {

	@Inject
	Es6Generator es6Generator;

	static Map<String, IGenerator2> generators = new HashMap;

	static def void register(String language, IGenerator2 generator2) {
		generators.put(language, generator2);
	}

	static def void unregister(String language) {
		generators.remove(language);
	}

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		if (resource !== null && resource.contents !== null && resource.contents.size > 0) {
			val project = resource.contents.get(0) as Project

			if (project.httpClient !== null) {
				es6Generator.doGenerate(project.httpClient, fsa);
			} else if (project.httpServer !== null) {
				val javaGenerator = generators.get("JAVA")
				if (javaGenerator !== null) {
					javaGenerator.doGenerate(resource, fsa, context);
				} else {
					throw new RuntimeException('''not suitable generator found for JAVA''');
				}
			}

		}

	}
}
/******* S.D.G. *******/
