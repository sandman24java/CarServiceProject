package org.example.carservice.exception;

import lombok.Getter;
import org.example.carservice.exception.base.BaseException;
import org.example.carservice.exception.base.BaseErrorService;


@Getter
public class CarException extends BaseException {

    private static final long serialVersionUID = 1L;

    public CarException(BaseErrorService baseErrorService, Throwable throwable, Object... args) {
        super((BaseErrorService) baseErrorService, throwable, args);
    }

    public CarException(BaseErrorService baseErrorService, Object... args) {
        super((BaseErrorService) baseErrorService, args);
    }
}
