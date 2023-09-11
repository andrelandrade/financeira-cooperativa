package com.fincoop.boleto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "boletos", uniqueConstraints = { @UniqueConstraint(columnNames = {"uuid", "associado"}) } )
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Boleto
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private UUID associado;
    private BigDecimal valor;
    private String documentoPagador;
    private String nomePagador;
    private String nomeFantasiaPagador;
    private String situacao;
}
