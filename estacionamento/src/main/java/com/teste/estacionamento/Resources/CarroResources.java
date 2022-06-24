package com.teste.estacionamento.Resources;


import com.teste.estacionamento.entities.Carro;
import com.teste.estacionamento.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@Resource
@RestController
@RequestMapping(value = "/carros")
public class CarroResources {

    @Autowired
    private CarroService carroService;

    @GetMapping
    public ResponseEntity<List<Carro>> findAllCarros() {
        List<Carro> list = carroService.findAllCarros();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Carro> insert(@RequestBody Carro obj) {
        obj = carroService.insertCarro(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Carro> update(@PathVariable Long id, @RequestBody Carro obj) {
        obj = carroService.updateCarro(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Carro> valorTotal(@PathVariable Long id, @RequestBody Carro obj) {
        carroService.updateDataSaida(id, obj);
        return ResponseEntity.ok().build();
    }

}
