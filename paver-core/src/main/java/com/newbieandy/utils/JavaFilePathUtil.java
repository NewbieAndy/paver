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

import java.io.File;

/**
 * @author andy
 * @description JavaFilePathUtil
 * @date 2022/4/22 23:36
 */
public class JavaFilePathUtil {
    //Java文件扩展名
    private static final String JAVA_EXT_NAME = ".java";
    private static final String COMMON_PATH = "src" + File.separator + "main" + File.separator + "java" + File.separator;

    /**
     * 获取文件路径
     *
     * @param projectBase 项目路径
     * @param basePackage 包地址
     * @param fileName    文件名
     * @return 文件就地址
     */
    public static String getFilePath(String projectBase, String basePackage, String fileName) {
        if (!projectBase.endsWith(File.separator)) {
            projectBase += File.separator;
        }
        String packagePath = basePackage.replace('.', File.separatorChar) + File.separator;
        return projectBase + COMMON_PATH + packagePath + fileName + JAVA_EXT_NAME;
    }

    public static void main(String[] args) {
        System.out.println(COMMON_PATH);
        String projectBase = "/Users/andy/bitank/bitank-server/center-server";
        String basePackage = "com.bitank.server.admin.dao";
        String javaFIle = "UserMapper";
        String filePath = getFilePath(projectBase, basePackage, javaFIle);
        System.out.println(filePath);
    }
}
