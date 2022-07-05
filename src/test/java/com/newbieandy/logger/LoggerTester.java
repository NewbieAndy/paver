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

import com.newbieandy.exception.CodeGenException;
import org.junit.Test;

import java.util.Map;
import java.util.Properties;

/**
 * @author andy
 * @description LoggerTester
 * @date 2022/6/11 20:13
 */
public class LoggerTester {
    private static final PaverLogger logger = PaverLogger.getLogger();

    @Test
    public void printLogTest() {
        Map<String, String> getenv = System.getenv();
        Properties properties = System.getProperties();
        System.out.println(getenv);
        System.out.println(properties);
        logger.warn("这是warn日志...");
        logger.info("这是info日志...{0}", "idx0");
        logger.error("这是error日志...");
        logger.debug("这是debug日志");
    }
}
