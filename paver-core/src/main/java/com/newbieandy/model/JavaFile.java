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

import com.newbieandy.constants.ClassType;

import java.util.List;

/**
 * @author andy
 * @description JavaFile
 * @date 2022/4/22 23:12
 */
public class JavaFile {
    private ClassType classType;
    /**
     * 包名
     */
    private String packageName;

    /**
     * 类名
     */
    private String className;

    /**
     * 继承的父类
     */
    private String parentClass;

    /**
     * 接口列表
     */
    private List<String> interfaces;

    /**
     * 引入包
     */
    private List<String> imports;

    /**
     * 类注释信息
     */
    private JavaClassComment classComment;

    /**
     * 注解列表
     */
    private List<String> classAnnotations;

    /**
     * 方法
     */
    private List<JavaMethod> javaMethods;

    /**
     * 内部类
     */
    private List<JavaFile> subClassList;

    public static void main(String[] args) {
        int modifiers = JavaFile.class.getModifiers();
    }
}
