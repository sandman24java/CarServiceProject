package org.example.module3.layered.exception;

import org.example.module3.layered.exception.base.BaseErrorService;

public enum CarErrorEnum implements BaseErrorService {

    CAR_NOT_FOUND("CAR_NOT_FOUND-0001", "CAR_NOT_FOUND", 404);

    final String message;

    final int httpStatus;

    final String errorCode;

    CarErrorEnum(String errorCode, String message, int httpStatus) {
        this.errorCode = errorCode;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public int getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getErrorCode() {
        return errorCode;
    }
}
