package com.Main.global.error.exception;

import com.Main.global.error.code.BaseErrorCode;
import com.Main.global.error.dto.ErrorReasonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {
    private BaseErrorCode baseErrorCode;

    public ErrorReasonDto getErrorReason() {
        return this.baseErrorCode.getReason();
    }

    public ErrorReasonDto getErrorReasonHttpStatus() {
        return this.baseErrorCode.getReasonHttpStatus();
    }
}
