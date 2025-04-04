package br.org.fundatec.filmes.repository;

import br.org.fundatec.filmes.model.TotalFuncionarioRestaurante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.List;

@Repository
public class VotoReapositoryImpl {

@PersistenceContext
    private EntityManager entityManager;

    public List<TotalFuncionarioRestaurante> TotalFuncionarioRestaurante(){
        Calendar caledar = Calendar.getInstance();
        String query = "select new br.org.fundatec.filmes.model.TotalFuncionarioRestaurante(r.nome, COUNT(r.id)) " +
                " from Voto v " +
                " inner join v.restaurante r " +
                " where v.data = :data " +
                " group by r.nome order by r.nome " +
                "order by COUNT(r.id) desc";

        TypedQuery<TotalFuncionarioRestaurante> TotalFuncionariosRestaurante = this.entityManager.createQuery(query, TotalFuncionarioRestaurante.class);
        TotalFuncionariosRestaurante.setParameter("data", caledar);
        return TotalFuncionariosRestaurante.getResultList();
    }
}
