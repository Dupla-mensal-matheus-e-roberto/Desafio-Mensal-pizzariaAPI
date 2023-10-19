package br.com.uniamerica.pizzaria.dto;

import br.com.uniamerica.pizzaria.entity.Pedido;
import br.com.uniamerica.pizzaria.entity.Pizza;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO{
    @NotNull(message = "Indentificador inválido")
    private Long idProduto;
    @NotNull(message = "pizza inválida")
    private Pizza pizza;
    @NotNull(message = "acompanhamentos inválidos")
    @NotBlank(message = "Campo acompanhamentos não pode ser vazio")
    private String acompanhamentos;
    @NotNull(message = "pedido inválido")
    private List<PedidoDTO> pedido;
}
