package br.com.uniamerica.pizzaria;

import br.com.uniamerica.pizzaria.controller.*;
import br.com.uniamerica.pizzaria.dto.*;
import br.com.uniamerica.pizzaria.entity.*;
import br.com.uniamerica.pizzaria.repository.*;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.security.ProtectionDomain;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
	@MockBean
	ProdutoRepository produtoRepository;
	@Autowired
	ProdutoController produtoController;
	@MockBean
	VendaRepository vendaRepository;
	@Autowired
	VendaController vendaController;

	@BeforeEach
	void injectData(){
		List<Pedido> pedidos = new ArrayList<>();
		List<Venda> vendas = new ArrayList<>();
		List<Produto> produtos = new ArrayList<>();

		Produto produto = new Produto();

		Cliente cliente = new Cliente(1L, "Cliente", "endereco 1", "login", "senha", pedidos);
		Cliente cliente2 = new Cliente(2L, "Cliente2", "endereco 1", "login", "senha",pedidos);
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente);
		clientes.add(cliente2);

		Funcionario funcionario = new Funcionario(1L, "funcionario", "login", "senha",vendas);
		Funcionario funcionario2 = new Funcionario(2L, "funcionario", "login", "senha",vendas);
		List<Funcionario> funcionarios = new ArrayList<>();
		funcionarios.add(funcionario);
		funcionarios.add(funcionario2);

		Pedido pedido = new Pedido(1L, LocalDateTime.now(), "Preparando", cliente, produtos, vendas );
		Pedido pedido2 = new Pedido(2L, LocalDateTime.now(), "Preparando", cliente, produtos, vendas );
		List<Pedido> pedidoss = new ArrayList<>();
		pedidoss.add(pedido);
		pedidoss.add(pedido2);

		Pizza pizza = new Pizza(1L, "Ca two piri", "BIG", "Nenhum", "Nenhum", produto);
		Pizza pizza2 = new Pizza(2L, "Ca two piri", "BIG", "Nenhum", "Nenhum", produto);
		List<Pizza> pizzas = new ArrayList<>();
		pizzas.add(pizza);
		pizzas.add(pizza2);

		Produto meuProduto = new Produto(1L, pizza2,"Kerischuque", pedido);
		Produto meuProduto2 = new Produto(2L, pizza2,"Kerischuque", pedido);
		List<Produto> produtoss = new ArrayList<>();
		produtoss.add(meuProduto);
		produtoss.add(meuProduto2);

		Venda venda = new Venda(1L, "Fiado", pedido, "Motofrete", funcionario);
		Venda venda2 = new Venda(2L, "Fiado", pedido, "Motofrete", funcionario);
		List<Venda> vendass = new ArrayList<>();
		vendass.add(venda);
		vendass.add(venda2);

		// Cliente
		Mockito.when(clienteRepository.save(cliente)).thenReturn(cliente);
		Mockito.when(clienteRepository.save(cliente2)).thenReturn(cliente2);
		Mockito.when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));
		Mockito.when(clienteRepository.findAll()).thenReturn(clientes);

		//Funcionario
		Mockito.when(funcionarioRepository.save(funcionario)).thenReturn(funcionario);
		Mockito.when(funcionarioRepository.save(funcionario2)).thenReturn(funcionario2);
		Mockito.when(funcionarioRepository.findById(1L)).thenReturn(Optional.of(funcionario));
		Mockito.when(funcionarioRepository.findAll()).thenReturn(funcionarios);

		//Pedido
		Mockito.when(pedidoRepository.save(pedido)).thenReturn(pedido);
		Mockito.when(pedidoRepository.save(pedido2)).thenReturn(pedido2);
		Mockito.when(pedidoRepository.findById(1L)).thenReturn(Optional.of(pedido));
		Mockito.when(pedidoRepository.findAll()).thenReturn(pedidoss);

		// Pizza
		Mockito.when(pizzaRepository.save(pizza)).thenReturn(pizza);
		Mockito.when(pizzaRepository.save(pizza2)).thenReturn(pizza2);
		Mockito.when(pizzaRepository.findById(1L)).thenReturn(Optional.of(pizza));
		Mockito.when(pizzaRepository.findAll()).thenReturn(pizzas);

		// Produto

		Mockito.when(produtoRepository.save(meuProduto)).thenReturn(meuProduto);
		Mockito.when(produtoRepository.save(meuProduto2)).thenReturn(meuProduto2);
		Mockito.when(produtoRepository.findById(1L)).thenReturn(Optional.of(meuProduto));
		Mockito.when(produtoRepository.findAll()).thenReturn(produtoss);

		// Venda

		Mockito.when(vendaRepository.save(venda)).thenReturn(venda);
		Mockito.when(vendaRepository.save(venda2)).thenReturn(venda2);
		Mockito.when(vendaRepository.findById(1L)).thenReturn(Optional.of(venda));
		Mockito.when(vendaRepository.findAll()).thenReturn(vendass);
	}



	@Test
	void AtestClienteCriar(){
		List<Pedido> pedidos = new ArrayList<>();
		var cliente = clienteController.createClient(new ClienteDTO(1L, "Cliente", "endereco 1","login", "senha", pedidos));
		Assert.assertEquals("Cliente criado com sucesso!", cliente.getBody());
	}

	@Test
	void BtestClienteEditar(){
		List<Pedido> pedidos = new ArrayList<>();
		var cliente = clienteController.updateClient(1L, new ClienteDTO(1L, "Pedro", "endereco 1","login", "senha", pedidos));
		Assert.assertEquals("Cliente editado com sucesso", cliente.getBody());
	}

	@Test
	void DtestClienteDeletar(){
		var cliente = clienteController.deleteClient(2L);
		Assert.assertEquals("Cliente deletado com sucesso", cliente.getBody());
	}

	@Test
	void CtestClienteFindById(){
		List<Pedido> pedidos = new ArrayList<>();
		clienteController.createClient(new ClienteDTO(1L, "Cliente", "endereco", "login", "senha", pedidos));
		var cliente = clienteController.findById(1L);
		Assert.assertEquals("Cliente", cliente.getBody().getNome());
	}

	@Test
	void CtestClienteFindAll(){
		List<Pedido> pedidos = new ArrayList<>();
		clienteController.createClient(new ClienteDTO(1L, "Cliente2", "endereco", "login", "senha", pedidos));
		var cliente = clienteController.getAllClients();
		Assert.assertEquals("Cliente2", cliente.getBody().get(1).getNome());
	}

	@Test
	void AtestFuncionarioCriar(){
		List<Venda> vendas = new ArrayList<>();
		var funcionario = funcionarioController.createFuncionario(new FuncionarioDTO(1L, "funcionario", "login", "senha", vendas));
		Assert.assertEquals("Funcionario criado com sucesso!", funcionario.getBody());
	}

	@Test
	void BtestFuncionarioEditar(){
		List<Venda> vendas = new ArrayList<>();
		var funcionario = funcionarioController.updateFuncionario(1L, new FuncionarioDTO(1L, "funcionario", "login", "senha", vendas));
		Assert.assertEquals("Funcionario editado com sucesso!", funcionario.getBody());
	}

	@Test
	void DtestFuncionarioDeletar(){
		var funcionario = funcionarioController.deleteFuncionario(2L);
		Assert.assertEquals("Funcionario deletado com sucesso", funcionario.getBody());
	}

	@Test
	void CtestFuncionarioFindById(){
		List<Venda> vendas = new ArrayList<>();
		funcionarioController.createFuncionario(new FuncionarioDTO(1L, "funcionario", "login", "senha", vendas));
		var funcionario = funcionarioController.findById(1L);
		Assert.assertEquals("funcionario", funcionario.getBody().getNome());
	}

	@Test
	void CtestFuncionarioFindAll(){
		List<Venda> vendas = new ArrayList<>();
		funcionarioController.createFuncionario(new FuncionarioDTO(1L, "funcionario", "login", "senha", vendas));
		var funcionario = funcionarioController.getAllFuncionarios();
		Assert.assertEquals("funcionario", funcionario.getBody().get(1).getNome());
	}

	@Test
	void AtestPedidoCriar(){
		List<Produto> produtos = new ArrayList<>();
		List<Pedido> pedidos = new ArrayList<>();
		List<Venda> vendas = new ArrayList<>();
		Cliente cliente = new Cliente(1L, "Cliente", "endereco 1", "login", "senha", pedidos);
		var pedido = pedidoController.criar(new PedidoDTO(1L, LocalDateTime.now(), "Preparando", cliente, produtos, vendas));
		Assert.assertEquals("Pedido cadastrado com sucesso", pedido.getBody());
	}

	@Test
	void BtestPedidoEditar(){
		List<Pedido> pedidos = new ArrayList<>();
		List<Produto> produtos = new ArrayList<>();
		List<Venda> vendas = new ArrayList<>();
		Cliente cliente = new Cliente(1L, "Cliente", "endereco 1", "login", "senha", pedidos);
		var pedido = pedidoController.editar(new PedidoDTO(1L, LocalDateTime.now(), "Preparando", cliente, produtos, vendas), 1L);
		Assert.assertEquals("Pedido editado com sucesso", pedido.getBody());
	}

	@Test
	void DtestPedidoDeletar(){
		var pedido = pedidoController.deletar(1L);
		Assert.assertEquals("Pedido deletado com sucesso", pedido.getBody());
	}

	@Test
	void CtestPedidoFindById(){

		List<Pedido> pedidos = new ArrayList<>();
		List<Produto> produtos = new ArrayList<>();
		List<Venda> vendas = new ArrayList<>();
 		Cliente cliente = new Cliente(1L, "Cliente", "endereco 1", "login", "senha", pedidos);
		pedidoController.criar(new PedidoDTO(1L, LocalDateTime.now(), "Preparando", cliente, produtos, vendas));

		var pedido_encontrado = pedidoController.findById(1L);
		Assert.assertEquals("Cliente", pedido_encontrado.getBody().getCliente().getNome());
	}

	@Test
	void CtestPedidoFindAll(){
		List<Pedido> pedidos = new ArrayList<>();
		List<Produto> produtos = new ArrayList<>();
		Cliente cliente = new Cliente(1L, "Cliente", "endereco 1", "login", "senha", pedidos);
		var pedido = pedidoController.getAll();
		Assert.assertEquals("Cliente", pedido.getBody().get(1).getCliente().getNome());
	}

	@Test
	void AtestPizzaCriar(){
		Produto produto = new Produto();
		var pizza = pizzaController.criar(new PizzaDTO(1L, "Ca two piri", "BIG", "Nenhum", "Nenhum", produto));
		Assert.assertEquals("Pizza cadastrada com sucesso", pizza.getBody());
	}
	@Test
	void BtestPizzaEditar(){
		Produto produto = new Produto();
		var pizza = pizzaController.editar(new PizzaDTO(1L, "Ca ONE piri", "BIG", "Nenhum", "Nenhum", produto), 1L);
		Assert.assertEquals("Pizza editada com sucesso", pizza.getBody());
	}

	@Test
	void DtestPizzaDeletar(){
		var pizza = pizzaController.deletar(1L);
		Assert.assertEquals("Pizza deletada com sucesso", pizza.getBody());
	}

	@Test
	void CtestPizzaFindById(){
		Produto produto = new Produto();
		pizzaController.criar(new PizzaDTO(1L, "Ca Two piri", "BIG", "Nenhum", "Nenhum", produto));
		var pizza = pizzaController.findById(1L);

		Assert.assertEquals("Ca two piri", pizza.getBody().getSabores());
	}

	@Test
	void CtestPizzaFindAll(){
		Produto produto = new Produto();
		pizzaController.criar(new PizzaDTO(1L, "Ca Three piri", "BIG", "Nenhum", "Nenhum", produto));
		var pizza = pizzaController.getAll();

		Assert.assertEquals("Ca two piri", pizza.getBody().get(1).getSabores());
	}

	@Test
	void AtestProdutoCriar(){
		Produto produto = new Produto();
		Pedido pedido = new Pedido();
		Pizza pizzaTeste = new Pizza(1L, "Ca two piri", "BIG", "Nenhum", "Nenhum", produto);
		var produto_request = produtoController.criar(new ProdutoDTO(1L, pizzaTeste, "Nenhum", pedido));
		Assert.assertEquals("Produto cadastrado com sucesso", produto_request.getBody());
	}

	@Test
	void BtestProdutoEditar(){
		Produto produto = new Produto();
		Pedido pedido = new Pedido();
		Pizza pizzaTeste = new Pizza(1L, "Ca two piri", "BIG", "Nenhum", "Nenhum", produto);
		var produtoTeste = produtoController.editar(new ProdutoDTO(1L,pizzaTeste, "Maionese", pedido), 1L);
		Assert.assertEquals("Produto editado com sucesso", produtoTeste.getBody());
	}

	@Test
	void DtestProdutoDeletar(){
		var produtoTeste = produtoController.deletar(1L);
		Assert.assertEquals("Produto deletado com sucesso", produtoTeste.getBody());
	}

	@Test
	void CtestProdutoFindById(){
		Produto produto = new Produto();
		Pedido pedido = new Pedido();
		Pizza pizzaTeste = new Pizza(1L, "Ca two piri", "BIG", "Nenhum", "Nenhum", produto);
		produtoController.criar(new ProdutoDTO(1L,pizzaTeste, "Kerischuque", pedido));

		var produtoTeste = produtoController.findById(1L);
		Assert.assertEquals("Kerischuque", produtoTeste.getBody().getAcompanhamentos());
	}

	@Test
	void CtestProdutoFindAll(){
		Produto produto = new Produto();
		Pedido pedido = new Pedido();
		Pizza pizzaTeste = new Pizza(1L, "Ca two piri", "BIG", "Nenhum", "Nenhum", produto);
		produtoController.criar(new ProdutoDTO(1L,pizzaTeste, "Kerischuque", pedido));

		var produtoTeste = produtoController.getAll();
		Assert.assertEquals("Kerischuque", produtoTeste.getBody().get(1).getAcompanhamentos());
	}

	@Test
	void AtestVendaCriar(){
		Produto produto = new Produto();

		List<Venda> vendas = new ArrayList<>();
		List<Produto> produtos = new ArrayList<>();
		List<Pedido> pedidos = new ArrayList<>();
		Cliente cliente = new Cliente(1L, "Cliente", "endereco 1", "login", "senha", pedidos);

		Funcionario funcionario = new Funcionario(1L, "funcionario", "login", "senha",vendas);
		Pedido pedido = new Pedido(1L, LocalDateTime.now(), "Preparando", cliente, produtos, vendas );

		var venda = vendaController.criar(new VendaDTO(1L, "Fiado", pedido, "Motofrete", funcionario));

		Assert.assertEquals("Venda realizada com sucesso",venda.getBody());
	}

	@Test
	void BtestVendaEditar(){
		Produto produto = new Produto();

		List<Venda> vendas = new ArrayList<>();
		List<Produto> produtos = new ArrayList<>();
		List<Pedido> pedidos = new ArrayList<>();
		Cliente cliente = new Cliente(1L, "Cliente", "endereco 1", "login", "senha", pedidos);

		Funcionario funcionario = new Funcionario(1L, "funcionario", "login", "senha",vendas);
		Pedido pedido = new Pedido(1L, LocalDateTime.now(), "Preparando", cliente, produtos, vendas);

		var venda = vendaController.editar(new VendaDTO(1L, "Dinheiro", pedido, "Motofrete", funcionario), 1L);
		Assert.assertEquals("Venda editada com sucesso", venda.getBody());
	}

	@Test
	void DtestVendaDeletar(){
		var venda = vendaController.deletar(1L);
		Assert.assertEquals("Venda deletada com sucesso", venda.getBody());
	}

	@Test
	void CtestVendaFindById(){
		Produto produto = new Produto();

		List<Venda> vendas = new ArrayList<>();
		List<Produto> produtos = new ArrayList<>();
		List<Pedido> pedidos = new ArrayList<>();
		Cliente cliente = new Cliente(1L, "Cliente", "endereco 1", "login", "senha", pedidos);

		Funcionario funcionario = new Funcionario(1L, "funcionario", "login", "senha",vendas);
		Pedido pedido = new Pedido(1L, LocalDateTime.now(), "Preparando", cliente, produtos, vendas);
		vendaController.criar(new VendaDTO(1L, "Dinheiro", pedido, "Motofrete", funcionario));

		var venda = vendaController.findById(1L);

		Assert.assertEquals("Fiado", venda.getBody().getTipoPagamento());
	}

	@Test
	void ctestVendaFindAll(){
		Produto produto = new Produto();

		List<Venda> vendas = new ArrayList<>();
		List<Produto> produtos = new ArrayList<>();
		List<Pedido> pedidos = new ArrayList<>();
		Cliente cliente = new Cliente(1L, "Cliente", "endereco 1", "login", "senha", pedidos);

		Funcionario funcionario = new Funcionario(1L, "funcionario", "login", "senha",vendas);
		Pedido pedido = new Pedido(1L, LocalDateTime.now(), "Preparando", cliente, produtos, vendas);
		vendaController.criar(new VendaDTO(1L, "Dinheiro", pedido, "Motofrete", funcionario));

		var venda = vendaController.getAll();

		Assert.assertEquals("Motofrete", venda.getBody().get(1).getTipoEntrega());
	}
}
