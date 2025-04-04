package br.org.fundatec.filmes.model;

public class TotalFuncionarioRestaurante {

    private String nomeRestaurante;
    private Long qntVotos;

    public TotalFuncionarioRestaurante(String nomeRestaurante, Long qntVotos){
        this.nomeRestaurante = nomeRestaurante;
        this.qntVotos = qntVotos;
    }

    public String getNomeRestaurante() {
        return nomeRestaurante;
    }

    public void setNomeRestaurante(String nomeRestaurante) {
        this.nomeRestaurante = nomeRestaurante;
    }

    public Long getQntVotos() {
        return qntVotos;
    }

    public void setQntVotos(Long qntVotos) {
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
