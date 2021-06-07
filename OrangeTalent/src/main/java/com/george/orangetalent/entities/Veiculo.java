package com.george.orangetalent.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "veiculo")
public class Veiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "usuario", nullable = false)
    private Long usuario;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "modelo", nullable = false)
    private String modelo;

    @Column(name = "ano", nullable = false)
    private int ano;

    @Column(name = "diaRodizio", nullable = false)
    private String diaRodizio;

    private boolean rodizioAtivo;

    public Veiculo() {}

    public Veiculo(Long usuario, String marca, String modelo, 
            int ano, String diaRodizio) {

        this.usuario = usuario;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.diaRodizio = diaRodizio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getDiaRodizio() {
        return diaRodizio;
    }

    public void setDiaRodizio(String diaRodizio) {
        this.diaRodizio = diaRodizio;
    }

    public boolean isRodizioAtivo() {
        return rodizioAtivo;
    }

    public void setRodizioAtivo(boolean rodizioAtivo) {
        this.rodizioAtivo = rodizioAtivo;
    }
}