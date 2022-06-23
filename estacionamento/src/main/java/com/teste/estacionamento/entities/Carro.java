package com.teste.estacionamento.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.DynamicUpdate;

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

    private Long tempo;
    private Double valor_pago;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private ZonedDateTime data_entrada;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private ZonedDateTime data_saida;

    public Carro() {
    }

    public Carro(Long id, String modelo, String placa, Long tempo, Double valor_pago, ZonedDateTime data_entrada, ZonedDateTime data_saida) {
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
        this.setData_entrada(ZonedDateTime.now());
    }







    public Long getTempo() {
        return tempo;
    }

    public void setTempo(Long tempo) {
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


    public double valorTotal(Valor entity) {
        setTempo(Duration.between(getData_entrada(), getData_saida()).toHours());
        setValor_pago((getTempo() * entity.getValor_demais_horas()) + entity.getValor_primeira_hora());
        return getValor_pago();


    }

}
