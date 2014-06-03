
package br.com.sgce.controller;

import br.com.sgce.entity.Funcionario;
import br.com.sgce.filter.FuncionarioFilter;
import br.com.sgce.repository.FuncionarioRepository;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class PesquisaFuncionarioBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Inject
    private FuncionarioRepository funcionarioRepository;
    private FuncionarioFilter filtro;
    private List<Funcionario> funcionariosFiltrados;

    public PesquisaFuncionarioBean() {
        filtro = new FuncionarioFilter();
    }
    
    //Botao pesquisar
    public void pesquisar() {
        funcionariosFiltrados = funcionarioRepository.filtrados(filtro);

    }

    public FuncionarioFilter getFiltro() {
        return filtro;
    }

    public List<Funcionario> getFuncionariosFiltrados() {
        return funcionariosFiltrados;
    }

        
}
