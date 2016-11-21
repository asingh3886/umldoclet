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

package nl.talsmasoftware.umldoclet.rendering;

import com.sun.javadoc.DocErrorReporter;
import nl.talsmasoftware.umldoclet.config.UMLDocletConfig;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasToString;
import static org.mockito.Mockito.mock;

/**
 * @author Sjoerd Talsma
 */
public class NoteRendererTest {

    @Test
    public void testIndentation() {
        UMLDocletConfig emptyConfig = new UMLDocletConfig(new String[0][], mock(DocErrorReporter.class));
        NoteRenderer note = new NoteRenderer(new DiagramRenderer(emptyConfig), "Note content!");
        assertThat(note, hasToString(equalTo(
                "note\n" +
                        "    Note content!\n" +
                        "end note\n\n"
        )));
    }

}
