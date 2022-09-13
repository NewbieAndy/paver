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

package com.newbieandy.core;

import com.newbieandy.model.JavaFile;

import java.io.Writer;

/**
 * java对象信息 生成Java文件
 * @author andy
 * @description JavaFileGenerator
 * @date 2022/9/11 15:04
 */
public interface JavaFileGenerator {
    void generate(JavaFile javaFile, Writer writer);
}
