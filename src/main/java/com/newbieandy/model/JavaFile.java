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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author andy
 * @description JavaFile
 * @date 2022/4/22 23:12
 */
abstract public class JavaFile {
    /**
     * 模版名
     */
    final private String template;

    /**
     * 包名
     */
    final private String packageName;

    /**
     * 外部导入依赖
     */
    final private List<String> extImportList;

    /**
     * 内部导入依赖
     */
    final private List<String> jreImportList;
    /**
     * 类注释信息
     */
    final private JavaClassComment classComment;

    /**
     * 注解列表
     */
    final private List<String> classAnnotations;

    /**
     * 类名
     */
    final private String className;

    public String getTemplate() {
        return template;
    }

    public String getPackageName() {
        return packageName;
    }

    public List<String> getExtImportList() {
        return extImportList;
    }

    public List<String> getJreImportList() {
        return jreImportList;
    }

    public JavaClassComment getClassComment() {
        return classComment;
    }

    public List<String> getClassAnnotations() {
        return classAnnotations;
    }

    public String getClassName() {
        return className;
    }

    protected JavaFile(Builder<?> builder) {
        this.template = builder.template;
        this.packageName = builder.packageName;
        this.extImportList = builder.extImportList;
        this.jreImportList = builder.jreImportList;
        this.classComment = builder.classComment;
        this.classAnnotations = builder.classAnnotations;
        this.className = builder.className;
    }

    static abstract class Builder<T extends Builder<T>> {
        /**
         * 模版名
         */
        private String template;

        /**
         * 包名
         */
        private String packageName;

        /**
         * 类名
         */
        private String className;

        /**
         * 类注释信息
         */
        protected JavaClassComment classComment;

        /**
         * 注解列表
         */
        protected List<String> classAnnotations;

        /**
         * 外部导入依赖
         */
        protected List<String> extImportList;

        /**
         * 内部导入依赖
         */
        protected List<String> jreImportList;

        protected Builder(String template, String packageName, String className) {
            this.template = template;
            this.packageName = packageName;
            this.className = className;
            this.jreImportList = Lists.newArrayList();
            this.extImportList = Lists.newArrayList();
            this.classAnnotations = Lists.newArrayList();
        }

        /**
         * 获取当前实例对象
         *
         * @return 获取对象
         */
        protected abstract T thisObj();

        /**
         * 类注释
         *
         * @param comments 注释信息
         * @param author   作者
         * @return builder
         */
        public T classComment(List<String> comments, String author) {
            T obj = thisObj();
            JavaClassComment javaClassComment = new JavaClassComment();
            javaClassComment.setAuthor(author);
            javaClassComment.setComments(comments);
            javaClassComment.setCreateDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));
            obj.classComment = javaClassComment;
            return obj;
        }

        /**
         * 添加类注解
         *
         * @param clazz 注解类型
         * @return builder
         */
        public T addClassAnnotation(Class<?> clazz) {
            T obj = thisObj();
            String packageName = clazz.getName();
            String annotationName = clazz.getSimpleName();
            if (!obj.classAnnotations.contains(annotationName)) {
                extImportList.add(packageName);
                classAnnotations.add(annotationName);
            }
            return obj;
        }

        /**
         * 添加类注解
         */
        public T addClassAnnotation(String annotationName, String packageName) {
            T obj = thisObj();
            if (!obj.classAnnotations.contains(annotationName)) {
                extImportList.add(packageName);
                classAnnotations.add(annotationName);
            }
            return obj;
        }
    }

}
