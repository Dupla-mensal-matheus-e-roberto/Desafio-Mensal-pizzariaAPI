package br.com.uniamerica.Pizzaria.Controller;

import br.com.uniamerica.Pizzaria.DTO.PizzaDTO;
import br.com.uniamerica.Pizzaria.Service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/pizza")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @GetMapping("/all")
    public ResponseEntity<List<PizzaDTO>> getAll(){
        try{
            return ResponseEntity.ok(this.pizzaService.getAll());
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<PizzaDTO> findById(@PathVariable("id") Long id){
        try{
            return ResponseEntity.ok(this.pizzaService.findById(id));
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criar(@RequestBody PizzaDTO pizzaDTO){
        try{
            this.pizzaService.criar(pizzaDTO);
            return ResponseEntity.ok("Pizza cadastrada com sucesso");
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editar(@RequestBody PizzaDTO pizzaDTO, @PathVariable("id") Long id){
        try{
            this.pizzaService.editar(pizzaDTO, id);
            return ResponseEntity.ok("Pizza editada com sucesso");
        } catch(Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable("id") Long id){
        try{
            this.pizzaService.deletar(id);
            return ResponseEntity.ok("Pizza deletada com sucesso");
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
