package br.com.sgce.entity;

public enum StatusAluno {

    ATIVO("Ativo"),
    INATIVO("Inativo"),;
    private String descricao;

    private StatusAluno(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
