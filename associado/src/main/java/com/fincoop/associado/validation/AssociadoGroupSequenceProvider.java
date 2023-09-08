package com.fincoop.associado.validation;

import com.fincoop.associado.dto.AssociadoDto;
import com.fincoop.associado.model.Associado;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;

public class AssociadoGroupSequenceProvider implements DefaultGroupSequenceProvider<AssociadoDto> {

    @Override
    public List<Class<?>> getValidationGroups(AssociadoDto associadoDto) {
        List<Class<?>> groups = new ArrayList<>();
        groups.add(AssociadoDto.class);

        if (isAssociadoSelecionado(associadoDto)) {
            groups.add(associadoDto.getTipoPessoa().getGroup());
        }

        return groups;
    }

    private boolean isAssociadoSelecionado(AssociadoDto associadoDto) {
        return associadoDto != null && associadoDto.getTipoPessoa() != null;
    }
}
