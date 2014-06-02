package br.com.sgce.controller;

import br.com.sgce.entity.Cidade;
import br.com.sgce.entity.Estado;
import br.com.sgce.entity.Funcionario;
import br.com.sgce.entity.TipoFuncionario;
import br.com.sgce.repository.CidadeRepository;
import br.com.sgce.repository.EstadoRepository;
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
    private CidadeRepository cidadeReoRepository;
    @Inject
    private EstadoRepository estadoRepository;
    @Inject
    private FuncionarioService funcionarioService;
    private Funcionario funcionario;
    private List<Cidade> listaCidades;
    private List<Estado> listaEstados;

    public FuncionarioBean() {
        limpar();
    }

    public void limpar() {
        funcionario = new Funcionario();
    }

    public void salvar() {
        this.funcionario = funcionarioService.salvar(this.funcionario);
        FacesUtil.addInfoMessage("Funcionario Salvo com Sucesso!");
        limpar();
    }

    public void inicializarEstado() {
        if (FacesUtil.isNotPostback()) {
            listaEstados = estadoRepository.buscarEstado();
        }
    }

    public void inicializarCidade() {
        if (FacesUtil.isNotPostback()) {
        listaCidades = cidadeReoRepository.buscarCidade();
    }
    }

    public List<Cidade> getListaCidades() {
        return listaCidades;
    }

    public List<Estado> getListaEstados() {
        return listaEstados;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
    
    public TipoFuncionario[] getTiposFuncionario(){
        return TipoFuncionario.values();
    }
   
}
