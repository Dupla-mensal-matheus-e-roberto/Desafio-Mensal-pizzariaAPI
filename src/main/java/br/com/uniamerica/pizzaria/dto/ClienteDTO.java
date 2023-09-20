package br.com.uniamerica.pizzaria.dto;

import br.com.uniamerica.pizzaria.entity.Pedido;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
public class ClienteDTO {
    @NotNull(message = "Indentificador inválido")
    private Long idCliente;
    @NotNull(message = "Nome inválido")
    @NotBlank(message = "Campo nome não pode ser vazio")
    private String nome;
    @NotNull(message = "Endereço inválido")
    @NotBlank(message = "Campo de endereço não pode ser vazio")
    private String endereco;
    @NotNull(message = "Username inválido")
    @NotBlank(message = "Campo de username não pode ser vazio")
    private String username;
    @NotNull(message = "Senha inválida")
    @NotBlank(message = "Campo de senha não pode ser vazia")
    private String senha;
    @NotNull(message = "pedidos inválidos")
    @NotEmpty(message = "pedidos não podem ser vazios")
    private List<Pedido> pedidos;
}
