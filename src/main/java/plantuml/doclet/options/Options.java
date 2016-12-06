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

package plantuml.doclet.options;

import plantuml.doclet.io.NameResolver;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;

import static java.util.Collections.*;

/**
 * Central class for doclet options.
 *
 * @author Gerald Boersma
 * @author Sjoerd Talsma
 */
public class Options {

    public final NameResolver nameresolver = new ConfiguredNameResolver();
    public final Collection<String> validationMessages;
    public final String[][] unsupportedOptions;



    public Options(String[][] options) {
        final ArrayList<String> messages = new ArrayList<>();
        final ArrayList<String[]> unsupported = new ArrayList<>();

        if (options != null) for (String[] option : options) {
        }

        // Keep messages as immutable collection.
        messages.trimToSize();
        this.validationMessages = messages.isEmpty() ? emptySet()
                : messages.size() == 1 ? singleton(messages.get(0))
                : unmodifiableCollection(messages);
        // Copy all unsupported options into its own array to be passed on to the standard Doclet.
        this.unsupportedOptions = unsupported.toArray(new String[unsupported.size()][]);
    }

    /**
     * An option is considered supported by this doclet if has a recognized option length greater than zero.
     *
     * @param optionName The name of the option to check for.
     * @return <code>true</code> if the option is supported by this doclet, otherwise <code>false</code> in which case
     * it probably is meant for the Standard doclet instead.
     */
    public static boolean isSupported(String optionName) {
        return optionLength(optionName) > 0;
    }

    public static int optionLength(String optionName) {
        return 0;
    }

    private final class ConfiguredNameResolver implements NameResolver {

        @Override
        public File resolveFilename(String packagename, String basename, String extension) {
            return null;
        }

        @Override
        public URI resolveLink(String packagename, String basename, String extension) {
            return null;
        }
    }

}
