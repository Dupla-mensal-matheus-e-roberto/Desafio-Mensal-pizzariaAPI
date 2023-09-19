package br.com.uniamerica.pizzaria;

import br.com.uniamerica.pizzaria.controller.ClienteController;
import br.com.uniamerica.pizzaria.controller.FuncionarioController;
import br.com.uniamerica.pizzaria.controller.PedidoController;
import br.com.uniamerica.pizzaria.dto.ClienteDTO;
import br.com.uniamerica.pizzaria.dto.FuncionarioDTO;
import br.com.uniamerica.pizzaria.dto.PedidoDTO;
import br.com.uniamerica.pizzaria.entity.*;
import br.com.uniamerica.pizzaria.repository.ClienteRepository;
import br.com.uniamerica.pizzaria.repository.FuncionarioRepository;
import br.com.uniamerica.pizzaria.repository.PedidoRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
	PedidoController pedidoControler;

	@BeforeEach
	void injectData(){
		List<Pedido> pedidos = new ArrayList<>();
		List<Venda> vendas = new ArrayList<>();
		List<Produto> produtos = new ArrayList<>();

		Cliente cliente = new Cliente(1L, "Cliente", "endereco 1", "login", "senha", pedidos);
		Cliente cliente2 = new Cliente(2L, "Cliente2", "endereco 1", "login", "senha",pedidos);

		Funcionario funcionario = new Funcionario(1L, "funcionario", "login", "senha",vendas);
		Funcionario funcionario2 = new Funcionario(2L, "funcionario", "login", "senha",vendas);

		Pedido pedido = new Pedido(1L, LocalDateTime.now(), "Preparando", cliente, produtos, vendas );
		Pedido pedido2 = new Pedido(2L, LocalDateTime.now(), "Preparando", cliente, produtos, vendas );


		// Cliente
		Mockito.when(clienteRepository.save(cliente)).thenReturn(cliente);
		Mockito.when(clienteRepository.save(cliente2)).thenReturn(cliente2);
		//Mockito.when(clienteRepository.save(cliente3)).thenReturn(cliente3);
		Mockito.when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

		//Funcionario
		Mockito.when(funcionarioRepository.save(funcionario)).thenReturn(funcionario);
		Mockito.when(funcionarioRepository.save(funcionario2)).thenReturn(funcionario2);
		//Mockito.when(funcionarioRepository.save(funcionario3)).thenReturn(funcionario3);
		Mockito.when(funcionarioRepository.findById(1L)).thenReturn(Optional.of(funcionario));

		//Pedido
		Mockito.when(pedidoRepository.save(pedido)).thenReturn(pedido);
		Mockito.when(pedidoRepository.save(pedido2)).thenReturn(pedido2);
		Mockito.when(pedidoRepository.findById(1L)).thenReturn(Optional.of(pedido));
		// Pizza

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
	void testePedidoCriar(){
		List<Produto> produtos = new ArrayList<>();
		List<Pedido> pedidos = new ArrayList<>();
		Cliente cliente = new Cliente(1L, "Cliente", "endereco 1", "login", "senha", pedidos);
		var pedido = pedidoControler.criar(new PedidoDTO(1L, LocalDateTime.now(), "Preparando", cliente, produtos));
		Assert.assertEquals("Pedido cadastrado com sucesso", pedido.getBody());
	}

	@Test
	void testePedidoEditar(){
		List<Pedido> pedidos = new ArrayList<>();
		List<Produto> produtos = new ArrayList<>();
		Cliente cliente = new Cliente(1L, "Cliente", "endereco 1", "login", "senha", pedidos);
		var pedido = pedidoControler.editar(new PedidoDTO(1L, LocalDateTime.now(), "Preparando", cliente, produtos), 1L);
		Assert.assertEquals("Pedido editado com sucesso", pedido.getBody());
	}

	@Test
	void testePedidoDeletar(){
		var pedido = pedidoControler.deletar(2L);
		Assert.assertEquals("Pedido deletado com sucesso", pedido.getBody());
	}

	void testePedidoFindById(){}


}
