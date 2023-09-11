package com.fincoop.boleto.repository;

import com.fincoop.boleto.model.Boleto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BoletoRepository extends JpaRepository<Boleto, UUID> {
}
