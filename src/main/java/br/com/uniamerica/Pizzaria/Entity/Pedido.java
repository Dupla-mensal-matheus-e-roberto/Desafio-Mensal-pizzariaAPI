package br.com.uniamerica.Pizzaria.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos", schema = "public")
@Getter
@Setter
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long idPedido;
    @Column(name = "data_do_pedido")
    private LocalDateTime dataDoPedido;
    @Column(name = "status")
    private String status;
    @Column(name = "id_cliente")
    private Long idCliente;
    @Column(name = "id_produto")
    private Long idProduto;

    public Pedido() {
    }

    public Pedido(Long idPedido, LocalDateTime dataDoPedido, String status, Long idCliente, Long idProduto) {
        this.idPedido = idPedido;
        this.dataDoPedido = LocalDateTime.now();
        this.status = status;
        this.idCliente = idCliente;
        this.idProduto = idProduto;
    }
}
