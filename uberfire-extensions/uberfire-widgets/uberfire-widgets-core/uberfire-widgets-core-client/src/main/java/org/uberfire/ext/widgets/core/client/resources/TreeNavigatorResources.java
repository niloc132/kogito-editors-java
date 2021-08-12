/*
 * Copyright 2015 JBoss, by Red Hat, Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.uberfire.ext.widgets.core.client.resources;

import org.gwtproject.core.client.GWT;
import org.gwtproject.resources.client.ClientBundle;
import org.gwtproject.resources.client.CssResource;

/**
 * Wizard resources
 */
public interface TreeNavigatorResources
        extends
        ClientBundle {

    public static final TreeNavigatorResources INSTANCE = null;

    @Source("css/TreeNavigator.css")
    NavigatorStyle css();

    public interface NavigatorStyle extends CssResource {

        @ClassName("tree")
        String tree();

        @ClassName("tree-folder")
        String treeFolder();

        @ClassName("tree-folder-header")
        String treeFolderHeader();

        @ClassName("tree-folder-name")
        String treeFolderName();

        @ClassName("tree-folder-content")
        String treeFolderContent();

        @ClassName("tree-item")
        String treeItem();

        @ClassName("tree-item-name")
        String treeItemName();

        @ClassName("tree-selected")
        String treeSelected();
    }
}