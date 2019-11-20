package com.pedro.pagamentosservice.service;

import com.pedro.pagamentosservice.model.Pagamento;
import com.pedro.pagamentosservice.repository.PagamentoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService implements IPagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Override
    public Pagamento save(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    @Override
    public List<Pagamento> findByIdUser(Integer idUser, Pageable pageable) {
        return pagamentoRepository.findByIdUser(idUser,pageable);
    }

    @Override
    public List<Pagamento> findByIdCartaoUsuario(Integer idCartao, Integer idUser, Pageable pageable) {
        return pagamentoRepository.findByIdCartaoUsuario(idCartao,idUser,pageable);
    }

    @Transactional
    public Pagamento update(Integer id, Boolean status) throws Exception {
        Optional<Pagamento> retorno = this.pagamentoRepository.findById(id);

        if (!retorno.isPresent()) {
            throw new Exception("A requisição não existe" + id);
        }

        Pagamento pagamento = retorno.get();
        pagamento.setAprovado(status);
        BeanUtils.copyProperties(pagamento, pagamento, "id");

        return pagamentoRepository.save(pagamento);
    }


}
