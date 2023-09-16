package br.com.uniamerica.pizzaria.controller;

import br.com.uniamerica.pizzaria.dto.VendaDTO;
import br.com.uniamerica.pizzaria.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/venda")
public class VendaController {
    @Autowired
    private VendaService vendaService;

    @GetMapping("/all")
    public ResponseEntity<List<VendaDTO>> getAll(){
        try{
            return ResponseEntity.ok(this.vendaService.getAll());
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<VendaDTO> findById(@PathVariable("id") Long id){
        try{
            return ResponseEntity.ok(this.vendaService.findById(id));
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criar(@RequestBody VendaDTO vendaDTO){
        try{
            this.vendaService.criar(vendaDTO);
            return ResponseEntity.ok("Venda realizada com sucesso");
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editar(@RequestBody VendaDTO vendaDTO, @PathVariable("id") Long id){
        try{
            this.vendaService.editar(vendaDTO, id);
            return ResponseEntity.ok("Venda editada com sucesso");
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable("id") Long id){
        try{
            this.vendaService.deletar(id);
            return ResponseEntity.ok("Venda deletada com sucesso");
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
