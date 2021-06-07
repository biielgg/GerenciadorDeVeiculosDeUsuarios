package com.george.orangetalent.dtos;

public class VeiculoDto {

    private Long id;
    private Long usuario;
    private String marca;
    private String modelo;
    private int ano;
    private String diaRodizio;
    private boolean rodAtivo;

    public VeiculoDto() {}

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

    public void setDiaRodizio(String rodizio) {
        this.diaRodizio = rodizio;
    }

    public boolean isRodAtivo() {
        return rodAtivo;
    }

    public void setRodAtivo(boolean rodAtivo) {
        this.rodAtivo = rodAtivo;
    }
}
