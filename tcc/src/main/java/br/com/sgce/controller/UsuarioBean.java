package br.com.sgce.controller;

import br.com.sgce.entity.Usuario;
import br.com.sgce.entity.Funcionario;
import br.com.sgce.entity.TipoFuncionario;
import br.com.sgce.repository.FuncionarioRepository;
import br.com.sgce.service.UsuarioService;
import br.com.sgce.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class UsuarioBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private FuncionarioRepository funcionarioRepository;
    @Inject
    private UsuarioService usuarioService;
    private Usuario usuario;
    private List<Funcionario> listaFuncionarios;

    public UsuarioBean() {
        limpar();
    }

    public void limpar() {
        usuario = new Usuario();
    }

    public void salvar() {
        this.usuario = usuarioService.salvar(this.usuario);
        FacesUtil.addInfoMessage("Senha Salva com Sucesso!");
        limpar();
    }

    public void inicializarFuncionario() {
        //Evitar consultas desnecessárias apartir da segunda vez é postback
        if (FacesUtil.isNotPostback()) {
            listaFuncionarios = funcionarioRepository.buscarFuncionario();
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public List<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }
         
}
