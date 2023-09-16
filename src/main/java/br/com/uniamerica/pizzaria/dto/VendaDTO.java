package br.com.uniamerica.pizzaria.dto;

import br.com.uniamerica.pizzaria.entity.Funcionario;
import br.com.uniamerica.pizzaria.entity.Pedido;
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
