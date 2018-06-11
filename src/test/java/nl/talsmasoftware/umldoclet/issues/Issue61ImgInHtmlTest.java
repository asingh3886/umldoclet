/*
 * Copyright 2016-2018 Talsma ICT
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
package nl.talsmasoftware.umldoclet.issues;

import nl.talsmasoftware.umldoclet.UMLDoclet;
import nl.talsmasoftware.umldoclet.testing.Testing;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.util.spi.ToolProvider;

/**
 * Test for automatic inclusion of UML diagrams in the generated documentation.
 * <p>
 * This tests inclusion of UML diagrams such as the {@classdiagram} into the generated HTML code.
 *
 * @author Sjoerd Talsma
 * @packagediagram nl.talsmasoftware.umldoclet.rendering.indent
 */
public class Issue61ImgInHtmlTest {

    private static final String packageAsPath = Issue61ImgInHtmlTest.class.getPackageName().replace('.', '/');
    private static final File outputdir = new File("target/test-61");
    private static String classHtml;

    @BeforeClass
    public static void setup() {
        String classAsPath = packageAsPath + '/' + Issue61ImgInHtmlTest.class.getSimpleName();
        ToolProvider.findFirst("javadoc").get().run(
                System.out, System.err,
                "-d", outputdir.getPath(),
                "-doclet", UMLDoclet.class.getName(),
                "src/test/java/" + classAsPath + ".java"
        );
        classHtml = Testing.read(new File(outputdir, classAsPath + ".html"));
    }

    @Test
    public void testClassdiagram() {

    }

}
