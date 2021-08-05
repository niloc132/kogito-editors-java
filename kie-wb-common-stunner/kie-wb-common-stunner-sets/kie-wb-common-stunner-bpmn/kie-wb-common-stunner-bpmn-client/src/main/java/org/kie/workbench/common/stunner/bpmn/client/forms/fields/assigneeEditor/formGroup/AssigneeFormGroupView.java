/*
 * Copyright 2018 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.workbench.common.stunner.bpmn.client.forms.fields.assigneeEditor.formGroup;

import org.gwtproject.user.client.ui.Widget;
import org.jboss.errai.common.client.api.IsElement;
import org.kie.workbench.common.forms.dynamic.client.rendering.formGroups.impl.ValidableFormGroupView;
import org.kie.workbench.common.forms.model.FieldDefinition;

public interface AssigneeFormGroupView extends ValidableFormGroupView,
                                               IsElement {

    void render(String inputId,
                Widget widget,
                FieldDefinition fieldDefinition);
}
