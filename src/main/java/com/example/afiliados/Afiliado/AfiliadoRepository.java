package com.example.afiliados.Afiliado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AfiliadoRepository extends JpaRepository<Afiliado, Long> {

    Optional<Afiliado> findAfiliadoByDocumento(String documento);

    Optional<Afiliado> findById(Long id);
}
