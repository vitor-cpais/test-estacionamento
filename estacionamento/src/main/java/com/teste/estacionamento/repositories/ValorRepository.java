package com.teste.estacionamento.repositories;


import com.teste.estacionamento.entities.Valor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ValorRepository extends JpaRepository <Valor, Long> {

}



