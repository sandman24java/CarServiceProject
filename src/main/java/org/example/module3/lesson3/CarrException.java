package org.example.module3.lesson3;

import lombok.Getter;
import org.example.module3.lesson3.base.BaseErrorrService;
import org.example.module3.lesson3.base.BaseeException;

/**
 * Exception class representing custom exceptions related to sample error cases.
 * Inherits from {@link BaseeException}, allowing it to utilize error details
 * from {@link BaseErrorrService} and optional additional arguments for flexible error message formatting.
 */
@Getter
public class CarrException extends BaseeException {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor for {@link CarrException} with a throwable and additional arguments.
     *
     * @param baseErrorService The error service providing error details.
     * @param throwable        The root cause of the exception.
     * @param args             Additional arguments for the error.
     */
    public CarrException(BaseErrorrService baseErrorService, Throwable throwable, Object... args) {
        super(baseErrorService, throwable, args);
    }

    /**
     * Constructor for {@link CarrException} with additional arguments.
     *
     * @param baseErrorService The error service providing error details.
     * @param args             Additional arguments for the error.
     */
    public CarrException(BaseErrorrService baseErrorService, Object... args) {
        super(baseErrorService, args);
    }
}

