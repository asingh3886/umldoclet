/*
 * Copyright (C) 2016 Talsma ICT
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package plantuml.doclet.rendering;

import plantuml.doclet.io.IndentingPrintWriter;
import plantuml.doclet.model.Model;
import plantuml.doclet.model.Package;
import plantuml.doclet.options.Options;

/**
 * @author Sjoerd Talsma
 */
public class PackageDiagramRenderer extends ModelRenderer {

    protected final Package pkg;

    public PackageDiagramRenderer(Model model, Options options, String qualifiedPackageName) {
        super(model, options);
        this.pkg = model.findPackage(qualifiedPackageName);
        if (pkg == null) throw new IllegalArgumentException(
                String.format("Package was not encountered in the model: \"%s\".", qualifiedPackageName));
    }

    @Override
    public IndentingPrintWriter renderTo(IndentingPrintWriter writer) {
        // TODO obviously
        return writer;
    }

}
