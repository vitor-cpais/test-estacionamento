package com.teste.estacionamento.entities;

import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "tbl_valor")
public class Valor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Double valor_primeira_hora = 6.00;
    private Double valor_demais_horas = 4.00;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private ZonedDateTime data_fim;

    public Valor() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor_primeira_hora() {
        return valor_primeira_hora;
    }

    public void setValor_primeira_hora(Double valor_primeira_hora) {
        this.valor_primeira_hora = valor_primeira_hora;
    }

    public Double getValor_demais_horas() {
        return valor_demais_horas;
    }

    public void setValor_demais_horas(Double valor_demais_horas) {
        this.valor_demais_horas = valor_demais_horas;
    }

    public ZonedDateTime getData_fim() {
        return data_fim;
    }

    public void setData_fim(ZonedDateTime data_fim) {
        this.data_fim = data_fim;
    }




}



