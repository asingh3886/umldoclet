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

package plantuml.doclet.model;

import java.util.Collection;
import java.util.Optional;

/**
 * Definition for a model type. This can normally be one of:
 * <ol>
 * <li>{@link Interface}</li>
 * <li>{@link Class}</li>
 * <li>{@link Enumeration}</li>
 * </ol>
 *
 * @author Gerald Boersma
 * @author Sjoerd Talsma
 */
public interface Type {

    Visibility getVisibility();

    String getQualifiedName();

    String getSimpleName();

    /**
     * @return The package containing this type, or the root package if defined at root level.
     */
    Package getPackage();

    /**
     * @return The interfaces implemented by this type (or extended in case of an interface itself).
     */
    Collection<Interface> getInterfaces();

    /**
     * @return The containing type for inner classes, interfaces or enumerations.
     * Returns <code>null</code> for types that are not 'inner' types.
     */
    Optional<Type> getContainingType();

    Collection<Field> getFields();

    Collection<Method> getMethods();

}
