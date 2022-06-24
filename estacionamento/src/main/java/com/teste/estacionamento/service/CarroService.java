package com.teste.estacionamento.service;


import com.teste.estacionamento.entities.Carro;
import com.teste.estacionamento.entities.Valor;
import com.teste.estacionamento.repositories.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.persistence.PrePersist;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarroService {


    @Autowired
    private CarroRepository carroRepository;


    public void updateValorTotal(Long id, Carro obj){
        Carro entity = carroRepository.findById(id).get();


//    public void updateDataSaida(Long id, Carro obj) {
//        Carro entity = repository.findById(id).get();
//        entity.setData_saida((obj.getData_saida()));
//        entity.setTempo(entity.tempoTotal(entity));
//
//        repository.save(entity);
    }




    public List<Carro> findAll() {


        return carroRepository.findAll();
    }


    public Carro insert(Carro obj) {
         obj.setTempo(obj.getTempo());
         obj.setData_saida(ZonedDateTime.now());
        return carroRepository.save(obj);
    }


    public Carro update(Long id, Carro obj) {

        Carro entity = carroRepository.findById(id).get();

        if (obj.getPlaca() != null) {
            entity.setPlaca(obj.getPlaca());
        }
        if (obj.getModelo() != null) {
            entity.setModelo(obj.getModelo());
        }
        //###########REMOVER PUT DE ENTRADA E SAIDA#########
        if (obj.getData_saida() != null) {
            entity.setData_saida(obj.getData_saida());
        }
        if (obj.getData_entrada() != null) {
            entity.setData_entrada(obj.getData_entrada());
        }

        return carroRepository.save(entity);
    }

    public void  valorTotal(long id, Carro obj){
        Carro entity = carroRepository.findById(id).get();
        entity.setValor_pago(obj.precoTotal(obj));

        carroRepository.save(entity);
    }


    public void updateDataSaida(Long id,Carro obj) {
        Carro entity = carroRepository.findById(id).get();
        entity.setData_saida(obj.getData_saida());
        entity.setTempo(entity.tempoTotal(entity));
        entity.setValor_pago(entity.precoTotal(obj));

        carroRepository.save(entity);
    }



}
