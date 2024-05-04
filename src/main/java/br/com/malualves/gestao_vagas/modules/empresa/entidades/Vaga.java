package br.com.malualves.gestao_vagas.modules.empresa.entidades;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity(name = "vaga")
@Data
public class Vaga {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String cargo; // UI/UX, PROGRAMADOR
    private String tipoTrabalho; // remoto, PRESENCIAL...
    private String level; // junior, senior
    private String descricao;

    @ManyToOne() // muitas vagas para uma empresa
    @JoinColumn(name = "empresa_id", insertable = false, updatable = false) // avisar que não é um campo da tabela
    private Empresa empresa;

    // informar o relacionamento com empresa 1:n
    // empresaId FK
    @Column(name = "empresa_id", nullable = false)
    private UUID empresaId;

    @CreationTimestamp
    private LocalDateTime creatAt;

}
