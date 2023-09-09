package com.fincoop.associado.service;

import com.fincoop.associado.dto.AlteraAssociadoDto;
import com.fincoop.associado.dto.AssociadoDto;
import com.fincoop.associado.model.Associado;
import com.fincoop.associado.repository.AssociadoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AssociadoService {
    @Autowired
    private AssociadoRepository repository;

    @Autowired
    private final ModelMapper modelMapper;

    @Transactional
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

    public AssociadoDto buscarPorId(UUID uuid) {
        var associado = buscaPorId(uuid);

        return modelMapper.map(associado, AssociadoDto.class);
    }

    @Transactional
    public void atualiza(AlteraAssociadoDto dto) {
        var associado = buscaPorId(dto.getUuid());

        modelMapper.map(dto, associado);

        repository.save(associado);
    }

    private Associado buscaPorId(UUID uuid) {
        return repository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Associado não encontrado"));
    }
}

