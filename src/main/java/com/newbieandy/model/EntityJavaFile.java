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

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author andy
 * @description EntityJavaFile
 * @date 2022/4/22 23:15
 */
public class EntityJavaFile extends JavaFile {
    /**
     * 字段信息
     */
    final private List<JavaField> fieldModels;

    public List<JavaField> getFieldModels() {
        return fieldModels;
    }

    private EntityJavaFile(Builder builder) {
        super(builder);
        this.fieldModels = builder.fieldModels;
    }

    public static Builder builder(String template, String packageName, String className) {
        return new Builder(template, packageName, className);
    }

    public static class Builder extends JavaFile.Builder<Builder> {

        private Builder(String template, String packageName, String className) {
            super(template, packageName, className);
            this.fieldModels = Lists.newArrayList();
        }

        private final List<JavaField> fieldModels;

        public EntityJavaFile build() {
            //对列表进行排序
            Collections.sort(this.extImportList);
            Collections.sort(this.jreImportList);
            this.fieldModels.sort(Comparator.comparing(JavaField::getIdx));
            return new EntityJavaFile(this);
        }

        @Override
        protected Builder thisObj() {
            return this;
        }

        /**
         * 添加字段
         *
         * @param pos     位置，从1开始
         * @param clazz   字段类型
         * @param name    字段名
         * @param comment 字段注解
         */
        public <T> Builder addJavaField(int pos, Class<T> clazz, String name, String comment) {
            JavaField javaField = new JavaField();
            String packageName = clazz.getPackage().getName();
            String fullName = clazz.getName();
            String typeName = clazz.getSimpleName();
            javaField.setIdx(pos);
            javaField.setType(typeName);
            javaField.setName(name);
            javaField.setComment(comment);
            //如果之前未添加过则添加
            if (!this.fieldModels.contains(javaField)) {
                this.fieldModels.add(javaField);
            }
            //如果依赖是java.lang下基础类则不需要声明
            if ("java.lang".equals(packageName)) {
                return this;
            }
            //如果包名是java开头则是jre依赖
            if (fullName.startsWith("java")) {
                if (!this.jreImportList.contains(fullName)) {
                    this.jreImportList.add(fullName);
                }
            } else {
                if (!this.extImportList.contains(fullName)) {
                    this.extImportList.add(fullName);
                }
            }
            return this;
        }
    }
}
