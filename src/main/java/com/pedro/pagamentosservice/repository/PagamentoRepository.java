package com.pedro.pagamentosservice.repository;

import com.pedro.pagamentosservice.model.Pagamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

    List<Pagamento> findAll();

    Page<Pagamento> findAll(Pageable pageable);

    List<Pagamento> findByIdUser(Integer idUser, Pageable pageable);

    List<Pagamento> findByIdCartao(Long idCartao);

    List<Pagamento> findByIdCartaoAndIdUser(Integer idCartao, Integer idUser);
}
