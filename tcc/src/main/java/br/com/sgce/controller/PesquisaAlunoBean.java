package br.com.sgce.controller;

import br.com.sgce.entity.Aluno;
import br.com.sgce.entity.Serie;
import br.com.sgce.entity.StatusAluno;
import br.com.sgce.filter.AlunoFilter;
import br.com.sgce.repository.AlunoRepository;
import br.com.sgce.repository.SerieRepository;
import br.com.sgce.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class PesquisaAlunoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private SerieRepository serieRepository;
    @Inject
    private AlunoRepository alunoRepository;
    private AlunoFilter filtro;
    private List<Aluno> alunosFiltrados;
    private List<Serie> listaSeries;

    public PesquisaAlunoBean() {
        filtro = new AlunoFilter();
        alunosFiltrados = new ArrayList<>();
    }

    //Botao pesquisar
    public void pesquisar() {
        alunosFiltrados = alunoRepository.filtrados(filtro);

    }

    public void inicializarSerie() {
        //Evitar consultas desnecessárias apartir da segunda vez é postback
        if (FacesUtil.isNotPostback()) {
            listaSeries = serieRepository.buscarSerie();
        }
    }
    
/*    public StatusAluno[] getStatusAlu(){
        return StatusAluno.values();
    }
*/
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
