package br.com.uniamerica.pizzaria.dto;

import br.com.uniamerica.pizzaria.entity.Pedido;
import br.com.uniamerica.pizzaria.entity.Pizza;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private List<PizzaDTO> pizzas;
    @NotNull(message = "acompanhamentos inválidos")
    @NotBlank(message = "Campo acompanhamentos não pode ser vazio")
    private String acompanhamentos;
    @NotNull(message = "Campo preco não pode ser vazio")
    private Float preco;
    @JsonIgnore
    private List<PedidoDTO> pedido;
}
