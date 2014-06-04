package br.com.sgce.repository;

import br.com.sgce.entity.Aluno;
import br.com.sgce.filter.AlunoFilter;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

@Named
public class AlunoRepository implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private EntityManager manager;

    public Aluno guardar(Aluno aluno) {

        return manager.merge(aluno);
    }

   /* public Aluno porNome(String nome) {
        //consulta feita com jpql
        try { 
            return manager.createQuery("from Aluno where upper(nome) = :nome", Aluno.class)
                    .setParameter("nome", nome.toUpperCase())
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    * /

    /*Metodo para filtrar aluno e mandar pra tela,da Forma com que esta sendo feito posso pesquisar
      por outro atributo basta adicionar na classe Alunofilter*/    
    
    public List<Aluno> filtrados(AlunoFilter filtro) {
        Session session = manager.unwrap(Session.class); //Pedindo pro manager desempacotar a session do hibernate, e joga na variavel session.
        Criteria criteria = session.createCriteria(Aluno.class); //criando um criterio para entidade Aluno.

        //Vrificar o que está sendo feito.
     //   criteria.add(Restrictions.eq(null, filtro));

        if (StringUtils.isNotBlank(filtro.getNome())) {
            criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
        }

        return criteria.addOrder(Order.asc("nome")).list();
    }

    public List<Aluno> buscarAluno() {
        return manager.createQuery("from Aluno", Aluno.class).getResultList();

    }
    //Retorna um aluno dado o id dele
    public Aluno porId(Long id) {
       return manager.find(Aluno.class, id);
    }
}
