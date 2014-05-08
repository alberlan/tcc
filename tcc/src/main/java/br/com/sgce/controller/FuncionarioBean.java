package br.com.sgce.controller;

import br.com.sgce.entity.Funcionario;
import br.com.sgce.entity.TipoFuncionario;
import br.com.sgce.service.FuncionarioService;
import br.com.sgce.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class FuncionarioBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private FuncionarioService funcionarioService;
    private Funcionario funcionario;

    public FuncionarioBean() {
        limpar();
    }

    public void limpar() {
        funcionario = new Funcionario();
    }

    public void salvar() {
        this.funcionario = funcionarioService.salvar(this.funcionario);
        FacesUtil.addInfoMessage("Aluno Salvo com Sucesso!");
        limpar();
    }

    public TipoFuncionario[] getTiposFuncionario() {
        return TipoFuncionario.values();
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
}
