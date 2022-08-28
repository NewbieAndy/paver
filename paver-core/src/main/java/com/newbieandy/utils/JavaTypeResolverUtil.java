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

package com.newbieandy.utils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author andy
 * @description JavaTypeResolverUtil
 * @date 2022/4/22 23:36
 */
public class JavaTypeResolverUtil {
    private static final Map<String, Class> DATA_TYPE_MAP = new HashMap<String, Class>();
    private static final Map<String, String> PRIMARY_KEY_TYPE_MAP = new HashMap<String, String>();

    static {
        DATA_TYPE_MAP.put(MysqlDataType.TYPE_TINYINT, Integer.class);
        DATA_TYPE_MAP.put(MysqlDataType.TYPE_INT, Integer.class);
        DATA_TYPE_MAP.put(MysqlDataType.TYPE_BIGINT, Long.class);
        DATA_TYPE_MAP.put(MysqlDataType.TYPE_DECIMAL, BigDecimal.class);
        DATA_TYPE_MAP.put(MysqlDataType.TYPE_VARCHAR, String.class);
        DATA_TYPE_MAP.put(MysqlDataType.TYPE_TEXT, String.class);
        DATA_TYPE_MAP.put(MysqlDataType.TYPE_MEDIUMTEXT, String.class);
        DATA_TYPE_MAP.put(MysqlDataType.TYPE_TIMESTAMP, LocalDateTime.class);
        DATA_TYPE_MAP.put(MysqlDataType.TYPE_DATETIME, LocalDateTime.class);
        DATA_TYPE_MAP.put(MysqlDataType.TYPE_TIME, LocalTime.class);

        PRIMARY_KEY_TYPE_MAP.put(MysqlDataType.TYPE_TINYINT, "int");
        PRIMARY_KEY_TYPE_MAP.put(MysqlDataType.TYPE_INT, "int");
        PRIMARY_KEY_TYPE_MAP.put(MysqlDataType.TYPE_BIGINT, "long");
        PRIMARY_KEY_TYPE_MAP.put(MysqlDataType.TYPE_VARCHAR, "String");
    }

    /**
     * 根据mysql数据类型获取Java数据类型
     *
     * @param mysqlDateType mysql数据类型
     * @return java数据类型
     */
    public static Class getJavaTypeByMysqlType(String mysqlDateType) {
        return DATA_TYPE_MAP.get(mysqlDateType.toLowerCase());
    }

    /**
     * 获取主键类型
     */
    public static String getPrimaryKeyTypeByMysqlType(String mysqlDateType) {
        return PRIMARY_KEY_TYPE_MAP.get(mysqlDateType.toLowerCase());
    }

    /**
     * Mysql数据类型
     */
    private static class MysqlDataType {
        //tinyint
        private static final String TYPE_TINYINT = "tinyint";
        //int
        private static final String TYPE_INT = "int";
        //bigint
        private static final String TYPE_BIGINT = "bigint";
        //decimal
        private static final String TYPE_DECIMAL = "decimal";
        //varchar
        private static final String TYPE_VARCHAR = "varchar";
        //text
        private static final String TYPE_TEXT = "text";
        //mediumtext
        private static final String TYPE_MEDIUMTEXT = "mediumtext";
        //timestamp
        private static final String TYPE_TIMESTAMP = "timestamp";
        //datetime
        private static final String TYPE_DATETIME = "datetime";
        //time
        private static final String TYPE_TIME = "time";
    }
}
