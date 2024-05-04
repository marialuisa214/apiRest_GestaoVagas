package br.com.malualves.gestao_vagas.modules.empresa.entidades;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity(name = "empresa")
@Data
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Length(min = 5, max = 20)
    private String nome;

    @NotBlank
    @Length(min = 5, max = 20)
    private String username;

    @Length(min = 5, max = 20)
    private String password;

    @Email
    private String email;
    private String description;
    @URL
    private String website;

    @CreationTimestamp
    private LocalDateTime createAT;

}
