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

package com.newbieandy.service.impl;

import com.newbieandy.model.TableInfo;
import com.newbieandy.service.DatabaseTableService;

import java.util.List;

/**
 * @author andy
 * @description DatabaseTableServiceImpl
 * @date 2022/4/23 18:20
 */
public class DatabaseTableServiceImpl implements DatabaseTableService {

    @Override
    public List<TableInfo> listDatabaseTableInfo(String database, List<String> tables) {
        return null;
    }
}
