package com.pedro.pagamentosservice.controller;

import com.pedro.pagamentosservice.event.RecursoCriadoEvent;
import com.pedro.pagamentosservice.model.Pagamento;
import com.pedro.pagamentosservice.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping("/user")
    public ResponseEntity<List<Pagamento>> findByIdUser(@RequestParam("idUser") Integer idUser,
                                                        @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                                        @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(pagamentoService.findByIdUser(idUser, pageRequest));
    }

    @GetMapping("/cartao")
    public ResponseEntity<List<Pagamento>> findByIdCartao(@RequestParam("idUser") Integer idUser,
                                                          @RequestParam("idCartao") Integer idCartao,
                                                          @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                                          @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(pagamentoService.findByIdCartaoAndIdUser(idCartao, idUser, pageRequest));
    }

    @PostMapping
    public ResponseEntity<Pagamento> save(@Valid @RequestBody Pagamento pagamento, HttpServletResponse response) {
        Pagamento save = pagamentoService.save(pagamento);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, save.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }


    @PatchMapping
    public ResponseEntity<Pagamento> alterarStatus(@RequestParam("id") Integer id,
                                                   @RequestParam("aprovado") Boolean aprovado,
                                                   HttpServletResponse response) throws Exception {

        Pagamento save = this.pagamentoService.update(id, aprovado);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, save.getId()));
        return ResponseEntity.ok(save);
    }

}