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

package info.leadinglight.umljavadoclet.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Lookup of relationships.
 *
 * @author Gerald Boersma
 */
public class RelFilter {
    public RelFilter() {
        _rels = new ArrayList<>();
    }

    public RelFilter(List<ModelRel> rels) {
        _rels = rels;
    }

    public boolean isEmpty() {
        return _rels.isEmpty();
    }

    public List<ModelRel> all() {
        return _rels;
    }

    public ModelRel first() {
        return _rels.size() > 0 ? _rels.get(0) : null;
    }

    public List<ModelClass> sourceClasses() {
        List<ModelClass> classes = new ArrayList<>();
        for (ModelRel rel : _rels) {
            classes.add(rel.source());
        }
        return classes;
    }

    public List<ModelClass> destinationClasses() {
        List<ModelClass> classes = new ArrayList<>();
        for (ModelRel rel : _rels) {
            classes.add(rel.destination());
        }
        return classes;
    }

    public void add(ModelRel rel) {
        _rels.add(rel);
    }

    public RelFilter source(ModelClass source) {
        RelFilter filter = new RelFilter();
        for (ModelRel rel : _rels) {
            if (rel.source() == source) {
                filter.add(rel);
            }
        }
        return filter;
    }

    public RelFilter destination(ModelClass dest) {
        RelFilter filter = new RelFilter();
        for (ModelRel rel : _rels) {
            if (rel.destination() == dest) {
                filter.add(rel);
            }
        }
        return filter;
    }

    public RelFilter kind(ModelRel.Kind kind) {
        RelFilter filter = new RelFilter();
        for (ModelRel rel : _rels) {
            if (rel.kind() == kind) {
                filter.add(rel);
            }
        }
        return filter;
    }

    public RelFilter between(ModelClass source, ModelClass dest) {
        return source(source).destination(dest);
    }

    private final List<ModelRel> _rels;
}
