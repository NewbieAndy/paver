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

package com.newbieandy;

import com.newbieandy.model.TableInfo;
import com.newbieandy.parser.CreateTableDDLParser;
import com.newbieandy.parser.MysqlCreateTableDDLParser;
import org.junit.Test;

/**
 * @author andy
 * @description CreateTableDDLParserTest
 * @date 2022/8/25 20:02
 */
public class CreateTableDDLParserTest extends PaverBaseTest {
    @Test
    public void mysqlParseDDLTest() {
        CreateTableDDLParser createTableDDLParser = injector.getInstance(MysqlCreateTableDDLParser.class);
        TableInfo tableInfo = createTableDDLParser.parseDDL("");
        System.out.println(tableInfo);
    }
}
