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

package com.newbieandy;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.newbieandy.config.PaverConfigModule;
import com.newbieandy.config.PaverModule;
import com.newbieandy.core.CodeGenerator;
import org.junit.Before;
import org.junit.Test;

/**
 * @author andy
 * @description PaverTester
 * @date 2022/7/9 14:08
 */
public class PaverTest {

    private CodeGenerator instance;

    @Before
    public void init() {
        String[] args = new String[1];
        args[0] = "../../src/test/resources/paver_config.properties";
        Injector injector = Guice.createInjector(new PaverConfigModule(args), new PaverModule());
        instance = injector.getInstance(CodeGenerator.class);
    }

    @Test
    public void runTester() {
        instance.generate();
    }
}
