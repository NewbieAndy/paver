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

package com.newbieandy.model;

import com.newbieandy.model.file.java.JavaFileModel;
import org.junit.Test;

/**
 * @author andy
 * @description JavaModelTest
 * @date 2022/9/18 14:22
 */
public class JavaModelTest {
    @Test
    public void test() {
        JavaFileModel helloworld = JavaFileModel
                .builder("helloworld")
                .packageName("com.newbie.andy")
                .build();
        String content = helloworld.getContent();
        System.out.println(content);

    }
}
