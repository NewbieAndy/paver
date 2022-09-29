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

package com.newbieandy.model.file.java;

import com.newbieandy.model.file.AbstractFileModel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author andy
 * @description JavaFileModel
 * @date 2022/9/18 13:30
 */
public class JavaFileModel extends AbstractFileModel {

    private JavaFileModel(String fileName, String content) {
        super(fileName, content);
    }

    /**
     * 构造器
     *
     * @param className 类名
     * @return 构造器
     */
    public static Builder builder(String className) {
        return new Builder(className);
    }

    public static class Builder {
        private static final List<String> DEFAULT_CLASS_MODIFIERS = Arrays.asList("public", "class");

        private Builder(String className) {
            this.className = className + ".java";
        }

        /**
         * 类名
         */
        final private String className;

        /**
         * 包名
         */
        private String packageName;

        /**
         * 类的修饰符
         */
        private List<String> classModifiers = DEFAULT_CLASS_MODIFIERS;


        /**
         * 实现的接口列表
         */
        private List<String> interfaces;

        /**
         * 父类
         */
        private String parentClassName;

        /**
         * 导入列表
         */
        private List<String> importList;

        /**
         * 类注释
         */
        private ClassCommentModel classComment;

        /**
         * 报名
         *
         * @param packageName 报名
         * @return 构建器
         */
        public Builder packageName(String packageName) {
            this.packageName = packageName;
            return this;
        }

        /**
         * 类描述符
         *
         * @param modifiers 描述符列表
         * @return 构建器
         */
        public Builder classModifiers(List<String> modifiers) {
            return this;
        }

        /**
         * 构建Java对象
         *
         * @return Java对象
         */
        public JavaFileModel build() {
            StringBuilder contentBuilder = new StringBuilder();
            //构建报名

            return new JavaFileModel(this.className, contentBuilder.toString());
        }
    }
}
