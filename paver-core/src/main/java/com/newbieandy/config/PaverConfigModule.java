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

//package com.newbieandy.config;

//import com.google.inject.AbstractModule;
//import com.google.inject.name.Names;
//import com.newbieandy.Paver;
//import com.newbieandy.exception.LoadConfigurationFileException;
//import com.newbieandy.exception.NotSupportedSystemException;
//import com.newbieandy.logger.PaverLogger;
//
//import java.io.*;
//import java.util.Locale;
//import java.util.Properties;
//
///**
// * @author andy
// * @description PaverConfigModule
// * @date 2022/7/09 16:14
// */
//public class PaverConfigModule extends AbstractModule {
//    private static final PaverLogger LOGGER = PaverLogger.paverGlobalLogger();
//
//    private final String[] args;
//
//    public PaverConfigModule(String[] args) {
//        this.args = args;
//    }
//
//    @Override
//    protected void configure() {
//        //配置属性
//        Properties properties = loadProperties(this.args);
//        //命令行配置的参数优先级高于配置文件的配置
//        Properties systemProperties = System.getProperties();
//        //合并配置
//        systemProperties.forEach((k, v) -> properties.setProperty((String) k, (String) v));
//        //配置加载
//        properties.forEach((propKey, propValue) ->
//                //看命令行是否有配置，有则覆盖文件的撇脂
//                bindConstant().annotatedWith(Names.named((String) propKey)).to((String) propValue)
//        );
//    }
//
//    /**
//     * 加载配置文件
//     *
//     *
//     * @param args 启动参数
//     * @return 配置文件
//     */
//    private static Properties loadProperties(String[] args) {
//        //配置文件路径
//        String configPath = configLocation(args);
//        Properties properties = new Properties();
//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(configPath))) {
//            //加载配置文件
//            properties.load(bufferedReader);
//        } catch (FileNotFoundException e) {
//            LOGGER.error("Failed to load configuration file,{0} not found", e);
//            throw new LoadConfigurationFileException();
//        } catch (IOException e) {
//            LOGGER.error("Failed to load configuration file, IO exception occurred", e);
//            throw new LoadConfigurationFileException();
//        }
//        return properties;
//    }
//
//    /**
//     * 配置文件的文件路径
//     *
//     * @param args 启动参数
//     * @return 文件路径
//     */
//    private static String configLocation(String[] args) {
//        //如果无参数，或者首个参数不是配置文件结尾的则直接返回默认配置文件地址
//        if (args.length == 0 || !args[0].endsWith(File.separator + ConfigConstants.SYS_CONFIG_DEFAULT_NAME)) {
//            return configDefaultLocation();
//        }
//        //取传过来的参数
//        String configCustomPath = args[0];
//        //判断是相对地址还绝对地址
//        if (isAbsolutePath(configCustomPath)) {
//            //绝对路径直接返回
//            return configCustomPath;
//        } else {
//            //相对路径则拼上目录地址转成绝对路径返回
//            return currentDirectory() + File.separator + configCustomPath;
//        }
//    }
//
//    /**
//     * 判断地址是否是绝对路径
//     *
//     * @param path 路径
//     * @return true - > 绝对路径 false->相对路径
//     */
//    private static boolean isAbsolutePath(String path) {
//        //查看当前系统的平台类型,目前仅支持Win 和 Mac
//        String osName = System.getProperty(ConfigConstants.SYS_OS_NAME_KEY);
//        if (null == osName) {
//            throw new NotSupportedSystemException();
//        }
//        osName = osName.toLowerCase(Locale.ROOT);
//        //mac 或者 linux系统 判断绝对路径都是通过/判断的
//        if (osName.startsWith(ConfigConstants.SYS_OS_NAME_VALUE_MAC) || osName.startsWith(ConfigConstants.SYS_OS_NAME_VALUE_LINUX)) {
//            return path.startsWith(File.separator);
//        } else if (osName.startsWith(ConfigConstants.SYS_OS_NAME_VALUE_WINDOWS)) {
//            //windows系统
//            char firstChar = path.charAt(0);
//            char secondChar = path.charAt(1);
//            //首字符是C-Z之间，第二字符是:则认为是windows的绝对路径
//            return 'C' <= firstChar && firstChar <= 'Z' && secondChar == ':';
//        } else {
//            throw new NotSupportedSystemException();
//        }
//    }
//
//
//    /**
//     * 配置文件默认地址 ./paver_config.properties
//     *
//     * @return 配置文件地址
//     */
//    private static String configDefaultLocation() {
//        return currentDirectory() + File.separator + ConfigConstants.SYS_CONFIG_DEFAULT_NAME;
//    }
//
//    /**
//     * 当前文件目录
//     *
//     * @return 文件目录地址
//     */
//    private static String currentDirectory() {
//        String path = Paver.class.getProtectionDomain().getCodeSource().getLocation().getPath();
//        return path.substring(0, path.lastIndexOf(File.separatorChar));
//    }
//}
