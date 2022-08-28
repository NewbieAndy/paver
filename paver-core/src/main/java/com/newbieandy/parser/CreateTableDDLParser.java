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
 * 解析建表语句
 *
 * @author andy
 * @description CreateTableDDLParser
 * @date 2022/8/24 11:45
 */
public interface CreateTableDDLParser {
    /**
     * 解析表创建DDL
     *
     * @param ddl 创建语句DDL
     * @return 表信息
     */
    TableInfo parseDDL(String ddl);
}
