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

import java.util.Objects;

/**
 * @author andy
 * @description NameCaseUtil
 * @date 2022/4/22 23:28
 */
public class NameCaseUtil {
    private static final char SEPARATOR = '_';

    /**
     * 驼峰命名转全大写下划线命名
     *
     * @param name 驼名命名
     * @return 全大写下划线命名
     */
    public static String camelToUpperUnderlineCase(String name) {
        return camelToUnderlineCase(name).toUpperCase();
    }

    /**
     * 驼峰命名转全小写下划线命名
     *
     * @param name 驼峰命名
     * @return 下划线命名
     */
    public static String camelToUnderlineCase(String name) {
        if (Objects.isNull(name)) {
            return null;
        }
        if (0 == name.length()) {
            return name;
        }
        StringBuilder nameBuilder = new StringBuilder();
        boolean upperCase = false;
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);

            boolean nextUpperCase = true;

            if (i < (name.length() - 1)) {
                nextUpperCase = Character.isUpperCase(name.charAt(i + 1));
            }

            if (Character.isUpperCase(c)) {
                if (!upperCase || !nextUpperCase) {
                    if (i > 0) nameBuilder.append(SEPARATOR);
                }
                upperCase = true;
            } else {
                upperCase = false;
            }

            nameBuilder.append(Character.toLowerCase(c));
        }

        return nameBuilder.toString();
    }

    /**
     * 下划线格式转驼峰格式
     *
     * @param name 下划线字段名
     * @return 驼峰字段名
     */
    public static String underlineToCamelCase(String name) {
        if (Objects.isNull(name)) {
            return null;
        }
        if (0 == name.length()) {
            return name;
        }
        name = name.toLowerCase();
        StringBuilder nameBuilder = new StringBuilder(name.length());
        boolean upperCase = false;
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (c == SEPARATOR) {
                upperCase = true;
            } else if (upperCase) {
                nameBuilder.append(Character.toUpperCase(c));
                upperCase = false;
            } else {
                nameBuilder.append(c);
            }
        }
        return nameBuilder.toString();
    }

    /**
     * 下划线格式转首字母大写的驼峰格式
     *
     * @param name 下划线字段名
     * @return 首字母大写驼峰字段名
     */
    public static String underlineToCapitalizeCamelCase(String name) {
        if (name == null) {
            return null;
        }
        if (0 == name.length()) {
            return name;
        }
        name = underlineToCamelCase(name);
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
}
