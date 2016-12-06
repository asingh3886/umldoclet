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
 */
package plantuml;

import com.sun.javadoc.DocErrorReporter;
import com.sun.javadoc.LanguageVersion;
import com.sun.tools.doclets.standard.Standard;
import plantuml.doclet.options.Options;

import static plantuml.doclet.options.Options.isSupported;

/**
 * @author Sjoerd Talsma
 * @author Gerald Boersma
 */
public class Doclet extends Standard {

    /**
     * Let's assume we support the java version the standard Doclet is made for!
     *
     * @return The same language version the Standard doclet also supports.
     */
    public static LanguageVersion languageVersion() {
        return Standard.languageVersion();
    }

    /**
     * Determines the option length for the requested option name if it is supported by this doclet,
     * otherwise the option length from the standard doclet is returned.
     *
     * @param optionName The name of the option to determine the length for.
     * @return The length of the option (normally length is 2, one for the name and one for the value),
     * or zero (<code>0</code>) for unsupported options/.
     */
    public static int optionLength(String optionName) {
        return isSupported(optionName) ? Options.optionLength(optionName) : Standard.optionLength(optionName);
    }

    public static boolean validOptions(String[][] options, DocErrorReporter reporter) {
        // Parse our own options, but hold back on the reporter for now.
        final Options parsed = new Options(options);
        // Let the standard doclet validate its own options, report the errors and remember the result.
        final boolean standardResult = Standard.validOptions(parsed.unsupportedOptions, reporter);
        // Now report our validation messages and return the combined result.
        parsed.validationMessages.forEach(reporter::printError);
        return standardResult && parsed.validationMessages.isEmpty();
    }


}
