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

import java.util.List;

/**
 * @author andy
 * @description DatabaseTableService
 * @date 2022/4/23 18:17
 */
public interface IDatabaseTableEngine {
    /**
     * 列出指定数据库对应表的详细信息，包括表明，描述，字段名等信息
     *
     * @param database 数据库
     * @param tables   数据库表
     * @return 表列表
     */
    List<TableInfo> listDatabaseTableInfo(String database, List<String> tables);
}
