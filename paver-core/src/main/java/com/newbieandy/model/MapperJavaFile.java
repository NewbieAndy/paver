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

/**
 * @author andy
 * @description MapperJavaFile
 * @date 2022/4/22 23:26
 */
public class MapperJavaFile extends JavaFile {
    //对应实体类名
    private String entityName;
    //对应实体变量名
    private String entityVarName;
    //表名
    private String tableName;
    //所有字段
    private String allColumns;
    //是否有删除标记
    private boolean hasDeleteFlag;
    //删除标记字段
    private String deleteFlagColumn;
    //是否自动生成key
    private boolean autoGenerateKey;
    //主键列
    private String keyColumn;
    //主键字段
    private String keyField;
    //主键java类型
    private String keyFieldType;
    /***********insert*************/
    //插入的字段
    private String insertColumns;
    //插入的值
    private String insertColumnValues;
    /***********update*************/
    private String updateColumnValues;
}
