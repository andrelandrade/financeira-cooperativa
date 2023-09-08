package com.fincoop.associado.service;

import com.fincoop.associado.dto.AssociadoDto;
import com.fincoop.associado.model.Associado;
import com.fincoop.associado.repository.AssociadoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssociadoService {
    @Autowired
    private AssociadoRepository repository;

    @Autowired
    private final ModelMapper modelMapper;

    public AssociadoDto cadastrar(AssociadoDto dto) {
        Associado associado = modelMapper.map(dto, Associado.class);

        repository.save(associado);

        return modelMapper.map(associado, AssociadoDto.class);
    }

    public AssociadoDto buscaPorDocumento(String documento) {
        Associado associado = repository.findByDocumento(documento)
                .orElseThrow(() -> new EntityNotFoundException("Associado não encontrado"));

        return modelMapper.map(associado, AssociadoDto.class);
    }
}

