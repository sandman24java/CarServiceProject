package org.example.module3.lesson3.ExceptionHandlerBasics;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value={UnsupportedOperationException.class})
    public ResponseEntity<String> handleSpecificException(Exception e, WebRequest request){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(value={Exception.class})
    public ResponseEntity<String> handleGlobalException(Exception e, WebRequest request){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
/**
 * Этот конкретный метод сработает только если где-то в коде выскочит UnsupportedOperationException.
    @ExceptionHandler(value={UnsupportedOperationException.class})
 Если упадет другая ошибка (например, NullPointerException), этот метод её проигнорирует.
    Spring работает по принципу «наиболее точного совпадения» (The Most Specific Match).
    Он смотрит на иерархию классов исключений:
    UnsupportedOperationException — это конкретный диагноз.
    Exception — это общая фраза «что-то пошло не так».
    Spring всегда отдаст приоритет тому методу, который работает с более узким (дочерним) классом.
    Только если для упавшей ошибки не нашлось «личного» обработчика,
    запрос пойдет в «общий» (handleGlobalException).
 */