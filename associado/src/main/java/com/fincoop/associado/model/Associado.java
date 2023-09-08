package com.fincoop.associado.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "associados")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Associado {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @NotEmpty
    @Column(unique = true)
    private String documento;

    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;

    @NotEmpty
    private String nome;
}
