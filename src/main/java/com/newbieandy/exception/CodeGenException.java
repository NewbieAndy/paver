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

package com.newbieandy.exception;

/**
 * @author andy
 * @description CodeGenException
 * @date 2022/6/26 20:43
 */
public class CodeGenException extends PaverException {
    public CodeGenException() {
        super();
    }

    public CodeGenException(String message) {
        super(message);
    }

    public CodeGenException(String message, Throwable cause) {
        super(message, cause);
    }

    public CodeGenException(Throwable cause) {
        super(cause);
    }

    protected CodeGenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
