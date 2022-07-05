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

import com.newbieandy.Paver;
import org.apache.commons.lang.exception.ExceptionUtils;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.*;

/**
 * 日志在本项目中没有特别的需求，直接使用原生的日志，这里针对个人习惯对日志进行一个简单对包装封装
 * 日志支持4中级别，DEBUG->INFO->WARN->ERROR 默认开启INFO级别，要想开启DEBUG日志，需要在启动时指定 --debug参数
 * 开启debug日志需要设置环境变量，PaverDebug=true
 *
 * @author andy
 * @description PaverLogger
 * @date 2022/4/23 19:44
 */
public class PaverLogger {
    /**
     * DEBUG模式环境变量
     */
    public static final String DEBUG_FLAG_KEY = "PaverDebug";
    private static final PaverLogger PAVER_LOGGER;

    static {
        Logger logger = Logger.getLogger(Paver.class.getName());
        logger.setUseParentHandlers(false);
        //控制台处理器，日志仅控制台输出
        ConsoleHandler consoleHandler = new ConsoleHandler();
        //自定义日志格式
        consoleHandler.setFormatter(new PaverLogFormatter());
        logger.addHandler(consoleHandler);
        if ("true".equals(System.getProperty(DEBUG_FLAG_KEY))) {
            consoleHandler.setLevel(Level.CONFIG);
            logger.setLevel(Level.CONFIG);
        }
        PAVER_LOGGER = new PaverLogger(logger);

    }

    private final Logger logger;


    private PaverLogger(Logger logger) {
        this.logger = logger;
    }

    public static PaverLogger getLogger() {
        return PAVER_LOGGER;
    }

    public void info(String msg) {
        logger.log(Level.INFO, msg);
    }

    public void info(String msg, Object... params) {
        logger.log(Level.INFO, msg, params);
    }

    public void warn(String msg) {
        logger.log(Level.WARNING, msg);
    }

    public void warn(String msg, Object... params) {
        logger.log(Level.WARNING, msg, params);
    }

    public void error(String msg) {
        logger.log(Level.SEVERE, msg);
    }

    public void error(String msg, Object... params) {
        logger.log(Level.SEVERE, msg, params);
    }

    public void debug(String msg) {
        logger.log(Level.CONFIG, msg);
    }

    public void debug(String msg, Object... params) {
        logger.log(Level.CONFIG, msg, params);
    }

    /**
     * 日志格式化
     * 这里针对原生日志消息进行一次格式化
     */
    private static class PaverLogFormatter extends Formatter {
        private static final String ERROR_LOG = "ERROR";
        private static final String WARN_LOG = "WARN";
        private static final String DEBUG_LOG = "DEBUG";
        private static final SimpleDateFormat LOG_DATA_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");

        @Override
        public String format(LogRecord record) {
            Level level = record.getLevel();
            //日志时间戳
            long millis = record.getMillis();
            StringBuilder messageBuilder = new StringBuilder();
            Object[] parameters = record.getParameters();
            //如果最后一个是Throwable则提取出来
            if (null != parameters && parameters[parameters.length - 1] instanceof Throwable) {
                Throwable thrown = (Throwable) parameters[parameters.length - 1];
                record.setThrown(thrown);
            }
            //格式化消息体
            String message = MessageFormat.format(record.getMessage(), parameters);
            //日志统一显示时间和级别
            messageBuilder.append(getLogTime(millis))
                    .append(" [")
                    .append(getLevelName(level)).append("] ");
            //Info级别的只显示日志内容，不显示其他信息
            messageBuilder.append(message).append("\n");
            //如果最后一个是Throwable则提取出来
            if (null != record.getThrown()) {
                String stackTrace = ExceptionUtils.getFullStackTrace(record.getThrown());
                messageBuilder.append(stackTrace);
            }
            return messageBuilder.toString();
        }

        /**
         * 获取日志级别描述
         *
         * @param level 日志级别
         * @return 级别描述
         */
        private static String getLevelName(Level level) {
            if (level.equals(Level.SEVERE)) {
                return ERROR_LOG;
            } else if (level.equals(Level.WARNING)) {
                return WARN_LOG;
            } else if (level.equals(Level.CONFIG)) {
                return DEBUG_LOG;
            }
            return level.getName();
        }

        /**
         * 根据日志时间戳获取日志时间
         *
         * @param millis 日志时间戳
         * @return 日志时间
         */
        private static String getLogTime(long millis) {
            return LOG_DATA_FORMAT.format(new Date(millis));
        }
    }
}
