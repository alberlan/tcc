package br.com.sgce.controller;

import br.com.sgce.entity.Aluno;
import br.com.sgce.entity.Endereco;
import br.com.sgce.entity.Telefone;
import br.com.sgce.service.AlunoService;
import br.com.sgce.service.EnderecoService;
import br.com.sgce.service.TelefoneService;
import br.com.sgce.util.jsf.FacesUtil;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class AlunoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    
    @Inject    
    private TelefoneService telefoneService;
    private Telefone telefone;
    @Inject    
    private EnderecoService enderecoService;
    private Endereco endereco;
    @Inject
    private AlunoService alunoService;
    private Aluno aluno;

    public AlunoBean() {        
                
        limpar();
    }

    public void limpar() {
        aluno = new Aluno();
        
    }

    public void salvar() {          
        this.aluno = alunoService.salvar(this.endereco, this.telefone, this.aluno);
       
        FacesUtil.addInfoMessage("Aluno Salvo com Sucesso!");
        limpar();
    }

    public Aluno getAluno() {
        return aluno;
            
    }

    public Endereco getEndereco() {
        return endereco;
    }
    
}
