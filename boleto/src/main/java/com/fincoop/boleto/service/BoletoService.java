package com.fincoop.boleto.service;

import com.fincoop.boleto.dto.DadosEmissaoBoleto;
import com.fincoop.boleto.model.Boleto;
import com.fincoop.boleto.repository.BoletoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BoletoService {

    @Autowired
    private BoletoRepository repository;

    @Autowired
    private final ModelMapper modelMapper;

    @Transactional
    public UUID emitir(DadosEmissaoBoleto dto) {
        Boleto boleto = modelMapper.map(dto, Boleto.class);

        repository.save(boleto);

        return boleto.getUuid();
    }
}
