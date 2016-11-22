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

package plantuml.doclet.io;

import java.io.File;
import java.net.URI;

/**
 * Interface that allows a name of a plantuml file to be resolved to a file or a link, according to the
 * user-specified doclet options.
 * <p>
 * Implementations should take care to be consistent between the {@link #resolveFilename(String, String, String) File}
 * and {@link #resolveLink(String, String, String) URI} methods so generated links to generated PlantUML files are
 * not rendered as 'dead' links.
 *
 * @author Sjoerd Talsma
 */
public interface NameResolver {

    /**
     * Resolves the given filename to an appropriate File reference.
     * <p>
     * The resolver may have various strategies determining where certain files go, like .puml files go with the rest
     * of the javadoc, but the .png files go into a central 'images' directory, oh by the way; in that last case, the
     * file must also contain the full package denotation to avoid name clashes.
     * <p>
     * Since this concern is non-trivial the name resolver interface was created.
     *
     * @param packagename The qualified name of the package containing the resource
     *                    (example: <code>"plantuml.doclet.io"</code>).
     * @param basename    The basename of the resource or specify <code>"package"</code> for a package diagram
     *                    (example: <code>"NameResolver"</code> or <code>"package"</code>)
     * @param extension   The file extension for the resource
     *                    (examples: <code>"puml"</code>, <code>"svg"</code>, <code>"png"</code>, etc).
     * @return The actual File reference where the given filename should actually end up.
     */
    File resolveFilename(String packagename, String basename, String extension);

    URI resolveLink(String packagename, String basename, String extension);

}
