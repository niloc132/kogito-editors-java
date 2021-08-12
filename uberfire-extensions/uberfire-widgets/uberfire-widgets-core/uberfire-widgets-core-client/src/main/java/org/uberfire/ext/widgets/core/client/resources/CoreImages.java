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

import org.gwtproject.resources.client.ClientBundle;
import org.gwtproject.resources.client.ImageResource;

public interface CoreImages
        extends
        ClientBundle {

    CoreImages INSTANCE = null;

    @Source("images/open_folder.gif")
    ImageResource openedFolder();

    @Source("images/package.gif")
    ImageResource packageIcon();

    @Source("images/file.gif")
    ImageResource file();

    @Source("images/backup_large.png")
    ImageResource backupLarge();

    //A warning triangle
    @Source("images/warning-large.png")
    ImageResource warningLarge();

    @Source("images/tick.png")
    ImageResource tick();

    @Source("images/BPM_FileIcons_text.png")
    ImageResource typeTextFile();
}
