package br.com.sgce.controller;

import br.com.sgce.entity.Disciplina;
import br.com.sgce.service.DisciplinaService;
import br.com.sgce.util.jsf.FacesUtil;
import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class DisciplinaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
   private DisciplinaService disciplinaService;
    private Disciplina disciplina;

    public DisciplinaBean() {
        limpar();
    }
    
    public void limpar(){
        disciplina = new Disciplina();
    }
    
    public void salvar() {
        this.disciplina = disciplinaService.salvar(this.disciplina);
        FacesUtil.addInfoMessage("Disciplina Salva com Sucesso!");
        limpar();
    }

    //public CadastroDisciplinaService getCadastroDisciplinaService() {
      //  return cadastroDisciplinaService;
    //}

    public Disciplina getDisciplina() {
        return disciplina;
    }
        
    
}
