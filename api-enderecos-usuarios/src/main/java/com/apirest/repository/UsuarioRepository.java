package com.apirest.repository;

import com.apirest.model.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
    Optional<UsuarioEntity> findByEmail(String email);
    Optional<UsuarioEntity> findByCpf(String cpf);
}
