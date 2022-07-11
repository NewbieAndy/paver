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

package com.newbieandy.core;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import com.newbieandy.config.ConfigConstants;
import com.newbieandy.logger.PaverLogger;

/**
 * @author andy
 * @description MysqlGenerator
 * @date 2022/7/9 15:49
 */
public class MysqlGenerator implements CodeGenerator {
    private static final PaverLogger logger = PaverLogger.paverGlobalLogger();

    @Inject
    @Named("hello.world")
    private String hello;

    @Override
    public void generate() {
        logger.info("info MysqlGenerator... generate...");
        logger.debug("debug MysqlGenerator... generate...");
        logger.error(hello);
    }
}