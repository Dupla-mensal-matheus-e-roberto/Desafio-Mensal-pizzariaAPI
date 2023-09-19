package br.com.uniamerica.pizzaria;

import br.com.uniamerica.pizzaria.controller.ClienteController;
import br.com.uniamerica.pizzaria.controller.FuncionarioController;
import br.com.uniamerica.pizzaria.controller.PedidoController;
import br.com.uniamerica.pizzaria.controller.PizzaController;
import br.com.uniamerica.pizzaria.dto.ClienteDTO;
import br.com.uniamerica.pizzaria.dto.FuncionarioDTO;
import br.com.uniamerica.pizzaria.dto.PedidoDTO;
import br.com.uniamerica.pizzaria.dto.PizzaDTO;
import br.com.uniamerica.pizzaria.entity.*;
import br.com.uniamerica.pizzaria.repository.ClienteRepository;
import br.com.uniamerica.pizzaria.repository.FuncionarioRepository;
import br.com.uniamerica.pizzaria.repository.PedidoRepository;
import br.com.uniamerica.pizzaria.repository.PizzaRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class PizzariaApplicationTests {

	@MockBean
	ClienteRepository clienteRepository;
	@Autowired
	ClienteController clienteController;
	@MockBean
	FuncionarioRepository funcionarioRepository;
	@Autowired
	FuncionarioController funcionarioController;
	@MockBean
	PedidoRepository pedidoRepository;
	@Autowired
	PedidoController pedidoController;
	@MockBean
	PizzaRepository pizzaRepository;
	@Autowired
	PizzaController pizzaController;

	@BeforeEach
	void injectData(){
		List<Pedido> pedidos = new ArrayList<>();
		List<Venda> vendas = new ArrayList<>();
		List<Produto> produtos = new ArrayList<>();

		Produto produto = new Produto();

		Cliente cliente = new Cliente(1L, "Cliente", "endereco 1", "login", "senha", pedidos);
		Cliente cliente2 = new Cliente(2L, "Cliente2", "endereco 1", "login", "senha",pedidos);

		Funcionario funcionario = new Funcionario(1L, "funcionario", "login", "senha",vendas);
		Funcionario funcionario2 = new Funcionario(2L, "funcionario", "login", "senha",vendas);

		Pedido pedido = new Pedido(1L, LocalDateTime.now(), "Preparando", cliente, produtos, vendas );
		Pedido pedido2 = new Pedido(2L, LocalDateTime.now(), "Preparando", cliente, produtos, vendas );

		Pizza pizza = new Pizza(1L, "Ca two piri", "BIG", "Nenhum", "Nenhum", produto);
		Pizza pizza2 = new Pizza(2L, "Ca two piri", "BIG", "Nenhum", "Nenhum", produto);

		// Cliente
		Mockito.when(clienteRepository.save(cliente)).thenReturn(cliente);
		Mockito.when(clienteRepository.save(cliente2)).thenReturn(cliente2);
		//Mockito.when(clienteRepository.save(cliente3)).thenReturn(cliente3);
		Mockito.when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

		//Funcionario
		Mockito.when(funcionarioRepository.save(funcionario)).thenReturn(funcionario);
		Mockito.when(funcionarioRepository.save(funcionario2)).thenReturn(funcionario2);
		Mockito.when(funcionarioRepository.findById(1L)).thenReturn(Optional.of(funcionario));

		//Pedido
		Mockito.when(pedidoRepository.save(pedido)).thenReturn(pedido);
		Mockito.when(pedidoRepository.save(pedido2)).thenReturn(pedido2);
		Mockito.when(pedidoRepository.findById(1L)).thenReturn(Optional.of(pedido));

		// Pizza
		Mockito.when(pizzaRepository.save(pizza)).thenReturn(pizza);
		Mockito.when(pizzaRepository.save(pizza2)).thenReturn(pizza2);
		Mockito.when(pizzaRepository.findById(1L)).thenReturn(Optional.of(pizza));

		// Produto

		// Venda

	}



	@Test
	void testClienteCriar(){
		var cliente = clienteController.createClient(new ClienteDTO(1L, "Cliente", "endereco 1","login", "senha"));
		Assert.assertEquals("Cliente criado com sucesso!", cliente.getBody());
	}

	@Test
	void testClienteEditar(){
		var cliente = clienteController.updateClient(1L, new ClienteDTO(1L, "Pedro", "endereco 1","login", "senha"));
		Assert.assertEquals("Cliente editado com sucesso", cliente.getBody());
	}

	@Test
	void testClienteDeletar(){
		var cliente = clienteController.deleteClient(2L);
		Assert.assertEquals("Cliente deletado com sucesso", cliente.getBody());
	}

	@Test
	void testClienteFindById(){
		clienteController.createClient(new ClienteDTO(1L, "cliente", "endereco", "login", "senha"));
		var cliente = clienteController.findById(1L);
		Assert.assertEquals(cliente.getBody().getNome(), clienteController.findById(1L).getBody().getNome());
	}

	@Test
	void testFuncionarioCriar(){
		List<Venda> vendas = new ArrayList<>();
		var funcionario = funcionarioController.createFuncionario(new FuncionarioDTO(1L, "funcionario", "login", "senha", vendas));
		Assert.assertEquals("Funcionario criado com sucesso!", funcionario.getBody());
	}

	@Test
	void testFuncionarioEditar(){
		List<Venda> vendas = new ArrayList<>();
		var funcionario = funcionarioController.updateFuncionario(1L, new FuncionarioDTO(1L, "funcionario", "login", "senha", vendas));
		Assert.assertEquals("Funcionario editado com sucesso!", funcionario.getBody());
	}

	@Test
	void testFuncionarioDeletar(){
		var funcionario = funcionarioController.deleteFuncionario(2L);
		Assert.assertEquals("Funcionario deletado com sucesso", funcionario.getBody());
	}

	@Test
	void testFuncionarioFindById(){
		List<Venda> vendas = new ArrayList<>();
		funcionarioController.createFuncionario(new FuncionarioDTO(1L, "funcionario", "login", "senha", vendas));
		var funcionario = funcionarioController.findById(1L);
		Assert.assertEquals(funcionario.getBody().getNome(), funcionarioController.findById(1L).getBody().getNome());
	}

	@Test
	void testPedidoCriar(){
		List<Produto> produtos = new ArrayList<>();
		List<Pedido> pedidos = new ArrayList<>();
		Cliente cliente = new Cliente(1L, "Cliente", "endereco 1", "login", "senha", pedidos);
		var pedido = pedidoController.criar(new PedidoDTO(1L, LocalDateTime.now(), "Preparando", cliente, produtos));
		Assert.assertEquals("Pedido cadastrado com sucesso", pedido.getBody());
	}

	@Test
	void testPedidoEditar(){
		List<Pedido> pedidos = new ArrayList<>();
		List<Produto> produtos = new ArrayList<>();
		Cliente cliente = new Cliente(1L, "Cliente", "endereco 1", "login", "senha", pedidos);
		var pedido = pedidoController.editar(new PedidoDTO(1L, LocalDateTime.now(), "Preparando", cliente, produtos), 1L);
		Assert.assertEquals("Pedido editado com sucesso", pedido.getBody());
	}

	@Test
	void testPedidoDeletar(){
		var pedido = pedidoController.deletar(1L);
		Assert.assertEquals("Pedido deletado com sucesso", pedido.getBody());
	}

	@Test
	void testPedidoFindById(){

		List<Pedido> pedidos = new ArrayList<>();
		List<Produto> produtos = new ArrayList<>();
		Cliente cliente = new Cliente(1L, "Cliente", "endereco 1", "login", "senha", pedidos);
		pedidoController.criar(new PedidoDTO(1L, LocalDateTime.now(), "Preparando", cliente, produtos));

		var pedido_encontrado = pedidoController.findById(1L);
		Assert.assertEquals(pedido_encontrado.getBody().getIdPedido(), pedidoController.findById(1L).getBody().getIdPedido());
	}

	@Test
	void testPizzaCriar(){
		var pizza = pizzaController.criar(new PizzaDTO(1L, "Ca two piri", "BIG", "Nenhum", "Nenhum"));
		Assert.assertEquals("Pizza cadastrada com sucesso", pizza.getBody());
	}
	@Test
	void testPizzaEditar(){
		var pizza = pizzaController.editar(new PizzaDTO(1L, "Ca ONE piri", "BIG", "Nenhum", "Nenhum"), 1L);
		Assert.assertEquals("Pizza editada com sucesso", pizza.getBody());
	}

	@Test
	void testPizzaDeletar(){
		var pizza = pizzaController.deletar(1L);
		Assert.assertEquals("Pizza deletada com sucesso", pizza.getBody());
	}

	@Test
	void testPizzaFindById(){
		pizzaController.criar(new PizzaDTO(1L, "Ca Three piri", "BIG", "Nenhum", "Nenhum"));
		var pizza = pizzaController.findById(1L);

		Assert.assertEquals(pizza.getBody().getIdPizza(), pizza.getBody().getIdPizza());
	}


}
