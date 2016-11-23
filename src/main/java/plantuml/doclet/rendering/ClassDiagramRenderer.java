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
import plantuml.doclet.model.Type;
import plantuml.doclet.options.Options;

/**
 * This class is a dedicated renderer for a separate class diagram for a single type.
 *
 * @author Sjoerd Talsma
 */
public class ClassDiagramRenderer extends ModelRenderer {

    protected final Type type;

    public ClassDiagramRenderer(Model model, Options options, String qualifiedClassName) {
        super(model, options);
        this.type = model.findType(qualifiedClassName);
        if (type == null) throw new IllegalArgumentException(
                String.format("Type was not encountered in the model: \"%s\".", qualifiedClassName));
    }

    @Override
    public IndentingPrintWriter renderTo(IndentingPrintWriter writer) {
        // TODO obviously
        return writer;
    }

}
