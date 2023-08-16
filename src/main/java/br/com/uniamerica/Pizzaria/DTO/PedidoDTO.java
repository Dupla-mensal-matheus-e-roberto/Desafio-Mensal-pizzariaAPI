package br.com.uniamerica.Pizzaria.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
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
