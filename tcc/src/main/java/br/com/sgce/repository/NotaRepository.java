
package br.com.sgce.repository;

import br.com.sgce.entity.Nota;
import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.EntityManager;


public class NotaRepository implements Serializable{
     private static final long serialVersionUID = 1L;
     
     @Inject
    private EntityManager manager;

    public Nota guardar(Nota nota) {

        return manager.merge(nota);

    }

            
}
