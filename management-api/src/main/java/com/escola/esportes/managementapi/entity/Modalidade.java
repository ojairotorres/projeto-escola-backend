package com.escola.esportes.managementapi.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.escola.esportes.managementapi.entity.Genero;
import com.escola.esportes.managementapi.entity.Nivel;

@Entity
@Table(name = "tb_modalidade")
public class Modalidade extends PanacheEntityBase {

    @Id
    @SequenceGenerator(name = "modalidade_seq", sequenceName = "modalidade_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modalidade_seq")
    public Long id;

    @NotBlank(message = "O nome não pode ser vazio.")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
    @Column(name = "nome", nullable = false, length = 100)
    public String nome;

    @Column(name = "descricao")
    public String descricao;

    @NotNull(message = "O status de ativação é obrigatório.")
    @Column(name = "modalidade_ativa", nullable = false)
    public Boolean modalidadeAtiva;

    @NotNull(message = "O valor da mensalidade é obrigatório.")
    @DecimalMin(value = "0.0", message = "O valor deve ser maior ou igual a zero.")
    @Column(name = "valor_mensalidade", nullable = false, precision = 10, scale = 2)
    public BigDecimal valorMensalidade;

    @NotNull(message = "A duração da aula é obrigatória.")
    @Min(value = 1, message = "A duração da aula deve ser no mínimo 1 minuto.")
    @Column(name = "duracao_aula_minutos", nullable = false)
    public Integer duracaoAulaMinutos;

    @NotNull(message = "A idade mínima é obrigatória.")
    @Min(value = 0, message = "A idade mínima deve ser maior ou igual a zero.")
    @Column(name = "idade_minima", nullable = false)
    public Integer idadeMinima;

    @NotNull(message = "A idade máxima é obrigatória.")
    @Min(value = 0, message = "A idade máxima deve ser maior ou igual a zero.")
    @Column(name = "idade_maxima", nullable = false)
    public Integer idadeMaxima;

    @NotNull(message = "A capacidade máxima é obrigatória.")
    @Min(value = 1, message = "A capacidade máxima deve ser no mínimo 1.")
    @Column(name = "capacidade_maxima_alunos", nullable = false)
    public Integer capacidadeMaximaAlunos;

    @NotNull(message = "O gênero permitido é obrigatório.")
    @Enumerated(EnumType.STRING)
    @Column(name = "genero_permitido", nullable = false)
    public Genero generoPermitido;

    @NotNull(message = "O nível é obrigatório.")
    @Enumerated(EnumType.STRING)
    @Column(name = "nivel", nullable = false)
    public Nivel nivel;

    @NotNull(message = "A data de criação é obrigatória.")
    @Column(name = "data_criacao", nullable = false)
    public LocalDate dataCriacao;
}