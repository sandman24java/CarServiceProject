package org.example.module3.layered.exception;

import lombok.Getter;
import org.example.module3.layered.exception.base.BaseErrorService;
import org.example.module3.layered.exception.base.BaseException;

import java.io.Serial;

/**
 * Exception class representing custom exceptions related to sample error cases.
 * Inherits from {@link BaseException}, allowing it to utilize error details
 * from {@link BaseErrorService} and optional additional arguments for flexible error message formatting.
 */
@Getter
public class AuthException extends BaseException {

    @Serial
    private static final long serialVersionUID = 2L;

    // 1. Этот конструктор ищет контроллер!
    // Он принимает наш Enum, так как тот реализует BaseErrorService
    public AuthException(BaseErrorService baseErrorService) {
        super(baseErrorService);
    }

    // 2. Для случаев с дополнительными аргументами
    public AuthException(BaseErrorService baseErrorService, Object... args) {
        super(baseErrorService, args);
    }

    // 3. Для случаев, когда нужно пробросить причину (Throwable)
    public AuthException(BaseErrorService baseErrorService, Throwable throwable, Object... args) {
        super(baseErrorService, throwable, args);
    }

}

