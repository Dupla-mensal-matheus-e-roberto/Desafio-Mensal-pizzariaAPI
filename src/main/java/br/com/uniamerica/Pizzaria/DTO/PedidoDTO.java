package br.com.uniamerica.Pizzaria.DTO;

import br.com.uniamerica.Pizzaria.Entity.Cliente;
import br.com.uniamerica.Pizzaria.Entity.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO{
    private Long idPedido;
    private LocalDateTime dataDoPedido;
    private String status;
    private Cliente idCliente;
    private List<Produto> produtos;
}
