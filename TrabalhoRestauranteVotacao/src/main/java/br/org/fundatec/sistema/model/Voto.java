package br.org.fundatec.sistema.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Classe Voto que representa uma tabela no banco de dados
 * @author Matheus Ranheri
 * @data 10/04/2025
 */

//Marca a classe como uma entidade jpa(Uma classe que será mapeada para uma tabela no banco de dados).
@Entity
//Nome da tabela
@Table(name = "VOTO")
public class Voto {

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
     * define o id;
     */
    private Long id;

    /**
     * Define que o campo data sera mapeado para a coluna data
     */
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private LocalDate data;

    /**
     * @ManyToOne = Muitos para um
     * FetchType.LAZY = Só vai carregar o relacionamento com funcionario, quando o campo funcionario for acessado
     * @JoinColumn = Associação etre as duas tabelas, a coluna id da tabela funcionario é a coluna que o id_funcionario irá apontar
     */
    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_funcionario", referencedColumnName = "id")
    private Funcionario funcionario;

    /**
     * @ManyToOne = Muitos para um
     * FetchType.LAZY = Só vai carregar o relacionamento com restaurante, quando o campo restaurante for acessado
     * @JoinColumn = Associação etre as duas tabelas, a coluna id da tabela restaurante é a coluna que o id_restaurante irá apontar
     */
    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_restaurante", referencedColumnName = "id")
    private Restaurante restaurante;

    /**
     * Construtor padrão
     */
    public Voto(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    /**
     * @param o Object
     * O metodo equals serve para comparar objetos e verificar se eles são iguais
     * @return A comparação entre os atributos id, data, funcionario e restaurante
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Voto voto = (Voto) o;
        return Objects.equals(id, voto.id) && Objects.equals(data, voto.data) && Objects.equals(funcionario, voto.funcionario) && Objects.equals(restaurante, voto.restaurante);
    }

    /**
     * Define onde  um objeto será posto em uma tabela de Hash.
     * @return Retorna um inteiro que representa um objeto
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, data, funcionario, restaurante);
    }

    /**
     * ToString é usado para uma representação em texto de um obejeto
     * @return retorna o nome da classe e os valores dos atributos
     */
    @Override
    public String toString() {
        return "Voto{" +
                "id=" + id +
                ", data=" + data +
                ", funcionario=" + funcionario +
                ", restaurante=" + restaurante +
                '}';
    }
}

