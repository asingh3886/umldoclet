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

package plantuml.doclet.model.javadoc;

import com.sun.javadoc.RootDoc;
import plantuml.doclet.model.Model;
import plantuml.doclet.model.Package;
import plantuml.doclet.model.Type;

import java.util.Collection;

import static java.util.Collections.emptySet;

/**
 * Implementation of the {@link Model} based on the current JavaDoc API.
 *
 * @author Gerald Boersma
 * @author Sjoerd Talsma
 */
public class JavaDocModel implements Model {

    public JavaDocModel(RootDoc root) {

    }

    @Override
    public Collection<Package> getPackages() {
        return emptySet();
    }

    @Override
    public Package findPackage(String qualifiedName) {
        return null;
    }

    @Override
    public Collection<Type> getTypes() {
        return emptySet();
    }

    @Override
    public Type findType(String qualifiedName) {
        return null;
    }

}
