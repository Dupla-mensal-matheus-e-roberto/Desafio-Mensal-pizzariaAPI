package br.com.uniamerica.pizzaria.service;

import br.com.uniamerica.pizzaria.dto.PizzaDTO;
import br.com.uniamerica.pizzaria.entity.Pizza;
import br.com.uniamerica.pizzaria.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;
    private Pizza pizza;

    public List<PizzaDTO> getAll(){
        return pizzaRepository.findAll().stream().map(this::toPizzaDto).toList();
    }

    public PizzaDTO findById(Long id){
        Pizza pizzaBanco = this.pizzaRepository.findById(id).orElse(null);

        Assert.isTrue( pizzaBanco != null, "Pizza Inválido");

        return toPizzaDto(pizzaBanco);
    }

    public void criar(PizzaDTO pizzaDTO){
        pizza = toPizza(pizzaDTO);

        this.pizzaRepository.save(pizza);
    }

    public void editar(PizzaDTO pizzaDTO, Long id){
        pizza = this.pizzaRepository.findById(id).orElse(null);

        Assert.isTrue(pizza != null, "Pizza Inválida");

        Assert.isTrue(pizzaDTO != null, "Pizza Inválida");

        pizza.setAdicionais(pizzaDTO.getAdicionais());
        pizza.setRemoviveis(pizzaDTO.getRemoviveis());
        pizza.setTamanho(pizzaDTO.getTamanho());
        pizza.setSabores(pizzaDTO.getSabores());

        this.pizzaRepository.save(pizza);
    }

    public void deletar(Long id){
        pizza = this.pizzaRepository.findById(id).orElse(null);

        Assert.isTrue(pizza != null, "Pizza Inválido");

        this.pizzaRepository.delete(pizza);
    }

    public PizzaDTO toPizzaDto(Pizza pizza){
        PizzaDTO pizzaDTO = new PizzaDTO();
        pizzaDTO.setIdPizza(pizza.getIdPizza());
        pizzaDTO.setAdicionais(pizza.getAdicionais());
        pizzaDTO.setRemoviveis(pizza.getRemoviveis());
        pizzaDTO.setTamanho(pizza.getTamanho());
        pizzaDTO.setSabores(pizza.getSabores());
        pizzaDTO.setProduto(pizza.getProduto());
        return pizzaDTO;
    }

    public Pizza toPizza(PizzaDTO pizzaDTO){
        pizza = new Pizza();
        pizza.setIdPizza(pizzaDTO.getIdPizza());
        pizza.setAdicionais(pizzaDTO.getAdicionais());
        pizza.setRemoviveis(pizzaDTO.getRemoviveis());
        pizza.setTamanho(pizzaDTO.getTamanho());
        pizza.setSabores(pizzaDTO.getSabores());
        pizza.setProduto(pizzaDTO.getProduto());
        return pizza;
    }

}
