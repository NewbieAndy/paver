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

package com.newbieandy.config;

/**
 * 配置项常量，配置项key
 * SYS开头为系统级配置
 * APP开头为应用配置
 *
 * @author andy
 * @description ConfigConstants
 * @date 2022/7/10 13:37
 */
public class ConfigConstants {
    /**
     * 当前宿主机的操作系统
     */
    static final String SYS_OS_NAME_KEY = "os.name";

    /**
     * MAC系统
     */
    static final String SYS_OS_NAME_VALUE_MAC = "mac";

    /**
     * Windows系统
     */
    static final String SYS_OS_NAME_VALUE_WINDOWS = "windows";

    /**
     * Linux系统
     */
    static final String SYS_OS_NAME_VALUE_LINUX = "linux";

    /**
     * 默认配置文件
     */
    static final String SYS_CONFIG_DEFAULT_NAME = "paver_config.properties";


    private ConfigConstants() {
    }
}
