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
import info.leadinglight.umljavadoclet.model.ModelPackage;

/**
 * Diagram showing all packages and all classes.
 * No relationships.
 */
public class OverviewDiagramPrinter extends PumlDiagramPrinter {
    public OverviewDiagramPrinter(Model model, DiagramOptions options) {
        super(model, options);
    }

    public void generate() {
        start();
        // The layout for packages is really bad.
        // Just show the classes within all of the packages in the model.
        for (ModelPackage modelPackage : getModel().rootPackages()) {
            packageDefinition(modelPackage, packageFilepath(modelPackage), null);
            for (ModelClass modelClass : modelPackage.classes()) {
                String filepath = null;
                if (modelClass.modelPackage() != null) {
                    filepath = classFilepath(modelClass);
                }
                classDefinitionNoDetail(modelClass, false, filepath, null);
            }
        }
        end();
    }
}
