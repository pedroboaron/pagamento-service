package com.pedro.pagamentosservice.model;

import javax.persistence.*;

@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_requisicao", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Usuario user;

    @ManyToOne
    @JoinColumn(name = "id_cartao_usuario")
    private CartaoUsuario cartaoUsuario;

    @Column(name = "ticket", nullable = false)
    private String ticket;

    @Column(name = "valor", nullable = false)
    private Double valor;

    @Column(name = "nsu", nullable = false, unique = true)
    private Long nsu;

    @Column(name = "aprovado", nullable = false)
    private Boolean aprovado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Long getNsu() {
        return nsu;
    }

    public void setNsu(Long nsu) {
        this.nsu = nsu;
    }

    public Boolean getAprovado() {
        return aprovado;
    }

    public void setAprovado(Boolean aprovado) {
        this.aprovado = aprovado;
    }

    public CartaoUsuario getCartaoUsuario() {
        return cartaoUsuario;
    }

    public void setCartaoUsuario(CartaoUsuario cartaoUsuario) {
        this.cartaoUsuario = cartaoUsuario;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}
