
package br.com.sgce.repository;

import br.com.sgce.entity.Bimestre;
import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.EntityManager;


public class BimestreRepository implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Inject
    private EntityManager manager;

    public Bimestre guardar(Bimestre bimestre) {

        return manager.merge(bimestre);
    }  
    
}
