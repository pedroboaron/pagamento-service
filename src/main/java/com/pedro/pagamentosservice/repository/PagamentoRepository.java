package com.pedro.pagamentosservice.repository;

import com.pedro.pagamentosservice.model.Pagamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;



@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

    List<Pagamento> findAll();

    Page<Pagamento> findAll(Pageable pageable);

    @Query(
            value = "SELECT * FROM Pagamento x where x.id_user = :idUser",
            nativeQuery = true)
    List<Pagamento> findByIdUser(@Param("idUser") Integer idUser, Pageable pageable);

    @Query(
            value = "SELECT x.id_requisicao, x.aprovado, x.nsu, x.ticket, x.valor, x.id_cartao_usuario, x.id_user " +
                    "FROM Pagamento x left join cartao_usuario c on x.id_cartao_usuario = c.id " +
                    "where c.id_user = :idUser and c.id_cartao = :idCartao",
            nativeQuery = true)
    List<Pagamento> findByIdCartaoUsuario(@Param("idCartao") Integer idCartao, @Param("idUser") Integer idUser, Pageable pageable);
}
