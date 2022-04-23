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

import com.newbieandy.utils.NameCaseUtil;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author andy
 * @description MapperJavaFile
 * @date 2022/4/22 23:26
 */
public class MapperJavaFile extends JavaFile {
    //对应实体类名
    final private String entityName;
    //对应实体变量名
    final private String entityVarName;
    //表名
    final private String tableName;
    //所有字段
    final private String allColumns;
    //是否有删除标记
    final private boolean hasDeleteFlag;
    //删除标记字段
    final private String deleteFlagColumn;
    //是否自动生成key
    final private boolean autoGenerateKey;
    //主键列
    final private String keyColumn;
    //主键字段
    final private String keyField;
    //主键java类型
    final private String keyFieldType;
    /***********insert*************/
    //插入的字段
    final private String insertColumns;
    //插入的值
    final private String insertColumnValues;
    /***********update*************/
    final private String updateColumnValues;

    public String getEntityName() {
        return entityName;
    }

    public String getEntityVarName() {
        return entityVarName;
    }

    public String getTableName() {
        return tableName;
    }

    public String getAllColumns() {
        return allColumns;
    }

    public boolean isHasDeleteFlag() {
        return hasDeleteFlag;
    }

    public String getDeleteFlagColumn() {
        return deleteFlagColumn;
    }

    public boolean isAutoGenerateKey() {
        return autoGenerateKey;
    }

    public String getKeyColumn() {
        return keyColumn;
    }

    public String getKeyField() {
        return keyField;
    }

    public String getKeyFieldType() {
        return keyFieldType;
    }

    public String getInsertColumns() {
        return insertColumns;
    }

    public String getInsertColumnValues() {
        return insertColumnValues;
    }

    public String getUpdateColumnValues() {
        return updateColumnValues;
    }

    private MapperJavaFile(MapperJavaFile.Builder builder) {
        super(builder);
        this.entityName = builder.entityName;
        this.entityVarName = builder.entityVarName;
        this.tableName = builder.tableName;
        this.allColumns = builder.allColumns;
        this.hasDeleteFlag = builder.hasDeleteFlag;
        this.deleteFlagColumn = builder.deleteFlagColumn;
        this.autoGenerateKey = builder.autoGenerateKey;
        this.keyColumn = builder.keyColumn;
        this.keyField = builder.keyField;
        this.keyFieldType = builder.keyFieldType;
        this.insertColumns = builder.insertColumns;
        this.insertColumnValues = builder.insertColumnValues;
        this.updateColumnValues = builder.updateColumnValues;
    }

    public static MapperJavaFile.Builder builder(String template, String entityName, String entityPackage, String packageName, String className) {
        return new MapperJavaFile.Builder(template, entityName, entityPackage, packageName, className);
    }

    public static class Builder extends JavaFile.Builder<MapperJavaFile.Builder> {

        private Builder(String template, String entityName, String entityPackage, String packageName, String className) {
            super(template, packageName, className);
            this.entityName = entityName;
            this.entityVarName = Character.toLowerCase(this.entityName.charAt(0)) + this.entityName.substring(1);
            this.extImportList.add(String.format("%s.%s", entityPackage, entityName));
        }

        //实体类名
        private String entityName;
        //实体变量名
        private String entityVarName;
        //表名
        private String tableName;
        //所有字段
        private String allColumns;
        //是否有逻辑删字段
        private boolean hasDeleteFlag;
        //删除状态字段
        private String deleteFlagColumn;
        //是否自动生成key
        private boolean autoGenerateKey;
        //主键列
        private String keyColumn;
        //主键字段
        private String keyField;
        //主键类型
        private String keyFieldType;

        /***********insert*************/
        //插入的字段
        private String insertColumns;
        //插入的值
        private String insertColumnValues;

        /***********update*************/
        private String updateColumnValues;

        public MapperJavaFile build() {
            //对列表进行排序
            Collections.sort(this.extImportList);
            Collections.sort(this.jreImportList);
            return new MapperJavaFile(this);
        }

        @Override
        protected MapperJavaFile.Builder thisObj() {
            return this;
        }

        /**
         * 设置表名
         */
        public MapperJavaFile.Builder tableName(String tableName) {
            this.tableName = String.format("`%s`", tableName);
            return this;
        }

        /**
         * 设置表所有字段
         */
        public MapperJavaFile.Builder allColumns(List<String> allColumns, boolean hasDeleteFlag, String deleteFlagColumn) {
            this.hasDeleteFlag = hasDeleteFlag;
            this.deleteFlagColumn = deleteFlagColumn;
            this.allColumns = allColumns.stream()
                    .map(column -> String.format("`%s`", column))
                    .collect(Collectors.joining(","));
            return this;
        }


        /**
         * 设置主键
         */
        public MapperJavaFile.Builder primaryKeyColumn(String primaryKeyColumn, String keyFieldType, boolean autoGenerate) {
            this.autoGenerateKey = autoGenerate;
            this.keyColumn = primaryKeyColumn;
            this.keyField = NameCaseUtil.underlineToCamelCase(primaryKeyColumn);
            this.keyFieldType = keyFieldType;
            return this;
        }

        /**
         * 插入方法
         */
        public MapperJavaFile.Builder insertMethod(List<String> insertColumns) {
            this.insertColumns = insertColumns.stream()
                    .map(column -> String.format(" `%s`", column))
                    .collect(Collectors.joining(","));

            this.insertColumnValues = insertColumns.stream()
                    .map(column -> String.format(" #{%s}", NameCaseUtil.underlineToCamelCase(column)))
                    .collect(Collectors.joining(","));
            return this;
        }

        /**
         * 更新方法
         */
        public MapperJavaFile.Builder updateMethod(List<String> updateColumns) {
            if (null == updateColumns || updateColumns.size() == 0) {
                return this;
            }
            this.updateColumnValues = updateColumns.stream()
                    .map(column -> String.format(" `%s` = #{%s}", column, NameCaseUtil.underlineToCamelCase(column)))
                    .collect(Collectors.joining(","));
            return this;
        }

        /**
         * list
         */
        public MapperJavaFile.Builder listMethod() {
            this.extImportList.add("java.util.List");
            return this;
        }
    }
}
