package br.com.malualves.gestao_vagas.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // classe global que fornece o tratamento da excessão
public class ExceptionHandlerController {

    private MessageSource messageSorce;

    public ExceptionHandlerController(MessageSource mensagem) {
        this.messageSorce = mensagem; // ao inicializar esse controler é preciso garantir que messageSorce seja nulo.
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorMessageDTO>> handleMethodArgumentException(MethodArgumentNotValidException e) {
        List<ErrorMessageDTO> dto = new ArrayList<>();
        e.getBindingResult().getFieldErrors().forEach(erro -> {

            String message = messageSorce.getMessage(erro, LocaleContextHolder.getLocale());

            ErrorMessageDTO mensagemErro = new ErrorMessageDTO(message, erro.getField());
            dto.add(mensagemErro);
        });
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);

    }

}
