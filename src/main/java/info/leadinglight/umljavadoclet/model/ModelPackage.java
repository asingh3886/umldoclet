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

import com.sun.javadoc.PackageDoc;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a package containing classes.
 *
 * @author Gerald Boersma
 */
public class ModelPackage {
    public ModelPackage(Model model, PackageDoc packageDoc) {
        _model = model;
        _packageDoc = packageDoc;
    }

    public void map() {
        mapRelationships();
    }

    public String fullName() {
        return fullName(_packageDoc);
    }

    public String qualifiedName() {
        return fullName(_packageDoc);
    }

    public List<ModelClass> classes() {
        return _classes;
    }

    public List<ModelPackage> dependencies() {
        return _dependencyPackages;
    }

    public List<ModelPackage> dependents() {
        return _dependentPackages;
    }

    public static String fullName(PackageDoc packageDoc) {
        return packageDoc.name();
    }

    /**
     * Is this package an immediate child package of the specified package?
     *
     * @param parentPackage Package to check.
     * @return Whether or not it is a child package.
     */
    public boolean isChildPackage(ModelPackage parentPackage) {
        if (parentPackage != this) {
            if (qualifiedName().startsWith(parentPackage.qualifiedName())) {
                String thisPath = qualifiedName().substring(parentPackage.qualifiedName().length() + 1);
                // If the remaining part of the package name does not contain a period, it is an immediate child.
                return (!thisPath.contains("."));
            }
            return false;
        }
        return false;
    }

    public String parentPackageFullName() {
        return qualifiedName().substring(0, qualifiedName().lastIndexOf("."));
    }

    // Update model

    public void addClass(ModelClass modelClass) {
        if (!_classes.contains(modelClass)) {
            _classes.add(modelClass);
        }
    }

    // Mapping

    private void mapRelationships() {
        for (ModelClass modelClass : _classes) {
            for (ModelRel rel : modelClass.relationships()) {
                if (rel.source() == modelClass) {
                    ModelClass dest = rel.destination();
                    ModelPackage destPackage = dest.modelPackage();
                    // Only packages that are included in the model are modelled.
                    if (destPackage != null) {
                        if (destPackage != this && !_dependencyPackages.contains(destPackage)) {
                            _dependencyPackages.add(destPackage);
                        }
                    }
                } else {
                    ModelClass src = rel.source();
                    ModelPackage srcPackage = src.modelPackage();
                    // Only packages that are included in the model are modelled.
                    if (srcPackage != null) {
                        if (srcPackage != this && !_dependentPackages.contains(srcPackage)) {
                            _dependentPackages.add(srcPackage);
                        }
                    }
                }
            }
        }
    }

    private final Model _model;
    private final PackageDoc _packageDoc;
    private final List<ModelClass> _classes = new ArrayList<>();
    private final List<ModelPackage> _dependentPackages = new ArrayList<>();
    private final List<ModelPackage> _dependencyPackages = new ArrayList<>();
}
