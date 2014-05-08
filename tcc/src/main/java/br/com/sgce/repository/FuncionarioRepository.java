
package br.com.sgce.repository;

import br.com.sgce.entity.Funcionario;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;


public class FuncionarioRepository implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Inject
    private EntityManager manager;
    
    public Funcionario guardar(Funcionario funcionario) {

        return manager.merge(funcionario);

    }

    public Funcionario porNome(String nome) {
        try {
            return manager.createQuery("from Funcionario where upper(nome) = :nome", Funcionario.class)
                    .setParameter("nome", nome.toUpperCase())
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Funcionario> buscarFuncionario() {
        return manager.createQuery("from Funcionario", Funcionario.class).getResultList();

    }
    
}
