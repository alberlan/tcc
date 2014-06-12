package br.com.sgce.filter;

import br.com.sgce.entity.StatusAluno;
import java.io.Serializable;

public class AlunoFilter implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nome;
    private String turno;
    private String serie;
    private StatusAluno[] statusaluno;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public StatusAluno[] getStatusaluno() {
        return statusaluno;
    }

    public void setStatusaluno(StatusAluno[] statusaluno) {
        this.statusaluno = statusaluno;
    }
}
