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

package com.newbieandy.parser;

import com.newbieandy.model.TableInfo;

/**
 * 直连数据库解析表信息
 *
 * @author andy
 * @description DirectDatabaseParser
 * @date 2022/8/27 21:07
 */
public interface DirectDatabaseParser {
    /**
     * 解析表信息
     *
     * @param table 表名
     * @return 表信息
     */
    TableInfo parseTable(String table);
}
