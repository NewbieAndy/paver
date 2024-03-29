/*
 * Copyright (C) 2022 Andy Ma.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.newbieandy.model.file;

/**
 * @author andy
 * @description AbstractFileModel
 * @date 2022/9/18 13:27
 */
public abstract class AbstractFileModel implements FileModel {
    private final String content;
    private final String fileName;

    protected AbstractFileModel(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
    }

    @Override
    public String getContent() {
        return this.content;
    }
}
