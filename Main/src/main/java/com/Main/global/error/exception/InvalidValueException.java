package com.Main.global.error.exception;


import com.Main.global.error.code.BaseErrorCode;

public class InvalidValueException extends GeneralException {
    private BaseErrorCode baseErrorCode;
    public InvalidValueException(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }
}