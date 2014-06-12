
package br.com.sgce.controller;

import br.com.sgce.entity.Aluno;
import br.com.sgce.entity.Nota;
import br.com.sgce.entity.Serie;
import br.com.sgce.filter.AlunoFilter;
import br.com.sgce.repository.AlunoRepository;
import br.com.sgce.repository.SerieRepository;
import br.com.sgce.service.NotaService;
import br.com.sgce.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@ViewScoped
public class NotaBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private SerieRepository serieRepository;
    @Inject
    private AlunoRepository alunoRepository;
    private AlunoFilter filtro;
    private List<Aluno> alunosFiltrados;
    private NotaService notaService;
    private Nota nota;
    private List<Serie> listaSeries;
    
    

    public NotaBean() {
        nota = new Nota();
        filtro = new AlunoFilter();   
    }

    public void salvar() {
        this.nota = notaService.salvar(this.nota);
        FacesUtil.addInfoMessage("Nota Salva com Sucesso!");
        
    }
    
    public void pesquisar() {
        alunosFiltrados = alunoRepository.filtrados(filtro);

    }

    public void inicializarSerie() {
        //Evitar consultas desnecessárias apartir da segunda vez é postback
        if (FacesUtil.isNotPostback()) {
            listaSeries = serieRepository.buscarSerie();
        }
    }

    public Nota getNota() {
        return nota;
    }
    
    public AlunoFilter getFiltro() {
        return filtro;
    }

    public List<Aluno> getAlunosFiltrados() {
        return alunosFiltrados;
    }

    public List<Serie> getListaSeries() {
        return listaSeries;
    }
    
}
