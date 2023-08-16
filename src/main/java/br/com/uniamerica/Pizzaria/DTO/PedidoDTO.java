package br.com.uniamerica.Pizzaria.DTO;

import java.time.LocalDateTime;

public class PedidoDTO{
    private Long idPedido;
    private LocalDateTime dataDoPedido;
    private String status;
    private Long idCliente;
    private Long idProduto;

    public PedidoDTO() {
    }

    public PedidoDTO(Long idPedido, LocalDateTime dataDoPedido, String status, Long idCliente, Long idProduto) {
        this.idPedido = idPedido;
        this.dataDoPedido = dataDoPedido;
        this.status = status;
        this.idCliente = idCliente;
        this.idProduto = idProduto;
    }
}
