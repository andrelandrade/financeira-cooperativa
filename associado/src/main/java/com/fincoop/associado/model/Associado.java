package com.fincoop.associado.model;

import com.fincoop.associado.validation.AssociadoGroupSequenceProvider;
import com.fincoop.associado.validation.CnpjGroup;
import com.fincoop.associado.validation.CpfGroup;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import java.util.UUID;

@Entity
@Table(name = "associados")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@GroupSequenceProvider(AssociadoGroupSequenceProvider.class)
public class Associado {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @CPF(groups = CpfGroup.class, message = "CPF inválido")
    @CNPJ(groups = CnpjGroup.class, message = "CNPJ inválido")
    @Column(unique = true)
    private String documento;

    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;

    private String nome;
}
