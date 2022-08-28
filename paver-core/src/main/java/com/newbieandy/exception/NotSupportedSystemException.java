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
 * @description NotSupportedSystemException
 * @date 2022/7/10 15:59
 */
public class NotSupportedSystemException extends PaverException {
    public NotSupportedSystemException() {
        super();
    }

    public NotSupportedSystemException(String message) {
        super(message);
    }

    public NotSupportedSystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotSupportedSystemException(Throwable cause) {
        super(cause);
    }

    protected NotSupportedSystemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
