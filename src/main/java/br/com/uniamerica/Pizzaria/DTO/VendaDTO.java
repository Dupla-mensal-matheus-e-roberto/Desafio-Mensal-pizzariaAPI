package br.com.uniamerica.Pizzaria.DTO;

import br.com.uniamerica.Pizzaria.Entity.Funcionario;
import br.com.uniamerica.Pizzaria.Entity.Pedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VendaDTO{
    private Long idVenda;
    private String tipoPagamento;
    private Pedido idPedido;
    private String tipoEntrega;
    private Funcionario idFuncionario;
}
