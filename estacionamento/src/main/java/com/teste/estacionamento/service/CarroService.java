package com.teste.estacionamento.service;


import com.teste.estacionamento.entities.Carro;
import com.teste.estacionamento.repositories.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;


    public List<Carro> findAllCarros() {
        return carroRepository.findAll();
    }

    public Carro insertCarro(Carro obj) {
        obj.setTempo(obj.getTempo());
        obj.setData_saida(ZonedDateTime.now());
        return carroRepository.save(obj);
    }

    public Carro updateCarro(Long id, Carro obj) {

        Carro entity = carroRepository.findById(id).get();

        if (obj.getPlaca() != null) {
            entity.setPlaca(obj.getPlaca());
        }
        if (obj.getModelo() != null) {
            entity.setModelo(obj.getModelo());
        }

        return carroRepository.save(entity);
    }


    public void updateDataSaida(Long id, Carro obj) {
        Carro entity = carroRepository.findById(id).get();
        entity.setData_saida(obj.getData_saida());
        Integer tempoVaga = entity.tempoTotal(entity);
        if (tempoVaga == 0) {
            entity.setTempo(entity.tempoTotal(entity) + 1);
        } else {
            entity.setTempo(entity.tempoTotal(entity));
        }

        entity.setValor_pago(entity.precoTotal(obj));

        carroRepository.save(entity);
    }

}
