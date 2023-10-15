package br.com.uniamerica.pizzaria.controller;

import br.com.uniamerica.pizzaria.dto.PedidoDTO;
import br.com.uniamerica.pizzaria.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@CrossOrigin(origins = "http://localhost:4200")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/all")
    public ResponseEntity<List<PedidoDTO>> getAll(){
        try{
            return ResponseEntity.ok(this.pedidoService.getAll());
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<PedidoDTO> findById(@PathVariable("id") Long id){
        try{
            return ResponseEntity.ok(this.pedidoService.findById(id));
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<PedidoDTO> criar(@RequestBody PedidoDTO pedidoDTO){
        try{
            return ResponseEntity.ok(this.pedidoService.criar(pedidoDTO));
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<PedidoDTO> editar(@RequestBody PedidoDTO pedidoDTO, @PathVariable("id") Long id){
        try{

            return ResponseEntity.ok(this.pedidoService.editar(pedidoDTO, id));
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<PedidoDTO> deletar(@PathVariable("id") Long id){
        try{
            return ResponseEntity.ok(this.pedidoService.deletar(id));
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }

}
