package com.mars.common.exception;

import com.mars.common.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NPGException.class)
    public ResponseEntity<Object> handleNPGException(NPGException exception) {
        if (exception.isMessageNotEmpty()) {
            log.warn("[{}] {}", exception.getNpgExceptionType().name(), exception.getMessage());
        }

        if (exception.isInternalServerError()) {
            log.error("Internal Server Error, type: {}", exception.getNpgExceptionType(), exception);
        }

        int httpStatus = exception.getNpgExceptionType().getHttpStatus().value();
        ResponseDto<String> responseDto = ResponseDto.of("", exception.getMessage());

        return ResponseEntity.status(httpStatus).body(responseDto);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
        HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        String message = ex.getBindingResult().getAllErrors().stream()
            .findFirst()
            .get().getDefaultMessage();

        return ResponseEntity.badRequest().body(ResponseDto.of("", message));
    }
}
