package com.fincoop.associado.controller;

import com.fincoop.associado.dto.AssociadoDto;
import com.fincoop.associado.service.AssociadoService;
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

@RestController
@RequestMapping("/associados")
public class AssociadoController {

    @Autowired
    private AssociadoService service;

    @PostMapping()
    @Transactional
    public ResponseEntity<AssociadoDto> cadastrar(@RequestBody @Valid AssociadoDto dto,
                                                  UriComponentsBuilder uriBuilder) {
        AssociadoDto associadoSalvo = service.cadastrar(dto);

        URI endereco = uriBuilder.path("/associados/{uuid}").buildAndExpand(associadoSalvo.getUuid()).toUri();

        return ResponseEntity.created(endereco).body(associadoSalvo);
    }
}
