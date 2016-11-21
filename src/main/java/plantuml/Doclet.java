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

package plantuml;

import com.sun.javadoc.DocErrorReporter;
import com.sun.javadoc.LanguageVersion;
import com.sun.tools.doclets.standard.Standard;
import plantuml.doclet.config.Options;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Combined doclet for generating JavaDoc documentation based on the {@link Standard} doclet,
 * combined with generated UML diagrams.
 *
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
     * First see if this option is intended for us, otherwise we'll let the standard doclet determine its length.
     *
     * @param optionName The option to return the expected array length for.
     * @return The number of strings that compose this option.
     */
    public static int optionLength(String optionName) {
        return Options.isValidOption(optionName) ? Options.OPTION_LENGTH : Standard.optionLength(optionName);
    }

    public static boolean validOptions(final String[][] options, DocErrorReporter reporter) {
        // First check whether our own options are valid, delegating all other options to the Standard doclet.
        final Collection<String[]> standardOptions = new ArrayList<>();
        boolean allValid = true;
        for (String[] option : options) {
            if (option.length > 0 && Options.isValidOption(option[0])) {
                allValid &= Options.validate(reporter, option);
            } else {
                standardOptions.add(option);
            }
        }
        return validateStandardOptions(standardOptions, reporter) && allValid;
    }

    private static boolean validateStandardOptions(Collection<String[]> standardOpts, DocErrorReporter reporter) {
        return Standard.validOptions(standardOpts.toArray(new String[standardOpts.size()][]), reporter);
    }

}
