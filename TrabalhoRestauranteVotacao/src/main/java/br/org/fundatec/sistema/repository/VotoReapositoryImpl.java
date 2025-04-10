package br.org.fundatec.sistema.repository;

import br.org.fundatec.sistema.model.TotalFuncionarioRestaurante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Classe VotoRepositoryImpl funciona como um repositorio
 * @author Matheus Ranheri
 * @data 10/04/2025
 */

/**
 * @Repository = faz com que o jpa entenda que essa classe serve para consultas no banco de dados
 */
@Repository
public class VotoReapositoryImpl {

/**
 * @PersistenceContext = injeta o EntityManager.
 * EntityManager = Fazer consultas manualmente
 */
@PersistenceContext
    private EntityManager entityManager;

    /**
     * Esse metodo TotalFuncionarioRestaurante pega a data de hoje que é utilizada para pegar somete os votos de hoje
     * A querry cria um novo objeto TotalFuncionarioRestaurante que tem como parametro o nome do restaurante e a quantidade de votos que ele recebeu
     * Busca a entidade votos faz um join com restaurante associada ao voto
     * Filtra os votos feitos na data de hoje
     * Agrupa os votos pelo nome do restaurante
     * Ordena os resultados pelo total de votos, do maio para o menor
     * TypedQuery = fazer querys, nesse caso vai retornar objetos do tipo TotalFuncionarioRestaurante
     * createQuery = cria uma query
     * setParameter = substitui o parametro :data da query pela data atual obtida pelo LocalDate
     * @return uma lista de objetos
     */
    public List<TotalFuncionarioRestaurante> TotalFuncionarioRestaurante(){
        LocalDate hoje = LocalDate.now();
        String query = "select new br.org.fundatec.sistema.model.TotalFuncionarioRestaurante(r.nome, COUNT(v)) " +
                " from Voto v " +
                " join v.restaurante r " +
                " where v.data = :data " +
                " group by r.nome " +
                "order by COUNT(v) desc";

        TypedQuery<TotalFuncionarioRestaurante> consulta = entityManager
                .createQuery(query,TotalFuncionarioRestaurante.class);
        consulta.setParameter("data", hoje);
        return consulta.getResultList();
    }
}
