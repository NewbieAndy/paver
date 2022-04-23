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

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;

/**
 * @author andy
 * @description PaverLogger
 * @date 2022/4/23 19:44
 */
public class PaverLogger {
    private static final PaverLogger PAVER_LOGGER;

    static {
        Logger logger = Logger.getLogger(Paver.class.getName());
        logger.setUseParentHandlers(false);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new PaverLogFormatter());
        logger.addHandler(consoleHandler);
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

    /**
     * 日志格式化
     */
    private static class PaverLogFormatter extends Formatter {
        private static final String ERROR_LOG = "ERROR";
        private static final String WARN_LOG = "WARN";
        private static final SimpleDateFormat LOG_DATA_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");

        @Override
        public String format(LogRecord record) {
            Level level = record.getLevel();
            //日志时间戳
            long millis = record.getMillis();
            StringBuilder messageBuilder = new StringBuilder();
            String message = MessageFormat.format(record.getMessage(), record.getParameters());
            messageBuilder
                    .append(getLogTime(millis))
                    .append(" [")
                    .append(getLevelName(level)).append("] ")
                    .append(message)
                    .append("\n");
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
