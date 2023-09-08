package com.fincoop.associado.dto;

import com.fincoop.associado.model.TipoPessoa;
import com.fincoop.associado.validation.AssociadoGroupSequenceProvider;
import com.fincoop.associado.validation.CnpjGroup;
import com.fincoop.associado.validation.CpfGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@GroupSequenceProvider(AssociadoGroupSequenceProvider.class)
public class AssociadoDto {
    private UUID uuid;

    @CPF(groups = CpfGroup.class, message = "CPF inválido")
    @CNPJ(groups = CnpjGroup.class, message = "CNPJ inválido")
    private String documento;

    @NotNull(message = "Tipo da pessoa é obrigatório")
    private TipoPessoa tipoPessoa;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;
}
