
package br.com.sgce.repository;

import br.com.sgce.entity.Turma;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;


public class TurmaRepository implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Inject
    private EntityManager manager;

    public Turma guardar(Turma turma) {

        return manager.merge(turma);

    }

    public Turma porDescricao(String descricao) {
        try {
            return manager.createQuery("from Turma where upper(descricao) = :descricao", Turma.class)
                    .setParameter("descricao", descricao.toUpperCase())
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public List<Turma> buscarTurma(){        
        return manager.createQuery("from Turma" , Turma.class).getResultList();
        
    }  
    
}
