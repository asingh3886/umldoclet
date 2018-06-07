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
package nl.talsmasoftware.umltaglet;

import com.sun.source.doctree.DocTree;
import jdk.javadoc.doclet.Taglet;

import javax.lang.model.element.Element;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Sjoerd Talsma
 */
public class UMLTaglet implements Taglet  {

    @Override
    public String getName() {
        return "uml";
    }

    @Override
    public boolean isInlineTag() {
        return true;
    }

    @Override
    public Set<Location> getAllowedLocations() {
        return EnumSet.allOf(Location.class);
    }

    @Override
    public String toString(List<? extends DocTree> tags, Element element) {
        return "<b>Hello, documentation!</b>";
    }
}
