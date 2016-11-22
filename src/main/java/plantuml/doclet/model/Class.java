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

package plantuml.doclet.model;

import java.util.Collection;

/**
 * Represents a class internal or external to the model.
 *
 * @author Gerald Boersma
 * @author Sjoerd Talsma
 */
public interface Class extends Type {

    /**
     * @return The superclass of this class.
     */
    Class getSuperclass();

    /**
     * @return The constructors of this class.
     */
    Collection<Constructor> getConstructors();

}
