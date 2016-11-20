/*
 * Copyright (C) 2016 Talsma ICT
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package info.leadinglight.umljavadoclet.printer;

import info.leadinglight.umljavadoclet.model.Model;
import info.leadinglight.umljavadoclet.model.ModelClass;
import info.leadinglight.umljavadoclet.model.ModelRel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gerald Boersma
 */
public class ContextDiagramPrinter extends PumlDiagramPrinter {
    public ContextDiagramPrinter(Model model, ModelClass contextClass, DiagramOptions options) {
        super(model, options);
        _contextClass = contextClass;
    }

    public void generate() {
        start();
        noPackagesOption();
        addContextClass(_contextClass);
        for (ModelRel rel : _contextClass.relationships()) {
            addRelationship(rel);
            newline();
        }
        end();
    }

    // Highlight the class with a different colour.
    private void addContextClass(ModelClass modelClass) {
        // TODO Show in different color.
        String filepath = classFilepath(modelClass, modelClass);
        classDefinition(modelClass, true, filepath, null, true, true, true, false, true);
        _classes.add(modelClass);
    }

    // Put the class on the other side of the relationship on the diagram.
    private void addRelationship(ModelRel rel) {
        ModelClass otherClass = (rel.source() != _contextClass ? rel.source() : rel.destination());
        if (!otherClass.fullName().startsWith("java.util.")) {
            if (isRelationshipVisible(rel)) {
                // Only draw the class on the other side of the relationship if it hasn't been added yet.
                if (!_classes.contains(otherClass)) {
                    String filepath = null;
                    if (otherClass.modelPackage() != null) {
                        filepath = classFilepath(_contextClass, otherClass);
                    }
                    if (otherClass.modelPackage() == _contextClass.modelPackage()) {
                        classDefinitionNoDetail(otherClass, true, filepath, null);
                    } else if (otherClass.isInternal()) {
                        classDefinitionNoDetail(otherClass, true, filepath, "white");
                    } else {
                        classDefinitionNoDetail(otherClass, true, filepath, "lightgrey");
                    }
                    _classes.add(otherClass);
                }

                // Draw the relationship with the other class.
                relationship(rel);
            }
        }
    }

    private final ModelClass _contextClass;
    private final List<ModelClass> _classes = new ArrayList<>();
}
