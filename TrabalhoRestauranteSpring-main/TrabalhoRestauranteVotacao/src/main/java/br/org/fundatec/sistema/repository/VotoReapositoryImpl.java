package br.org.fundatec.sistema.repository;

import br.org.fundatec.sistema.model.TotalFuncionarioRestaurante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class VotoReapositoryImpl {

@PersistenceContext
    private EntityManager entityManager;

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
