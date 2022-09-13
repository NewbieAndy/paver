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

package com.newbieandy.config;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.newbieandy.annotation.MysqlParser;
import com.newbieandy.parser.CreateTableDDLParser;
import com.newbieandy.parser.MysqlCreateTableDDLParser;

import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.sql.Connection;

/**
 * @author andy
 * @description PaverModule
 * @date 2022/4/23 18:15
 */
public class PaverModule extends AbstractModule {
    @Override
    protected void configure() {
        //Mysql建表语句解析
        bind(CreateTableDDLParser.class).annotatedWith(MysqlParser.class).to(MysqlCreateTableDDLParser.class).in(Singleton.class);
    }

    @Provides
    static Connection Connection() {
        return null;
    }
}
