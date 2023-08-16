package br.com.uniamerica.Pizzaria.Service;

import br.com.uniamerica.Pizzaria.DTO.PizzaDTO;
import br.com.uniamerica.Pizzaria.Entity.Pizza;
import br.com.uniamerica.Pizzaria.Repository.PizzaRepository;
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
    private PizzaDTO pizzaDTO;

    public List<PizzaDTO> getAll(){
        List<Pizza> listBanco = this.pizzaRepository.findAll();
        List<PizzaDTO> listDTO = new ArrayList<>();

        for(int i = 0; i < listBanco.size(); i++){
            listDTO.add(toPizzaDto(listBanco.get(i)));
        }

        return listDTO;
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
        pizza = toPizza(pizzaDTO);

        pizza = this.pizzaRepository.findById(id).orElse(null);

        Assert.isTrue(pizza != null, "Pizza Inválido");

        this.pizzaRepository.save(pizza);
    }

    public void deletar(Long id){
        pizza = this.pizzaRepository.findById(id).orElse(null);

        Assert.isTrue(pizza != null, "Pizza Inválido");

        this.pizzaRepository.delete(pizza);
    }

    public PizzaDTO toPizzaDto(Pizza pizza){
        pizzaDTO = new PizzaDTO();
        pizzaDTO.setAdicionais(pizza.getAdicionais());
        pizzaDTO.setRemoviveis(pizza.getRemoviveis());
        pizzaDTO.setTamanho(pizza.getTamanho());
        pizzaDTO.setSabores(pizza.getSabores());

        return pizzaDTO;
    }

    public Pizza toPizza(PizzaDTO pizzaDTO){
        pizza = new Pizza();
        pizza.setAdicionais(pizzaDTO.getAdicionais());
        pizza.setRemoviveis(pizzaDTO.getRemoviveis());
        pizza.setTamanho(pizzaDTO.getTamanho());
        pizza.setSabores(pizzaDTO.getSabores());

        return pizza;
    }

}
