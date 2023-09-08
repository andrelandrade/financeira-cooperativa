package com.fincoop.associado.dto;

import com.fincoop.associado.model.TipoPessoa;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AssociadoDto {
    private UUID uuid;
    private String documento;
    private TipoPessoa tipoPessoa;
    private String nome;
}
