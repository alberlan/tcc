
package br.com.sgce.service;

import br.com.sgce.entity.Estado;
import br.com.sgce.repository.EstadoRepository;
import br.com.sgce.util.jpa.Transactional;
import java.io.Serializable;
import javax.inject.Inject;


public class EstadoService implements Serializable{
    
     private static final long serialVersionUID = 1L;
    
    @Inject
    private EstadoRepository estadoRepository;
    
   @Transactional
    public Estado salvar(Estado estado){
        
        
        
        return estadoRepository.guardar(estado);
        
    }   
    
}
