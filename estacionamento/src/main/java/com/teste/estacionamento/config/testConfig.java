package com.teste.estacionamento.config;


import com.teste.estacionamento.entities.Carro;
import com.teste.estacionamento.repositories.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.ZonedDateTime;
import java.util.Arrays;

@Configuration
public class testConfig implements CommandLineRunner {



    @Autowired
    private CarroRepository carroRepository;

    @Override
    public void run(String... args) throws Exception {


        Carro car1 = new Carro(null,"Ford Focus", "h5htr4",null,null, ZonedDateTime.parse("2019-06-20T13:34:54Z"),ZonedDateTime.parse("2019-06-20T23:53:07Z"));
        Carro car2 = new Carro(null,"Fiat Uno", "g5hg",null,null, ZonedDateTime.parse("2019-06-20T12:03:32Z"),ZonedDateTime.parse("2019-06-20T23:53:07Z"));
        Carro car3 = new Carro(null,"Fusca", "7657",null,null, ZonedDateTime.parse("2019-06-20T20:22:01Z"),ZonedDateTime.parse("2019-06-20T23:53:07Z"));
        Carro car4 = new Carro(null,"titan 150", "5665g",null,null, ZonedDateTime.parse("2019-06-20T03:02:24Z"),ZonedDateTime.parse("2019-06-20T23:53:07Z"));

        carroRepository.saveAll(Arrays.asList(car1,car2,car3,car4));

    }



}
