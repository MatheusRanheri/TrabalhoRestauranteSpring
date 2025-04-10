package br.org.fundatec.sistema.model;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * Classe Funcionario que representa uma tabela no banco de dados
 * @author Matheus Ranheri
 * @data 10/04/2025
 */

//Marca a classe como uma entidade jpa(Uma classe que será mapeada para uma tabela no banco de dados).
@Entity
//Nome da tabela.
@Table(name = "FUNCIONARIO")
public class Funcionario {

    /**
     * @Id = chave primaria
     * @Column = mapeamento de um atributo com uma coluna do banco de dados
     * @GeneratedValue = o valor do campo vai ser gerado automaticamente
     * strategi = GenerationType.SEQUENCE = strategia de geração por sequencia no banco de dados
     * generator = "label_sequence" = nome da sequecia que vai ser usada
     * @SequenceGenerator = sequencia para a geração automatica de ids
     * name = "label_sequence" = nome do operador
     * sequenceName = "label_sequence" = nome da sequencia no banco de dados
     * allocationSize = 100 = tamanho do bloco de ids que o jpa reserva de uma só vez
     */
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "label_sequence")
    @SequenceGenerator(name = "label_sequence", sequenceName = "label_sequence", allocationSize = 100)

    /**
     * Define o id
     */
    private Long id;

    /**
     * Define que o campo nome sera mapeada para a coluna nome
     */
    @Column(name = "nome")
    private String nome;

    /**
     * @param nomeFuncionario String
     * Permite criar uma instância da classe Funcionario e inicializar o atributo nome
     */
    public Funcionario(String nomeFuncionario) {
        this.nome = nomeFuncionario;
    }

    /**
     * Construtor padrão
     */
    public Funcionario(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param o Object
     * O metodo equals serve para comparar objetos e verificar se são iguais
     * @return false se o id for nulo ou diferente
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        //Se o objeto o não for instancia da classe Funcionario então retorna false
        if (!(o instanceof Funcionario)) return false;
        Funcionario that = (Funcionario) o;
        return id != null && id.equals(that.id);
    }

    /**
     * Define onde  um objeto será posto em uma tabela de Hash.
     * @return Retorna um Long que representa um objeto
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * ToString é usado para uma representação em texto de um obejeto
     * @return retorna o nome da classe e os valores dos atributos
     */
    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}

