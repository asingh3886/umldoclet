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

package plantuml.doclet.config;

import com.sun.javadoc.DocErrorReporter;

/**
 * @author Sjoerd Talsma
 * @author Gerald Boersma
 */
public class Options {

    public static final int OPTION_LENGTH = 2;

    public static boolean isValidOption(String name) {
        return name.equals("blaaaaaaa");
    }

    public static boolean validate(DocErrorReporter reporter, String... option) {
        return reporter != null && option.length == OPTION_LENGTH && isValidOption(option[0]);
    }

}
