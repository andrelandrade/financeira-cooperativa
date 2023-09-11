package com.fincoop.boleto.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DadosEmissaoBoleto {
    @NotNull
    private UUID associado;

    @Digits(integer = 10, fraction = 2)
    private BigDecimal valor;

    @NotBlank
    private String documentoPagador;

    @NotBlank
    private String nomePagador;

    private String nomeFantasiaPagador;
}
