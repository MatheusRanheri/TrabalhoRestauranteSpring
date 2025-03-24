package com.br.org.fundatec.model;

public class TotalFuncionariosRestaurante {

    private String nomeRestaurante;
    private Long qntVotos;

    public TotalFuncionariosRestaurante(String nomeRestaurante, Long qntVotos){
        this.nomeRestaurante = nomeRestaurante;
        this.qntVotos = qntVotos;
    }

    @Override
    public String toString() {
        return "TotalFuncionariosRestaurante{" +
                "nomeRestaurante='" + nomeRestaurante + '\'' +
                ", qntVotos=" + qntVotos +
                '}';
    }
}
