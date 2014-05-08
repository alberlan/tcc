
package br.com.sgce.controller;

import br.com.sgce.entity.Disciplina;
import br.com.sgce.filter.DisciplinaFilter;
import br.com.sgce.repository.DisciplinaRepository;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class PesquisaDisciplinaBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private DisciplinaRepository disciplinaRepository;
    private DisciplinaFilter filtro;
    private List<Disciplina> disciplinasfiltradas;

    public PesquisaDisciplinaBean() {        
        filtro = new DisciplinaFilter();
    }
    
    public void pesquisar() {
        disciplinasfiltradas = disciplinaRepository.filtrados(filtro);

    }

    public List<Disciplina> getDisciplinasfiltradas() {
        return disciplinasfiltradas;
    }    

    public DisciplinaFilter getFiltro() {
        return filtro;
    }
    
}
