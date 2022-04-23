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

package com.newbieandy.model;

import java.util.List;

/**
 * @author andy
 * @description JavaImportInfo
 * @date 2022/4/22 23:24
 */
public class JavaImportInfo {
    /**
     * 外部导入依赖
     */
    private List<String> extImportList;

    /**
     * 内部导入依赖
     */
    private List<String> jreImportList;

    public List<String> getExtImportList() {
        return extImportList;
    }

    public void setExtImportList(List<String> extImportList) {
        this.extImportList = extImportList;
    }

    public List<String> getJreImportList() {
        return jreImportList;
    }

    public void setJreImportList(List<String> jreImportList) {
        this.jreImportList = jreImportList;
    }
}
