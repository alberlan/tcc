package br.com.sgce.controller;

import br.com.sgce.entity.Disciplina;
import br.com.sgce.entity.Serie;
import br.com.sgce.repository.DisciplinaRepository;
import br.com.sgce.service.SerieService;
import br.com.sgce.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class SerieBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private DisciplinaRepository disciplinaRepository;
    @Inject
    private SerieService serieService;
    private Serie serie;
    private List<Disciplina> disciplinaAlunos;  

    public SerieBean() {
        limpar();
    }

    public void limpar() {
        serie = new Serie();
    }

    public void inicializarDisciplina() {
        if (FacesUtil.isNotPostback()) {
            disciplinaAlunos = disciplinaRepository.buscarDisciplina();
        }
    }

    public void salvar() {        
        this.serie = serieService.salvar(this.serie);
        FacesUtil.addInfoMessage("Série Salva com Sucesso!");
        limpar();
    }

    public Serie getSerie() {
        return serie;
    }

    public List<Disciplina> getDisciplinaAlunos() {
        return disciplinaAlunos;
    }
}
