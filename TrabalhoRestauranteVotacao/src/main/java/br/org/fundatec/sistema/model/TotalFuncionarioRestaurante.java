package br.org.fundatec.sistema.model;

/**
 * Classe TotalFuncionarioRestaurante que possui um nome restaurante e uma quantidade de votos
 * @author Matheus Ranheri
 * @data 10/04/2025
 */
public class TotalFuncionarioRestaurante {

    /**
     * Uma variavel do tipo texto que está privada
     * Uma variavel de tipo numerico que esta privado
     */
    private String nomeRestaurante;
    private Long qntVotos;

    /**
     * @param nomeRestaurante String
     * @param qntVotos Long
     * Permite criar uma instância da classe TotalFuncionariosRestaurante e inicializar o atributo nomeRestaurante e qntVotos
     */
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

    /**
     * ToString é usado para uma representação em texto de um obejeto
     * @return retorna o nome da classe e os valores dos atributos
     */
    @Override
    public String toString() {
        return "TotalFuncionariosRestaurante{" +
                "nomeRestaurante='" + nomeRestaurante + '\'' +
                ", qntVotos=" + qntVotos +
                '}';
    }
}
