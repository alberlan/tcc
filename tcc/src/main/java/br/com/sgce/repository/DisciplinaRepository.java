package br.com.sgce.repository;

import br.com.sgce.entity.Disciplina;
import br.com.sgce.filter.DisciplinaFilter;
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

public class DisciplinaRepository implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private EntityManager manager;

    public Disciplina guardar(Disciplina disciplina) {

        return manager.merge(disciplina);

    }

    public Disciplina porDescricao(String descricao) {
        try {
            return manager.createQuery("from Disciplina where upper(descricao) = :descricao", Disciplina.class)
                    .setParameter("descricao", descricao.toUpperCase())
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Disciplina> filtrados(DisciplinaFilter filtro) {

        Session session = manager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Disciplina.class);

        criteria.add(Restrictions.eq(null, filtro));

        if (StringUtils.isNotBlank(filtro.getDescricao())) {
            criteria.add(Restrictions.ilike("descricao", filtro.getDescricao(), MatchMode.ANYWHERE));

        }

        return criteria.addOrder(Order.asc("descricao")).list();

    }

    public List<Disciplina> buscarDisciplina() {
        return manager.createQuery("from Disciplina", Disciplina.class).getResultList();

    }

    public Disciplina porId(Long id) {
        return manager.find(Disciplina.class, id);
    }

    
}
