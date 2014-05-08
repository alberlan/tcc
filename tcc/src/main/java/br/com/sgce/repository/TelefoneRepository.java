
package br.com.sgce.repository;

import br.com.sgce.entity.Telefone;
import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.EntityManager;


public class TelefoneRepository implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Inject
    private EntityManager manager;

    public Telefone guardar(Telefone telefone) {

        return manager.merge(telefone);

    }
    
}
