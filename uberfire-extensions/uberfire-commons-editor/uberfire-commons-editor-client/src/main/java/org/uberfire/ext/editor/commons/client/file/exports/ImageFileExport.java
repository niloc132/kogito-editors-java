/*
 * Copyright 2017 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.uberfire.ext.editor.commons.client.file.exports;

import java.util.Optional;
import java.util.function.BiConsumer;

import org.gwtproject.typedarrays.client.ArrayBufferNative;
import org.gwtproject.typedarrays.client.Uint8ArrayNative;
import org.gwtproject.typedarrays.shared.ArrayBuffer;
import org.gwtproject.typedarrays.shared.Uint8Array;
import elemental2.dom.Blob;
import elemental2.dom.BlobPropertyBag;
import elemental2.dom.DomGlobal;

public class ImageFileExport extends AbstractFileExport<ImageDataUriContent> {

    public ImageFileExport() {
    }

    ImageFileExport(final BiConsumer<Blob, String> saveAs) {
        super(saveAs);
    }

    @Override
    protected Optional<Blob> getContent(final ImageDataUriContent entity) {
        final Blob blob = dataImageAsBlob(entity.getData(),
                                          entity.getMimeType());
        return Optional.of(blob);
    }

    /**
     * Creates a Blob instance for the raw image data-uri value.
     * @param data The image uri data.
     * @param mimeType The media type for the generated blob.
     */
    public static Blob dataImageAsBlob(final String data,
                                       final String mimeType) {
        final String byteString = DomGlobal.atob(data);
        final ArrayBuffer buffer = ArrayBufferNative.create(byteString.length());
        final Uint8Array ia = Uint8ArrayNative.create(buffer);
        for (int i = 0; i < byteString.length(); i++) {
            ia.set(i,
                   byteString.charAt(i));
        }

        BlobPropertyBag blobPropertyBag = BlobPropertyBag.create();
        blobPropertyBag.setType(mimeType);

        return new Blob(new Blob.ConstructorBlobPartsArrayUnionType[]{Blob.ConstructorBlobPartsArrayUnionType.of(new Object[]{ia})}, blobPropertyBag);
    }
}
