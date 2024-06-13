package com.bewell.api.common;

import java.lang.reflect.Constructor;

public class GeneralException extends RuntimeException {
    public GeneralException(String message) {
        super(message);
    }
}
