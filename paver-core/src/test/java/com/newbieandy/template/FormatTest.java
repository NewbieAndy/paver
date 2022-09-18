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

package com.newbieandy.template;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * @author andy
 * @description FormatTest
 * @date 2022/8/29 14:14
 */
public class FormatTest {
    @Test
    public void test() {
        System.out.println("hello");
    }

    @Test
    public void fileWriteTest() throws IOException {
        List<String> strings = Arrays.asList("hello", "world", "aaaaa" + System.lineSeparator() + "bbbbb", "    @Test\n" +
                "    public void fileWriteTest() throws IOException {\n" +
                "        List<String> strings = Arrays.asList(\"hello\", \"world\", \"aaaaa\" + System.lineSeparator() + \"bbbbb\");\n" +
                "        Path j = Files.write(Paths.get(\"/Users/andy/Desktop/Test.java\"), strings);\n" +
                "    }");
        Path j = Files.write(Paths.get("/Users/andy/Desktop/Test.java"), strings);
    }

    @Test
    public void fileWriterTest() {

        String input = "hello world";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("/Users/andy/github/paver/paver-core/src/test/java/com/newbieandy/template/hello.txt")))) {
            for (int i = 0; i < 1000000; i++) {
                writer.write(input + i);
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
