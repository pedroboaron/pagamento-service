package com.pedro.pagamentosservice.repository;

import com.pedro.pagamentosservice.model.CartaoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoUsuarioRepository extends JpaRepository<CartaoUsuario, Integer> {
}
