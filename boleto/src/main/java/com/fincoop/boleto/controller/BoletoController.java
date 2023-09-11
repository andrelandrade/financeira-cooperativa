package com.fincoop.boleto.controller;

import com.fincoop.boleto.dto.DadosEmissaoBoleto;
import com.fincoop.boleto.model.Boleto;
import com.fincoop.boleto.service.BoletoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/boletos")
public class BoletoController {

    @Autowired
    private BoletoService service;

    @PostMapping()
    @Transactional()
    public ResponseEntity<UUID> emitir(@RequestBody @Valid DadosEmissaoBoleto dto,
                                       UriComponentsBuilder uriBuilder) {
        UUID boletoId = service.emitir(dto);

        URI endereco = uriBuilder.path("/boletos/{uuid}").buildAndExpand(boletoId).toUri();

        return ResponseEntity.created(endereco).body(boletoId);
    }
}
