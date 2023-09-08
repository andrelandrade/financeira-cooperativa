package com.fincoop.associado.model;

import com.fincoop.associado.validation.CnpjGroup;
import com.fincoop.associado.validation.CpfGroup;
import lombok.Getter;

@Getter
public enum TipoPessoa {
    PF(CpfGroup.class),
    PJ(CnpjGroup.class);

    private final Class<?> group;

    private TipoPessoa(Class<?> group) {
        this.group = group;
    }
}
