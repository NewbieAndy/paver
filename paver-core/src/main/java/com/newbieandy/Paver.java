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

/**
 * @author Andy
 * @description Paver
 * @date 2022/4/19 22:13
 */
public class Paver {

    public static void main(String[] args) {
        initAndRun(args);
    }

    private static void initAndRun(String[] args) {
        Injector injector = Guice.createInjector(new PaverConfigModule(args), new PaverModule());
//        CodeGenerator instance = injector.getInstance(CodeGenerator.class);
//        instance.generate();
    }

}

