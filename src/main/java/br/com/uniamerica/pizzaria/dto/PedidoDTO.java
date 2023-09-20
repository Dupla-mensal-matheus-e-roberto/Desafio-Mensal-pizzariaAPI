package br.com.uniamerica.pizzaria.dto;

import br.com.uniamerica.pizzaria.entity.Cliente;
import br.com.uniamerica.pizzaria.entity.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "Indentificador inválido")
    private Long idPedido;
    @NotNull(message = "data do pedido inválida")
    private LocalDateTime dataDoPedido;
    @NotNull(message = "status do pedido inválido")
    @NotBlank(message = "Campo de status não pode ser vazio")
    private String status;
    @NotNull(message = "cliente inválido")
    private Cliente cliente;
    @NotNull(message = "produtos inválido")
    @NotEmpty(message = "Produtos não pode ser vazio")
    private List<Produto> produtos;
}
