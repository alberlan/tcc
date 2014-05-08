package br.com.sgce.repository;

import br.com.sgce.entity.Aluno;
import br.com.sgce.entity.Endereco;
import br.com.sgce.entity.Telefone;
import br.com.sgce.filter.AlunoFilter;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class AlunoRepository implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private EntityManager manager;

    public Aluno guardar(Endereco endereco, Telefone telefone, Aluno aluno) {              
               
        return manager.merge(aluno);
    }

    public Aluno porNome(String nome) {
        try {
            return manager.createQuery("from Aluno where upper(nome) = :nome", Aluno.class)
                    .setParameter("nome", nome.toUpperCase())
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Aluno> filtrados(AlunoFilter filtro) {

        Session session = manager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Aluno.class);

        criteria.add(Restrictions.eq(null, filtro));

        if (StringUtils.isNotBlank(filtro.getNome())) {
            criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));

        }

        return criteria.addOrder(Order.asc("nome")).list();


    }

    public List<Aluno> buscarAluno() {
        return manager.createQuery("from Aluno", Aluno.class).getResultList();

    }
}
