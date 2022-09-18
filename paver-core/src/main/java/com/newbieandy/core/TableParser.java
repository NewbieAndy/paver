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

import com.newbieandy.model.TableInfo;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 表解析器
 *
 * @author andy
 * @description TableParser
 * @date 2022/9/11 16:25
 */
@FunctionalInterface
public interface TableParser<T> {
    TableInfo parse(T source);

    public static void main(String[] args) {

    }
}
