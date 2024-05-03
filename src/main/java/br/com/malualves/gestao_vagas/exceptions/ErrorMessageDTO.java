package br.com.malualves.gestao_vagas.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor // contrutor com argumentos
public class ErrorMessageDTO {
    private String mensagem;
    private String field;
}
