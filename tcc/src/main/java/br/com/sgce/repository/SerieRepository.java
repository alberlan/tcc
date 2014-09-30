
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

//Camada de persistencia no banco de dados
public class SerieRepository implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Inject
    private EntityManager manager;   
    
       
    // guarda no banco de dados
    public Serie guardar(Serie serie) {        
        return manager.merge(serie);

    }

    //busca uma serie pela descriçao no banco de dados
    //utilizando Jpql nessa consulta, aqui é feita aconsulta por Entidade que fiz mapeamento
    public Serie porDescricao(String descricao) {
        try {
            return manager.createQuery("from Serie where upper(descricao) = :descricao", Serie.class)
                    .setParameter("descricao", descricao.toUpperCase())
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    //Carrega lista com todas as series, é utilizada na tela de cadastro de alunos
    public List<Serie> buscarSerie(){        
        return manager.createQuery("from Serie" , Serie.class).getResultList();
        
    }  

    //busca serie por id no banco de dados
    public Serie porId(Long id) {
        return manager.find(Serie.class, id);
    }

    public Serie getAlunosBySerie(Serie serie) {
        Session session = manager.unwrap(Session.class); //Pedindo pro manager desempacotar a session do hibernate, e joga na variavel session.
        Criteria criteria = session.createCriteria(Aluno.class); //criando um criterio para entidade Aluno.
         criteria.add(Restrictions.eq("Serie", serie.getId()));
         Aluno aluno = (Aluno) criteria.uniqueResult();
         return aluno.getSerie(); 
           
                       
    }
    
}
