
package br.com.sgce.repository;

import br.com.sgce.entity.Aluno;
import br.com.sgce.entity.Disciplina;
import br.com.sgce.entity.Serie;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


public class SerieRepository implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Inject
    private EntityManager manager;    

    public Serie guardar(Serie serie) {        
        return manager.merge(serie);

    }

    public Serie porDescricao(String descricao) {
        try {
            return manager.createQuery("from Serie where upper(descricao) = :descricao", Serie.class)
                    .setParameter("descricao", descricao.toUpperCase())
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public List<Serie> buscarSerie(){        
        return manager.createQuery("from Serie" , Serie.class).getResultList();
        
    }  

    public Serie porId(Long id) {
        return manager.find(Serie.class, id);
    }

    public Serie getAlunosBySerie(Serie serie) {
        Session session = manager.unwrap(Session.class); //Pedindo pro manager desempacotar a session do hibernate, e joga na variavel session.
        Criteria criteria = session.createCriteria(Aluno.class); //criando um criterio para entidade Aluno.
         criteria.add(Restrictions.eq("Serie", serie.getId()));
         Aluno aluno = (Aluno) criteria.uniqueResult();
         return aluno.getSerie(); 
            //    .createAlias("Serie", "t"); //criando um criterio para entidade Serie.
                       
    }
    
}
