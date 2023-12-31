package com.fincoop.associado.repository;

import com.fincoop.associado.model.Associado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AssociadoRepository extends JpaRepository<Associado, UUID> {
    Optional<Associado> findByDocumento(String documento);
}
