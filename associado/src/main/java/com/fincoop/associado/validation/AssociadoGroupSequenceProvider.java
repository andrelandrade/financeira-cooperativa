package com.fincoop.associado.validation;

import com.fincoop.associado.model.Associado;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;

public class AssociadoGroupSequenceProvider implements DefaultGroupSequenceProvider<Associado> {
    @Override
    public List<Class<?>> getValidationGroups(Associado associado) {
        List<Class<?>> groups = new ArrayList<>();
        groups.add(Associado.class);

        if (isAssociadoSelecionado(associado)) {
            groups.add(associado.getTipoPessoa().getGroup());
        }

        return groups;
    }

    private boolean isAssociadoSelecionado(Associado associadoDto) {
        return associadoDto != null && associadoDto.getTipoPessoa() != null;
    }
}
