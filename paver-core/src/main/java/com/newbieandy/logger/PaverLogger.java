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

package com.newbieandy.logger;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 日志在本项目中没有特别的需求，直接使用原生的日志，这里针对个人习惯对日志进行一个简单对包装封装
 * 日志支持4中级别，DEBUG->INFO->WARN->ERROR 默认开启INFO级别，要想开启DEBUG日志，需要在启动时指定 --debug参数
 * 开启debug日志需要设置环境变量，debugMode=true
 *
 * @author andy
 * @description PaverLogger
 * @date 2022/7/9 16:29
 */
public class PaverLogger {
    /**
     * 是否开debug模式
     */
    private static final String SYS_DEBUG_MODEL_KEY = "debugMode";

    private final boolean debugMode;
    private final Logger logger;
    private final static PaverLogger PAVER_LOGGER = new PaverLogger();

    public static PaverLogger paverGlobalLogger() {
        return PAVER_LOGGER;
    }

    private PaverLogger() {
        this.logger = Logger.getGlobal();
        this.debugMode = Boolean.TRUE.toString().equalsIgnoreCase(System.getProperty(SYS_DEBUG_MODEL_KEY));
        logger.setUseParentHandlers(false);
        //控制台处理器，日志仅控制台输出
        ConsoleHandler consoleHandler = new ConsoleHandler();
        //自定义日志格式
        consoleHandler.setFormatter(new PaverLogFormatter());
        logger.addHandler(consoleHandler);
        //是否是Debug模式
        if (debugMode) {
            consoleHandler.setLevel(Level.CONFIG);
            logger.setLevel(Level.CONFIG);
        }
    }

    public void info(String msg) {
        log(Level.INFO, msg);
    }


    public void info(String msg, Object... params) {
        log(Level.INFO, msg, params);
    }

    public void warn(String msg) {
        log(Level.WARNING, msg);
    }

    public void warn(String msg, Object... params) {
        log(Level.WARNING, msg, params);
    }

    public void error(String msg) {
        log(Level.SEVERE, msg);
    }

    public void error(String msg, Object... params) {
        log(Level.SEVERE, msg, params);
    }

    public void debug(String msg) {
        log(Level.CONFIG, msg);
    }

    public void debug(String msg, Object... params) {
        log(Level.CONFIG, msg, params);
    }

    private void log(Level level, String msg, Object... params) {
        String sourceClass = "";
        String sourceMethod = "";
        if (debugMode) {
            StackTraceElement[] stackTraces = Thread.currentThread().getStackTrace();
            sourceClass = stackTraces[3].getClassName();
            sourceMethod = stackTraces[3].getMethodName();
        }
        logger.logp(level, sourceClass, sourceMethod, msg, params);
    }
}
