/**
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 * 
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */
package de.acegen.generator;

import de.acegen.aceGen.HttpClient;
import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.Project;
import de.acegen.generator.Es6Generator;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGenerator2;
import org.eclipse.xtext.generator.IGeneratorContext;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
@SuppressWarnings("all")
public class AceGenGenerator extends AbstractGenerator {
  @Inject
  private Es6Generator es6Generator;
  
  private static Map<String, IGenerator2> generators = new HashMap<String, IGenerator2>();
  
  public static void register(final String language, final IGenerator2 generator2) {
    AceGenGenerator.generators.put(language, generator2);
  }
  
  public static void unregister(final String language) {
    AceGenGenerator.generators.remove(language);
  }
  
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    if ((((resource != null) && (resource.getContents() != null)) && (resource.getContents().size() > 0))) {
      EObject _get = resource.getContents().get(0);
      final Project project = ((Project) _get);
      HttpClient _httpClient = project.getHttpClient();
      boolean _tripleNotEquals = (_httpClient != null);
      if (_tripleNotEquals) {
        this.es6Generator.doGenerate(project.getHttpClient(), fsa);
      } else {
        HttpServer _httpServer = project.getHttpServer();
        boolean _tripleNotEquals_1 = (_httpServer != null);
        if (_tripleNotEquals_1) {
          final IGenerator2 javaGenerator = AceGenGenerator.generators.get("JAVA");
          if ((javaGenerator != null)) {
            javaGenerator.doGenerate(resource, fsa, context);
          } else {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("not suitable generator found for JAVA");
            throw new RuntimeException(_builder.toString());
          }
        }
      }
    }
  }
}
