
package br.com.sgce.service;

import br.com.sgce.entity.Cidade;
import br.com.sgce.repository.CidadeRepository;
import br.com.sgce.util.jpa.Transactional;
import java.io.Serializable;
import javax.inject.Inject;


public class CidadeService implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private CidadeRepository cidadeRepository;
    
   @Transactional
    public Cidade salvar(Cidade cidade){
        
        
        
        return cidadeRepository.guardar(cidade);
        
    }   
    
}
