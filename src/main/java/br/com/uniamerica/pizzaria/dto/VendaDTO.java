package br.com.uniamerica.pizzaria.dto;

import br.com.uniamerica.pizzaria.entity.Funcionario;
import br.com.uniamerica.pizzaria.entity.Pedido;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VendaDTO{
    @NotNull(message = "Indentificador inválido")
    private Long idVenda;
    @NotNull(message = "Tipo de pagamento inválido")
    @NotBlank(message = "Campo tipo de pagamento não ser vazio")
    private String tipoPagamento;
    @NotNull(message = "pedido inválido")
    private Pedido pedido;
    @NotNull(message = "Tipo de entrega inválida")
    @NotBlank(message = "Campo tipo entrega não pode ser vazio")
    private String tipoEntrega;
    @NotNull(message = "funcionario inválido")
    private Funcionario funcionario;
    @NotNull(message = "valor total inválido")
    private Float valorTotal;
}
