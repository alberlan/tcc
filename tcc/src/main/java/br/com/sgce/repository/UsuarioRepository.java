package br.com.sgce.repository;

import br.com.sgce.entity.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

public class UsuarioRepository implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private EntityManager manager;

    public Usuario guardar(Usuario usuario) {

        return manager.merge(usuario);
    }

    public List<Usuario> buscarUsuario() {
        return manager.createQuery("from Usuario", Usuario.class).getResultList();
    }

    public Usuario porId(Long id) {
        return manager.find(Usuario.class, id);
    }

    public Usuario porLogin(String login) {
        Usuario usuario = null;

        try {
            usuario = this.manager.createQuery("from Usuario where lower (login) =: login", Usuario.class)
                    .setParameter("login", login.toLowerCase()).getSingleResult();

        } catch (Exception e) {
            //Nenhum usuario encontrado com esse login
            
        }

        return usuario;
    }
}
