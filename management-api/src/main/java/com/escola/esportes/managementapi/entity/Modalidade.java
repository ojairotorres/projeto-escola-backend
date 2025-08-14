package com.escola.esportes.managementapi.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_modalidade")
public class Modalidade extends PanacheEntityBase {

    @Id
    @SequenceGenerator(name = "modalidade_seq", sequenceName = "modalidade_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modalidade_seq")
    public Long id;

    @NotBlank
    @Size(min = 3, max = 100)
    @Column(name = "nome", nullable = false, length = 100)
    public String nome;

    @NotNull
    @DecimalMin("0.0")
    @Column(name = "valor_mensalidade", nullable = false, precision = 10, scale = 2)
    public BigDecimal valorMensalidade;
}