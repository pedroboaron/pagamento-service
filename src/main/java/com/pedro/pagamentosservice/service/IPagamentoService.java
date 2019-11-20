package com.pedro.pagamentosservice.service;

import com.pedro.pagamentosservice.model.Pagamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IPagamentoService {

    List<Pagamento> findAll();

    Page<Pagamento> findAll(Pageable pageable);

    Pagamento save(Pagamento pagamento);

    Pagamento update(Integer id, Boolean status) throws Exception;

    List<Pagamento> findByIdUser(Integer idUser, Pageable pageable);

    List<Pagamento> findByIdCartao(Long idCartao);

    List<Pagamento> findByIdCartaoAndIdUser(Integer idCartao, Integer idUser, Pageable pageable);
}
