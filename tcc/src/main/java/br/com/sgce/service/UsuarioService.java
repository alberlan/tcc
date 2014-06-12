
package br.com.sgce.service;

import br.com.sgce.entity.Usuario;
import br.com.sgce.repository.UsuarioRepository;
import br.com.sgce.util.jpa.Transactional;
import java.io.Serializable;
import javax.inject.Inject;

public class UsuarioService implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private UsuarioRepository usuarioRepository;
    
   @Transactional
    public Usuario salvar(Usuario usuario){   
        
        
        return usuarioRepository.guardar(usuario);
        
    }   
    
}
