package org.example.module3.layered.exception;

import lombok.Getter;
import org.example.module3.layered.exception.base.BaseErrorService;


@Getter
public class CarException extends org.example.module3.layered.exception.base.BaseException {

    private static final long serialVersionUID = 1L;

    public CarException(BaseErrorService baseErrorService, Throwable throwable, Object... args) {
        super((BaseErrorService) baseErrorService, throwable, args);
    }

    public CarException(BaseErrorService baseErrorService, Object... args) {
        super((BaseErrorService) baseErrorService, args);
    }
}
