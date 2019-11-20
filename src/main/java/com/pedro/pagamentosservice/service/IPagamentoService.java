package com.pedro.pagamentosservice.service;

import com.pedro.pagamentosservice.model.Pagamento;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPagamentoService {

    Pagamento save(Pagamento pagamento);

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
