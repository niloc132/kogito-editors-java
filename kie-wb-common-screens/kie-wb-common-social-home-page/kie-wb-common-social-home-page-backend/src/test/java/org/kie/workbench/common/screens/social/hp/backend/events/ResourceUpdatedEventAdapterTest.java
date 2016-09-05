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

package org.kie.workbench.common.screens.social.hp.backend.events;

import java.util.HashMap;
import java.util.Map;

import org.jboss.errai.security.shared.api.identity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.uberfire.social.activities.service.SocialUserRepositoryAPI;
import org.kie.workbench.common.screens.social.hp.config.SocialConfigurationService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

@RunWith( MockitoJUnitRunner.class )
public class ResourceUpdatedEventAdapterTest {

    @Mock
    private User loggedUser;

    @Mock
    private SocialUserRepositoryAPI socialUserRepositoryAPI;

    @Mock
    private SocialConfigurationService socialConfigurationService;

    @InjectMocks
    private ResourceUpdatedEventAdapter resourceUpdatedEventAdapter;

    @Test
    public void getDefinedCreatedMessage() {
        Map<String, String> messagesByKey = new HashMap<>();
        messagesByKey.put( "added", "message-added" );
        messagesByKey.put( "created", "message-created" );
        messagesByKey.put( "edited", "message-edited" );

        doReturn( messagesByKey ).when( socialConfigurationService ).getSocialMessages();

        final String message = resourceUpdatedEventAdapter.getEditedMessage();

        assertEquals( "message-edited", message );
    }
}
