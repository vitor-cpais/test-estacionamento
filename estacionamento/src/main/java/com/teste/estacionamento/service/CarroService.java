package com.teste.estacionamento.service;


import com.teste.estacionamento.entities.Carro;
import com.teste.estacionamento.entities.Valor;
import com.teste.estacionamento.repositories.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class CarroService {


    @Autowired
    private CarroRepository repository;


    public List<Carro> findAll() {


        return repository.findAll();

    }

    public Carro insert(Carro obj) {
        return repository.save(obj);
    }


    public Carro update(Long id, Carro obj) {

        Carro entity = repository.findById(id).get();

        if (obj.getPlaca() != null) {
            entity.setPlaca(obj.getPlaca());
        }
        if (obj.getModelo() != null) {
            entity.setModelo(obj.getModelo());
        }
        if (obj.getData_saida() != null) {
            entity.setData_saida(obj.getData_saida());
        }
        if (obj.getData_entrada() != null) {
            entity.setData_entrada(obj.getData_entrada());
        }

        return repository.save(entity);
    }

//    public void updateDataSaida(Long id) {
//        Carro entity = repository.findById(id).get();
//        entity.setData_saida(ZonedDateTime.now());
//        repository.save(entity);
//    }

}
