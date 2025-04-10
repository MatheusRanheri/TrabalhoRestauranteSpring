package br.org.fundatec.sistema.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "label_sequence")
    @SequenceGenerator(name = "label_sequence", sequenceName = "label_sequence", allocationSize = 100)
    private Long id;

    @Column(name = "nome")
    private String nome;


    public Funcionario(String nomeFuncionario) {
        this.nome = nomeFuncionario;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Funcionario)) return false;
        Funcionario that = (Funcionario) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }



}

