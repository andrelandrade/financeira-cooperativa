package com.fincoop.associado.dto;

import com.fincoop.associado.model.TipoPessoa;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlteraAssociadoDto {

        @NotNull
        private UUID uuid;
        private String documento;
        private TipoPessoa tipoPessoa;
        private String nome;
}