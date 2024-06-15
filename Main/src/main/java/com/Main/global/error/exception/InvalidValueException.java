package com.Main.global.error.exception;


import com.Main.global.error.status.ErrorCode;
import com.Main.global.error.status.ErrorStatus;

public class InvalidValueException extends BusinessException {
    public InvalidValueException(ErrorStatus invalidTeamtype) {
        super(ErrorCode.BAD_REQUEST);
    }

    public InvalidValueException(ErrorCode errorCode) {
        super(errorCode);
    }
}
