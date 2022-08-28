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

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/**
 * @author andy
 * @description PaverLogFormatter
 * @date 2022/7/9 16:34
 */
public class PaverLogFormatter extends Formatter {
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
        if (null != parameters && parameters.length > 0 && parameters[parameters.length - 1] instanceof Throwable) {
            Throwable thrown = (Throwable) parameters[parameters.length - 1];
            record.setThrown(thrown);
        }
        //格式化消息体
        String message = MessageFormat.format(record.getMessage(), parameters);
        //日志统一显示时间和级别
        messageBuilder.append(getLogTime(millis))
                .append(" [")
                .append(getLevelName(level)).append("] ");
        //有sourceClassName就显示
        String sourceClassName = record.getSourceClassName();
        String sourceMethodName = record.getSourceMethodName();
        if (StringUtils.isNotBlank(sourceClassName) && StringUtils.isNotBlank(sourceMethodName)) {
            messageBuilder.append("[").append(sourceClassName).append(".").append(sourceMethodName).append("()] ");
        }
        //Info级别的只显示日志内容，不显示其他信息
        messageBuilder.append("").append(message).append("\n");
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
