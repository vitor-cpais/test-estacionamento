package com.teste.estacionamento.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.Duration;
import java.time.ZonedDateTime;


@Entity
@Table(name = "tbl_movimentacao")
@DynamicUpdate
public class Carro {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String modelo;
    private String placa;


    private Integer tempo = 1;

    private Double valor_pago;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private ZonedDateTime data_entrada;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private ZonedDateTime data_saida;

    public Carro() {
    }


    public Carro(Long id, String modelo, String placa, Integer tempo, Double valor_pago, ZonedDateTime data_entrada, ZonedDateTime data_saida) {
        this.id = id;
        this.modelo = modelo;
        this.placa = placa;
        this.tempo = tempo;
        this.valor_pago = valor_pago;
        this.data_entrada = data_entrada;
        this.data_saida = data_saida;
    }

    @PrePersist
    public void prePersist() {
        if (getData_entrada() == null) {
            setData_entrada(ZonedDateTime.now());
        }

        if (getTempo() == null) {
            setTempo((int) Duration.between(getData_entrada(), getData_saida()).toHours());
        }

        if (getTempo() != null) {
            Valor valor = new Valor();
            Integer tempoVaga = getTempo() -1;
            setValor_pago((tempoVaga * valor.getValor_demais_horas()) + valor.getValor_primeira_hora());
        }

        }



    public Integer getTempo() {
        return tempo;
    }

    public void setTempo(Integer tempo) {
        this.tempo = tempo;
    }

    public Double getValor_pago() {
        return valor_pago;
    }

    public void setValor_pago(Double valor_pago) {
        this.valor_pago = valor_pago;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public ZonedDateTime getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(ZonedDateTime data_entrada) {
        this.data_entrada = data_entrada;
    }

    public ZonedDateTime getData_saida() {
        return data_saida;
    }

    public void setData_saida(ZonedDateTime data_saida) {
        this.data_saida = data_saida;
    }


    public Integer tempoTotal(Carro entity) {

        entity.setTempo((int) Duration.between(entity.getData_entrada(), entity.getData_saida()).toHours());
        return getTempo();
    }







    public Double precoTotal(Carro entity){
        Valor obj = new Valor();
        if(getTempo() <= 1){
            setValor_pago((obj.getValor_primeira_hora()));
        }
        if(getTempo()>1) {
            Integer tempoVaga = getTempo() -1;
            setValor_pago((tempoVaga * obj.getValor_demais_horas()) + obj.getValor_primeira_hora());
        }
        return getValor_pago();
    }
}










