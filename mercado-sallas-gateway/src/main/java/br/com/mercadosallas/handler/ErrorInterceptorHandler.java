package br.com.mercadosallas.handler;

import br.com.mercadosallas.decode.CustomErrorDecoder;
import br.com.mercadosallas.handler.error.ErroDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorInterceptorHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(CustomErrorDecoder.ExceptionMessage.class)
    public ResponseEntity<ErroDto> handleException(CustomErrorDecoder.ExceptionMessage e) {
        return new ResponseEntity<>(new ErroDto(e.getStatus(), e.getError(), e.getMessage(), e.getPath()), HttpStatus.valueOf(e.getStatus()));
    }

}
