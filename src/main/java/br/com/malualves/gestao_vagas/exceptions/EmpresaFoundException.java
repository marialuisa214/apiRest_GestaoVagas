package br.com.malualves.gestao_vagas.exceptions;

public class EmpresaFoundException extends RuntimeException {
    public EmpresaFoundException() {
        super("Empresa já existe");
    }
}
