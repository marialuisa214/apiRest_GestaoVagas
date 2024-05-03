package br.com.malualves.gestao_vagas.modules.candidato;

import lombok.Data;
import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

@Data //adicioona getter e setter para todos
public class Candidato {
    private UUID id;
    private String nome;
    @Pattern(regexp = "^(?!\\s*$).+", message = "O campo username não deve conter espaço") 
    private String username;
    @Length(min = 8, max=20)
    private String senha;
    @Email(message = "O campo e-mail deve conter um campo valido")
    private String email;
    private String descricao;
    private String curriculo;

}
