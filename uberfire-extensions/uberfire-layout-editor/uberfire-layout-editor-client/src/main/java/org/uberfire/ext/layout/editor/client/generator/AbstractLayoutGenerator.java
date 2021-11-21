/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates.
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
package org.uberfire.ext.layout.editor.client.generator;

import java.util.List;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;
import org.gwtproject.user.client.ui.IsWidget;
import org.jboss.errai.common.client.dom.DOMUtil;
import org.uberfire.ext.layout.editor.api.editor.LayoutColumn;
import org.uberfire.ext.layout.editor.api.editor.LayoutComponent;
import org.uberfire.ext.layout.editor.api.editor.LayoutInstance;
import org.uberfire.ext.layout.editor.api.editor.LayoutRow;
import org.uberfire.ext.layout.editor.api.editor.LayoutTemplate;
import org.uberfire.ext.layout.editor.client.infra.RowSizeBuilder;

public abstract class AbstractLayoutGenerator implements LayoutGenerator {

    public static final String CONTAINER_ID = "mainContainer";

    @Override
    public LayoutInstance build(LayoutTemplate layoutTemplate, LayoutGeneratorDriver driver) {
        HTMLElement container = driver.createContainer();
        container.id = (CONTAINER_ID);
        container.classList.add("uf-perspective-container");
        container.classList.add("uf-perspective-rendered-container");

        LayoutInstance layoutInstance = new LayoutInstance(container);
        List<LayoutRow> rows = layoutTemplate.getRows();
        generateRows(layoutTemplate, layoutInstance, driver, rows, container);
        return layoutInstance;
    }

    protected void generateRows(LayoutTemplate layoutTemplate,
                              LayoutInstance layoutInstance,
                              LayoutGeneratorDriver driver,
                              List<LayoutRow> rows,
                              HTMLElement parentWidget) {
        for (LayoutRow layoutRow : rows) {
            HTMLElement row = driver.createRow(layoutRow);

            if (layoutTemplate.isPageStyle()) {
                row.classList.add(RowSizeBuilder.buildRowSize(layoutRow.getHeight()));
                row.classList.add("uf-le-overflow");
            }
            for (LayoutColumn layoutColumn : layoutRow.getLayoutColumns()) {
                HTMLElement column = driver.createColumn(layoutColumn);

                if (layoutTemplate.isPageStyle() && layoutColumn.getHeight().isEmpty()) {
                    column.classList.add("uf-perspective-col");
                }
                if (columnHasNestedRows(layoutColumn)) {
                    if (layoutTemplate.isPageStyle() && layoutColumn.getHeight().isEmpty()) {
                        column.classList.add("uf-perspective-col");
                    } else if (!layoutColumn.getHeight().isEmpty()) {
                        column.classList.add("uf-perspective-row-" + layoutColumn.getHeight());
                    }
                    generateRows(layoutTemplate,
                                 layoutInstance,
                                 driver,
                                 layoutColumn.getRows(),
                                 column);
                } else {
                    generateComponents(layoutTemplate,
                                       layoutInstance,
                                       driver,
                                       layoutColumn,
                                       column);
                }
                column.classList.add("uf-perspective-rendered-col");
                row.appendChild(column);
            }
            row.classList.add("uf-perspective-rendered-row");
            parentWidget.appendChild(row);
        }
    }

    protected void generateComponents(LayoutTemplate layoutTemplate,
                                    final LayoutInstance layoutInstance,
                                    final LayoutGeneratorDriver driver,
                                    final LayoutColumn layoutColumn,
                                    final HTMLElement column) {

        DomGlobal.console.warn("generateComponents > " + layoutColumn.getLayoutComponents().size());


        for (final LayoutComponent layoutComponent : layoutColumn.getLayoutComponents()) {

            DomGlobal.console.warn("generateComponents >> " + layoutColumn);
            //DomGlobal.console.warn("generateComponents > " + layoutColumn + " " + layoutComponent.getDragTypeName());


            final IsWidget componentWidget = driver.createComponent(column, layoutComponent);
            if (componentWidget != null) {
                if (layoutTemplate.isPageStyle() && layoutColumn.getHeight().isEmpty()) {
                    componentWidget.asWidget().getElement().addClassName("uf-perspective-col");
                }
                else if (!layoutColumn.getHeight().isEmpty()) {
                    column.classList.add("uf-perspective-row-" + layoutColumn.getHeight());
                }

                column.id = "OLOLO_ZZZ";
                DOMUtil.appendWidgetToElement(column, componentWidget);
            }
        }
    }

    protected boolean columnHasNestedRows(LayoutColumn layoutColumn) {
        return layoutColumn.getRows() != null && !layoutColumn.getRows().isEmpty();
    }
}
