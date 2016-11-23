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

import plantuml.doclet.model.Model;
import plantuml.doclet.options.Options;

import static java.util.Objects.requireNonNull;

/**
 * Abstract base definition for any 'renderer' implementation that can write the model to a particular output.
 * <p>
 * Each specific ModelRenderer implementation 'knows' how to render a particular UML diagram type.
 *
 * @author Sjoerd Talsma
 */
public abstract class ModelRenderer implements Renderer {

    /**
     * The UML model being rendered (guaranteed, non-<code>null</code>).
     */
    protected final Model model;

    /**
     * The options to take into account when rendering the diagram (guaranteed, non-<code>null</code>).
     */
    protected final Options options;

    protected ModelRenderer(Model model, Options options) {
        this.model = requireNonNull(model, "Model was <null>.");
        this.options = requireNonNull(options, "Options were <null>.");
    }

}
